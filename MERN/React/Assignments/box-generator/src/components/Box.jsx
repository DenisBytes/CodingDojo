import React, { useState } from "react";


export const BoxContainerForm = (props) => {

    const {boxArray, setBoxArray, } = props;

    const [color, setColor] = useState("");
    const [size, setSize] = useState(200);

    const handleSubmit = (e) => {
        e.preventDefault();
        setBoxArray([...boxArray, {
            color : color,
            size : size + "px"
        }]);    
        setColor("");
        setSize(200)
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <h1>Set Color</h1>
                <input placeholder="Enter color here" onChange={ (e)=> setColor(e.target.value) } value={color}></input>
                <h1>Set Size</h1>
                <input placeholder="Enetr num here" type="int" onChange={ (e) => setSize(e.target.value)} value={size}></input>
                <button type="submit" style={{
                    backgroundColor: "blue", color: "white"
                }} >Submit</button>
            </form>
        </div>
    );

}