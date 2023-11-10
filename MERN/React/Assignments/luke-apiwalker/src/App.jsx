import './App.css'
import { SearchForm } from './components/SearchForm'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Display } from './components/Display';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<SearchForm />}></Route>
          <Route path="/:word/:id" element={<Display />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
