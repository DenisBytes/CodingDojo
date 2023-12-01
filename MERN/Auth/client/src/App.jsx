import {BrowserRouter, Route, Routes } from "react-router-dom"
import './App.css'
import { UserAuthComponent } from "./components/UserAuthComponent"
import { UserListComponent } from "./components/UserListComponent"

function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/home" element={<UserAuthComponent></UserAuthComponent>}></Route>
          <Route path="/users" element={<UserListComponent></UserListComponent>}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
  }

export default App
