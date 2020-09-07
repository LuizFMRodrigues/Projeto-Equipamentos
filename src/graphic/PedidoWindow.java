package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import run.MenuWindow;
import tables.Endereco;
import tables.Equipamento;
import tables.Pedidos;

import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PedidoWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfCidade;
	private JLabel lblNewLabel_2;
	private JTextField txfBairro;
	private JLabel lblNewLabel_3;
	private JTextField txfRua;
	private JLabel lblNewLabel_4;
	private JTextField txfNum;
	private JLabel lblNewLabel_5;
	private JTextField txfCep;
	private JLabel lblNewLabel_6;
	private JTextField txfBloco;
	private JLabel lblApartamento;
	private JTextField txfApartamento;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextPane txpDesc;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txfTipo;
	private JLabel lblNewLabel_11;
	private JTextField txfMarca;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private JLabel lblNewLabel_12;
	private JTextField txfTelefone;
	private JLabel lblNewLabel_13;
	private JTextField txfEmail;
	private JLabel lblNewLabel_14;
	private JTextField txfCpf;
	private JLabel lblNewLabel_15;
	private JComboBox cbxStatus;
	private JTextField txfPedido;
	private JLabel lblNewLabel_16;

	/**
	 * Create the frame.
	 */
	public PedidoWindow() {
		setTitle("Cadastrar Pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{146, 178, 98, 158, 80, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_15 = new JLabel("Status do pedido");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 0;
		contentPane.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Nome/C\u00F3digo do Pedido");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.gridwidth = 2;
		gbc_lblNewLabel_16.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 2;
		gbc_lblNewLabel_16.gridy = 0;
		contentPane.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		cbxStatus = new JComboBox();
		cbxStatus.setModel(new DefaultComboBoxModel(new String[] {"Pendente", "Finalizado"}));
		cbxStatus.setSelectedIndex(0);
		GridBagConstraints gbc_cbxStatus = new GridBagConstraints();
		gbc_cbxStatus.gridwidth = 2;
		gbc_cbxStatus.insets = new Insets(0, 0, 5, 5);
		gbc_cbxStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxStatus.gridx = 0;
		gbc_cbxStatus.gridy = 1;
		contentPane.add(cbxStatus, gbc_cbxStatus);
		
		txfPedido = new JTextField();
		GridBagConstraints gbc_txfPedido = new GridBagConstraints();
		gbc_txfPedido.gridwidth = 3;
		gbc_txfPedido.insets = new Insets(0, 0, 5, 0);
		gbc_txfPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPedido.gridx = 2;
		gbc_txfPedido.gridy = 1;
		contentPane.add(txfPedido, gbc_txfPedido);
		txfPedido.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Cliente");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_14 = new JLabel("CPF (N\u00FAmeros)");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 3;
		gbc_lblNewLabel_14.gridy = 3;
		contentPane.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.gridwidth = 3;
		gbc_txfNome.insets = new Insets(0, 0, 5, 5);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 0;
		gbc_txfNome.gridy = 4;
		contentPane.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		txfCpf = new JTextField();
		GridBagConstraints gbc_txfCpf = new GridBagConstraints();
		gbc_txfCpf.gridwidth = 2;
		gbc_txfCpf.insets = new Insets(0, 0, 5, 0);
		gbc_txfCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCpf.gridx = 3;
		gbc_txfCpf.gridy = 4;
		contentPane.add(txfCpf, gbc_txfCpf);
		txfCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Bairro");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txfCidade = new JTextField();
		txfCidade.setToolTipText("");
		GridBagConstraints gbc_txfCidade = new GridBagConstraints();
		gbc_txfCidade.gridwidth = 3;
		gbc_txfCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txfCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCidade.gridx = 0;
		gbc_txfCidade.gridy = 6;
		contentPane.add(txfCidade, gbc_txfCidade);
		txfCidade.setColumns(10);
		
		txfBairro = new JTextField();
		GridBagConstraints gbc_txfBairro = new GridBagConstraints();
		gbc_txfBairro.gridwidth = 2;
		gbc_txfBairro.insets = new Insets(0, 0, 5, 0);
		gbc_txfBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBairro.gridx = 3;
		gbc_txfBairro.gridy = 6;
		contentPane.add(txfBairro, gbc_txfBairro);
		txfBairro.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Rua");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txfRua = new JTextField();
		GridBagConstraints gbc_txfRua = new GridBagConstraints();
		gbc_txfRua.gridwidth = 5;
		gbc_txfRua.insets = new Insets(0, 0, 5, 0);
		gbc_txfRua.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfRua.gridx = 0;
		gbc_txfRua.gridy = 8;
		contentPane.add(txfRua, gbc_txfRua);
		txfRua.setColumns(10);
		
		lblNewLabel_4 = new JLabel("N\u00FAmero");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 9;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("CEP");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 9;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Bloco");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 9;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblApartamento = new JLabel("Apartamento");
		GridBagConstraints gbc_lblApartamento = new GridBagConstraints();
		gbc_lblApartamento.anchor = GridBagConstraints.WEST;
		gbc_lblApartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblApartamento.gridx = 3;
		gbc_lblApartamento.gridy = 9;
		contentPane.add(lblApartamento, gbc_lblApartamento);
		
		txfNum = new JTextField();
		GridBagConstraints gbc_txfNum = new GridBagConstraints();
		gbc_txfNum.insets = new Insets(0, 0, 5, 5);
		gbc_txfNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNum.gridx = 0;
		gbc_txfNum.gridy = 10;
		contentPane.add(txfNum, gbc_txfNum);
		txfNum.setColumns(10);
		
		txfCep = new JTextField();
		GridBagConstraints gbc_txfCep = new GridBagConstraints();
		gbc_txfCep.insets = new Insets(0, 0, 5, 5);
		gbc_txfCep.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCep.gridx = 1;
		gbc_txfCep.gridy = 10;
		contentPane.add(txfCep, gbc_txfCep);
		txfCep.setColumns(10);
		
		txfBloco = new JTextField();
		GridBagConstraints gbc_txfBloco = new GridBagConstraints();
		gbc_txfBloco.insets = new Insets(0, 0, 5, 5);
		gbc_txfBloco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBloco.gridx = 2;
		gbc_txfBloco.gridy = 10;
		contentPane.add(txfBloco, gbc_txfBloco);
		txfBloco.setColumns(10);
		
		txfApartamento = new JTextField();
		GridBagConstraints gbc_txfApartamento = new GridBagConstraints();
		gbc_txfApartamento.insets = new Insets(0, 0, 5, 0);
		gbc_txfApartamento.gridwidth = 2;
		gbc_txfApartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfApartamento.gridx = 3;
		gbc_txfApartamento.gridy = 10;
		contentPane.add(txfApartamento, gbc_txfApartamento);
		txfApartamento.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Telefone");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 11;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 1;
		gbc_lblNewLabel_13.gridy = 11;
		contentPane.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		txfTelefone = new JTextField();
		GridBagConstraints gbc_txfTelefone = new GridBagConstraints();
		gbc_txfTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTelefone.gridx = 0;
		gbc_txfTelefone.gridy = 12;
		contentPane.add(txfTelefone, gbc_txfTelefone);
		txfTelefone.setColumns(10);
		
		txfEmail = new JTextField();
		GridBagConstraints gbc_txfEmail = new GridBagConstraints();
		gbc_txfEmail.gridwidth = 4;
		gbc_txfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfEmail.gridx = 1;
		gbc_txfEmail.gridy = 12;
		contentPane.add(txfEmail, gbc_txfEmail);
		txfEmail.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Equipamento");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 13;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Descri\u00E7\u00E3o do problema");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 14;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txpDesc = new JTextPane();
		GridBagConstraints gbc_txpDesc = new GridBagConstraints();
		gbc_txpDesc.gridwidth = 5;
		gbc_txpDesc.insets = new Insets(0, 0, 5, 0);
		gbc_txpDesc.fill = GridBagConstraints.BOTH;
		gbc_txpDesc.gridx = 0;
		gbc_txpDesc.gridy = 15;
		contentPane.add(txpDesc, gbc_txpDesc);
		
		lblNewLabel_10 = new JLabel("Tipo");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 16;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Marca");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 2;
		gbc_lblNewLabel_11.gridy = 16;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		txfTipo = new JTextField();
		GridBagConstraints gbc_txfTipo = new GridBagConstraints();
		gbc_txfTipo.gridwidth = 2;
		gbc_txfTipo.insets = new Insets(0, 0, 5, 5);
		gbc_txfTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTipo.gridx = 0;
		gbc_txfTipo.gridy = 17;
		contentPane.add(txfTipo, gbc_txfTipo);
		txfTipo.setColumns(10);
		
		txfMarca = new JTextField();
		GridBagConstraints gbc_txfMarca = new GridBagConstraints();
		gbc_txfMarca.insets = new Insets(0, 0, 5, 0);
		gbc_txfMarca.gridwidth = 3;
		gbc_txfMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMarca.gridx = 2;
		gbc_txfMarca.gridy = 17;
		contentPane.add(txfMarca, gbc_txfMarca);
		txfMarca.setColumns(10);
		
		btnSalvar = new JButton(new AbstractAction("Salvar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Endereco ender = new Endereco(txfCidade.getText(), txfBairro.getText(), txfRua.getText(), txfNum.getText(), txfCep.getText(), txfBloco.getText(), txfApartamento.getText());
				Equipamento equip = new Equipamento(txpDesc.getText(), txfTipo.getText(), txfMarca.getText());
				Pedidos pedido = new Pedidos(txfPedido.getText(), txfNome.getText(), txfCpf.getText(), ender, txfTelefone.getText(), txfEmail.getText(), equip, cbxStatus.getSelectedIndex());
				
					String codFunc = JOptionPane.showInputDialog(null, "Informe o código de funcionário:");
					
					if (codFunc != null) {
						if (new File("c:\\Projeto Equipamentos\\Funcionários\\" + codFunc + ".txt").exists()) {
							try {
								pedido.salvarPedido(codFunc);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "Código inválido!");
						}						
					}
					
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.EAST;
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 3;
		gbc_btnSalvar.gridy = 18;
		contentPane.add(btnSalvar, gbc_btnSalvar);
		
		btnVoltar = new JButton(new AbstractAction("Cancelar") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				new MenuWindow().setVisible(true);
			}
		});
		btnVoltar.setText("Voltar");
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.gridx = 4;
		gbc_btnVoltar.gridy = 18;
		contentPane.add(btnVoltar, gbc_btnVoltar);
	}
}
