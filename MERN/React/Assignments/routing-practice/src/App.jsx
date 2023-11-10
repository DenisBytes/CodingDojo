import { useState } from 'react'
import './App.css'
import { BrowserRouter, Routes, Route, Link, useParams, useNavigate } from "react-router-dom";

const Home = (props) => {

  const [number, setNumber] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
  }
  const navigate = useNavigate();

  return (
    <div>
      <h1>Hello WOrld!</h1>
      <form onSubmit={handleSubmit}>
        <label>Enter word</label>
        <input type='text' onChange={ (e)=>setNumber(e.target.value)}></input>
        {
          isNaN(number) ? <Link to={`/${number}`}>Going to word: {number}</Link> : <Link to={`/${number}`}>Going to number:  {number}</Link>
        }
      </form>
      <Link onClick={(e)=>{e.preventDefault(); navigate(1)}}>Go forward</Link>
    </div>
  )
}


const WordComponent = (props) => {
  const {word} = useParams();
  const navigate = useNavigate();
  const [baskGround, setBaskGround] = useState("");
  const [color, setColor] = useState("");
  const [secondWord, setSecondWord] = useState("");

  return (
    <div>
      {
        isNaN(word) ? <h1>Word : {word}</h1> : <h1>Numebr : {word}</h1>
      }
      <Link onClick={(e)=>{e.preventDefault(); navigate(-1)}}>Go back</Link>
      <form>
        <label>Enter word</label>
        <input type='text' onChange={ (e)=>setSecondWord(e.target.value)}></input>
        <label>Enter background color</label>
        <input type='text' onChange={ (e)=>setBaskGround(e.target.value)}></input>
        <label>Enter text color</label>
        <input type='text' onChange={ (e)=>setColor(e.target.value)}></input>
        {
          isNaN(secondWord&&baskGround&&color) ? <Link to={`/${secondWord}/${baskGround}/${color}`}>Going to /{secondWord}/{baskGround}/{word}</Link> : <p>Not a word</p>
        }
      </form>
    </div>
  )
}

const ColoredText = (props) => {
  const {word, background ,color} = useParams();

  return (
    <div style={{backgroundColor: background, color: color}}>
      <h1>{word}</h1>
    </div>
  )
}


function App() {

  return (
   <div>
    <BrowserRouter>
      <Routes>
        <Route element={<Home />} path="/home"/>
        <Route element={<WordComponent />} path="/:word"/>
        <Route element={<ColoredText />} path="/:word/:background/:color"/>
      </Routes>
    </BrowserRouter>
   </div>
  )
}

export default App
