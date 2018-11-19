//获取数据
function getArticle() {
    $.ajax({
        //几个参数需要注意一下
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/GetArticle",//请求地址
        success: function (resultget) {
            console.log(resultget);//打印服务端返回的数据(调试用)
            if (resultget.resultCode = 200) {
                var article = "<div class='articleGroup'>";
                $.each(resultget, function (i, n) {
                    article += "<div class='articleitem'><img class=\"articleImage\" src=\"" + n.articleImage + "\"><br>" +
                        "<label style='font-size: 18px'>" + n.articleDescription + "</label><br>" +
                        "<label style='color:aquamarine; font-size: 16px'>拾到地址:" + n.articleLocal + "</label></div>";
                });
                article += "</div>";
                $('.page-inner-body-article').empty();
                $('.page-inner-body-article').append(article);
            }
            ;
        },
        error: function () {
            alert("失败执行");
        }
    });
}

//提交数据
function submitArticle() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        contentType:false, //给服务器的数据格式
        url: "FoundArticle",//url
        data: new FormData($('#articleFrom')[0]),
        processData: false,
        //  data: "articleDescription=" + $('#articleDescription').val() +
        //       "&articleTime=" + $('#articleTime').val() +
        //       "&articleLocal=" + $('#articleLocal').val() +
        //       "&articleImg=" + $('#articleImg').val() +
        //       "&articleContact=" + $('#articleContact').val() +
        //       "&articleAddress=" + $('#articleAddress').val(),
        success: function (result) {
            if (result.resultCode = 200) {
                // $('#massageShow').html(result);

                console.log("提交成功"+$('#articleFrom')[0]);
                getArticle();   //刷新数据
                $('#splitlayout').attr("class","splitlayout open-left");  //跳转到物品页
            }
            ;
        },
        error: function () {
            alert("提交异常！网站出错，请联系管理员（tel:18229738322）");
        }
    });
}

//数据初始化
$(function () {
    getArticle();  //获得数据
    $(".CountNumber").text("456"); //about页面数据，假数据。以后用JSon传递
    var time = new Date();   // 程序计时的月从0开始取值后+1
    var y = time.getFullYear();
    var m = time.getMonth() + 1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var ss = 0;
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
    $('.page-inner-body-article-a').css("font-size", "1em");
    $('.page-inner-body-help-a').css("font-size", "1em");
    $('.page-inner-body-classify-a').css("font-size", "1em");
    $('.page-inner-body-thanks-a').css("font-size", "1em");
    $(page).show();
    $('.page-inner-menu-left ' + page + '-a').css("font-size", "1.3em");
}

function changeRightPage(page) {
    $('.page-inner-body-input').hide();
    $('.page-inner-body-about').hide();
    $('.page-inner-body-input-a').css("font-size", "1em");
    $('.page-inner-body-about-a').css("font-size", "1em");
    $(page).show();
    $('.page-inner-menu-right ' + page + '-a').css("font-size", "1.3em");
}