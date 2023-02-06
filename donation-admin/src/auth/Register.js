import client from "../config/Axios";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

const Register = () =>{

    const [username,setUsername] = useState();
    const [password,setPassword] = useState();
    const navigation = useNavigate();

    async function register(e){
        e.preventDefault();
        try {
            const res = await client.post('/register',{username,password});
            navigation('/login');
            console.warn(res);
        } catch (error) {
            console.warn(error);
        }
    }

    return(
        <>
            <div className="container-fluid">
                <div className="container my-5">
                    <div className="row">
                        <div className="col-4"></div>
                        <div className="col-4">
                            <div className="card">
                                <div className="card-body bg-secondary">
                                    <form onSubmit={register}>
                                        <div className="form-group">
                                            <label className="text-white">Username</label>
                                            <input type={"text"} onChange={e => setUsername(e.target.value)} className="form-control" placeholder="Username" id="username" />
                                        </div>
                                        <div className="form-group">
                                            <label className="text-white">Password</label>
                                            <input type={"password"} onChange={e => setPassword(e.target.value)} className="form-control" placeholder="Password" id="password" />
                                        </div>
                                        <button type="submit" className="btn btn-primary">Register</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div className="col-4"></div>
                    </div>
                </div>
            </div>
        </>
    )
}
export default Register;