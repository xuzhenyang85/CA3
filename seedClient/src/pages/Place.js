/**
 * Created by Xu on 01-11-2017.
 */
import React, {Component} from 'react'
import placeData from "../facades/placeFacade";

class PlaceList extends Component {
  constructor() {
  super();
  this.state = { message: "", data: "", err: "" }
}

componentWillMount() {
  /*
  This will fetch data each time you navigate to this route
  If only required once, add "logic" to determine when data should be "refetched"
  */
  placeData.getPlaces((e, data) => {
    if (e) {
      return this.setState({ err: e.err })
    }
    var message ="";
    message = e;
    console.log(data);
  }, "api/all/places");
}

render() {
  return (
    <div>
      <h2>Sommerhus</h2>
      <p>This list contains all the places in the system</p>
      <img src="https://xudk.me/backend/ca3/img/image.jpg"  />
      {this.state.message}
      {this.state.err && (
        <div className="alert alert-danger errmsg-left" role="alert">
          {this.state.err}
        </div>
      )}
    </div>
  )
}
}

export default PlaceList;
