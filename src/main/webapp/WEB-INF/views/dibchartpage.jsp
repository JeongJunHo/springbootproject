<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<title>Insert title here</title>

<script type="text/javascript">
	$(function(){
		
		var eatDibChart = new Chart($("#eatDibChart"), {
		    type: 'horizontalBar',
		    data: {
		    	labels : [ '탄수화믈', '단백질', '지방', '당류',
					'나트륨', '콜레스테롤', '포화 지방산', '트렌스지방' ],
		        datasets: [{
		            label: '찜 식품 섭취 전',
		            data: [
		            	${todayEatMap['carbo']},
		            	${todayEatMap['protein']},
		            	${todayEatMap['fat']},
		            	${todayEatMap['sugar']},
		            	${todayEatMap['natrium'] / 1000},
		            	${todayEatMap['chole'] / 1000},
		            	${todayEatMap['fattyacid']},
		            	${todayEatMap['transfat']},
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: false,
		        },
		        {
		            label: '찜 식품 섭취 후',
		            data: [
		            	${eatPlusDibMap['carbo']},
		            	${eatPlusDibMap['protein']},
		            	${eatPlusDibMap['fat']},
		            	${eatPlusDibMap['sugar']},
		            	${eatPlusDibMap['natrium'] / 1000},
		            	${eatPlusDibMap['chole'] / 1000},
		            	${eatPlusDibMap['fattyacid']},
		            	${eatPlusDibMap['transfat']},
		            ],
		            borderColor: "rgba(255, 201, 255, 1)",
		            backgroundColor: "rgba(255, 201, 255, 0.5)",
		            fill: false,
		        }
		    ]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '당일 섭취량'
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
		                    suggestedMin: 0
		                },
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취량(g)'
		                },
		            }],
		            yAxes: [{
		                display: true,
		                ticks: {
		                    autoSkip: false
		                },
		                scaleLabel: {
		                    display: true,
		                    labelString: '영양소'
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
		<jsp:include page="header.jsp"/>

		<div class="panel panel-default">
			<div class="panel-body productPanel">
				<h1 style="text-align: center; font-size: 3em;">찜 식품 섭취 전&후 변화량 통계</h1>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="eatDibChart"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>