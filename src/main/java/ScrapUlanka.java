package main.java;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ScrapUlanka{
	
	private String inicial  = "https://www.ulanka.com/";
	private int n_prod =5;
	
	public static Document getHtmlDocument(String url) throws IOException {

        Document doc = null;

        doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();

        return doc;

    }
	
	public void busquedaUlanka (String request, ArrayList<Zapatilla> zapas) throws IOException{
		
		String words[] = request.split(" ");
		words[0]="buscar/?q="+words[0];
		if(words.length > 1){
			words[0] += "+" + words[1];
			if(words.length > 2)
				words[0] += "+" + words[2];
			if(words.length > 3)
				words[0] += "+" + words[3];
			if(words.length > 4)
				words[0] += "+" + words[4];
		}
		String url=inicial+words[0];
		
		Document doc_Ulanka = getHtmlDocument(url);
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
		
		for(int i=0; i < names_Ulanka.size() && i < n_prod; i++){
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

