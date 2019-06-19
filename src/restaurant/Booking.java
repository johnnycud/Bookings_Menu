/**
 * 
 */
package restaurant;

import java.time.LocalDate;

import javax.swing.JLabel;

/**
 * Author jCudd
 * Date 19/06/2019
 * Bookings and its attributes
 * 
 */

public class Booking<LoacalDate> {
	
	
	static Booking<?> next = null;
	static LocalDate date;
	static String sittingTime = "";
	private static String surname = "";
	static String partyOf = "";
	static String tableNo = "";
	/**
	 * @param date
	 * @param surname
	 * @param partyOf
	 * @param tableNo
	 * @param sittingTime
	 */
	public Booking(LocalDate date,String surname,String sittingTime,String tableNo, String partyOf ) {
		
		
		this.setDate(date);
		this.setSurname(surname);
		this.setPartyOf(partyOf);
		this.setTableNo(tableNo);
		this.setSittingTime(sittingTime);
		
	}

	public Booking(String surName2, String sittingTime2, String tableNo2, String partyOf2) {
		// TODO Auto-generated constructor stub
	}

	public Booking(JLabel surNameLabel, JLabel tableNoLabel, JLabel sittingTimeLabel, JLabel partyOfLabel) {
		// TODO Auto-generated constructor stub
	}

	public static String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		Booking.surname = surname;
	}

	public static String getPartyOf() {
		return partyOf;
	}

	public void setPartyOf(String partyOf) {
		Booking.partyOf = partyOf;
	}

	public static String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		Booking.tableNo = tableNo;
	}

	public static String getSittingTime() {
		return sittingTime;
	}

	public void setSittingTime(String sittingTime) {
		Booking.sittingTime = sittingTime;
	}
	
	private boolean available;
	
	
	public void bookingStatus(boolean available) {
		this.setAvailable(true);
		
		if(Integer.parseInt(getPartyOf()) <= Integer.parseInt(Table.seats) || Integer.parseInt(getSittingTime()) != Integer.parseInt(Table.getBookingtime())) {
			available = true;
		}else 
			return;
	}
	
	
	@Override
	public  String toString() {
		return "Booking [Date = " + Booking.getDate() +"/t" + " Surname = " + Booking.getSurname()  +"/t" + " Sitting Time = " + Booking.getSittingTime() +"/t" + "Table Number= " + Booking.getTableNo()  +"/t" +
				" Number In Party = " + Booking.getPartyOf() +  "]";
	}
	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return the next
	 */
	public Booking<?> getNext() {
		
		return next;
	}

	

	/**
	 * @return the date
	 */
	public static LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		Booking.date = date;
	}


}
