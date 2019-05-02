package cn.ytc.webstore.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Category {
	private static HashMap<Integer, String> categoryMap = new HashMap<Integer, String>();
	private static ArrayList<Category> categories = new ArrayList<Category>();
	
	private int NO;
	private String name;
	
	
	static {
		Properties prop = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream("C:\\Users\\yunti\\Desktop\\java\\spring\\spring projects\\SSH web-store\\SSHPractice\\src\\main\\resources\\categories.properties");
			prop.load(in);
			for(Entry category: prop.entrySet()) {
				getCategoryMap().put(Integer.parseInt((String) category.getKey()), category.getValue());
				categories.add(new Category(Integer.parseInt((String)category.getKey()), (String)category.getValue()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Category(int nO, String name) {
		super();
		NO = nO;
		this.name = name;
	}
	
	

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getCategory(int id) {
		return (String) getCategoryMap().get(id);
	}
	
	public static List getCategories() {
		return categories;
	}

	public static HashMap getCategoryMap() {
		return categoryMap;
	}

}
