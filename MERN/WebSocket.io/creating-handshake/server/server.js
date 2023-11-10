const express = require("express");
const app = express();
const cors = require ("cors");
const socket = require ("socket.io");
const port = 8000;


app.use(cors);
const server = app.listen(port, ()=>console.log(`Listening on port: ${port}`));

const io = socket(server, {
    cors: {
        origin: "http://localhost:5173",
        methods: ["GET", "POST"],
        allowedHeaders: ["*"],
        Credentials: true
    }
});

io.on("connection", socket=>{
    console.log("socker id: "+ socket.id);
    console.log("Nice to meet you. (shake hand)")
    socket.on("send message", (data)=>{
        io.emit("new message",data)
    })
})