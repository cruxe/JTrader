package com.app4j.tradeobserver.spring.common;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml", "classpath:spring/appServlet/servlet-context.xml", "classpath:spring/hibernate-context.xml"})
public class CommonTest {
	
    @After
    public void tearDown() throws Exception {
    }
    
    /*
     * data already inserted
     */
    @Test
    public void apacheDeteUtilTest() throws Exception {
    	Date today = new Date();
    	String dateFormat = DateFormatUtils.format(today, "yyyyMMdd");
    	System.out.println(dateFormat);
    	
    	String format1 = DateFormatUtils.format(DateUtils.addMonths(today, -5), "yyyyMMdd");
    	System.out.println(format1);
    	
    }
    
}
