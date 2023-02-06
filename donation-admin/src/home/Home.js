import {Link} from "react-router-dom";

const Home = () =>{
//     const [about,setAbout] = useState([]);
//     async function getAbout(){
//         try {
//             const res = await client.get('/list-about');
//             setAbout(res.data);
//             // console.warn(res.data);
//         } catch (error) {
//             console.warn(error);
//         }
//     }
//     useEffect(() => { getAbout() }, [])
    return(
    <>
        <div className="container-fluid">
            <div className="container">
                <div className="row">
                    <div className="col-12">
                        <div className="card my-5">
                            <div className="card-body">
                                <div className="container">
                                    <div className="row">
                                        <div className="col-6">
                                            <Link to={"/category"}>
                                                <div className="card">
                                                    <div className="card-body bg-info text-center text-dark">
                                                        <h4>{"CREATE CATEGORY"}</h4>
                                                    </div>
                                                </div>
                                            </Link>
                                        </div>
                                        <div className="col-6">
                                            <Link to={"/post"}>
                                                <div className="card">
                                                    <div className="card-body bg-info text-center text-dark">
                                                        <h4>CREATE PRODUCT</h4>
                                                    </div>
                                                </div>
                                            </Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </>
    )
}

export default Home;