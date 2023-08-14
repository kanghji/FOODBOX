$(function (){

    // new menu slider
    $(".new-slider__wrap").slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2200,
        speed: 850,
        cssEase: "ease-in-out",
        dots: false,
        prevArrow: "<i class='xi-angle-left-thin new-prev new-btn'></i>",
        nextArrow: "<i class='xi-angle-right-thin new-next new-btn'></i>"
    });

});