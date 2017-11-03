import React, {Component} from 'react';

class SearchResult extends Component
{
    constructor(){
        super();
        this.state={
            data:[{id:1, img:"picture", Street:"Kanalvej", Zip:"2800", City:"Lyngby", geolat:2.04, geolong:2.95, description:"very good", rating:5},]
        }
    }

    render() {
        const rows = this.state.data.map(row => {
            return <tr> <td>{row.City}</td> </tr>
        })
        return (
            <div>
               <table><tbody>{rows} </tbody> </table>
            </div>
        )
    }
}

export default SearchResult;