import React, { useEffect, useState, useContext } from 'react';
import axios from 'axios';
import Post from '../../components/Post/Post';
import './Posts.css';
import { Link, Route } from 'react-router-dom';
import FullPost from '../../components/FullPost/FullPost';
import { Render } from '../../store/Render'
import { API } from '../../store/API'

const Posts = (props) => {
    const [posts, setPosts] = useState([]);
    const [isLoading, setLoading] = useState(false);
    const [error, setError] = useState();
    const [selectedId, setSelectedId] = useState(null);
    const [show, setVisibility ] = useState(false);  // Just for demonstration 
    const [render, setRender] = useState({});
    const Api = useContext(API);

    function fetchPostsHandler() {
        const headers = {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json',
        }
        setLoading(true);
        setError(null); // this is to set the error to null, if there were any previous errors existing 
        console.log(isLoading);
        axios(Api.postAPI, { headers })
            .then(response => {
                setPosts(response.data);
            })
            // ***** If you want to slice out and modify during call *****
            // const sposts = response.data.slice(0, 2);  // This will get them but take the first 5 then you would have to change the response.data i nthe setPosts
            // const updatedPosts = sposts.map(post => {  // This will transform anything before assigning it to the state
            //     return {
            //         ...post,
            //         author: ' Dean'
            //     }
            // });
            // setPosts(_ => [...updatedPosts]); // async
            .catch(error => {
                setError(error.message);
                setLoading(false);
            })
    
    
        }
        
        useEffect(()=> {  
            fetchPostsHandler();
            console.log("Deleted so its called");
    
        },[]);
    useEffect(()=> {  
        fetchPostsHandler();
        console.log("Deleted so its called");

    },[render]); // This will be fetched when mounted

    const postSelectedHandler = (id) => {
        setSelectedId(id);
    }

    // const hideText = () => {
    //     setVisibility(!(show));
    // }
    
    // We can do this rather than this :: <Post title={{...posts[1]}.title} />
    const rposts = posts.map(post => {
        return <Link to={props.match.url + '/' + post.id} key={post.id}>
            <Post
                title={post.title}
                author={post.author}
                clicked={() => { postSelectedHandler(post.id) }} 
                id={post.id}/>
        </Link>
    });

    let content = <p >No posts available</p>;
    if (rposts.length > 0) {
        content = rposts;
    }
    else if (error) {
        content = <p>{error}</p>;
    }
    else if (isLoading) {
        content = <p> Loading ... </p>;  // BONUS MAKE THIS WAIT FOR A 30 seconds
    }

    // {!isLoading && rposts.length > 0 && rposts}
    //             {!isLoading && !error && rposts.length===0 && <div><br/><p >No posts available</p></div>}
    //             {!isLoading && error && <p>{error}</p>}
    //             {isLoading && <p> Loading ... </p> }  

    return (
        <Render.Provider value={{ render, setRender }}>
            <div>
                <section className="Posts">
                    {content}
                </section>
                <Route path={props.match.url + '/:id'} component={FullPost} />
                
                
                
                {show && <label> SECRET TEXT</label>}
                {/* {show ?<label> SECRET TEXT</label> : null} */}
                <button onClick={() => setVisibility(!show)}> Hide/Show</button>
            </div>
        </Render.Provider>
    );
}

export default Posts;
