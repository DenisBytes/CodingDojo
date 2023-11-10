const User = require('../models/user.model');

module.exports.findAllUsers = (req, res) => {
    User.find()
        .then((allDataUsers) => {
            res.json(allDataUsers);
        })
        .catch((err) => {
            res.json({mesagge: "Something went wrong", error: err});
        })
}

module.exports.findOneSingleUser = (req, res) => {
    User.findOne({_id: req.params.id})
        .then((oneSingleUser) => {
            res.json({user: oneSingleUser});
        })
        .catch((err) => {
            res.json({mesagge: "Something went wrong", error: err});
        })
}

module.exports.createNewUser = (req, res) => {
    User.create(req.body)
        .then((newlyCreatedUser) => {
            res.json({user: newlyCreatedUser});
        })
        .catch((err) => {
            res.json({mesagge: "Something went wrong", error: err});
        })
}

module.exports.updateExistingUser = (req, res) => {
    User.findOneAndUpdate(
            {_id: req.params.id},
            req.body,
            {new: true, runValidators: true}
        )
        .then((updatedUser) => {
            res.json({user: updatedUser});
        })
        .catch((err) => {
            res.json({mesagge: "Something went wrong", error: err});
        })
}

module.exports.deleteAnExistingUser = (req, res) => {
    User.deleteOne({_id: req.params.id})
        .then((deletedUser) => {
            res.json({user: deletedUser});
        })
        .catch((err) => {
            res.json({mesagge: "Something went wrong", error: err});
        })
}