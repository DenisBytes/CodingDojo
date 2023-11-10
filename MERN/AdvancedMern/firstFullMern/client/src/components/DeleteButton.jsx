import axios from "axios";
import React from 'react';

export const DeleteButton = (props) => {
    const {peronId, successCallback} = props;
    const deletePerson = (e) => {
        axios.delete(`http://localhost:8000/api/people/${peronId}`)
        .then((response) => {
            successCallback();
        })
        .catch((error) => {
            console.log(error);
        });
    } 

    return (
        <button onClick={deletePerson}>Delete</button>
    )
}