<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css"/>" />
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/webjars/jqgrid/4.6.0/css/ui.jqgrid.css"/>" />

<script src="<c:url value="/webjars/jquery/1.9.1/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.3/ui/jquery-ui.js"/>" type="text/javascript"></script> 
<script src="<c:url value="/webjars/jqgrid/4.6.0/js/i18n/grid.locale-kr.js"/>" type="text/javascript"></script>
<script src="<c:url value="/webjars/jqgrid/4.6.0/js/jquery.jqGrid.js"/>" type="text/javascript"></script>

<title>Stock here</title>
</head>
<body>
<table id="dayGrid"></table>

<script type="text/javascript">
jQuery(document).ready(function (){
	jQuery("#dayGrid").jqGrid({
		url:'/tradeobserver/stock/trade-situation/getlist?year=0&month=0&day=5'//-- 머시기
		,datatype: "json"
		,colNames:['일자', '가격', '개인', '세력합', '외국인' ,
		   		 '기관' , '금융투자' , '투신', '보험', '은행',
		   		 '투자은행', '연기금', '사모펀드', '내외국인', '기타']
		,colModel: [
		            {name:'ymdDay',index:'ymdDay', width:60, formatter:fontFormatter},
		            {name:'price',index:'price', width:60, formatter:fontFormatter },
		            {name:'ant',index:'ant', width:60, formatter:fontFormatter },
		            {name:'forceGrp',index:'forceGrp', width:60, formatter:fontFormatter }, // 이거 개발해야함.		            
		            {name:'foreigner',index:'foreigner', width:60, formatter:fontFormatter },
		            {name:'institution',index:'institution', width:60, formatter:fontFormatter },
		            {name:'financialInvestment',index:'financialInvestment', width:60, formatter:fontFormatter },
		            {name:'trust',index:'trust', width:60, formatter:fontFormatter },
		            {name:'assurance',index:'assurance', width:60, formatter:fontFormatter },
		            {name:'bank',index:'bank', width:60, formatter:fontFormatter },
		            {name:'investmentBank',index:'investmentBank', width:60, formatter:fontFormatter },
		            {name:'pension',index:'pension', width:60, formatter:fontFormatter },
		            {name:'privateEquityFund',index:'privateEquityFund', width:60, formatter:fontFormatter },
		            {name:'innerForeigner',index:'innerForeigner', width:60, formatter:fontFormatter },
		            {name:'etc',index:'etc', width:60, formatter:fontFormatter }		                    
		]
		,rowNum:5
		,rowList:[10,20,30]
		,sortname:'ymdDay'
		,autowidth: false
		,viewrecords: false
		,loadonce:true
		,caption:"날짜별"
		,loadError:function(xhr, status, error) {
		    // 데이터 로드 실패시 실행되는 부분
		    alert(error); 
		}
		,jsonReader : {
	        root: "rows",
	        total: "total",
	        records: "records",
	        repeatitems: false,
	        cell: "cell",
	        id: "ymdDay"
	    }
	});
});

function fontFormatter(cellValue, opts, rowObject){ 
    if(cellValue > 0 ) return '<span style="color:red">'+cellValue+'</span>';
    else return '<span style="color:blue">'+cellValue+'</span>'; 
}
</script>

<!-- pager는 없음 -->


</body>
</html>