const Product = require('../models/product.model');

module.exports.getAllProducts = (req, res) => {
    Product.find()
        .then((products) => {
            res.json(products);
        })
        .catch((err) => {
            res.json(err);
        });
}

module.exports.createProduct = (req, res) => {
    Product.create(req.body)
        .then((product) => {
            res.json(product);
        })
        .catch((err) => {
            res.json(err);
        });
}

module.exports.getProduct = (req, res) => {
    Product.findById(req.params.id)
        .then((product) => {
            res.json(product);
        })
        .catch((err) => {
            res.json(err);
        });
}

module.exports.updateProduct = (req, res) => {
    Product.findByIdAndUpdate(req.params.id, req.body, { new: true })
        .then((product) => {
            res.json(product);
        })
        .catch((err) => {
            res.json(err);
        });
}

module.exports.deleteProduct = (req, res) => {
    Product.findByIdAndDelete(req.params.id)
        .then((product) => {
            res.json(product);
        })
        .catch((err) => {
            res.json(err);
        });
}