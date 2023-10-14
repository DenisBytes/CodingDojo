import './App.css'
import { Header } from './Components/Header'
import { Main } from './Components/Main'
import { Navigation } from './Components/Navigation'
import { SubContent } from './Components/SubContent'
import { Advert } from './Components/Advertisement'
function App() {

  return (
    <>
      <Header/>
      <div style={{display: 'flex'}}>
        <Navigation/>
        <Main>
          <SubContent/>
          <SubContent/>
          <SubContent/>
          <Advert/>
        </Main>
      </div>
    </>
  )
}

export default App
