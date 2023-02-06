import axios from "axios";
const tokenString = localStorage.getItem('token');
const token = JSON.parse(tokenString);
// console.warn(token);
const instance = axios.create({
    baseURL: "http://localhost:8080"
});
instance.defaults.headers.common['Authorization'] = `Bearer `+ token?.token;
export default instance;