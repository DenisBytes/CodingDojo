import { React, useState } from 'react'
import './App.css'
import { TabDisplay } from './Components/TabDisplay';
import { Tab } from './Components/Tab';

function App() {
  const [showText, setText] = useState("");

  return (
    <>
      <Tab message={setText}></Tab>
      <TabDisplay showMessage={showText}></TabDisplay>
    </>
  )
}

export default App
