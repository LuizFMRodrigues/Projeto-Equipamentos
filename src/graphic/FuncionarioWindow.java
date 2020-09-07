package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import run.MenuWindow;
import tables.Funcionarios;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class FuncionarioWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txfId;
	private JTextField txfNome;
	private JTextField txfCpf;
	private JTextField txfCargo;

	/**
	 * Create the frame.
	 */
	public FuncionarioWindow() {
		setTitle("Cadastrar Funcion\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txfNome = new JTextField();
		GridBagConstraints gbc_txfNome = new GridBagConstraints();
		gbc_txfNome.gridwidth = 8;
		gbc_txfNome.insets = new Insets(0, 0, 5, 0);
		gbc_txfNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNome.gridx = 0;
		gbc_txfNome.gridy = 1;
		contentPane.add(txfNome, gbc_txfNome);
		txfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txfId = new JTextField();
		GridBagConstraints gbc_txfId = new GridBagConstraints();
		gbc_txfId.insets = new Insets(0, 0, 5, 5);
		gbc_txfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfId.gridx = 0;
		gbc_txfId.gridy = 3;
		contentPane.add(txfId, gbc_txfId);
		txfId.setColumns(10);
		
		txfCpf = new JTextField();
		GridBagConstraints gbc_txfCpf = new GridBagConstraints();
		gbc_txfCpf.gridwidth = 7;
		gbc_txfCpf.insets = new Insets(0, 0, 5, 0);
		gbc_txfCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCpf.gridx = 1;
		gbc_txfCpf.gridy = 3;
		contentPane.add(txfCpf, gbc_txfCpf);
		txfCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txfCargo = new JTextField();
		GridBagConstraints gbc_txfCargo = new GridBagConstraints();
		gbc_txfCargo.insets = new Insets(0, 0, 5, 0);
		gbc_txfCargo.gridwidth = 8;
		gbc_txfCargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfCargo.gridx = 0;
		gbc_txfCargo.gridy = 5;
		contentPane.add(txfCargo, gbc_txfCargo);
		txfCargo.setColumns(10);
		
		JButton btnSalvar = new JButton(new AbstractAction("Salvar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Funcionarios(txfId.getText(), txfNome.getText(), txfCpf.getText(), txfCargo.getText());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 6;
		gbc_btnSalvar.gridy = 6;
		contentPane.add(btnSalvar, gbc_btnSalvar);
		
		JButton btnCancelar = new JButton(new AbstractAction("Cancelar") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				new MenuWindow().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 6;
		contentPane.add(btnCancelar, gbc_btnCancelar);
	}

}
