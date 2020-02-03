package dto;

public class OrderDto {
	private String id;
	private String name;
	private String syrup;
	private String size;
	private String etc;
	private String sysdate;
	private int count;
	private int price;
	

	public OrderDto() {
	}






	public OrderDto(String id, String name, String syrup, String size, String etc, String sysdate, int count,
			int price) {
		super();
		this.id = id;
		this.name = name;
		this.syrup = syrup;
		this.size = size;
		this.etc = etc;
		this.sysdate = sysdate;
		this.count = count;
		this.price = price;
	}






	public OrderDto(String id, String name, String sysdate, String size, int count, int price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.sysdate = sysdate;
		this.count = count;
		this.price = price;
	}






	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSysdate() {
		return sysdate;
	}

	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}

	
	@Override
	public String toString() {
		return "OrderDto [name=" + name + ", syrup=" + syrup + ", size=" + size + ", etc=" + etc + ", count=" + count
				+ ", price=" + price + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
