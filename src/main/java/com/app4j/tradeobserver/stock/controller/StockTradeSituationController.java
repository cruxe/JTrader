package com.app4j.tradeobserver.stock.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app4j.tradeobserver.common.json.CustomDefaultResponse;
import com.app4j.tradeobserver.common.util.DateUtil;
import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;
import com.app4j.tradeobserver.stock.service.SupplyAndDemandService;

@Controller
@RequestMapping("/stock/trade-situation")
public class StockTradeSituationController {
	
	//@Autowired
	@Resource(name="supplyAndDemandService")
	private SupplyAndDemandService supplyAndDemandService;
	
	 @RequestMapping(value = "/getlist", method = RequestMethod.GET)
     public @ResponseBody CustomDefaultResponse<StockTradeSituationDto> getList(
       @RequestParam("year") int year
       ,@RequestParam("month") int month
       ,@RequestParam("day") int day
     ) throws ParseException { 

		 String maxDay = supplyAndDemandService.getMaxYmdDay("005930");
		 String fromDay = DateUtil.addYmdDay(new SimpleDateFormat("yyyyMMdd").parse(maxDay), -year, -month, -day);
		 
		 List<StockTradeSituationDto> stockTradeSituationList = 
				 supplyAndDemandService.getStockTradeSituationList(fromDay, maxDay, "005930");
		 Collections.reverse(stockTradeSituationList);
		 
		 CustomDefaultResponse<StockTradeSituationDto> response = new CustomDefaultResponse<StockTradeSituationDto>();
		 
		 response.setRows(stockTradeSituationList);
		 
		 response.setRecords(String.valueOf(stockTradeSituationList.size()));
		 
		 response.setPage("1");
		 
		 response.setTotal("10");
		 
		 return response;	 
	 }
	 
	

}
