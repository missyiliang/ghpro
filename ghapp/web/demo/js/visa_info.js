$(function(){
	var channelId = GetQueryString("channelId");
	$.ajax({
		type:"get",
		url:"../detail/getContentByChannelId.do",
		async:true,
		dataType:"json",
		data:{channelId:channelId},
		success:function(data){
			var basicInfo = "";
			var shortVisitVisa = "";
			var transitVisa = "";
			$.each(data.contentList,function(i,val){
				if(val.channelName=="基本信息"){
					var str = "<div class='weui_panel_bd'><div class='weui_cell relation_div'><div class='weui_cell_hd rel_num'>"
							+" <label class='weui_label rel_lable'>"+val.title+"</label>"
							+" </div><div class='weui_cell_bd weui_cell_primary'>"+val.txt+"</div></div></div>";
					basicInfo += str;
				}else if(val.channelName=="短期访问签证"){
					var str = "<div class='weui_panel_bd'><div class='weui_cell relation_div'><div class='weui_cell_hd rel_num2'>"
							+ "<label class='weui_label rel_lable'>"+val.title+"</label></div><div class='weui_cell_bd weui_cell_primary'>"
							+ val.txt;
					var attachStr =  "";
					$.each(val.attachmentList,function(j,attach){
						attachStr +="<p style='color:#3279b9;'>•&nbsp;&nbsp;<span>"+attach.attachmentName+"</span></p>";
					});
					str +=attachStr;
					str += "</div></div></div>";
					shortVisitVisa += str;
				}else if(val.channelName=="过境签证"){
					var str = "<div class='weui_panel_bd'><div class='weui_cell relation_div'><div class='weui_cell_hd rel_num2'>"
							 +"</div>"
							 +"<div class='weui_cell_bd weui_cell_primary'>"+val.txt+"</div></div></div>"
					transitVisa += str;
				}
			});
			$("#basicInfo").html(basicInfo);
			$("#shortVisitVisa").html(shortVisitVisa);
			$("#transitVisa").html(transitVisa);
			
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
	
	//文本域字数
	$("#consulting").bind('input propertychange', function() {
	    $('#wordNum').html($(this).val().length);
	});
	
	//咨询与问答提交
	$("#submitGuestbook").click(function(){
		var content = $("#consulting").val();
		$.ajax({
			type:"get",
			async:true,
			url:"../detail/saveGuestbook.do",
			dataType:"json",
			data:{channelId:channelId,content:content},
			success:function(resp){
				if(resp.resp_status == "ok"){
					alert("留言成功！");
					location.reload();
				}
			},
			error:function(e){
				alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
			}
		});
	});
	
	//获取咨询与问答列表
	$.ajax({
		type:"get",
		async:true,
		url:"../detail/getGuestbookListByChannelId.do",
		dataType:"json",
		data:{channelId:channelId},
		success:function(resp){
			var str = "";
			$.each(resp.guestbookList,function(i,val){
				var question = "";
				var	answer = "";
				var createTime = val.createTime;
				createTime = createTime.substring(0,createTime.length-2);
				question += "<div class='weui_uploader'><div class='weui_uploader_hd weui_cell comment_tit'><div class='weui_cell_bd weui_cell_primary leave_nm'>"
				question +="<img src='images/icon_q.png' class='leave_img'>"+val.userName
				question +="</div><div class='weui_cell_ft'>"+createTime+"</div></div>"
				question +="<div class='weui_media_desc comment_cen'>"+val.content+"</div></div>"
				if(val.reply!="undefined" && val.reply!=null && val.reply!=""){
					var replayTime = val.replayTime;
					replayTime = replayTime.substring(0,replayTime.length-2);
					answer += "<div class='weui_uploader'><div class='weui_uploader_hd weui_cell comment_tit'><div class='weui_cell_bd weui_cell_primary leave_nm'>"
					answer +="<img src='images/icon_a.png' class='leave_img'>"+val.memberName
					answer +="</div><div class='weui_cell_ft'>"+replayTime+"</div></div>"
					answer +="<div class='weui_uploader_bd comment_cen'>"+val.reply+"</div></div>"
				}
				str = str + question + answer;
			});
			$("#guestbookList").html(str);
		},
		error:function(e){
			alert("网络异常，数据加载错误。请联系管理员或稍后再试！");
		}
	});
});

//获取网址参数值
function GetQueryString(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return unescape(r[2]); return null;
}