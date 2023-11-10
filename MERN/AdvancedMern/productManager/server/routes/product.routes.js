const ProductController = require('../controllers/product.controller') // Import ProductController

module.exports = (app) => {
    app.get('/api/products', ProductController.getAllProducts)
    app.post('/api/products', ProductController.createProduct)
    app.get('/api/products/:id', ProductController.getProduct)
    app.patch('/api/products/:id', ProductController.updateProduct)
    app.delete('/api/products/:id', ProductController.deleteProduct)
}