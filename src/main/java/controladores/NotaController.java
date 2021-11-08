package controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Nota;
import com.example.demo.Value;
import com.example.demo.ValueNota;

import baseDatosConexion.ConexionBD;

@Controller
//@RequestMapping(path = "/pizarra")
public class NotaController {
	
	
	 @RequestMapping( value="/", method=RequestMethod.GET)
	    public String home() {
	        return "index";
	    }
	
	
	@RequestMapping(value="/pizarra", method = RequestMethod.GET)
    public String piz(Model model) {
        return "Pizarra/Pizarra_de_notas";
    }
	
	
	@RequestMapping(value = "/agregar", method=RequestMethod.POST)
	public String agregarProducto(Model model) {
	    model.addAttribute("nota", new Nota());
	    return "notas/agregar_nota";
	}
	

	@RequestMapping(value = "/guardar", method=RequestMethod.POST)
	public String guardarProducto(@ModelAttribute ValueNota notaCreada) throws SQLException {
    
	
		ConexionBD conectar = new ConexionBD();
	    Connection conectarDeveloper = conectar.conexionSQLDeveloper();
	    String consulta = "INSERT INTO NOTA (Titulo, Contenido, Categoria, Prioridad, idUsuario) values "
	    		+ "('" + notaCreada.getTitulo() + "','" + notaCreada.getContenido()  +  "','" + notaCreada.getCategoria()  +  "'," +   
	    		notaCreada.getPrioridad() + ", 17)"; 
	    
	    System.out.println(consulta);
	    Statement statement = conectarDeveloper.prepareStatement(consulta);
	    statement.executeUpdate(consulta);
	    statement.close();
	    conectarDeveloper.close();	
		
		return "redirect:/pizarra/";
	}
	
	
}

