import { useContext } from "react"
import { Wrapper } from "./Wrapper"

export const NavBar = (props)=>{

    const {name} = useContext(Wrapper);
    return(
        <div style={{backgroundColor: "blue"}}>
            <h1>Hello {name}!</h1>
        </div>
    )
}
