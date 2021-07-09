const main = {
    init: function () {
        const _this = this;
        $('#btn-send').on('click', function () {
            _this.send()
        })
        $('#btn-select').on('click', function () {
            _this.openSelect()
        })
        $('#btn-cancel').on('click', function () {
            if(confirm('취소하시겠습니까? 작성된 내용이 모두 사라집니다.')){
                location.href='/tables';
            }
        })
    },
    send: function () {
        var date = new Date();
        var send_date = date.toLocaleString();
        const data = {
            emp_name: $('#engineer_name').val(),
            address: $('#address').val(),
            title: $('#title').val(),
            message: $('#message').val(),
            mail_product_name: document.getElementById('product').innerText,
            customer: document.getElementById('check').innerText,
            send_date: send_date
        };

        if(data.address === '' || data.title === '' || data.message === '' || data.message === '' || data.emp_name === '' || data.mail_product_name === '' || data.customer === '') {
            alert('작성이 완료되지 않았습니다.');
        } else {
            loadingBarStart();
            $.ajax({
                type: 'POST',
                url: '/api/send',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data),
                success: function (returnData) {
                    console.log(returnData.data.result);

                    if(returnData.data.result == '메일 전송 성공') {
                        alert(returnData.data.result);

                        $.ajax({
                            type: 'POST',
                            url: '/api/mail-save',
                            contentType: 'application/json; charset=utf-8',
                            data: JSON.stringify(data),
                            success: function () {
                                console.log('메일 DB저장 성공');
                                loadingBarEnd();
                                location.href='/lookup';
                            },
                            error: function (jqxhr, textStatus, errorThrown) {
                                alert('DB서버 전송 실패 : ' + jqxhr.status + ' ' + jqxhr.statusText);
                                loadingBarEnd();
                            }
                        });
                    } else {
                        alert(returnData.data.result);
                        loadingBarEnd();
                        console.log(returnData.data.result);
                    }
                },
                error: function (jqxhr, textStatus, errorThrown) {
                    alert('메일 서버 전송 실패 : ' + jqxhr.status + ' ' + jqxhr.statusText);
                    loadingBarEnd();
                }
            });
        }
    },
    openSelect: function () {
        // window.open('http://localhost:8080/select','selectView','width=680, height=580, top=0')

        // centered as of the monitor that fired on it
        // multipleScreenPopup('https://google.com', '_blank', 500, 500);
        // move from the left and from the top
        multipleScreenPopup('http://localhost:8080/select', 'selectView', 680, 580, false, 0, 0);
    }
};
main.init();

function multipleScreenPopup(url, title, w, h, centered = true, moveRight = 0, moveDown = 0, resizable = "no") {
    // Fixes dual-screen position                         Most browsers      Firefox
    const dualScreenLeft = window.screenLeft !== undefined ? window.screenLeft : screen.left;
    const dualScreenTop = window.screenTop !== undefined ? window.screenTop : screen.top;

    const width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
    const height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

    let left;
    let top;
    if (centered === true) {
        left = ((width / 2) - (w / 2)) + dualScreenLeft;
        top = ((height / 2) - (h / 2)) + dualScreenTop;
    } else {
        left = dualScreenLeft + moveRight;
        top = dualScreenTop + moveDown;
    }

    const newWindow = window.open(url, title, 'directories=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=' + resizable + ', width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);

    // Puts focus on the newWindow
    if (window.focus) {
        newWindow.focus();
    }
}

function loadingBarStart() {
    var backHeight = $(document).height(); //뒷 배경의 상하 폭
    var backWidth = window.document.body.clientWidth; //뒷 배경의 좌우 폭
    var loadingBarImage = "<div id='back'>"; //뒷 배경을 감쌀 커버
    loadingBarImage += "<div class=\"loading\" id=\"Progress_Loading\"></div>"; //로딩 바 이미지
    loadingBarImage += "<div id=\"loading-text\">전송 중...</div>";
    loadingBarImage += "</div>";
    $('body').append(loadingBarImage);
    $('#back').css({ 'width': backWidth, 'height': backHeight, 'opacity': '0.3' });
    $('#back').show();
}

function loadingBarEnd() {
    $('#back').hide();
    $('#back').remove();
}
