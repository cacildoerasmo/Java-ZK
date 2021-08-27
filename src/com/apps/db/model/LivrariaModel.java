package com.apps.db.model;

public class LivrariaModel {

	private String autor;
	private String editora;
	private String assunto;
	private String valor;
	
	
	
	

	public LivrariaModel(String autor, String editora, String assunto, String valor) {
		super();
		this.autor = autor;
		this.editora = editora;
		this.assunto = assunto;
		this.valor = valor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public static void main(String[] args) {
	
		

	}

}
