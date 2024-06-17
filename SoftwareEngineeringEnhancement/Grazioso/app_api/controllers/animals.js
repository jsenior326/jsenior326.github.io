const { MongoClient } = require('mongodb');

const mongoURL = 'mongodb://localhost:27017';
const myDatabase = 'AAC';
const myCollection = 'animals';

// Returns full list of animals
const animalsList = async (req, res) => {
    let client;
    try{
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);
        
        // Execute query and return result
        const data = await collection.find({}).toArray();

        return res.status(200).json(data);
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
    
};

// Returns a single animal
const getAnimalById = async (req, res) => {
    let client;
    try{
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);
        
        // Execute query and return result
        const data = await collection.findOne({animal_id: req.params.animal_id});
        
        return res.status(200).json(data);
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
};

// Returns animals filtered by Water rescues
const waterRescues = async (req, res) => {
    let client;
    try {
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);

        // Regular expression to represent allowed breeds
        const breeds = new RegExp('Labrador Retriever|Chesa Bay Retr|Newfoundland', 'i');
        // Execute query which filters animals by water rescue candidates
        const data = await collection.find(
                                    {'animal_type' : 'Dog',
                                    'breed' : { '$regex':breeds },
                                    'sex_upon_outcome' : 'Intact Female',
                                    '$expr': {
                                        '$and': [
                                          { '$gte': [{ '$toDouble': "$age_upon_outcome_in_weeks" }, 26.0] },
                                          { '$lte': [{ '$toDouble': "$age_upon_outcome_in_weeks" }, 156.0] }
                                        ]
                                      }
                                    }).toArray();
        return res.status(200).json(data);
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
};

// Returns animals filtered by Mountain or Wilderness rescues
const mountainWildernessRescues = async (req, res) => {
    let client;
    try {
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);

        // Regular expression to represent allowed breeds
        const breeds = new RegExp('German Shepherd|Alaskan Malamute|Old English Sheepdog|Siberian Husky|Rottweiler', 'i');
        // Execute query which filters animals by mountain and wilderness rescue candidates
        const data = await collection.find(
                                    {'animal_type' : 'Dog',
                                    'breed' : { '$regex':breeds },
                                    'sex_upon_outcome' : 'Intact Male',
                                    '$expr': {
                                        '$and': [
                                          { '$gte': [{ '$toDouble': "$age_upon_outcome_in_weeks" }, 26.0] },
                                          { '$lte': [{ '$toDouble': "$age_upon_outcome_in_weeks" }, 156.0] }
                                        ]
                                      }
                                    }).toArray();
        return res.status(200).json(data);
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
};

// Returns animals filtered by Disaster or Individual Tracking
const disasterIndividualRescues = async (req, res) => {
    let client;
    try {
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);

        // Regular expression to represent allowed breeds
        const breeds = new RegExp('Doberman Pinscher|German Shepherd|Golden Retriever|Bloodhound|Rottweiler', 'i');
        // Execute query which filters animals by disaster and individual tracking rescue candidates
        const data = await collection.find(
                                    {'animal_type' : 'Dog',
                                    'breed' : { '$regex':breeds },
                                    'sex_upon_outcome' : 'Intact Male',
                                    '$expr': {
                                        '$and': [
                                          { '$gte': [{ '$toDouble': "$age_upon_outcome_in_weeks" }, 20.0] },
                                          { '$lte': [{ '$toDouble': "$age_upon_outcome_in_weeks" }, 300.0] }
                                        ]
                                      }
                                    }).toArray();
        return res.status(200).json(data);
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
};

// Updates a single animal
const updateAnimal = async (req, res) => {
    let client;
    try {
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);

        const result = await collection.updateOne(
            { animal_id: req.params.animal_id },
            { $set: req.body }
        );
        
        if (result.matchedCount === 0) {
            return res.status(404).send({message: 'Animal not found with id ' + req.params.animal_id});
        }

        return res.status(200).json({message: 'Animal updated'});
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
};

// Deletes a single animal
const deleteAnimal = async (req, res) => {
    let client;
    try {
        // Connect to database
        const client = new MongoClient(mongoURL, {});
        await client.connect();
        const db = client.db(myDatabase);
        const collection = db.collection(myCollection);

        const result = await collection.deleteOne(
            { animal_id: req.params.animal_id },
        );
        
        if (result.matchedCount === 0) {
            return res.status(404).send({message: 'Animal not found with id ' + req.params.animal_id});
        }

        return res.status(200).json({message: 'Animal deleted'});
    } catch (err){
        return res.status(500).send(err);
    } finally {
        if (client) {
            client.close();
        }
    }
}

module.exports = {
    animalsList,
    getAnimalById,
    waterRescues,
    mountainWildernessRescues,
    disasterIndividualRescues,
    updateAnimal,
    deleteAnimal
};