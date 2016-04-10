
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	
		
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrameSetup("Order Generator", 400, 200, panel);
		frame.add(panel);

		frame.setVisible(true);
		
	}


}

class JFrameSetup extends JFrame {
	
	static double price;
	static int volume;
	static String name; 
	
	public JFrameSetup(String t, int w, int h, JPanel panel)
	{
		super();	// Calls the constructor of JFrame
		setSize(w, h);
		setTitle(t);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		placeComponents(panel);
	}
	public static void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		panel.setBackground(new Color(224, 224, 224));

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

		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(10, 120, 80, 25);
		panel.add(submitButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(180, 120, 80, 25);
		panel.add(resetButton);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JLabel lastOrderDisplay = new JLabel("", SwingConstants.CENTER);
		lastOrderDisplay.setBackground(new Color(192,192,192));
	      lastOrderDisplay.setOpaque(true);
		lastOrderDisplay.setBounds(0,150,400,25);
		panel.add(lastOrderDisplay);
		
		
		
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				name = nameText.getText();
				price = Double.parseDouble(priceText.getText());
				volume = Integer.parseInt(volumeText.getText());
				/*
				 * try { 
				 * double d = Double.parseDouble(text); // or
				 * Integer.parseInt(text), etc. // OK, valid number. 
				 * } catch (NumberFormatException nfe) 
				 * { // Not a number. 
				 * }
				 */
			}
		});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				nameText.setText(null);
				priceText.setText(null);
				volumeText.setText(null);
				lastOrderDisplay.setText("new text");
			}
		});
		 
		 
		
		//ActionClass actionEvent = new ActionClass();

		//submitButton.addActionListener(actionEvent);
		//resetButton.addActionListener(actionEvent);

		//submitButton.setActionCommand("1");
		//resetButton.setActionCommand("2");

	}
}

/*
 * class ActionClass implements ActionListener {
 * @Override
	public void actionPerformed(ActionEvent e) {
		int action = Integer.parseInt(e.getActionCommand());
		switch (action) {
		case 1:
			//String cust_Name = txt_cust_Name.getText();
			JFrame myWindow = new JFrame("YOU DID A POOPOO");
			myWindow.setSize(200, 200);
			myWindow.setVisible(true);
			break;
		case 2:
			JFrame myWindowz = new JFrame("YOU DID A CACA");
			myWindowz.setSize(200, 200);
			myWindowz.setVisible(true);
			break;
		default:
			break;
		}

	}
	}
 */

	