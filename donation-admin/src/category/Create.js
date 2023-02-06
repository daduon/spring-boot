import client from "../config/Axios";
import {useState} from "react";
import {Link} from "react-router-dom";

const Create = () =>{
    const [title,setTitle] = useState();
    const [subTitle,setSubTitle] = useState();
    const [image,setImage] = useState();
    var form = {
        title:title,
        subTitle:subTitle,
        image:image
    };

    async function create(e){
        e.preventDefault();
        try {
            const res = await client.post('/create-category',form);
            console.warn(res)
            setTitle('');
            setSubTitle('');
            setImage('');
        } catch (error) {
            console.warn(error);
        }
    } 

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
                                    <form onSubmit={create}>
                                        <div className="form-group">
                                            <label>Title</label>
                                            <input value={title} onChange={(e) => setTitle(e.target.value)} className="form-control" type={"text"} name="title" placeholder="category title" />
                                        </div>
                                        <div className="form-group">
                                            <label>Sub Title</label>
                                            <input value={subTitle} onChange={(e) => setSubTitle(e.target.value)} className="form-control" type={"text"} name="subTitle" placeholder="category sub-title" />
                                        </div>
                                        <div className="form-group">
                                            <label>Image</label>
                                            <input value={image} onChange={(e) => setImage(e.target.value)} className="form-control" type={"text"} name="image" placeholder="image link" />
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

export default Create;