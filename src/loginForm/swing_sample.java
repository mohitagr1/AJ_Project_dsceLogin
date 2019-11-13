package loginForm;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class swing_sample extends JFrame {
	// declaring our swing components
	JLabel l_name, l_pass, l_dsce;
	JTextField t_name;
	JPasswordField t_pass; // A special JTextField but hides input text
	JButton button;
	JButton buttonSignup;
	JLabel imgLabel;

	// a inner class to handling ActionEvents
	handler handle;

	// a separate class for processing database connection and authentication
	database db;

	swing_sample() {
		super("Login and Signup form");
		setTitle("Login and Signup Form in Windows Form");
		setLayout(null);
		setSize(800, 600);

		// extra classes
		db = new database();
		handle = new handler();

		// swing components
		imgLabel = new JLabel(new ImageIcon("D:\\Users\\Mohit Agarwal\\Desktop\\index2.png"));
		l_dsce = new JLabel("D S C E");
		l_name = new JLabel("Username");
		l_pass = new JLabel("Password");
		t_name = new JTextField(10);
		t_pass = new JPasswordField(10);
		button = new JButton("Login");
		buttonSignup = new JButton("SignUp");

		// adding actionlistener to the button
		button.addActionListener(handle);
		buttonSignup.addActionListener(handle);

		int formDisX = 400;
		l_dsce.setBounds(formDisX, 0, 50, 50);
		l_name.setBounds(formDisX - 150, 370, 200, 30);
		l_pass.setBounds(formDisX - 150, 410, 200, 30);
		t_name.setBounds(formDisX, 370, 200, 30);
		t_pass.setBounds(formDisX, 410, 200, 30);
		button.setBounds(formDisX - 100, 460, 100, 30);
		buttonSignup.setBounds(formDisX + 10, 460, 100, 30);
		imgLabel.setBounds(265, 0, 300, 300);

		// add to contaienr
		add(l_dsce);
		add(imgLabel);
		add(l_name);
		add(t_name);
		add(l_pass);
		add(t_pass);
		add(button);
		add(buttonSignup);
		// visual
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String args[]) {
		swing_sample sample = new swing_sample();
	}

	// an inner class .You can also write as a separate class
	class handler implements ActionListener {
		// must implement method
		// This is triggered whenever the user clicks the login button
		public void actionPerformed(ActionEvent ae) {
			// checks if the button clicked
			if (ae.getSource() == button) {
				char[] temp_pwd = t_pass.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(temp_pwd);
				System.out.println("Username,Pwd:" + t_name.getText() + "," + pwd);

				// The entered username and password are sent via "checkLogin()" which return
				// boolean
				if (db.checkLogin(t_name.getText(), pwd)) {
					// a pop-up box
					JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					afterLogin aLogin = new afterLogin(t_name.getText(), pwd);
					dispose();

				} else {
					// a pop-up box
					JOptionPane.showMessageDialog(null, "Login failed!", "Failed!!", JOptionPane.ERROR_MESSAGE);
				}

			} // if
			else if (ae.getSource() == buttonSignup) {
				char[] temp_pwd = t_pass.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(temp_pwd);
				System.out.println("Username,Pwd:" + t_name.getText() + "," + pwd);

				db.fillData(t_name.getText(), pwd);
				JOptionPane.showMessageDialog(null, "You have Signed up successfully", "Success",
						JOptionPane.INFORMATION_MESSAGE);

			}
		}// method

	}// inner class

}// class
