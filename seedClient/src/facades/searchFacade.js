import testData from '../pages/Places'

class SearchFacade {
    getData(Search, cb) {

        fetch("https://xudk.me/backend/ca3/api/all/place/city/" + Search).then(res => res.json()).then(data => {
            console.log(data)
            cb(data);
        })


    }
}

export default new SearchFacade();