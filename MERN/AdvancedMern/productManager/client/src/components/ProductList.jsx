import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';
import { DeleteButton } from './DeleteButton';

export const ProductList = (props) => {
    const {products, setProducts} = props;

    useEffect(() => {
        axios.get("http://localhost:8000/api/products")
        .then((res) => {
            setProducts(...products, res.data);
        })
        .catch((err) => {
            console.log(err);
        });
    }, []);

    const removeFromDom = (productId) => {
        setProducts(products.filter(product => product._id != productId));
    }

    return (
        <div>
            {products.map((product, index) => (
                <div key={index}>
                    <h3>{product.title}</h3>
                    <p>{product.price}</p>
                    <p>{product.description}</p>
                    <Link to={`/products/${product._id}`}>View Details</Link>
                    <Link to={`/products/${product._id}/edit`}>Update</Link>
                    <DeleteButton productId={product._id} successCallback={() => removeFromDom(product._id)}/>
                </div>
            ))}
        </div>
    )
}