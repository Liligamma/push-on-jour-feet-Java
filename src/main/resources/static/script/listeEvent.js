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




$("input[name='filter']").click(function(){
     var col = $(this).val();
     console.log(col);

     var filterParam  = "";

     if(col != "all"){
     filterParam = "text=" + col;


     }
     fetch("/evenements/liste?" + filterParam)


     .then(result =>{
         return result.text();



       })

       .then(text =>{

        $('#myEvents').html(text);
         })
         });



//  var value = $(this).val().checked;
//  console.log (value);
//  fetch("/evenements/liste?text=" + value)
//  .then(result =>{
//    return result.text();


//  })
//     .then(text =>{
//     console.log(text);
//    $('#myEvents').html(text);
//     })
//     });

});