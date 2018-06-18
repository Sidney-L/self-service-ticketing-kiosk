import java.awt.BorderLayout;
import java.util.*; 
import java.text.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**This is the Select frame, the user can select the movie show time, ticket type, and ticket number in this frame
 * 
 * @author Fan
 *
 */
public class Select extends JFrame implements ActionListener{

	private JPanel contentPane;
	private String[] tickettime;
	private int ticketnumber;
	private String tickettype;
	private String moviename;
	private String screen;
	private String choosetime;
	private String seat;
	private JButton button;
	private JButton btnBack;
	private String stunum;
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	JComboBox<String> comboBox_2;

	public Select(String moviename,String screen,String[] tickettime,String choosetime,String tickettype,int ticketnumber,String seat,String stunum) {
		this.moviename=moviename;
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.stunum=stunum;
		this.seat=seat;
		setTitle("Buy Ticket");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Show Time");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 62, 119, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblTicketType = new JLabel("Ticket Type");
		lblTicketType.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicketType.setBounds(321, 62, 88, 50);
		contentPane.add(lblTicketType);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setBounds(446, 62, 53, 50);
		contentPane.add(lblNumber);
		
		comboBox = new JComboBox<String>();
		for(int i=0;i<tickettime.length;i++){
			if(!tickettime[i].equals("null"))
			comboBox.addItem(tickettime[i]);
		}
		
		comboBox.setBounds(91, 142, 137, 24);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("Child");
		comboBox_1.addItem("Adult");
		comboBox_1.addItem("Senior");
		comboBox_1.addItem("Student");
		comboBox_1.setBounds(320, 142, 81, 24);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		for(int i=1;i<11;i++){
			comboBox_2.addItem(String.valueOf(i));
		}
		comboBox_2.setBounds(436, 142, 76, 24);
		contentPane.add(comboBox_2);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(14, 333, 113, 27);
		contentPane.add(btnBack);
		
		button= new JButton("Confirm");
		button.addActionListener(this);
		button.setBounds(399, 333, 113, 27);
		contentPane.add(button);
	}
	public void actionPerformed(ActionEvent e) {
		JButton jb=(JButton) e.getSource();
		if(jb==button){
		choosetime=comboBox.getSelectedItem().toString();
		tickettype=comboBox_1.getSelectedItem().toString();
		ticketnumber=Integer.valueOf(comboBox_2.getSelectedItem().toString());
		if(whetherPassTime(choosetime)){
			Dialog a=new Dialog("The time you selected have paseed!Please choose another time");
			a.setLocationRelativeTo(null);
			a.setVisible(true);
			return;
		}
		else{
		dispose();
		screen=getRightScreen(choosetime,moviename);
		SelectConfirm frame=new SelectConfirm(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
		}
		else if(jb==btnBack){
		dispose();
		ChooseFilm frame2=new ChooseFilm(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
		}
	}
	
	/**
	 * This is the function to get the screen information from the choose time, if user 
	 * choose a particular movie time, the function will find out the in which screen(1,2 or 3) it is showed
	 * @param choosetime the time the user choose 
	 * @param moviename	the name of movie
	 * @return the screen(1,2 or 3)
	 */
	
	public String getRightScreen(String choosetime, String moviename){
		String screen="";
		switch(moviename){
		case "beauty and the beast":
			if(choosetime.equals("10:00")||choosetime.equals("12:30"))
				screen="screen1";
			if(choosetime.equals("10:30")||choosetime.equals("13:30"))
				screen="screen3";
		break;
		case "logan":
			screen="screen3";
		break;
		case "kong: skull island":
			if(choosetime.equals("15:30")||choosetime.equals("18:30")||choosetime.equals("21:00"))
				screen="screen1";
			if(choosetime.equals("20:00"))
				screen="screen2";
			if(choosetime.equals("20:30"))
				screen="screen3";
		break;
		case "moonlight":
			screen="screen2";
		break;
		case "la la land":
			screen="screen2";
		break;
		}
		return screen;
	}

		public boolean whetherPassTime(String choosetime){
		Calendar ca=Calendar.getInstance();
		int systemhour=Integer.valueOf(ca.getTime().toString().split(" ")[3].split(":")[0]);
		int systemminute=Integer.valueOf(ca.getTime().toString().split(" ")[3].split(":")[1]);
		String[] list=choosetime.split(":");
		int choosehour=Integer.valueOf(list[0]);
		int chooseminute=Integer.valueOf(list[1]);
		/*System.out.println(systemhour+"@"+systemminute+"@"+choosehour+"@"+chooseminute);*/
		if(systemhour>choosehour){
			return true;
		}
		else if(systemhour==choosehour){
			if(systemminute>chooseminute){
				return true;
			}
			else return false;
		}
		else{
		return false;
		}
	}

}
