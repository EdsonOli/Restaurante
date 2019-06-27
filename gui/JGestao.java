package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.awt.TrayIcon.MessageType;

import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JGestao extends JFrame {
	private JTextField nomeTextField;
	private JTextField IDTextField;
	private JTextField CargoTextField;
	private JTextField nome2TextField;
	private JTextField ID2TextField;
	private JPanel PainelAtivo;
	private JTextField nome3TextField;
	private JTextField ID3TextField;

	/**
	 * Launch the application.
	 */
	public static void start() {
		JGestao frame = new JGestao();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public JGestao() {
		getContentPane().setBackground(new Color(224, 255, 255));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.RED);
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 291, 21);
		getContentPane().add(menuBar);
		
		JMenu mnFuncionarios = new JMenu("Funcionarios");
		menuBar.add(mnFuncionarios);
		mnFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel promocaoPanel = new JPanel();
		promocaoPanel.setBackground(new Color(224, 255, 255));
		promocaoPanel.setBounds(85, 69, 409, 327);
		getContentPane().add(promocaoPanel);
		promocaoPanel.setLayout(null);
		promocaoPanel.setVisible(false);
		
		JLabel promocaoLabel = new JLabel("Altera\u00E7\u00E3o de Cargo");
		promocaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		promocaoLabel.setFont(new Font("Arial", Font.BOLD, 18));
		promocaoLabel.setBounds(115, 28, 180, 22);
		promocaoPanel.add(promocaoLabel);
		
		JButton btnProm = new JButton("Alterar");
		btnProm.setBounds(159, 256, 90, 23);
		promocaoPanel.add(btnProm);
		
		JLabel lblNome3 = new JLabel("Nome:");
		lblNome3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome3.setBounds(37, 136, 56, 19);
		promocaoPanel.add(lblNome3);
		
		nome3TextField = new JTextField();
		nome3TextField.setEditable(false);
		nome3TextField.setFont(new Font("Arial", Font.PLAIN, 16));
		nome3TextField.setColumns(10);
		nome3TextField.setBounds(103, 135, 271, 20);
		promocaoPanel.add(nome3TextField);
		
		JLabel label = new JLabel("ID:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(37, 88, 56, 19);
		promocaoPanel.add(label);
		
		ID3TextField = new JTextField();
		ID3TextField.setToolTipText("");
		ID3TextField.setFont(new Font("Arial", Font.PLAIN, 16));
		ID3TextField.setColumns(10);
		ID3TextField.setBounds(103, 87, 90, 20);
		promocaoPanel.add(ID3TextField);
		
		JLabel lblCargo3 = new JLabel("Novo Cargo:");
		lblCargo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCargo3.setBounds(10, 179, 90, 19);
		promocaoPanel.add(lblCargo3);
		
		JComboBox cargoComboBox = new JComboBox();
		cargoComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		cargoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Cozinheiro", "Gar\u00E7om", "Limpeza", "Gerente"}));
		cargoComboBox.setBounds(103, 180, 90, 20);
		promocaoPanel.add(cargoComboBox);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID3TextField.getText().equals("121984")) {
					nome3TextField.setText("Isaac Joas Bernardes de Lima");
				}
				else {
					nome3TextField.setText("Funcionario não encontrado");
				}
			}
		});
		btnProcurar.setBounds(203, 87, 95, 20);
		promocaoPanel.add(btnProcurar);
		
		JPanel efetivarPanel = new JPanel();
		efetivarPanel.setEnabled(false);
		efetivarPanel.setBounds(85, 69, 409, 327);
		getContentPane().add(efetivarPanel);
		efetivarPanel.setLayout(null);
		
		PainelAtivo = efetivarPanel;
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(42, 73, 56, 19);
		efetivarPanel.add(lblNome);
		efetivarPanel.setVisible(false);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCargo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCargo.setBounds(42, 156, 56, 19);
		efetivarPanel.add(lblCargo);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Arial", Font.PLAIN, 16));
		lblId.setBounds(42, 114, 56, 19);
		efetivarPanel.add(lblId);
		
		nomeTextField = new JTextField();
		nomeTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		nomeTextField.setBounds(94, 72, 271, 20);
		efetivarPanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		IDTextField = new JTextField();
		IDTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		IDTextField.setColumns(10);
		IDTextField.setBounds(94, 113, 56, 20);
		efetivarPanel.add(IDTextField);
		
		CargoTextField = new JTextField();
		CargoTextField.setFont(new Font("Arial", Font.PLAIN, 16));
		CargoTextField.setBounds(94, 157, 271, 20);
		efetivarPanel.add(CargoTextField);
		CargoTextField.setColumns(10);
		
		JLabel lbEfetivar = new JLabel("Efetivar");
		lbEfetivar.setHorizontalAlignment(SwingConstants.CENTER);
		lbEfetivar.setFont(new Font("Arial", Font.BOLD, 18));
		lbEfetivar.setBounds(169, 26, 77, 22);
		efetivarPanel.add(lbEfetivar);
		
		JButton btnEfetivarInterno = new JButton("OK");
		btnEfetivarInterno.setBounds(276, 266, 89, 23);
		efetivarPanel.add(btnEfetivarInterno);
		
		JButton btnCancelarEfet = new JButton("Cancelar");
		btnCancelarEfet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				efetivarPanel.setVisible(false);
				efetivarPanel.setEnabled(false);
				nomeTextField.setText("");
				IDTextField.setText("");
				CargoTextField.setText("");
				
			}
		});
		btnCancelarEfet.setBounds(177, 266, 89, 23);
		efetivarPanel.add(btnCancelarEfet);
		
		JPanel demitirPanel = new JPanel();
		demitirPanel.setBounds(85, 69, 409, 327);
		getContentPane().add(demitirPanel);
		demitirPanel.setLayout(null);
		demitirPanel.setVisible(false);
		
		JLabel lblNome2 = new JLabel("Nome:");
		lblNome2.setBounds(42, 71, 46, 19);
		lblNome2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome2.setFont(new Font("Arial", Font.PLAIN, 16));
		demitirPanel.add(lblNome2);
		
		JLabel lblID2 = new JLabel("ID:");
		lblID2.setBounds(42, 115, 19, 19);
		lblID2.setHorizontalAlignment(SwingConstants.CENTER);
		lblID2.setFont(new Font("Arial", Font.PLAIN, 16));
		demitirPanel.add(lblID2);
		
		nome2TextField = new JTextField();
		nome2TextField.setBounds(92, 74, 272, 19);
		nome2TextField.setFont(new Font("Arial", Font.PLAIN, 16));
		nome2TextField.setColumns(10);
		demitirPanel.add(nome2TextField);
		
		ID2TextField = new JTextField();
		ID2TextField.setBounds(94, 115, 99, 19);
		ID2TextField.setFont(new Font("Arial", Font.PLAIN, 16));
		ID2TextField.setColumns(10);
		demitirPanel.add(ID2TextField);
		
		JLabel lblDemitir = new JLabel("Demitir");
		lblDemitir.setBounds(169, 26, 77, 22);
		lblDemitir.setHorizontalAlignment(SwingConstants.CENTER);
		lblDemitir.setFont(new Font("Arial", Font.BOLD, 18));
		demitirPanel.add(lblDemitir);
		
		JButton btnDemitirInterno = new JButton("OK");
		btnDemitirInterno.setBounds(169, 157, 77, 23);
		demitirPanel.add(btnDemitirInterno);
		
		JButton btnEfetivar = new JButton("Efetivar");
		btnEfetivar.setForeground(Color.BLACK);
		btnEfetivar.setBackground(Color.WHITE);
		btnEfetivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelAtivo.setVisible(false);
				PainelAtivo.setEnabled(false);
				PainelAtivo = efetivarPanel;
				efetivarPanel.setVisible(true);
				efetivarPanel.setEnabled(true);
			}
		});
		mnFuncionarios.add(btnEfetivar);
		
		JButton btnDemitir = new JButton("Demitir");
		btnDemitir.setForeground(Color.BLACK);
		btnDemitir.setBackground(Color.WHITE);
		btnDemitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelAtivo.setVisible(false);
				PainelAtivo.setEnabled(false);
				PainelAtivo = demitirPanel;
				demitirPanel.setVisible(true);
				demitirPanel.setEnabled(true);
			}
		});
		mnFuncionarios.add(btnDemitir);
		
		JButton btnAlterarCargo = new JButton("Alterar Cargo");
		btnAlterarCargo.setForeground(Color.BLACK);
		btnAlterarCargo.setBackground(Color.WHITE);
		btnAlterarCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelAtivo.setVisible(false);
				PainelAtivo.setEnabled(false);
				PainelAtivo = promocaoPanel;
				promocaoPanel.setVisible(true);
				promocaoPanel.setEnabled(true);
			}
		});
		mnFuncionarios.add(btnAlterarCargo);
		
		JButton btnDarAumento = new JButton("Aumentar Salario");
		mnFuncionarios.add(btnDarAumento);
		
		JButton btnReduzirSalario = new JButton("Reduzir Salario");
		mnFuncionarios.add(btnReduzirSalario);
		
		JMenu mnPratos = new JMenu("Pratos");
		menuBar.add(mnPratos);
		
		JButton btnNovoPrato = new JButton("Adicionar");
		mnPratos.add(btnNovoPrato);
		
		JButton btnRemoverPrato = new JButton("Remover");
		mnPratos.add(btnRemoverPrato);
		
		JButton btnAlterar = new JButton("Alterar");
		mnPratos.add(btnAlterar);
		
		JMenu mnIngredientes = new JMenu("Ingredientes");
		menuBar.add(mnIngredientes);
		
		JButton btnComprar = new JButton("Adicionar");
		mnIngredientes.add(btnComprar);
		
		JButton btnRemover = new JButton("Remover");
		mnIngredientes.add(btnRemover);
		
		JMenu mnDespesas = new JMenu("Despesas");
		menuBar.add(mnDespesas);
		
		JButton btnNewButton = new JButton("Pagar Funcionarios");
		mnDespesas.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Despesas Extras");
		mnDespesas.add(btnNewButton_1);
		
		JButton btnComprarIngredientes = new JButton("Comprar Ingredientes");
		mnDespesas.add(btnComprarIngredientes);
		
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
