package com.app4j.tradeobserver.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stock")
public class MediatorController {
	/**
     * Retrieves the JSP page that contains our JqGrid
     */
    @RequestMapping(value = "/trade-situation", method = RequestMethod.GET)
    public String getStockTradeSituationPage() {
    
     // This will resolve to /WEB-INF/jsp/users.jsp page
     return "stock/SupplyAndDemand";
 }

}
