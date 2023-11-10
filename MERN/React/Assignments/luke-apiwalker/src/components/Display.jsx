import { useEffect, useState } from "react"
import { SearchForm } from "./SearchForm"
import { useParams, Link } from "react-router-dom"
import axios from "axios"

export const Display = (props)=>{

    const {word,id} = useParams();
    console.log(word,id);
    const [useData, setData] = useState(null);
    const [homeworld, setHomeworld] = useState("");
    const [homeworldId, setHomeworldId] = useState("");

    useEffect(() => {
        axios.get(`https://swapi.dev/api/${word}/${id}`)
            .then((res)=>{
                setData(res.data)
                console.log("API request successful:", res.data);
            })
            .catch((err)=>{
                console.error("API request failed:", err);
                setData(null)
            })
    },[word, id]);

    useEffect(() => {
        if (word === "people" && useData) {
            const wow = useData.homeworld;
            axios
                .get(wow)
                .then((res) => {
                    setHomeworld(res.data);
                    console.log("API request successful:", res.data);
                })
                .catch((err) => {
                    console.error("API request failed:", err);
                    setHomeworld("");
                });

            if (wow.charAt(wow.length - 3) === "/") {
                setHomeworldId(wow.charAt(wow.length - 2));
            } else {
                const firstChar = wow.charAt(wow.length - 3);
                const secondChar = wow.charAt(wow.length - 2);
                const string = firstChar + secondChar;
                setHomeworldId(string);
            }
        }
    }, [word, useData]);

    const renderFields = () => {
        if (useData==null) {
            return(
                <>
                    <h1>These aren&apos;t the droids you&apos;re looking for</h1>
                    <Link to="/">Go back</Link>
                </>
            )
        }
        if (word === "people") {

            return (
                <>
                    <SearchForm />
                    <p>Name: {useData.name}</p>
                    <p>Height: {useData.height} </p>
                    <p>Mass: {useData.mass}</p>
                    <p>Gender: {useData.gender}</p>
                    <p>Homeworld: <Link to={"/planets/"+ homeworldId}>{homeworld.name}</Link></p>
                </>
            );
        } else if (word === "planets") {
            return (
                <>
                    <SearchForm />
                    <p>Name: {useData.name}</p>
                    <p>Diameter: {useData.diameter} </p>
                    <p>Climate: {useData.climate} </p>
                    <p>Gravity: {useData.gravity} </p>
                </>
            );
        } else if (word === "starships") {
            return (
                <>
                    <SearchForm />
                    <p>Name: {useData.name} </p>
                    <p>Length: {useData.length} </p>
                    <p>Model: {useData.model} </p>
                    <p>Crew: {useData.crew} </p>
                </>
            );
        }
    };

    return (
        <div>
            {renderFields()}
        </div>
    )
}