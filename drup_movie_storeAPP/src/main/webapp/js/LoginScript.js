$(document).ready(function(){
	 var DOM = {
		formlogin: $("#formlogin"),
		txtuser: $("input#user"),
		txtpassw: $("input#passw"),
		alert: $("div#contenetor")
		
	};
	
	DOM.formlogin.on("submit", function (e){
	e.preventDefault();
	getintoSystem();
	});
	function getintoSystem(){
		var obj = {
			us: DOM.txtuser.val(),
			pass: DOM.txtpassw.val()};
		console.log(JSON.stringify(obj))
		$.ajax({
			
			type: 'post',
			url: 'http://localhost:9090/api/Login',
			data: JSON.stringify(obj),
			headers:{
				'Accept':'application/json',
				'Content-Type':'application/json'
			},
			success: function(data){
				if(data.replay === 1){
					DOM.alert[0].textContent = data.text;
					$.post("LoginServlet?okSesion", {data:JSON.stringify(data.body)});
					setTimeout(function(){
						window.location.href = "home.jsp";
					}, 1600);
				}else{
					DOM.alert[0].textContent = data.text;
				}
			}, error: function(x, y){
				console.log(x.responseText);
			}
			
		});
	}
	
});
	
