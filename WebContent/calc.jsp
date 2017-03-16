<% %>
<% 	
		String _x=request.getParameter("x");
		String _y=request.getParameter("y");
		// x,y가 필수 입력 값이라면
/*		int x = Integer.parseInt(_x);
		int y = Integer.parseInt(_y);*/
		
		//x,y가 필수가 아닌 옵션 값이라면
		
		int x=0;
		int y=0;
		
		if(_x!=null && !_x.equals(""))//x가 전달된 것이 있다면
			x = Integer.parseInt(_x);
		if(_y!=null && !_y.equals(""))
			y = Integer.parseInt(_y);
		// 쿼리 스트림이 전달되는 방식3
		//1. calc -> x=null
		//2. calc?x=&y= ->""
		//3. calc?x=1&y=2 ->x=1
%>			

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>안녕? Jasper </title>
</head>
<body>
	<form action="calc" method="post">
   <p>
      <label>x:</label><input name="x"  id="txt-x"/> 
      <label>y:</label><input name="y" id="txt-y" />
   </p>
   <p>
      sum = <input id="txt-sum" value="<%out.print(3+4);%>"/>
   </p>
   <p>
      <input id="btn-sum" type="submit" value="Sum" value="결과"/>
   </p>
   </form>
</body>
</html>