package cn.blankworld.pojo;

public class Product {
	private Integer id;
	private String name;
	private Double price;

	/**
	 * 动态传入值
	 * 
	 * @param obj
	 */

	public Product() {

	}

	public Product(Object... obj) {
		if (obj != null && obj.length != 0 && obj.length < 3) {
			for (int i = 0; i < obj.length; i++) {
				if (String.class == obj[i].getClass()) {
					this.name = (String) obj[i];
				} else if (Double.class == obj[i].getClass()) {
					this.price = (Double) obj[i];
				}
			}
			// 如果传入的值都不符合，按照对象初始化全部赋予初始化值
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
