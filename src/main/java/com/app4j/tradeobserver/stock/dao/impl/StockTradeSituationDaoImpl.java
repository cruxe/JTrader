package com.app4j.tradeobserver.stock.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metamodel.source.annotations.entity.EntityClass;
import org.springframework.stereotype.Repository;

import com.app4j.tradeobserver.common.dao.impl.AbstractDaoImpl;
import com.app4j.tradeobserver.stock.dao.StockTradeSituationDao;
import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;
import com.app4j.tradeobserver.stock.entity.id.StockTradeSituationDtoId;

@Repository("stockTradeSituationDao")
public class StockTradeSituationDaoImpl extends AbstractDaoImpl<StockTradeSituationDto, StockTradeSituationDtoId> implements StockTradeSituationDao{
	
	protected StockTradeSituationDaoImpl() {
        super(StockTradeSituationDto.class);
    }
	
	@Override
	public StockTradeSituationDto getStockTradeSituation(String ymdDay, String stockCode) {
		return getById(new StockTradeSituationDtoId(ymdDay, stockCode));
	}

	@Override
	public List<StockTradeSituationDto> getStockTradeSituationList(String fromDay,
			String toDay, String stockCode) {
		

		List<StockTradeSituationDto> list = null;
		Criterion criterion = Restrictions.and(
				Restrictions.eq("stockCode", stockCode), Restrictions.between("ymdDay", fromDay, toDay));
		
		return getByCriteria(criterion);
	}

	@Override
	public String getMaxYmdDay(String stockCode) {
		// TODO Auto-generated method stub
		Criteria cr = getCurrentSession().createCriteria(StockTradeSituationDto.class);
		cr.add(Restrictions.eq("stockCode", stockCode));
		cr.setProjection(Projections.max("ymdDay"));
		
		return cr.list().get(0).toString();
	}

}
