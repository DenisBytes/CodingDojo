const PlayerSchema = require('../models/player.model');

module.exports.createPlayer = (req, res) => {
    PlayerSchema.create(req.body)
        .then(player => res.json(player))
        .catch(err => res.status(400).json(err))
}

module.exports.getAllPlayers = (req, res) => {
    PlayerSchema.find()
        .then(players => res.json(players))
        .catch(err => res.status(400).json(err))
}

module.exports.getPlayer = (req, res) => {
    PlayerSchema.findById(req.params.id)
        .then(player => res.json(player))
        .catch(err => res.status(400).json(err))
}

module.exports.updatePlayer = (req, res) => {
    PlayerSchema.findOneAndUpdate({_id: req.params.id}, req.body, {new: true})
        .then(player => res.json(player))
        .catch(err => res.status(400).json(err))
}

module.exports.deletePlayer = (req, res) => {
    PlayerSchema.deleteOne({_id: req.params.id})
        .then(player => res.json(player))
        .catch(err => res.status(400).json(err))
}

