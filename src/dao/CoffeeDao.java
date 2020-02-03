package dao;

import java.util.List;
import dto.CoffeeDto;
import dto.OrderDto;

public interface CoffeeDao {

	public List<CoffeeDto> getCoffeeList();

	public int getPrice(String coffeeName, String selectSize);

	public boolean setOrderList(OrderDto orderDto);

	public List<OrderDto> getHistoryList();
}
