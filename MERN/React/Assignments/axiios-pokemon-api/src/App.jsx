import { useState, useEffect } from 'react'
import './App.css'
import axios from "axios"

function App() {
  const [usePokemonList, setPokemonList] = useState([]);

  useEffect( () =>{
    axios.get("https://pokeapi.co/api/v2/pokemon")
    .then( response => setPokemonList(response.data.results))
    .catch( err => console.log(err))
  }, []);

  return (
    <div>
      <ul>
      {
        usePokemonList.map( (poke, index) => <li key={index}>{poke.name}</li> )
      }
      </ul>
    </div>
  )
}

export default App
