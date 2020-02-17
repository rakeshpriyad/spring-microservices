import React, { Component } from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddCustomer from "./components/Customer/AddCustomer";
import AddUser from "./components/User/AddUser";
import { Provider } from "react-redux";
import store from "./store";
import Signup from "./components/Signup";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/addCustomer" component={AddCustomer} />
            <Route exact path="/signup" component={Signup} />
            <Route exact path="/addUser" component={AddUser} />
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
