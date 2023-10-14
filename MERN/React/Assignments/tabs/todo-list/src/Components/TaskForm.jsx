import React, { useEffect, useState } from "react";

export const TaskForm = (props) =>{

    const {TaskArray, setTaskArray} = props;

    const [getTask, setTask] = useState("");

    const handleSubmit = (e)=>{
        e.preventDefault();
        setTaskArray([...TaskArray, {text: getTask, checked: false, id : Date.now().toString}]);
        localStorage.setItem("tasks", JSON.stringify(TaskArray));
        console.log(TaskArray);
        setTask("")
    }

    const buttonStyles= {
        padding: "2%",
        color: "white",
        backgroundColor: "blue",
    }
    
    useEffect(() => {
        const tasks = JSON.parse(localStorage.getItem("tasks"));
        if (tasks) {
            setTaskArray(TaskArray);
        }
        console.log("Here: ", tasks);
    }, []);

    return (
        <form onSubmit={handleSubmit}>
            <input onChange={(e)=>setTask(e.target.value)} value={getTask} placeholder="Enter Task"></input>
            <button type="submit" style={buttonStyles}>Submit</button>
        </form>
    );

}