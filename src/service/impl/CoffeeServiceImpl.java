package service.impl;

import java.util.List;

import dao.CoffeeDao;
import dao.impl.CoffeeDaoImpl;
import dto.CoffeeDto;
import dto.OrderDto;
import service.CoffeeService;

public class CoffeeServiceImpl implements CoffeeService {

	CoffeeDao dao = new CoffeeDaoImpl();
	
	@Override
	public List<CoffeeDto> getCoffeeList() {
		return dao.getCoffeeList();
	}

	@Override
	public int getPrice(String coffeeName, String selectSize) {
		return dao.getPrice(coffeeName, selectSize);
	}

	@Override
	public boolean setOrderList(OrderDto orderDto) {
		
		return dao.setOrderList(orderDto);
	}

	@Override
	public List<OrderDto> getHistoryList() {
		return dao.getHistoryList();
	}
	
	
	
}
