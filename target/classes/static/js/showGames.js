(function(){
    let juegos = document.getElementById("games").value;
    let Arr = juegos.split(",");
    console.log(Arr);

    Arr.forEach(juego =>{
        let juegoRecord = document.createElement("div");
        let icon = document.createElement("i");
        let text = document.createElement("p");
        text.textContent = juego;
        juegoRecord.className += "item";
        icon.className += "fa-solid fa-gamepad";
        juegoRecord.appendChild(icon);
        juegoRecord.appendChild(text);
        if(juego != " " && juego != "")
            document.getElementById("juegosList").appendChild(juegoRecord);
    });
})();


(function(){
    let razas = document.getElementById("razas").value;
    let Arr = razas.split(",");
    console.log(Arr);

    Arr.forEach(raza =>{
        let razaRecord = document.createElement("div");
        let icon = document.createElement("i");
        let text = document.createElement("p");
        razaRecord.className += "item";
        icon.className += "fa-solid fa-id-badge";
        razaRecord.appendChild(icon);
        text.textContent = raza;
        razaRecord.appendChild(text);
        if(raza != " ")
            document.getElementById("razaList").appendChild(razaRecord);
    });
})();