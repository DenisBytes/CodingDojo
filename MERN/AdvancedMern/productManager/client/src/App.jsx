import React, { useState } from 'react'
import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { Combined } from './view/Combined'
import { Details } from './components/Details'
import { Update } from './components/Update'
function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/home' element={<Combined />} />
          <Route path='/products/:id' element={<Details />} />
          <Route path='/products/:id/edit' element={<Update />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App