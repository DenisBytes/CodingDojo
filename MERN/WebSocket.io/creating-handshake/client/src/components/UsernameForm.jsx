import React, { useState } from "react";

export const UsernameForm = ({ setUsername }) => {
    const [usernameInput, setUsernameInput] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        setUsername(usernameInput);
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Enter your username"
                value={usernameInput}
                onChange={(e) => setUsernameInput(e.target.value)}
            />
            <button type="submit">Submit</button>
        </form>
    );
};

