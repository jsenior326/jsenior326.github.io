const passport = require('passport');
const mongoose = require('mongoose');
const User = require('../models/user');
const Model = mongoose.model('users');

const register = async(req, res) => {
    if (!req.body.name || !req.body.email || !req.body.password) {
        return res
        .status(400)
        .json({"message": "All fields required"});
    }

    const user = new Model();
    user.name = req.body.name;
    user.email = req.body.email;
    user.setPassword(req.body.password);

    try {
        
        const existingUser = await Model.findOne({email: req.body.email})

        if (!existingUser){
            const q = await user.save();

                if (!q) 
                {
                    return res
                        .status(400)
                        .json(err);
                } else {
                    const token = user.generateJwt();
                    return res
                        .status(200)
                        .json({token});
                }

        } else {
            return res
            .status(404)
            .json({message: "User already exists"});
        }
    } catch (err) {
        console.error('Error finding uesr:', err);
    }
};

const login = async(req, res) => {
    if (!req.body.email || !req.body.password) {
        return res
        .status(400)
        .json({"message": "All fields required"});
    }

    passport.authenticate('local', (err, user, info) => {
        if (err) {
            return res
            .status(404)
            .json(err);
        }
        if (user) {
            const token = user.generateJwt();
            return res
                .status(200)
                .json({token});
        } else {
            return res
                .status(401)
                .json(info);
        }
    })(req, res);
};

module.exports = {
    register,
    login
};