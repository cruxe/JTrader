package com.app4j.tradeobserver.stock.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app4j.tradeobserver.stock.dao.StockTradeSituationDao;
import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;
import com.app4j.tradeobserver.stock.service.SupplyAndDemandService;


@Service("supplyAndDemandService")
@Transactional(readOnly=true)
public class SupplyAndDemandServiceImpl implements SupplyAndDemandService{

//	@Autowired
	@Resource(name="stockTradeSituationDao")
	private StockTradeSituationDao stockTradeSituationDao;
	
	@Override
	public StockTradeSituationDto getStockTradeSituation(String ymdDay, String stockCode) {
		return stockTradeSituationDao.getStockTradeSituation(ymdDay, stockCode);		
	}

	@Override
	public List<StockTradeSituationDto> getStockTradeSituationList(String fromDay,
			String toDay, String stockCode) {
		return stockTradeSituationDao.getStockTradeSituationList(fromDay, toDay, stockCode);
	}

	@Override
	public String getMaxYmdDay(String stockCode) {
		return stockTradeSituationDao.getMaxYmdDay(stockCode);
	}
}
