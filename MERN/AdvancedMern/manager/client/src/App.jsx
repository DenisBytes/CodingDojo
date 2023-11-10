import { GamesList } from "./components/GamesList"
import { PlayerList } from "./components/PlayerList"
import { AddPlayer } from "./view/AddPLayer"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import "./App.css"

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/players/list" element={<PlayerList />} />
        <Route path="/players/addplayer" element={<AddPlayer />} />
        <Route path="/status/games/:id" element={<GamesList />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
