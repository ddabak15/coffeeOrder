package controller;

import java.util.List;

import dto.CoffeeDto;
import dto.OrderDto;
import service.CoffeeService;
import service.impl.CoffeeServiceImpl;
import singleton.Singleton;
import view.cartView;
import view.coffeeListView;
import view.historyView;
import view.orderView;

public class CoffeeController {

	CoffeeService coffeeServ = new CoffeeServiceImpl();

	public void getCoffeeList() {
		List<CoffeeDto> list = coffeeServ.getCoffeeList();
		new coffeeListView(list);

	}

	public void getOrder() {
		new orderView();
	}
	
	public List<CoffeeDto> getCoffeeName() {
		List<CoffeeDto> list = coffeeServ.getCoffeeList();
		return list;
	}

	public void getPrice(String coffeeName, String selectSize, String selectSyrup, String selectEtc, int count) {
		
		int price = coffeeServ.getPrice(coffeeName, selectSize);
		System.out.println("price : " + price);
		
		OrderDto dto = new OrderDto("", coffeeName, selectSyrup, selectSize, selectEtc, "", count, price);
		new cartView(dto);
	}

	public boolean setOrderList(OrderDto orderDto) {
		return coffeeServ.setOrderList(orderDto);		
	}

	public void getHistoryList() {
		List<OrderDto> list = coffeeServ.getHistoryList();
		new historyView(list);
		
	}

}
