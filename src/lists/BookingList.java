/**
 * 
 */
package lists;

/**
 * Author jCudd
 * Date 19/06/2019
 * Bookings linked list
 * 
 */

	
import java.util.*;

import restaurant.Booking;
import java.io.*;


public class BookingList {
		
	private static BookingList b1 = new BookingList();
	private static String surName = Booking.getSurname();
	private static String tableNo = Booking.getTableNo();
	private static String sittingTime = Booking.getSittingTime();
	private static String partyOf = Booking.getPartyOf();
		
	// to save a booking
	public static void saveData() throws FileNotFoundException {	
			
	Scanner  inputStream = new Scanner(new File("bookings.dat"));
		try {
			
			BookingList.surName = inputStream.nextLine();
			BookingList.tableNo = inputStream.nextLine();
			BookingList.sittingTime = inputStream.nextLine();
			BookingList.partyOf = inputStream.nextLine();
				
			Booking<?> bookingData = new Booking<Object>(null, surName, tableNo, sittingTime, partyOf);
			b1.insert(bookingData);
				
		}finally {
			inputStream.close();
		}
			
	}
		
	public BookingList getB1() {
		return b1;
	}
		
	public static BookingNode head;  // Head is first node in bookinglist
		
	public BookingNode tail;  // Head is last node in bookinglist
		
	public boolean isEmpty() {
				
		return length() == 0;
	}
	//insert data in general
	public void insert(Booking<?> booking) {
			
		BookingNode node = new BookingNode(booking);
		node.setData(booking);
		node.next = null;
			
		if(head == null) {
				
			head = node;
		}
		else {
				
			BookingNode n = head;
			while(n.next!=null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	//insert data at start
	public void insertAtStart(Booking<?> data) {
			
		BookingNode node = new BookingNode(data);
		node.setData(data);
		node.next = null;
		node.next = head;
		head = node;
	}
	//insert data at a particular index
	public void insertAt(int index, Booking<?> data) {
			
		BookingNode node = new BookingNode(data);
		node.setData(data);
		node.next = null;
			
		if(index == 0) {
			insertAtStart( data);
		}else {
		    BookingNode n = head;
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
				
			BookingNode n = head;
			BookingNode n1 = null;
			for(int i = 0; i < index-1; i++) {
					
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			//System.out.println("n1 " + n1.data);
			n1 = null;
			}
		}
			
	// append data	
	public void append(Booking<?> bookingData){
		
		if(head == null){
			
		   head = new BookingNode(bookingData);
		   return;
		}
		tail().next = new BookingNode(bookingData);
	}
		
	//define tail node	
	private BookingNode tail() {
		BookingNode tail = head;
		     
		// Find last element of linked list known as tail
		while(tail.next != null){
			tail = tail.next;
		}      
		return tail;
		     
	}
	//define length	
	public int length() {
		int length = 0;
		BookingNode current = head;  // Starts counting from head - first node
		while(current != null){
			length ++;
			current = current.next;
		}
		return length;
		}		
			


	//Node is nested class because it only exists along with linked list
	//Node is private because it's implementation detail

	//inner class booking node
	public static class BookingNode {

		BookingNode next;
		private static Booking<?> data;

		public BookingNode(Booking<?> booking) {
			this.setData(booking);
		}

		public void show() {
			BookingNode node = head;
				
			while (node.next!=null) {
					
				System.out.println(BookingNode.getData());
				node = node.next;
			}
			System.out.println(BookingNode.getData());
		}

		public static Booking<?> getData() {
			return data;
		}

		public void setData(Booking<?> data) {
			BookingNode.data = data;
		}

	}

}
