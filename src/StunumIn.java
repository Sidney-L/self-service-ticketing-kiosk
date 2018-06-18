import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * This is the frame to get the student ID number 
 * @author Fun
 *
 */
public class StunumIn extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private String[] tickettime;
	private int ticketnumber;
	private String moviename;
	private String screen;
	private String choosetime;
	private String tickettype;
	private String totalprice;
	private String seat;
	private String stunum;
	private JButton btnConfirm;
	private JButton btnBack;
	/**
	 * Create the frame.
	 */
	public StunumIn(String moviename,String screen, String[] tickettime,String choosetime,String tickettype,int ticketnumber,String seat,String totalprice,String stunum) {
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.seat=seat;
		this.stunum=stunum;
		this.totalprice=totalprice;
		this.moviename=moviename;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblP = new JLabel("Please input your student number\uFF087 digit\uFF09, seperate with ;");
		lblP.setHorizontalAlignment(SwingConstants.CENTER);
		lblP.setBounds(41, 13, 643, 40);
		contentPane.add(lblP);
		
		textField = new JTextField();
		textField.setBounds(51, 66, 633, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(14, 304, 113, 27);
		contentPane.add(btnBack);
		
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(this);
		btnConfirm.setBounds(617, 304, 113, 27);
		contentPane.add(btnConfirm);
	}
	
	
	public void actionPerformed(ActionEvent e){
		JButton jb=(JButton)e.getSource();
		if(jb==btnConfirm){
			stunum=textField.getText();
			if(!isValidlist(textField.getText())){
				Dialog dg=new Dialog("Incorrect student ID number!");
				dg.setLocationRelativeTo(null);
				dg.setVisible(true);
				return;
			}
			else{
				Final frame=new Final(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,totalprice,stunum);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		}
		else if(jb==btnBack){
			dispose();
			confirmPayment cp=new confirmPayment(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
			cp.setLocationRelativeTo(null);
			cp.setVisible(true);
		}
	}
	
	/**
	 * The function will check whether the input string is valid list of student number 
	 * @param list
	 * @return true or false
	 */
	
	public boolean isValidlist(String list){
		boolean isvalid=true;
		String[] splitlist=list.split(";");
		for(int i=0;i<splitlist.length;i++){
			isvalid=isValidString(splitlist[i]);
		}
		if(splitlist.length!=ticketnumber){
			isvalid=false;
		}
		return isvalid;
	}
	
	/**
	 * This function will check whether the input string is valid Student number 
	 * @param s input string 
	 * @return true or false
	 */
	
	
	public boolean isValidString(String s){
		for(int i=0;i<s.length();i++){
		if(!Character.isDigit(s.charAt(i))){
			return false;
			}
		}
		return true;
	}
	
}
