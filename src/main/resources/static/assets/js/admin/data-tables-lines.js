$(document).ready(function () {

    $('#dataTableLines').DataTable({
        "bLengthChange": true,
        "searching": false,
        "bPaginate": false,
        "language": {
            "decimal": "",
            "emptyTable": "No hay líneas a mostrar",
            "info": "",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Mostrar _MENU_ líneas",
            "loadingRecords": "Cargando líneas...",
            "processing": "Procesando líneas...",
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
});

async function viewOrder(id) {

    const request = await fetch('api/orders/' + id, {
        method: 'GET',
        headers: getHeaders()
    });
    const specificOrderRequest = await request.json();

    let orderInLinesHTML = '';
    let orderInLinesText = '';
    let fakeLineId = 0;
    let orderId = 0;

    specificOrderRequest.forEach(line => {

        orderId = line.order;

        fakeLineId++;

        let lineHTML = `<tr><td>${fakeLineId}</td>`
        let prodNameHTML = `<td>${line.product.name}</td>`
        let amountHTML = `<td>${line.amount}</td>`
        let lineSaleHTML = `<td>${line.sale}%</td>`
        let totalLineSaleHTML = `<td>${line.totalSale}</td>`
        let linModButtonHTML = `<td><a href="#" onclick="modifyLine(${line.id})" class="btn btn-warning btn-circle btn-sm"><i class="fa-solid fa-gear"></i></a>`
        let linDelButtonHTML = `<a href="#" onclick="deleteLine(${line.id})" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>`

        orderInLinesHTML += lineHTML + prodNameHTML + amountHTML + lineSaleHTML + totalLineSaleHTML + linModButtonHTML + linDelButtonHTML;

    });

    if (fakeLineId > 1){
        orderInLinesText = `Mostrando <strong>${fakeLineId}</strong> líneas del pedido <strong>${orderId}</strong>`;
    } else if (fakeLineId == 1){
        orderInLinesText = `Mostrando <strong>${fakeLineId}</strong> línea del pedido <strong>${orderId}</strong>`;
    } else {
        orderInLinesText = `No hay líneas a mostrar en este pedido`;
    }

    document.querySelector('#selectedLineText').innerHTML = orderInLinesText;
    document.querySelector('#specificOrderInput').innerHTML = orderInLinesHTML;

}
