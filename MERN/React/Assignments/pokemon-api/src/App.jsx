import React,{ useEffect, useState } from 'react'
import './App.css'

function App() {
  const [usePoke, setPoke] = useState([]);

    useEffect(()=>{
        fetch('https://pokeapi.co/api/v2/pokemon')
        .then( resolve => resolve.json())
        .then( resolve => setPoke(resolve.results))
        .catch( err => console.log(err));
    }, [])

    return (
      <div>
        <form onSubmit={handleSubmit}>
          <input></input>
          <button type='submit'>Submit</button>
        </form>

        <ul>
        {
          usePoke.map( (pokemon, index) => (<li key={index}>{pokemon.name}</li>))
        }
        </ul>
      </div>
    );
}

export default App
