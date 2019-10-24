package mvc.examples.model;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Cat {
	String timeCreating; 
	static {
		System.out.println("Cat類已載入");
	}
	public Cat() {
		System.out.println("Cat類已實例化...");
		Date date = new Date();
		timeCreating = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	public String getTimeCreating() {
		return timeCreating;
	}

	public void setTimeCreating(String timeCreating) {
		this.timeCreating = timeCreating;
	}

	@Override
	public String toString() {
		return "Cat [createTime=" + timeCreating + "]";
	} 
	
}
