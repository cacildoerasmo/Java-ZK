package com.apps.controller;

import java.sql.*;

import org.zkoss.zul.*;

import com.apps.db.model.DBSQLConnection;
import com.apps.db.model.LivrariaModel;


import org.zkoss.zhtml.Pre;

public class livraria extends Window{

	public void saveitem(String autor, String editora, String assunto, String valor) throws Exception {
		
		String SQL ="INSERT INTO livro(autor, editora, assunto, valor) VALUES (?,?,?,?)";
		
		Connection Conn = new DBSQLConnection().openConnection();
		PreparedStatement prep = Conn.prepareStatement(SQL);
		
		prep.setString(1, autor);
		prep.setString(2, editora);
		prep.setString(3, assunto);
		prep.setString(4, valor);
		prep.executeUpdate();
		
		Conn.close();
		Messagebox.show("Livro cadastrado com Sucesso!!!");
		
		viewlist();
	}
	
	public void viewlist() throws Exception {
		
		Listbox lb = (Listbox)this.getFellow("listData");
		lb.getItems().clear();
		
		String SQL = "SELECT * FROM livro order by id_livro";
		
		Connection Conn = new DBSQLConnection().openConnection();
		Statement st = Conn.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		
		while(rs.next()) {
			
			Listitem li = new Listitem();
			li.setValue(rs.getString("id_livro"));
	        li.appendChild(new Listcell(rs.getString("id_livro")));
	        li.appendChild(new Listcell(rs.getString("autor")));
	        li.appendChild(new Listcell(rs.getString("editora")));
	        li.appendChild(new Listcell(rs.getString("assunto")));
	        li.appendChild(new Listcell(rs.getString("valor")));
	        lb.appendChild(li);
	     
			
		}
		rs.close();
		st.close();
		Conn.close();
	
			
		}
	public void delete(String id) throws Exception {
		
		String SQL ="delete from livro where id_livro = ?";
		
		Connection Conn = new DBSQLConnection().openConnection();
		PreparedStatement prep = Conn.prepareStatement(SQL);
		
		prep.setString(1, id);
		
		prep.executeUpdate();
		
		Conn.close();
		Messagebox.show("Livro eliminado com Sucesso!!!");
		
		viewlist();
	}
	


}
