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


//CREAR NOTA
function crearNota() {

    titulo = document.getElementById("tituloNota").value
    content = document.getElementById("contenidoNota").value
    categ = document.getElementById("categoriaNota").value
    fec1 = document.getElementById('selectTiempo1').value
    var mes1=fec1.substring(5,7)
    console.log(mes1)
    var anno1=fec1.substring(0,4)
    console.log(anno1)
    var dia1=fec1.substring(8,10)
    console.log(dia1)
    
    fec2 = document.getElementById('selectTiempo2').value
    /*var mes2=fec2.substring(5,7)
    console.log(mes2)
    var anno2=fec2.substring(0,4)
    console.log(anno2)
    var dia2=fec2.substring(8,10)
    console.log(dia2)
    */
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
    
    /*
    const nota= document.createElement('div')
    nota.className='col'
    nota.style = 'border-bottom: 1px solid rgba(0, 0, 0, 0.507); margin-right:30px;'

    const tiempo = document.createElement('p')
    tiempo.innerText = fec
    tiempo.style = 'text-align: right; padding-right: 30px;'

    const title = document.createElement('li')
    title.innerText = titulo
    title.className = 'card-title'
    title.style='font-size:15px; font-weight: bold;'
    
    const contenido =document.createElement('p') 
    contenido.innerText=content
    contenido.style='word-wrap:break-word; font-size:15px; margin-right: 60px; width: 50%'



    fragment.appendChild(nota)  
    if(!lista_notas.hasChildNodes()) { lista_notas.appendChild(fragment) }
    else { lista_notas.insertBefore(fragment,lista_notas.children[0]) }
    
    nota.appendChild(title)
    nota.appendChild(contenido)
    nota.appendChild(tiempo)
    */
    document.getElementById("tituloNota").value=""
    document.getElementById("contenidoNota").value=""
    document.getElementById("selectTiempo1").value=""
    document.getElementById("selectTiempo2").value=""
}
crear_nota.addEventListener('click', crearNota, true)

//CARGAR CATEGORIAS DEL FORMULARIO

for (const c of categorias) {
    const selectItem = document.createElement('option')
    selectItem.setAttribute('value', c.toLowerCase())
    selectItem.textContent = c
    fragment2.appendChild(selectItem)
}
categ_form.appendChild(fragment2)

