package cn.ytc.webstore.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Good {
	private int id;
	private String name;
	private double price;
	private List<String> gallery = new ArrayList<String>();
	private int category;
	
	
	
	public Good() {
		super();
	}
	public Good(String name, double price, List<String> gallery, int category) {
		super();
		this.name = name;
		this.price = price;
		this.gallery = gallery;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<String> getGallery() {
		return gallery;
	}
	public void setGallery(List<String> gallery) {
		this.gallery = gallery;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category;
		result = prime * result + ((gallery == null) ? 0 : gallery.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", gallery=" + gallery + ", category="
				+ category + "]";
	}
	
	
	
}
