/**
 * 
 */
package lists;

/**
 * Author jCudd
 * Date 19/06/2019
 * Table Linked List
 * 
 */
import java.util.*;

import restaurant.Menu;
import java.io.*;

public class MenuList {

	Menu itemName = Menu.getItemName();
	Menu price = Menu.getPrice();
	Menu quantity = Menu.getQuantity();
	
	
	static MenuList menuList = new MenuList();
	private static Object category;
	
	public void SaveTableList() throws IOException
	{
		Scanner  inputStream = new Scanner(new File("menuItems.dat"));
		
		try {
			
			String itemName = inputStream.nextLine();
			String price = inputStream.nextLine();
			String quantity = inputStream.nextLine();
			Menu m = new Menu(itemName,price,quantity);
			menuList.append(m);
		}finally {
			inputStream.close();
		}
	}
	static String food = "";
	String drink = "";
	
	MenuNode   head;  // Head is first node in menu list
	
	public boolean isEmpty() {
			
		return length() == 0;
	}
	// inserting a node in general
	public void insert(Menu item) {
		
		MenuNode node = new MenuNode(item);
		node.item = item;
		node.next = null;
		
		if(head == null) {
			
			head = node;
		}
		else {
			
			MenuNode n = head;
			while(n.next!=null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	//insert data at start
		public void insertAtStart(Menu item) {
			
			MenuNode node = new MenuNode(item);
			node.item = item;
			node.next = null;
			node.next = head;
			head = node;
		}
	
	//insert data at a particular index
		public void insertAt(int index, Menu item) {
			
			MenuNode node = new MenuNode(item);
			node.item = item;
			node.next = null;
			
			if(index == 0) {
				insertAtStart( item);
			}else {
			MenuNode n = head;
			for(int i = 0; i < index-1; i++) {
				
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
			}
		}

    //deleting a node and its contents
	public void deleteAt(int index) {
		
		if(index == 0) {
			
			head = head.next;
		}else {
			
			MenuNode n = head;
			MenuNode n1 = null;
			for(int i = 0; i < index-1; i++) {
				
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			//System.out.println("n1 " + n1.data);
			n1 = null;
		}
	}

	// appending a node	
	public void append(Menu data){
	    if(head == null){
	        head = new MenuNode(data);
	        return;
	    }
	    tail().next = new MenuNode(data);
	    }
	//define tail node	
	private MenuNode tail() {
		MenuNode tail = head;
	     
	    // Find last element of Menu list known as tail
	    while(tail.next != null){
	        tail = tail.next;
	    }      
	    return tail;
	     
	}
	//define length of sequence	
	public int length() {
		int length = 0;
		MenuNode current = head;  // Starts counting from head - first node
		while(current != null){
		    length ++;
		    current = current.next;
		}
		return length;
	}
	
	
	
	/**
	 * @return the category
	 */
	public static Object getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public static Object setCategory(Object category) {
		MenuList.category = category;
		return category;
	}

	// inner class menu node
	class MenuNode {

		MenuNode next;
		private Menu item;

		public MenuNode(Menu data) {
			this.item = data;
		}

		
		public void show() {
			MenuNode node = head;
			
			while (node.next!=null) {
				
				System.out.println(node.item);
				node = node.next;
			}
			System.out.println(node.item);
		}

	}

}
