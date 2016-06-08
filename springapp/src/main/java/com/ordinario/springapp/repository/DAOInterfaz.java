package com.ordinario.springapp.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ordinario.springapp.bean.Cuenta;



public interface DAOInterfaz {
	
	
	public Boolean usuario(String u, String c) throws SQLException;
	public ArrayList<Cuenta> cuentas() throws SQLException;

}
