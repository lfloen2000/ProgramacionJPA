package gui;

import java.awt.BorderLayout;
//import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class Principal extends JFrame {

private JTabbedPane jTabbedPane = null;
	
	private static Principal instance = null;
	
	{
		try {
			// Look and Feel Windows - S�lo en entornos Windows
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} 
	}
	
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
		super("Gestión de venta de coches");
		this.setBounds(0, 0, 600, 400);
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * 
	 * @return
	 */
	private JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		
		jTabbedPane.add("Estudiantes", new PNLestudiantes());
		jTabbedPane.add("Valoración de estudiantes", new PNLvaloraciones());
		
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
