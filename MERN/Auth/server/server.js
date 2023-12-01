const express = require("express");
const app = express();
const cors = require("cors");
const cookieParser = require('cookie-parser');
const port = 8000;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cookieParser());
app.use(cors({credentials: true, origin: 'http://localhost:5173'}));

require('./routes/user.routes')(app);
require('./config/user.config');



app.listen(port, () => {console.log(`Listening on port: ${port}`);})