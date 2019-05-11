import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class Login {

	private JFrame frame1;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setTitle("Karel Room Management System");
		frame1.setBounds(100, 100, 519, 426);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Karel Room Booking System");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(135, 29, 231, 28);
		frame1.getContentPane().add(lblTitle);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(65, 119, 75, 17);
		frame1.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(65, 176, 86, 14);
		frame1.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(161, 117, 142, 28);
		frame1.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(161, 171, 142, 28);
		frame1.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				
				if(username.contains("admin") && password.contains("admin")) {
					txtUsername.setText(null);
					txtPassword.setText(null);
					
					Main deneme = new Main();
					//frame1.dispatchEvent(new WindowEvent(frame1, WindowEvent.WINDOW_CLOSING));
					deneme.main(null);

					
				} else {
					JOptionPane.showMessageDialog(null, "Username or password is wrong.", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setBounds(48, 267, 97, 35);
		frame1.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(199, 267, 97, 35);
		frame1.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				System.exit(0);
			}
		});
		btnExit.setBounds(338, 267, 103, 35);
		frame1.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 82, 430, 2);
		frame1.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 235, 430, 2);
		frame1.getContentPane().add(separator_1);
	}
}
