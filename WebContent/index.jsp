<%@page import="java.util.ArrayList"%>
<%@page import="main.java.*"%>
<%@page import="org.w3c.dom.Document"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<form id="busqueda.jsp" method="GET" autocomplete="ON">
					<fieldset>
						<label for="buscar"> Buscar:</label>
		                <input type="text" name= "query"/>
		        		<input type="submit" value="Buscar">
					</fieldset>
				</form>
			</section>
			<section>
				<h2>Productos</h2>
				<ul class="lista-productos">
					<%
					//Para recoger el valor de un formulario en JSP, se utiliza la función request.getParameter.
					//En la variable producto se almacena la búsqueda introducida por el usuario.
					String producto = request.getParameter("query");
					
					//Se crea un objeto de la clase ComponerBusquedas, que es la encargada de confeccionar la salida
					//añadiendo los productos obtenidos de las diferentes fuentes de datos.
					if(request.getParameter("query")!=null){
					ProcesarDatos oferta = new ProcesarDatos(producto);
					oferta.busqueda();
					}else{
						out.println("<h5>No hay query</h5>");
					}
					
					//contiene todas laszapatillas y su información
					//ArrayList<Zapatilla> zapas = oferta.getZapatillas();
					
					/*for(int i=0 ; i<zapas.size() ; i++){
						Zapatilla p = zapas.get(i);
						
						//Se consulta la URL del producto para saber de dónde procede y así
						//añadir el logo en el resultado
						String pathLogo;
						if(p.getVendedor()=="Ulanka"){
							pathLogo = "Ulanka";
						}else if(p.getVendedor()=="Sarenza"){
							pathLogo = "Sarenza";
						}
						else{
							pathLogo = "Amazon";
						}					
						
						out.println("<li class='producto'><h3>"+p.getPrecio()+" "+p.esPrecioKilo()+
								"</h3><img class='logo-super' src='img/"+pathLogo+
								"-logo.jpg' alt='logo supermercado'><a href='"+
								p.getUrlProducto()+"' target='_blank'><img src='"+p.getUrlImagen()+
								"' alt='"+p.getProducto()+"'></a><p class='titulo'>"+p.getProducto()+
								"</p></li>");
					}*/
					
					%>
				</ul>
				
	

</body>
		</main>
		<footer>
	  		<h3>Autores: Cristina de la Torre Villaverde, Laura Sánchez Parra.</h3>
	 	</footer>
	</body>
</html>





	
