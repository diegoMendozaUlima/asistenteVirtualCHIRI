package com.example.demo;

import java.sql.Connection;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
	
	
	  @GetMapping("/crearNota")
	  public String greetingForm(Model model) {
		    model.addAttribute("notaCreada", new ValueNota());
		    return "Pizarra_de_notas";
		  }
	
	   @PostMapping("/crearNota")
	   public String crearNota(@ModelAttribute ValueNota notaCreada, Model model) throws SQLException {
		    model.addAttribute("notaCreada",  notaCreada);
		    ConexionBD conectar = new ConexionBD();
		    Connection conectarDeveloper = conectar.conexionSQLDeveloper();
		    System.out.println(notaCreada.getTitulo());
		    System.out.println(notaCreada.getContenido());
		    String consulta = "INSERT INTO NOTA (Titulo, Contenido, Categoria, Prioridad, id_Usuario) values "
		    		+ "('" + notaCreada.getTitulo() + "','" + notaCreada.getContenido()  +  "','" + notaCreada.getCategoria()  +  "'," +   
		    		"1"  + ", 20)"; 
		    
		    System.out.println(consulta);
		    Statement statement = conectarDeveloper.prepareStatement(consulta);
		    statement.executeUpdate(consulta);
		    statement.close();
		    conectarDeveloper.close();
		   
	       return "redirect:/crearNota"; // you should return the name of a template here.
	   }
	
	   @GetMapping("/calendario")
	   public String calenForm(Model model) {
			    model.addAttribute("eventoCreado", new ValueEvento());
			    return "calendar";
			  }
	   
	   
	   @PostMapping("/calendario")
	   public String crearEvento(@ModelAttribute ValueEvento eventoCreado, Model model) throws SQLException, ParseException {
		    model.addAttribute("eventoCreado",  eventoCreado);
		    ConexionBD conectar = new ConexionBD();
		    Connection conectarDeveloper = conectar.conexionSQLDeveloper();
		    
		    System.out.println(eventoCreado.fechaInicio);
		    System.out.println(eventoCreado.fechaFin);
		    
		    SimpleDateFormat STD1 = new SimpleDateFormat("yyyy-mm-dd");
		    Date d =  null;
		    d = STD1.parse(eventoCreado.fechaInicio);
		    SimpleDateFormat STDP = new SimpleDateFormat("dd/mm/yyyy");
		    
		    STDP.format(d);
		    System.out.println(d);
		    
		    SimpleDateFormat STD2 = new SimpleDateFormat("yyyy-mm-dd");
		    Date d2 = null;
		    d2 = STD2.parse(eventoCreado.fechaFin);
		    SimpleDateFormat STDP2 = new SimpleDateFormat("dd/mm/yyyy");
		    
		    STDP.format(d2);
		    System.out.println(d2);
		    
		    
		    String consulta = "INSERT INTO EVENTO (Titulo, Contenido, Categoria, fechaInicio, fechaFin) values "
		    		+ "('" + eventoCreado.getTitulo() + "','" + eventoCreado.getContenido()  +  "','" + eventoCreado.getCategoria()  +  "','" +   
		    		STDP.format(d) + "','" +  STDP.format(d2) + "')"; 
		    
		    System.out.println(consulta);
		    Statement statement = conectarDeveloper.prepareStatement(consulta);
		    statement.executeUpdate(consulta);
		    statement.close();
		    conectarDeveloper.close();
		   
	       return "redirect:/calendario"; // you should return the name of a template here.
	   }
	

	
	
	
}

