$(document).ready(function(){
//$('#myInput').on("keyup", function() {
// var value = $(this).val().toLowerCase();
// console.log (value);
// $('.event-card').filter(function() {
//$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
// });
// });


 $('#myInput').on("keyup", function() {
  var value = $(this).val().toLowerCase();
  console.log (value);
  fetch("/evenements/liste?text=" + value)
  .then(result =>{
    return result.text();


  })
  .then(text =>{
  console.log(text);
 $('#myEvents').html(text);
  })
  });


});



