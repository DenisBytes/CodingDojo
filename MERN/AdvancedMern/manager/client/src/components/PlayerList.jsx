import { NavigationBar } from "./NavigationBar";
import { Link } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";

export const PlayerList = (props) => {
    const [players, setPlayers] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios
            .get("http://localhost:8000/api/players")
            .then((res) => {
                setPlayers(res.data);
                setLoaded(true);
            })
            .catch((err) => {
                console.log(err);
            });
    }, []); // Added an empty dependency array to run the effect only once

    const deleteAction = (id) => {
        const confirmDelete = window.confirm("Are you sure you want to delete this player?");

        if (confirmDelete) {
            const newPlayers = players.filter((player) => player._id !== id);
            setPlayers(newPlayers);
            axios
                .delete(`http://localhost:8000/api/players/${id}`)
                .then((res) => {
                    console.log(res.data);
                })
                .catch((err) => {
                    console.log(err);
                });
        }
    };

    return (
        <div>
            <NavigationBar emphasizedLink="players"></NavigationBar>
            <div style={{ display: 'flex', justifyContent: 'center', fontSize: '20px' }}>
                <Link to="/players/list"><em>List</em></Link>
                <Link to="/players/addplayer">Add Player</Link>
            </div>
            <div>
                {
                    loaded && (
                        <table>
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                {players.map((player) => (
                                    <tr key={player._id}>
                                        <td><Link to={`/players/${player._id}`}>{player.name}</Link></td>
                                        <td>{player.position}</td>
                                        <td>
                                            <button onClick={() => deleteAction(player._id)}>
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    )
                }
            </div>
        </div>
    );
};
