package gui;

import java.awt.BorderLayout;
//import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class Principal extends JFrame {

private JTabbedPane jTabbedPane = null;
	
	private static Principal instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static Principal getInstance () {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public Principal() {
		super("Gestión de centro educativo");
		this.setBounds(0, 0, 600, 400);
		
//		this.setJMenuBar(new MenuBar());
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		
		jTabbedPane.add("Estudiantes", new PNLestudiantes());
		jTabbedPane.add("Profesores", new PNLtalerdo());
//		jTabbedPane.add("JScroolPane con imagen", new PaneForJScroolPane());
//		jTabbedPane.add("Coches", new PanelCoches());
//		jTabbedPane.add("Clientes", new PanelClientes());
//		jTabbedPane.add("Concesionarios", new PanelConcesionarios());
//		jTabbedPane.add("Ventas", new PanelVentas());
		
		
		return jTabbedPane;
	}
	
	
	
	
	
	/**
	 * @return the jTabbedPane
	 */
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
	}


}
