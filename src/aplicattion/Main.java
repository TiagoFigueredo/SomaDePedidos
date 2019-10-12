package aplicattion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		String datastring = sc.next();
		Date niver = date.parse(datastring);
		Client cliente = new Client(name,email,niver);
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.next();
		OrderStatus os1 = OrderStatus.valueOf(status);
		Date x1 = new Date();
		Order pedido = new Order(x1,os1,cliente);
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter #"+ i +" item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameproduct = sc.next();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			Product x = new Product(nameproduct,price);
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			OrderItem y = new OrderItem(quantity,x.getPrice(),x);
			pedido.addItem(y);
		}
		System.out.println("ORDER SUMMARY: ");
			
			System.out.println("Order items: ");
			System.out.println(pedido);
		sc.close();
	}

}
