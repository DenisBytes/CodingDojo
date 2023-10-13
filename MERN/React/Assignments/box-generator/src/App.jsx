import { useState } from 'react';
import './App.css'
import { BoxContainerForm } from './components/box';
import { BoxDisplay } from './components/BoxDisplay';


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