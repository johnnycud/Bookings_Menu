/**
 * 
 */
package gui;

import java.awt.*;
import lists.BookingList;
import restaurant.Booking;

import javax.swing.*;

/**
 * Author jCudd
 * Date 19/06/2019
 * Bookings linked list
 * 
 */
public class BookingGUI extends JFrame{
	
	//Constants
	
	//GUI components
	
	private static final long serialVersionUID = 1L;
	JTextArea bookingTextArea       = new JTextArea ();
	JLabel surNameLabel             = new JLabel ("Surname: ");
	JTextField surNameTextField     = new JTextField(15);
	JLabel tableNoLabel             = new JLabel ("TableNo: ");
	JTextField tableNoTextField     = new JTextField(5);
	JLabel sittingTimeLabel         = new JLabel ("Sitting Time: ");
	JTextField sittingTimeTextField = new JTextField(8);
	JLabel partyOfLabel             = new JLabel ("Party of: ");
	JTextField partyOfTextField     = new JTextField(5);
	
	JButton addButton               = new JButton("ADD");
	JButton deleteButton            = new JButton("DELETE");
	JButton displayAllButton        = new JButton("DISPLAY ALL");
	JButton tablesButton            = new JButton("TABLES");
	JButton menuButton              = new JButton("MENU");
	JButton exitButton              = new JButton("EXIT");
	
	
	//Class instance data:
	
	private BookingList bookingLinkedList= new BookingList();
	
	public  BookingGUI() {
		
		JPanel flow1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel flow2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel gridPanel = new JPanel(new GridLayout (2,1));
		
		bookingTextArea.setEditable(false);
		
		flow1Panel.add (surNameLabel);
		flow1Panel.add (surNameTextField);
		flow1Panel.add (tableNoLabel);
		flow1Panel.add (tableNoTextField);
		flow1Panel.add (sittingTimeLabel);
		flow1Panel.add (sittingTimeTextField);
		flow1Panel.add (partyOfLabel);
		flow1Panel.add (partyOfTextField );
		
		flow2Panel.add(addButton);
		flow2Panel.add(deleteButton);
		flow2Panel.add(displayAllButton);
		flow2Panel.add(tablesButton);
		flow2Panel.add(menuButton);
		flow2Panel.add(exitButton);
		
		gridPanel.add(flow1Panel);
		gridPanel.add(flow2Panel);
		
		add(bookingTextArea, BorderLayout.CENTER);
		add (gridPanel, BorderLayout.SOUTH);
		
		addButton.addActionListener ( event -> addBooking());
	}
	
	@SuppressWarnings("rawtypes")
	private void addBooking() {
			
		bookingLinkedList.insert
			(new Booking(surNameTextField.getText(),
			tableNoTextField.getText(),
			sittingTimeTextField.getText(),
			partyOfTextField.getText()));
		
		bookingTextArea.setText ("");
		
		for(Booking booking : bookingLinkedList) {
			
			bookingTextArea.append (booking + "\n");
		}
		
		BookingList.saveData();
	}
	
	
	
	public static void main(String[] args) {
		BookingGUI app = new BookingGUI();
		app.setVisible (true);
		app.setSize (700,500);
		app.setLocation (200,100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
