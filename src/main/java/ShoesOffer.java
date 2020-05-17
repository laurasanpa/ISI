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
import main.java.Zapatilla;

@WebServlet(
    name = "ShoesOffer",
    urlPatterns = {"https://shoesoffer-272416.appspot.com/"}
)

public class ShoesOffer extends HttpServlet {
	
	public InterfazObtenerDatos scrapUlanka = new ScrapUlanka();
	public InterfazObtenerDatos scrapSarenza = new ScrapSarenza();
	private ArrayList<Zapatilla> zapas = new ArrayList<Zapatilla>();
	
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException {
    zapas = new ArrayList<Zapatilla>(); 
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    AmazonProducts amazon_products;
    ArrayList<String> datos_amazon = new ArrayList<String>();
    ProcesarDatos intDatosUlanka = new ProcesarDatos(zapas,scrapUlanka.query(request.getParameter("query")), 3); 
    ProcesarDatos intDatosSarenza = new ProcesarDatos(zapas,scrapSarenza.query(request.getParameter("query")), 3); 
    
	intDatosUlanka.procesarDatosUlanka(zapas);
	intDatosSarenza.procesarDatosSarenza(zapas);
    
    
    
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
	    if(!datos_amazon.isEmpty()) {
	     Zapatilla aux = new Zapatilla(datos_amazon);
	     zapas.add(aux);
    }
    }
    request.setAttribute("MatchedProducts", zapas);
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    try {
		dispatcher.forward(request, response);
	} catch (ServletException e) {
		e.printStackTrace();
	}
  }
}