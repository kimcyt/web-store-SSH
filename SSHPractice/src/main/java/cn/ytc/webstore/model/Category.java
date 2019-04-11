package cn.ytc.webstore.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Category {
	private static HashMap categoryMap = new HashMap();
	private static ArrayList<String> categories = new ArrayList<String>();
	
	static {
		Properties prop = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream("categories.properties");
			prop.load(in);
			for(Entry category: prop.entrySet()) {
				categoryMap.put(category.getKey(), category.getValue());
				categories.add((String) category.getValue());
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
	
	public static String getCategory(int id) {
		return (String) categoryMap.get(id);
	}
	
	public List getCategories() {
		return categories;
	}
}
