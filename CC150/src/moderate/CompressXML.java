package moderate;

import java.util.HashMap;

public class CompressXML {
	static HashMap<String, Integer> map; 

	public static void encode(Element root, StringBuffer sb) {
		String rootName = root.getNameCode(); 
		int roorCode = map.get(rootName) ;
		sb.append(roorCode + " "); 
		Attribute[] attrs = root.getAttribute(); 
		for (Attribute attr : attrs) {
			int attName = map.get(attr.name); 
			sb.append(attName + " "); 
			sb.append(attr.value + " "); 
		}
		sb.append("0 "); 
	}
}

class Element{
	String name; 
	Attribute[] attrs; 
	
	public String getNameCode() {
		return name; 
	}
	
	public Attribute[] getAttribute() {
		return attrs; 
	}
}

class Attribute{
	String name; 
	String value; 
}