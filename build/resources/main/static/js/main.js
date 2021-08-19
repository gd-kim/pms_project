const main = {
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
    }
}