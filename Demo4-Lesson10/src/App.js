import React, {useState} from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Blog from './containers/Blog/Blog';
import Login from './components/Login/Login'
import { LoggedIn } from './store/LoggedIn';

const App = () => {

  const [loggedIn, setLoggedIn] = useState(false);
  return (
    <BrowserRouter>
    <LoggedIn.Provider value={{ loggedIn, setLoggedIn }}>
    <Switch>
      <Route path="/login" component={Login}/>
      <Route path ="/" component={Blog}/>
      <Route><div><h1>Not Found!</h1></div></Route>
    </Switch>
      {/* <Blog/> */}
    </LoggedIn.Provider>
    
    </BrowserRouter>
  );
}

export default App;
