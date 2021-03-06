<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div id="header">
	<div id="title">
		<h1>
			Friend Bar音乐咖啡吧<small>--后台管理</small>
			<shiro:user>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <i class="icon-user"></i> <shiro:principal
							property="name" /> <span class="caret"></span>
					</a>

					<ul class="dropdown-menu">
						<shiro:hasRole name="admin">
							<li><a href="${ctx}/admin/user">Admin Users</a></li>
							<li class="divider"></li>
						</shiro:hasRole>
						<li><a href="${ctx}/profile">Edit Profile</a></li>
						<li><a href="${ctx}/logout">Logout</a></li>
					</ul>
				</div>
			</shiro:user>
		</h1>
		<shiro:user>
			<div>
				<ul class="nav nav-pills">
					<li id="user-tab"><a href="${ctx}/admin/user">会员管理</a></li>
				    <li id="news-tab"><a href="${ctx}/news">新闻管理</a></li>
					<li><a href="#">产品类别</a></li>
					<li><a href="#">产品管理</a></li>
					<li id="task-tab"><a href="${ctx}/task">任务管理</a></li>
					<li><a href="#">优惠券</a></li>

				</ul>
			</div>
		</shiro:user>
	</div>
</div>