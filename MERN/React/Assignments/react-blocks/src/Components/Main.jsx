import React from "react";

export const Main = (props) =>{
    const styles = {
        width: "80%",
        height: "500px",
        backgroundColor: "red",
        margin: "5% 0%",
        marginLeft: "2%",
        padding: "3%",
    };

    return (
    <span style={styles}>
        {props.children}
    </span>
    );
}