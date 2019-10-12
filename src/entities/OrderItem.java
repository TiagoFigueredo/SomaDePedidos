package entities;

public class OrderItem {
	public OrderItem(Integer quantity, Double price,Product x) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.x = x;
	}
	private Integer quantity;
	private Double price;
	private Product x;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double subtotal() {
		return quantity*price;
	}
	public String toString() {
			return x.getName()
					+ ", $" 
					+ String.format("%.2f", price) 
					+ ", Quantity: " 
					+ quantity + 
					", Subtotal: $" 
					+ String.format("%.2f", subtotal());
	}
}
