$(function(){
	//获取栏目名称
	$.ajax({
		type:"get",
		url:"../index/getChannelListByParentId.do",
		async:true,
		dataType:"json",
		data:{channelParentId:1420,type:1},
		success:function(data){
			var str = "";
			$.each(data.channelList,function(i,val){
				var styleName="";
				if(i==0){
					styleName="weui_navbar_item weui_bar_item_on nav_tab1";
					findAttachByChannelId(val.channelId);
				}else if(i==1){
					styleName="weui_navbar_item nav_tab1";
				}else{
					styleName="weui_navbar_item nav_tab2";
				}
				str = str + "<div class='"+styleName+"' id='bar"+val.channelId+"' onclick='findAttachByChannelId("+val.channelId+")'>"+val.channelName+"</div>";
			});
			$("#navbar").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
});

function findAttachByChannelId(channelId){
	//获取栏目名称
	$.ajax({
		type:"get",
		url:"../detail/findAttachByChannelId.do",
		async:true,
		dataType:"json",
		data:{channelId:channelId},
		success:function(data){
			var str = "";
			$.each(data.attachList,function(i,val){
				var styleName="";
				str = str + "<a href='javascript:void(0);' class='weui_btn down_btn'>"+val.attachmentName+"</a>";
			});
			$("#attachList").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
}