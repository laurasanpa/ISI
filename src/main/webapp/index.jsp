<%@page import="java.util.ArrayList"%>
<%@page import="main.java.Oferta"%>
<%@page import="main.java.Zapatilla"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ShoesOffer</title>
	 	<link rel = "stylesheet" type = "text/css" href = "index.css" />
	</head>
	
	<body>
		<header>
	  		<img src="img/logo.png" alt="logo">
	
	  	</header>
	  	<main>
	  		<section id="Buscador">
				<form id="busqueda" action="busqueda.php" method="get" autocomplete="ON">
					<fieldset>
						<label for="buscar"> Buscar:</label>
		                <input type= "text" id="buscar" name= "busqueda"/>
		                <input type="submit" id="botonbusqueda" value="Encontrar mejor oferta"/>
		            </fieldset>
				</form>
			</section>
			<section id="Ofertas">
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
			   						<h5 class="offset-1 col-10"><% out.print(p.getNombre());out.print("<br>");
	   								out.print(p.getValoracion());%></h5>						
	   							</div>
	   							<div class="enlaces">
		   						<% 
	   							if(p.getOfertas()!=null){
								for(int j=0; j<p.getOfertas().size(); j++){
	   							String enlace="";	
              					enlace+=p.getOfertas().get(j).getEnlace();
						   		out.print("<h5>Precio: " + p.getOfertas().get(j).getVendedor() + " " + p.getOfertas().get(j).getPrecio()+" </h5>"+
						   		"<a href=" + enlace + ">");
						   		if(p.getOfertas().get(j).getVendedor()=="Amazon")
						   			out.print("<img src="+"img/Amazon.png"+" alt="+"Amazon"+"/></a>");
						   		if(p.getOfertas().get(j).getVendedor()=="Asos")
						   			out.print("<img src="+"img/Asos.png"+" alt="+"Asos"+"/></a>");
						   		if(p.getOfertas().get(j).getVendedor()=="Zalando")
						   			out.print("<img src="+"img/Zalando.png"+" alt="+"Zalando"+"/></a>");
              					 }}}%>
              				 </div>
							</article> 
							<%
	   						}else{
	   						out.print("No se han encontrado resultados.");
	   						}}%>	   		
			</section>
		</main>
		<footer>
	  		<h3>Autores: Cristina de la Torre Villaverde, Laura Sánchez Parra.</h3>
	 	</footer>
	</body>
</html>
