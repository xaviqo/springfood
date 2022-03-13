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

    const request = await fetch('api/orders/getOrderLines/' + id, {
        method: 'GET',
        headers: getHeaders()
    });
    const specificOrderRequest = await request.json();

    let orderInLinesHTML = '';
    let fakeLineId = 0;
    let orderId = 0;

    specificOrderRequest.forEach(line => {

        orderId = line.order;

        fakeLineId++;

        let lineHTML = `<tr><td>${fakeLineId}</td>`
        let prodIdHTML = `<td>${line.product}</td>`
        let prodNameHTML = `<td>${line.product}</td>`
        let amountHTML = `<td>${line.amount}</td>`
        let lineSaleHTML = `<td>${line.sale}%</td>`
        let totalLineSaleHTML = `<td>${line.totalSale}</td>`
        let linModButtonHTML = `<td><a href="#" onclick="modifyLine(${line.id})" class="btn btn-warning btn-circle btn-sm"><i class="fa-solid fa-gear"></i></a>`
        let linDelButtonHTML = `<a href="#" onclick="deleteLine(${line.id})" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>`

        orderInLinesHTML += lineHTML + prodIdHTML + prodNameHTML + amountHTML + lineSaleHTML + totalLineSaleHTML + linModButtonHTML + linDelButtonHTML;

    });

    document.querySelector('#selectedLineText').innerHTML = `Mostrando <strong>${fakeLineId}</strong> línea del pedido <strong>${orderId}</strong>`;
    document.querySelector('#specificOrderInput').innerHTML = orderInLinesHTML;

}
