import './App.css'
import {PersonCard} from './components/PersonCard'

function App() {
  return (
    <>
      <PersonCard firstName="Bill" lastName="Swag"  hairColor="Black"></PersonCard>
      <PersonCard firstName="Mart" lastName="Nope"  hairColor="Black"></PersonCard>
      <PersonCard firstName="Bert" lastName="Smith"  hairColor="Black"></PersonCard>
    </>
  )
}

export default App
