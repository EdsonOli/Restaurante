package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Restaurante extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurante frame = new Restaurante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Restaurante() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setTitle("Cabra de Peste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrar = new JLabel("Restaurante Cabra da Peste");
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setForeground(new Color(0, 0, 0));
		lblEntrar.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblEntrar.setBounds(10, 22, 414, 32);
		contentPane.add(lblEntrar);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLogin.setBounds(10, 83, 76, 24);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSenha.setBounds(10, 138, 76, 24);
		contentPane.add(lblSenha);
		
		loginField = new JTextField();
		loginField.setBounds(96, 83, 302, 24);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 138, 302, 25);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(loginField.getText().isEmpty() || passwordField.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Preencha todas as informações necessarias!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Bem vindo " + loginField.getText());
					JGestao.start();
					setVisible(false);
					dispose();
					
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEntrar.setBounds(311, 205, 87, 24);
		contentPane.add(btnEntrar);
		
		JLabel lblRestauranteDeComidas = new JLabel("Comidas Regionais");
		lblRestauranteDeComidas.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRestauranteDeComidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestauranteDeComidas.setBounds(10, 51, 414, 21);
		contentPane.add(lblRestauranteDeComidas);
	}
}
