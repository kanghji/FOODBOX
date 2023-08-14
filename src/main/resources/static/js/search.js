
// 검색 버튼
function SearchBtn() {

    let noSearch = $("#prod_name").val();

    if (!noSearch || noSearch.trim() == "") {
        alert("검색어를 입력해주세요");
        return;
    }
    $.ajax({
        url: '/user/prodSearch',
        type: 'post',
        data: {prod_name: $('#prod_name').val()},
        success: function (data) {
          if (noSearch != data) {
              alert("검색 결과가 없습니다");
              return;
          }
          location.href="/user/prodSearch";
        }
    })
}

// 상품 탭 버튼
function prodSearchBtn() {
    $.ajax({
        url: '/user/prodSearch',
        type: 'post',
        data: {prod_name: $('#prod_name').val()},
        success: function (data) {
            // alert(data);
            let productViewLine = '</div><div class="d-flex mt-3 w-100">';
            let productCount = 1;
            for (let i = 0; i < data.length; i++) {

                productViewLine += '<div class="card me-5 mb-3" style="width:300px; border:none; height:300px;">'
                    + '<a href="/user/productView?prod_code=' + data[i].prod_code + '" style="height:180px; overflow:hidden;">'
                    + '<img class="card-image" src="/image/' + data[i].prod_thumbnail + '" alt="Card image" style="width:100%">'
                    + '</a>'
                    + '<div class="card-body">'
                    + '<h7 class="" style="font-size:15px;">'
                    + '<b>' + data[i].prod_brand + data[i].prod_name + '</b></h7>'
                    + '<p class="card-text">' + data[i].prod_price + '</p>'
                    + '</div>'
                    + '</div>';
                if (productCount % 4 == 0) {
                    productViewLine += '</div>'
                        + '<div class="d-flex mt-3 w-100">';
                }
                productCount++;
            }
            $('#productpreview').append(productViewLine);
        }
    })
}