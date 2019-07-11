package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bases.Funcionario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import bases.Pedido;
import negocio.Gestao;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCozinheiro extends JFrame {

	private JPanel contentPane;
	public static int numPedidos = 0;
	private ArrayList<Pedido> listaPedidos;
	private Gestao gerir = new Gestao();
	
	public static void start() {
		
		JCozinheiro frame = new JCozinheiro();
		frame.setVisible(true);

	}
	

	public JCozinheiro(){
		
		boolean request[] = new boolean[15];
		for(int i = 0; i < 15; i++) {
			request[i] = false;
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\isaac\\Desktop\\UFRPE\\Restaurante\\icon.png"));
		setTitle("Cozinha");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 10, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPedidos = new JLabel("Pedidos:");
		lblPedidos.setForeground(new Color(255, 255, 255));
		lblPedidos.setFont(new Font("Arial", Font.BOLD, 22));
		lblPedidos.setBounds(10, 11, 100, 26);
		contentPane.add(lblPedidos);
		
		JPanel pedido1 = new JPanel();
		pedido1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido1.setBackground(new Color(245, 222, 179));
		pedido1.setBounds(20, 43, 168, 200);
		contentPane.add(pedido1);
		pedido1.setLayout(null);
		pedido1.setVisible(false);
		
		JLabel lblPedido1 = new JLabel("Pedido:");
		lblPedido1.setBounds(9, 9, 48, 17);
		lblPedido1.setFont(new Font("Arial", Font.PLAIN, 14));
		pedido1.add(lblPedido1);
		
		JScrollPane pedidosScrollPane1 = new JScrollPane();
		pedidosScrollPane1.setBounds(9, 30, 150, 134);
		pedido1.add(pedidosScrollPane1);
		
		JList listaPedidos1 = new JList();
		pedidosScrollPane1.setViewportView(listaPedidos1);
		
		JButton btnFazer1 = new JButton("Fazer");
		btnFazer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.concluirPedido(listaPedidos.get(0));
				gerir.cancelarPedido(0);
				dispose();
				start();
			}
		});
		btnFazer1.setForeground(new Color(255, 255, 255));
		btnFazer1.setBackground(new Color(0, 128, 0));
		btnFazer1.setBounds(9, 168, 63, 23);
		btnFazer1.setFont(new Font("Arial", Font.PLAIN, 11));
		pedido1.add(btnFazer1);
		
		JButton btnCancelar1 = new JButton("Cancelar");
		btnCancelar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(0);
				dispose();
				start();
			}
		});
		btnCancelar1.setBounds(76, 168, 83, 23);
		btnCancelar1.setFont(new Font("Arial", Font.PLAIN, 11));
		pedido1.add(btnCancelar1);
		
		JPanel pedido2 = new JPanel();
		pedido2.setLayout(null);
		pedido2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido2.setBackground(new Color(245, 222, 179));
		pedido2.setBounds(230, 43, 168, 200);
		contentPane.add(pedido2);
		pedido2.setVisible(false);
		
		JLabel lblPedido2 = new JLabel("Pedido:");
		lblPedido2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido2.setBounds(9, 9, 75, 17);
		pedido2.add(lblPedido2);
		
		JScrollPane pedidosScrollPane2 = new JScrollPane();
		pedidosScrollPane2.setBounds(9, 30, 150, 134);
		pedido2.add(pedidosScrollPane2);
		
		JList listaPedidos2 = new JList();
		pedidosScrollPane2.setViewportView(listaPedidos2);
		
		JButton btnFazer2 = new JButton("Fazer");
		btnFazer2.setForeground(new Color(255, 255, 255));
		btnFazer2.setBackground(new Color(0, 128, 0));
		btnFazer2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer2.setBounds(9, 168, 63, 23);
		pedido2.add(btnFazer2);
		
		JButton btnCancelar2 = new JButton("Cancelar");
		btnCancelar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(1);
				dispose();
				start();
			}
		});
		btnCancelar2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar2.setBounds(76, 168, 83, 23);
		pedido2.add(btnCancelar2);
		
		JPanel pedido3 = new JPanel();
		pedido3.setLayout(null);
		pedido3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido3.setBackground(new Color(245, 222, 179));
		pedido3.setBounds(440, 43, 168, 200);
		contentPane.add(pedido3);
		pedido3.setVisible(false);
		
		JLabel lblPedido3 = new JLabel("Pedido:");
		lblPedido3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido3.setBounds(9, 9, 75, 17);
		pedido3.add(lblPedido3);
		
		JScrollPane pedidosScrollPane3 = new JScrollPane();
		pedidosScrollPane3.setBounds(9, 30, 150, 134);
		pedido3.add(pedidosScrollPane3);
		
		JList listaPedidos3 = new JList();
		pedidosScrollPane3.setViewportView(listaPedidos3);
		
		JButton btnFazer3 = new JButton("Fazer");
		btnFazer3.setForeground(new Color(255, 255, 255));
		btnFazer3.setBackground(new Color(0, 128, 0));
		btnFazer3.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer3.setBounds(9, 168, 63, 23);
		pedido3.add(btnFazer3);
		
		JButton btnCancelar3 = new JButton("Cancelar");
		btnCancelar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(2);
				dispose();
				start();
			}
		});
		btnCancelar3.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar3.setBounds(76, 168, 83, 23);
		pedido3.add(btnCancelar3);
		
		JPanel pedido4 = new JPanel();
		pedido4.setLayout(null);
		pedido4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido4.setBackground(new Color(245, 222, 179));
		pedido4.setBounds(650, 43, 168, 200);
		contentPane.add(pedido4);
		pedido4.setVisible(false);
		
		JLabel lblPedido4 = new JLabel("Pedido:");
		lblPedido4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido4.setBounds(9, 9, 75, 17);
		pedido4.add(lblPedido4);
		
		JScrollPane pedidosScrollPane4 = new JScrollPane();
		pedidosScrollPane4.setBounds(9, 30, 150, 134);
		pedido4.add(pedidosScrollPane4);
		
		JList listaPedidos4 = new JList();
		pedidosScrollPane4.setViewportView(listaPedidos4);
		
		JButton btnFazer4 = new JButton("Fazer");
		btnFazer4.setForeground(new Color(255, 255, 255));
		btnFazer4.setBackground(new Color(0, 128, 0));
		btnFazer4.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer4.setBounds(9, 168, 63, 23);
		pedido4.add(btnFazer4);
		
		JButton btnCancelar4 = new JButton("Cancelar");
		btnCancelar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(3);
				dispose();
				start();
			}
		});
		btnCancelar4.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar4.setBounds(76, 168, 83, 23);
		pedido4.add(btnCancelar4);
		
		JPanel pedido5 = new JPanel();
		pedido5.setLayout(null);
		pedido5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido5.setBackground(new Color(245, 222, 179));
		pedido5.setBounds(860, 43, 168, 200);
		contentPane.add(pedido5);
		pedido5.setVisible(false);
		
		JLabel lblPedido5 = new JLabel("Pedido:");
		lblPedido5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido5.setBounds(9, 9, 75, 17);
		pedido5.add(lblPedido5);
		
		JScrollPane pedidosScrollPane5 = new JScrollPane();
		pedidosScrollPane5.setBounds(9, 30, 150, 134);
		pedido5.add(pedidosScrollPane5);
		
		JList listaPedidos5 = new JList();
		pedidosScrollPane5.setViewportView(listaPedidos5);
		
		JButton btnFazer5 = new JButton("Fazer");
		btnFazer5.setForeground(new Color(255, 255, 255));
		btnFazer5.setBackground(new Color(0, 128, 0));
		btnFazer5.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer5.setBounds(9, 168, 63, 23);
		pedido5.add(btnFazer5);
		
		JButton btnCancelar5 = new JButton("Cancelar");
		btnCancelar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(4);
				dispose();
				start();
			}
		});
		btnCancelar5.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar5.setBounds(76, 168, 83, 23);
		pedido5.add(btnCancelar5);
		
		JPanel pedido6 = new JPanel();
		pedido6.setLayout(null);
		pedido6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido6.setBackground(new Color(245, 222, 179));
		pedido6.setBounds(20, 254, 168, 200);
		contentPane.add(pedido6);
		pedido6.setVisible(false);
		
		JLabel lblPedido6 = new JLabel("Pedido:");
		lblPedido6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido6.setBounds(9, 9, 75, 17);
		pedido6.add(lblPedido6);
		
		JScrollPane pedidosScrollPane6 = new JScrollPane();
		pedidosScrollPane6.setBounds(9, 30, 150, 134);
		pedido6.add(pedidosScrollPane6);
		
		JList listaPedidos6 = new JList();
		pedidosScrollPane6.setViewportView(listaPedidos6);
		
		JButton btnFazer6 = new JButton("Fazer");
		btnFazer6.setForeground(new Color(255, 255, 255));
		btnFazer6.setBackground(new Color(0, 128, 0));
		btnFazer6.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer6.setBounds(9, 168, 63, 23);
		pedido6.add(btnFazer6);
		
		JButton btnCancelar6 = new JButton("Cancelar");
		btnCancelar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(5);
				dispose();
				start();
			}
		});
		btnCancelar6.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar6.setBounds(76, 168, 83, 23);
		pedido6.add(btnCancelar6);
		
		JPanel pedido7 = new JPanel();
		pedido7.setLayout(null);
		pedido7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido7.setBackground(new Color(245, 222, 179));
		pedido7.setBounds(230, 254, 168, 200);
		contentPane.add(pedido7);
		pedido7.setVisible(false);
		
		JLabel lblPedido7 = new JLabel("Pedido:");
		lblPedido7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido7.setBounds(9, 9, 75, 17);
		pedido7.add(lblPedido7);
		
		JScrollPane pedidosScrollPane7 = new JScrollPane();
		pedidosScrollPane7.setBounds(9, 30, 150, 134);
		pedido7.add(pedidosScrollPane7);
		
		JList listaPedidos7 = new JList();
		pedidosScrollPane7.setViewportView(listaPedidos7);
		
		JButton btnFazer7 = new JButton("Fazer");
		btnFazer7.setForeground(new Color(255, 255, 255));
		btnFazer7.setBackground(new Color(0, 128, 0));
		btnFazer7.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer7.setBounds(9, 168, 63, 23);
		pedido7.add(btnFazer7);
		
		JButton btnCancelar7 = new JButton("Cancelar");
		btnCancelar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(6);
				dispose();
				start();
			}
		});
		btnCancelar7.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar7.setBounds(76, 168, 83, 23);
		pedido7.add(btnCancelar7);
		
		JPanel pedido8 = new JPanel();
		pedido8.setLayout(null);
		pedido8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido8.setBackground(new Color(245, 222, 179));
		pedido8.setBounds(440, 254, 168, 200);
		contentPane.add(pedido8);
		pedido8.setVisible(false);
		
		JLabel lblPedido8 = new JLabel("Pedido:");
		lblPedido8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido8.setBounds(9, 9, 75, 17);
		pedido8.add(lblPedido8);
		
		JScrollPane pedidosScrollPane8 = new JScrollPane();
		pedidosScrollPane8.setBounds(9, 30, 150, 134);
		pedido8.add(pedidosScrollPane8);
		
		JList listaPedidos8 = new JList();
		pedidosScrollPane8.setViewportView(listaPedidos8);
		
		JButton btnFazer8 = new JButton("Fazer");
		btnFazer8.setForeground(new Color(255, 255, 255));
		btnFazer8.setBackground(new Color(0, 128, 0));
		btnFazer8.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer8.setBounds(9, 168, 63, 23);
		pedido8.add(btnFazer8);
		
		JButton btnCancelar8 = new JButton("Cancelar");
		btnCancelar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(7);
				dispose();
				start();
			}
		});
		btnCancelar8.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar8.setBounds(76, 168, 83, 23);
		pedido8.add(btnCancelar8);
		
		JPanel pedido9 = new JPanel();
		pedido9.setLayout(null);
		pedido9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido9.setBackground(new Color(245, 222, 179));
		pedido9.setBounds(650, 254, 168, 200);
		contentPane.add(pedido9);
		pedido9.setVisible(false);
		
		JLabel lblPedido9 = new JLabel("Pedido:");
		lblPedido9.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido9.setBounds(9, 9, 75, 17);
		pedido9.add(lblPedido9);
		
		JScrollPane pedidosScrollPane9 = new JScrollPane();
		pedidosScrollPane9.setBounds(9, 30, 150, 134);
		pedido9.add(pedidosScrollPane9);
		
		JList listaPedidos9 = new JList();
		pedidosScrollPane9.setViewportView(listaPedidos9);
		
		JButton btnFazer9 = new JButton("Fazer");
		btnFazer9.setForeground(new Color(255, 255, 255));
		btnFazer9.setBackground(new Color(0, 128, 0));
		btnFazer9.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer9.setBounds(9, 168, 63, 23);
		pedido9.add(btnFazer9);
		
		JButton btnCancelar9 = new JButton("Cancelar");
		btnCancelar9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(8);
				dispose();
				start();
			}
		});
		btnCancelar9.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar9.setBounds(76, 168, 83, 23);
		pedido9.add(btnCancelar9);
		
		JPanel pedido10 = new JPanel();
		pedido10.setLayout(null);
		pedido10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido10.setBackground(new Color(245, 222, 179));
		pedido10.setBounds(860, 254, 168, 200);
		contentPane.add(pedido10);
		pedido10.setVisible(false);
		
		JLabel lblPedido10 = new JLabel("Pedido:");
		lblPedido10.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido10.setBounds(9, 9, 75, 17);
		pedido10.add(lblPedido10);
		
		JScrollPane pedidosScrollPane10 = new JScrollPane();
		pedidosScrollPane10.setBounds(9, 30, 150, 134);
		pedido10.add(pedidosScrollPane10);
		
		JList listaPedidos10 = new JList();
		pedidosScrollPane10.setViewportView(listaPedidos10);
		
		JButton btnFazer10 = new JButton("Fazer");
		btnFazer10.setForeground(new Color(255, 255, 255));
		btnFazer10.setBackground(new Color(0, 128, 0));
		btnFazer10.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer10.setBounds(9, 168, 63, 23);
		pedido10.add(btnFazer10);
		
		JButton btnCancelar10 = new JButton("Cancelar");
		btnCancelar10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(9);
				dispose();
				start();
			}
		});
		btnCancelar10.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar10.setBounds(76, 168, 83, 23);
		pedido10.add(btnCancelar10);
		
		JPanel pedido11 = new JPanel();
		pedido11.setLayout(null);
		pedido11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido11.setBackground(new Color(245, 222, 179));
		pedido11.setBounds(20, 465, 168, 200);
		contentPane.add(pedido11);
		pedido11.setVisible(false);
		
		JLabel lblPedido11 = new JLabel("Pedido:");
		lblPedido11.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido11.setBounds(9, 9, 75, 17);
		pedido11.add(lblPedido11);
		
		JScrollPane pedidosScrollPane11 = new JScrollPane();
		pedidosScrollPane11.setBounds(9, 30, 150, 134);
		pedido11.add(pedidosScrollPane11);
		
		JList listaPedidos11 = new JList();
		pedidosScrollPane11.setViewportView(listaPedidos11);
		
		JButton btnFazer11 = new JButton("Fazer");
		btnFazer11.setForeground(new Color(255, 255, 255));
		btnFazer11.setBackground(new Color(0, 128, 0));
		btnFazer11.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer11.setBounds(9, 168, 63, 23);
		pedido11.add(btnFazer11);
		
		JButton btnCancelar11 = new JButton("Cancelar");
		btnCancelar11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(10);
				dispose();
				start();
			}
		});
		btnCancelar11.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar11.setBounds(76, 168, 83, 23);
		pedido11.add(btnCancelar11);
		
		JPanel pedido12 = new JPanel();
		pedido12.setLayout(null);
		pedido12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido12.setBackground(new Color(245, 222, 179));
		pedido12.setBounds(230, 465, 168, 200);
		contentPane.add(pedido12);
		pedido12.setVisible(false);
		
		JLabel lblPedido12 = new JLabel("Pedido:");
		lblPedido12.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido12.setBounds(9, 9, 75, 17);
		pedido12.add(lblPedido12);
		
		JScrollPane pedidosScrollPane12 = new JScrollPane();
		pedidosScrollPane12.setBounds(9, 30, 150, 134);
		pedido12.add(pedidosScrollPane12);
		
		JList listaPedidos12 = new JList();
		pedidosScrollPane12.setViewportView(listaPedidos12);
		
		JButton btnFazer12 = new JButton("Fazer");
		btnFazer12.setForeground(new Color(255, 255, 255));
		btnFazer12.setBackground(new Color(0, 128, 0));
		btnFazer12.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer12.setBounds(9, 168, 63, 23);
		pedido12.add(btnFazer12);
		
		JButton btnCancelar12 = new JButton("Cancelar");
		btnCancelar12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(11);
				dispose();
				start();
			}
		});
		btnCancelar12.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar12.setBounds(76, 168, 83, 23);
		pedido12.add(btnCancelar12);
		
		JPanel pedido13 = new JPanel();
		pedido13.setLayout(null);
		pedido13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido13.setBackground(new Color(245, 222, 179));
		pedido13.setBounds(440, 465, 168, 200);
		contentPane.add(pedido13);
		pedido13.setVisible(false);
		
		JLabel lblPedido13 = new JLabel("Pedido:");
		lblPedido13.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido13.setBounds(9, 9, 75, 17);
		pedido13.add(lblPedido13);
		
		JScrollPane pedidosScrollPane13 = new JScrollPane();
		pedidosScrollPane13.setBounds(9, 30, 150, 134);
		pedido13.add(pedidosScrollPane13);
		
		JList listaPedidos13 = new JList();
		pedidosScrollPane13.setViewportView(listaPedidos13);
		
		JButton btnFazer13 = new JButton("Fazer");
		btnFazer13.setForeground(new Color(255, 255, 255));
		btnFazer13.setBackground(new Color(0, 128, 0));
		btnFazer13.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer13.setBounds(9, 168, 63, 23);
		pedido13.add(btnFazer13);
		
		JButton btnCancelar13 = new JButton("Cancelar");
		btnCancelar13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(12);
				dispose();
				start();
			}
		});
		btnCancelar13.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar13.setBounds(76, 168, 83, 23);
		pedido13.add(btnCancelar13);
		
		JPanel pedido14 = new JPanel();
		pedido14.setLayout(null);
		pedido14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido14.setBackground(new Color(245, 222, 179));
		pedido14.setBounds(650, 465, 168, 200);
		contentPane.add(pedido14);
		pedido14.setVisible(false);
		
		JLabel lblPedido14 = new JLabel("Pedido:");
		lblPedido14.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido14.setBounds(9, 9, 75, 17);
		pedido14.add(lblPedido14);
		
		JScrollPane pedidosScrollPane14 = new JScrollPane();
		pedidosScrollPane14.setBounds(9, 30, 150, 134);
		pedido14.add(pedidosScrollPane14);
		
		JList listaPedidos14 = new JList();
		pedidosScrollPane14.setViewportView(listaPedidos14);
		
		JButton btnFazer14 = new JButton("Fazer");
		btnFazer14.setForeground(new Color(255, 255, 255));
		btnFazer14.setBackground(new Color(0, 128, 0));
		btnFazer14.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer14.setBounds(9, 168, 63, 23);
		pedido14.add(btnFazer14);
		
		JButton btnCancelar14 = new JButton("Cancelar");
		btnCancelar14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(13);
				dispose();
				start();
			}
		});
		btnCancelar14.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar14.setBounds(76, 168, 83, 23);
		pedido14.add(btnCancelar14);
		
		JPanel pedido15 = new JPanel();
		pedido15.setLayout(null);
		pedido15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pedido15.setBackground(new Color(245, 222, 179));
		pedido15.setBounds(860, 465, 168, 200);
		contentPane.add(pedido15);
		pedido15.setVisible(false);
		
		JLabel lblPedido15 = new JLabel("Pedido:");
		lblPedido15.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido15.setBounds(9, 9, 75, 17);
		pedido15.add(lblPedido15);
		
		JScrollPane pedidosScrollPane15 = new JScrollPane();
		pedidosScrollPane15.setBounds(9, 30, 150, 134);
		pedido15.add(pedidosScrollPane15);
		
		JList listaPedidos15 = new JList();
		pedidosScrollPane15.setViewportView(listaPedidos15);
		
		JButton btnFazer15 = new JButton("Fazer");
		btnFazer15.setForeground(new Color(255, 255, 255));
		btnFazer15.setBackground(new Color(0, 128, 0));
		btnFazer15.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazer15.setBounds(9, 168, 63, 23);
		pedido15.add(btnFazer15);
		
		JButton btnCancelar15 = new JButton("Cancelar");
		btnCancelar15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerir.cancelarPedido(14);
				dispose();
				start();
			}
		});
		btnCancelar15.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCancelar15.setBounds(76, 168, 83, 23);
		pedido15.add(btnCancelar15);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				start();
			}
		});
		btnUpdate.setBounds(945, 11, 89, 23);
		contentPane.add(btnUpdate);
		
		lerLista();
		
		for(int i = 0; i < numPedidos && i < 15; i++)
		{
			request[i] = true;
		}
		
		
		pedido1.setVisible(request[0]);
		if(request[0])
		{
			listaPedidos1.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(0).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido1.setText("Mesa "+ listaPedidos.get(0).getMesa().getNum());
		}
		pedido2.setVisible(request[1]);
		if(request[1])
		{
			listaPedidos2.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(1).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido2.setText("Mesa "+ listaPedidos.get(1).getMesa().getNum());
		}
		pedido3.setVisible(request[2]);
		if(request[2])
		{
			listaPedidos3.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(2).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido3.setText("Mesa "+ listaPedidos.get(2).getMesa().getNum());
		}
		pedido4.setVisible(request[3]);
		if(request[3])
		{
			listaPedidos4.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(3).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido4.setText("Mesa "+ listaPedidos.get(3).getMesa().getNum());
		}
		pedido5.setVisible(request[4]);
		if(request[4])
		{
			listaPedidos5.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(4).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido5.setText("Mesa "+ listaPedidos.get(4).getMesa().getNum());
		}
		pedido6.setVisible(request[5]);
		if(request[5])
		{
			listaPedidos6.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(5).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido6.setText("Mesa "+ listaPedidos.get(5).getMesa().getNum());
		}
		pedido7.setVisible(request[6]);
		if(request[6])
		{
			listaPedidos7.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(6).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido7.setText("Mesa "+ listaPedidos.get(6).getMesa().getNum());
		}
		pedido8.setVisible(request[7]);
		if(request[7])
		{
			listaPedidos8.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(7).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido8.setText("Mesa "+ listaPedidos.get(7).getMesa().getNum());
		}
		pedido9.setVisible(request[8]);
		if(request[8])
		{
			listaPedidos9.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(8).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido9.setText("Mesa "+ listaPedidos.get(8).getMesa().getNum());
		}
		pedido10.setVisible(request[9]);
		if(request[9])
		{
			listaPedidos10.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(9).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido10.setText("Mesa "+ listaPedidos.get(9).getMesa().getNum());
		}
		pedido11.setVisible(request[10]);
		if(request[10])
		{
			listaPedidos11.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(10).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido11.setText("Mesa "+ listaPedidos.get(10).getMesa().getNum());
		}
		pedido12.setVisible(request[11]);
		if(request[11])
		{
			listaPedidos12.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(11).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido12.setText("Mesa "+ listaPedidos.get(11).getMesa().getNum());
		}
		pedido13.setVisible(request[12]);
		if(request[12])
		{
			listaPedidos13.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(12).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido13.setText("Mesa "+ listaPedidos.get(12).getMesa().getNum());
		}
		pedido14.setVisible(request[13]);
		if(request[13])
		{
			listaPedidos14.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(13).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido14.setText("Mesa "+ listaPedidos.get(13).getMesa().getNum());
		}
		pedido15.setVisible(request[14]);
		if(request[14])
		{
			listaPedidos15.setModel(new AbstractListModel() {
				String[] values = listaPedidos.get(14).toString().split("\n");
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			
			lblPedido15.setText("Mesa "+ listaPedidos.get(14).getMesa().getNum());
		}
		
	}
	
	public void lerLista(){		
		listaPedidos = gerir.pegarPedidos();
		
		if(listaPedidos != null)
			numPedidos = listaPedidos.size();
		
	}
}
