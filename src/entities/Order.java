package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	private Date moment;
	private Client client;
	private OrderStatus status;
	private List<OrderItem> pedidos = new ArrayList<>();
	public void addItem(OrderItem item) {
		pedidos.add(item);
	}
	public void removeItem(OrderItem item) {
		pedidos.remove(item);
	}
	public Double total() {
		double total = 0;
		for(OrderItem x : pedidos) {
			total += x.subtotal();
		}
		return total;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public List<OrderItem> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<OrderItem> pedidos) {
		this.pedidos = pedidos;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment  + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : pedidos) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
