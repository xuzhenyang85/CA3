import fetchHelper, {errorChecker} from "./fetchHelpers"
const URL = require("../../package.json").serverURL;
/**
 * Created by Xu on 02-11-2017.
 */
 class PlaceStore {
   constructor() {
     this._data = "";
     this._errorMessage = "";
   }
   getPlaces = (cb , path) => {
       this._errorMessage = "";
       this._messageFromServer = "";
       let resFromFirstPromise=null;  //Pass on response the "second" promise so we can read errors from server
       const options = fetchHelper.makeOptions("GET", true);
       fetch(URL + path, options)
         .then((res) => {
           resFromFirstPromise = res;
           return res.json();
         }).then((data) => {
           errorChecker(resFromFirstPromise,data);
           if (cb) {
             cb(null, data.users)
           }
         }).catch(err => {
           if (cb) {
             cb({ err: fetchHelper.addJustErrorMessage(err) })
           }
         })
     }
 }
let placeStore = new PlaceStore();

//Only for debugging
//window.userStore = userStore;
export default placeStore;
