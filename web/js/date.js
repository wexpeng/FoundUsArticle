function submitArticle() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "text",//预期服务器返回的数据类型
        url: "FoundArticle",//url
        data: $('#articleFrom').serialize(),
        success: function (result) {
            if (result.resultCode = 200) {
                // $('#massageShow').html(result);
                alert("提交成功,感谢您的爱心。");
            }
            ;
        },
        error: function () {
            alert("提交异常！请重新提交");
        }
    });
}
$(function () {
    $.ajax({
        //几个参数需要注意一下
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/GetArticle",//请求地址
        success: function (resultget) {
            console.log(resultget);//打印服务端返回的数据(调试用)
            if (resultget.resultCode = 200) {
                var article= "<div>";
                $.each(resultget, function (i, n) {
                   article += "<div class='articleitem'><img class=\"articleImage\" src=\""+n.articleImage+"\">" +
                        "<label>"+n.articleDescription+"</label><br>"+
                        "<label style='color:aquamarine; font-size: 16px'>拾到地址:"+n.articleLocal+"</label></div>";
                });
                article+="</div>"
                $('#resultget').append(article);
            }
            ;
        },
        error: function () {
            alert("失败执行");
        }
    });
    $(".CountNumber").text("456"); //about页面数据，假数据。以后用JSon传递
    var time = new Date();   // 程序计时的月从0开始取值后+1
    var y = time.getFullYear();
    var m = time.getMonth() + 1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var ss = time.getSeconds()
    if (m < 10) m = '0' + m;
    if (d < 10) d = '0' + d;
    if (h < 10) h = '0' + h;
    if (mm < 10) mm = '0' + mm;
    if (ss < 10) ss = '0' + ss;
    var t = y + "-" +
        m + "-" +
        d + "T" +
        h + ":" +
        mm + ":" + ss;
    $("#articleTime").val(t);
});
function changeLeftPage(page) {
    $('.page-inner-body-article').hide();
    $('.page-inner-body-classify').hide();
    $('.page-inner-body-help').hide();
    $('.page-inner-body-thanks').hide();
    $(page).show();
}

function changeRightPage(page) {
    $('.page-inner-body-input').hide();
    $('.page-inner-body-about').hide();
    $(page).show();
}