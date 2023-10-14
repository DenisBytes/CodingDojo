import React, { useState } from "react";
import './App.css'
import { TaskForm } from './Components/TaskForm';
import { TaskDisplay } from './Components/TaskDisplay';

function App() {
  const [getTaskArray, setTaskArray] = useState([]);

  return (
    <>
      <TaskForm TaskArray={getTaskArray} setTaskArray={setTaskArray}></TaskForm>
      <TaskDisplay showTask = {getTaskArray} setShowTask={setTaskArray}></TaskDisplay>
    </>
  )
}

export default App
