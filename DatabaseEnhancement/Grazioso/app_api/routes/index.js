const express = require('express');
const router = express.Router();
const { expressjwt: expressJwt } = require('express-jwt');
const auth = expressJwt({
        secret: process.env.JWT_SECRET,
        userProperty: 'payload',
        algorithms: ["HS256"]
});

// Import controller for authentication
const authController = require('../controllers/authentication');
// Import controller for animals routing
const animalController = require('../controllers/animals');

// define routes for authentication
router.route('/login').post(authController.login);

router.route('/register').post(authController.register);

// define routes for animals endpoints
router.get('/animals', animalController.animalsList); // GET method routes animalList

router.route('/animals/:animal_id')
        .get(animalController.getAnimalById) // GET method returns single animal
        .put(auth, animalController.updateAnimal) // PUT method updates single animal
        .delete(auth, animalController.deleteAnimal) // DELETE method deletes single animal

router.get('/waterRescue', animalController.waterRescues); // GET method returns filtered water rescues

router.get('/mountainWildernessRescue', animalController.mountainWildernessRescues); // GET method returns filtered mountain/wilderness rescues

router.get('/disasterIndividualRescue', animalController.disasterIndividualRescues); // GET method returns disaster/individual rescues

module.exports = router;