import React, { Component } from 'react';
import searchFacade from '../facades/searchFacade';

class Search extends Component {

    constructor() {
        super();
        this.state = { places: { search: "" }, data: [] }
        this.handleClick = this.handleClick.bind(this);
    }
    handleClick = (event) => {
        const places = this.state.places.search;
        console.log(places)
        const place = this;
        searchFacade.getData(places, (data) => {
            console.log(this)
            place.setState({ data });

        })
    }

    onChange = (e) => {
        const propertyName = e.target.id;
        const value = e.target.value;
        let places = this.state.places;
        places[propertyName] = value;
        this.setState({ places });
    }
    componentWillMount() {
        /*
        This will fetch data each time you navigate to this route
        If only required once, add "logic" to determine when data should be "refetched"
        */
    }

    /*
    [
  {
    "id": 4,
    "image": "image.jpg",
    "street": "Vejnavn 1",
    "zip": "2800",
    "city": "KÃ¸ge",
    "geolat": 12.445,
    "geolng": 32.7632,
    "description": "Ude pÃ¥ sjÃ¦lland",
    "rating": 5
  }
]
    */

    render() {
        const rows = this.state.data.map(row => {
            return (
                <tr key={row.id}>
                    <td>{row.id}</td>
                    <td>{row.street}</td>
                    <td>{row.zip}</td>
                    <td>{row.city}</td>
                    <td>{row.geolat}</td>
                    <td>{row.geolng}</td>
                    <td>{row.description}</td>
                    <td>{row.rating}</td>
                </tr>
            )
        })
        return (
            <div>
                <input type="text" value={this.state.places.search} onChange={this.onChange} id="search" placeholder="Search for places..." />
                <button type="button" onClick={this.handleClick}>search</button>

                <div>
                    <table className="table table-striped"> <thead ><tr><th>Id</th><th>Street</th><th>Zip</th><th>City</th><th>Geolat</th><th>Geolng</th><th>Description</th><th>Rating</th></tr></thead><tbody>{rows} </tbody> </table>
                </div>
            </div>
        )
    }
}

export default Search;