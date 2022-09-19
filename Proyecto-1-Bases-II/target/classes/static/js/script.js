function selectBackground(direccion){
    let body = document.getElementById("body");
    body.style.backgroundImage = `url('${direccion}')`;
    document.getElementById("panel").style.display = "none";
}

function configButton(){
    document.getElementById("panel").style.display = "flex";
}

function hideButton(){
    document.getElementById("panel").style.display = "none";
}