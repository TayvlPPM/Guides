<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="<spring:url value='/resources/css/style.css'/>" rel="stylesheet">
	<script src="<spring:url value='/resources/js/jquery/jquery-3.4.1.min.js'/>"></script>
<title>Application guides</title>
</head>
<body onload="getMenu()">
	<main>
		<div class="guide-page">
				<div class="menu-panel">
					<p>Guides</p>
					<ul id = "menu-panel">
					</ul>
				</div>
			<div class="guide-panel">
				<div id="guide-body" class="guide-body">
				</div>
			</div>
		</div>

	</main>

	<script>
		let newId = 1;
		function getDocument(path,button){
			var actBut = document.getElementById('active');
			//var actButSub = document;
			if (actBut != null && actBut.id != button){
				actBut.setAttribute("class","menu-value");
				actBut.id = "unactive"+(newId++).toString();
			document.getElementById("activeSub").id="unactiveSub"+newId.toString();}
			document.getElementById(button).id="active";
			document.getElementById(button +'Sub').id="activeSub";
			document.getElementById("active").setAttribute("class", "active-button");
			let targetUrl = 'http://localhost:8080/guide/' + path;
		fetch(targetUrl)
				.then(response => response.json())
				.then(data => {
					document.getElementById('guide-body').innerHTML=data.document;
					let h1s = document.querySelectorAll('h1');
					h1s.forEach(function buildSub(x){
						let container = document.getElementById(button+'Sub');
						let menuSubPar = '<li><a href="#'+x.id+'\">'+x.text+'</a></li>';

						container.innerHTML += menuSubPar;
					});
				})
				.catch(error => console.error(error))
		}
		function getMenu(){
			var container = document.getElementById('menu-panel')
			fetch('http://localhost:8080/guide/menu')
					.then(response => response.json())
					.then(data => {
						data.forEach(function build(x){
							var menuButton = '<li><p onclick="getDocument(\''+x.url+'\',this.id)" id=\"'+x.url+'\" class="menu-value">'+x.caption+'</p><ul id=\"'+x.url+'Sub'+'\"><></li>';

							container.innerHTML += menuButton;
						});
					})
					.catch(error => console.error(error))
		}


	</script>
</body>
</html>