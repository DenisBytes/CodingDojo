import React, { useState } from "react";

export const UserForm = (props) => {

    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [confirm, setConfirm] = useState();

    const showUser = (e) =>{
        e.preventDefault();

        const newUSer = {firstName, lastName, email, password, confirm};

        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setConfirm("");

    }

    return (
        <form onSubmit={showUser}>
            <label>First Name: </label>
            <input type="text" value={firstName} onChange={ (event) => setFirstName(event.target.value)}></input>

            <label>Last Name: </label>
            <input type="text" value={lastName} onChange={ (event) => setLastName(event.target.value)}></input>

            <label>Email: </label>
            <input type="text" value={email} onChange={ (event) => setEmail(event.target.value)}></input>

            <label>Password: </label>
            <input type="text" value={password} onChange={ (event) => setPassword(event.target.value)}></input>

            <label>Confirm: </label>
            <input type="text" value={confirm} onChange={ (event) => setConfirm(event.target.value)}></input>
            
            <h2>Your Data Form</h2>
            <p>{firstName}</p>
            <p>{lastName}</p>
            <p>{email}</p>
            <p>{password}</p>
            <p>{confirm}</p>
        </form>
    );
}