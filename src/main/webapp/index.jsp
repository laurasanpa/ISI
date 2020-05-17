<%@page import="java.util.ArrayList"%>
<%@page import="com.example.Pala"%>
<%@page import="com.example.SmartyPadel"%>
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
		                <input type="submit" id="botonbusqueda" value="Encontrar mejor oferta"
		            </fieldset>
				</form>
			</section>
			<section id="Ofertas">
			<%
	   			if(request.getParameter("query") != null){
	   				ArrayList<Zapatilla> zapas = (ArrayList<Zapatilla>)request.getAttribute("MatchedProducts");
	   				if(zapas.size() != 0){
	   				for(int i = 0; i < zapas.size(); i++){ 
						Zapatilla p = zapa.get(i);%>
			   				<article class="articulo">      
			   					<div class="img_articulo">                     
		   							 <img src=<% out.print(p.getImagen()); %> alt="foto-articulo" />
		   						</div>
		   						<div class="nombre_articulo"
			   						<h5 class="offset-1 col-10"><% out.print(p.getNombre());out.print("<br>");
	   								out.print(p.getPuntuacion());%></h5>						
	   							</div>
	   							<div class="enlaces">
		   						<% 
	   							if(p.getOfertas()!=null){
	   							for(int j=0; j<p.getOfertas().size(); j++){ 
	   							String enlace="";
	   							enlace+=p.getOfertas().get(j).getEnlace();
								out.print("<a href=enlace> Ver oferta </a>);
              					}} %>
              				 </div>
							</article> <% 
	   				}
	   				}else{
	   					out.print("No se han encontrado resultados.");
	   				}
	   			}
	   		%>	   		
			</section>
		</main>
		<footer>
	  		<h3>Autores: Cristina de la Torre Villverde, Laura Sánchez Parra.</h3>
	 	</footer>
	</body>
</html>
