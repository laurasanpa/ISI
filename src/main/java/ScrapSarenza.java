package main.java;


import org.jsoup.Jsoup;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ScrapSarenza{
	
	private String inicial  = "https://www.sarenza.es/";
	private int n_prod =5;
	
	
    public static int getStatusConnectionCode(String url) throws IOException {
		
        Response response = null;
		
        response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        return response.statusCode();
    }
	
	public static Document getHtmlDocument(String url) throws IOException {

        Document doc = null;

        doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();

        return doc;

    }
	
	public void busquedaSarenza (String request, ArrayList<Zapatilla> zapas) throws IOException{
		//Pruebo solo a meter una 
		Zapatilla z = new Zapatilla();
		zapas.add(z);
		/*
		String words[] = request.split(" ");
		words[0]="store/product/search/list/view?origin=s&search="+words[0];
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
		if (getStatusConnectionCode(url) == 200) {
		
		Document doc_Sarenza = getHtmlDocument(url);
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
		
		for(int i=0; i < names_Sarenza.size() && i < n_prod; i++){
			Zapatilla aux = new Zapatilla();
			aux.setNombre(nombres_Sarenza.get(i));
			aux.setImagen(imagenes_Sarenza.get(i));//i*2
			aux.setPrecio(precios_Sarenza.get(i));
			aux.setLink(enlaces_Sarenza.get(i));
			aux.setVendedor("Sarenza");
			zapas.add(aux);
			}
		}*/
	}
		

}

