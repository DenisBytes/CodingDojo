import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { PlayerForm } from '../components/PlayerForm';
import { NavigationBar } from '../components/NavigationBar';
import { Paper } from '@mui/material';


export const AddPlayer = (props) => {
    
    const [players, setPlayers] = useState([]);

    const onSubmitProp = (newPlayer) => {
        axios.post('http://localhost:8000/api/players', newPlayer)
            .then(res => {
                setPlayers([...players, res.data]);
                console.log(res.data);
            })
            .catch(err => console.log(err))
    }

    return (
        <Paper elevation={3}>
            <NavigationBar emphasizedLink="players" />
            <div>
                <div style={{display: 'flex', justifyContent: 'center', fontSize: '20px'}}>
                    <Link to="/players/list">List</Link>
                    <Link  to="/players/addplayer"><em>Add Player</em></Link>
                </div>
                <div>
                    <h1>Add Player</h1>
                    <PlayerForm onSubmitProp={onSubmitProp} initialName="" initialPosition="" />
                </div>
            </div>
        </Paper>
    )
}