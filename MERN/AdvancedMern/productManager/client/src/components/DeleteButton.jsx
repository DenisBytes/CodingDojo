import axios from 'axios';

export const DeleteButton = (props) => {
    const {productId, successCallback} = props;
    const deleteProduct = (e) => {
        axios.delete(`http://localhost:8000/api/products/${productId}`)
        .then((res) => {
            console.log(res);
            successCallback();
        })
        .catch((err) => {
            console.log(err);
        })
    }

    return (
        <button onClick={deleteProduct}>Delete</button>
    )
}