package springpractise.entity;

import java.util.ArrayList;
import java.util.List;

public enum Title {
	MR("Mr"),
	MRS("Mrs");
	private String code;
	private Title(String code) {
	       this.code = code;
	   }
	public void setCode(String code) {
	       this.code = code;
	   }
	public static List<String> getTitles(){
		List<String> result = new ArrayList<String>();
		result.add(MR.code);
		result.add(MRS.code);
		return result;
	}
}
