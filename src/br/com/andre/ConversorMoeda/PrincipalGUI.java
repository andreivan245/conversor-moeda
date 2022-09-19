package br.com.andre.ConversorMoeda;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PrincipalGUI {

	public JFrame frmConversorDeMoeda;
	public JTextField textField;

	
	 
	public PrincipalGUI() throws ParseException {
		initialize();
	}

	//INICIALIZA O PAINEL
	public void initialize() throws ParseException {
		frmConversorDeMoeda = new JFrame();
		frmConversorDeMoeda.setTitle("Conversor de Moeda");
		frmConversorDeMoeda.setBounds(100, 100, 302, 377);
		frmConversorDeMoeda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMoeda.getContentPane().setLayout(null);
		frmConversorDeMoeda.setLocationRelativeTo(null);
		
		
		String[] moedas_principais = { "USD","BRL","EUR"};
		
		String[] moedas_secundarias = { "USD","BRL","EUR","JPY","CNY","GBP","AUD","CHF","CAD","ARS","TRY","CLP","AOA","VEF","CUP"};
		
		JComboBox<?> comboBox = new JComboBox<Object>(moedas_principais);
		comboBox.setToolTipText("");
		comboBox.setBounds(10, 58, 266, 22);
		frmConversorDeMoeda.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Moeda escolhida:");
		lblNewLabel.setBounds(10, 36, 102, 14);
		frmConversorDeMoeda.getContentPane().add(lblNewLabel);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>(moedas_secundarias);
		comboBox_1.setBounds(10, 131, 266, 22);
		frmConversorDeMoeda.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Converter para:");
		lblNewLabel_1.setBounds(10, 112, 102, 14);
		frmConversorDeMoeda.getContentPane().add(lblNewLabel_1);
	
			
		JFormattedTextField field = new JFormattedTextField();
		
		//VERIFICA SE O CAMPO DE TEXTO VALOR ESTA RECEBENDO LETRA, SE SIM ELA NAO ACEITA O VALOR POREM QUALQUER OUTRO VALOR É ACEITO COM POR EXEMPLO PONTUAÇÕES EM GERAL
		field.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				
			    char c=e.getKeyChar();
		        if(Character.isLetter(c)&&!e.isAltDown()){
		            e.consume();
		        }
			}
		});
		
		
	    field.setBounds(10, 198, 266, 20);
	    frmConversorDeMoeda.getContentPane().add(field);
	    field.setColumns(10);
	    
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setBounds(10, 178, 46, 14);
		frmConversorDeMoeda.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.setBounds(85, 265, 99, 23);
		
		
		//EVENTO PARA O CLICK NO BOTAO CONVERTE
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	//ARMAZENA VALORES DOS INPUTS
		    	String PrimeiraMoeda = comboBox.getSelectedItem().toString();
		    	String SegundaMoeda = comboBox_1.getSelectedItem().toString();
		    	String ValorString = field.getText();
		    	String NovaValorString = ValorString.replace(",", ".");
		    	//CONVERTE PARA VALOR PARA DOUBLE
		    	
		    	
		    	//CAPTURA A EXCECAO DE NUMBERFORMAT
		    	try{
		    		double Valor = Double.parseDouble(NovaValorString);
		    		//CHAMA O CONSUMIRAPI
			    	ConsumirAPI resultadoAPI = new ConsumirAPI();
					resultadoAPI.ChamaAPI(PrimeiraMoeda, SegundaMoeda, Valor);
			    	System.exit(0);
		    	}catch (NumberFormatException ex) {
		    		
		    		JOptionPane.showMessageDialog(null, "Você digitou algum caracter inválido, digite apenas números separados por apenas um '.' (Ponto) ou ',' (Vírgula). ","CARACTER DIGITADO INVÁLIDO!!", JOptionPane.ERROR_MESSAGE);
		        }
		    	
		    	
		    	
;		        
		    }
		});
		
		frmConversorDeMoeda.getContentPane().add(btnNewButton);
	}
}
