<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>

<title>Insert title here</title>
<script>
	$(document).ready(function() {		
		$(".delete_btn").click(function(){
			if(confirm("정말 삭제하시겠습니까?")){
				var id = $(this).data("id");
				var code = $(this).data("code");
				var action = "delete";

				$.ajax({
					type: 'DELETE',
					url: '/api/dibfood/delete/' + id+'/'+code,
					contentType: 'application/json; charset=utf-8',
					success: function(res){
						alert(res.resmsg);
						location.reload();
					},
					error: function(jqXHR, textStatus, errorThrown){
						alert(jqXHR.status + '' + jqXHR.responseText);
					}
				});
			}
		});
	});
</script>

</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp"/>

		<div class="panel panel-info">
			<div class="panel-heading">찜 리스트</div>
			<div class="panel-body productPanel">
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr>
							<th>아이디</th>
							<th>제품이름</th>
							<th>제품갯수</th>
							<th>제품사진</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.name }</td>
								<td>${item.cnt }</td>
								<td><img src="../${item.img}" alt="${item.name}" style="max-width: 15%;"></td>
								<td>
									<button class="btn btn-danger btn-sm delete_btn" data-id="${item.id}" data-code="${item.code}" >삭제</button>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${list.size() == 0}">
							<tr>
								<td colspan="5" align="center">찜목록이 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>