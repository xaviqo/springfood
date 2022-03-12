$(document).ready(function () {
    getOrders();
    $('#dataTableOrders').DataTable({
        "bLengthChange": false,
        "searching": false,
        "language": {
            "decimal": "",
            "emptyTable": "No hay pedidos pendientes",
            "info": "Mostrando _START_ / _END_ de un total de _TOTAL_ pedidos",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Mostrar _MENU_ pedidos",
            "loadingRecords": "Cargando pedidos...",
            "processing": "Procesando pedidos...",
            "search": "Buscar:",
            "zeroRecords": "No se han encontrado coincidencias",
            "paginate": {
                "first": "Primero",
                "last": "Ultimo",
                "next": "Siguente",
                "previous": "Previo"
            },
            "aria": {
                "sortAscending": ": activar para ordenar columnas ascendentes",
                "sortDescending": ": activar para ordenar columnas descendentes"
            }
        }
    });

    // getUserEmail();
});

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        // 'Authorization': localStorage.token
    };
}

async function getOrders() {

    const request = await fetch('api/orders/getOrders', {
        method: 'GET',
        headers: getHeaders()
    });
    const personaRequest = await request.json();

    let orderListHTML = '';

    let remainOrders = 0;
    let percent;

    personaRequest.forEach(order => {

        if (order.state == true) remainOrders++;

        //TODO: IF order.state = true X if order.state = false Y
        //TODO: Implementar direccion en base a cliente (street y city)

        let idHTML = `<tr><td>${order.id}</td>`
        let clientHTML = `<td>${order.client}</td>`
        let TimeStampHTML = `<td>${order.date}</td>`
        let CityStreetHTML = `<td>TODO</td>`
        let LineSizeHTML = `<td>${order.lines}</td>`
        let totalHTML = `<td>${order.total}</td>`
        let saleHTML = `<td>${order.sale}</td>`
        let stateHTML = `<td>${order.state}</td>`
        let delButtonHTML = `<td><a href="#" onclick="deletePersona(${order.id})" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>`

        orderListHTML += idHTML + clientHTML + TimeStampHTML + CityStreetHTML + LineSizeHTML + totalHTML + saleHTML + stateHTML + delButtonHTML;

    });

    percent = Math.round((remainOrders/Object.keys(personaRequest).length)*100);

    document.querySelector('#orderListInput').outerHTML = orderListHTML;

    document.querySelector('#remainingOrdersBar').innerHTML = `<div class="progress-bar progress-bar progress-bar-striped progress-bar-animated" role="progressbar" style="width: ${100-percent}%"></div>`;
    document.querySelector('#remainingPercent').innerHTML = `${100-percent}%`;
    document.querySelector('#remainTotal').innerHTML = `${remainOrders} Pedidos`;

    // $('#registeredClients').append(`<b>${Object.keys(personaRequest).length}`);

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