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
    }
}