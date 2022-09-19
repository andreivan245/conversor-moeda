package br.com.andre.ConversorMoeda;
import java.awt.EventQueue;



public class Main {
	
	
	
	public static void main(String[] args) {
		
		
		//TRY CATCH PARA A CAPTURA DE EXCEÇÃO DA INTERFACE GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI painelMoeda = new PrincipalGUI();
					painelMoeda.frmConversorDeMoeda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
}
