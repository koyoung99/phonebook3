<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>

<h1>전화번호부</h1>
<h2>수정폼</h2>
<p>
   전화번호를 수정하려면<br>
   아래 항목을 기입하고 "수정"버튼을 클릭하세요.
</p>
<!-- http://localhost:8080/phonebook3/pbc?name=황일영&hp=010&company=02--> 
<!--  pbc까지가 프로그램이다. 뒤에는 데이터임. -->

<form action="/phonebook3/pbc" method=""><!-- get으로 해서 먼저는 보이게하기, 주소는 앞에 htpp:~localhost생략가능 -->
  <input type="hidden" name="no" value="<%=request.getAttribute("no")%>">
   <div>
      <label>이름(name)</label> <!-- 한줄 전체를 요소라고함. 태그 + 내용 -->
      <input type="text" name="name" value="<%=request.getAttribute("name")%>">
   </div>
   
   <div>
      <label>핸드폰(hp)</label>
      <input type="text" name="hp" value="<%=request.getAttribute("hp")%>"><!-- value는 입력되는 값이라 비워둠 -->
   </div>
   
   <div>
      <label>회사(company)</label>
      <input type="text" name="company" value="<%=request.getAttribute("company")%>">
   </div>
   
   <input type="text" name="action" value="updateUser"> <!-- 여긴 입력하는 값이 아니라 value에 값 넣어줌. 안넣으면 insert가 안넘어와서 컨트롤러가 인식을 못함. 따라서 action에 값을 넣어주기 위해서 만들어줌. 개발할땐 text로 놓고 마지막에 hidden으로 안보이게하기 (내부개발용)-->
   <br>
   <button type="submit">수정</button> 
</form>
<br>
<a href="">리스트페이지로 이동</a>


</body>
</html>