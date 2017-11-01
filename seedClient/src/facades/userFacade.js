import fetchHelper, {errorChecker} from "./fetchHelpers"
const URL = require("../../package.json").serverURL;

class UserStore {
  constructor() {
    this._data = "";
    this._errorMessage = "";
  }

  getData = (cb,path) => {
      this._errorMessage = "";
      this._messageFromServer = "";
      let resFromFirstPromise = null;  //Pass on response the "second" promise so we can read errors from server
      const options = fetchHelper.makeOptions("GET", true);
      fetch(URL + path, options)
        .then((res) => {
          resFromFirstPromise = res;
          return res.json();
        }).then((data) => {
          errorChecker(resFromFirstPromise, data);
          if (cb) {
            cb(null, data.message)
          }
        }).catch(err => {
          console.log(JSON.stringify(err))
          if (cb) {
            cb({ err: fetchHelper.addJustErrorMessage(err) })
          }
        })
    }

getRandom = (cb) => {
    this._errorMessage = "";
    this._messageFromServer = "";
    let resFromFirstPromise=null;  //Pass on response the "second" promise so we can read errors from server
    const options = fetchHelper.makeOptions("GET", true);//true will attach the Token
    fetch(URL + "api/demouser/random", options)
      .then((res) => {
        resFromFirstPromise = res;
        return res.json();
      }).then((data) => {
        errorChecker(resFromFirstPromise,data);
        if (cb) {
          cb(null, data.message)
        }
      }).catch(err => {
        console.log(JSON.stringify(err))
        if (cb) {
          cb({ err: fetchHelper.addJustErrorMessage(err) })
        }
      })
  }
}

let userStore = new UserStore();

//Only for debugging
//window.userStore = userStore;
export default userStore;
