import { useState, useEffect } from "react";
import {io} from "socket.io-client";

export const Chat = ({username})=>{
    const [socket] = useState(()=>io(":8000"));

    const [messages, setMessages] = useState([]);
    const [message, setMessage] = useState("");

    useEffect(() => {
        console.log('Is this running?');
        socket.on("new message", data => {
            setMessages(prevMessages => [...prevMessages, data]);
        });
    
        return () => {
            socket.off("new message");
        };
    }, [socket]);
    

    const handleSendMessage = (e) => {
        e.preventDefault();
        if (message) {
            // Emit a "send message" event to the server
            socket.emit("send message", { username, message });
        
            // Clear the message input field
            setMessage("");
        }
    };
    
    return (
        <div>
            <div>
                {messages.map((msg, index) => (
                <div key={index}>
                    <strong>{msg.username}:</strong> {msg.message}
                </div>
                ))}
            </div>
            <form onSubmit={handleSendMessage}>
                <input
                    type="text"
                    placeholder="Type your message..."
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                />
                <button type="submit">Send</button>
            </form>
        </div>
    );
};