const main = {
    init: function () {
        // 이벤트 등록
        const _this = this;
        $('#btn-check').on('click', function () {
            _this.changeEngineer()
        })

        $('#btn-cancel').on('click', function (){
            window.close();
        })


    },
    changeEngineer : function (){
        //체크된거 확인.
        const radioList = document.getElementsByName('empname')
        radioList.forEach((node) => {
            if(node.checked){
                this.updateEngineer(node.id)
            }
        })
/*        window.close();*/
    },
    trClick: function(pjtcode,customer_no,empno,customer_name,project_name){
        $('#pjtcode').val(pjtcode);
        $('#customer_no').val(customer_no);
        $('#customer_name').val(customer_name);
        $('#project_name').val(project_name);
        /**
         * 프로젝트 품명 가져오기
         */
        $.ajax({
            url: '/api/v1.0/product-info/2/projectcode',
            type: 'GET',
            data : 'pjtcode=' + pjtcode,
            success : function(data){
                $("#detail").css("display", "block");
                $("#solutionList").empty();
                const form = document.getElementById("solutionList");

                for(let i=0; i<data.length; i++){
                    const newDiv = document.createElement('div');
                    newDiv.setAttribute('class','form-check');

                    const newInput = document.createElement('input');
                    newInput.setAttribute('id', data[i].productNo);
                    newInput.setAttribute('name', data[i].productNo);
                    newInput.setAttribute('class', 'form-check-input');
                    newInput.setAttribute('type', 'radio');

                    const newLabel = document.createElement('label');
                    newLabel.setAttribute('class', 'form-check-label');
                    newLabel.setAttribute('for', data[i].productNo);
                    newLabel.innerHTML = data[i].productName + '/' + data[i].productStandard;

                    newDiv.appendChild(newInput);
                    newDiv.appendChild(newLabel);

                    form.appendChild(newDiv);
                }
                $('html, body').scrollTop( $(document).height() );

            }
        });

        /**
         * 프로젝트 엔지니어 정보 가져오기
         */
        $.ajax({
            url: '/api/v1.0/engineer-info/1/empno',
            type: 'GET',
            data : 'empno='+empno,
            success : function(data){
                $('#empno').val(data.empno);
                $('#emp_name').val(data.emp_name);
                $('#mail_address').val(data.mail_address);
            }
        });

        /**
         * 고객사 담당자 정보 가져오기
         */
        $.ajax({
            url: '/api/v1.0/customer-emp-info/1/customerNo',
            type: 'GET',
            data : 'customerNo='+customer_no,
            success : function(data){
                $('#customer_emp_name').val(data[0].customer_emp_name);
                $('#mail').val(data[0].customer_mail_address);
                $('#pnumber').val(data[0].customer_emp_phone);
            }
        });
    },

    checkButtonClick: function() {
        const data = {
            projectCode : $('#pjtcode').val(),
            customerEmpName : $('#customer_emp_name').val(),
            customerMailAddress : $('#mail').val(),
            customerEmpPhone : $('#pnumber').val()
        }

        /*
         * 고객사 담당자 정보 수정
         */
        $.ajax({
                url: '/api/v1.0/customer-emp-info/2/projectCode',
                type: 'PUT',
                contentType: 'application/json; charset=utf-8',
                data : JSON.stringify(data),
                success : function(){
                    console.log("업데이트 완료");
                }
            });
    },

    openSelectEngineer: function() {
        main.multipleScreenPopup('http://localhost:8080/selectEngineer', 'selectEngineer', 680, 580, false, 0, 0);
    },

    createProject: function () {
        // window.open('http://localhost:8080/select','selectView','width=680, height=580, top=0')

        // centered as of the monitor that fired on it
        // multipleScreenPopup('https://google.com', '_blank', 500, 500);
        // move from the left and from the top
        main.multipleScreenPopup('http://localhost:8080/select', 'selectView', 680, 580, false, 0, 0);

    },

    multipleScreenPopup(url, title, w, h, centered = true, moveRight = 0, moveDown = 0, resizable = "no") {
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
    },

    updateEngineer(empno) {
        const data = {
            empno : empno,
            projectCode : opener.$('#pjtcode').val()
        }

        /**
         * 프로젝트 엔지니어 정보 업데이트
         */
        $.ajax({
            url: '/api/v1.0/project-info/4',
            type: 'PUT',
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(data),
            success : function(resData){
                opener.$('#empno').val(resData.empno)
                opener.$('#emp_name').val(resData.emp_name)
                opener.$('#mail_address').val(resData.mail_address)
                window.close()
            },
            fail : function(){
                alert("업데이트 실패. 다시 시도하세요.");
            }
        });
    }
}
main.init();


$('.dropdown-menu a').click(function () {
    //alert(this.id);
    /**
     * 프로젝트 엔지니어 정보 가져오기
     */
    $.ajax({
        url: '/api/v1.0/engineer-info/1/empno',
        type: 'GET',
        data : 'empno='+this.id,
        success : function(data){
            $('#empno').val(data.empno);
            $('#emp_name').val(data.emp_name);
            $('#mail_address').val(data.mail_address);
        }
    });

})

$('#engineer-update').click(function () {
    const data = {
        emp_name : $("#emp_name").val(),
        mail_address: $("#mail_address").val()
    }

    const id = $("#empno").val()
    /**
     * 프로젝트 엔지니어 정보 업데이트
     */
    $.ajax({
        url: '/api/v1.0/engineer-info/4/'+id,
        type: 'PUT',
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(data),
        success : function(){
            alert("업데이트 성공.");
        },
        fail : function(){
            alert("업데이트 실패. 다시 시도하세요.");
        }
    });

})

$('#engineer-delete').click(function () {
    alert("아직 삭제하면 안됨.")

})
