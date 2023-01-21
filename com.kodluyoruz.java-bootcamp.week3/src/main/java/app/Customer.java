package app;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import app.Helper.DateHelper;

public class Customer{
    
    // oluşan her Customer için unique id sağlar
    private static int autoIncrementId = 0;
    
    private int id;
    private String name;
    private String surname;
    private LocalDateTime createDate;
    private List<Invoice> invoices;
    
    public Customer(String name, String surname, LocalDateTime createDate){
        id = ++autoIncrementId;
        this.name = name;
        this.surname = surname;
        this.createDate = createDate;
        invoices = new ArrayList<Invoice>();
    }
    
	public Customer( String name, String surname, LocalDateTime createDate, List<Invoice> invoices){
        id = ++autoIncrementId;
        this.name = name;
        this.surname = surname;
        this.createDate = createDate;
        this.invoices = invoices;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public LocalDateTime getCreateDate(){
        return createDate;
    }
    
    public List<Invoice> getInvoices(){
        return invoices;
    }
    
    public void setInvoices(List<Invoice> invoices){
        this.invoices = invoices;
    }
    
    @Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("Id : ").append(id).append("\nName & Surname : ").append(name).append(" ").append(surname)
    			.append("\nCreate Date : ").append(DateHelper.DateFormatter(createDate)).append("\n");
    	return sb.toString();
    }
}