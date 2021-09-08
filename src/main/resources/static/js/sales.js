$('.dropdown-menu a').click(function () {
    //alert(this.id);
    /**
     * 영업 정보 가져오기
     */
    $.ajax({
        url: '/api/v1.0/sales-info/1/salesno',
        type: 'GET',
        data : 'salesno='+this.id,
        success : function(data){
            $('#salesno').val(data.salesno);
            $('#sales_name').val(data.sales_name);
            $('#sales_team').val(data.sales_team);
            $('#email_address').val(data.email_address);
        }
    });

})


$('#sales-update').click(function () {
    const data = {
        sales_name : $("#sales_name").val(),
        sales_team : $("#sales_team").val(),
        email_address: $("#email_address").val()
    }

    const id = $("#salesno").val()
    /**
     * 영업 정보 업데이트
     */
    $.ajax({
        url: '/api/v1.0/sales-info/4/'+id,
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

$('#sales-delete').click(function () {
    alert("아직 삭제하면 안됩니다.")

})