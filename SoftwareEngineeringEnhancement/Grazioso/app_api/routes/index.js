const express = require('express');
const router = express.Router();

// Import controller for animals routing
const { animalsList, waterRescues, disasterIndividualRescues, mountainWildernessRescues } = require('../controllers/animals');

// define routes for animals endpoints
router.get('/animals', animalsList); // GET method routes animalList

router.get('/waterRescue', waterRescues); // GET method returns filtered water rescues

router.get('/mountainWildernessRescue', mountainWildernessRescues); // GET method returns filtered mountain/wilderness rescues

router.get('/disasterIndividualRescue', disasterIndividualRescues); // GET method returns disaster/individual rescues

module.exports = router;