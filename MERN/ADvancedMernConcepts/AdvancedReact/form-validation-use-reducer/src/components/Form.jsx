import { useReducer } from "react"


const initialState = {
    firstName: {
        value: "",
        error: null
    },
    lastName: {
        value: "",
        error: null
    },
    email: {
        value: "",
        error: null
    }
}

const reducer = (state, action) =>{
    switch (action.type){
        case "SET_FIRSTNAME_VALUE":
            return {
                ...state,
                firstName: {
                    ...state.firstName,
                    value: action.payload
                }
            }
        case "SET_FIRSTNAME_ERROR":
            return {
                ...state,
                firstName: {
                    ...state.firstName,
                    error: action.payload
                }
            }
        case "SET_LASTNAME_VALUE":
            return {
                ...state,
                lastName: {
                    ...state.lastName,
                    value: action.payload
                }
            }
        case "SET_LASTNAME_ERROR":
            return {
                ...state,
                lastName: {
                    ...state.lastName,
                    error: action.payload
                }
            }
        case "SET_EMAIL_VALUE":
            return {
                ...state,
                email: {
                    ...state.email,
                    value: action.payload
                }
            }
        case "SET_EMAIL_ERROR":
            return {
                ...state,
                email: {
                    ...state.email,
                    error: action.payload
                }
            }
        default:
            return state
    }
}


export const Form = (props) =>{
    const [state, dispatch] = useReducer(reducer, initialState);

    const handleFirstName = (e)=>{
        if (e.target.value.length < 5){
            dispatch({
                type: "SET_FIRSTNAME_ERROR",
                payload: "First Name must be at least 5 characters"
            })
        }
        else{
            dispatch({
                type: "SET_FIRSTNAME_ERROR",
                payload: null
            })
        }

        dispatch({
            type: "SET_FIRSTNAME_VALUE",
            payload: e.target.value
        })
    }

    const handleLastName = (e)=>{
        if (e.target.value.length < 5){
            dispatch({
                type: "SET_LASTNAME_ERROR",
                payload: "Last Name must be at least 5 characters"
            })
        }
        else{
            dispatch({
                type: "SET_LASTNAME_ERROR",
                payload: null
            })
        }

        dispatch({
            type: "SET_LASTNAME_VALUE",
            payload: e.target.value
        })
    }

    const handleEmail = (e)=>{
        const mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

        if (!e.target.value.match(mailformat)){
            dispatch({
                type: "SET_EMAIL_ERROR",
                payload: "Not an email"
            })
        }
        else{
            dispatch({
                type: "SET_EMAIL_ERROR",
                payload: null
            })
        }

        dispatch({
            type: "SET_EMAIL_VALUE",
            payload: e.target.value
        })
    }

    return (
        <div>
            <h1>{JSON.stringify(state)}</h1> {/* display current value of state */}
            <form>
                <p>
                    <label>First Name:</label>
                    {state.firstName.error !== null && (
                        <p className="error">{state.firstName.error}</p>
                    )}
                    <input value={state.firstName.value} onChange={(e)=>handleFirstName(e)}></input>
                </p>
                <p>
                    <label>Last Name:</label>
                    {state.lastName.error!==null&&(
                        <p className="error">{state.lastName.error}</p>
                    )}
                    <input value={state.lastName.value} onChange={(e)=>handleLastName(e)}></input>
                </p>
                <p>
                    <label>Email:</label>
                    {state.email.error!==null &&(
                        <p className="error">{state.email.error}</p>
                    )}
                    <input value={state.email.value} onChange={(e)=>handleEmail(e)}></input>
                </p>
                <button value="Submit" type="submit"></button>
            </form>
        </div>
    )
}