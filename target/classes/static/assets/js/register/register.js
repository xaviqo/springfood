async function createAccount(){

    const request = await fetch('api/order/getProductCart/' + id, {
        method: 'GET',
        headers: getHeaders()
    });

    const productJSON = await request.json();

}