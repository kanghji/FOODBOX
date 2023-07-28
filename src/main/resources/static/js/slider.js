$(function (){

    // new menu slider
    $(".new-slider__wrap").slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2500,
        speed: 850,
        cssEase: "ease-in-out",
        dots: false,
        prevArrow: "<i class='xi-angle-left-thin best-prev best-btn'></i>",
        nextArrow: "<i class='xi-angle-right-thin best-next best-btn'></i>"
    });

});