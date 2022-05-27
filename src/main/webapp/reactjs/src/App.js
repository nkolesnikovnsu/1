import React from "react";
import "./App.css";

import { Container, Row, Col } from "react-bootstrap";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import NavigationBar from "./components/NavigationBar";
import NavigationBarUser from "./components/NavigationBarUser";
import Welcome from "./components/Welcome";
import Book from "./components/Book/Book";
import BookList from "./components/Book/BookList";
import UserList from "./components/User/UserList";
import Register from "./components/User/Register";
import RegisterHelpers from "./components/User/RegisterHelpers";
import Login from "./components/User/Login";
import Footer from "./components/Footer";
import Home from "./components/Home";
import HomeAdminHelper from "./components/HomeAdminHelper";
import HomeAdmin from "./components/HomeAdmin";
import {useSelector} from "react-redux";
import NavigationBarAdminHelper from "./components/NavigationBarAdminHelper";
import BookListForUser from "./components/Book/BookListForUser";

const App = () => {
  window.onbeforeunload = (event) => {
    const e = event || window.event;
    e.preventDefault();
    if (e) {
      e.returnValue = "";
    }
    return "";
  };
  const auth = useSelector((state) => state.auth);
  if(auth.username==="test@admin.com"){
    return (
        <Router>
          <NavigationBar />
          <Container>
            <Row>
              <Col lg={12} className={"margin-top"}>
                <Switch>
                  <Route path="/homeadmin" exact component={HomeAdmin} />
                  <Route path="/homehelperadmin" exact component={HomeAdminHelper} />
                  <Route path="/" exact component={Welcome} />
                  <Route path="/home" exact component={Home} />
                  <Route path="/add" exact component={Book} />
                  <Route path="/edit/:id" exact component={Book} />
                  <Route path="/list" exact component={BookList} />
                  <Route path="/users" exact component={UserList} />
                  <Route path="/register" exact component={Register} />
                  <Route path="/login" exact component={Login} />
                  <Route path="/registerhelpers" exact component={RegisterHelpers} />
                  <Route
                      path="/logout"
                      exact
                      component={() => (
                          <Login message="User Logged Out Successfully." />
                      )}
                  />
                </Switch>
              </Col>
            </Row>
          </Container>
          <Footer />
        </Router>
    );
  } else if(auth.username.indexOf("helper.com")!==-1){
    return (
        <Router>
          <NavigationBarAdminHelper />
          <Container>
            <Row>
              <Col lg={12} className={"margin-top"}>
                <Switch>
                  <Route path="/homeadmin" exact component={HomeAdmin} />
                  <Route path="/homehelperadmin" exact component={HomeAdminHelper} />
                  <Route path="/" exact component={Welcome} />
                  <Route path="/home" exact component={Home} />
                  <Route path="/add" exact component={Book} />
                  <Route path="/edit/:id" exact component={Book} />
                  <Route path="/list" exact component={BookList} />
                  <Route path="/users" exact component={UserList} />
                  <Route path="/register" exact component={Register} />
                  <Route path="/login" exact component={Login} />
                  <Route
                      path="/logout"
                      exact
                      component={() => (
                          <Login message="User Logged Out Successfully." />
                      )}
                  />
                </Switch>
              </Col>
            </Row>
          </Container>
          <Footer />
        </Router>
    );
  } else{
    return (
        <Router>
          <NavigationBarUser />
          <Container>
            <Row>
              <Col lg={12} className={"margin-top"}>
                <Switch>
                  <Route path="/" exact component={Welcome} />
                  <Route path="/home" exact component={Home} />
                  <Route path="/list" exact component={BookListForUser} />
                  <Route path="/register" exact component={Register} />
                  <Route path="/login" exact component={Login} />
                  <Route
                      path="/logout"
                      exact
                      component={() => (
                          <Login message="User Logged Out Successfully." />
                      )}
                  />
                </Switch>
              </Col>
            </Row>
          </Container>
          <Footer />
        </Router>
    );
  }
};

export default App;
