
// 서브메뉴 카테고리 리스트 불러오기
function storeSubmenuOver() {

    $.ajax({
       type: 'get',
       url: '/categoryCodeList',
       success: function (data) {

           let storeCategory = document.querySelector('#storeCategory');
           let addCategoryListStr="<li class='sub_title'><span>푸드</span></li>";

           storeCategory.innerHTML= "<li class='sub_title'><span>푸드</span></li>"

           $.each(data,function(index, value) {
                   // alert(value.category_name);
               addCategoryListStr+="<li><a href='/user/productPage?category_code="+value.category_code+"&" +
                                            "category_name="+value.category_name+"'>"+value.category_name+"</a></li>";

                   storeCategory.innerHTML=addCategoryListStr;
               });

           $("#storeCategory").css('display', 'block');
       }
    });
};

function storeSubmenuOut() {
    $("#storeCategory").css('display', 'none');
}
