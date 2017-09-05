package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Indicadores extends JFrame {

	private JPanel contentPane;
	private JList list_1;
	private JList list;
	private JLabel lblEmpresas;
	private JLabel lblPeriodos;
	private JLabel lblResultadoDeAplicar;
	private JLabel lblAplicarElSiguiente;
	private JLabel lblNuevoIndicador;
	private JList list_3;
	private JButton btnAplicarIndicador;
	private JButton btnCrearNuevoIndicador;
	private JList list_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Indicadores frame = new Indicadores();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Indicadores() 
	{
		initComponentes();
		createEvents();
	}
	private void initComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		list = new JList();
		
		list_1 = new JList();
		
		list_2 = new JList();
		
		lblEmpresas = new JLabel("Empresas:");
		
		lblPeriodos = new JLabel("Periodos:");
		
		lblResultadoDeAplicar = new JLabel("<html>Resultado de <br>aplicar indicador:</htlm>");
		
		btnCrearNuevoIndicador = new JButton("Guardar nuevo indicador");
		
		
		lblNuevoIndicador = new JLabel("<html>Indicador a guardar: <br><b>NombreIndicador=expresion</b>, tal que: <br>expresion incluye indicadores y/o cuentas</html>");
		
		lblAplicarElSiguiente = new JLabel("<html>Seleccionar Empresa, periodo e indicador<br>presionar el botón \"Aplicar indicador\"<br>Aplicar el siguiente indicador</html>");
		
		JList list_4 = new JList();
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		
		list_3 = new JList();
		
		btnAplicarIndicador = new JButton("Aplicar indicador");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmpresas))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeriodos))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblResultadoDeAplicar)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAplicarIndicador, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
								.addComponent(list_3, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
								.addComponent(lblAplicarElSiguiente, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(list_4, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNuevoIndicador, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(btnCrearNuevoIndicador, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
					.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblResultadoDeAplicar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblEmpresas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPeriodos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addComponent(list_2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblAplicarElSiguiente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNuevoIndicador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(list_4)
							.addComponent(list_3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAplicarIndicador)
						.addComponent(btnCrearNuevoIndicador))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	private void createEvents() {
		btnCrearNuevoIndicador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}

	
	
}
