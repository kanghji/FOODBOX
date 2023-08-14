
// 상품 검색
function prodSearchBtn(obj) {
    let searchListArea = $(".searchArea");

    // let btns = document.querySelectorAll('.search_btn');
    // $('.search_btn').removeClass('active');

    console.log(obj.getAttribute('data-mode'));
    let mode = obj.getAttribute('data-mode');

    if(mode == 'z'){
        mode = $('.active').data('mode');
        console.log("mode : " + mode);
        console.log($(`[data-mode="mode"]`));
        $(`[data-mode="${mode}"]`).addClass('active');
    }else{
        $('.search_btn').removeClass('active');
        obj.classList.add('active');
    }
    alert(mode);

    let prod_name = document.getElementById("prod_name").value;
    console.log(prod_name);

    if(mode ==='p'){

        $.ajax({
            type: 'post',
            url: '/user/prodSeach',
            data: {"prod_name" : prod_name},
            // data:JSON.stringify(jsonObj),
            // contentType: 'application/json; charset=utf8',
            success: (data) => {
                // let str = "";
                let productViewLine = '</div><div class="d-flex w-100 justify-content-center mt-3">';
                let productCount = 0;

                // if(data) callback(data);
                if(data.length != 0 ){
                    for(let i=0; i < data.length; i++ ){
                        // productViewLine +=
                            // + '<p>'+data[i].prod_name+'<img src="/image/'+data[i].prod_thumbnail+'" width="100px"/>'+' :: '+data[i].prod_comment+'</p>';
                            productViewLine += '<div class="card me-2 mb-3" style="width:265px; border:none; height:300px;">'
                                + '<div class="d-flex justify-content-center">'
                                + '<a href="/user/productView?prod_code=' + data[i].prod_code + '" style="height:180px; overflow:hidden;">'
                                + '<img class="card-image" src="/image/' + data[i].prod_thumbnail + '" alt="Card image" style="width:70%">'
                                + '</a></div>'
                                + '<div class="mt-3" style="width:70%;">'
                                + '<h7  style="font-size:15px;">'
                                + '<b class="mt-2">' + data[i].prod_brand + data[i].prod_name + '</b></h7>'
                                + '<p class="mt-3">' + data[i].prod_price + '</p>'
                                + '</div>'
                                + '</div>';
                            if ((i+1) % 4 == 0) {
                                productViewLine += '</div>'
                                    + '<div class="d-flex justify-content-center mt-3">';
                            }
                            if((data.length-(i+1))<4 && ((i+1)%4==0)){
                                productViewLine += '</div>'
                                    + '<div class="d-flex justify-content-start mt-3" style="width:1232px;">';
                            }
                                productCount++;
                        }
                        // document.getElementById('prodspanCnt').innerHTML='('+productCount+')';
                        // $('#productpreview').html(productViewLine);
                } else{
                    productViewLine += "검색된 결과가 없습니다!!";
                }
                document.getElementById('prodspanCnt').innerHTML='('+productCount+')';
                searchListArea.html(productViewLine);
                // $('#productpreview').html(productViewLine);
            },
            error: () => {
                alert("에러");
            }
        });
    }else if(mode ==='r'){
        $.ajax({
            type: 'post',
            url: '/user/recipeSeach',
            data: {"prod_name" : prod_name},
            // data:JSON.stringify(jsonObj),
            // contentType: 'application/json; charset=utf8',
            success: (data) => {

                // let productViewLine = '</div><div class="d-flex flex-column mt-3 m-auto">';
                // let productCount = 0;

                console.log(data);
                // if(data) callback(data);
                let str = "";
                // if(data) callback(data);
                if(data.length != 0 ){
                    for(let i=0; i < data.length; i++ ){
                        str +='<p>'+data[i].rcp_NM+' :: '+data[i].rcp_PAT2+'</p>';
                    }
                }else{
                    productViewLine += "검색된 결과가 없습니다!!";
                }
                searchListArea.html(str);
            },
            error: () => {
                alert("에러");
            }
        });
    }
}




// 검색 버튼
// function SearchBtn() {
//
//     let noSearch = $("#prod_name").val();
//
//     if (!noSearch || noSearch.trim() == "") {
//         alert("검색어를 입력해주세요");
//         return;
//     }
//     $.ajax({
//         url: '/user/prodSearch',
//         type: 'post',
//         data: {prod_name: $('#prod_name').val()},
//         success: function (data) {
//             let productViewLine = '</div><div class="d-flex mt-3">';
//
//             if (!data) {
//                 // alert("검색 결과가 없습니다");
//                 // location.href="/user/prodSearch";
//                 productViewLine += '<p>검색결과가 없습니다</p>';
//                 $('#productpreview').html(productViewLine);
//             } else {
//                 prodSearchBtn();
//             }
//
//         }
//     })
// }
//
// // 상품 탭 버튼
// function prodSearchBtn() {
//     $.ajax({
//         url: '/user/prodSearch',
//         type: 'post',
//         data: {prod_name: $('#prod_name').val()},
//         success: function (data) {
//             // alert(data);
//             let productViewLine = '</div><div class="d-flex flex-column mt-3">';
//             let productCount = 0;
//
//             for (let i = 0; i < data.length; i++) {
//                 productViewLine += '<div class="card me-2 mb-3" style="width:265px; border:none; height:300px;">'
//                     + '<div class="d-flex justify-content-center">'
//                     + '<a href="/user/productView?prod_code=' + data[i].prod_code + '" style="height:180px; overflow:hidden;">'
//                     + '<img class="card-image" src="/image/' + data[i].prod_thumbnail + '" alt="Card image" style="width:70%">'
//                     + '</a></div>'
//                     + '<div class="mt-3" style="width:70%;">'
//                     + '<h7  style="font-size:15px;">'
//                     + '<b class="mt-2">' + data[i].prod_brand + data[i].prod_name + '</b></h7>'
//                     + '<p class="mt-3">' + data[i].prod_price + '</p>'
//                     + '</div>'
//                     + '</div>';
//                 if ((i+1) % 4 == 0) {
//                     productViewLine += '</div>'
//                         + '<div class="d-flex flex-column mt-3">';
//                 }
//                 productCount++;
//             }
//             document.getElementById('prodspanCnt').innerHTML='('+productCount+')';
//             $('#productpreview').html(productViewLine);
//         }
//     })
// }
