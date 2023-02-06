import client from "../config/Axios";
import {useState,useEffect} from "react";
import {Link} from "react-router-dom";

const Index = () =>{

    const [categories,setCategories] = useState([]);

    async function listCategory(){
        try {
            const res = await client.get('/categories');
            setCategories(res.data);
        } catch (error) {
            console.warn(error);
        }
    }

    async function handRemove(id){
        try {
            await client.delete(`/delete-category/${id}`)
            setCategories(
                categories.filter((cat) => {
                    return cat.id !== id;
                })
            )
        } catch (error) {
            console.warn(error);
        }
    }

    useEffect(() => {listCategory()},[] )
    return(
        <>
            <div className="container-fluid">
                <div className="container mt-5">
                    <div className="row">
                        <div className="col-12">
                            <Link to={"/category/create"} className="btn btn-info">Create Category</Link>
                        </div>
                    </div>
                </div>
                <div className="container my-2">
                    <div className="row">
                        <div className="col-12">
                            <div className="card">
                                <div className="card-body">
                                    <table className="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>TITLE</th>
                                                <th>SUB-TITLE</th>
                                                <th>IMAGE</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        {
                                            categories.map( category => {
                                                return(
                                                <tr>
                                                    <td key={category.id}>{category.id}</td>
                                                    <td>{category.title}</td>
                                                    <td>{category.subTitle}</td>
                                                    <td>{category.image}</td>
                                                    <td>
                                                        <Link to={`/category/edit/${category.id}`} className="btn btn-warning mx-2">edit</Link>
                                                        <button type="button" onClick={() => handRemove(category.id)} className="btn btn-danger">delete</button>
                                                    </td>
                                                </tr>
                                                )
                                            })
                                        }
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Index;