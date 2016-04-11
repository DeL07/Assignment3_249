/*
 * Assignment 3 Part 2: Order Creator GUI
 * Authors: Louis-Simon Carle (ID: 26677266) & Mylene Haurie (ID: 26767893)
 * 
 * GUI is made using Swing and accepts 3 parameters in its text fields.
 * When the user clicks Submit, program will verify if the price and volume
 * inputs are valid (price has to be a double and volume has to be an integer).
 * If they are, the status bar at the bottom will display the most recent valid
 * order. Otherwise it will show an error message and the user will have to resubmit their 
 * input. If the user clicks Reset, program will delete whatever is in the text fields,
 * but will still show the most recent valid order in the status bar.
 * While a text field usually converts all inputs to strings, program takes care
 * of converting the price and volume inputs into a double and integer so that 
 * the variables can be used to create BidOrder or OfferOrder objects, and consequently
 * be stored in the OrderBook, if need be.
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class GUI {
<<<<<<< Updated upstream

=======
		
>>>>>>> Stashed changes
	public static void main(String[] args) {

		JPanel panel = new JPanel();
		JFrame frame = new JFrameSetup("Order Generator", 400, 170, panel);
		frame.add(panel);
		frame.setLocationRelativeTo(null); // makes window appear in center of
											// monitor instead of in the
											// upper-left corner
		frame.setVisible(true);

<<<<<<< Updated upstream
	}

=======
>>>>>>> Stashed changes
}

class JFrameSetup extends JFrame {

	private static final long serialVersionUID = 1L; // default serialization UID to keep compiler happy
	static String price;
	static double priceDouble;
	static String volume;
	static int volumeInt;
	static String ID;
	static DecimalFormat moneyFormat = new DecimalFormat("$00.00");

	// JFrame constructor, determines dimensions and name of pop-up window

	public JFrameSetup(String t, int w, int h, JPanel panel) {
		super(); // Calls the constructor of JFrame
		setSize(w, h);
		setTitle(t);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(panel);
	}

	// Method (which is called in JFrameSetup)
	// places everything where it should be inside JPanel.
	// It determines the colors used as well as the
	// locations of all the text fields and the buttons.

	public static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		panel.setBackground(new Color(224, 224, 224));

		// text fields and their respective labels

		JLabel priceLabel = new JLabel("Enter price here: ");
		priceLabel.setBounds(10, 10, 150, 25);
		panel.add(priceLabel);

		JTextField priceText = new JTextField(20);
		priceText.setBounds(150, 10, 150, 25);
		panel.add(priceText);

		JLabel volumeLabel = new JLabel("Enter volume here: ");
		volumeLabel.setBounds(10, 40, 150, 25);
		panel.add(volumeLabel);

		JTextField volumeText = new JTextField(20);
		volumeText.setBounds(150, 40, 150, 25);
		panel.add(volumeText);

		JLabel nameLabel = new JLabel("Enter name here: ");
		nameLabel.setBounds(10, 70, 150, 25);
		panel.add(nameLabel);

		JTextField nameText = new JTextField(20);
		nameText.setBounds(150, 70, 150, 25);
		panel.add(nameText);

		// submit and reset buttons

		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(310, 25, 80, 25);
		panel.add(submitButton);

		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(310, 55, 80, 25);
		panel.add(resetButton);

		JSeparator separator = new JSeparator();
		panel.add(separator);

		// status bar at the bottom

		JLabel lastOrderDisplay = new JLabel("Last Order: N/A",
				SwingConstants.CENTER);
		lastOrderDisplay.setBackground(new Color(192, 192, 192));
		lastOrderDisplay.setOpaque(true);
		lastOrderDisplay.setBounds(0, 120, 400, 25);
		panel.add(lastOrderDisplay);

		// Action listener for submit button.
		// Assigns text field inputs into strings, then verifies
		// if price is a double and volume is an integer. If they are,
		// action listener will parse them into a double and an integer
		// (in case user wants to use the variables in part 1 of assignment)
		// and display the order in the status bar.
		// Otherwise, displays error message and user will be 
		// prompted to enter correct input.
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ID = nameText.getText();
				price = priceText.getText();
				volume = volumeText.getText();

				if (isDouble(price) && isInteger(volume)) {
					volumeInt = Integer.parseInt(volume);
					priceDouble = Double.parseDouble(price);
					lastOrderDisplay.setText("Last order: " + volumeInt
							+ " shares at " + moneyFormat.format(priceDouble));
				} else
					lastOrderDisplay
							.setText("Error: Enter price/volume as a number");

			}
		});
		
		// Action listener for reset button.
		// Clears whatever is written in the text fields
		// but still displays the most recent valid order
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				nameText.setText(null);
				priceText.setText(null);
				volumeText.setText(null);
				lastOrderDisplay.setText("Last order: " + volumeInt
						+ " shares at " + moneyFormat.format(priceDouble));
			}
		});

	}

	// helper method to verify if price user entered is indeed a double
	
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// helper method to verify if volume entered by user is an integer
	
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

	