package com.app4j.tradeobserver.stock.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.app4j.tradeobserver.common.dao.AbstractDao;
import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;
import com.app4j.tradeobserver.stock.entity.id.StockTradeSituationDtoId;

public interface StockTradeSituationDao extends AbstractDao<StockTradeSituationDto, StockTradeSituationDtoId> {
	StockTradeSituationDto getStockTradeSituation(String ymdDay, String stockCode);
	List<StockTradeSituationDto> getStockTradeSituationList(String fromDay, String toDay, String stockCode);
	String getMaxYmdDay(String stockCode);
}
