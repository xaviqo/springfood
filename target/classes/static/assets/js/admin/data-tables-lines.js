$(document).ready(function () {

    $('#dataTableLines').DataTable({
        "bLengthChange": true,
        "searching": false,
        "bPaginate": false
    });

    
});

async function viewPurchase(id) {

    const request = await fetch('api/dashboard/purchaseLineBy/' + id, {
        method: 'GET',
        headers: getHeaders()
    });
    const specificOrderRequest = await request.json();

    let orderInLinesHTML = '';
    let orderInLinesText = '';
    let fakeLineId = 0;
    let orderId = 0;

    specificOrderRequest.forEach(line => {

        orderId = line.purchase;

        fakeLineId++;

        let lineHTML = `<tr><td>${fakeLineId}</td>`
        let prodNameHTML = `<td>${line.product.name}</td>`
        let amountHTML = `<td>${line.amount}</td>`
        let lineSaleHTML = `<td>${line.discount}%</td>`
        let totalLineHTML = `<td>${line.total}€</td>`
        let linModButtonHTML = `<td><a href="#" onclick="modifyLine(${line.id})" class="btn btn-warning btn-circle btn-sm"><i class="fa-solid fa-gear"></i></a>`
        let linDelButtonHTML = `<a href="#" onclick="deleteLine(${line.id})" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>`

        orderInLinesHTML += lineHTML + prodNameHTML + amountHTML + lineSaleHTML + totalLineHTML + linModButtonHTML + linDelButtonHTML;

    });

    if (fakeLineId > 1){
        orderInLinesText = `Showing <strong>${fakeLineId}</strong> lines of order <strong>${orderId}</strong>`;
    } else if (fakeLineId == 1){
        orderInLinesText = `Showing <strong>${fakeLineId}</strong> line of order <strong>${orderId}</strong>`;
    } else {
        orderInLinesText = `No available lines to show in this order`;
    }

    document.querySelector('#selectedLineText').innerHTML = orderInLinesText;
    document.querySelector('#specificOrderInput').innerHTML = orderInLinesHTML;

}
