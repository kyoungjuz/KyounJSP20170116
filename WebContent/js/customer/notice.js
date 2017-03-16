/**
 * 
 */
	


window.addEventListener("load",function(){
		var btnResult = document.getElementById("btn-result");
	
		btnResult.onclick = printResult;
		function printResult() {
			var x, y;
			x = prompt("x 값을 입력하세요", 0);
			y = prompt("x 값을 입력하세요", 0);
			x = parseInt(x);
			y = parseInt(y);
			btnResult.value = (x + y);
		}
	});





