import { useEffect, useState } from "react";

export const TaskForm = (props) =>{

    const {TaskArray, setTaskArray} = props;

    const [getTask, setTask] = useState("");

    const handleSubmit = (e)=>{
        e.preventDefault();
        setTaskArray((prevTaskArray) => {
            const updatedTaskArray = [...prevTaskArray,  { text: getTask, checked: false, id: Date.now().toString() }];
            localStorage.setItem("tasks", JSON.stringify(updatedTaskArray));
            return updatedTaskArray;
        });
        setTask("")
    }

    const buttonStyles= {
        padding: "2%",
        color: "white",
        backgroundColor: "blue",
    }
    
    useEffect(()=>{
        console.log("Modified from task form");
        localStorage.setItem("tasks", JSON.stringify(TaskArray));
    },[TaskArray]);
    

    useEffect(() => {
        console.log("Page reload from Task Form")
        const tasks = JSON.parse(localStorage.getItem("tasks"));
        if (tasks) {
            setTaskArray(TaskArray);
        }
    }, []);

    return (
        <form onSubmit={handleSubmit}>
            <input onChange={(e)=>setTask(e.target.value)} value={getTask} placeholder="Enter Task"></input>
            <button type="submit" style={buttonStyles}>Submit</button>
        </form>
    );

}