const mongoose = require('mongoose');
const JokeSchema = new mongoose.Schema({
    setup: { type: String, required: true, minLength: 10 },
    punchline: { type: String, required: true, minLength: 3 }
});

const Joke = mongoose.model('Joke', JokeSchema);
module.exports = Joke;