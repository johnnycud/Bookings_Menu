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

import restaurant.Table;

import java.io.*;

public class TableList {
	
	static TableList tableList = new TableList();
	//save table list
	public void SaveTableList() throws IOException
	{
		Scanner  inputStream = new Scanner(new File("tables.dat"));
		
		try {
			String tableId = inputStream.nextLine();
			String status = inputStream.nextLine();
			String bookingTime = inputStream.nextLine();
			String seats = inputStream.nextLine();
			Table t = new Table(tableId,bookingTime,status,seats);
			tableList.append(t);
		}finally {
			inputStream.close();
		}
	}
	
	TableNode head;  // Head is first node in table list
	
	public boolean isEmpty() {
			
		return length() == 0;
	}
	// inserting in general	
	public void insert(Table data) {
		
		TableNode node = new TableNode(data);
		node.data = data;
		node.next = null;
		
		if(head == null) {
			
			head = node;
		}
		else {
			
			TableNode n = head;
			while(n.next!=null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	//insert data at start
	public void insertAtStart(Table data) {
			
		TableNode node = new TableNode(data);
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
	}
	//insert data at a particular index
	public void insertAt(int index, Table data) {
			
		TableNode node = new TableNode(data);
		node.data = data;
		node.next = null;
			
		if(index == 0) {
			insertAtStart( data);
		}else {
			TableNode n = head;
			for(int i = 0; i < index-1; i++) {
				
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
			}
		}
	
	// deleting a node and its contents
	public void deleteAt(int index) {
			
		if(index == 0) {
				
			head = head.next;
		}else {
				
			TableNode n = head;
			TableNode n1 = null;
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
	public void append(Table t){
	    if(head == null){
	        head = new TableNode(t);
	        return;
	    }
	    tail().next = new TableNode(t);
	    }
		
	private TableNode tail() {
		TableNode tail = head;
	     
	    // Find last element of Table list known as tail
	    while(tail.next != null){
	        tail = tail.next;
	    }      
	    return tail;
	     
	}
	//define length	
	public int length() {
		int length = 0;
		TableNode current = head;  // Starts counting from head - first node
		while(current != null){
		    length ++;
		    current = current.next;
		}
		return length;
	}
	// inner class table node
	public class TableNode {

		TableNode next;
		private Table data;

		public TableNode(Table t) {
			this.data = t;
		}

		public void show() {
			TableNode node = head;
			
			while (node.next!=null) {
				
				System.out.println(node.data);
				node = node.next;
			}
			System.out.println(node.data);
		}

	}
}
