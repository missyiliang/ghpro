var pagenum = 0;
$(function(){
	$.ajax({
		type:"get",
		url:"../servlet/waitServlet",
		async:true,
		dataType:"json",
		data:{pagenum:pagenum},
		success:function(data){
			var str = "";
			$.each(data.wlist,function(i,val){
				var styleName="weui_navbar_item";
				if(i==0){
					/*styleName="weui_navbar_item weui_bar_item_on";
					findCountryByContinentId(val.channelId);*/
				}
				str += "<div class=\"ibox float-e-margins\">"
						+ "<div class=\"ibox-content\">"
						+ "<h4><a href=\"#\">" + val.title + "</a></h4>"
						+ "<div class=\"form-group\">"
						+ "<label>申请时间:</label>"
						+ "<span>" + val.applyTime + "</span>"
						+ "</div>"
						+ "<div class=\"form-group\">"
						+ "<label>所属中心:</label>"
						+ "<span>" + val.centerName + "</span>"
						+ "</div></div></div>";
				//  = str + "<div class='"+styleName+"' id='bar"+val.channelId+"' onclick='findCountryByContinentId("+val.channelId+")'>"+val.channelName+"</div>";
			});
			$("#wlistdiv").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
});


