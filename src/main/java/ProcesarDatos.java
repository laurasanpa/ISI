package main.java;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;


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
  
  public void procesarDatosSarenza(ArrayList<Zapatilla> zapas) {
		Document doc_Sarenza = this.doc;
		Elements names_Sarenza = doc_Sarenza.select("span.model");
		Elements links_Sarenza = doc_Sarenza.select("a[href]");
		Elements prices_Sarenza = doc_Sarenza.select("span.mighty price");
		Elements imgs_Sarenza = doc_Sarenza.select("img[src]");  
		ArrayList<String> nombres_Sarenza = new ArrayList<String>();
		ArrayList<String> enlaces_Sarenza = new ArrayList<String>();
		ArrayList<String> precios_Sarenza = new ArrayList<String>();
		ArrayList<String> imagenes_Sarenza = new ArrayList<String>();

		for(Element e : names_Sarenza){
	      nombres_Sarenza.add(e.text());
		}
		for(Element e : imgs_Sarenza){
	      String aux = e.attr("data-lazy-src");
	      imagenes_Sarenza.add(aux);
		}
		for(Element l : links_Sarenza){
			String aux =l.attr("href");
			enlaces_Sarenza.add(aux);
		}
		for(Element p : prices_Sarenza){
			precios_Sarenza.add(p.text());
		}
		
		for(int i=0; i < names_Sarenza.size() && i < getNProd(); i++){
			Zapatilla aux = new Zapatilla();
			aux.setNombre(nombres_Sarenza.get(i));
			aux.setImagen(imagenes_Sarenza.get(i));//i*2
			aux.setPrecio(precios_Sarenza.get(i));
			aux.setLink(enlaces_Sarenza.get(i));
			aux.setVendedor("Sarenza");
			zapas.add(aux);
		}
	  }
  
  public void procesarDatosUlanka(ArrayList<Zapatilla> zapas) {
	  	Document doc_Ulanka = this.doc;
	  	Elements links_Ulanka = doc_Ulanka.select("h3");
		Elements names_Ulanka = doc_Ulanka.select("href");
		Elements prices_Ulanka = doc_Ulanka.select("strong");
		Elements imgs_Ulanka = doc_Ulanka.select("div.data-image");

		ArrayList<String> nombres_Ulanka = new ArrayList<String>();
		ArrayList<String> enlaces_Ulanka = new ArrayList<String>();
		ArrayList<String> precios_Ulanka = new ArrayList<String>();
		ArrayList<String> imagenes_Ulanka = new ArrayList<String>();

		for(Element e : names_Ulanka){
	      nombres_Ulanka.add(e.text());
		}
		for(Element e : imgs_Ulanka){
	      String aux = e.attr("data-lazy-src");
	      imagenes_Ulanka.add(aux);
		}
		for(Element l : links_Ulanka){
			String aux =l.attr("href");
			enlaces_Ulanka.add(aux);
		}
		for(Element p : prices_Ulanka){
			precios_Ulanka.add(p.text());
		}
		
		for(int i=0; i < names_Ulanka.size() && i < getNProd(); i++){
			Zapatilla aux = new Zapatilla();
			aux.setNombre(nombres_Ulanka.get(i));
			aux.setImagen(imagenes_Ulanka.get(i));//i*2
			aux.setPrecio(precios_Ulanka.get(i));
			aux.setLink(enlaces_Ulanka.get(i));
			aux.setVendedor("Ulanka");
			zapas.add(aux);
		}
	  }
  }