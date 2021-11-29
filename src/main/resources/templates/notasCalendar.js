crear_nota = document.getElementById('creaNota')
categ_form = document.getElementById('categoriaNota')
fache_nota = document.getElementById('selectTiempo')
fragment = document.createDocumentFragment()
fragment2 = document.createDocumentFragment()
categorias = ["Trabajo", "Estudio", "Lista de compras", "Deberes", "Deporte", "Música", "Salud", "Viaje", "Libro", "Restaurante"]

const meses = [
    "Jaunary",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
]

titulo = ""
content = ""
modificado = ""
categ = ""

newEventoVarios(titulo, content, categ, fec1, fec2);


//CREAR NOTA
window.onload =  function crearNota() {

   titulo = document.getElementById("tituloN").value
    content = document.getElementById("contenidoN").value
    categ = document.getElementById("categoriaN").value
    fec1 = document.getElementById('selectTiempo1').value
   fec2 = document.getElementById('selectTiempo2').value
    
    
    
    console.log(fec1)
    console.log(fec2)
    console.log(content)
    console.log(categ)
    console.log(titulo)

    var par1= ""+meses[parseInt(mes1,10)]+"/"+dia1+"/"+anno1+""
    console.log(par1)
    /*var par2= ""+meses[parseInt(mes2,10)]+"/"+dia2+"/"+anno2+""
    console.log(par2)*/
    if (fec2=="") {
        newEvento(titulo, content, categ, fec1)
    } else {
        newEventoVarios(titulo, content, categ, fec1, fec2)
    }
    
   
    document.getElementById("tituloNota").value=""
    document.getElementById("contenidoNota").value=""
    document.getElementById("selectTiempo1").value=""
    document.getElementById("selectTiempo2").value=""
}
//crear_nota.addEventListener('click', crearNota, true)

//CARGAR CATEGORIAS DEL FORMULARIO

for (const c of categorias) {
    const selectItem = document.createElement('option')
    selectItem.setAttribute('value', c.toLowerCase())
    selectItem.textContent = c
    fragment2.appendChild(selectItem)
}
categ_form.appendChild(fragment2)

