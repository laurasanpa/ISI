<%@page import="java.util.ArrayList"%>
<%@page import="main.java.Zapatilla"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ShoesOffer</title>
 	<link rel = "stylesheet" type = "text/css" href = "style.css" />
</head>
	
	<body>
		<header>
	  		<img src="img/logo.png" alt="logo">
	
	  	</header>
	  	<main>
	  		<section id="Buscador">
				<form id="busqueda" method="get" autocomplete="ON">
					<fieldset>
						<label for="buscar"> Buscar:</label>
		                <input type="text" name= "query"/>
		                
		                
		            </fieldset>
				</form>
			</section>
			<section id="resultados">
			<%

	   			if(request.getParameter("query") != null){
	   				ArrayList<Zapatilla> zapas = (ArrayList<Zapatilla>)request.getAttribute("MatchedProducts");
	   				if(zapas.size() != 0){
	   				for(int i = 0; i < zapas.size(); i++){ 
						Zapatilla p = zapas.get(i);%>
			   				<article class="articulo">      
			   					<div class="img_articulo">                     
		   							 <img src=<% out.print(p.getImagen()); %> alt="foto-articulo" />
		   						</div>
		   						<div class="nombre_articulo">
			   						<h5><% out.print(p.getNombre());%></h5>	
			   						<BR>
			   						<h5><% out.print(p.getPrecio());%></h5>				
	   							</div>
	   							<div class="enlace">
		   						<% 
	   							String enlace="";	
              					enlace+=p.getLink();
						   		out.print("</h5><a href="+enlace+"/></h5>");
						   		if(p.getVendedor()=="Amazon")
						   			out.print("<img src="+"img/Amazon.png"+" alt="+"Amazon"+"/></a>");
						   		if(p.getVendedor()=="Zacaris")
						   			out.print("<img src="+"img/Zacaris.jpg"+" alt="+"Zacaris"+"/></a>");
						   		if(p.getVendedor()=="Ulanka")
						   			out.print("<img src="+"img/Ulanka.jpg"+" alt="+"Ulanka"+"/></a>");
              					 }}%>
              				 </div>
							</article> 
							<%
	   				}else{
	   						out.print("No se han encontrado resultados.");
	   						}%>	   		
			</section>
		</main>
		<footer>
	  		<h3>Autores: Cristina de la Torre Villaverde, Laura Sánchez Parra.</h3>
	 	</footer>
	</body>
</html>
