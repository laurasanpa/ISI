package main.java;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/*
@WebServlet(
    name = "ShoesOffer",
    urlPatterns = {"/shoesoffer"}
)

public class ShoesOffer extends HttpServlet {
	
	public InterfazDatos scrapPZ = new ScrappingPZ();
	public InterfazDatos scrapT2P = new ScrapingT2P();
	public InterfazDatos scrapPS = new ScrappingPS();
	private ArrayList<Zapatilla> zapas = new ArrayList<Zapatilla>();
	
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException {
    zapas = new ArrayList<Zapatilla>(); 
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    AmazonProducts amazon_products;
    ArrayList<String> datos_amazon = new ArrayList<String>();
    IntegracionDatos intDatos = new IntegracionDatos(zapas,scrapPZ.query(request.getParameter("query")), 10);
    intDatos.procesarDatosPZ(Palas, scrapPZ.query(request.getParameter("query")));
    
    for(int i=0; i< zapas.size(); i++) {
	    zapas p = zapas.get(i);
	    intDatos.procesarDatosT2P(p, scrapT2P.query(p.getNombre()));
	    intDatos.procesarDatosPS(p, scrapPS.query(p.getNombre()));
    }
    
    
    for(int i=0; i < zapas.size(); i++) {
    	amazon_products = new AmazonProducts(zapas.get(i).getNombre());
	    datos_amazon = null;
	    try {
			datos_amazon = amazon_products.getInformacion();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	    if(!datos_amazon.isEmpty())
	    	zapas.get(i).setOferta(datos_amazon, 0, "Amazon");
    }
    
    request.setAttribute("MatchedProducts", zapas);
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    try {
		dispatcher.forward(request, response);
	} catch (ServletException e) {
		e.printStackTrace();
	}
  }
}*/