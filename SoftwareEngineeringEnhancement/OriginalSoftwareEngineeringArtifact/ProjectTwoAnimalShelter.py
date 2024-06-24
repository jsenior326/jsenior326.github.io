from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """ CRUD operations for Animal collection in MongoDB """

    def __init__(self, username, password, host, port, db, col):
        # Initializing the MongoClient. This helps to 
        # access the MongoDB databases and collections.
        # This is hard-wired to use the aac database, the 
        # animals collection, and the aac user.
        # Definitions of the connection string variables are
        # unique to the individual Apporto environment.
        #
        # You must edit the connection variables below to reflect
        # your own instance of MongoDB!
        #
        # Connection Variables
        #
        USER = username
        PASS = password
        HOST = host
        PORT = port
        DB = db
        COL = col
        #
        # Initialize Connection
        #
        self.client = MongoClient('mongodb://%s:%s@%s:%d' % (USER,PASS,HOST,PORT))
        self.database = self.client['%s' % (DB)]
        self.collection = self.database['%s' % (COL)]

# Complete this create method to implement the C in CRUD.
    def create(self, data):
        if data is not None:
            result = self.database.animals.insert_one(data)  # data should be dictionary
            return result.acknowledged  # acknowledged will return false if the insert failed
        else:
            raise Exception("Nothing to save, because data parameter is empty")

# Create method to implement the R in CRUD.
    def read(self, data):
        if data is not None:
            result = []
            try:
                result = list(self.collection.find(data))  # store cursor returned as a list
            except TypeError:
                print("Gave an invalid argument type.")
            finally:
                return result
        else:
            raise Exception("Nothing to read, because data parameter is empty")
            
# Method to implement the U in CRUD.
    def update(self, find, data):
        if data is not None:
            numUpdate = 0
            try:
                result = self.database.animals.update_many(find, data)  # store result of the update
                numUpdated = result.matched_count  # get number of successfully updated documents
            except Exception:
                print("Gave an invalid argument type.")
            finally:
                return numUpdated
        else:
            raise Exception("Nothing to update, because data parameter is empty")

# Method to implement the D in CRUD.
    def delete(self, data):
        if data is not None:
            numDelete = 0
            try:
                result = self.database.animals.delete_many(data)  # store result of the delete
                numDelete = result.deleted_count  # get numer of successfully deleted documents
            except Exception:
                print("Gave an invalid argument type.")
            finally:
                return numDelete
        else:
            raise Exception("Nothing to delete, because data parameter is empty")