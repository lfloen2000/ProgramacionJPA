package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;
import model.controllers.ControladorEstudiantes;
import model.controllers.ControladorMaterias;
import model.controllers.ControladorProfesores;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JList;



public class PNLvaloraciones extends JPanel {
	
	
	ValoracionMateria actual = new ValoracionMateria();
//	private Profesor profesor;
//	private Materia materia;
	JComboBox<Profesor> jcbProfesor;
	JComboBox<Materia> jcbMateria;
	JComboBox<Integer> jcbNotas;
	List<Estudiante> estudiantes = ControladorEstudiantes.getInstancia().findAll();
	JList jlistestudiantes;
	DefaultListModel<Estudiante> listModelEstudiante = null;

	/**
	 * Create the panel.
	 */
	public PNLvaloraciones() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_Materia = new GridBagConstraints();
		gbc_Materia.insets = new Insets(0, 0, 5, 0);
		gbc_Materia.fill = GridBagConstraints.HORIZONTAL;
		gbc_Materia.gridx = 1;
		gbc_Materia.gridy = 0;
		add(jcbMateria, gbc_Materia);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_Profesor = new GridBagConstraints();
		gbc_Profesor.insets = new Insets(0, 0, 5, 0);
		gbc_Profesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_Profesor.gridx = 1;
		gbc_Profesor.gridy = 1;
		add(jcbProfesor, gbc_Profesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNotas = new JComboBox<Integer>();
		jcbNotas.setModel(new DefaultComboBoxModel(new String[] {"","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 2;
		add(jcbNotas, gbc_comboBox_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{124, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alumnado seleccionado:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane(jlistestudiantes);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList estudiantes = new JList();
//		DefaultListSelectionModel Alumnodes = new DefaultListSelectionModel();
		scrollPane.setViewportView(estudiantes);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNewButton_4 = new JButton("<<");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 0;
		panel_3.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("<");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		panel_3.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton(">");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		panel_3.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton(">>");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		panel_3.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JButton btnNewButton = new JButton("Boton actualizar alumnado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEstudiantes();;
				cargarActualEnPantalla();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);

		
		cargarProfesores();
		
		cargarMaterias();
		
		cargarEstudiantes();
		
		cargarNotas();
		
		cargarActualEnPantalla();
		
		getDefaultListModel();
	}

	
	private DefaultListModel getDefaultListModel () {
		this.listModelEstudiante = new DefaultListModel<Estudiante>();
		return this.listModelEstudiante;
	}
	private void cargarNotas() {
//		for (int i = 0; i < 10;i++)
//		while(i<=10)
//			{this.jcbNotas;};	
//			
//		
	}

	
	private void cargarProfesores() {
		List<Profesor> profesores = ControladorProfesores.getInstancia().findAll();
		
		for (Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
		
	}
	
	private void cargarMaterias() {
		List<Materia> materias = ControladorMaterias.getInstancia().findAll();
		
		for (Materia m : materias) {
			this.jcbMateria.addItem(m);
		}
		
	}
	
	private void cargarEstudiantes() {
		System.out.println("a");
		// Obtengo un listado de estudiantes 
		List<Estudiante> estudiantes = ControladorEstudiantes.getInstancia().findAll();
//		this.listModelEstudiante.addElement(this.estudiantes.get(this.indiceProximaProvinciaParaAgregar));
		for (Estudiante e : estudiantes) {
			this.estudiantes.add(e);}
		System.out.println("b");
		
		// Creo todas las fichas de valoración de cada estudiante
//		this.fichasValoracion.clear();
//		for (Estudiante e : estudiantes) {
//			this.fichasValoracion.add(new FichaValoracionPorEstudiante(profSeleccionado, matSeleccionada, e));
		}
	
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			for (int i = 0; i < this.jcbProfesor.getItemCount(); i++) {
				if (this.actual.getProfesor() != null && this.actual.getProfesor().getId() == this.jcbProfesor.getItemAt(i).getId()) {
					this.jcbProfesor.setSelectedIndex(i);
				}
			}
			for (int i = 0; i < this.jcbMateria.getItemCount(); i++) {
				if (this.actual.getMateria() != null && this.actual.getMateria().getId() == this.jcbMateria.getItemAt(i).getId()) {
					this.jcbMateria.setSelectedIndex(i);
				}
			}
			
			for (int i = 0; i < this.estudiantes.size(); i++) {
				this.actual.getEstudiante();
				this.listModelEstudiante = new DefaultListModel<Estudiante>();
				
			}
			
			
//			for (int i = 0; i < this.jcbNotas.getItemCount(); i++) {
//				if (this.actual.getValoracion() != null && this.actual.getValoracion().getId() == this.jcbNotas.getItemAt(i).getId()) {
//					this.jcbNotas.setSelectedIndex(i);
//				}
//			}
			
		}
	}
	

}
