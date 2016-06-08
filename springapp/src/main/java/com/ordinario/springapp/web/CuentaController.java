package com.ordinario.springapp.web;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ordinario.springapp.bean.Cuenta;
import com.ordinario.springapp.bean.Perfil;
import com.ordinario.springapp.bean.Persona;
import com.ordinario.springapp.repository.DAOCuenta;



@Controller
public class CuentaController {
	
	@Autowired
	DAOCuenta cuenta;
	
	
	
	@RequestMapping(value = "/logueo.ordi")
	public String inicio() {
		

	      return "logueo";
	   }
	
	   
	 	@RequestMapping(value = "/resultado.ordi",method = RequestMethod.GET)
		public String listar(){
			  return "redirect:/logueo.ordi";
		}
	
	   @RequestMapping(value = "/resultado.ordi",method = RequestMethod.POST)
	   public String listar(@RequestParam("u") String u,@RequestParam("c") String c,ModelMap model) {
		   String s = "result";
		   
		   
		 
		  try {
			  
			 
			if(cuenta.usuario(u, c)){

				
				model.addAttribute("cuentas", cuenta.cuentas());
				
			  }else{
				  
				  s="redirect:/logueo.ordi";
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   System.out.println(s);
		   return s;
	   }

	

	public void setCuenta(DAOCuenta cuenta) {
		this.cuenta = cuenta;
	}

	   
	   
	   
	   
	   

	   
	   
	   
	   
}
