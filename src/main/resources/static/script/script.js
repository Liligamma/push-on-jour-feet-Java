// const open = document.getElementById('1');
// const modal_container = document.getElementById('modal-container');
// const close = document.getElementById('close');
//
// open.addEventListener('click' () =>{
//     modal_container.classList.add('show');
// });
//
// close.addEventListener('click' () =>{
//     modal_container.classList.remove('show');
// });

$(document).ready(function() {

    console.log ("tout est ok !");
    //on localise l'objet .btn open et on écoute l'événement click
    $("#open").click(function (){
        $(".modal-container").slideDown(2000);
    });

    $("#close").click(function (){
        $(".modal-container").hide();
    });
});