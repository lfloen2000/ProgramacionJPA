package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.Estudiante;

import model.Tipologiasexo;
import model.controllers.ControladorEstudiantes;
import model.controllers.ControladorTiopologiassexo;


public class PNLestudiantes extends JPanel {
	
	
	JFileChooser jfileChooser;
	byte imagen[];
	JScrollPane scrollPane;


	Estudiante actual = new Estudiante();
	private JTextField Id;
	private JTextField nombre;
	private JTextField primer_apellido;
	private JTextField segundo_apellido;
	private JTextField DNI;
	private JTextField direccion;
	private JTextField email;
	private JTextField telefono;
	private JComboBox<Tipologiasexo> jcbSexo;
	private JTextField jtfColor = new JTextField();
	JButton jbtSeleccionar = new JButton ("Seleccionar color");
	JPanel jpPanelParaColorear = new JPanel();
	JColorChooser jColorChooser;

	/**
	 * Create the panel.
	 */
	public PNLestudiantes() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		Id = new JTextField();
		GridBagConstraints gbc_Id = new GridBagConstraints();
		gbc_Id.insets = new Insets(0, 0, 5, 5);
		gbc_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_Id.gridx = 1;
		gbc_Id.gridy = 0;
		add(Id, gbc_Id);
		Id.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
		gbc_lblNewLabel1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel1.gridx = 0;
		gbc_lblNewLabel1.gridy = 1;
		add(lblNewLabel1, gbc_lblNewLabel1);
		
		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombre.gridx = 1;
		gbc_nombre.gridy = 1;
		add(nombre, gbc_nombre);
		nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Primer Apellido");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		primer_apellido = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(primer_apellido, gbc_textField_1);
		primer_apellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Segundo Apellido");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		segundo_apellido = new JTextField();
		GridBagConstraints gbc_segundo_apellido = new GridBagConstraints();
		gbc_segundo_apellido.insets = new Insets(0, 0, 5, 5);
		gbc_segundo_apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_segundo_apellido.gridx = 1;
		gbc_segundo_apellido.gridy = 3;
		add(segundo_apellido, gbc_segundo_apellido);
		segundo_apellido.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		DNI = new JTextField();
		GridBagConstraints gbc_DNI = new GridBagConstraints();
		gbc_DNI.insets = new Insets(0, 0, 5, 5);
		gbc_DNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_DNI.gridx = 1;
		gbc_DNI.gridy = 4;
		add(DNI, gbc_DNI);
		DNI.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Sexo");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 5;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jcbSexo = new JComboBox<Tipologiasexo>();
		GridBagConstraints gbc_Tipologiasexo = new GridBagConstraints();
		gbc_Tipologiasexo.insets = new Insets(0, 0, 5, 5);
		gbc_Tipologiasexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_Tipologiasexo.gridx = 1;
		gbc_Tipologiasexo.gridy = 5;
		add(jcbSexo, gbc_Tipologiasexo);
		
		JLabel lblNewLabel_4 = new JLabel("Dirección");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		direccion = new JTextField();
		GridBagConstraints gbc_direccion = new GridBagConstraints();
		gbc_direccion.insets = new Insets(0, 0, 5, 5);
		gbc_direccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_direccion.gridx = 1;
		gbc_direccion.gridy = 6;
		add(direccion, gbc_direccion);
		direccion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 1;
		gbc_email.gridy = 7;
		add(email, gbc_email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Cambiar imagen");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cambiarimagen();
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		telefono = new JTextField();
		GridBagConstraints gbc_telefono = new GridBagConstraints();
		gbc_telefono.insets = new Insets(0, 0, 5, 5);
		gbc_telefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefono.gridx = 1;
		gbc_telefono.gridy = 8;
		add(telefono, gbc_telefono);
		telefono.setColumns(10);

		
		this.actual = ControladorEstudiantes.getInstance().findPrimero();
		
		JLabel lblNewLabel_8 = new JLabel("Color favorito");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cambiar color");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		add(btnNewButton_1, gbc_btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				seleccionaColor();
			}
		});
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 10;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiantes.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		panel.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		cargarTipologiasSexo();
		
		cargarActualEnPantalla();

	}

	
	
	
	
	
	private void cargarTipologiasSexo() {
		List<Tipologiasexo> tipos = ControladorTiopologiassexo.getInstance().findAll();
		
		for (Tipologiasexo tip : tipos) {
			this.jcbSexo.addItem(tip);
		}
	}
	
	
	
	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		if (this.actual != null) {
			this.Id.setText("" + this.actual.getId());
			this.nombre.setText(this.actual.getNombre());
			this.primer_apellido.setText(this.actual.getApellido1());
			this.segundo_apellido.setText(this.actual.getApellido2());
			this.DNI.setText(this.actual.getDni());
			this.direccion.setText("" + this.actual.getDireccion());
			this.email.setText("" + this.actual.getEmail());
			this.telefono.setText("" + this.actual.getTelefono());
			//this.actual.setTipologiasexo(((Tipologiasexo) jcbSexo.getSelectedItem()).getId());
			
			for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
				if (this.actual.getTipologiasexo().getId() == this.jcbSexo.getItemAt(i).getId()) {
					this.jcbSexo.setSelectedIndex(i);
				}
			}
		}

}
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.Id.setText("" + this.actual.getId());
			this.nombre.setText(this.actual.getNombre());
			this.primer_apellido.setText(this.actual.getApellido1());
			this.segundo_apellido.setText(this.actual.getApellido2());
			this.DNI.setText(this.actual.getDni());
			this.direccion.setText("" + this.actual.getDireccion());
			this.email.setText("" + this.actual.getEmail());
			this.telefono.setText("" + this.actual.getTelefono());
			
			for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
				if (this.actual.getTipologiasexo().getId() == this.jcbSexo.getItemAt(i).getId()) {
					this.jcbSexo.setSelectedIndex(i);
				}
			}
		}

}

	/**
	 * 
	 */
	private void guardar () {
		cargarActualDesdePantalla();
		// Decido si se trata de guardar un registro existente o nuevo
		if (this.actual.getId() != 0) { // Modificación
			if (ControladorEstudiantes.getInstance().guardar(this.actual) == true) {
				JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al guardar");
			}
		}
	}
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.jtfColor.setBackground(color);
		}
	}
	
	/**
	 * 
	 */
	private void cambiarimagen() {
		this.jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selecci�n que se hace en el di�logo
		//this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros
		//this.jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // S�lo selecciona ficheros
		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Selecciona ficheros y carpetas
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de texto *.png";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && f.getAbsolutePath().endsWith(".png"))) 
					return true;
				return false;
			}
		});
		
		// Abro el di�logo para la elecci�n del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = this.jfileChooser.getSelectedFile();
			
			setImagen(leerContenidoFicheroBinario(fichero));
		}
	}
	
	
	private void setImagen(byte imagen[]) {
		this.imagen = imagen;
		ImageIcon icon = new ImageIcon(imagen);
		JLabel lbl = new JLabel(icon);
		scrollPane.setViewportView(lbl);
		scrollPane.revalidate();
		scrollPane.repaint();
	}
	
	
	private byte[] getImagen() {
		return this.imagen;
	}
	
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	private byte[] leerContenidoFicheroBinario (File f) {
		try {
			return Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[] {};
	}

}
