const fs = require('fs');
const path = require('path');
const { MongoClient } = require('mongodb');
const csv = require('csv-parser');

const animalDataCSV = path.join(__dirname, 'data/aac_shelter_outcomes.csv');
const mongoURL = 'mongodb://localhost:27017';
const myDatabase = 'AAC';
const myCollection = 'animals';

// Seeds database with csv data if no data already exists in the above collection
async function seedDatabase() {
    // Establish connection with mongodb
    const client = new MongoClient(mongoURL, {});
    await client.connect();
    const db = client.db(myDatabase);
    const collection = db.collection(myCollection);

    // Read data from the CSV
    const records = [];
    fs.createReadStream(animalDataCSV)
        .pipe(csv())
        .on('data', (row) => {
            records.push(row);
        })
        .on('end', async () => {
            console.log('Attempting to seed database');
            try {
                const existingData = await collection.find({}).toArray();
                if (existingData.length === 0) {
                    await collection.insertMany(records);
                    console.log('Data has been seeded for the \'' 
                                + myCollection + '\' collection in the \''
                                + myDatabase + '\' database.');
                } else {
                    console.log('Aborted. \'' + myCollection + '\' collection already contains data.');
                }
            } catch (err) {
                console.error('Error inserting data:', err);
            } finally {
                await client.close();
            }
        });
}

module.exports = seedDatabase;