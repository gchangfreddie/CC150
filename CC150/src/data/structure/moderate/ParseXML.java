package data.structure.moderate;

import java.util.*;

import javax.xml.stream.events.Attribute;

public class ParseXML {
	
	public String parse(Element e, StringBuffer sb) { 
		Integer[] a = new Integer[8]; 
		parse(e.name, sb); 
		for (Attribute attr : e.attributes) {
			parse(attr, sb);
		}
		parse("0", sb); 
		if (e.children!=null && e.children.size() >0) {
			for (Element child : e.children) {
				parse(child, sb); 
			}
		}
		if (e.value != null && e.value !="") {
			parse(e.value, sb); 
		}
		parse("0", sb); 
		return sb.toString(); 
	}
	
	public void parse(String s, StringBuffer sb) {
		sb.append(s); 
		sb.append(" "); 
	}

	public void parse(Attribute a, StringBuffer sb) {
		parse(a.getName().toString(), sb);  
		parse(a.getValue(), sb); 
	}
	
	public static void main(String[] args) {
		ParseXML p = new ParseXML();
		Element e = new Element(); 
		e.name = "family"; 
		e.attributes = new ArrayList<Attribute>(); 
		String rs = p.parse(e, new StringBuffer()); 
	}
}

class Element{
	String name; 
	List<Element> children; 
	String value; 
	List<Attribute> attributes; 
}