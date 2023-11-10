import './App.css'
import React from 'react'
import {Combined} from './view/Combined'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import {Details} from './components/Details'
import { Update } from './components/Update'
function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/people" element={<Combined />}/>
          <Route path="/people/:id" element={<Details />} />
          <Route path="/people/update/:id" element={<Update />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
