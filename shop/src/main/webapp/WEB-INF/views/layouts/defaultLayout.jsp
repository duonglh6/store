<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>Free Home Shoppe Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<script type="text/javascript" src="<c:url value ='/resource/js/jquery-1.7.2.min.js'/>"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="<c:url value ='/resource/css/style.css'/>" rel="stylesheet" type="text/css" media="all"/>
<link href="<c:url value ='/resource/css/slider.css'/>" rel="stylesheet" type="text/css" media="all"/>
 
<script type="text/javascript" src="<c:url value ='/resource/js/move-top.js'/>"></script>
<script type="text/javascript" src="<c:url value ='/resource/js/easing.js'/>"></script>
<script type="text/javascript" src="<c:url value ='/resource/js/startstop-slider.js'/>"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div class="wrap">
<div class="header">
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="menu"/>
</div>


<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</div>
</body>
</html>