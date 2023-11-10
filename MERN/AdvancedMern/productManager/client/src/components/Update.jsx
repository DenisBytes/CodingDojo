import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import { ProductForm } from "./ProductForm";
import { DeleteButton } from "./DeleteButton";


export const Update = (props) => {
    const [product, setProduct] = useState({});
    const [loaded, setLoaded] = useState(false);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8000/api/products/${id}`)
            .then((res) => {
                console.log(res);
                setProduct(res.data);
                setLoaded(true);
            })
            .catch((err) => {
                console.log(err);
            })
    }, []);

    const updateProduct = (person) => {
        axios.put(`http://localhost:8000/api/products/${id}`, person)
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            })
    }

    return (
        <div>
            <h1>Update</h1>
            {
                loaded && (
                    <>
                        <ProductForm onSubmitProp={updateProduct} initialTitle={product.title} initialPrice={product.price} initialDescription={product.description} />
                        <DeleteButton productId={product._id} successCallback={() => navigate("/home")}></DeleteButton>
                    </>
                )
            }
        </div>
    )
}