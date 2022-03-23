let active = false;
let productsArray = [];

$(document).ready(function () {
    
    reloadDataTable();

});

async function addToSelected(id) {

    event.preventDefault();

    //activate table and datatables for first time
    if (!active){
        $("#heyUserDiv").hide();
        $("#dataTablesCartList").show();
        $('#btnSend').prop("disabled", false);
        active = true;
    }

    const request = await fetch('api/order/getProductDto/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    const productInfo = await request.json();

    reloadDataTable();
    
}

function reloadDataTable(){

    $('#dataTablesCartList').DataTable({
        "bLengthChange": true,
        "searching": false,
        "bPaginate": false,
        "bInfo" : false
    });

}