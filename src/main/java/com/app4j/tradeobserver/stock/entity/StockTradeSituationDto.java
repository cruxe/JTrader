package com.app4j.tradeobserver.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.app4j.tradeobserver.stock.entity.id.StockTradeSituationDtoId;

/* reference : 
 * http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate
 * */
@Entity
@Table (name = "STOCK_TRADE_SITUATION")
@IdClass(StockTradeSituationDtoId.class)
public class StockTradeSituationDto {
	
	@Id
    @Column (name = "YMD_DAY")
    private String ymdDay;
	@Id
    @Column (name = "STOCK_CODE")
    private String stockCode;

    @Column (name = "PRICE")
    private int price;

    @Column (name = "DIFF")
    private double diff;

    @Column (name = "ANT")
    private int ant;
    
    @Column (name = "FOREIGNER")
    private int foreigner;
    
    @Column (name = "INSTITUTION")
    private int institution;
    
    @Column (name = "FINANCIAL_INVESTMENT")
    private int financialInvestment;
    
    @Column (name = "TRUST")
    private int trust;
    
    @Column (name = "ASSURANCE")
    private int assurance;
    
    @Column (name = "BANK")
    private int bank;
    
    @Column (name = "INVESTMENT_BANK")
    private int investmentBank;
    
    @Column (name = "PENSION")
    private int pension;
    
    @Column (name = "PRIVATE_EQUITY_FUND")
    private int privateEquityFund;
    
    @Column (name = "INNER_FOREIGNER")
    private int innerForeigner;
    
    @Column (name = "ETC")
    private int etc;
    
    public StockTradeSituationDto() {    }

	public String getYmdDay() {
		return ymdDay;
	}

	public void setYmdDay(String ymdDay) {
		this.ymdDay = ymdDay;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiff() {
		return diff;
	}

	public void setDiff(double diff) {
		this.diff = diff;
	}

	public int getAnt() {
		return ant;
	}

	public void setAnt(int ant) {
		this.ant = ant;
	}

	public int getForeigner() {
		return foreigner;
	}

	public void setForeigner(int foreigner) {
		this.foreigner = foreigner;
	}

	public int getInstitution() {
		return institution;
	}

	public void setInstitution(int institution) {
		this.institution = institution;
	}

	public int getFinancialInvestment() {
		return financialInvestment;
	}

	public void setFinancialInvestment(int financial_investment) {
		this.financialInvestment = financial_investment;
	}

	public int getTrust() {
		return trust;
	}

	public void setTrust(int trust) {
		this.trust = trust;
	}

	public int getAssurance() {
		return assurance;
	}

	public void setAssurance(int assurance) {
		this.assurance = assurance;
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}

	public int getInvestmentBank() {
		return investmentBank;
	}

	public void setInvestmentBank(int investment_bank) {
		this.investmentBank = investment_bank;
	}

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	public int getPrivateEquityFund() {
		return privateEquityFund;
	}

	public void setPrivateEquityFund(int private_equity_fund) {
		this.privateEquityFund = private_equity_fund;
	}

	public int getInnerForeigner() {
		return innerForeigner;
	}

	public void setInnerForeigner(int inner_foreigner) {
		this.innerForeigner = inner_foreigner;
	}

	public int getEtc() {
		return etc;
	}

	public void setEtc(int etc) {
		this.etc = etc;
	}
	
	
}

