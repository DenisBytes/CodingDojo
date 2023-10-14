import { useState } from 'react';
import './App.css'
import { BoxContainerForm } from './Components/Box';
import { BoxDisplay } from './Components/BoxDisplay';


function App() {
  const [boxArray, setBoxArray] = useState([]);

  return(
    <>
      <BoxContainerForm boxArray = {boxArray} setBoxArray = {setBoxArray}></BoxContainerForm>
      <BoxDisplay boxArray = {boxArray}></BoxDisplay>
    </>
  );
}

export default App