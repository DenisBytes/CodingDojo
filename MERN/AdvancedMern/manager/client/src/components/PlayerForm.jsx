import { useState } from "react";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export const PlayerForm = (props) => {

    const {onSubmitProp, initialName, initialPosition} = props
    const [name, setName] = useState(initialName);
    const [position, setPosition] = useState(initialPosition);

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmitProp({name, position});
        setName("");
        setPosition("");
    }

    return (
        <form onSubmit={handleSubmit} style={{display: 'flex', flexDirection: 'column'}}>
            <TextField id="outlined-basic" label="Name" variant="outlined" value={name} onChange={(e) => setName(e.target.value)}></TextField>
            <TextField id="outlined-basic" label="Position" variant="outlined" value={position} onChange={(e) => setPosition(e.target.value)}></TextField>
            <Button variant="contained" type="submit">Submit</Button>
        </form>
    )

}