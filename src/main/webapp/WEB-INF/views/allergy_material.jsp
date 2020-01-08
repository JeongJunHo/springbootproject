<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common.jsp"/>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.css"
	integrity="sha256-IvM9nJf/b5l2RoebiFno92E5ONttVyaEEsdemDC6iQA="
	crossorigin="anonymous" />
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<title>알러지 정보 페이지</title>
<script type="text/javascript">
	$(function(){
		
		var myBarChart = new Chart($("#alleryChart"), {
		    type: 'horizontalBar',
		    data: {
		        labels: [
		        	<c:forEach items="${map}" var="amp" varStatus="status">
						'${amp.key}',
					</c:forEach>
		        ],
		        datasets: [{
		            label: '알러지 보유 수',
		            data: [
		            	<c:forEach items="${map}" var="amp" varStatus="status">
							${amp.value},
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: false,
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '막대 차트 테스트'
		        },
		        tooltips: {
		            mode: 'index',
		            intersect: false,
		        },
		        hover: {
		            mode: 'nearest',
		            intersect: true
		        },
		        scales: {
		            xAxes: [{
		                display: true,
		                ticks: {
		                    autoSkip: false,
		                    stepSize: 1,
		                    suggestedMin: 0
		                },
		                scaleLabel: {
		                    display: true,
		                    labelString: '알러지 보유자 수'
		                },
		            }],
		            yAxes: [{
		                display: true,
		                ticks: {
		                    autoSkip: false
		                },
		                scaleLabel: {
		                    display: true,
		                    labelString: '알러지 종류'
		                }
		            }]
		        }
		    }
		});	
	});
</script>
</head>

<body>
	<div class="container">
		<jsp:include page="header.jsp" />

		<div class="row">
			<div class="col-xs-12"
				style="text-align: right; margin-bottom: 15px;"></div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">알러지 정보</div>
			<div class="panel-body">
				<div class="row productRow">
					<canvas id="alleryChart"></canvas>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>