$(document).ready(function () {
    // loadAllOrders();
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
        'Authorization': localStorage.token
    };
}

// async function loadAllOrders() {

//     const request = await fetch('api/personas', {
//         method: 'GET',
//         headers: getHeaders()
//     });
//     const personaRequest = await request.json();


//     let fullPersonaHTML = '';
//     personaRequest.forEach(persona => {

//         let idHTML = `<tr><td>${persona.id}</td>`
//         let nameHTML = `<td>${persona.name}</td>`
//         let surnameHTML = `<td>${persona.surname}</td>`
//         let emailHTML = `<td>${persona.email}</td>`
//         let phoneHTML =`<td>${persona.phone}</td>`
//         let delButtonHTML = `<td><a href="#" onclick="deletePersona(${persona.id})" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>`

//         fullPersonaHTML += idHTML+nameHTML+surnameHTML+emailHTML+phoneHTML+delButtonHTML;
//     });

//     document.querySelector('#personas').outerHTML = fullPersonaHTML;
//     $('#registeredClients').append(`<b>${Object.keys(personaRequest).length}`);

// }

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