package graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import run.MenuWindow;
import tables.Arquivos;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ListaWindow extends JFrame {

	private JPanel contentPane;
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnAtualizar;
	private JButton btnVoltar;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ListaWindow() throws IOException {
		setTitle("Lista de Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{167, 69, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JComboBox cbxTipoPedidos = new JComboBox();
		cbxTipoPedidos.setModel(new DefaultComboBoxModel(new String[] {"Mostrar Tudo", "Apenas Pedidos Pendentes", "Apenas Pedidos Finalizados"}));
		cbxTipoPedidos.setSelectedIndex(0);
		GridBagConstraints gbc_cbxTipoPedidos = new GridBagConstraints();
		gbc_cbxTipoPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_cbxTipoPedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxTipoPedidos.gridx = 0;
		gbc_cbxTipoPedidos.gridy = 0;
		contentPane.add(cbxTipoPedidos, gbc_cbxTipoPedidos);
		
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		model.addColumn("Status");
		model.addColumn("Nome");
		model.addColumn("CPF");
		model.addColumn("Equipamento");
		model.addColumn("Data Inicial");
		model.addColumn("Data Final");
		
		btnAtualizar = new JButton(new AbstractAction("Atualizar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				while(model.getRowCount() != 0) {
					model.removeRow(0);
				}
				
				try {
					criarLista(cbxTipoPedidos.getSelectedIndex());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAtualizar = new GridBagConstraints();
		gbc_btnAtualizar.anchor = GridBagConstraints.WEST;
		gbc_btnAtualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizar.gridx = 1;
		gbc_btnAtualizar.gridy = 0;
		contentPane.add(btnAtualizar, gbc_btnAtualizar);
		
		btnVoltar = new JButton(new AbstractAction("Voltar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new MenuWindow().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.anchor = GridBagConstraints.EAST;
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 0);
		gbc_btnVoltar.gridx = 7;
		gbc_btnVoltar.gridy = 0;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scroll, gbc_scrollPane);
		
		this.criarLista(cbxTipoPedidos.getSelectedIndex());
	}
	
	public void criarLista(int index) throws IOException {
		if (!new File("c:\\Projeto Equipamentos\\Pedidos\\").exists()) {
			JOptionPane.showMessageDialog(null, "Não foi cadastrado nenhum pedido ainda!");
			return;
		}
		
		File file = new File("c:\\Projeto Equipamentos\\Pedidos\\");
		
		File[] arquivos = file.listFiles();
		
		String[] dados;
		
		for(File f : arquivos) {
			switch (index) {
			case 0:
				dados = Arquivos.prepararLista(f);
				
				model.addRow(dados);
				break;
			case 1:
				if (!f.getName().startsWith("[F]")) {
					dados = Arquivos.prepararLista(f);
					
					model.addRow(dados);
				}
				break;
			case 2:
				if (f.getName().startsWith("[F]")) {
					dados = Arquivos.prepararLista(f);
					
					model.addRow(dados);
				}
				break;
			}
		}
	}
}
