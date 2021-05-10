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

const titreSpans = document.querySelectorAll('h1 span');
const paragrapheDroite1 = document.getElementById('droite1');
const paragrapheDroite2 = document.getElementById('droite2');
const paragrapheGauche1 = document.getElementById('gauche1');
const paragrapgeGauche2 = document.getElementById('gauche2');



window.addEventListener('load',() =>{

    const timeline = gsap.timeline({paused:true});

    timeline
        .staggerFrom(titreSpans, 1, {top: -50, opacity:0, ease: "power2.out"}, 0.3)


    timeline.play();
})

$(document).ready(function (){

    $(".btn-info").click(function (){

        $(".concept").slideDown(2000);
    });
});