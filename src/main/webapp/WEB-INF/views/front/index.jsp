<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>首页</title>
</head>

<body>

	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide">
 
		<div class="carousel-inner">
			<c:forEach items="${AdvertisementList}" var="advertisement" varStatus="status">
				<c:if test="${status.index==0}">
					<div class="item active">
						<img src="${ctx}${advertisement.backgroundImageUrl}" alt="">
						<div class="container">
							<div class="carousel-caption">
								<h1>${advertisement.title}</h1>
								<p class="lead">${advertisement.description}</p>
								<a class="btn btn-large btn-primary" href="${advertisement.openUrl}">${advertisement.openBtnName}</a>
							</div>
						</div>
					</div>

				</c:if>
				<c:if test="${status.index!=0}">
					<div class="item">
						<img src="${ctx}${advertisement.backgroundImageUrl}" alt="">
						<div class="container">
							<div class="carousel-caption">
								<h1>${advertisement.title}</h1>
								<p class="lead">${advertisement.description}</p>
								<a class="btn btn-large btn-primary" href="${advertisement.openUrl}">${advertisement.openBtnName}</a>
							</div>
						</div>
					</div>

				</c:if>


			</c:forEach>
		</div>

		<a class="left carousel-control"  href="#myCarousel" data-slide="prev">&lsaquo;</a> 
		<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	<!-- /.carousel -->


	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Hello, world!</h1>
			<p>This is a template for a simple marketing or informational website. It includes a large callout called the
				hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
			<p>
				<a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec
					sed odio dui.</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec
					sed odio dui.</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta
					felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa
					justo sit amet risus.</p>
				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
		</div>

		<hr>


	</div>
	<!-- /container -->
</body>
</html>
