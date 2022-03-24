async function createAccount(){

    let customerInfo = {};

    const request = await fetch('api/order/getProductCart/' + id, {
        method: 'GET',
        headers: getHeaders(),
        body: JSON.stringify(customerInfo)
    });

    const productJSON = await request.json();

}