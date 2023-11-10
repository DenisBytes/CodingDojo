import { useContext } from "react"
import { Wrapper } from "./Wrapper";

export const Form = (props)=>{
    const {name, setName} = useContext(Wrapper);


    return (
        <div>
            <form>
                <p>
                    <label>Your Name:</label>
                    <input onChange={(e)=> setName(e.target.value)} value={name}></input>
                </p>
            </form>
        </div>
    )
}