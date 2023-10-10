import React, { useState } from "react";

export const UserForm = (props) => {

    const [firstName, setFirstName] = useState();
    const [firstNameError, setFirstNameError] = useState("");
    const [lastName, setLastName] = useState();
    const [lastNameError, setLastNameError] = useState("");
    const [email, setEmail] = useState();
    const [emaiLError, setEmailError] = useState("");
    const [password, setPassword] = useState();
    const [passwordError, setPasswordError] = useState("");
    const [confirm, setConfirm] = useState();
    const [confirmError, setConfirmError] = useState("");


    const firstNameHandler = (e) => {
        setFirstName(e.target.value);
        if (e.target.value.length < 2 && e.target.value.length > 0){
            setFirstNameError("First name must be more than 2 characters")
        }
        else{
            setFirstNameError("");
        }
    }

    const lastNameHandler = (e) => {
        setLastName(e.target.value);
        if (e.target.value.length < 2 && e.target.value.length > 0){
            setLastNameError("Last name must be more than 2 characters")
        }
        else{
            setLastNameError("");
        }
    }

    const emailHandler = (e) => {
        setEmail(e.target.value);
        if (e.target.value.length < 5 && e.target.value.length > 0){
            setEmailError("Email must be more than 5 characters")
        }
        else{
            setEmailError("");
        }
    }

    const passwordHandler = (e) => {
        setPassword(e.target.value);
        if (e.target.value.length < 8 && e.target.value.length > 0){
            setPasswordError("Password must be more than 8haracters")
        }
        else{
            setPasswordError("");
        }
    }

    const confirmHandler = (e) => {
        setConfirm(e.target.value);
        if (e.target.value !== password && e.target.value.length > 0 ){
            setConfirmError("Confrim must match password")
        }
        else{
            setConfirmError("");
        }
    }

    

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
            <input type="text" value={firstName} onChange={ firstNameHandler }></input>

            {
            firstNameError ? <p className="text-danger">{firstNameError}</p>:<p></p>
            }

            <label>Last Name: </label>
            <input type="text" value={lastName} onChange={ lastNameHandler}></input>

            {
            lastNameError ? <p className="text-danger">{lastNameError}</p>:<p></p>
            }

            <label>Email: </label>
            <input type="text" value={email} onChange={ emailHandler }></input>

            {
            emaiLError ? <p className="text-danger">{emaiLError}</p>:<p></p>
            }

            <label>Password: </label>
            <input type="text" value={password} onChange={ passwordHandler }></input>

            {
            passwordError ? <p className="text-danger">{passwordError}</p>:<p></p>
            }

            <label>Confirm: </label>
            <input type="text" value={confirm} onChange={ confirmHandler }></input>

            {
            confirmError ? <p className="text-danger">{confirmError}</p>:<p></p>
            }
            
            <h2>Your Data Form</h2>
            <p>{firstName}</p>
            <p>{lastName}</p>
            <p>{email}</p>
            <p>{password}</p>
            <p>{confirm}</p>
        </form>
    );
}