<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  	<head>
	    <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value='/css/bootstrap-theme.css' />" rel="stylesheet">
	    
	    <!-- Bootstrap JS -->
	    <link href="<c:url value='/js/bootstrap.js' />">
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		
	    <title>Hello, world!</title>

	    
		<style>
			.pagination {
			   justify-content: center;
			}
		</style>
	</head>

	<body>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	
    	<!-- Pagination -->
		<script>	
			$('document').ready(function() {
			   	var area0 = ["시/도 선택","서울특별시","인천광역시","대전광역시","광주광역시","대구광역시","울산광역시","부산광역시","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도"];
				var area1 = ["구/군 선택","강남구","강동구","강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"];
			   	var area2 = ["구/군 선택","계양구","남동구","동구","미추홀구","부평구","서구","연수구","중구","강화군","옹진군"];
			   	var area3 = ["구/군 선택","대덕구","동구","서구","유성구","중구"];
			   	var area4 = ["구/군 선택","광산구","남구","동구","북구","서구"];
			   	var area5 = ["구/군 선택","남구","달서구","동구","북구","서구","수성구","중구","달성군"];
			   	var area6 = ["구/군 선택","남구","동구","북구","중구","울주군"];
			   	var area7 = ["구/군 선택","강서구","금정구","남구","동구","동래구","부산진구","북구","사상구","사하구","서구","수영구","연제구","영도구","중구","해운대구","기장군"];
			   	var area8 = ["구/군 선택","고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
			   	var area9 = ["구/군 선택","강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
			   	var area10 = ["구/군 선택","제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
			   	var area11 = ["구/군 선택","계룡시","공주시","논산시","보령시","서산시","아산시","천안시","금산군","당진군","부여군","서천군","연기군","예산군","청양군","태안군","홍성군"];
			   	var area12 = ["구/군 선택","군산시","김제시","남원시","익산시","전주시","정읍시","고창군","무주군","부안군","순창군","완주군","임실군","장수군","진안군"];
			   	var area13 = ["구/군 선택","광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
			   	var area14 = ["구/군 선택","경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
			   	var area15 = ["구/군 선택","거제시","김해시","마산시","밀양시","사천시","양산시","진주시","진해시","창원시","통영시","거창군","고성군","남해군","산청군","의령군","창녕군","하동군","함안군","함양군","합천군"];
			   	var area16 = ["구/군 선택","서귀포시","제주시","남제주군","북제주군"];
	
			 	// 시/도 선택 박스 초기화
			
				 $("select[name^=sido]").each(function() {
					  $selsido = $(this);
					  $.each(eval(area0), function() {
					   $selsido.append("<option value='"+this+"'>"+this+"</option>");
					  });
					  $selsido.next().append("<option value='구/군 선택'>구/군 선택</option>");
				 });
	
				 // 시/도 선택시 구/군 설정			
				 $("select[name^=sido]").change(function() {
					  var area = "area"+$("option",$(this)).index($("option:selected",$(this))); // 선택지역의 구군 Array
					  var $gugun = $(this).next(); // 선택영역 군구 객체
					  $("option",$gugun).remove(); // 구군 초기화
					
					  if(area == "area0")
					   $gugun.append("<option value='구/군 선택'>구/군 선택</option>");
					  else {
					   $.each(eval(area), function() {
					    $gugun.append("<option value='"+this+"'>"+this+"</option>");
					   });
					  }
				 });
	
			});
			
	
			
		</script>
		<article>		
			<div class="container">	
				<div class="row">
					<form action="<c:url value='/board/postList' />" name="fr" id="fr" role="form" onsubmit="return check()">
						<div class="col-xs-12">	
						
							<select class="dropdown" name="sido" id="sido1"></select>
							<select class="dropdown" name="gugun" id="gugun1"></select>
							
							<select class="dropdown" name="theme">
								<option value="장소 선택">장소 선택</option>
								<option value="술">술</option>
								<option value="식사">식사</option>
								<option value="놀이">놀이</option>
								<option value="실외">실외</option>
								<option value="디저트">디저트</option>	
							</select>
							
							<input class="btn btn-md" type="submit" value="검색">	
											
						</div>
					</form>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-2 col-xs-offset-8">				
						<form action="<c:url value='/board/selectLoc'/>">
							<input class="btn btn-md" type="submit" value="글쓰기">	
						</form>
					</div>
				</div>		
				<div class="table-responsive">	
					<table class="table table-striped table-sm">
						<colgroup>
							<col style="width:5%;" />
							<col style="width:auto;" />
							<col style="width:15%;" />
							<col style="width:10%;" />
							<col style="width:10%;" />
						</colgroup>
						<thead>
							<tr>
								<th>NO</th>
								<th>작성자</th>
								<th>글제목</th>
								<th>시도</th>
								<th>구군</th>
								<th>장소</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<%
								String a = request.getAttribute("listCnt").toString();
								int listCnt = Integer.parseInt(a);
							%>
							
							<c:choose>
								<c:when test="${empty list }" >
									<tr><td colspan="8" align="center">데이터가 없습니다.</td></tr>
								</c:when> 
								<c:when test="${!empty list}">
									<c:forEach var="list" items="${list}">
										<tr>
											<td class="scrolling" data-bno="${list.post_idx }"><%=listCnt %></td>
											<td> <a href="<c:url value='/board/postDetail?idx=${list.post_idx }' />"><c:out value="${list.mem_id}"/></a></td>
											<td><c:out value="${list.post_title}"/></td>
											<td><c:out value="${list.post_sido}"/></td>
											<td><c:out value="${list.post_gugun}"/></td>
											<td><c:out value="${list.post_theme}"/></td>
											<td><c:out value="${list.post_date}"/></td>
											<td><c:out value="${list.post_views}"/></td>
										</tr>
									<%listCnt=listCnt-1; %>
									</c:forEach>
								</c:when>
							</c:choose>
							<%listCnt=listCnt-1; %>
						</tbody>		
					</table>
				</div>
			</div>
			
			
		</article>	
		<!-- <script type="text/javascript">
			function check() {
				  if(fr.sido.value == "시/도 선택" && fr.gugun.value == "구/군 선택" && fr.theme.value == "장소 선택") {
				    alert("한가지라도 선택 후 확인을 눌러주세요.");
				    return false;
				  }
				  else{
					  return true;
				  }
			}
			var isEnd = false;
		    
		    $(function(){
		        $(window).scroll(function(){
		            let  $window = $(this);
		            let scrollTop = $window.scrollTop();
		            let windowHeight = $window.height();
		            let documentHeight = $(document).height();
		            
		            console.log("documentHeight:" + documentHeight + " | scrollTop:" + scrollTop + " | windowHeight: " + windowHeight );
		            
		            // scrollbar의 thumb가 바닥 전 30px까지 도달 하면 리스트를 가져온다.
		            if( scrollTop + windowHeight + 30 > documentHeight ){
		                fetchList();
		            }
		        })
		        fetchList();
		    })
		    
		    var fetchList = function(){
		        if(isEnd == true){
		            return;
		        }
		        
		        // 방명록 리스트를 가져올 때 시작 번호
		        // renderList 함수에서 html 코드를 보면 <li> 태그에 data-no 속성이 있는 것을 알 수 있다.
		        // ajax에서는 data- 속성의 값을 가져오기 위해 data() 함수를 제공.
		        let startNo = $(".scrolling").last().data("no") || 0;
		        $.ajax({
		            url:"/board/postList?page=" + ${pagination.page+1}+"&range="+${pagination.range},
		            type: "GET",
		            dataType: "json",
		            success: function(result){
		                // 컨트롤러에서 가져온 방명록 리스트는 result.data에 담겨오도록 했다.
		                // 남은 데이터가 5개 이하일 경우 무한 스크롤 종료
		                let length = result.data.length;
		                if( length < 5 ){
		                    isEnd = true;
		                }
		                $.each(result.data, function(index, vo){
		                    renderList(false, vo);
		                })
		            }
		        });
		    }
		    
		    let renderList = function(mode, vo){
		        // 리스트 html을 정의
		        let html = "<li data-no='"+ vo.no +"'>" +
		            "<strong>"+ vo.name +"</strong>" +
		            "<p>"+ vo.content.replace(/\n/gi, "<br>") +"</p>" +
		            "<strong></strong>" +
		            "<a href='#' data-no='"+ vo.no +"'>삭제</a>" +
		            "</li>"
		        
		        if( mode ){
		            $("#list-guestbook").prepend(html);
		        }
		        else{
		            $("#list-guestbook").append(html);
		        }
		    }
		</script> -->
	</body>
	
</html>


