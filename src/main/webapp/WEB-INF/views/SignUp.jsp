<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>

<style type="text/css">
	input[type=password]{
		font-family: auto;
	}
</style>

<script type="text/javascript">
	function check() {
		var id = pid.value;
		if (id.length < 3) {
			alert("ID가 너무 짧습니다");
			pid.focus();
			return;
		}
		rform.submit();
	}
</script>
<title>회원 가입</title>
</head>
<body>
	<div class="container">
		<jsp:include page="menu.jsp" />

		<div class="ex">
			<h2>회원가입</h2>
			<form action="registermem" method="post" id="rform"
				class="form-horizontal" role="form">
				<div class="form-group" id="divId">
					<label for="inputId" class="col-lg-2 control-label">아이디</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyAlphabetAndNumber"
							name="pid" id="pid" data-rule-required="true" placeholder=""
							maxlength="30" required="required">
					</div>
				</div>

				<div class="form-group" id="divPassword">
					<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="ppw" name="ppw"
							data-rule-required="true" placeholder="영문 숫자포함  6자리 이상"
							maxlength="30" required="required">
					</div>
				</div>
				<div class="form-group" id="divName">
					<label for="inputName" class="col-lg-2 control-label">이름</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyHangul" id="pname"
							name="pname" data-rule-required="true" placeholder="이름"
							maxlength="15" required="required">
					</div>
				</div>
				<div class="form-group" id="divAddress">
					<label for="inputAddress" class="col-lg-2 control-label">주소</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="paddr" name="paddr"
							data-rule-required="true" placeholder="주소" maxlength="50" required="required">
					</div>
				</div>
				<div class="form-group" id="divPhoneNumber">
					<label for="inputPhoneNumber" class="col-lg-2 control-label">전화번호</label>
					<div class="col-lg-10">
						<input type="tel" class="form-control onlyNumber" id="ptel"
							name="ptel" data-rule-required="true" placeholder="010xxxxxxxx"
							maxlength="11" required="required">
					</div>
				</div>
				<div class="form-group" id="divAllergy">
					<label for="inputAllergy" class="col-lg-2 control-label">알레르기</label>
					<div class="col-lg-10">
						<fieldset>
							<legend>check</legend>
							<c:forEach items="${allergyList }" var="allergy" varStatus="i">
								<label class="checkbox-inline"> <input type="checkbox" name="pallergy" value="${allergy.name }">${allergy.name }</label>
								<c:if test="${i.count%4==0 }">
									<br>
								</c:if>
							</c:forEach>
						</fieldset>

					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-primary">등록</button>
						<!-- <input type="button" value="등록" onclick="check()"> -->
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>
