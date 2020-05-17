package main.java;

import java.util.ArrayList;

public class Zapatilla {
	  private String nombre;
	  private String imagen;
	  private String precio;
	  private String vendedor;
	  private String link;
	  
	  public Zapatilla() {
		  
	  }
	  
	  public Zapatilla(ArrayList<String> datos) {
		  this.nombre=datos.get(4);
		  this.imagen=datos.get(3);
		  this.precio=datos.get(2).substring(4);
		  this.link=datos.get(1);
		  this.vendedor="Amazon";
		  
	  }
	  
	  
	  public String getNombre() {
	    return nombre;
	  }
	  
	  public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }
	  
	  public String getImagen() {
	    return imagen;
	  }
	  
	  public void setImagen(String imagen) {
	    this.imagen = imagen;
	  }
	  
	  public String getPrecio() {
			return precio;
		}
		
		public void setPrecio(String precio) {
			this.precio = precio;
		}
		
		public String getLink() {
			return link;
		}
		
		public void setLink(String link) {
			this.link = link;
		}

		public String getVendedor() {
			return vendedor;
		}

		public void setVendedor(String vendedor) {
			this.vendedor = vendedor;
		}
	}
