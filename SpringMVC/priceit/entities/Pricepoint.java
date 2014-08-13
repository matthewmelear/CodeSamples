package com.priceit.entities;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import org.springframework.stereotype.Component;

@Component
public class Pricepoint {
	
	@Override
	public String toString() {
		return "Pricepoints [id=" + pricepointId +"]";
	}
	

	public static final String GET_PRICEPOINTS = "SELECT pd.id as productId, p.id, p.price, p.date, pd.name as product_name, s.name as status_name, " +
			"st.name as store, p.sale_end_date  FROM pricepoint p  join status s on s.id = p.status_fk join product pd" +
			" on pd.id = p.product_fk  join store st on p.store_fk = st.id  WHERE pd.id = :id";

	
//	public static final String TEST = "SELECT pd.id as productId, p.id, p.price, p.date, pd.product_name, st.store_name, " +
//	"s.status_name, p.sale_end_date  FROM pricepoint p  join status s on s.id = p.status_fk join product pd" +
//	" on pd.id = p.product_fk  join store st on p.store_fk = st.id  WHERE pd.id = :id";


	private int pricepointId;
	private String product_name;
	private String store;
	private Date date;
	private String status_name;
	private Date sale_end_date;
	private BigDecimal price;
	private int productId;
	private String name;
	
	public Pricepoint(){
		
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPricepointId() {
		return pricepointId;
	}

	public void setPricepointId(int pricepointId) {
		this.pricepointId = pricepointId;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store_name) {
		this.store = store_name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public Date getSale_end_date() {
		return sale_end_date;
	}

	public void setSale_end_date(Date sale_end_date) {
		this.sale_end_date = sale_end_date;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}


