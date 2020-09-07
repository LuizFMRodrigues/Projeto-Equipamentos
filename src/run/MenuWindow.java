package run;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import graphic.PedidoWindow;
import graphic.FuncionarioWindow;
import graphic.ListaWindow;

import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Font;

public class MenuWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuWindow() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.SOUTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JButton btnCadastrar = new JButton(new AbstractAction("Cadastrar Pedido") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new PedidoWindow().setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(btnCadastrar);
		
		JButton btnFuncionario = new JButton(new AbstractAction("Cadastrar Funcionário") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new FuncionarioWindow().setVisible(true);
			}
		});
		btnFuncionario.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnFuncionario = new GridBagConstraints();
		gbc_btnFuncionario.insets = new Insets(0, 0, 5, 0);
		gbc_btnFuncionario.gridx = 0;
		gbc_btnFuncionario.gridy = 1;
		contentPane.add(btnFuncionario, gbc_btnFuncionario);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		JButton btnVisualizar = new JButton(new AbstractAction("Visualizar Pedidos") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				try {
					new ListaWindow().setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVisualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnVisualizar);
	}

}
