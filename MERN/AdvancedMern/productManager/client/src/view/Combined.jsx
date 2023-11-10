import React, { useState } from "react";
import { ProductForm } from "../components/ProductForm";
import { ProductList } from "../components/ProductList";
import axios from "axios";

export const Combined = () => {

    const [products, setProducts] = useState([]);

    const createProduct = (product) => {
        axios.post("http://localhost:8000/api/products", product)
        .then((res) => {
            setProducts([...products, res.data]);
        })
        .catch((err) => {
            console.log(err);
        })
    }


    return (
        <div>
            <ProductForm onSubmitProp={createProduct} initialTitle={""} initialPrice={""} initialDescription={""}/>
            <ProductList products={products} setProducts={setProducts}/>
        </div>
    );
};