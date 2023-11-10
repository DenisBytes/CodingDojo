import React, { useEffect, useState } from 'react'
import axios from 'axios';
import {useParams} from "react-router-dom";

export const Details = (props) => {
    const { id } = useParams();
    const [person, setPerson] = useState({});

    useEffect(() => {
        axios.get("http://localhost:8000/api/people/" + id)
            .then((response) => {
                console.log(response);
                setPerson(response.data);
            })
            .catch((err) => {
                console.log(err);
            })
    }, []);

    return (
        <div>
            <h3>{person.firstName} {person.lastName}</h3>
        </div>
    )
}