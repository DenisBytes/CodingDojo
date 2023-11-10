import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

export const Details = (props) => {
    const [product, setProduct] = useState({});
    const { id } = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
        .then((res) => {
            setProduct(res.data);
        })
        .catch((err) => {
            console.log(err);
        })
    })

    return (
        <div>
            <h1>{product.title}</h1>
            <p>{product.price}</p>
            <p>{product.description}</p>
        </div>
    )
}