//五大洲id;
var continentId;
$(function(){
	//最外层栏目，五大洲
	$.ajax({
		type:"get",
		url:"../index/getChannelListByParentId.do",
		async:true,
		dataType:"json",
		data:{channelParentId:3,type:0},
		success:function(data){
			var str = "";
			$.each(data.channelList,function(i,val){
				var styleName="weui_navbar_item";
				if(i==0){
					styleName="weui_navbar_item weui_bar_item_on";
					findCountryByContinentId(val.channelId);
				}
				str = str + "<div class='"+styleName+"' id='bar"+val.channelId+"' onclick='findCountryByContinentId("+val.channelId+")'>"+val.channelName+"</div>";
			});
			$("#navbar").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
	
	//签证知识必读
	$.ajax({
		type:"get",
		url:"../index/getVisaknowledge.do",
		async:true,
		dataType:"json",
		success:function(data){
			var str = "";
			$.each(data.contentList,function(i,val){
				var styleName="";
				if(i!=0){
					styleName="style='padding-top: 5px;'";
				}
				str += "<p "+styleName+">"+val.txt+"</p>";  
			});
			$("#visaknowledge").html(str)
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
		
	});
	
	//反馈与建议  ---提交
	$("#comment").click(function(){
		var txt = $("#commentText").val();
		if(txt==null||txt==""){
			alert("添写评论，再提交！");
		}else{
			$.ajax({
				type:"get",
				url:"../index/comment.do",
				async:true,
				dataType:"json",
				data:{txt:txt},
				success:function(resp){
					if(resp.msg == "ok"){
						alert("反馈成功！请待审核通过后查看。");
						$("#commentText").val('');
					}
				},
				error:function(e){
					alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
				}
				
			});
		}
	});
		
	//反馈与建议  ---点赞
	$("#praise").click(function(){
		$.ajax({
			type:"get",
			url:"../index/praise.do",
			async:true,
			dataType:"json",
			success:function(resp){
			},
			error:function(e){
				alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
			}
			
		});
	});
	
	//获取反馈与建议列表
	$.ajax({
		type:"get",
		url:"../index/getCommentList.do",
		async:true,
		dataType:"json",
		success:function(data){
			var str = "";
			$.each(data.commentList,function(i,val){
				var createTime = val.createTime;
				createTime = createTime.substring(0,createTime.length-2);
				str += " <div class='weui_uploader'><div class='weui_uploader_hd weui_cell comment_tit'><div class='weui_cell_bd weui_cell_primary leave_nm'>"
				str += " <img src='images/icon_leave.png' class='leave_img'>"+val.commentUserId;
				str += " </div><div class='weui_cell_ft'>"+createTime
				str += " </div></div><div class='weui_media_desc comment_cen'>"+val.text
				str += " </div></div>";
			});
			$("#commentList").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
	
	//文本域字数
	$("#commentText").bind('input propertychange', function() {
	    $('#wordNum').html($(this).val().length);
	});
});

//每个大洲下栏目
function findCountryByContinentId(continentId){
	$.ajax({
		type:"get",
		url:"../index/getChannelListByParentId.do",
		async:true,
		dataType:"json",
		data:{channelParentId:continentId,type:1},
		success:function(data){
			var str = "";
			$.each(data.channelList,function(i,val){
				str = str + "<li><a href='./visa_info.html?channelId="+val.channelId+"'>"+val.channelName+"</a></li>"
			});
			$("#navbar div").removeClass("weui_bar_item_on");
			$("#bar"+continentId).addClass("weui_bar_item_on");
			$("#country_ul").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
}





