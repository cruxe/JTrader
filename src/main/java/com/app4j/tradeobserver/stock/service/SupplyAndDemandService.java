package com.app4j.tradeobserver.stock.service;

import java.util.List;

import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;

public interface SupplyAndDemandService {
	
	StockTradeSituationDto getStockTradeSituation(String ymdDay, String stockCode);
	
	List<StockTradeSituationDto> getStockTradeSituationList(String fromDay, String toDay, String stockCode);
	
	String getMaxYmdDay(String stockCode);

}
