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
	<script src="<spring:url value='/resources/js/scripts.js'/>"></script>
<title>Application guides</title>
</head>
<body onload="getMenu()">
	<main>
		<div class="guide-page">
				<div class="menu-panel">
					<div class="menu-body">
					<p>Guides</p>
					<ul id = "menu-panel">
					</ul>
					</div>
				</div>
			<div class="guide-panel">
				<div id="guide-body" class="guide-body">
					${content.document}
				</div>
			</div>
		</div>

	</main>

<script>
	$(document).ready(function () {
		$(document).on("scroll", onScroll);

		//smoothscroll
		$('a[href^="#"]').on('click', function (e) {
			e.preventDefault();
			$(document).off("scroll");

			$('a').each(function () {
				$(this).removeClass('currentSub');
			})
			$(this).addClass('currentSub');

			var target = this.hash,
					menu = target;
			$target = $(target);
			$('html, body').stop().animate({
				'scrollTop': $target.offset().top+2
			}, 500, 'swing', function () {
				window.location.hash = target;
				$(document).on("scroll", onScroll);
			});
		});
	});

	function onScroll(event){
		var scrollPos = $(document).scrollTop();
		$('#activeSub a').each(function () {
			var currLink = $(this);
			var refElement = $(currLink.attr("href"));
			if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
				$('#activeSub ul li a').removeClass("currentSub");
				currLink.addClass("currentSub");
			}
			else{
				currLink.removeClass("currentSub");
			}
		});
	}
</script>

</body>
</html>