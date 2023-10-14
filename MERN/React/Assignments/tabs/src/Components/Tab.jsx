import React from "react";

export const Tab = (props) => {

    const content = ["Hello", "Hedera", "World"];

    const handleClick = (e) =>{
        e.preventDefault();
        props.message(content[e.target.id])
    }

    return (
        <div>
            <button id="0" onClick={handleClick}>Tab 1</button>
            <button id="1" onClick={handleClick}>Tab 2</button>
            <button id="2" onClick={handleClick}>Tab 3</button>
        </div>
    );
}
