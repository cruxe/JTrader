package com.app4j.tradeobserver.spring.db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app4j.tradeobserver.common.predicate.BetweenPredicate;
import com.app4j.tradeobserver.common.util.DateUtil;
import com.app4j.tradeobserver.stock.entity.StockTradeSituationDto;
import com.app4j.tradeobserver.stock.service.SupplyAndDemandService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml", "classpath:spring/appServlet/servlet-context.xml", "classpath:spring/hibernate-context.xml"})
public class DaoTest {
	
	@Autowired
    private SupplyAndDemandService supplyAndDemandService;

	/*samsung electronics*/
    private final String ymdDay = "20140528";
    private final String stockCode = "005930"; 
    private final int price = 1433000;    

    @After
    public void tearDown() throws Exception {
    }
    
    /*
     * data already inserted
     */
    @Test
    public void getStockTradeSituationTest() throws Exception {
    	StockTradeSituationDto stockTradeSituation = supplyAndDemandService.getStockTradeSituation(ymdDay, stockCode);
        
        assertEquals(price, stockTradeSituation.getPrice());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void getStockTradeSituationListTest() throws Exception {
    	List<StockTradeSituationDto> stockTradeSituationList = supplyAndDemandService.getStockTradeSituationList("20100514", "20140523", "005930");
    	
    	assertEquals(1000 , stockTradeSituationList.size());
    	
    	Predicate betweenPredicate = new BetweenPredicate(DateUtil.getYmdFormatDate("20140516"), DateUtil.getYmdFormatDate("20140523"));
    	
    	List<StockTradeSituationDto> selectedList = (List<StockTradeSituationDto>) CollectionUtils.select(stockTradeSituationList, betweenPredicate);
    	assertEquals(6 , selectedList.size());
    }
    @Test
    public void getMaxYmdDayTest() throws Exception {
    	String maxDay = supplyAndDemandService.getMaxYmdDay("005930");
    	
    	assertEquals("20140523", maxDay);
    }
}
