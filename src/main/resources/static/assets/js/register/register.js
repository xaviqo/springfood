async function createAccount() {

    let customerInfo = {};
    let splitedNameSurname = "";
    let nameSurname = "";
    let repeatPassword = "";

    nameSurname = $("#nameSurname").val();
    customerInfo.email = $("#emailTxt").val();
    customerInfo.phone = $("#phoneTxt").val();
    customerInfo.city = $("#cityTxt").val();
    customerInfo.street = $("#streetTxt").val();
    customerInfo.password = $("#inputPassTxt").val();

    repeatPassword = $("#repeatPassTxt").val();

    splitedNameSurname = nameSurname.trim().split(/\s+/);

    customerInfo.name = splitedNameSurname[0];
    customerInfo.surname = splitedNameSurname[1];


    if (repeatPassword != customerInfo.password) {
        alert("Passwords do not match!");
        return;
    }

    const request = await fetch('api/account', {
        method: 'POST',
        headers: getHeaders(),
        body: JSON.stringify(customerInfo)
    });

}