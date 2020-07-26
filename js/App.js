import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import ListComputerComponent from "./component/computer/ListComputerComponent";
import AddComputerComponent from "./component/computer/AddComputerComponent";
import EditComputerComponent from "./component/computer/EditComputerComponent";

function App() {
  return (
      <div className="container">
          <Router>
              <div className="col-md-6">
                  <h1 className="text-center" style={style}>React User Application</h1>
                  <Switch>
                      <Route path="/" exact component={ListComputerComponent} />
                      <Route path="/computer" component={ListComputerComponent} />
                      <Route path="/add-computer" component={AddComputerComponent} />
                      <Route path="/edit-computer" component={EditComputerComponent} />
                  </Switch>
              </div>
          </Router>
      </div>
  );
}

const style = {
    color: 'red',
    margin: '10px'
}

export default App;


