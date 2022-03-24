let active = false;
let productsArray = [];

async function addToSelected(id) {

    e.preventDefault();

    //activate table for first time
    if (!active) {
        $("#heyUserDiv").hide();
        $("#dataTablesCartList").show();
        $('#btnSend').prop("disabled", false);
        active = true;
    }

    const request = await fetch('api/order/getProductCart/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    const productJSON = await request.json();

    //check if the product is already in the array
    if (!existsId(productJSON.productId)) {

        let addSelectedProductHTML = "";

        //add product to array and sum 1 unit to amount
        let product = { id: productJSON.productId, quantity: 1 };
        productsArray.push(product);

        //create line

        addSelectedProductHTML += `<tr id="product${productJSON.productId}" ><td scope="row">${productJSON.productName}</td>`;
        addSelectedProductHTML += `<td>${product.quantity}</td>`;
        addSelectedProductHTML += `<td>${productJSON.price}</td>`;
        addSelectedProductHTML += `<td> ACTIONS HERE </td></tr>`;

        document.querySelector('#dataTablesCartList tbody').innerHTML += addSelectedProductHTML;
    }

    // reloadDataTable(); //fix reload

}

$("#btnSend").click(async function (e) { 
    e.preventDefault();
    
    for (let product of Object.values(productsArray)) {
        if (product.id === searchId) return true;
    }

});

function existsId(searchId) {
    for (let product of Object.values(productsArray)) {
        if (product.id === searchId) return true;
    }
    return false;
}