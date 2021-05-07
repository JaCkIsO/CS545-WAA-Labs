import React, {useContext} from 'react';
import { LoggedIn } from '../../store/LoggedIn'
import "./Login.css"

const Login = (props) => {
    const { loggedIn, setLoggedIn } = useContext(LoggedIn);

    const loginHandler = () => {
        setLoggedIn(true);
        props.history.push("/")
    }
    return (

        <div className="login">
            <div><label>Email</label>
                <input name="Email" placeholder="johndoe@example.com" /></div>
            <div><label>Password</label>
                <input name="Password" type="password" /></div>
            <div>
                <button onClick={loginHandler}>Login</button>
            </div>
        </div>

    );
}

export default Login;