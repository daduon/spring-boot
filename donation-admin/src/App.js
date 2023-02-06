import React, { Component } from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';

import Login from './auth/Login';
import Register from './auth/Register';
import Home from './home/Home';
import IndexCategory from './category/Index';
import CreateCategory from './category/Create';
import UpdateCategory from './category/Update';
import IndexPost from './post/Index';
import CreatePost from './post/Create';
import ShowPost from './post/Show';
import UpdatePost from './post/Update';

class App extends Component{
  render(){
    return(
      <>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<Home />}></Route>
            <Route path='login' element={<Login />}></Route>
            <Route path='register' element={<Register />}></Route>
            <Route path='category' element={<IndexCategory />}></Route>
            <Route path='category/create' element={<CreateCategory />}></Route>
            <Route path='category/edit/:id' element={<UpdateCategory />}></Route>
            <Route path='post' element={<IndexPost/>}></Route>
            <Route path='post/create' element={<CreatePost />}></Route>
            <Route path='post/edit/:id' element={<UpdatePost />}></Route>
            <Route path='post/show/:id' element={<ShowPost />}></Route>
          </Routes>
        </BrowserRouter>
      </>
    )
  }
}

export default App;
