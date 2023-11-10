import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from "react-router-dom";
import { PersonForm } from './PersonForm';
import { DeleteButton } from './DeleteButton';

export const Update = (props) => {
  const { id } = useParams();
  const [person, setPerson] = useState({});
  const [loaded, setLoaded] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get(`http://localhost:8000/api/people/${id}`)
      .then(res => {
        console.log(res.data);
        setPerson(res.data);
        setLoaded(true);
      })
      .catch(err => console.log(err));
  }, []);

  const updatePerson = (personParam) => {
    axios.put(`http://localhost:8000/api/people/${id}`, personParam)
      .then(res => {
        console.log(res);
      })
      .catch(err => console.log(err));
  }

  return (
    <div>
      <h1>Update Person</h1>
      {loaded && (
        <>
          <PersonForm onSubmitProp={updatePerson} initialFirstName={person.firstName} initialLastName={person.lastName} />
          <DeleteButton personId={person._id} successCallback={() => navigate("/")} />
        </>
      )
  }
    </div>
  );
}