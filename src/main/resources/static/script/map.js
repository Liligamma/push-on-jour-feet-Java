
    var map, searchManager;

    function GetMap() {
        map = new Microsoft.Maps.Map('#myMap', {
            credentials: 'AodddEr2Z6uTzo8eX5a7xaLk4OHojboX8Bj_wnZ5vxxk1D7H17BO89v-SEGR9HMe'
        });

        Microsoft.Maps.Events.addHandler(map,  "click", onMapClick);
    }

    function onMapClick (map){
    console.log("ca marche")

    let latitude = map.location.latitude;
    let longitude = map.location.longitude;

    console.log(latitude);
    console.log(longitude);

    document.forms['Formulaire'].elements['latitude'].value = latitude
    document.forms['Formulaire'].elements['longitude'].value = longitude

    }



//    Microsoft.Maps.loadModule('Microsoft.Maps.Search', function () {
//        var searchManager = new Microsoft.Maps.Search.SearchManager(map);
//        var reverseGeocodeRequestOptions = {
//        location : new Microsoft.Maps.Location(latitude, longitude),
//        callback : function(answer, userData){
//         map.setView({ bounds: answer.bestView });
//          map.entities.push(new Microsoft.Maps.Pushpin(reverseGeocodeRequestOptions.location));
//
//        }
//        }
//        }
