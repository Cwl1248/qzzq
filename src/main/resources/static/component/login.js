function login() {
    let email = document.getElementById("inputEmail3").value
    let pwd = document.getElementById("inputPassword3").value
    let user = {}
    user.email = email
    user.password = pwd
    console.log(user)
    $.ajax({
        url: 'http://localhost:18011/myInfo/login',
        type: 'post',
        data: JSON.stringify(user),
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            console.log(res)
            console.log("token:" + res.data['token'])
            console.log("Userid:" + res.data['Userid'])
            sessionStorage.setItem("token", res.data['token'])
            sessionStorage.setItem("userid", res.data['Userid'])
            alert('登录成功')
            $('#loginModal').modal('hide')
            $('#registeredModal').modal('hide')
        }
    })
}

function registered() {
    let email = document.getElementById("registeredEmail").value
    let pwd = document.getElementById("registeredPassword").value
    let user = {}
    user.email = email
    user.password = pwd
    console.log(JSON.stringify(user))
    $.ajax({
        url: 'http://localhost:18011/myInfo/registered',
        type: 'post',
        data: JSON.stringify(user),
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            $('#loginModal').modal('hide')
            $('#registeredModal').modal('hide')
            alert('注册成功')
            console.log(res)
        }
    })
}


layui.use(['dropdown', 'util', 'layer', 'table'], function () {
        var dropdown = layui.dropdown
            , util = layui.util
            , layer = layui.layer
            , table = layui.table
            , $ = layui.jquery;
        //自定义事件 - hover
        var userid = sessionStorage.getItem('userid')
        dropdown.render({
            elem: '#personalCenter'
            , trigger: 'hover'
            , data: [{
                title: '我的简历'
                , id: 100
                , href: '/myInfo/InfoDetail'
            }, {
                title: '修改简历'
                , id: 101
                , href: '/myInfo/toSelect'
            }, {
                title: '为我推荐'
                , id: 102
                , href: '/myInfo/toRecommend?userid=' + userid
            }, {
                title: '收藏职位'
                , id: 102
                ,href: '/myInfo/toCollection?userid=' + userid
            }, {
                title: '投递记录'
                , id: 102
                ,href: '/myInfo/deliveryRecord?userid=' + userid
            }
            ]
        });
    }
)