package main.java;
import java.util.ArrayList;

public class Zapatilla {
	  private String nombre;
	  private String imagen;
	  private String valoracion;
	  private ArrayList<Oferta> ofertas;
	  
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
	  
	  public String getValoracion() {
	    return valoracion;
	  }
	  
	  public void setValoracion(String valoracion) {
	    this.valoracion = valoracion;
	  }

	  public ArrayList<Oferta> getOfertas() {
		return ofertas;
	  }

	  public void setOfertas(ArrayList<Oferta> ofertas) {
		this.ofertas = ofertas;
	  }
	  
	  public void setOferta(ArrayList<String> oferta, int i, String vendedor) {
		 this.ofertas.get(i).setPrecio(oferta.get(2).substring(4));
		 this.ofertas.get(i).setEnlace(oferta.get(1));
		 this.ofertas.get(i).setVendedor(vendedor);
	  }

	  public void addOferta(ArrayList<String> datos, String vendedor) {
		  Oferta oferta = new Oferta();
		  oferta.setVendedor(vendedor);
		  oferta.setEnlace(datos.get(1));
		  oferta.setPrecio(datos.get(2));
		  ofertas.add(oferta);
	  }
}
