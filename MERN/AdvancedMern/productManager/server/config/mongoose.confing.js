const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/product-manager', { useNewUrlParser: true, useUnifiedTopology: true })
.then(() => console.log('MongoDB Connected'))
.catch(err=> console.log("Something went wrong: ",err))