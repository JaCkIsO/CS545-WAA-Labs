import React, { useEffect, useState, useContext } from 'react';
import axios from 'axios';
import './FullPost.css';
import { Render } from '../../store/Render'
import { API } from '../../store/API'


const FullPost = (props) => {

    const headers = {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
    }

    const [postCall , setPostCall] = useState({});
    const [renderedId , setRenderedId] = useState(null);
    const { render, setRender } = useContext(Render);
    const Api = useContext(API);


    useEffect(()=> {
        setRenderedId(props.match.params.id);
        return ('This was executed when unmounted!');

    },[props.id]);

    useEffect(()=> {
        if( renderedId !== props.match.params.id){
            axios(Api.postAPI + props.match.params.id , {headers})
            .then(response => {
                setPostCall(response.data);
                setRenderedId(props.match.params.id);
                console.log('This wont get called again '); 
            })
        }
        return () =>{
            console.log('post was unmounted')
        };
    },[props]);  // if I leave this empty here, it will update twice.  


    const deletePost = () => {
        axios.delete(Api.postAPI +  props.match.params.id, {headers})
            .then(response => {
                
                props.history.push('/posts'); 
                setRender({...render});
            });
    };


    let post = <p style={{ justifyContent:'space-around' }}> Please select a Post!</p>;
    if (props.match.params.id != null) {
        post = (
            <div className="FullPost">
                <h1>{postCall.title}</h1>
                <p>{postCall.content}</p>
                <div className="Edit">
                    <button onClick={deletePost} className="Delete">Delete</button>
                </div>
            </div>
        );
    }


    return post;
}

export default FullPost;