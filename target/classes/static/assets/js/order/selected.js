let active = false;
let productsArray = [];

// $(document).ready(function () {
    
//     reloadDataTable();

// });

async function addToSelected(id) {

    //activate table and datatables for first time
    if (!active){
        $("#heyUserDiv").hide();
        $("#dataTablesCartList").show();
        $('#btnSend').prop("disabled", false);
        active = true;
    }

    const productInfo = await getProductInfo(id);

    console.log(productInfo);

    reloadDataTable();
    
}

function getProductInfo(id){

    return request = await fetch('api/order/getProductDto/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    // return await request.json();

}

function reloadDataTable(){

    $('#dataTablesCartList').DataTable({
        "bLengthChange": true,
        "searching": false,
        "bPaginate": false,
        "bInfo" : false
    });

}