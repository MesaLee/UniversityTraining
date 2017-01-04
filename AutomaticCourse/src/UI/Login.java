/*
 * Login.java
 *
 * Created on __DATE__, __TIME__
 */

package UI;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import JDBC.ArrangeImpl;
import JDBC.JdbcUtils;

/**
 *
 * @author  __USER__
 */
public class Login extends javax.swing.JFrame {

	/** Creates new form Login */
	public Login() {
		initComponents();
		setLocation(300, 200);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		idLabel = new javax.swing.JLabel();
		idTextField = new javax.swing.JTextField();
		passwordLabel = new javax.swing.JLabel();
		loginButton = new javax.swing.JButton();
		exitButton = new javax.swing.JButton();
		passwordField = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u81ea\u52a8\u6392\u8bfe\u7cfb\u7edf--\u767b\u5f55");

		idLabel.setText("\u7ba1\u7406\u5458\u8d26\u53f7\uff1a");

		idTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				idTextFieldActionPerformed(evt);
			}
		});

		passwordLabel.setText("\u7ba1\u7406\u5458\u5bc6\u7801\uff1a");

		loginButton.setIcon(new javax.swing.ImageIcon(
				"..\\AutomaticCourse\\images\\login.png")); // NOI18N
		loginButton.setText("\u767b\u5f55");
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		exitButton.setIcon(new javax.swing.ImageIcon(
				"..\\AutomaticCourse\\images\\exit.png")); // NOI18N
		exitButton.setText("\u9000\u51fa");
		exitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(86, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		loginButton)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		exitButton))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						idLabel)
																				.addComponent(
																						passwordLabel))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						idTextField)
																				.addComponent(
																						passwordField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						153,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGap(84, 84, 84)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(idLabel)
												.addComponent(
														idTextField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(31, 31, 31)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(passwordLabel)
												.addComponent(
														passwordField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(37, 37, 37)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(exitButton)
												.addComponent(loginButton))
								.addContainerGap(108, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		System.exit(0);
	}

	//GEN-END:initComponents

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling

		String jusername = this.idTextField.getText(); //��ȡ��½�˺�
		char[] s = this.passwordField.getPassword();//��ȡ��½����
		String jpassword = new String(s);
		if (jusername.equals("") || jpassword.equals("")) {
			JOptionPane.showMessageDialog(this, "�Բ���,�������û���������.", "����!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Connection conn = JdbcUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("select * from Administrator where Aid='"
								+ jusername + "'");
				if (rs.next()) {
					if (rs.getString("password").equals(jpassword)) {
						new MainInterface().setVisible(true);
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(this, "�Բ���,�������,����������",
								"��½ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "�û���������,����������", "����!",
							JOptionPane.ERROR_MESSAGE);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("SQL�쳣");
			}
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton exitButton;
	private javax.swing.JLabel idLabel;
	private javax.swing.JTextField idTextField;
	private javax.swing.JButton loginButton;
	private javax.swing.JPasswordField passwordField;
	private javax.swing.JLabel passwordLabel;
	// End of variables declaration//GEN-END:variables

}