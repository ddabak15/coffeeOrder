package service;

import java.util.List;

import dto.CoffeeDto;
import dto.OrderDto;

public interface CoffeeService {

	public List<CoffeeDto> getCoffeeList();
	
	public int getPrice(String coffeeName, String selectSize);
	
	public boolean setOrderList(OrderDto orderDto);

	public List<OrderDto> getHistoryList();
}
