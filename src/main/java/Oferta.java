package main.java;

public class Oferta {
	private String precio;
	private String vendedor;
	private String enlace;
	
	
	public Oferta() {
		  precio = null;
		  vendedor=null;  
		  enlace= null;
		  
	  }

	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getEnlace() {
		return enlace;
	}
	
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getTienda() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

}
