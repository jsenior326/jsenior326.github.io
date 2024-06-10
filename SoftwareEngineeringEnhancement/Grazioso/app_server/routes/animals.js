var express = require('express');
var router = express.Router();
const controller = require('../controllers/animals.js');

// Get animals
router.get('/', controller.animals);

module.exports = router;