package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;
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
import org.springframework.web.servlet.ModelAndView;

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
	
	 @RequestMapping( value="/login", method=RequestMethod.GET)
	    public String login() {
	        return "Login";
	    }
	
	/* 
	 @RequestMapping("/calendario")
	 public ModelAndView thymeleafView(Map<String, Object> model1) throws SQLException {
	    
		 
		
		 ConexionBD conectar = new ConexionBD();
		 Connection conectarDeveloper = conectar.conexionSQLDeveloper();
		 String consulta = "SELECT * FROM Evento"; 
		 Statement stmt = conectarDeveloper.createStatement();
		 ResultSet rs = stmt.executeQuery(consulta);
		 while (rs.next()) {
			  String tit = rs.getString("titulo");
			  String cont = rs.getString("contenido");
			  String cat = rs.getString("categoria");
			  String fec = rs.getString("fechaIncio");
			  String fec2 = rs.getString("fechaFin");
			  model.put("titulo", tit);
			  model.put("contenido", cont);
			  model.put("categoria", cat);
			  model.put("fecha", fec);
			  model.put("fecha2", fec2);
			  System.out.println("AAAAAAAAAAAAAAAAA");	
			  return new ModelAndView("/calendario");
		 }
		 
	     return new ModelAndView("thymeleaf/calendario");
	 }
	*/
	
	
	  @GetMapping("/crearNota")
	  public String greetingForm(Model model, Model model1) throws SQLException {
		  	ConexionBD conectar = new ConexionBD();
			 Connection conectarDeveloper = conectar.conexionSQLDeveloper();
			 int contador = 1; 
			 String consulta = "SELECT TITULO, CONTENIDO, CATEGORIA, PRIORIDAD FROM NOTA where ROWNUM < 6";
			 //String consulta = "SELECT TITULO, CONTENIDO, CATEGORIA, PRIORIDAD FROM NOTA" ; 
			 Statement stmt = conectarDeveloper.createStatement();
			 ResultSet rs = stmt.executeQuery(consulta);
			 System.out.println(consulta);
			 
			 while (rs.next()) {
				  
				  
				 
				  String tit = rs.getString("titulo");
				  String cont = rs.getString("contenido");
				  String cat = rs.getString("categoria");
				  String pri = rs.getString("prioridad");
				
				  if(contador == 1) { 
				  model1.addAttribute("tit", tit);
				  model1.addAttribute("cont", cont);
				  model1.addAttribute("cat", cat);
				  model1.addAttribute("pri", pri);
				  }
				  
				  else if(contador == 2) {
					  model1.addAttribute("tit2", tit);
					  model1.addAttribute("cont2", cont);
					  model1.addAttribute("cat2", cat);
					  model1.addAttribute("pri2", pri);
					  }
				  
				  else if(contador == 3) {
					  model1.addAttribute("tit3", tit);
					  model1.addAttribute("cont3", cont);
					  model1.addAttribute("cat3", cat);
					  model1.addAttribute("pri3", pri);
					  }
				  
				  else if(contador == 4) {
					  model1.addAttribute("tit4", tit);
					  model1.addAttribute("cont4", cont);
					  model1.addAttribute("cat4", cat);
					  model1.addAttribute("pri4", pri);
					  }
				  
				  else if(contador == 5) {
					  model1.addAttribute("tit5", tit);
					  model1.addAttribute("cont5", cont);
					  model1.addAttribute("cat5", cat);
					  model1.addAttribute("pri5", pri);
					  }
				  
				  
				  
				  System.out.println(tit);
				  System.out.println(cont);
				  System.out.println(rs.getString("categoria"));
				  System.out.println(rs.getString("prioridad"));
				  
				  contador += 1;
				  }
		  
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
	   public String calenForm(Model model, Map<String, Object> model1) throws SQLException {
			    model.addAttribute("eventoCreado", new ValueEvento());
			     ConexionBD conectar = new ConexionBD();
				 Connection conectarDeveloper = conectar.conexionSQLDeveloper();
				 String consulta = "SELECT TITULO, CONTENIDO, CATEGORIA, FECHAINICIO, FECHAFIN FROM EVENTO" ; 
				 Statement stmt = conectarDeveloper.createStatement();
				 ResultSet rs = stmt.executeQuery(consulta);
				 while (rs.next()) {
					  String tit = rs.getString("titulo");
					  String cont = rs.getString("contenido");
					  String cat = rs.getString("categoria");
					 // Date fec = rs.getDate("fechaIncio");
					 // Date fec2 = rs.getDate("fechaFin");
					  
					  model1.put("titulo", tit);
					  model1.put("contenido", cont);
					  model1.put("categoria", cat);
					 // model1.put("fecha", fec);
					 // model1.put("fecha2", fec2);
					  System.out.println(tit);
					  }
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

