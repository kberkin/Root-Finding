package find_root;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField txtRoot1;
	private JTextField txtRoot2;
	private JTextField textField_1;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtP;
	private JTextField txtR;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	double x;	// I added these 8 lines to take and create the equation from the user. 
	double eq;
	double deriv;
	static int a;
	static int b;
	static int c;
	static int p;
	static int r;
	static double F(double x) {	// I created a function to use in Secant and Newton Raphson methods.
		return (a*Math.pow(x, p))+(b*Math.pow(x, r))+c;
	}
	static double deriv(double x) { // I created derivative function to use in Newton Raphson Method.
	return ((a*p)*Math.pow(x, p-1))+((b*r)*Math.pow(x, r-1));
	}
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 459, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMethod = new JLabel("Method");
		lblMethod.setBounds(20, 82, 59, 14);
		panel.add(lblMethod);
		
		JLabel lblRoot1 = new JLabel("Root 1 :");
		lblRoot1.setBounds(20, 181, 46, 14);
		panel.add(lblRoot1);
		lblRoot1.setVisible(false);
		
		txtRoot1 = new JTextField();
		txtRoot1.setBounds(85, 178, 65, 20);
		panel.add(txtRoot1);
		txtRoot1.setColumns(10);
		txtRoot1.setVisible(false);
		
		JLabel lblRoot2 = new JLabel("Root 2 :");
		lblRoot2.setBounds(20, 212, 46, 14);
		panel.add(lblRoot2);
		lblRoot2.setVisible(false);
		
		txtRoot2 = new JTextField();
		txtRoot2.setBounds(85, 209, 65, 20);
		panel.add(txtRoot2);
		txtRoot2.setColumns(10);
		txtRoot2.setVisible(false);
		
		JLabel lblX0 = new JLabel("X0 :");
		lblX0.setBounds(20, 181, 46, 14);
		panel.add(lblX0);
		lblX0.setVisible(false);
		
		JLabel lblX1 = new JLabel("X1 :");
		lblX1.setBounds(20, 212, 46, 14);
		panel.add(lblX1);
		lblX1.setVisible(false);
		
		JTextPane textPane1 = new JTextPane();
		textPane1.setBounds(313, 92, 78, 20);
		panel.add(textPane1);
		
		JTextPane textPane2 = new JTextPane();
		textPane2.setBounds(313, 123, 78, 19);
		panel.add(textPane2);
		
		txtA = new JTextField();
		txtA.setBounds(17, 35, 40, 20);
		panel.add(txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setBounds(65, 35, 45, 20);
		panel.add(txtB);
		txtB.setColumns(10);
		
		txtC = new JTextField();
		txtC.setBounds(120, 35, 45, 20);
		panel.add(txtC);
		txtC.setColumns(10);
		
		txtP = new JTextField();
		txtP.setBounds(176, 35, 45, 20);
		panel.add(txtP);
		txtP.setColumns(10);
		
		txtR = new JTextField();
		txtR.setBounds(229, 35, 45, 20);
		panel.add(txtR);
		txtR.setColumns(10);
		
		JTextPane txtPane3 = new JTextPane();
		txtPane3.setBounds(319, 35, 130, 20);
		panel.add(txtPane3);
		txtPane3.setVisible(false);
		
		JLabel lblEquation = new JLabel("Equation :");
		lblEquation.setBounds(321, 10, 59, 14);
		panel.add(lblEquation);
		lblEquation.setVisible(false);
		
		
		JCheckBox chckbx1 = new JCheckBox("Bisection");	// I added this checkbox for Bisection Method.
		chckbx1.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx1.isSelected()) {	// When user selects this checkbox, textfields for root 1 and 2 become visible.
				lblRoot1.setVisible(true);
				txtRoot1.setVisible(true);
				lblRoot2.setVisible(true);
				txtRoot2.setVisible(true);
				}
				else {
					lblRoot1.setVisible(false);
					txtRoot1.setVisible(false);
					lblRoot2.setVisible(false);
					txtRoot2.setVisible(false);
				}
			}});
		chckbx1.setBounds(85, 78, 97, 23);
		panel.add(chckbx1);
		
		
		JCheckBox chckbx2 = new JCheckBox("Newton Raphson"); // I added this checkbox for Newton Raphson Method.
		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx2.isSelected()) {// When user selects this checkbox, textfield for root 1 become visible.
					lblRoot1.setVisible(true);
					txtRoot1.setVisible(true);
				}
				else {
					lblRoot1.setVisible(false);
					txtRoot1.setVisible(false);
				}
			}
		});
		chckbx2.setBounds(85, 104, 121, 23);
		panel.add(chckbx2);
		
		JCheckBox chckbx3 = new JCheckBox("Secant"); // I added this checkbox for Secant Method.
		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx3.isSelected()) {// When user selects this checkbox, textfields for root 1 and 2 become visible.
					lblX0.setVisible(true);
					lblX1.setVisible(true);
					txtRoot1.setVisible(true);
					txtRoot2.setVisible(true);
				}
				else {
					lblX0.setVisible(false);
					lblX1.setVisible(false);
					txtRoot1.setVisible(false);
					txtRoot2.setVisible(false);
				}
				
			}
		});
		chckbx3.setBounds(85, 130, 97, 23);
		panel.add(chckbx3);
		
		
		JButton btnSave = new JButton("Save");	// When user clicks this button, the program calculates and shows the results.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx1.isSelected()) {
					int a,b,c,p,r;
					double eq;
					double x;
					int root1,root2;
					String root11,root22;
					
					root11=txtRoot1.getText();	// Takes the root 1 from the user.
					root1=Integer.parseInt(root11);
					root22=txtRoot2.getText();	// Takes the root 2 from the user.
					root2=Integer.parseInt(root22);
					
					a=Integer.parseInt(txtA.getText()); // I converted strings to integer type.
					b=Integer.parseInt(txtB.getText());
					c=Integer.parseInt(txtC.getText());
					p=Integer.parseInt(txtP.getText());
					r=Integer.parseInt(txtR.getText());
					lblEquation.setVisible(true);
					txtPane3.setVisible(true);
					
					txtPane3.setText(a+"x^"+p+" + "+b+"x^"+r+" + "+c); // I added this textpane to show the equation.
					
					x=root1;	// I used root1 value to find f(root1).
					eq=(a*Math.pow(x, p))+(b*Math.pow(x, r))+c;
					int eq1=(int) eq;
					textPane1.setText("f("+root1+") = "+eq1); 
					x=root2;	// I used root2 value to find f(root2).
					eq=(a*Math.pow(x, p))+(b*Math.pow(x, r))+c;
					int eq2=(int) eq;
					textPane2.setText("f("+root2+") = "+eq2);
					
					Double rot1= new Double(root1);
					Double rot2= new Double(root2);
					
					double m=0,ym,yroot1;
					double error = 0;
					
					if(eq1*eq2<0) { // It checks the result of (eq1*eq2), result must be negative.
					while(rot2-rot1>0.0001) {
						{	m=(rot1+rot2)/2.0;	//m is midpoint and it takes a new value.
						
						ym=(a*Math.pow(m, p))+(b*Math.pow(m, r))+c;

						yroot1=(a*Math.pow(rot1, p))+(b*Math.pow(rot1, r))+c;
						
						if((ym>0 && yroot1<0) || (ym<0 && yroot1>0)) {
							rot2=m;
						}	else
						{
							rot1=m;
						}
					}
						{	
						error=Math.abs((rot2-rot1)/rot1)*100;	//Absolute error calculating until while loop close.
				}
				}
					JOptionPane.showMessageDialog(null, "Approximate Solution : "+(rot1+rot2)/2+
							"\nAbsolute Error : "+error); //This JOptionPane shows the last root and error.
					}
					else
						JOptionPane.showMessageDialog(null, "There is no real root!!!!");
				}			//This JOptionPane gives a warning.
				else	if(chckbx2.isSelected()) {
					double root1;
					double root = 0,error = 0,given;
					boolean flag=true;
					
					String root11;
					root11=txtRoot1.getText();	// Takes the root 1 from the user.
					root1=Integer.parseInt(root11);
					
					a=Integer.parseInt(txtA.getText());	// I converted strings to integer type.
					b=Integer.parseInt(txtB.getText());
					c=Integer.parseInt(txtC.getText());
					p=Integer.parseInt(txtP.getText());
					r=Integer.parseInt(txtR.getText());
					
					lblEquation.setVisible(true);
					txtPane3.setVisible(true);
					
					txtPane3.setText(a+"x^"+p+" + "+b+"x^"+r+" + "+c); // I added this textpane to show the equation.
					
					given=root1;
					
					while(flag) {
						root=root1-(F(root1)/deriv(root1)); 
						
						error=Math.abs((root-root1)/root)*100;

						root1=root; // root takes the value of root1.
						
						if(given>error) {
							flag=false;
						}
					} JOptionPane.showMessageDialog(null, "Approximate Solution : "+root+
							"\nAbsolute Error : "+error);	//This JOptionPane shows the last root and error.
					
				}
				else 	if(chckbx3.isSelected()) {
					boolean flag=true;
					double x0,x1,root = 0,error = 0,given=5;
					String x00,x11;
					
					x00=txtRoot1.getText(); // Takes the x0 from the user.
					x0=Integer.parseInt(x00);
					x11=txtRoot2.getText(); // Takes the x1 from the user.
					x1=Integer.parseInt(x11);
					
					a=Integer.parseInt(txtA.getText()); // I converted strings to integer type.
					b=Integer.parseInt(txtB.getText());
					c=Integer.parseInt(txtC.getText());
					p=Integer.parseInt(txtP.getText());
					r=Integer.parseInt(txtR.getText());
					lblEquation.setVisible(true);
					txtPane3.setVisible(true);
					
					txtPane3.setText(a+"x^"+p+" + "+b+"x^"+r+" + "+c); // I added this textpane to show the equation.
					
					while(flag) {
						root=x0-((F(x0)*(x0-x1))/(F(x0)-F(x1))); // Calculates the x2(root).
						error=Math.abs((root-x0)/root)*100; // Calculates the absolute error.
						
						x1=x0; // x1 takes value of x0.
						x0=root;  // x0 take value of root.
						
						if(given>error) {
							flag=false;
						}
					}
					JOptionPane.showMessageDialog(null, "Approximate Solution : "+root+
							"\nAbsolute Error : "+error);	//This JOptionPane shows the last root and error.
				}
			}
		});
		btnSave.setBounds(82, 257, 89, 23);
		panel.add(btnSave);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(32, 10, 25, 15);
		panel.add(lblA);
		
		JLabel lblB = new JLabel("b");
		lblB.setBounds(85, 11, 25, 15);
		panel.add(lblB);
		
		JLabel lblC = new JLabel("c");
		lblC.setBounds(140, 10, 25, 15);
		panel.add(lblC);
		
		JLabel lblExampleEquation = new JLabel("Example Equation: 2x^4 + 3x^2 + 1");
		lblExampleEquation.setBounds(245, 278, 204, 14);
		panel.add(lblExampleEquation);
		
		JLabel lblaBC = new JLabel(" (a=2, b=3, c=1, p=^4, r=^2)");
		lblaBC.setBounds(258, 297, 163, 14);
		panel.add(lblaBC);
		
		JLabel lblP = new JLabel("p");
		lblP.setBounds(192, 10, 25, 15);
		panel.add(lblP);
		
		JLabel lblR = new JLabel("r");
		lblR.setBounds(242, 10, 25, 15);
		panel.add(lblR);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	// Exits from the program.
			}
		});
		btnExit.setBounds(362, 241, 59, 23);
		panel.add(btnExit);
		
	}
}