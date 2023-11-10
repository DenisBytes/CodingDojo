const mongoose = require ('mongoose');
const USerSchema = mongoose.Schema({
    name: { type: String, required: true },
    age: { type: Number, required: true },
    email: { type: String, required: false },
    password: { type: String, required: false },
    date: { type: Date, default: Date.now }
})

const User = mongoose.model('User', USerSchema);

module.exports = User;