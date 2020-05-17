package main.java;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ProcesarDatos {
  private Document doc;
  private int n_prod;
  
  public ProcesarDatos(ArrayList<Zapatilla> zapas, String html, int num_prod) {
	  doc = Jsoup.parse(html);
	  n_prod = num_prod;
  }

  public Document getDoc(){
	  return this.doc;
	  
  }
  
  public int getNProd(){
    return this.n_prod;
  }
  
  public void procesarDatosJD(Zapatilla product, String html_cu) {
	Document doc_JD = Jsoup.parse(html_cu);
	Elements links_JD = doc_JD.select("h4.name > a");
	Elements names_JD = doc_JD.select("h4.name");
	Elements prices_JD = doc_JD.select("span.product-price");
	ArrayList<String> ofertas = new ArrayList<String>();
	ComparaCadenas compara = new ComparaCadenas(product.getNombre());
	int maximo = 0;
	int indice = 0;
	String precio_JD = "";
	String enlace_JD = "";
	
	for(int i=0; i < names_JD.size() && maximo < 3; i++){
		  int valor = compara.indCoincide(names_JD.get(i).text());
	      if(valor > maximo) {
	    	  maximo = valor;
	    	  indice = i;
	      }
	}		
	
	if (prices_JD.size() != 0 && maximo >= 3){
		enlace_JD = links_JD.get(indice).attr("href");
		precio_JD = prices_JD.get(indice).text();
		ofertas.add(null);
		ofertas.add(enlace_JD);
		ofertas.add(precio_JD);
		product.addOferta(ofertas, "JD");
	}
 }
  
  public void procesarDatosAsos(Zapatilla product, String html_cu) {
		Document doc_Asos = Jsoup.parse(html_cu);
		Elements links_Asos = doc_Asos.select(" h3 > a");
		Elements prices_Asos = doc_Asos.select("span.price");
		Elements names_Asos = doc_Asos.select("h3.s_title_block");
		ArrayList<String> ofertas = new ArrayList<String>();
		ComparaCadenas compara = new ComparaCadenas(product.getNombre());
		int maximo = 0;
		int indice = 0;
		String precio_Asos = "";
		String enlace_Asos = "";
		
		for(int i=0; i < names_Asos.size() && maximo < 3; i++){
			  int valor = compara.indCoincide(names_Asos.get(i).text());
		      if(valor > maximo) {
		    	  maximo = valor;
		    	  indice = i;
		      }
		}		
		
		if (prices_Asos.size() != 0 && maximo >= 3){
			enlace_Asos = links_Asos.get(indice).attr("href");
			precio_Asos = prices_Asos.get(indice).text();
			ofertas.add(null);
			ofertas.add(enlace_Asos);
			ofertas.add(precio_Asos);
			product.addOferta(ofertas, "Asos");
		}
		
  }
  
}