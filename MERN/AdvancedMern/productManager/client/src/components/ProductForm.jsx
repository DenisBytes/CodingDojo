import React, { useState, useEffect } from "react";
import axios from "axios";

export const ProductForm = (props) => {

    const {onSubmitProp, initialTitle, initialPrice, initialDescription} = props;
    const [title, setTitle] = useState(initialTitle);
    const [price, setPrice] = useState(initialPrice);
    const [description, setDescription] = useState(initialDescription);


    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmitProp({title, price, description});
        setTitle("");
        setPrice("");
        setDescription("");
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <p>
                    <label>Title</label>
                    <input type="text" name="title" value={title} onChange={(e) => setTitle(e.target.value)} />
                </p>
                <p>
                    <label>Price</label>
                    <input type="text" name="price" value={price} onChange={(e) => setPrice(e.target.value)} />
                </p>
                <p>
                    <label>Description</label>
                    <input type="text" name="description" value={description} onChange={(e) => setDescription(e.target.value)} />
                </p>
                <p>
                    <input type="submit" value="Submit" />
                </p>
            </form>
        </div>
    )
}