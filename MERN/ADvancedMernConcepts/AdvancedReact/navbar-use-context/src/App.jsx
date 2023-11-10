import { useState } from 'react'
import './App.css'
import { Wrapper } from './components/Wrapper'
import { NavBar } from './components/NavBAr'
import { FormWrapper } from './components/FormWrapper'

function App() {
  const [name, setName] = useState("");

  return (
    <>
      <Wrapper.Provider value={{name, setName}}>
        <NavBar></NavBar>
        <FormWrapper></FormWrapper>
      </Wrapper.Provider>
    </>
  )
}

export default App
