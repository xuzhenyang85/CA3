/**
 * Created by Xu on 02-11-2017.
 */
 class PlaceFacade {
     getData(Search, cb) {

         fetch("https://xudk.me/backend/ca3/api/all/place/" + Search).then(res => res.json()).then(data => {
             console.log(data)
             cb(data);
         })


     }
 }

 export default new PlaceFacade();
