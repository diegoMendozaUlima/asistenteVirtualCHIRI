function validar(){
    var username=document.getElementById("Username").value;
    var password=document.getElementById("Password").value;
    var dict = []; 

    dict.push({ 
        key: "admin",
        value: "12345"}
    );
    dict.push({ 
        key: "admin1",
        value: "12346"}
    );

    for (var i = 0; i < dict.length;  i++){
        if(dict[i].key == username && dict[i].value == password){
            alert("Login cool");
            break;
        }
        if(dict[i].key == null){
            alert("Login faild");
        }
        else if(dict[i].key != null && dict[i].value != password){
            alert("La contraseña no es correcta");
        }
    }

}