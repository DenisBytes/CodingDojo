  import './App.css'
  import {Chat} from './components/Chat'; 
  import { UsernameForm } from './components/UsernameForm';
  import { useState } from 'react';
  function App() {
    const [username, setUsername] = useState("");

  return (
    <div>
      {!username ? (
        <UsernameForm setUsername={setUsername} />
      ) : (
        <Chat username={username} />
      )}
    </div>
  );
  }

  export default App
