import React, { useEffect, useState } from 'react';
import { NavigationBar } from './NavigationBar';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

export const GamesList = () => {
    const { id } = useParams();
    console.log(id);
    
    const [players, setPlayers] = useState([]);

    useEffect(() => {
        axios
            .get(`http://localhost:8000/api/players`)
            .then((res) => {
                setPlayers(res.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []);

    const handleStatusChange = (playerId, status) => {
        const matchNumber = id; // Use the id value from useParams directly
        const matchString = matchNumber === '1' ? 'firstMatch' : matchNumber === '2' ? 'secondMatch' : 'thirdMatch';
        console.log("matchString: " + matchString);
        const newPlayersList = players.map((player) => {
            if (player._id === playerId) {
                player[matchString] = status;
            }
            return player;
        });
    
        axios
            .patch(`http://localhost:8000/api/players/${playerId}`, { [matchString]: status })
            .then((res) => {
                console.log(res.data);
                console.log(newPlayersList);
                setPlayers(newPlayersList);
            })
            .catch((err) => {
                console.log(err);
            });
    };


    return (
        <div>
            <NavigationBar emphasizedLink="games" />
            <div>
                <Link  to={`/status/games/1`}>Game 1</Link>
                <Link to={`/status/games/2`}>Game 2</Link>
                <Link to={`/status/games/3`}>Game 3</Link>
            </div>

            <div>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            players.map((player, i) => (
                                <tr key={i}>
                                    <td>{player.name}</td>
                                    <td>
                                        <button id='playing-button'
                                            style={{ backgroundColor: player[id === '1' ? "firstMatch" : id === '2' ? "secondMatch" : "thirdMatch"] === 'playing' ? 'green' : 'white' }}
                                            onClick={() => handleStatusChange(player._id, 'playing')}
                                        >
                                            Playing
                                        </button>
                                        <button id='not-playing-button'
                                            style={{ backgroundColor: player[id === "1" ? "firstMatch" : id === "2" ? "secondMatch" : "thirdMatch"] === 'notPlaying' ? 'red' : 'white' }}
                                            onClick={() => handleStatusChange(player._id, 'notPlaying')}
                                        >
                                            Not Playing
                                        </button>
                                        <button id='undecided-button'
                                            style={{ backgroundColor: player[id === "1" ? "firstMatch" : id === "2" ? "secondMatch" : "thirdMatch"] === 'undecided' ? 'yellow' : 'white' }}
                                            onClick={() => handleStatusChange(player._id,'undecided')}
                                        >   
                                            Undecided
                                        </button>
                                        <ul>
                                            
                                        </ul>
                                    </td>
                                </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
