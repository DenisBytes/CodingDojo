import { useState } from "react";
import { useNavigate } from "react-router-dom";

export const SearchForm = (props) => {

    const [useWord,setWord] = useState("people");
    const [useId,setId] = useState("1");
    const navigate = useNavigate();

    const handelSubmit = (e) => {
        e.preventDefault();
        navigate(`/${useWord}/${useId}`);
        setId("");
    }
2
    return (
        <div>
            <form onSubmit={handelSubmit}>
                <label>Search for: </label>
                <select onChange={(e) => setWord(e.target.value)}>
                    <option value="people">People</option>
                    <option value="planets">Planets</option>
                    <option value="starships">Starships</option>
                </select>
                <label>Id: </label>
                <input type="text" placeholder="Id" onChange={(e) => setId(e.target.value)}/>
                <button type="submit">Go</button>
            </form>
        </div>
    )
}