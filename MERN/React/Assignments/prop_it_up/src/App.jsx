import './App.css'
import PersonCard from './components/PersonCard'

function App() {
  return (
    <>
      <PersonCard firstName="Bill" lastName="Swag" age={27} hairColor="Black"></PersonCard>
      <PersonCard firstName="Mart" lastName="Nope" age={27} hairColor="Black"></PersonCard>
      <PersonCard firstName="Bert" lastName="Smith" age={27} hairColor="Black"></PersonCard>
    </>
  )
}

export default App
