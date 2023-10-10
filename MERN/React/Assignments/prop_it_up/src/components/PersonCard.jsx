import React, { useState } from "react";

export const PersonCard = (props) =>{

    const {firstName, lastName, age, hairColor} = props;

    const [getState, setState] = useState(age);

    const increaseAge = () => setState(getState + 1);

    return (
        <div>
            <h1>{lastName}, {firstName}</h1>
            <p>Age: {getState}</p>
            <p>Hair Color: {hairColor}</p>
            <button onClick={increaseAge}>Increase Age</button>
        </div>
    );
}
