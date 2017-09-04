package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import repositorios.*;
import tipos.*;
import javax.swing.ListSelectionModel;

public class Empresas extends JFrame {

	private JPanel ctpMain;
	private static JList lstEmpresas;
	private static JList lstCuentas;
	private static JList lstPeriodos;
	private static List<Empresa> empresas ;
	private static List <Cuenta> cuentas ;
	private static List <Periodo> periodos ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					Empresas frame = new Empresas();
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
	public Empresas() 
	{
		setTitle("Información sobre valores de cuentas");
		initComponents();
		createEvents();
	}
	//////////////////////////////////////////////////////////////////////
	// This method contains all the code for creating and
	// initializing components
	//////////////////////////////////////////////////////////////////////
	private void initComponents() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 453);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		empresas = TestSerializingAndDeserializing.getEmpresas();
		lstEmpresas = new JList(listModel);
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.empresas.forEach(e -> listModel.addElement(e.getNombre()));
		lstEmpresas.setSelectedIndex(0);
		
		lstCuentas = new JList();
		lstCuentas.setSelectedIndex(0);
		lstCuentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lstPeriodos = new JList();
		lstPeriodos.setSelectedIndex(0);
		lstPeriodos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(lstEmpresas, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(lstCuentas, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(lstPeriodos, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(lblEmpresa)
							.addGap(212)
							.addComponent(lblCuenta, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(210)
							.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmpresa)
						.addComponent(lblCuenta, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lstEmpresas, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addComponent(lstCuentas, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
						.addComponent(lstPeriodos, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
					.addGap(78))
		);
		ctpMain.setLayout(gl_ctpMain);
	}
	//////////////////////////////////////////////////////////////////////
	//This method contains all the code for creating events
	//////////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		
		
		lstEmpresas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				lstCuentas.setModel(listModel);
				int empresa = lstEmpresas.getSelectedIndex();
				cuentas = empresas.get(empresa).getCuentas();
				cuentas.forEach(a -> listModel.addElement(a.getNombre()));
			}
		});
		
		lstCuentas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				lstPeriodos.setModel(listModel);
				int cuenta = lstCuentas.getSelectedIndex();
				if ( cuenta >= 0)
				{
					periodos = cuentas.get(cuenta).getPeriodos();
					periodos.forEach(c -> listModel.addElement(c.toString()));
				}
			}
		});
		
		lstPeriodos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int periodo = lstPeriodos.getSelectedIndex();
				if (periodo >= 0) {
					int cotizacion = periodos.get(periodo).getCotizacion();
					JOptionPane.showMessageDialog(null, "La cotización fue de $"+cotizacion);
				}
			}
		});
		
	}
}
