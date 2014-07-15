package com.app4j.tradeobserver.common.predicate;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.time.DateUtils;

import com.app4j.tradeobserver.common.util.DateUtil;
import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;

public class BetweenPredicate implements Predicate{
	private Date fromDate;
	private Date toDate;
	
	public BetweenPredicate(Date fromDate, Date toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	@Override
	public boolean evaluate(Object object){
		// TODO Auto-generated method stub
		if(object instanceof StockTradeSituationDto) {
			Date ymdDate = null;
			try {
				ymdDate = DateUtil .getYmdFormatDate(((StockTradeSituationDto) object).getYmdDay());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return ymdDate.after(DateUtils.addDays(fromDate, -1))
				&& ymdDate.before(DateUtils.addDays(toDate, +1));
		}
		return false;
	}

}
