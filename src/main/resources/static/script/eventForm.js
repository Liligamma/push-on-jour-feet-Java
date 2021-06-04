 src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDAAkz7ldBW_CZb56l6jZgmJ2XRKVfdN9s"


           function initMap(){
            var map = new google.maps.Map(document.getElementById('map'), {
            center : {lat: -33.8688, lng: 151.2195},
            zoom: 13
            });

            var input = document.getElementById('searchInput')
             map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

            var autocomplete = new google.maps.places.Autocomplete(input);
             autocomplete.bindTo('bounds', map);

            var infowindow = new google.maps.InfoWindow();
            var marker = new google.maps.Marker({
            map: map,
            anchorPoint: new google.maps.Point(0, -29)
    });



    }