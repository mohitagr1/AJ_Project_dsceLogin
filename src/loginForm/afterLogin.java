package loginForm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class afterLogin extends JFrame {

	JLabel l_user, l_pass, l_welcome;

	afterLogin(String l_user, String l_pass) {
		this.l_user = new JLabel("Welcome : " + l_user);
		this.l_pass = new JLabel("Your password is : " + l_pass);
		l_welcome = new JLabel();
		l_welcome.setBounds(40, 0, 300, 70);
		this.l_user.setBounds(50, 0, 400, 100);
		this.l_pass.setBounds(50, 50, 400, 100);
		setTitle("WELCOME DSCE, CSE");
		setLayout(null);
		setSize(600, 400);
		add(this.l_user);
		add(this.l_pass);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
