$(document).ready(function () {

    getPurchases();

    //UPDATE LIVE TIME CARD OF ADMIN DASHBOARD
    document.querySelector('#insertCurrentTime').innerHTML = currentTime() 
    setInterval( function () {
        document.querySelector('#insertCurrentTime').innerHTML = currentTime() 
    }, 1000);

    $('#dataTablePurchases').DataTable({
        "bLengthChange": false,
        "searching": false,
        "info": false
    });

});

async function getPurchases() {

    const request = await fetch('api/dashboard/getAllPurchaseDto', {
        method: 'GET',
        headers: getHeaders()
    });
    const purchasesRequest = await request.json();

    let purchaseListHTML = '';
    let remainPurchases = 0;
    let percent;
    let purchaseStatus = "";
    let totalEarnings = 0;

    purchasesRequest.forEach(purchase => {

        if (purchase.delivered == true) {
            purchaseStatus = `<td class="table-success table-active innerButtonpurchaseList">Delivered &nbsp &nbsp<i class="fa-solid fa-toggle-on"></i></td>`;
        } else {
            remainPurchases++;
            purchaseStatus = `<td class="table-danger table-active innerButtonpurchaseList" >Pending &nbsp &nbsp<i class="fa-solid fa-toggle-off"></i></td>`;
        }

        //SUM TOTAL EARNINGS
        totalEarnings += purchase.purchaseTotal;

        //TODO: Arreglar problema width datatables

        let idHTML = `<tr><td>${purchase.purchaseId}</td>`
        let TimeStampHTML = `<td>${parseTime(purchase.date)}</td>`
        let clientHTML = `<td>${purchase.customerName}</td>`
        let phoneHTML = `<td>${purchase.phone}</td>`
        let CityStreetHTML = `<td>${purchase.street} (${purchase.city.cityName})</td>`
        let totalHTML = `<td>${purchase.purchaseTotal}€ / ${purchase.discount}%</td>`
        let stateHTML = purchaseStatus;
        let linButtonHTML = `<td class="innerButtonPurchaseList"><a href="#" onclick="viewPurchase(${purchase.purchaseId})" class="btn btn-info btn-circle btn-sm"><i class="fa-solid fa-clipboard-list"></i></i></a>`
        let modButtonHTML = `<a href="#" onclick="modifyPurchase(${purchase.purchaseId})" class="btn btn-warning btn-circle btn-sm"><i class="fa-solid fa-pen-to-square"></i></a>`
        let delButtonHTML = `<a href="#" onclick="deletePurchase(${purchase.purchaseId})" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>`

        purchaseListHTML += idHTML + TimeStampHTML + clientHTML + phoneHTML + CityStreetHTML + totalHTML + stateHTML + linButtonHTML +  modButtonHTML + delButtonHTML;

    });
    
    //UPDATE REMAINING ORDERS CARD (Has to be over percent card)
    percent = Math.round((remainPurchases/Object.keys(purchasesRequest).length)*100);
    document.querySelector('#remainingPercent').innerHTML = `${100-percent}%`;
    document.querySelector('#remainTotal').innerHTML = `${remainPurchases} orders`;

    //UPDATE RAMINING PERCENT CARD
    document.querySelector('#purchaseListInput').innerHTML = purchaseListHTML;
    document.querySelector('#remainingPurchasesBar').innerHTML = `<div class="progress-bar progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: ${100-percent}%"></div>`;

    //UPDATE TOTAL EARNINGS CARD
    document.querySelector('#insertTotalEarnings').innerHTML = `${totalEarnings}€ from a total of ${Object.keys(purchasesRequest).length} orders`;
}

// function getUserEmail() {
//     document.querySelector('#txtUserEmail').innerHTML=localStorage.email;
// }

// async function deletePersona(id) {

//     if (!confirm(`Do you want to delete client with id ${id}?`)) {
//         return;
//     }

//     const request = await fetch('api/personas/' + id, {
//         method: 'DELETE',
//         headers: getHeaders()
//     });

//     location.reload()
// };