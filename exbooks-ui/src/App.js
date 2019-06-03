import React, { Component } from 'react';
import {BrowserRouter as Router, Route,NavLink} from 'react-router-dom';
import './App.css';
import SignUpForm from './pages/SignUpForm.js';
import SignInForm from './pages/SignInForm.js';

class App extends Component {
  render() {
    return (
        <Router>
        <div className="App">
          <div>
            <div>
            <NavLink to ="/sign-in">Sign in</NavLink> or
            <NavLink exact to ="/">Sign up</NavLink>
            </div>
            <Route exact path="/" component={SignUpForm}>
            </Route>
            <Route path="/sign-in" component={SignInForm}> 
            </Route>
          </div>
        </div>
      </Router>
    );
  }
}

export default App;
