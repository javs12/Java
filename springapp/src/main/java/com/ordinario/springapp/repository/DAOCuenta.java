package com.ordinario.springapp.repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.PreparedStatement;
import com.ordinario.springapp.bean.Cuenta;
import com.ordinario.springapp.bean.Perfil;
import com.ordinario.springapp.bean.Persona;




public class DAOCuenta implements DAOInterfaz {

		
	 	private DataSource data;
	 
	 	
	 	
	 	private Connection con;
	 	
	 	private Cuenta cuenta ;
	 	
	 	private Persona persona ;
	 	
	 	private Perfil perfil;
	 	
	 	private ArrayList<Cuenta> lista;
	 	private ApplicationContext context;
	 	
	   
	    
	    private static final String logueo = 
	            "SELECT id FROM cuenta where contrasena=? and usuario=?"; 
	            
	
	    private static final String cuentas = "SELECT C.id, C.usuario,"
				+ " C.contrasena, C.cuentaActiva, P.nombre, "
				+ "P.fechaNacimiento, P.sexo, R.nombre, R.descripcion"
				+ " FROM cuenta C, persona P, perfil R where "
				+ "C.persona_id=P.id and C.perfil_id=R.id group by C.id order by C.id";
	
	
	public Boolean usuario(String user,String pass) throws SQLException{

		con=data.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(logueo);
		ps.setString(1, pass);
		ps.setString(2, user);
		ResultSet r = ps.executeQuery();
			
		
			
		
		return r.next();
	}
	
	
	public ArrayList<Cuenta> cuentas() throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(cuentas);
		ResultSet r = ps.executeQuery();
		context = new ClassPathXmlApplicationContext(new String[] {"app-config.xml"});
		lista=context.getBean("lis",ArrayList.class);
		
		while(r.next()){
			
			
			   
			  cuenta = context.getBean("cuenta",Cuenta.class);
			  perfil = context.getBean("perfil",Perfil.class);
			  persona = context.getBean("persona",Persona.class);
			
			cuenta.setId(r.getString(1)+"");
			cuenta.setUsuario(r.getString(2));
			cuenta.setContrasena(r.getString(3));
			cuenta.setUsuarioActivo(r.getString(4));
			
			
			persona.setNombre(r.getString(5));
			persona.setFechaNacimiento(r.getString(6));
			persona.setSexo(r.getString(7));
			
			
			perfil.setNombre(r.getString(8));
			perfil.setDescripcion(r.getString(9));
			
			cuenta.setPersona(persona);
			cuenta.setPerfil(perfil);
			
			lista.add(cuenta);

		}
		return lista;
	}
	
	public void setData(DataSource data) {
		this.data = data;
	}


	
	public void setLista(ArrayList<Cuenta> lista) {
		this.lista = lista;
	}
	
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public ArrayList<Cuenta> getLista() {
		return lista;
	}


	


	

	
	
	
}
