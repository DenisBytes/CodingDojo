const mongoose = require('mongoose');

const playerSchema = new mongoose.Schema({
    name: {type: String, required: true},
    position: {type: String, required: true},
    firstMatch: {type: String, enum: ["playing", "notPlaying", "undecided"], default: "undecided"},
    secondMatch: {type: String, enum: ["playing", "notPlaying", "undecided"], default: "undecided"},
    thirdMatch: {type: String, enum: ["playing", "notPlaying", "undecided"], default: "undecided"},
}, {timestamps: true});

module.exports = mongoose.model('Player', playerSchema)