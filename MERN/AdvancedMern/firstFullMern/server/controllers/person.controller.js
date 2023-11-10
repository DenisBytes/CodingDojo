const Person = require("../models/person.model");

module.exports.createPerson = (req, res) => {
    Person.create(req.body)
        .then(person => {
            console.log(person); 
            res.json(person)
        })
        .catch(err => {
            console.log(err);
            res.status(400).json(err)
        });
}


module.exports.getAllPeople = (req, res) => {
    Person.find({})
        .then(persons =>{
            console.log(persons); 
            res.json(persons)
        })
        .catch(err => {
            console.log(err);
            res.status(400).json(err)
        });
}

module.exports.getOnePerson = (req, res) => {
    Person.findOne({_id: req.params.id})
        .then(person =>{
            console.log(person); 
            res.json(person)
        })
        .catch(err => {
            console.log(err);
            res.status(400).json(err)
        });
}

module.exports.index = (req, res) => {
    res.json({
        message: "Hello World!"
    });
}

module.exports.updatePerson = (req, res) => {
    Person.findOneAndUpdate({_id: req.params.id}, req.body, {new: true})
        .then(person =>{
            console.log(person); 
            res.json(person)
        })
        .catch(err => {
            console.log(err);
            res.status(400).json(err)
        });
}

module.exports.deletePerson = (req, res) => {
    Person.deleteOne({_id: req.params.id})
        .then(person =>{
            console.log(person); 
            res.json(person)
        })
        .catch(err => {
            console.log(err);
            res.status(400).json(err)
        });
}