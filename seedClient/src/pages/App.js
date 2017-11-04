import React from "react";
import {Route, Switch } from "react-router-dom";
import Login from "./Login";
import Logout from "./Logout";
import About from "./About";
import UserPage from "./UserPage";
import AdminPage from "./AdminPage";
import TopMenu from "./TopMenu";
import UserList from "./UserList";
import RandomNumber from "./RandomNumber";
import Search from "./Search";
import Place from "./Place";


function App() {
  return (
    <div>
      <TopMenu />
      <Switch>
        <Route path="/login" component={Login} />
        <Route path="/logout" component={Logout} />
        <Route path="/about" component={About} />
        <Route path="/user" component={UserPage} />
        <Route path="/admin" component={AdminPage} />
        <Route path="/userList" component={UserList} />
        <Route path="/random" component={RandomNumber} />
        <Route path="/search" component={Search} />
        <Route path="/place" component ={Place} />
      </Switch>
    </div>
  )
}
export default App;
