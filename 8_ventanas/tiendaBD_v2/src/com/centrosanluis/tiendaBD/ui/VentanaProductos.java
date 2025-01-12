package com.centrosanluis.tiendaBD.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.centrosanluis.tiendaBD.bd.AccesoBD;
import com.centrosanluis.tiendaBD.dto.ProductoDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class VentanaProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtValorDescuento;
	private JTextField txtColor;
	private final ButtonGroup BtnGroupEstado = new ButtonGroup();
	private JRadioButton radioSeleccionado;
	private JTable tablaProductos;
	private JTextField txtFiltroNombre;

	public VentanaProductos(AccesoBD bd) throws SQLException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Productos");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(35, 21, 100, 20);
		contentPane.add(lblTitulo);
		
		JLabel lblProducto = new JLabel("Nuevo Producto");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProducto.setBounds(35, 106, 120, 14);
		contentPane.add(lblProducto);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("");
		txtNombre.setBounds(35, 145, 158, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setToolTipText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(35, 193, 158, 20);
		contentPane.add(txtPrecio);
		
		JComboBox comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Inform\u00E1tica", "Audio", "Electr\u00F3nica"}));
		comboCategoria.setBounds(35, 242, 158, 20);
		contentPane.add(comboCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(35, 176, 120, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 131, 120, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(35, 224, 120, 14);
		contentPane.add(lblCategoria);
		
		JCheckBox chckbxDescuento = new JCheckBox("Descuento");
		chckbxDescuento.setBounds(35, 276, 97, 23);
		contentPane.add(chckbxDescuento);
		
		JLabel lblValorDescuento = new JLabel("Valor Descuento");
		lblValorDescuento.setBounds(35, 306, 120, 14);
		contentPane.add(lblValorDescuento);
		
		txtValorDescuento = new JTextField();
		txtValorDescuento.setToolTipText("");
		txtValorDescuento.setColumns(10);
		txtValorDescuento.setBounds(35, 323, 158, 20);
		contentPane.add(txtValorDescuento);
		
		txtColor = new JTextField();
		txtColor.setToolTipText("");
		txtColor.setColumns(10);
		txtColor.setBounds(35, 371, 158, 20);
		contentPane.add(txtColor);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(35, 354, 120, 14);
		contentPane.add(lblColor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 70, 904, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(228, 118, 2, 506);
		contentPane.add(separator_1);
		
		JRadioButton rdbtnNuevo = new JRadioButton("Nuevo");
		BtnGroupEstado.add(rdbtnNuevo);
		rdbtnNuevo.setBounds(35, 421, 158, 23);
		contentPane.add(rdbtnNuevo);
		
		JRadioButton rdbtnReacondicionado = new JRadioButton("Reacondicionado");
		BtnGroupEstado.add(rdbtnReacondicionado);
		rdbtnReacondicionado.setBounds(35, 447, 158, 23);
		contentPane.add(rdbtnReacondicionado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(35, 402, 120, 14);
		contentPane.add(lblEstado);
		
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setBounds(35, 500, 158, 83);
		contentPane.add(txtDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(35, 475, 120, 14);
		contentPane.add(lblDescripcion);
		
		JButton btnAddProducto = new JButton("A\u00F1adir Producto");
		btnAddProducto.setForeground(new Color(255, 255, 255));
		btnAddProducto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddProducto.setBackground(new Color(34, 139, 34));
		btnAddProducto.setOpaque(true);
		btnAddProducto.setBounds(35, 594, 158, 30);
		contentPane.add(btnAddProducto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 224, 676, 359);
		contentPane.add(scrollPane);
		
		String[] nombreColumnas = {"nombre", "descripcion", "categoria", "precio", "descuento (%)","estado","color"};
		DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0);
		
		tablaProductos = new JTable(modeloTabla);
		scrollPane.setViewportView(tablaProductos);
		
		JLabel lblMostrarProductos = new JLabel("Mostrar Productos");
		lblMostrarProductos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMostrarProductos.setBounds(263, 107, 120, 14);
		contentPane.add(lblMostrarProductos);
		
		JLabel lblFiltros = new JLabel("Filtros:");
		lblFiltros.setBounds(263, 148, 62, 14);
		contentPane.add(lblFiltros);
		
		txtFiltroNombre = new JTextField();
		txtFiltroNombre.setBounds(399, 173, 131, 20);
		contentPane.add(txtFiltroNombre);
		txtFiltroNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(68, 68, 68));
		btnBuscar.setOpaque(true);
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBounds(619, 173, 147, 21);
		contentPane.add(btnBuscar);
		
		JCheckBox chckbxOferta = new JCheckBox("En oferta");
		chckbxOferta.setBounds(536, 172, 77, 23);
		contentPane.add(chckbxOferta);
		
		JLabel lblNombreFiltro = new JLabel("Filtrar por Nombre");
		lblNombreFiltro.setBounds(263, 176, 120, 14);
		contentPane.add(lblNombreFiltro);
		
		rellenarTabla(bd, modeloTabla, "SELECT * FROM productos");

		btnAddProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = txtNombre.getText();
				String color = txtColor.getText();
				String descripcion = txtDescripcion.getText();
				String precio = txtPrecio.getText();
				String valorDescuento = txtValorDescuento.getText();
				String estado = null;
				boolean descuento;
				if(rdbtnNuevo.isSelected()) {
					estado = rdbtnNuevo.getText();
				}
				if(rdbtnReacondicionado.isSelected()) {
					estado = rdbtnReacondicionado.getText();
				}		
				String categoria = comboCategoria.getSelectedItem().toString();
								
				if(chckbxDescuento.isSelected()) {
					descuento = true;
				} else {
					descuento = false;
				}
				if(validarCampos(nombre, categoria, descripcion, color, estado, precio, descuento, valorDescuento)) {
					ProductoDTO p = new ProductoDTO();
					p.setNombre(nombre);
					p.setColor(color);
					p.setDescripcion(descripcion);
					p.setPrecio(Float.parseFloat(precio));
					p.setEstado(estado);
					p.setCategoria(categoria);
					if(descuento) {
						p.setDescuento(true);
						p.setValorDescuento(Integer.parseInt(valorDescuento));
					} else {
						p.setDescuento(false);
						p.setValorDescuento(0);
					}
					
					try {
						bd.addProducto(p);
						modeloTabla.setRowCount(0);
						rellenarTabla(bd, modeloTabla,"SELECT * FROM productos");
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}				
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "SELECT * FROM productos WHERE nombre like '%"+txtFiltroNombre.getText()+"%'";
				if(chckbxOferta.isSelected()) {
					sql += "AND descuento = 1 ";
				}
				
				try {
					modeloTabla.setRowCount(0);
					rellenarTabla(bd, modeloTabla,sql);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	private boolean validarCampos(String nombre, String categoria, String descripcion, String color, String estado,
			String precio, boolean descuento, String valorDescuento) {
		System.out.println("validando");
		if(nombre.equals("")) {
			return false;
		}
		if(categoria.equals("")) {
			return false;
		}
		if(descripcion.equals("")) {
			return false;
		}
		if(color.equals("")) {
			return false;
		}
		if(estado.equals("") || estado.equals(null)) {
			return false;
		}
		if(precio.equals("")) {
			return false;
		}
		if(descuento==true && valorDescuento.equals("")) {
			return false;
		}
		
		return true;
		
	}
	private void rellenarTabla(AccesoBD bd, DefaultTableModel modelo, String sql) throws ClassNotFoundException, SQLException {
		bd.conectar();
		ArrayList<ProductoDTO> productos = bd.getProductosFiltrados(sql);
		for (ProductoDTO p : productos) {
			Object[] fila = {p.getNombre(), p.getDescripcion(), p.getCategoria(), p.getPrecio(), p.getValorDescuento(), p.getEstado(),p.getColor()};
			modelo.addRow(fila);
		}
		bd.desconectar();
	}

}
