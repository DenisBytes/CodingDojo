import React, { useState } from "react";

export const PersonForm = (props) => {
    const {initialFirstName, initialLastName, onSubmitProp} = props;
    const [firstName, setFirstName] = useState(initialFirstName);
    const [lastName, setLastName] = useState(initialLastName);

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmitProp({firstName, lastName});
        setFirstName("");
        setLastName("");
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <p>
                    <label>First Name: </label>
                    <input type="text" name="firstName" onChange={(e) => setFirstName(e.target.value)} />
                </p>
                <p>
                    <label>Last Name: </label>
                    <input type="text" name="lastName" onChange={(e) => setLastName(e.target.value)} />
                </p>
                <input type="submit"/>
            </form>
        </div>
    )
}