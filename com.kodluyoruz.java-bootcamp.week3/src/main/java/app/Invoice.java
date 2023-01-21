package app;

import java.time.LocalDateTime;

import app.Helper.DateHelper;

public class Invoice{
    
    // oluşan her Invoice için unique id sağlar
    private static int autoIncrementId = 0;
    
    private int id;
    private String companyName;
    private String sector;
    private double amount;
    private LocalDateTime dateOfInvoice;
    
    public Invoice(double amount, LocalDateTime dateOfInvoice, String companyName, String sector){
        id = ++autoIncrementId;
        this.amount = amount;
        this.dateOfInvoice = dateOfInvoice;
        this.companyName = companyName;
        this.sector = sector;
    }
    
    public int getId(){
        return id;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public LocalDateTime getDateOfInvoice(){
        return dateOfInvoice;
    }

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
    
	@Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("Invoice Id : ").append(id).append("\nAmount : ").append(amount).append("\nCompany Name : ").append(companyName)
    	.append("\nSector : ").append(sector).append("\nDate of Invoice : ")
    	.append(DateHelper.DateFormatter(dateOfInvoice)).append("\n");
    	return sb.toString();
    }
	
}
