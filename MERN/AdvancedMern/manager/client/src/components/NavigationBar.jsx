import React from 'react'
import { Link } from 'react-router-dom';

export const NavigationBar = ({ emphasizedLink }) => {
    return (
        <div style={{ display: 'flex', justifyContent: 'center', fontSize: '20px', borderBottom: '1px solid black', padding: '10px' }}>
            <Link to="/players/list">{emphasizedLink === 'players' ? <em>Manage Players </em> : 'Manage Players '}</Link> !
            <Link to="/status/games/1">{emphasizedLink === 'games' ? <em>Manage Players Status</em> : 'Manage Players Status'}</Link>
        </div>
    );
};
