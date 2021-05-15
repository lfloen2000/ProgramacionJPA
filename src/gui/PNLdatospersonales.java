package gui;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.Tipologiasexo;
import model.controllers.ControladorTiopologiassexo;

public class PNLdatospersonales  extends JPanel{
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDNI;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	JComboBox<Tipologiasexo> jcbSexo;
	JScrollPane scrollPane;
	private byte[] imagen = null;
	JFileChooser jfileChooser = new JFileChooser();
	private JLabel lblNewLabel_7;
	private JTextField jtfColorPreferido;
	private JButton btnColor;
	JColorChooser jColorChooser;
	String colorPreferido;
	

	/**
	 * Create the panel.
	 */
	public PNLdatospersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.5, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellido 1:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 0;
		gbc_lblApellidos.gridy = 1;
		add(lblApellidos, gbc_lblApellidos);
		
		jtfApellido1 = new JTextField();
		jtfApellido1.setColumns(10);
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 1;
		add(jtfApellido1, gbc_jtfApellido1);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido 2:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 2;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfDNI = new JTextField();
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 3;
		add(jtfDNI, gbc_jtfDNI);
		jtfDNI.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 4;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jcbSexo = new JComboBox<>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 4;
		add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblNewLabel_3 = new JLabel("Dirección:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JButton btnCambiaImagen = new JButton("Cambiar imagen");
		btnCambiaImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnCambiaImagen = new GridBagConstraints();
		gbc_btnCambiaImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiaImagen.gridx = 2;
		gbc_btnCambiaImagen.gridy = 6;
		add(btnCambiaImagen, gbc_btnCambiaImagen);
		
		JLabel lblNewLabel_5 = new JLabel("Teléfono:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		lblNewLabel_7 = new JLabel("Color preferido:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfColorPreferido = new JTextField();
		GridBagConstraints gbc_jtfColorPreferido = new GridBagConstraints();
		gbc_jtfColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColorPreferido.gridx = 1;
		gbc_jtfColorPreferido.gridy = 8;
		add(jtfColorPreferido, gbc_jtfColorPreferido);
		jtfColorPreferido.setColumns(10);
		
		btnColor = new JButton("Cambiar color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 2;
		gbc_btnColor.gridy = 8;
		add(btnColor, gbc_btnColor);

		// Cargamos datos de Tipologías de sexo: Hombre, Mujer, otro
		List<Tipologiasexo> tiposSexo = ControladorTiopologiassexo.getInstance().findAll();
		for (Tipologiasexo t : tiposSexo) {
			this.jcbSexo.addItem(t);
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.jtfNombre.getText();
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.jtfNombre.setText(nombre);;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidoPrimero() {
		return this.jtfApellido1.getText();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidoPrimero(String apellidos) {
		this.jtfApellido1.setText(apellidos);
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidoSegundo() {
		return this.jtfApellido2.getText();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidoSegundo(String apellidos) {
		this.jtfApellido2.setText(apellidos);
	}

	/**
	 * @return the apellidos
	 */
	public String getDni() {
		return this.jtfDNI.getText();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setDNI(String dni) {
		this.jtfDNI.setText(dni);
	}

	/**
	 * @return the apellidos
	 */
	public String getDireccion() {
		return this.jtfDireccion.getText();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setDireccion(String direccion) {
		this.jtfDireccion.setText(direccion);
	}

	/**
	 * @return the apellidos
	 */
	public String getEmail() {
		return this.jtfEmail.getText();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setEmail(String email) {
		this.jtfEmail.setText(email);
	}

	/**
	 * @return the apellidos
	 */
	public String getTelefono() {
		return this.jtfTelefono.getText();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setTelefono(String telefono) {
		this.jtfTelefono.setText(telefono);
	}

	/**
	 * @return the apellidos
	 */
	public Tipologiasexo getTipologiaSexo() {
		return (Tipologiasexo) this.jcbSexo.getSelectedItem();
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setTipologiaSexo(Tipologiasexo tipoSexo) {
		for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
			if (tipoSexo != null && this.jcbSexo.getItemAt(i).getId() == tipoSexo.getId()) {
				this.jcbSexo.setSelectedIndex(i);
			}
		}
	}

	/**
	 * @return the apellidos
	 */
	public byte[] getImagen() {
		return this.imagen;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
		JLabel lbl;
		if (imagen != null && imagen.length > 0) {
			ImageIcon img = new ImageIcon(imagen);
			lbl = new JLabel(img);
		}
		else {
			lbl = new JLabel();
		}
		this.scrollPane.setViewportView(lbl);
	}

	
	/**
	 * 
	 */
	private void seleccionaImagen() {
		this.jfileChooser = new JFileChooser();
		
		// Configurando el componente		
		// Tipo de selección que se hace en el di�logo
		//this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Selecciona ficheros y carpetas
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().endsWith(".jpg") || (f.getAbsolutePath().endsWith(".png"))))) 
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
	
	
	
	/**
	 * 
	 * @return
	 */
	public String getColorPreferido () {
		return this.colorPreferido;
	}
	
	/**
	 * 
	 * @param color
	 */
	public void setColorPreferido (String color) {
		if (color != null) {
			this.colorPreferido = color;
			this.setBackground(Color.decode(this.colorPreferido));
		}
		else {
			this.colorPreferido = null;
			this.setBackground(Color.LIGHT_GRAY);
		}
	}
	
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color colorInicial = (this.colorPreferido != null)? Color.decode(this.colorPreferido) : Color.LIGHT_GRAY;
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", colorInicial);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			setColorPreferido(strColor);
			this.jtfColorPreferido.setText(strColor);
		}
	}

}
