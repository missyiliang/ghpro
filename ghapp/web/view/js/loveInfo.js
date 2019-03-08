$(function(){
	var inid ='';
	var url = location.search; //获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for(var i = 0; i < strs.length; i ++) {
			inid = unescape(strs[i].split("=")[1]);
		}
	}
	var instanceid = inid; 
//	var instanceid = "8aef00a46923f027016928c295480006"; //2个
//	var instanceid = "8aeffe6767ac37c30167ac7106450021"; //5个
	
	$.ajax({
		type:"get",
		url:"../servlet/loveInfoServlet",
		async:true,
		dataType:"json",
		data:{instanceid:instanceid},
		success:function(data){
			var loveInfo = data.loveInfo;
			var str = "";
			var styleName= "ibox float-e-margins";
			str += "<div class='"+styleName+"'>"
				+"<div class=\"ibox-content\">"
				+"<h4>"+loveInfo.title+"</h4>"
				+"<div ><label class=\"lab-font\">"+loveInfo.totalCode+"</label>"
				+"<div>"
				+"<label class=\"lab-font\">"+loveInfo.centerName+"</label>"
				+"<span class=\"pull-right\">"+loveInfo.applyDate+"</span>"
				+"</div>"
				+"<div>"
				+"<label class=\"lab-font\">"+loveInfo.createName+"("+loveInfo.createCode+")</label>"
				+"<span class=\"pull-right\"><img src=\"../img/tel.png\" style=\"width: 20px;\"/><a href=\"tel:"+loveInfo.phone+"\" style=\"color: #259B24;\">"+loveInfo.phone+"</a></span>"
				+"</div>"
				+"</div></div>"
			
			$("#loveFirst").html(str);
			
			var str1 = "";
				str1 += "<div class='"+styleName+"'>"
					 +"<div class=\"ibox-title\">"
					 +"<i class=\"fa fa-hourglass-half\"></i><h5>审批进度</h5>"
					 +"</div>"
					 +"<div class=\"ibox-content\" style=\"margin-bottom: 5px;\">"
					 +"<div id=\"vertical-timeline\" class=\"vertical-container light-timeline\">";
			
				$.each(data.list,function(i,val){
					if(val.nodeNameRemoveName.indexOf("不通过") == -1 ){ //已通过
						str1 += "<div class=\"vertical-timeline-block\">"
							 +"<div class=\"vertical-timeline-tim\" style=\"min-height: 35px;\">"
							 +"<span class=\"pull-right\">"+val.endTime+"</span>"
							 +"</div>"
							 +"<div class=\"vertical-timeline-ic\">"
							 +"<div class=\"vertical-timeline-icon green-bg\">"
							 +"<i class=\"fa fa-check\"></i>"
							 +"</div></div>"
							 +"<div class=\"vertical-timeline-con\">"
							 +"<span class=\"vertical-date\">"+val.nodeNameRemoveName+"</span>"
							 +"</div></div>";
					}else{ //未通过的
						str1 += "<div class=\"vertical-timeline-block\">"
							 +"<div class=\"vertical-timeline-tim\">"
							 +"<span class=\"pull-right\">"+val.endTime+"</span>"+'&nbsp;'+""
							 +"</div>"
							 +"<div class=\"vertical-timeline-ic\">"
							 +"<div class=\"vertical-timeline-icon red-bg\">"
							 +"<i class=\"fa fa-remove\" style=\"margin-top: -9px;\"></i>"
							 +"</div></div>"
							 +"<div class=\"vertical-timeline-con\">"
							 +"<span class=\"vertical-date\">"+val.nodeNameRemoveName+"</span>"
							 +"</div></div>";
						}
						
				
			})
				str1 +="</div></div></div>";
				$("#loveSecond").html(str1);
				
				        
				var loveInfoList = data.loveInfoList;
				var index = $.inArray("台工会财务办结", loveInfoList);   //Jquery判断数组中是否包含某个元素$.inArray()的用法 
				if(index == -1){ //未办结
					$("div[class=vertical-timeline-block]:last").after("<div class=\"vertical-timeline-block\">"
																		+"<div class=\"vertical-timeline-tim\" style=\"min-height: 35px;\">"
																		+"<span class=\"pull-right\"></span>"+'&nbsp;'+""
																		+"</div>"
																		+"<div class=\"vertical-timeline-ic\" >"
																		+"<div class=\"vertical-timeline-icon\" style=\"border: 0;left: 21.5%;\">"
																		+"<img src=\"../img/huisz.png\" style=\"width:30px;height:30px;\">"
																		+"</div></div>"
																		+"<div class=\"vertical-timeline-con\">"
																		+"<span class=\"vertical-date\">台工会财务办结</span>"
																		+"</div></div>");
				}else{ //办结
					var loveLast = data.list[data.list.length-1];
					
					$("div[class=vertical-timeline-block]:last").html("<div class=\"vertical-timeline-tim\" >"
																	  +"<span class=\"pull-right\">"+loveLast.endTime+"</span>"
																	  +"</div>"
																	  +"<div class=\"vertical-timeline-ic\" >"
																	  +"<div class=\"vertical-timeline-icon\" style=\"border: 0;left: 21.5%;\">"
																	  +"<img src=\"../img/hongsz.png\" style=\"width:30px;height:30px;\">"
																	  +"</div></div>"
																	  +"<div class=\"vertical-timeline-con\">"
																	  +"<span class=\"vertical-date\">"+loveLast.nodeNameRemoveName+"</span>"
																	  +"</div>");
				}
				/*$.each(data.list,function(i,val){
				//如果是第一个值审批进度为绿色
				if(i == 0){
					str1 += "<div class=\"vertical-timeline-block\">"
						 +"<div class=\"vertical-timeline-icon green-bg\">"
						 +"<i class=\"fa fa-check\"></i>"
						 +"</div>"
						 +"<div class=\"vertical-timeline-content\">"
						 +"<span class=\"vertical-date\">"+val.nodeNameRemoveName+"</span>"
						 +"<span class=\"pull-right\">"+val.endTime+"</span>"
						 +"</div>"
						 +"</div>";
				}
				//其他为灰色
				if(i > 0 && i <= 4){
					str1 += "<div class=\"vertical-timeline-block\">"
						 +"<div class=\"vertical-timeline-icon gray-bg\">"
						 +"<i class=\"fa fa-check\"></i>"
						 +"</div>"
						 +"<div class=\"vertical-timeline-content\">"
						 +"<span class=\"vertical-date\">"+val.nodeNameRemoveName+"</span>"
						 +"<span class=\"pull-right\">"+val.endTime+"</span>"
						 +"</div>"
						 +"</div>";
				}
			})
			
			if(data.list.length > 5){
				str1 += "<div id=\"showjd\" style=\"display:none;\">";
				
				$.each(data.list,function(i,val){
					//大于5的时候显示更多
					if(i > 4){
						str1 += "<div class=\"vertical-timeline-block\">"
							 +"<div class=\"vertical-timeline-icon gray-bg\"><i class=\"fa fa-check\"></i>"
							 +"</div>"
							 +"<div class=\"vertical-timeline-content\">"
							 +"<span class=\"vertical-date\">"+val.nodeNameRemoveName+"</span>"
							 +"<span class=\"pull-right\">"+val.endTime+"</span>"
							 +"</div>"
							 +"</div>";
					}
				})
				
				str1 +="</div></div><a href=\"javascript:showjdVoid();\" id=\"btnjd\" class=\"btn btn-xs btn-white\" style=\"border:0;\">查看更多</a>"
					 +"</div></div>";
			}
			
			$("#loveSecond").html(str1);*/
			
			// 判断是否现实按钮
            var num = $(".vertical-timeline-block").length;
            if (num>5) {
            	$("#btnjd").css("display","block");
            }else{
            	$("#btnjd").css("display","none");
            }
			
			var str2 = "";
			str2 += "<div class='"+styleName+"'>"
			+"<div class=\"ibox-title\">"
			+"<i class=\"fa fa-tag\"></i><h5>申领单信息</h5>"
			+"</div><div class=\"ibox-content\">"
			+"<h4 class=\"tit-center\" >";
			if(loveInfo.type == 1){
				str2 += "中央电视台工会联合会“爱心工程”慰问金申领表<br>（新、生、故）";
			}
			if(loveInfo.type == 2){
				str2 += "中央电视台工会联合会“爱心工程”慰问金申领表<br>（台聘退休慰问）";
			}
			if(loveInfo.type == 3){
				str2 += "中央电视台工会联合会“爱心工程”慰问金申领表<br>（在职去世）";
			}
			if(loveInfo.type == 4){
				str2 += "中央电视台工会联合会“爱心工程”慰问金申领表<br>（因公殉职）";
			}
			str2 += "</h4>"
				+"<div class=\"form-group\">"
				+"<label>职工信息</label>"
				+"<div class=\"row\" style=\"margin:0;\">"
				+"<div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">职工姓名："+(loveInfo.employeeName==undefined?"":loveInfo.employeeName)+"</label></div>"
				+"</div>"
				+"<div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">人员编制："+(loveInfo.staffEstablishing==undefined?"":loveInfo.staffEstablishing)+"</label></div>"
				+"</div><div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">性别："+(loveInfo.employeeSex==undefined?"":loveInfo.employeeSex)+"</label></div>"
				+"</div>"
				+"<div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">工作证号："+(loveInfo.workNumber==undefined?"":loveInfo.workNumber)+"</label></div>"
				+"</div>"
				+"</div>"
				+"</div><div class=\"form-group\">"
				+"<label>家属信息</label>"
				+"<div class=\"row\" style=\"margin:0;\">"
				+"<div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">家属姓名："+(loveInfo.familyName==undefined?"":loveInfo.familyName)+"</label></div>"
				+"</div><div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">性别："+(loveInfo.familySex==undefined?"":loveInfo.familySex)+"</label></div>"
				+"</div><div class=\"col-xs-6\">"
				+"<div><label class=\"lab-font\">与职工本人关系："+(loveInfo.employeeRelation==undefined?"":loveInfo.employeeRelation)+"</label></div>"
				+"</div></div>"
				+"</div>"
				+"<div class=\"form-group\">"
				+"<label>慰问信息</label><br/>"
				+"<div><label class=\"lab-font\">慰问项目:&nbsp;</label>"
				+"<span>"+(loveInfo.consolationProject==undefined?"":loveInfo.consolationProject)+"</span></div>"
				+"<div><label class=\"lab-font\">申领金额大写:&nbsp;</label>"
				+"<span>"+loveInfo.applyAmountd+"</span></div>"
				+"<div><label class=\"lab-font\">申领金额小写:&nbsp;</label>￥"
				+"<span>"+loveInfo.applyAmountx+"</span></div>"
				+"</div></div>"
				
			$("#loveThird").html(str2);
			
			var str3 = "";
				str3 += "<div class='"+styleName+"'>"
					 +"<div class=\"ibox-title\">"
					 +"<i class=\"fa fa-tag\"></i>"
					 +"<h5>附件信息</h5>"
					 +"</div>"
					 +"<div class=\"ibox-content\">"
					 +"<div class=\"form-group\">"
					 +"<p>请登录电脑进行查看</p>"
					 +"</div>"
					 +"</div>"
					 +"</div>";
				
			$("#loveForth").html(str3);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
});


        
      
        
        
    















    
    


   
            
                
            

            
                
                
            
        

        
            
                
            

            
               
                
            
        

        
        
       
       
            
                

  
   
        


