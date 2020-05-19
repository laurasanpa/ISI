package main.java;

import main.java.ScrapSarenza;

import java.io.IOException;
import java.util.ArrayList;
import main.java.ScrapUlanka;

public class ProcesarDatos {
  private String nom_zapatilla;
  private ArrayList<Zapatilla> zapas;
 
  
  public ProcesarDatos(String nombre){
	  nom_zapatilla=nombre;
  }
  
  public ArrayList<Zapatilla> getZapatillas(){
	  return zapas;
  }
  
  public void  busqueda() throws IOException {
	  System.out.println("<h5>Entro en busqueday</h5>");
	//Añadimos a zapas las zapatillas encontradas en Sarenza.
	  ScrapSarenza scrapS = new ScrapSarenza();
	  scrapS.busquedaSarenza(nom_zapatilla, zapas);
	  System.out.println("<h5>Termino Sarenza</h5>");
	  //Añadimos a zapas las zapatillas encontradas en Ulanka.
	  ScrapUlanka scrapU = new ScrapUlanka();
	  scrapU.busquedaUlanka(nom_zapatilla, zapas);
	  //Añadimos las zapatillas de Amazon.
	  //*******************************************************************************//
  }
    
}