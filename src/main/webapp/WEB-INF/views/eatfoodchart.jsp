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
	$(document).ready(function() {
		$("#sdate, #edate").datepicker({
			dateFormat: 'yy/mm/dd'
		});
		
		$("#sdate, #edate").on('change', function(){
			location.href = "/eatfood/eatfoodchart?sdate=" + $("#sdate").val() + "&edate=" + $("#edate").val();
		});
		
		var data = {
			datasets : [ {
				backgroundColor : [ 'rgba(0, 100, 0, 0.25)',
						'rgba(0, 0, 100, 0.25)',
						'rgba(100, 100, 0, 0.25)',
						'rgba(0, 100, 100, 0.25)',
						'rgba(100, 0, 100, 0.25)',
						'rgba(100, 100, 100, 0.25)',
						'rgba(0, 0, 0, 0.25)',
						'rgba(200, 100, 250, 0.25)' ],
				data : [ 
						${totalEatMap.carbo},
						${totalEatMap.protein},
						${totalEatMap.fat},
						${totalEatMap.sugar},
						${totalEatMap.natrium / 1000},
						${totalEatMap.chole / 1000},
						${totalEatMap.fattyacid},
						${totalEatMap.transfat}
				]
			} ],
	
			labels : [ '탄수화믈', '단백질', '지방', '당류',
					'나트륨', '콜레스테롤', '포화 지방산', '트렌스지방' ]
		};
		var myDoughnutChart = new Chart($("#myChart"), {
			type : 'doughnut',
			data : data
		//						 		    options: options
		});
		
		var caloryChart = new Chart($("#caloryChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '칼로리',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.calory}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '칼로리 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '칼로리 섭취량'
			                }
			            }]
		        }
		    }
		});
		
		var carboChart = new Chart($("#carboChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '탄수화물',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.carbo}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '탄수화물 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(g)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var proteinChart = new Chart($("#proteinChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '단백질',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.protein}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '단백질 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(g)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var fatChart = new Chart($("#fatChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '지방',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.fat}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '지방 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(g)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var sugarChart = new Chart($("#sugarChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '당류',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.sugar}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '당류 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(g)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var natriumChart = new Chart($("#natriumChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '나트륨',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.natrium}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '나트륨 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(mg)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var choleChart = new Chart($("#choleChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '콜레스테롤',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.chole}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '콜레스테롤 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(mg)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var fattyacidChart = new Chart($("#fattyacidChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '포화 지방산',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.fattyacid}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '포화 지방산 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(g)'
			                }
			            }
		            ]
		        }
		    }
		});
		
		var transfatChart = new Chart($("#transfatChart"), {
		    type: 'line',
		    data: {
				labels:[
					<c:forEach items="${dayTotalEatMapList }" var="item">
						'${item.eatdate}',
					</c:forEach>
				],
				datasets: [{
		            label: '트렌스지방',
		            data: [
		            	<c:forEach items="${dayTotalEatMapList }" var="item">
							'${item.transfat}',
						</c:forEach>
		            ],
		            borderColor: "rgba(255, 201, 14, 1)",
		            backgroundColor: "rgba(255, 201, 14, 0.5)",
		            fill: true,
		            lineTension: 0
		        }]
		    },
		    options: {
		        responsive: true,
		        title: {
		            display: true,
		            text: '트렌스지방 섭취 통계'
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
		                scaleLabel: {
		                    display: true,
		                    labelString: '섭취일'
		                }
		            }],
		            yAxes: [
		            	{
			                display: true,
			                ticks: {
			                    suggestedMin: 0,
			                },
			                scaleLabel: {
			                    display: true,
			                    labelString: '섭취량(g)'
			                }
			            }
		            ]
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
				<h1 style="text-align: center; font-size: 3em;">섭취량 통계</h1>
				조회기간 <input type="text" id="sdate" readonly="readonly" value="${sdate }"> ~ <input type="text" id="edate" readonly="readonly" value="${edate }">
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-8">
						<canvas id="myChart" style="max-height: 600px; max-width: 600px;"></canvas>
					</div>
		
					<div class="col-sm-4">
						<table class="table">
							<tr>
								<td>칼로리</td>
								<td id="calory">${totalEatMap.calory}</td>
							</tr>
		
							<tr>
								<td>탄수화물(g)</td>
								<td id="carbo">${totalEatMap.carbo}</td>
							</tr>
		
							<tr>
								<td>단백질(g)</td>
								<td id="protein">${totalEatMap.protein}</td>
							</tr>
		
							<tr>
								<td>지방(g)</td>
								<td id="fat">${totalEatMap.fat}</td>
							</tr>
		
							<tr>
								<td>당류(g)</td>
								<td id="sugar">${totalEatMap.sugar}</td>
							</tr>
		
							<tr>
								<td>나트륨(mg)</td>
								<td id="natrium">${totalEatMap.natrium}</td>
							</tr>
		
							<tr>
								<td>콜레스테롤(mg)</td>
								<td id="chole">${totalEatMap.chole}</td>
							</tr>
		
							<tr>
								<td>포화 지방산(g)</td>
								<td id="fattyacid">${totalEatMap.fattyacid}</td>
							</tr>
		
							<tr>
								<td>트렌스지방(g)</td>
								<td id="transfat">${totalEatMap.transfat}</td>
							</tr>
						</table>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="caloryChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="carboChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="proteinChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="fatChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="sugarChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="natriumChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="choleChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="fattyacidChart"></canvas>
					</div>
				</div>
				
				<hr style="margin-bottom: 40px;">
				<div class="row">
					<div class="col-sm-12">
						<canvas id="transfatChart"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>