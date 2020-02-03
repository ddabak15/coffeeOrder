package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CoffeeDao;
import db.DBClose;
import db.DBConnection;
import dto.CoffeeDto;
import dto.OrderDto;
import singleton.Singleton;

public class CoffeeDaoImpl implements CoffeeDao {

	@Override
	public List<CoffeeDto> getCoffeeList() {
		String sql = " SELECT SEQ, ESPRESSO, SIZE_SHORT, SIZE_TALL, SIZE_GRANDE" + " FROM COFFEELIST ";

		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result

		List<CoffeeDto> list = new ArrayList<CoffeeDto>();
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				CoffeeDto dto = new CoffeeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)

				);
				list.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;

	}

	@Override
	public int getPrice(String coffeeName, String selectSize) {

		int price = 0;
		
		String size = "";
		if (selectSize.equals("Short")) {
			size = " SIZE_SHORT ";
		} else if (selectSize.equals("Tall")) {
			size = " SIZE_TALL ";
		} else if (selectSize.equals("Grande")) {
			size = " SIZE_GRANDE ";
		}

		
		String sql =  " SELECT " + size 
			    	+ " FROM COFFEELIST "
				    + " WHERE ESPRESSO = ? ";


		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, coffeeName);
			
			rs = psmt.executeQuery();

			if (rs.next()) {
				price = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return price;
	}

	@Override
	public boolean setOrderList(OrderDto dto) {
		String sql = " INSERT INTO ORDER_LIST ( SEQ, ID, COF_NAME, COF_SYSDATE, COF_SIZE, COF_COUNT, COF_PRICE ) "
				+ " VALUES ( SEQ_ORDER_LIST.NEXTVAL, ?, ?, SYSDATE, ?, ?, ? ) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();				
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getSize());
			psmt.setInt(4, dto.getCount());
			psmt.setInt(5, dto.getPrice());
			
			count = psmt.executeUpdate();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			DBClose.close(psmt, conn, null);				
		}		
		
		return count>0?true:false;
	}

	@Override
	public List<OrderDto> getHistoryList() {
		String sql = " SELECT ID, COF_NAME, COF_SYSDATE, "
				   + " COF_SIZE, COF_COUNT, COF_PRICE " 
				   + " FROM ORDER_LIST "
				   + " WHERE ID = ? ";

		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result

		List<OrderDto> list = new ArrayList<OrderDto>();
		try {
			Singleton s = Singleton.getInstance();
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s.getLoginID());
			rs = psmt.executeQuery();

			while (rs.next()) {

				OrderDto dto = new OrderDto(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6)
				);
				list.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}
	
	

}
