package com.app4j.tradeobserver.stock.entity.id;

import java.io.Serializable;

import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;

public class StockTradeSituationDtoId implements Serializable {
	protected String ymdDay;
	protected String stockCode;

    public StockTradeSituationDtoId() {}

    public StockTradeSituationDtoId(String ymdDay, String stockCode) {
        this.ymdDay = ymdDay;
        this.stockCode = stockCode;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockTradeSituationDto stockTradeSituation = (StockTradeSituationDto) o;

        return stockCode.equals(stockTradeSituation.getStockCode()) 
        	&& ymdDay.equals(stockTradeSituation.getYmdDay());
    }
    
    public int hashCode() {		
		int result;
	    result = ymdDay.hashCode();
	    result = 29 * result + stockCode.hashCode();
	    return result;
    }
}