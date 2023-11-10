import React, { useState, useEffect } from "react";
import {PersonForm} from "../components/PersonForm";
import {PersonList} from "../components/PersonList";
import axios from "axios";


export const Combined = (props) => {

    const [personList, setPersonList] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:8000/api/people")
        .then((response) => {
            console.log(response.data);
            setPersonList(response.data)
        })
        .catch((err) => {
            console.log(err);
        })
    }, []);

    const removeFromDom = (personId) => {
        axios.get("http://localhost:8000/api/people/" + personId)
        .then((response) => {
            console.log(response);
            setPersonList(personList.filter((person) => person._id !== personId));
        })
        .catch((err) => {
            console.log(err);
        })
    }

    const createPerson = (person) => {
        axios.post("http://localhost:8000/api/people", person)
        .then((response) => {
            console.log(response);
            setPersonList([...personList, response.data]);
        })
        .catch((err) => {
            console.log(err);
        })
    }
    return (
        <div>
            <PersonForm onSubmitProp={createPerson} initialFirstName={""} initialLastName={""} />
            <hr></hr>
            <PersonList personList={personList} removeFromDom={removeFromDom} />
        </div>
    )
}