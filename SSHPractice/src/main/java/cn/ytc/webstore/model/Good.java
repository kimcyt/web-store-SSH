package cn.ytc.webstore.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Good {
	private int id;
	private String name;
	private double price;
	private List<String> gallery;
	private int category;
	
	
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
	public String toString() {
		return "Good [id=" + id + ", name=" + name + ", price=" + price + ", gallery=" + gallery + ", category="
				+ category + "]";
	}
	
	
	
}
