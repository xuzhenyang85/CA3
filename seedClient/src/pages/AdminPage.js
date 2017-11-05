import React, { Component } from 'react'
import adminData from "../facades/adminFacade";

class AdminPage extends Component {

    constructor(){
      super();
      this.state = {data: "", err:""}
    }

    componentWillMount() {
      /*
      This will fetch data each time you navigate to this route
      If only required once, add "logic" to determine when data should be "refetched"
      */
      adminData.getData((e,data)=>{
        if(e){
          return this.setState({err:e.err})
        }
        this.setState({err:"",data});
      }, "api/demoadmin");
    }
    render() {
      return (
        <div>
          <h2>Admins</h2>
          <p>Hello Admin from server (call accesible by only authenticated ADMINS</p>

          <div className="msgFromServer">
            {this.state.data}
          </div>
          { this.state.err && (
            <div className="alert alert-danger errmsg-left" role="alert">
              {this.state.err}
            </div>
          )}

        </div>
      )
    }

  }

export default AdminPage;
