var bMapAPIKey = AodddEr2Z6uTzo8eX5a7xaLk4OHojboX8Bj_wnZ5vxxk1D7H17BO89v-SEGR9HMe;

var latitude = document.getElementById('latitude');
var longitude = document.getElementById('longitude');

var displayLat = latitude.textContent;
var displayLong = longitude.textContent;

console.log(latitude);
console.log(longitude);

 function GetMap()
   {
   "use strict";

    var map = new Microsoft.Maps.Map('#myMap', {
//    credentials: 'Your Bing Maps Key',
    center: new Microsoft.Maps.Location(displayLat, displayLong),
    mapTypeId: Microsoft.Maps.MapTypeId.aerial,
    zoom: 10
    });


   }

