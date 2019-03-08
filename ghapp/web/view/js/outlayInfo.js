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
//	var instanceid = "8aef00a4690fc8b801691319d5e60002"	;//活动申请退办
//	var instanceid = "8aef00a46923f027016928c32b330008"; 
//	var instanceid = "8aef00a46923f027016928c1d2140002"; 
//	var instanceid = "8aef00a4691467be016914747c7e0004";
	
	$.ajax({
		type:"get",
		url:"../servlet/outlayInfoServlet",
		async:true,
		dataType:"json",
		data:{instanceid:instanceid},
		success:function(data){
			//活动预算
			var outLayInfo = data.outLayInfo;
			//取消活动
			var cancelApply = data.cancelApply;
			
			var str = ""; //活动的请示
			var styleName= "ibox float-e-margins";
				str += "<div class='"+styleName+"'>"
					+"<div class=\"ibox-content\">";
			
			if(cancelApply == undefined){
				str	+= "<h4>"+outLayInfo.askName+"</h4>";
			}else{
				str	+= "<h4>"+cancelApply.title+"</h4>";
			}
			
			str	+="<div ><label class=\"lab-font\">"+outLayInfo.totalCode+"</label>"
				+"</div>"
				+"<div ><label class=\"lab-font\">"+outLayInfo.centerName+"</label>"
				+"<span class=\"pull-right\">"+outLayInfo.applyDate+"</span>"
				+"</div>"
				+"<div ><label class=\"lab-font\">"+outLayInfo.createName+"("+outLayInfo.createCode+")</label>"
				+"<span class=\"pull-right\"><img src=\"../img/tel.png\" style=\"width: 20px;\"/><a href=\"tel:"+outLayInfo.phone+"\" style=\"color: #27c24c;\">"+outLayInfo.phone+"</a></span>"
				+"</div>" 
				+"</div>"
				+"</div>";
			$("#first").html(str);
			
			if(cancelApply == undefined){ 
				
				var str1 = ""; //审批进度 
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
									 +"<span class=\"pull-right\">"+val.endTime+"</span>"+'&nbsp;'+""
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
									 +"<span class=\"pull-right\">"+" "+val.endTime+"</span>"+'&nbsp;'+""
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
					$("#second").html(str1);
					
					var outLayList = data.outLayList;
					var index = $.inArray("台工会财务办结", outLayList);   //Jquery判断数组中是否包含某个元素$.inArray()的用法 
					if(index == -1){ //未办结
						$("div[class=vertical-timeline-block]:last").after("<div class=\"vertical-timeline-block\">"
																			+"<div class=\"vertical-timeline-tim\" style=\"min-height: 35px;\">" 
																			+"<span class=\"pull-right\"></span>"+'&nbsp;'+""
																			+"</div>"
																			+"<div class=\"vertical-timeline-ic\">"
																			+"<div class=\"vertical-timeline-icon\" style=\"border: 0;left: 21.5%;\">"
																			+"<img src=\"../img/huisz.png\" style=\"width:30px;height:30px;\">"
																			+"</div></div>"
																			+"<div class=\"vertical-timeline-con\">"
																			+"<span class=\"vertical-date\">台工会财务办结</span>"
																			+"</div></div>");
					}else{ //办结
						var outLayList = data.list[data.list.length-1];
						
						$("div[class=vertical-timeline-block]:last").html("<div class=\"vertical-timeline-tim\" >"
																		  +"<span class=\"pull-right\">"+outLayList.endTime+"</span>"
																		  +"</div>"
																		  +"<div class=\"vertical-timeline-ic\" >"
																		  +"<div class=\"vertical-timeline-icon\" style=\"border: 0;\">"
																		  +"<img src=\"../img/hongsz.png\" style=\"width:20px;height:20px;\">"
																		  +"</div></div>"
																		  +"<div class=\"vertical-timeline-con\">"
																		  +"<span class=\"vertical-date\">"+outLayList.nodeNameRemoveName+"</span>"
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
					
					
					str1 +="</div></div><a href=\"javascript:showjdVoid();\" id=\"btnjd\" class=\"btn btn-xs btn-white\" style=\"border:0;\" >查看更多</a>"
						 +"</div></div>";
				}
				$("#second").html(str1);
				*/
				
				
				
				
				// 判断是否现实按钮
	            var num = $(".vertical-timeline-block").length;
                if (num>5) {
                    $("#btnjd").css("display","block");
                }else{
                	$("#btnjd").css("display","none");
                }
				
			}else{ 
				
				var str1 = ""; //取消原因
					str1 += "<div class='"+styleName+"'>"
						 +"<div class=\"ibox-title\">"
						 +"<i class=\"fa fa-tag\"></i><h5>取消原因</h5>"
						 +"</div>"
						 +"<div class=\"ibox-content\">"
						 +"<div class=\"form-group\">"
						 +"<p>"+cancelApply.cancelWhy+"</p>"
						 +"</div>"
						 +"</div>"
						 +"</div>";
				
				$("#second").html(str1);
			}
			
			var str2 = "";//活动基本信息 
				str2 += "<div class='"+styleName+"'>"
					 +"<div class=\"ibox-title\"><i class=\"fa fa-tag\"></i>"
					 +"<h5>活动基本信息</h5>"
					 +"</div>" 
					 +"<div class=\"ibox-content\">"
					 +"<div><label class=\"lab-font\">活动时间:&nbsp;</label>"
					 +"<span>"+outLayInfo.ghStartTime+"至"+outLayInfo.ghEndTime+"</span>"
					 +"</div>"
					 +"<div><label class=\"lab-font\">受众人数:&nbsp;</label>"
					 +"<span>"+outLayInfo.joinNum+"</span>"
					 +"</div><div ><label class=\"lab-font\">活动项目:&nbsp;</label>"
					 +"<span>"+outLayInfo.proType+"</span>"
					 +"</div>"
					 +"</div>"
					 +"</div>";
		
			$("#third").html(str2);
			
			var str3 = ""; //经费类别 
				str3 += "<div class='"+styleName+"' id=\"forth\" style=\"display: none;\">"
					 +"<div class=\"ibox-title\">"
					 +"<i class=\"fa fa-tag\"></i><h5>经费类别</h5>"
					 +"</div><div class=\"ibox-content\" >"
					 +"<div class=\"form-group checkbox i-checks\">"
					 +"<table class=\"check-tab\">"
					 +"<tr>"
					 +"<td align=\"left\">"
					 +"<label>事业编会费&nbsp;</label>"
					 +"<input type=\"checkbox\" value=\"事业编会费\" name=\"businessSubscriptionFee\" id=\"businessSubscriptionFee\">"
					 +"</td>"
					 +"<td>"
					 +"<label>台聘会费&nbsp;</label>"
					 +"<input type=\"checkbox\" value=\"台聘会费\" name=\"dues\" id=\"dues\">"
					 +"</td>"
					 +"<td align=\"right\">"
					 +"<label>专项额度&nbsp;</label>"
					 +"<input type=\"checkbox\" value=\"专项额度\" name=\"accessLimit\" id=\"accessLimit\">"
					 +"</td>"
					 +"</tr>"
					 +"</table>"
					 +"</div>"
					 +"</div>"
					 +"</div>";
					 
			$("#outlayType").html(str3);
			
			var str4 = ""; //支付方式
				str4 += "<div class='"+styleName+"' id=\"fifth\" style=\"display: none;\">"
					 +"<div class=\"ibox-title\">"
					 +"<i class=\"fa fa-tag\"></i><h5>支付方式</h5>"
					 +"</div>"
					 +"<div class=\"ibox-content\" >"
					 +"<div class=\"form-group checkbox i-checks\">"
					 +"<table class=\"check-tab\">"
					 +"<tr>"
					 +"<td align=\"left\">"
					 +"<label>汇款&nbsp;</label>"
					 +"<input type=\"checkbox\" id=\"remit\" value=\"汇款\" name=\"remit\">"
					 +"</td>"
					 +"<td>"
					 +"<label>支票&nbsp;</label>"
					 +"<input type=\"checkbox\" id=\"check\" value=\"支票\" name=\"check\">"
					 +"</td>"
					 +"<td align=\"right\">"
					 +"<label>现金&nbsp;</label>"
					 +"<input type=\"checkbox\" id=\"cash\" value=\"现金\" name=\"cash\">"
					 +"</td>"
					 +"</tr>"
					 +"</table>"
					 +"</div>"
					 +"</div>"
					 +"</div> ";
				
			$("#payType").html(str4);
			
			$('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
			
			$("input:checkbox").prop("disabled",true);
			//经费类别 
			var outlayType = data.outLayInfo.outlayType;
			if(outlayType == undefined ){
				$("#forth").hide();
			}else{
				var outlayTypeValue = outlayType.split(",");
				for (var i = 0; i < outlayTypeValue.length; i++) {
					if(outlayTypeValue[i] == "事业编会费"){
						$("#businessSubscriptionFee").parent().addClass("checked");
						$("#businessSubscriptionFee").prop("disabled",true); 
					}
					if(outlayTypeValue[i] == "台聘会费"){
						$("#dues").parent().addClass("checked");
						$("#dues").prop("disabled",true); 
					}
					if(outlayTypeValue[i] == "专项额度"){
						$("#accessLimit").parent().addClass("checked");
						$("#accessLimit").prop("disabled",true); 
					}
				}
				$("#forth").show();
			}
			
			//支付方式
			var payType = data.outLayInfo.payType;
			if(payType == undefined ){
				$("#fifth").hide();
			}else{
				var payTypeValue = payType.split(",");
				for (var i = 0; i < payTypeValue.length; i++) {
					if(payTypeValue[i] == "汇款"){
						$("#remit").parent().addClass("checked");
						$("#remit").prop("disabled",true);
					}
					if(payTypeValue[i] == "支票"){
						$("#check").parent().addClass("checked");
						$("#check").prop("disabled",true);
					}
					if(payTypeValue[i] == "现金"){
						$("#cash").parent().addClass("checked");
						$("#cash").prop("disabled",true);
					}
				}
				$("#fifth").show();
			}
			
			var str5 = "";//涵盖
			var remitBillSize = data.remitBillSize;//汇款申请单份数
			var attachSize = data.attachSize;//合同附件份数
			var payBudgetListSize = data.payBudgetListSize;//预算份数
				str5 += "<div class='"+styleName+"'>"
					 +"<div class=\"ibox-title\"><i class=\"fa fa-tag\"></i>"
					 +"<h5>涵盖</h5>"
					 +"</div>"
					 +"<div class=\"ibox-content\">"
					 +"<div><label class=\"lab-font\">请示</label><span><b>1</b>份</span>"
					 +"</div>"
					 +"<div><label class=\"lab-font\">预算</label><span><b>"+(payBudgetListSize==undefined?0:payBudgetListSize)+"</b>份</span>"
					 +"</div>"
					 +"<div><label class=\"lab-font\">汇款申请单</label><span><b>"+(remitBillSize==undefined?0:remitBillSize)+"</b>份</span>"
					 +"</div>"
					 +"<div><label class=\"lab-font\">合同附件</label><span><b>"+(attachSize==undefined?0:attachSize)+"</b>份</span>"
					 +"</div>"
					 +"</div>"
					 +"</div>";
			$("#sixth").html(str5);
			
			
			var str6 = "";//请示
				str6 += "<div class='"+styleName+"'>"
					 +"<div class=\"ibox-title\">"
					 +"<i class=\"fa fa-tag\"></i><h5>请示</h5>"
					 +"</div>"
					 +"<div class=\"ibox-content\">"
					 +"<h4 class=\"tit-center\" >"+outLayInfo.askName+"</h4>"
					 +"<div class=\"form-group\">"
					 +"<p class=\"indent-cen\">"+(outLayInfo.askLoc==undefined?"":outLayInfo.askLoc)+"</p>"
					 +"</div>"
					 +"</div>"
					 +"</div>";
			$("#seventh").html(str6);
            
			if(data.payBudgetList.length > 0){
				var str7 = "";//预算
				
				var totalPriceSumStr = data.totalPriceSumStr ;//总金额
				var totalPriceLinesStr = data.totalPriceLinesStr;//总专项额度
				var totalCareerVipCastStr = data.totalCareerVipCastStr;//总事业编会员会费
				var totalCctvVipCastStr = data.totalCctvVipCastStr;//总台聘会员会费
				
					str7 += "<div class='"+styleName+"'>"
						 +"<div class=\"ibox-title\"><i class=\"fa fa-tag\"></i>"
						 +"<h5>预算</h5>"
						 +"</div>"
						 +"<div class=\"ibox-content\">"
						 +"<div class=\"form-group\">"
						 +"<div class=\"row\" id=\"list\" style=\"margin:0;\">"
						 +"<div class=\"col-xs-4\" >"
						 +"<table class=\"table ui-table\">"
						 +"<tbody>"
						 +"<tr>"
						 +"<td>序号</td>"
						 +"<td style=\"padding: 3px;\">项目</td>"
						 +"</tr>";
				$.each(data.payBudgetList,function(i,val){
					if(i >= 0){
						str7 += "<tr>"
							 +"<td>"+val.seqCode+"</td>"
							 +"<td style=\"padding: 3px;\">"+(val.title==undefined?"":val.title)+"</td>"
							 //+"<td></td>"
							 +"</tr>";
					}
				})
				
					str7 += "<tr>"
						 +"<td>合计</td>"
						 +"<td></td>"
						 +"</tr>"
						 +"</tbody>"
						 +"</table>"
						 +"</div>"
						 +"<div class=\"x_auto_box col-xs-8\" id=\"showDiv\" style=\"margin-left: -2px;\">"
						 +"<input type=\"hidden\" name=\"dto.position\" value=\"1\" />"
						 +"<input type=\"hidden\" name=\"dto.position\" value=\"1\" />"
						 +"<input type=\"hidden\" name=\"dto.position\" value=\"1\" />"
						 +"<input type=\"hidden\" name=\"dto.position\" value=\"1\" />"
						 +"<table id=\"tableRight\" class=\"table ui-table\">"
						 +"<tbody>"
						 +"<tr>"
						 +"<td>数量</td>"
						 +"<td>物品单位</td>"
						 +"<td>单价</td>"
						 +"<td style=\"font-weight: bold;\">金额</td>"
						 +"<td>事业编会员会费</td>"
						 +"<td>台聘会员会费</td>"
						 +"<td>专项额度</td>"
						 +"<td>结算方式</td>"
						 +"<td>去向</td>"
						 +"</tr>";
				
				$.each(data.payBudgetList,function(i,val){
					if(i >= 0){
						str7 += "<tr>"
							 +"<td>"+val.num+"</td>"
							 +"<td>"+val.unit+"</td>"
							 +"<td>"+val.price+"</td>"
							 +"<td style=\"font-weight: bold;\">"+val.priceSum+"</td>"
							 +"<td>"+val.careerVipCast+"</td>"
							 +"<td>"+val.cctvVipCast+"</td>"
							 +"<td>"+val.priceLines+"</td>"
							 +"<td>"+(val.settlementType==undefined?"":val.settlementType)+"</td>"
							 +"<td>"+(val.direction==undefined?"":val.direction)+"</td>"
							 +"</tr>";
					}
				})
				
					str7 += "<tr>"
						 +"<td></td>"
						 +"<td></td>"
						 +"<td></td>"
						 +"<td style=\"font-weight: bold;\">"+totalPriceSumStr+"</td>"
						 +"<td>"+totalCareerVipCastStr+"</td>"
						 +"<td>"+totalCctvVipCastStr+"</td>"
						 +"<td>"+totalPriceLinesStr+"</td>"
						 +"<td></td>"
						 +"<td></td>"
						 +"</tr>"
						 +"</tbody>"
						 +"</table>"
						 +"</div>"
						 +"</div>"
						 +"</div>"
						 +"</div>"
						 +"</div>";
					$("#eighth").html(str7);
			}
			
			
			if(data.remitBillList.length > 0){
				var str8 =	"";//汇款单
					str8 += "<div class='"+styleName+"'>"
						 +"<div class=\"ibox-title\">"
						 +"<i class=\"fa fa-tag\"></i>"
						 +"<h5>汇款单</h5>"
						 +"</div>";
				$.each(data.remitBillList,function(i,val){
					if(i == 0){
						str8 += "<div class=\"ibox-content text-show\" style=\" padding-bottom:5px;\">"
							 +"<h4 class=\"tit-center\" >中央电视台工会联合会汇款申请单</h4>"
							 +"<p class=\"tit-center\">"+val.remitBudgetNum+"</p>"
							 +"<div class=\"form-group\" style=\"margin-bottom:5px;\">"
							 +"<label>汇款方信息</label><br/>"
							 +"<div><label class=\"lab-font\">汇款部门:&nbsp;</label>"
							 +"<span>"+val.remitCenterName+"</span></div>"
							 +"<div><label class=\"lab-font\">汇款金额:&nbsp;</label>"
							 +"<span>"+val.remitCost+"</span></div>"
							 +"<div><label class=\"lab-font\">汇款用途:&nbsp;</label>"
							 +"<span>"+val.remitUse+"</span></div>"
							 +"<div class=\"form-group\">"
							 +"<label>收款方信息</label><br/>"
							 +"<div><label class=\"lab-font\">收款方名称:&nbsp;</label>"
							 +"<span>"+val.recevieName+"</span></div>"
							 +"<div><label class=\"lab-font\">开户行名称:&nbsp;</label>"
							 +"<span>"+val.recevieBankName+"</span></div>"
							 +"<div><label class=\"lab-font\">收款方账号:&nbsp;</label>"
							 +"<span>"+val.recevieBankCard+"</span></div>"
							 +"</div>"
							 +"</div>";
					}
					if(i == 1){
						str8 += "<div class=\"ibox-content text-show\" style=\"padding:0px; padding-bottom:5px;\">"
							 +"<h4 class=\"tit-center\" >中央电视台工会联合会汇款申请单</h4>"
							 +"<p class=\"tit-center\">"+val.remitBudgetNum+"</p>"
							 +"<div class=\"form-group\" style=\"margin-bottom:5px;\">"
							 +"<label>汇款方信息</label><br/>"
							 +"<div><label class=\"lab-font\">汇款部门:&nbsp;</label>"
							 +"<span>"+val.remitCenterName+"</span></div>"
							 +"<div><label class=\"lab-font\">汇款金额:&nbsp;</label>"
							 +"<span>"+val.remitCost+"</span></div>"
							 +"<div><label class=\"lab-font\">汇款用途:&nbsp;</label>"
							 +"<span>"+val.remitUse+"</span></div>"
							 +"<div class=\"form-group\">"
							 +"<label>收款方信息</label><br/>"
							 +"<div><label class=\"lab-font\">收款方名称:&nbsp;</label>"
							 +"<span>"+val.recevieName+"</span></div>"
							 +"<div><label class=\"lab-font\">开户行名称:&nbsp;</label>"
							 +"<span>"+val.recevieBankName+"</span></div>"
							 +"<div><label class=\"lab-font\">收款方账号:&nbsp;</label>"
							 +"<span>"+val.recevieBankCard+"</span></div>"
							 +"</div>"
							 +"</div>";
					}
					
				})
				
						str8 += "<div id=\"showhk\" style=\"display:none;\">";
				
				$.each(data.remitBillList,function(i,val){
					if(i > 1){
						str8 += "<div class=\"ibox-content text-show\" style=\"padding:0px;padding-bottom:5px;\">"
							 +"<h4 class=\"tit-center\" >中央电视台工会联合会汇款申请单</h4>"
							 +"<p class=\"tit-center\">"+val.remitBudgetNum+"</p>"
							 +"<div class=\"form-group\" style=\"margin-bottom:5px;\">"
							 +"<label>汇款方信息</label><br/>"
							 +"<div><label class=\"lab-font\">汇款部门:&nbsp;</label>"
							 +"<span>"+val.remitCenterName+"</span></div>"
							 +"<div><label class=\"lab-font\">汇款金额:&nbsp;</label>"
							 +"<span>"+val.remitCost+"</span></div>"
							 +"<div><label class=\"lab-font\">汇款用途:&nbsp;</label>"
							 +"<span>"+val.remitUse+"</span></div>"
							 +"</div><div class=\"form-group\">"
							 +"<label>收款方信息</label><br/>"
							 +"<div><label class=\"lab-font\">收款方名称:&nbsp;</label>"
							 +"<span>"+val.recevieName+"</span></div>"
							 +"<div><label class=\"lab-font\">开户行名称:&nbsp;</label>"
							 +"<span>"+val.recevieBankName+"</span></div>"
							 +"<div><label class=\"lab-font\">收款方账号:&nbsp;</label>"
							 +"<span>"+val.recevieBankCard+"</span></div>"
							 +"</div>"
							 +"</div>";
					}
				})
					str8 += "</div>"
						 +"<a href=\"javascript:showhkVoid();\" id=\"btnhk\" class=\"btn btn-xs btn-white\" style=\"border:0;\">查看更多</a>"
						 +"</div>";
				
					$("#ninth").html(str8);
					
					 //汇款单显示隐藏
		             var number =$(".text-show").length;
		             if(number > 2){
		            	$("#btnhk").css("display","block");
		             }else{
		            	$("#btnhk").css("display","none");
		             }
					
					var	str9 = "";
					str9 += "<div class='"+styleName+"'>"
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
					
				$("#tenth").html(str9);	
			}
			
				
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
});


        
      
        
        
    















    
    


   
            
                
            

            
                
                
            
        

        
            
                
            

            
               
                
            
        

        
        
       
       
            
                

  
   
        


