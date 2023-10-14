import React, { useEffect } from "react";

export const TaskDisplay = (props) =>{

    const { showTask, setShowTask } = props; 

    const stylesButton = {
        padding: "2%",
        color: "white", 
        backgroundColor: "black"
    }

    const deleteTask = (index) => {
        const tempArray = showTask.filter((item,i) => i!==index);
        setShowTask(tempArray);
        localStorage.setItem("tasks", JSON.stringify(showTask));
        console.log(showTask)
    }

    const handleCheck = (e) =>{
        showTask[e.target.id].checked = !showTask[e.target.id].checked;
        setShowTask([...showTask]);
        localStorage.setItem("tasks", JSON.stringify(showTask));
        console.log(showTask)
    }

    useEffect(() => {
        const tasks = JSON.parse(localStorage.getItem("tasks"));
        if (tasks) {
            setShowTask(tasks);
        }

        console.log("Here: ", tasks);
    }, []);

    return (
        <div>
            {
                showTask.length > 0 ? (
                    showTask.map((task, index) => (
                        <div key={index} style={{display: "flex", width: "100px", padding: "5%"}}>
                            <p style={{ textDecoration: task.checked ? 'line-through' : 'none' }}>{task.text}</p>
                            <input type="checkbox" id={index} className="form-check-input" onClick={handleCheck} />
                            <button style={stylesButton} onClick={(event) => deleteTask(index)}>Delete</button>
                        </div>
                    ))
                ) : (
                    <p>No tasks to display.</p>
                )
            }
        </div>
    );
}