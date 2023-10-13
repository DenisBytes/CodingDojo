import React from "react";

export const BoxDisplay = (props) =>{

    const {boxArray} = props;

    return (
        <div>
            {
                boxArray.map((box, index)=>(
                    <div style={{
                        display: "inline-block",
                        margin: "10px",
                        height: box.size, 
                        width: box.size,
                        backgroundColor: box.color}}>
                    </div>
                ))
            }
        </div>
    );

}