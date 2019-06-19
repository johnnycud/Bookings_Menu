/**
 * 
 */
package restaurant;

import java.time.LocalDate;

/**
 * Author jCudd
 * Date 19/06/2019
 * Table and its attributes
 * 
 */
public class Table {
	
	private static LocalDate date;
	static String tableId;
	static String seats;
	private static String bookingTime;
	public Table next;
	
	public Table(String tableId, String seats, String status, String bookingTime) {
		
		Table.setDate(date);
		Table.setTableId(tableId);
		Table.setSeats(seats);
		Table.setStatus(status);
		this.setBookingtime(bookingTime);
	}
	
	
	public Table(LocalDate value, String text, String text2, String text3, String text4) {
		// TODO Auto-generated constructor stub
	}


	public static String isTableFree(String string) {
		
		if(Table.date == Booking.getDate() && bookingTime == Booking.getSittingTime() && tableId == Booking.getTableNo() ) {
			return "Booked";
		
		}else
			return "Available";
	}

	@Override
	public String toString() {
		return "Table [Date = " + this.getDate()  +"/t" +"Table Id = " + this.getTableId()  +"/t" + ", Seats= " + this.getSeats()  +"/t" + ", Status=" + this.getStatus()  +"/t"
				+ "]";
	}

	public String getTableId() {
		return tableId;
	}

	public static void setTableId(String tableId) {
		Table.tableId = tableId;
	}

	public String getSeats() {
		return seats;
	}

	public static void setSeats(String seats) {
		Table.seats = seats;
	}

	public static String getBookingtime() {
		return bookingTime;
	}

	public void setBookingtime(String bookingTime) {
		Table.bookingTime = bookingTime;
	}

	public String getStatus() {
		return isTableFree("");
	}

	public static void setStatus(String status) {
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public static void setDate(LocalDate date) {
		Table.date = date;
	}
	

}


