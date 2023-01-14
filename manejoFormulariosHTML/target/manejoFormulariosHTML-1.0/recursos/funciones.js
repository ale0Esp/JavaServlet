function validarForma(forma){
    var usuario = forma.usuario;
    if(usuario.value === ""|| usuario.value==="Escribir usuario"){
        alert("Debe proporcionar un usuario");
    }
}