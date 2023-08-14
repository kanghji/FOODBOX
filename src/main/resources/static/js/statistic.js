$(document).ready(function() {
    numberOfMember();
});
function graph(){
    let html='<div id="graph" class="w-100 h-100">\n' +
        '        <div id="graph-top" class="d-flex align-items-center w-100" style="height:10%;">\n' +
        '\n' +
        '        </div>\n' +
        '        <div id="graph-middle" class="d-flex w-100" style="height:90%;">\n' +
        '            <div id="graph-middle-left" class="" style="width:10%; height:90%;">\n' +
        '\n' +
        '            </div>\n' +
        '            <div id="graph-middle-middle" class="h-100" style="width:80%;">\n' +
        '                <div id="graph-middle-middle-top" class="w-100 border" style="height:90%;">\n' +
        '\n' +
        '                </div>\n' +
        '                <div id="graph-middle-middle-bottom" class="d-flex w-100" style="height:10%;">\n' +
        '                </div>\n' +
        '            </div>\n' +
        '            <div id="graph-middle-right" class="d-flex h-100" style="width:10%;">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>';
    $('#graphView').html(html);
}

function salesgraph(){
    let html='<div id="graph" class="w-100" style="height: 50%; ">\n' +
        '        <div id="graph-top" class="d-flex align-items-center w-100" style="height:10%;">\n' +
        '\n' +
        '        </div>\n' +
        '        <div id="graph-middle" class="d-flex w-100" style="height:90%;">\n' +
        '            <div id="graph-middle-left" class="" style="width:10%; height:90%;">\n' +
        '\n' +
        '            </div>\n' +
        '            <div id="graph-middle-middle" class="h-100" style="width:80%;">\n' +
        '                <div id="graph-middle-middle-top" class="w-100 border" style="height:90%;">\n' +
        '\n' +
        '                </div>\n' +
        '                <div id="graph-middle-middle-bottom" class="d-flex w-100" style="height:10%;">\n' +
        '                </div>\n' +
        '            </div>\n' +
        '            <div id="graph-middle-right" class="d-flex h-100" style="width:10%;">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>';
    $('#graphView').html(html);
}
function monthlygraph(){
    let html='<div id="monthlygraph" class="w-100" style="height: 50%; ">\n' +
        '        <div id="monthlygraph-top" class="d-flex align-items-center w-100" style="height:10%;">\n' +
        '\n' +
        '        </div>\n' +
        '        <div id="monthlygraph-middle" class="d-flex w-100" style="height:90%;">\n' +
        '            <div id="graph-middle-left" class="" style="width:10%; height:90%;">\n' +
        '\n' +
        '            </div>\n' +
        '            <div id="monthlygraph-middle-middle" class="h-100" style="width:80%;">\n' +
        '                <div id="graph-middle-middle-top" class="w-100 border" style="height:90%;">\n' +
        '\n' +
        '                </div>\n' +
        '                <div id="monthlygraph-middle-middle-bottom" class="d-flex w-100" style="height:10%;">\n' +
        '                </div>\n' +
        '            </div>\n' +
        '            <div id="monthlygraph-middle-right" class="d-flex h-100" style="width:10%;">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>';
    $('#graphView').append(html);
}

function numberOfMember(){

    $.ajax({
        url: "/numberOfMember",
        type: "get",
        success: (statisticDTO) => {
            graph();
            let graphtcode="";
            let graphmlcode="";
            let graphmmtcode="";
            let graphmmbcode="";
            console.log(statisticDTO);
            graphtcode+='<div class="w-100">\n' +
                '                <div class="d-flex justify-content-center w-100 text-center"><h2>전체 회원수</h2></div>\n';
            if(statisticDTO.num_member<100) {
                graphtcode+='<div style="width: 90%"><div class="d-flex w-100 justify-content-end me-3"><h7>단위수: 명</h7></div></div>\n';
            }else {
                graphtcode+='<div style="width: 90%"><div class="d-flex justify-content-end me-3"><h7>단위수: 백명</h7></div></div>\n';
            }
                graphtcode+='</div>';

            graphmlcode+='<div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:50%;"><h7>전체 가입자수</h7></div>\n' +
                '                <div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:50%;"><h7>전체 탈퇴자수</h7></div>';
            graphmmtcode +='<div class="d-flex w-100 align-items-center" style="height:50%; background-color:#eeeeee;">\n' ;
            if(statisticDTO.num_member<100) {
                graphmmtcode +='                    <div style="width:' +statisticDTO.num_member+ '%; height:50px; background-color: dodgerblue;"></div>\n' +
                '                    <h7 class="ms-2">' + statisticDTO.num_member + '</h7>\n';
            }else{
                graphmmtcode +='                    <div style="width:' +statisticDTO.num_member/100+ '%; height:50px; background-color: dodgerblue;"></div>\n' +
                    '                    <h7 class="ms-2">' + statisticDTO.num_member/100+'</h7>\n';
            }
            graphmmtcode +='                </div>\n' +
                '                <div class="d-flex w-100 align-items-center" style="height:50%; background-color:#eeeeee;">\n' ;
            if(statisticDTO.num_member<100) {
                graphmmtcode += '                    <div style="width:' + statisticDTO.num_withdrawals + '%; height:50px; background-color: darkgray;"></div>\n' +
                    '                    <h7 class="ms-2">' + statisticDTO.num_withdrawals + '</h7>\n';
            }else{
                graphmmtcode += '                    <div style="width:' + statisticDTO.num_withdrawals/100 + '%; height:50px; background-color: darkgray;"></div>\n' +
                    '                    <h7 class="ms-2">' + statisticDTO.num_withdrawals/100+'</h7>\n';
            }
            graphmmtcode +='                </div>';
            for(let i = 0; i<=100; i+=25){
                graphmmbcode+='<div class="d-flex justify-content-start" style="width:25%;"><h7>'+i+'</h7></div>';

            }
            $('#graph-top').append(graphtcode);
            $('#graph-middle-left').append(graphmlcode);
            $('#graph-middle-middle-top').append(graphmmtcode);
            $('#graph-middle-middle-bottom').append(graphmmbcode);

        },
        error: () => {
            alert("요청실패")
        }


    });
}
function total_sales(){
    $.ajax({
        url: "/totalsales",
        type: "get",
        success: (statisticDTO) => {
            console.log(statisticDTO);
            salesgraph();
            let graphtcode="";
            let graphmlcode="";
            let graphmmtcode="";
            let graphmmbcode="";
            graphtcode+='<div class="w-100">\n' +
                '                <div class="d-flex justify-content-center w-100 text-center" sytle="height:30px;"><h4>매출 총액</h4></div>\n'
                +'                <div style="width: 90%">'
                +    '<div class="d-flex w-100 justify-content-end me-3"><h7>단위수: 백만원</h7></div></div>\n'

                +'            </div>';
            graphmlcode+='<div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:100%;"><h7>매출 총액</h7></div>';

            graphmmtcode +='<div class="d-flex w-100 align-items-center" style="height:100%; background-color:#eeeeee;">\n'
                +'                    <div style="width:' +statisticDTO.total_sales/1000000+ '%; height:50px; background-color: dodgerblue;"></div>\n'
                +    '                    <h7 class="ms-2">' + statisticDTO.total_sales/1000000 + '</h7>\n'
                +'                </div>\n';
            for(let i = 0; i<=100; i+=25){
                graphmmbcode+='<div class="d-flex justify-content-start" style="width:25%;"><h7>'+i+'</h7></div>';

            }

            $('#graph-top').append(graphtcode);
            $('#graph-middle-left').append(graphmlcode);
            $('#graph-middle-middle-top').append(graphmmtcode);
            $('#graph-middle-middle-bottom').append(graphmmbcode);

            monthlygraph();

            let mgraphtcode="";
            let mgraphmlcode="";
            let mgraphmmtcode="";
            let mgraphmmbcode="";
            let today = new Date();
            // alert(statisticDTO.month_sales[0].month);
            mgraphtcode+='<div class="w-100">\n' +
                '                <div class="d-flex justify-content-center w-100 text-center" sytle="height:30px;"><h4>월별 매출액</h4></div>\n'
                +'                <div style="width: 90%">'
                +    '<div class="d-flex w-100 justify-content-end me-3"><h7>단위수: 만원</h7></div></div>\n'

                +'            </div>';
            mgraphmlcode+='<div class="d-flex flex-column justify-content-end align-items-end" style="height:100%;width:100%;">';
            for(let j = 0; j<=100; j+=25){
                mgraphmlcode+='<h7 style="height:25%;">'+j+'</h7>';

            }
            mgraphmlcode+='</div>';
            let check=false;
            for(let i = 0; i<12; i++){
                mgraphmmtcode +='<div class="d-flex justify-content-center align-items-end" style="width:'+100/12+'%; height:100%; background-color:#eeeeee;">\n'
                    +'                    <div style="width:40px; height:';
                check=false;
                for(let j =0; j<statisticDTO.month_sales.length; j++){
                    if(statisticDTO.month_sales[j].month==(i+1)) {
                        mgraphmmtcode += statisticDTO.month_sales[j].sales / 10000 + '%; background-color: dodgerblue;"></div>\n';
                            // + '                    <h7>' + statisticDTO.month_sales[j].sales / 10000 + '</h7>\n';
                        check=true;
                    }
                }
                if(!check){
                    mgraphmmtcode += '0%; background-color: dodgerblue;"></div>\n';
                        // + '                    <h7 class="ms-2">0</h7>\n';
                }
                    mgraphmmtcode +='                </div>\n';

                    mgraphmmbcode+='<div class="d-flex justify-content-center" style="width:'+100/12+'%;"><h7>'
                        +(i+1)
                        +'월</h7></div>';

            }
            $('#monthlygraph-top').append(mgraphtcode);
            $('#monthlygraph-middle-left').append(mgraphmlcode);
            $('#monthlygraph-middle-middle-top').append(mgraphmmtcode);
            $('#monthlygraph-middle-middle-bottom').append(mgraphmmbcode);
        },
        error: () => {
            alert("요청실패")
        }
    });
}
function term_sales(){
    graph();
    let graphtcode="";

    graphtcode+='<div class="w-100">' +
        '<div class="d-flex justify-contnet-start"><input type="date" ' +
        'class="form-control me-1" style="width:10%" name="start_date" id="start_date">' +
        '-><input type="date" class="form-control ms-1" style="width:10%" name="end_date" id="end_date">' +
        '<input type="button" class="btn btn-sm btn-warning" value="검색" onclick="term_sales_search()"></div>' +
        '<div class="d-flex justify-content-center w-100 text-center">' +
        '<h2>기간별 매출조회</h2></div></div>';
    $('#graph-top').append(graphtcode);
}
function term_sales_search(){
    let start_date = $('#start_date').val();
    let end_date = $('#end_date').val();
    if(start_date==""){
        alert("시작날짜를 입력하세요");
        return;
    }
    if(end_date==""){
        alert("종료날짜를 입력하세요")
        return;
    }
    $.ajax({
        url: "/termSales/"+start_date+"/"+end_date,
        type: "get",
        success: (statisticDTO) => {
            graph();
            let graphtcode="";
            let graphmlcode="";
            let graphmmtcode="";
            let graphmmbcode="";
            console.log(statisticDTO);
            graphtcode+='<div class="w-100">' +
                '<div class="d-flex w-100 justify-contnet-start align-items-center"><input type="date" ' +
                'class="form-control ms-3 me-1" style="width:10%" name="start_date" id="start_date">' +
                '-><input type="date" class="form-control ms-1" style="width:10%" name="end_date" id="end_date">' +
                '<input type="button" class="btn btn-sm btn-warning" value="검색" onclick="term_sales_search()"></div>' +
                '<div class="d-flex justify-content-center w-100 text-center">' +
                '<h2>기간별 매출조회</h2></div>'
                +    '<div style="width: 90%"><div class="d-flex w-100 justify-content-end me-3"><h7>단위수: 백만원/백건</h7></div></div>\n'

                +'            </div>';
            graphmlcode+='<div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:50%;"><h7>매출 총액</h7></div>' +
                '<div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:50%;"><h7>매출 건수</h7></div>';

            graphmmtcode +='<div class="d-flex w-100 align-items-center" style="height:50%; background-color:#eeeeee;">\n'
                +'                    <div style="width:' +statisticDTO.total_sales/1000000+ '%; height:50px; background-color: dodgerblue;"></div>\n'
                +    '                    <h7 class="ms-2">' + statisticDTO.total_sales/1000000 + '</h7>\n'
                +'                </div>\n';
            graphmmtcode +='<div class="d-flex w-100 align-items-center" style="height:50%; background-color:#eeeeee;">\n'
                +'                    <div style="width:' +statisticDTO.order_num/100+ '%; height:50px; background-color: darkgray;"></div>\n'
                +    '                    <h7 class="ms-2">' + statisticDTO.order_num/100 + '</h7>\n'
                +'                </div>\n';
            for(let i = 0; i<=100; i+=25){
                graphmmbcode+='<div class="d-flex justify-content-start" style="width:25%;"><h7>'+i+'</h7></div>';

            }
            $('#graph-top').append(graphtcode);
            $('#graph-middle-left').append(graphmlcode);
            $('#graph-middle-middle-top').append(graphmmtcode);
            $('#graph-middle-middle-bottom').append(graphmmbcode);

        },
        error: () => {
            alert("요청실패")
        }


    });
}
function product_sales(prod_code){
    $.ajax({
        url: "/productSales/"+prod_code,
        type: "get",
        success: (statisticDTO) => {
            salesgraph();
            let graphtcode="";
            let graphmlcode="";
            let graphmmtcode="";
            let graphmmbcode="";
            graphtcode+='<div class="w-100">\n' +
                '                <div class="d-flex justify-content-center w-100 text-center" sytle="height:30px;"><h4>매출 총액</h4></div>\n'
                +'                <div style="width: 90%">'
                +    '<div class="d-flex w-100 justify-content-end me-3"><h7>단위수: 백만원</h7></div></div>\n'

                +'            </div>';
            graphmlcode+='<div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:50%;"><h7>매출 총액</h7></div>' +
                '<div class="d-flex w-100 justify-content-center align-items-center text-center" style="height:50%;"><h7>매출 건수</h7></div>';

            graphmmtcode +='<div class="d-flex w-100 align-items-center" style="height:50%; background-color:#eeeeee;">\n'
                +'                    <div style="width:' +statisticDTO.total_sales/1000000+ '%; height:50px; background-color: dodgerblue;"></div>\n'
                +    '                    <h7 class="ms-2">' + statisticDTO.total_sales/1000000 + '</h7>\n'
                +'                </div>\n';
            graphmmtcode +='<div class="d-flex w-100 align-items-center" style="height:50%; background-color:#eeeeee;">\n'
                +'                    <div style="width:' +statisticDTO.order_num/100+ '%; height:50px; background-color: darkgray;"></div>\n'
                +    '                    <h7 class="ms-2">' + statisticDTO.order_num/100 + '</h7>\n'
                +'                </div>\n';
            for(let i = 0; i<=100; i+=25){
                graphmmbcode+='<div class="d-flex justify-content-start" style="width:25%;"><h7>'+i+'</h7></div>';

            }

            $('#graph-top').append(graphtcode);
            $('#graph-middle-left').append(graphmlcode);
            $('#graph-middle-middle-top').append(graphmmtcode);
            $('#graph-middle-middle-bottom').append(graphmmbcode);

            monthlygraph();

            let mgraphtcode="";
            let mgraphmlcode="";
            let mgraphmmtcode="";
            let mgraphmmbcode="";
            let today = new Date();
            for(let i = 0; i<12; i++){
                mgraphtcode+='<div class="w-100">\n' +
                    '                <div class="d-flex justify-content-center w-100 text-center" sytle="height:30px;"><h4>월별 매출액</h4></div>\n'
                    +'                <div style="width: 90%">'
                    +    '<div class="d-flex w-100 justify-content-end me-3"><h7>단위수: 만원</h7></div></div>\n'

                    +'            </div>';
                mgraphmlcode+='<div class="d-flex w-100 justify-content-end align-items-end text-center" style="height:100%;"';
                for(let i = 0; i<=100; i+=25){
                    mgraphmlcode+='<h7>'+i+'</h7>';

                }
                mgraphmlcode+='</div>';

                mgraphmmtcode +='<div class="d-flex w-100 justify-content-center align-items-end" style="height:100%; background-color:#eeeeee;">\n'
                    +'                    <div style="width:25px; height:';
                if(statisticDTO.month_sales[i].getMonth()==i+1&& statisticDTO.month_sales[i].getSales()!=0) {
                    mgraphmmtcode += (statisticDTO.month_sales[i].getSales()) / 10000 + '%; background-color: dodgerblue;"></div>\n'
                        +'                    <h7 class="ms-2">' + (statisticDTO.month_sales[i].getSales()) / 10000 + '</h7>\n';
                }else{
                    mgraphmmtcode += '0%; background-color: dodgerblue;"></div>\n'
                        +'                    <h7 class="ms-2">0</h7>\n';
                }
                mgraphmmtcode +='                </div>\n';

                mgraphmmbcode+='<div class="d-flex justify-content-center" style="width:'+12/100+'%;"><h7>'
                    +today.getMonth()+i
                    +'월</h7></div>';

            }
            $('#monthlygraph-top').append(mgraphtcode);
            $('#monthlygraph-middle-left').append(mgraphmlcode);
            $('#monthlygraph-middle-middle-top').append(mgraphmmtcode);
            $('#monthlygraph-middle-middle-bottom').append(mgraphmmbcode);
        },
        error: () => {
            alert("요청실패")
        }
    });
}
function openMember() {
    var e = document.getElementById("num_member_all");
    e.style.display = ((e.style.display!='none') ? 'none' : 'block');
}
function openSales() {
    var to = document.getElementById("total");
    var te = document.getElementById("term");
    var p = document.getElementById("product");
    to.style.display = ((to.style.display!='none') ? 'none' : 'block');
    te.style.display = ((te.style.display!='none') ? 'none' : 'block');
    p.style.display = ((p.style.display!='none') ? 'none' : 'block');
}
function productListOpen() {
    var e = document.getElementById("product_list");
    e.style.display = ((e.style.display!='none') ? 'none' : 'flex');
}