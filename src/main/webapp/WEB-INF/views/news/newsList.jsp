<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>新闻管理</title>
	<script>
		$(document).ready(function() {
			$("#news-tab").addClass("active");
		});
	</script>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>标题：</label> <input type="text" name="search_LIKE_title" class="input-medium" value="${param.search_LIKE_title}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>标题</th><th>创建人</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${newss.content}" var="news">
			<tr>
				<td><a href="${ctx}/news/update/${news.id}">${news.title}</a></td>
				<td>${news.user.name}</td>
				<td><a href="${ctx}/news/delete/${news.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${newss}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/news/create">创建新闻</a></div>
</body>
</html>
