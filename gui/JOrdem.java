package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bases.Mesa;
import bases.Prato;
import bases.Sobremesa;
import negocio.Gestao;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.AbstractListModel;
import java.awt.Toolkit;

public class JOrdem extends JFrame {

	private JPanel contentPane;
	private Gestao gerir = new Gestao();
	private JTextField nomeDoPrato;

	/**
	 * Launch the application.
	 */
	public static void start(){
		JOrdem frame = new JOrdem();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public JOrdem() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\isaac\\Desktop\\UFRPE\\Restaurante\\icon.png"));
		setTitle("Fazer Pedido");
		
		ArrayList<Prato> pratosPedidos = new ArrayList<Prato>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner MesaNumspinner = new JSpinner();
		MesaNumspinner.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		MesaNumspinner.setBounds(145, 21, 40, 20);
		contentPane.add(MesaNumspinner);
		
		JList listaPedido = new JList();
		listaPedido.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaPedido.setBounds(20, 52, 554, 188);
		contentPane.add(listaPedido);
		
		JButton btnFazerPedido = new JButton("Fazer Pedido");
		btnFazerPedido.setForeground(new Color(0, 0, 0));
		btnFazerPedido.setBackground(new Color(255, 255, 255));
		btnFazerPedido.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFazerPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mesa m = new Mesa((int) MesaNumspinner.getValue());
				
				if(!pratosPedidos.isEmpty()) {
					gerir.fazerPedido(m, pratosPedidos);
					JOptionPane.showMessageDialog(null, "Pedido Confirmado!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
					pratosPedidos.clear();
					
					listaPedido.setModel(new AbstractListModel() {
						String[] values = new String[] {};
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
				}
				else
				{
					JOptionPane.showMessageDialog(null, "A lista de pedidos está vaiza!", "Ops", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnFazerPedido.setBounds(210, 356, 167, 23);
		getContentPane().add(btnFazerPedido);
		
		JLabel lblNumeroDaMesa = new JLabel("Numero da Mesa:");
		lblNumeroDaMesa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumeroDaMesa.setBounds(24, 21, 111, 20);
		contentPane.add(lblNumeroDaMesa);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPedido.setBounds(30, 254, 48, 20);
		contentPane.add(lblPedido);
		
		nomeDoPrato = new JTextField();
		nomeDoPrato.setBounds(84, 255, 391, 20);
		contentPane.add(nomeDoPrato);
		nomeDoPrato.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prato p = gerir.encontrarPrato(nomeDoPrato.getText());
				if(p != null)
				{
					pratosPedidos.add(p);
					
					String text = "";
					for(Prato x: pratosPedidos)
						text += x.getNome() + "\n";
					
					final String textoFinal = text;
					listaPedido.setModel(new AbstractListModel() {
						String[] values = textoFinal.split("\n");
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
				}
				else
				{
					JOptionPane.showMessageDialog(null, "O prato inserido não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdicionar.setBounds(485, 254, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
