package com.apps.db.model;

import java.sql.Connection;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.zkoss.zul.Messagebox;

public class DBSQLConnection {

	public Connection openConnection() {
		
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/apps");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			Messagebox.show("Conexao falhou.. "+e.getMessage());
			
		}
		return conn;
	}
	
	
}
