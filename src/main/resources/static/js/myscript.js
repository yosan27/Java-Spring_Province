var tableProvince = {
	create : function(){
		$.ajax({
			url : '/province/get-all',
			method : 'get',
			contentType : 'application/json',
			
			success : function(res, status, xhr){
				if(xhr.status == 200 || xhr.status == 201){
					$('#table-province').DataTable({
						data : res.body,
						columns: [
							{
								title : "id",
								data : "id"
							},
							
							{
								title : "Province Code",
								data : "provinceCode"
							},
							
							{
								title : "Province Name",
								data : "provinceName"
							},
							
							{
								title : "Status",
								data : "status"
							},
							
							{
								title : "Action",
								data : null,
								render : function(data, type, row){
										return "<button class='btn btn-warning' onclick=formProvince.getData('" + data.id + "')>Edit</button>" + " " + 
                                		"<button class='btn btn-danger' onclick=formProvince.delete('" + data.id + "')>Delete</button>"
										
									
								}
							}
						]
					});
				} else{}
			},
			
			error : function(e){
				alert(e);
				console.log(e);
			}
			
		});
	}
};

var formProvince = {
	save : function(){
		var province = {};
		province["provinceCode"] = $('#provinceCode').val();
		province["provinceName"] = $('#provinceName').val();
		
		$.ajax({
			url : '/province/post',
			method : 'post',
			contentType : 'application/json',
			data : JSON.stringify(province),
			
			success : function(res){
				console.log(res);
			},
			
			error : function(e){
				alert(e);
				console.log(e);
			}
		});
	},
	
	getData : function(id){
		$.ajax({
			url : `/province/get-by-id/${id}`,
			method : 'get',
			contentType : 'application/json',
			
			success : function(res, status, xhr){
				data=res.body;
				$('#provinceCode').val(data.provinceCode)
				$('#provinceName').val(data.provinceName)
				
				$('#update-span').removeClass("hide");
				$('#btn-save').addClass("hide");
				
				$('#btn-update-data').click(function(){
					formProvince.update(data.id);
					window.location.reload();
				});
			},
			
			error : function(e){
				alert(e);
				console.log(e);
			}
			
		});
	},
	
	update : function(id){
		var province = {};
		province["provinceCode"] = $('#provinceCode').val();
		province["provinceName"] = $('#provinceName').val();
		
		$.ajax({
			url : `/province/update/${id}`,
			method : 'put',
			contentType : 'application/json',
			data : JSON.stringify(province),
			
			success : function(res){
				console.log(res);
				
				$('#update-span').addClass("hide");
				$('#btn-save').removeClass("hide");
			},
			
			error : function(e){
				alert(e);
				console.log(e);
			}
		});
	},
	
	delete : function(id){
		$.ajax({
			url : `/province/delete/${id}`,
			method : 'delete',
			contentType : 'application/json'
		});
			
		window.location.reload();
	},
	
	restore : function(id){
		$.ajax({
			url : `/province/restore/${id}`,
			method : 'delete',
			contentType : 'application/json'
		});
			
		window.location.reload();
	}
};