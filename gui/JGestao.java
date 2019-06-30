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

import dados.RepositorioFuncionario;
import negocio.Gestao;
import bases.Funcionario;
import bases.Cargo;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class JGestao extends JFrame {
	private Gestao gerir = new Gestao();
	private JTextField nomeTextField;
	private JTextField IDTextField;
	private JTextField nome2TextField;
	private JTextField ID2TextField;
	private JPanel PainelAtivo;
	private JTextField nome3TextField;
	private JTextField ID3TextField;
	//private RepositorioFuncionario repFunc = new RepositorioFuncionario();
	private JTextField ID4textField;
	private JTextField nome4textField;
	private JTextField cargo4textField;
	private JTextField RG5textField;
	private JTextField Nome5TextField;
	private JTextField Cargo5textField;
	private JTextField salario4TextField;
	private JTextField Salario5textField;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\isaac\\Desktop\\UFRPE\\Restaurante\\icon.png"));
		setTitle("Gerenciar");
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
		
		JPanel listarFuncionarios = new JPanel();
		listarFuncionarios.setBackground(new Color(224, 255, 255));
		listarFuncionarios.setBounds(38, 69, 507, 327);
		getContentPane().add(listarFuncionarios);
		listarFuncionarios.setLayout(null);
		listarFuncionarios.setVisible(false);
		
		JScrollPane listarFuncionariosScrollPane = new JScrollPane();
		listarFuncionariosScrollPane.setBounds(5, 5, 300, 317);
		listarFuncionarios.add(listarFuncionariosScrollPane);
		
		JPanel FiltroSalario = new JPanel();
		FiltroSalario.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		FiltroSalario.setBounds(315, 98, 192, 200);
		listarFuncionarios.add(FiltroSalario);
		FiltroSalario.setLayout(null);
		
		JList listaFuncionarios = new JList();
		listarFuncionariosScrollPane.setViewportView(listaFuncionarios);
		listaFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaFuncionarios.setModel(new AbstractListModel() {
			String[] values = gerir.ListaFuncionarios().split("\n");
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listaFuncionarios.setVisibleRowCount(4);
		
		JButton btnFiltroRg = new JButton("Salario");
		btnFiltroRg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiltroSalario.setVisible(true);
			}
		});
		
		JLabel lblFiltrarPorSalario = new JLabel("Filtrar por Salario");
		lblFiltrarPorSalario.setFont(new Font("Arial", Font.BOLD, 16));
		lblFiltrarPorSalario.setBounds(33, 11, 131, 19);
		FiltroSalario.add(lblFiltrarPorSalario);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDe.setBounds(10, 65, 25, 20);
		FiltroSalario.add(lblDe);
		
		JLabel lblAt = new JLabel("At\u00E9:");
		lblAt.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAt.setBounds(10, 110, 28, 20);
		FiltroSalario.add(lblAt);
		
		JSpinner DEspinner = new JSpinner();
		DEspinner.setModel(new SpinnerNumberModel(new Double(1000), new Double(1000), null, new Double(10)));
		DEspinner.setBounds(45, 67, 131, 20);
		FiltroSalario.add(DEspinner);
		
		JSpinner ATEspinner = new JSpinner();
		ATEspinner.setModel(new SpinnerNumberModel(new Double(2000), new Double(1000), null, new Double(10)));
		ATEspinner.setBounds(45, 112, 131, 20);
		FiltroSalario.add(ATEspinner);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Filtrar por Salario
				FiltroSalario.setVisible(false);
				double min = (double) DEspinner.getValue();
				double max = (double) ATEspinner.getValue();
				listaFuncionarios.setModel(new AbstractListModel() {
					String[] values = gerir.FiltroSalarial(min, max).split("\n");
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		btnFiltrar.setBounds(14, 155, 79, 23);
		FiltroSalario.add(btnFiltrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiltroSalario.setVisible(false);
			}
		});
		btnCancelar.setBounds(103, 155, 79, 23);
		FiltroSalario.add(btnCancelar);
		FiltroSalario.setVisible(false);
		
		JPanel FiltroCargo = new JPanel();
		FiltroCargo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		FiltroCargo.setBounds(315, 98, 192, 229);
		listarFuncionarios.add(FiltroCargo);
		FiltroCargo.setLayout(null);
		FiltroCargo.setVisible(false);
		
		JLabel lblFiltrarPorCargo = new JLabel("Filtrar por Cargo");
		lblFiltrarPorCargo.setFont(new Font("Arial", Font.BOLD, 16));
		lblFiltrarPorCargo.setBounds(32, 11, 125, 19);
		FiltroCargo.add(lblFiltrarPorCargo);
		
		JRadioButton rdbtnCozinheiro = new JRadioButton("Cozinheiro");
		rdbtnCozinheiro.setSelected(true);
		rdbtnCozinheiro.setBounds(6, 46, 125, 23);
		FiltroCargo.add(rdbtnCozinheiro);
		
		JRadioButton rdbtnChef = new JRadioButton("Chef");
		rdbtnChef.setSelected(true);
		rdbtnChef.setBounds(6, 72, 125, 23);
		FiltroCargo.add(rdbtnChef);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setSelected(true);
		rdbtnGerente.setBounds(6, 98, 125, 23);
		FiltroCargo.add(rdbtnGerente);
		
		JRadioButton rdbtnGarom = new JRadioButton("Gar\u00E7om");
		rdbtnGarom.setSelected(true);
		rdbtnGarom.setBounds(6, 124, 125, 23);
		FiltroCargo.add(rdbtnGarom);
		
		JRadioButton rdbtnServiosGerais = new JRadioButton("Servi\u00E7os Gerais");
		rdbtnServiosGerais.setSelected(true);
		rdbtnServiosGerais.setBounds(6, 154, 125, 23);
		FiltroCargo.add(rdbtnServiosGerais);
		
		JButton btnFiltrar2 = new JButton("Filtrar");
		btnFiltrar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String listaCargos = "";
				
				if(rdbtnCozinheiro.isSelected())
					listaCargos += gerir.FiltroCargo(Cargo.COZINHEIRO);
				if(rdbtnChef.isSelected())
					listaCargos += gerir.FiltroCargo(Cargo.CHEF_DE_COZINHA);
				if(rdbtnGerente.isSelected())
					listaCargos += gerir.FiltroCargo(Cargo.GERENTE);
				if(rdbtnGarom.isSelected())
					listaCargos += gerir.FiltroCargo(Cargo.GARCOM);
				if(rdbtnServiosGerais.isSelected())
					listaCargos += gerir.FiltroCargo(Cargo.SERVIÇOS);
				
				final String text = listaCargos;
				
				listaFuncionarios.setModel(new AbstractListModel() {
					String[] values = text.split("\n");
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				
			}
		});
		btnFiltrar2.setBounds(6, 195, 81, 23);
		FiltroCargo.add(btnFiltrar2);
		
		JButton btnCancelar2 = new JButton("Cancelar");
		btnCancelar2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiltroCargo.setVisible(false);
			}
		});
		btnCancelar2.setBounds(97, 195, 85, 23);
		FiltroCargo.add(btnCancelar2);
		btnFiltroRg.setBounds(363, 35, 89, 23);
		listarFuncionarios.add(btnFiltroRg);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar Por:");
		lblFiltrarPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrarPor.setFont(new Font("Arial", Font.BOLD, 16));
		lblFiltrarPor.setBounds(363, 5, 89, 19);
		listarFuncionarios.add(lblFiltrarPor);
		
		JButton btnCargo = new JButton("Cargo");
		btnCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiltroCargo.setVisible(true);
			}
		});
		btnCargo.setBounds(363, 69, 89, 23);
		listarFuncionarios.add(btnCargo);
		
		JPanel reduzirPanel = new JPanel();
		reduzirPanel.setLayout(null);
		reduzirPanel.setBackground(new Color(224, 255, 255));
		reduzirPanel.setBounds(85, 69, 409, 327);
		getContentPane().add(reduzirPanel);
		reduzirPanel.setVisible(false);
		
		JLabel lblReduzirSalario5 = new JLabel("Reduzir Salario");
		lblReduzirSalario5.setFont(new Font("Arial", Font.BOLD, 18));
		lblReduzirSalario5.setBounds(140, 11, 151, 22);
		reduzirPanel.add(lblReduzirSalario5);
		
		JLabel lblRG5 = new JLabel("RG:");
		lblRG5.setHorizontalAlignment(SwingConstants.CENTER);
		lblRG5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRG5.setBounds(10, 65, 66, 19);
		reduzirPanel.add(lblRG5);
		
		RG5textField = new JTextField();
		RG5textField.setColumns(10);
		RG5textField.setBounds(86, 66, 117, 21);
		reduzirPanel.add(RG5textField);
		
		JLabel lblNome5 = new JLabel("Nome:");
		lblNome5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome5.setBounds(10, 110, 68, 19);
		reduzirPanel.add(lblNome5);
		
		Nome5TextField = new JTextField();
		Nome5TextField.setEditable(false);
		Nome5TextField.setColumns(10);
		Nome5TextField.setBounds(86, 110, 263, 22);
		reduzirPanel.add(Nome5TextField);
		
		JLabel lblCargo5 = new JLabel("Cargo:");
		lblCargo5.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCargo5.setBounds(10, 155, 70, 19);
		reduzirPanel.add(lblCargo5);
		
		Cargo5textField = new JTextField();
		Cargo5textField.setFont(new Font("Arial", Font.PLAIN, 16));
		Cargo5textField.setEditable(false);
		Cargo5textField.setColumns(10);
		Cargo5textField.setBounds(86, 154, 151, 22);
		reduzirPanel.add(Cargo5textField);
		
		JLabel lblReduzir = new JLabel("Redu\u00E7\u00E3o:");
		lblReduzir.setFont(new Font("Arial", Font.PLAIN, 16));
		lblReduzir.setBounds(10, 236, 70, 19);
		reduzirPanel.add(lblReduzir);
		
		JButton btnReduzir = new JButton("Reduzir");
		btnReduzir.setEnabled(false);
		btnReduzir.setBounds(175, 279, 89, 23);
		reduzirPanel.add(btnReduzir);
		
		JLabel lblSalario5 = new JLabel("Salario:");
		lblSalario5.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalario5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSalario5.setBounds(10, 197, 70, 19);
		reduzirPanel.add(lblSalario5);
		
		Salario5textField = new JTextField();
		Salario5textField.setFont(new Font("Arial", Font.PLAIN, 16));
		Salario5textField.setEditable(false);
		Salario5textField.setColumns(10);
		Salario5textField.setBounds(86, 195, 151, 22);
		reduzirPanel.add(Salario5textField);
		
		JButton btnProcurar5 = new JButton("Procurar");
		btnProcurar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario encontrado = gerir.buscaFuncionario(Integer.parseInt(RG5textField.getText()));
				if(encontrado != null)
				{
					Nome5TextField.setText(encontrado.getNome());
					Cargo5textField.setText(encontrado.getCargo().getNome());
					Salario5textField.setText("R$ " + encontrado.getSalario());
					btnReduzir.setEnabled(true);
					
				} else {
					Nome5TextField.setText("Funcionario não encontrado");
					Cargo5textField.setText("");
					Salario5textField.setText("R$ 0.00");
					btnReduzir.setEnabled(false);
				}
			}
		});
		btnProcurar5.setBounds(213, 65, 89, 23);
		reduzirPanel.add(btnProcurar5);
		
		JSpinner reduzirSpinner = new JSpinner();
		reduzirSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(100)));
		reduzirSpinner.setBounds(86, 237, 151, 20);
		reduzirPanel.add(reduzirSpinner);
		
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
		btnProm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProm.setEnabled(false);
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
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setFont(new Font("Arial", Font.PLAIN, 16));
		lblRg.setBounds(37, 88, 56, 19);
		promocaoPanel.add(lblRg);
		
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
		
		JComboBox cargo3ComboBox = new JComboBox();
		cargo3ComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		cargo3ComboBox.setModel(new DefaultComboBoxModel(Cargo.values()));
		cargo3ComboBox.setBounds(103, 180, 146, 20);
		promocaoPanel.add(cargo3ComboBox);
		cargo3ComboBox.setEnabled(false);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario encontrado = gerir.buscaFuncionario(Integer.parseInt(ID3TextField.getText()));
				if(encontrado != null)
				{
					nome3TextField.setText(encontrado.getNome());
					cargo3ComboBox.setEnabled(true);
					btnProm.setEnabled(true);
					
					switch(encontrado.getCargo()) 
					{
					case GARCOM:
						cargo3ComboBox.setSelectedIndex(0);
						break;
					case COZINHEIRO:
						cargo3ComboBox.setSelectedIndex(1);
						break;
					case CHEF_DE_COZINHA:
						cargo3ComboBox.setSelectedIndex(2);
						break;
					case GERENTE:
						cargo3ComboBox.setSelectedIndex(3);
						break;
					case SERVIÇOS:
						cargo3ComboBox.setSelectedIndex(4);
						break;
					}
					
				} else {
					nome3TextField.setText("Funcionario não encontrado");
					cargo3ComboBox.setEnabled(false);
					btnProm.setEnabled(false);
				}
			}
		});
		btnProcurar.setBounds(203, 87, 95, 20);
		promocaoPanel.add(btnProcurar);
		
		JPanel darAumentoPanel = new JPanel();
		darAumentoPanel.setBackground(new Color(224, 255, 255));
		darAumentoPanel.setBounds(85, 69, 409, 327);
		getContentPane().add(darAumentoPanel);
		darAumentoPanel.setLayout(null);
		darAumentoPanel.setVisible(false);
		
		JLabel lblAumentarSalario = new JLabel("Aumentar Salario");
		lblAumentarSalario.setFont(new Font("Arial", Font.BOLD, 18));
		lblAumentarSalario.setBounds(140, 11, 151, 22);
		darAumentoPanel.add(lblAumentarSalario);
		
		JLabel lblID4 = new JLabel("RG:");
		lblID4.setHorizontalAlignment(SwingConstants.CENTER);
		lblID4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblID4.setBounds(15, 65, 66, 19);
		darAumentoPanel.add(lblID4);
		
		ID4textField = new JTextField();
		ID4textField.setBounds(91, 66, 117, 22);
		darAumentoPanel.add(ID4textField);
		ID4textField.setColumns(10);
		
		JLabel lblNome4 = new JLabel("Nome:");
		lblNome4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome4.setBounds(15, 101, 66, 19);
		darAumentoPanel.add(lblNome4);
		
		nome4textField = new JTextField();
		nome4textField.setEditable(false);
		nome4textField.setBounds(91, 101, 273, 22);
		darAumentoPanel.add(nome4textField);
		nome4textField.setColumns(10);
		
		JLabel lblCargo4 = new JLabel("Cargo:");
		lblCargo4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCargo4.setBounds(15, 146, 66, 19);
		darAumentoPanel.add(lblCargo4);
		
		cargo4textField = new JTextField();
		cargo4textField.setEditable(false);
		cargo4textField.setFont(new Font("Arial", Font.PLAIN, 16));
		cargo4textField.setBounds(91, 145, 161, 22);
		darAumentoPanel.add(cargo4textField);
		cargo4textField.setColumns(10);
		
		JLabel lblAumento = new JLabel("Aumento:");
		lblAumento.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAumento.setBounds(15, 227, 66, 19);
		darAumentoPanel.add(lblAumento);
		
		JButton btnAlterar4 = new JButton("Aumentar");
		btnAlterar4.setEnabled(false);
		btnAlterar4.setBounds(164, 279, 106, 23);
		darAumentoPanel.add(btnAlterar4);
		
		JButton btnProcurar4 = new JButton("Procurar");
		btnProcurar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario encontrado = gerir.buscaFuncionario(Integer.parseInt(ID4textField.getText()));
				if(encontrado != null)
				{
					nome4textField.setText(encontrado.getNome());
					cargo4textField.setText(encontrado.getCargo().getNome());
					salario4TextField.setText("R$ " + encontrado.getSalario());
					btnAlterar4.setEnabled(true);
					
				} else {
					nome4textField.setText("Funcionario não encontrado");
					cargo4textField.setText("");
					salario4TextField.setText("R$ 0.00");
					btnAlterar4.setEnabled(false);
				}
			}
		});
		btnProcurar4.setBounds(218, 65, 89, 22);
		darAumentoPanel.add(btnProcurar4);
		
		JSpinner aumentoSpinner = new JSpinner();
		aumentoSpinner.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(100)));
		aumentoSpinner.setBounds(91, 227, 151, 22);
		darAumentoPanel.add(aumentoSpinner);
		
		JLabel lblSalario4 = new JLabel("Salario:");
		lblSalario4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalario4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSalario4.setBounds(15, 186, 66, 19);
		darAumentoPanel.add(lblSalario4);
		
		salario4TextField = new JTextField();
		salario4TextField.setFont(new Font("Arial", Font.PLAIN, 16));
		salario4TextField.setEditable(false);
		salario4TextField.setColumns(10);
		salario4TextField.setBounds(91, 187, 161, 22);
		darAumentoPanel.add(salario4TextField);
		
		JPanel demitirPanel = new JPanel();
		demitirPanel.setBackground(new Color(224, 255, 255));
		demitirPanel.setBounds(85, 69, 409, 327);
		getContentPane().add(demitirPanel);
		demitirPanel.setLayout(null);
		demitirPanel.setVisible(false);
		
		JLabel lblNome2 = new JLabel("Nome:");
		lblNome2.setBounds(38, 115, 46, 19);
		lblNome2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome2.setFont(new Font("Arial", Font.PLAIN, 16));
		demitirPanel.add(lblNome2);
		
		JLabel lblID2 = new JLabel("RG:");
		lblID2.setBounds(38, 74, 46, 19);
		lblID2.setHorizontalAlignment(SwingConstants.CENTER);
		lblID2.setFont(new Font("Arial", Font.PLAIN, 16));
		demitirPanel.add(lblID2);
		
		nome2TextField = new JTextField();
		nome2TextField.setEditable(false);
		nome2TextField.setBounds(94, 115, 272, 23);
		nome2TextField.setFont(new Font("Arial", Font.PLAIN, 16));
		nome2TextField.setColumns(10);
		demitirPanel.add(nome2TextField);
		
		ID2TextField = new JTextField();
		ID2TextField.setBounds(94, 74, 99, 23);
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
		
		JButton btnProcurar2 = new JButton("Procurar");
		btnProcurar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario encontrado = gerir.buscaFuncionario(Integer.parseInt(ID2TextField.getText()));
				if(encontrado != null)
				{
					nome2TextField.setText(encontrado.getNome());
				} else {
					nome2TextField.setText("Funcionario não encontrado");
				}
			}
		});
		btnProcurar2.setBounds(203, 74, 89, 23);
		demitirPanel.add(btnProcurar2);
		
		JPanel efetivarPanel = new JPanel();
		efetivarPanel.setBackground(new Color(224, 255, 255));
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
		
		JLabel lblId = new JLabel("RG:");
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
		IDTextField.setBounds(94, 113, 105, 20);
		efetivarPanel.add(IDTextField);
		
		JLabel lbEfetivar = new JLabel("Efetivar");
		lbEfetivar.setHorizontalAlignment(SwingConstants.CENTER);
		lbEfetivar.setFont(new Font("Arial", Font.BOLD, 18));
		lbEfetivar.setBounds(169, 26, 77, 22);
		efetivarPanel.add(lbEfetivar);
		
		JComboBox cargoComboBox = new JComboBox();
		cargoComboBox.setModel(new DefaultComboBoxModel(Cargo.values()));
		cargoComboBox.setBounds(94, 157, 152, 20);
		efetivarPanel.add(cargoComboBox);
		
		JButton btnEfetivarInterno = new JButton("OK");
		btnEfetivarInterno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!nomeTextField.getText().isEmpty() && !IDTextField.getText().isEmpty()) {
					String nomeFunc = nomeTextField.getText();
					int RGFunc = Integer.parseInt(IDTextField.getText());
					Cargo cargoFunc = (Cargo) cargoComboBox.getSelectedItem();
					gerir.CadastrarFuncionario(nomeFunc, RGFunc, cargoFunc);
				}
			}
		});
		btnEfetivarInterno.setBounds(276, 266, 89, 23);
		efetivarPanel.add(btnEfetivarInterno);
		
		JButton btnCancelarEfet = new JButton("Limpar");
		btnCancelarEfet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeTextField.setText("");
				IDTextField.setText("");
				cargoComboBox.setSelectedIndex(1);
			}
		});
		btnCancelarEfet.setBounds(177, 266, 89, 23);
		efetivarPanel.add(btnCancelarEfet);
		
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
		btnDarAumento.setForeground(Color.BLACK);
		btnDarAumento.setBackground(Color.WHITE);
		btnDarAumento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelAtivo.setVisible(false);
				PainelAtivo.setEnabled(false);
				PainelAtivo = darAumentoPanel;
				darAumentoPanel.setVisible(true);
				darAumentoPanel.setEnabled(true);
			}
		});
		mnFuncionarios.add(btnDarAumento);
		
		JButton btnReduzirSalario = new JButton("Reduzir Salario");
		btnReduzirSalario.setForeground(Color.BLACK);
		btnReduzirSalario.setBackground(Color.WHITE);
		btnReduzirSalario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelAtivo.setVisible(false);
				PainelAtivo.setEnabled(false);
				PainelAtivo = reduzirPanel;
				reduzirPanel.setVisible(true);
				reduzirPanel.setEnabled(true);
			}
		});
		mnFuncionarios.add(btnReduzirSalario);
		
		JButton btnListarFuncionarios = new JButton("Listar Funcionarios");
		btnListarFuncionarios.setForeground(Color.BLACK);
		btnListarFuncionarios.setBackground(Color.WHITE);
		btnListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelAtivo.setVisible(false);
				PainelAtivo.setEnabled(false);
				PainelAtivo = listarFuncionarios;
				listaFuncionarios.setModel(new AbstractListModel() {
					String[] values = gerir.ListaFuncionarios().split("\n");
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				listarFuncionarios.setVisible(true);
				listarFuncionarios.setEnabled(true);
			}
		});
		mnFuncionarios.add(btnListarFuncionarios);
		
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
