var GK = GK || {};

GK = {
    init: function(remote_server) {
        var server = "https://beta-sso-backoffice.woowa.in";
        return typeof (remote_server) === 'undefined' ? server : remote_server;
    }
}

$(function() {
    var sessionId = document.cookies.read('gk-session-id');

    var sessionAPI = 'https://beta-sso-backoffice.woowa.in/api/validate/signin/' + sessionId + '?scope=public_user&callback=?';

    $.getJSON({
        url: sessionAPI,
        type: 'json'
    })
    .done(function(data) {
        if (data.code == '0000') {
            // document.cookies.create('gk-session-id', sessionId);

            fn_showLoginNavBar(data.result);
        } else {
            alert('로그인 처리 중 문제가 발생하였습니다.');

            fn_showLoginLayout();
        }
    })
    .fail(function(data) {
        alert('로그인에 실패하였습니다. 다시 로그인해주세요.');

        fn_showLoginLayout();
    });
});

function fn_showLoginNavBar(data) {
    var ul = document.createElement('ul');
    ul.setAttribute("class", "util");

    // <li><span>(주)우아한형제들의 <strong>이창기</strong>님</span></li>
    var corporateLi = document.createElement('li');
    corporateLi.innerHTML = '<span>' + data.corporateName + '</span>의 ';
    corporateLi.innerHTML += '<strong>' + data.name + '</strong>님';
    ul.appendChild(corporateLi);

    // <li><a href="#">정보수정</a></li>
    // var editProfileLi = document.createElement('li');
    // var editProfileAnchor = document.createElement('a');
    // editProfileAnchor.setAttribute('href', '#');
    // editProfileAnchor.innerHTML = '정보수정';
    // editProfileLi.appendChild(editProfileAnchor);
    // ul.appendChild(editProfileLi);

    // <li><a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i> 로그아웃</a></li>
    var logoutLi = document.createElement('li');
    var logoutAnchor = document.createElement('a');
    logoutAnchor.setAttribute('id', 'logout');
    logoutAnchor.setAttribute('href', '#');
    logoutAnchor.setAttribute('onclick', 'fn_logout()');

    var iconI = document.createElement('i');
    iconI.setAttribute('class', 'fa fa-sign-out');
    iconI.setAttribute('aria-hidden', 'true');
    logoutAnchor.appendChild(iconI);

    var logoutTextNode = document.createTextNode('로그아웃');
    logoutAnchor.appendChild(logoutTextNode);

    logoutLi.appendChild(logoutAnchor);
    ul.appendChild(logoutLi);

    var gk_div = document.getElementById('gk_nav');
    gk_div.appendChild(ul);
}

function fn_logout() {
    $.getJSON('https://beta-sso-backoffice.woowa.in/api/signout/?callback=?')
        .done(function(data) {
            if (data.code == '0000') {
                document.cookies.delete('gk-session-id');

                alert('로그아웃하였습니다.');

                window.location.reload();
            }
        })
        .fail(function(data) {
            alert('로그아웃 중 문제가 발생하였습니다.');
        });
}

function fn_showLoginLayout() {
    var gk_div = document.getElementById('gk_nav');
    gk_div.innerHTML = '';

    var ul = document.createElement('ul');
    ul.setAttribute("class", "util");

    var loginLi = document.createElement('li');
    var loginAnchor = document.createElement('a');
    loginAnchor.setAttribute('id', 'login');
    loginAnchor.setAttribute('href', '#');
    loginAnchor.setAttribute('onclick', 'fn_login()');

    var iconI = document.createElement('i');
    iconI.setAttribute('class', 'fa fa-sign-out');
    iconI.setAttribute('aria-hidden', 'true');
    loginAnchor.appendChild(iconI);

    loginAnchor.appendChild(document.createTextNode('로그인'));

    loginLi.appendChild(loginAnchor);

    ul.appendChild(loginLi);

    gk_div.appendChild(ul);
}

function fn_login() {
    window.location.href = 'https://beta-sso-backoffice.woowa.in/web/login?returnUrl=' + encodeURIComponent(window.location.href);
}

function fn_calculateDate(time) {
    var currentDate = new Date();
    if (typeof(time) === 'undefined') {
        time = 7 * 24 * 60;
    }
    return new Date(currentDate.getTime() + (time * 60 * 1000)).toUTCString();
}

document.cookies = {
    create: function(key, value, time) {
        document.cookie = key + '=' + value + '; expires=' + fn_calculateDate(time) + '; path=/';
    },
    read : function(key) {
        var keyX = key + '=';
        var cookieArray = document.cookie.split(';');
        for(var i=0; i<cookieArray.length; i++) {
            var cookie = cookieArray[i];
            while(cookie.charAt(0) == ' ') {
                cookie = cookie.substring(1, cookie.length);
            }
            if (cookie.indexOf(keyX) == 0) {
                return cookie.substring(keyX.length, cookie.length);
            }
        }
        return null;
    },
    delete: function (key) {
        document.cookie = key + '=; expires=' + fn_calculateDate(-1) + '; path=/';
    }
}
