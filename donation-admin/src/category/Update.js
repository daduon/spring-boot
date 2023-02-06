import client from "../config/Axios";
import {useState,useEffect} from "react";
import {Link,useParams} from "react-router-dom";

const Update = () =>{
    const {id} = useParams();
    const [formData,setFormData] = useState({title:"",subTitle:"",image:""})
    async function getCategoryById(){
        try {
            const res = await client.get(`/edit-category/${id}`)
            setFormData(res.data)
        } catch (error) {
            console.warn(error);
        }
    }

    async function update(e){
        e.preventDefault();
        
        try {
            await client.put(`/update-category/${id}`,formData);
        } catch (error) {
            console.warn(error);
        }
    }

    useEffect(() => {getCategoryById(id)}, [id]);

    return(
        <>
            <div className="container-fluid">
                <div className="container mt-5">
                    <div className="row">
                        <div className="col-12">
                            <Link to={"/category"} className="btn btn-dark">Back</Link>
                        </div>
                    </div>
                </div>
                <div className="container my-2">
                    <div className="row">
                        <div className="col-12">
                            <div className="card">
                                <div className="card-body">
                                    <form onSubmit={update}>
                                        <div className="form-group">
                                            <label>Title</label>
                                            <input value={formData.title} onChange={(e) => setFormData({...formData,title:e.target.value})} className="form-control" type={"text"} name="title" placeholder="category title" />
                                        </div>
                                        <div className="form-group">
                                            <label>Sub Title</label>
                                            <input value={formData.subTitle} onChange={(e) => setFormData({...formData,subTitle:e.target.value})} className="form-control" type={"text"} name="subTitle" placeholder="category sub-title" />
                                        </div>
                                        <div className="form-group">
                                            <label>Image</label>
                                            <input value={formData.image} onChange={(e) => setFormData({...formData,image:e.target.value})} className="form-control" type={"text"} name="image" placeholder="image link" />
                                        </div>
                                        <button type="submit" className="btn btn-primary">Save</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Update;