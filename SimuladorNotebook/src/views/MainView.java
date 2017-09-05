package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel ctpMain;
	private JButton btnEmpresasWindow;
	private JButton btnIndicadoresWindow;
	private JButton btnMetodologiasWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainView frame = new MainView();
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
	public MainView() 
	{
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		btnEmpresasWindow = new JButton("Empresas");
		
		btnIndicadoresWindow = new JButton("Indicadores");
		
		
		btnMetodologiasWindow = new JButton("Metodolog�as");
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_ctpMain.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnMetodologiasWindow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(btnEmpresasWindow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(btnIndicadoresWindow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
					.addGap(69))
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addComponent(btnEmpresasWindow, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnIndicadoresWindow, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMetodologiasWindow, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		ctpMain.setLayout(gl_ctpMain);
	}

	private void createEvents() {
		
		btnEmpresasWindow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Empresas empresa = new Empresas();
				empresa.setVisible(true);
			}
		});
		
		btnIndicadoresWindow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Indicadores indicador = new Indicadores();
				indicador.setVisible(true);
			}
		});
		
		btnMetodologiasWindow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Metodologias metodologia = new Metodologias();
				metodologia.setVisible(true);
			}
		});
		
	}
}
