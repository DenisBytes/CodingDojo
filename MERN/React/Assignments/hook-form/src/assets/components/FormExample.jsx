import React, { useState } from "react";

export const UserForm = (props) => {
    const [getUsername, setUsername] = useState("");
    const [getEmail, setEmail] = useState("");
    const [getPassword, setPassword] = useState("");

    const createUser = (e) => {
        e.preventDefault();

        const newUser = {
            username : getUsername,
            email : getEmail,
            password : getPassword
        }
        console.log("Welcome", newUser);
        setUsername("");
        setEmail("");
        setPassword("");
    }

    return (
        <form onSubmit={createUser}>
            <div>
                <label>Username: </label>
                <input type="text" onChange={(event) => {setUsername(event.target.value)}} value={getUsername}></input>
            </div>

            <div>
                <label>Email: </label>
                <input type="email" onChange={(event) => {setEmail(event.target.value)}} value={getEmail}></input>
            </div>

            <div>
                <label>Password: </label>
                <input type="password" onChange={(event) => {setPassword(event.target.value)}} value={getPassword}></input>
            </div>

            <input type="submit" value="Create User" />
        </form>
    )
}
