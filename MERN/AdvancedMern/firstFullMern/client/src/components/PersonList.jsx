import axios from "axios";
import React, { useState, useEffect } from "react";
import{Link} from "react-router-dom";
import { DeleteButton } from "./DeleteButton";

export const PersonList = (props) => {
    const [usePeople, setPeople] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8000/api/people").then((response) => {
            setPeople(response.data);
        })
        .catch((err) => {
            console.log(err);
        });
    }, []);

    const removeFromDom = (personId) => {
        setPeople(usePeople.filter((person) => person._id !== personId));
    }


    return (
        <div>
            {
                usePeople.map((person, index)=>{
                    return(
                        <div key={index}>
                            <p key={index}>
                                <Link to={`/people/${person._id}`}>{person.firstName} {person.lastName}</Link> | 
                                <Link to={`/people/update/${person._id}`}> Update Details</Link> |
                                <DeleteButton personId={person._id} successCallback={()=>{removeFromDom(person._id)}} />
                            </p>
                        </div>
                    )
                })
            }
        </div>
    );

}