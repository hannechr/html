package html;

public class Node {
	
	private String tag;
	private String text;
	private Node firstChild;
	private Node lastChild;
	private Node nextSibling;
	private Node previousSibling;
	
	public Node(String tag, String text) {
		this.tag = tag;
		this.text = text;
	
	}
	
//	public void addChild(Node child) {
//		if (firstChild == null)
//			firstChild = child;
//		else {
//			Node i = firstChild;
//			while (i.nextSibling != null)
//				i = i.nextSibling;
//			i.nextSibling = child;
//		}
//	}
//	
	
	public void addChild(Node child) {
		if (firstChild == null) {
			firstChild = child;
			lastChild = child;
		}
		else {
			lastChild.nextSibling = child;
			child.previousSibling = lastChild;
			lastChild = child;
			
		}
	}
	
	public void removeChild(Node child) {
		if (firstChild == child) {
			firstChild = firstChild.nextSibling;
			firstChild.previousSibling = null;
			if (firstChild == null)
				lastChild = null;
		}
		
		else {
			Node currentChild = firstChild;
			while (currentChild.nextSibling != child)
				currentChild = currentChild.nextSibling;
			if (currentChild.nextSibling.nextSibling == null) {
				lastChild = currentChild;
				currentChild.nextSibling = null;
			}
			else {
				currentChild.nextSibling = currentChild.nextSibling.nextSibling;
				currentChild.nextSibling.previousSibling = currentChild;
			}
	}
		
		
			

		
//		if (firstChild == child) {
//			firstChild = firstChild.nextSibling;
//			if (firstChild == null)
//				lastChild == 0;
//		else {
//			Node child1 = firstChild;
//			while (child1.nextSibling != child)
//				child1 = child1.nextSibling;
//			if (child1.nextSibling.nextSibling==null) {
//				lastChild = child1;
//			}
//		child1.nextSibling = child1.nextSibling.nextSibling;
//		}
	}
	
	public String toString() {
		if (text != null)
				return text;
		String result = "<" + tag + ">";
		Node child = firstChild;
		while(child != null) {
			result += child.toString();
			child = child.nextSibling;
		}
		result += "</" + tag + ">";
		return result;
	}
}