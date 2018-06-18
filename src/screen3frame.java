import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


/**This is the frame of screen3, the user can choose seats in this frame
 * 
 * @author Fan
 *
 */

public class screen3frame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private String[] tickettime;
	private int ticketnumber;
	private String moviename;
	private String screen;
	private String choosetime;
	private String tickettype;
	private String stunum;
	private String seat;
	private JButton btnBack;
	private JButton btnChoose;
	private JButton btnReset;
	private ArrayList<JButton> selectedbutton=new ArrayList<>();
	private JButton [][]buttongroup=new JButton[5][];
	
	
	public screen3frame(String moviename,String screen, String[] tickettime, String choosetime,String tickettype, int ticketnumber, String seat,String stunum) {
		this.moviename=moviename;
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.stunum=stunum;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.seat=seat;
		setTitle("Screen3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 13, 722, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		buttongroup[0]=new JButton[8];
		buttongroup[1]=new JButton[8];
		buttongroup[2]=new JButton[8];
		buttongroup[3]=new JButton[8];
		buttongroup[4]=new JButton[8];
		
		buttongroup[4][7] = new JButton("8");
		buttongroup[4][7].setBounds(28, 35, 50, 27);
		panel.add(buttongroup[4][7]);
		
		
		buttongroup[3][7] = new JButton("8");
		buttongroup[3][7].setBounds(28, 13, 50, 27);
		/*panel.add(buttongroup[3][7]);*/
		
		buttongroup[2][7] = new JButton("8");
		buttongroup[2][7].setBounds(28, 69, 50, 27);
		/*panel.add(buttongroup[2][7]);*/
		
		buttongroup[1][7] = new JButton("8");
		buttongroup[1][7].setBounds(28, 127, 50, 27);
		/*panel.add(buttongroup[1][7]);*/
		
		buttongroup[0][7] = new JButton("8");
		buttongroup[0][7].setBounds(28, 189, 50, 27);
		/*panel.add(buttongroup[0][7]);*/
		
		buttongroup[4][6] = new JButton("7");
		buttongroup[4][6].setBounds(115, 35, 50, 27);
		panel.add(buttongroup[4][6]);
		
		buttongroup[3][6] = new JButton("7");
		buttongroup[3][6].setBounds(107, 13, 50, 27);
		/*panel.add(buttongroup[3][6]);*/
		
		buttongroup[2][6] = new JButton("7");
		buttongroup[2][6].setBounds(107, 69, 50, 27);
		/*panel.add(buttongroup[2][6]);*/
		
		buttongroup[1][6] = new JButton("7");
		buttongroup[1][6].setBounds(107, 127, 50, 27);
/*		panel.add(buttongroup[1][6]);*/
		
		buttongroup[0][6] = new JButton("7");
		buttongroup[0][6].setBounds(107, 189, 50, 27);
		/*panel.add(buttongroup[0][6]);*/
		
		buttongroup[4][5] = new JButton("6");
		buttongroup[4][5].setBounds(195, 35, 50, 27);
		panel.add(buttongroup[4][5]);
		
		buttongroup[3][5] = new JButton("6");
		buttongroup[3][5].setBounds(28, 95, 50, 27);
		panel.add(buttongroup[3][5]);
		
		buttongroup[2][5] = new JButton("6");
		buttongroup[2][5].setBounds(28, 155, 50, 27);
		panel.add(buttongroup[2][5]);
		
		buttongroup[1][5] = new JButton("6");
		buttongroup[1][5].setBounds(28, 215, 50, 27);
		panel.add(buttongroup[1][5]);
		
		buttongroup[0][5] = new JButton("6");
		buttongroup[0][5].setBounds(28, 275, 50, 27);
		panel.add(buttongroup[0][5]);
		
		buttongroup[4][4] = new JButton("5");
		buttongroup[4][4].setBounds(275, 35, 50, 27);
		panel.add(buttongroup[4][4]);
		
		buttongroup[3][4] = new JButton("5");
		buttongroup[3][4].setBounds(105, 95, 50, 27);
		panel.add(buttongroup[3][4]);
		
		buttongroup[2][4] = new JButton("5");
		buttongroup[2][4].setBounds(105, 155, 50, 27);
		panel.add(buttongroup[2][4]);
		
		buttongroup[1][4] = new JButton("5");
		buttongroup[1][4].setBounds(105, 215, 50, 27);
		panel.add(buttongroup[1][4]);
		
		buttongroup[0][4] = new JButton("5");
		buttongroup[0][4].setBounds(105, 275, 50, 27);
		panel.add(buttongroup[0][4]);
		
		buttongroup[4][3] = new JButton("4");
		buttongroup[4][3].setBounds(360, 35, 50, 27);
		panel.add(buttongroup[4][3]);		
		
		buttongroup[3][3] = new JButton("4");
		buttongroup[3][3].setBounds(275, 95, 50, 27);
		panel.add(buttongroup[3][3]);
		
		buttongroup[2][3] = new JButton("4");
		buttongroup[2][3].setBounds(275, 155, 50, 27);
		panel.add(buttongroup[2][3]);
		
		buttongroup[1][3] = new JButton("4");
		buttongroup[1][3].setBounds(275, 215, 50, 27);
		panel.add(buttongroup[1][3]);
		
		buttongroup[0][3] = new JButton("4");
		buttongroup[0][3].setBounds(275, 275, 50, 27);
		panel.add(buttongroup[0][3]);
		
		buttongroup[4][2] = new JButton("3");
		buttongroup[4][2].setBounds(456, 35, 50, 27);
		panel.add(buttongroup[4][2]);
		
		buttongroup[3][2] = new JButton("3");
		buttongroup[3][2].setBounds(360, 95, 50, 27);
		panel.add(buttongroup[3][2]);
		
		buttongroup[2][2] = new JButton("3");
		buttongroup[2][2].setBounds(360, 155, 50, 27);
		panel.add(buttongroup[2][2]);
		
		buttongroup[1][2] = new JButton("3");
		buttongroup[1][2].setBounds(360, 215, 50, 27);
		panel.add(buttongroup[1][2]);
		
		buttongroup[0][2] = new JButton("3");
		buttongroup[0][2].setBounds(360, 275, 50, 27);
		panel.add(buttongroup[0][2]);
		
		buttongroup[4][1] = new JButton("2");
		buttongroup[4][1].setBounds(540, 35, 50, 27);
		panel.add(buttongroup[4][1]);
		
		
		buttongroup[3][1] = new JButton("2");
		buttongroup[3][1].setBounds(550, 95, 50, 27);
		panel.add(buttongroup[3][1]);

		buttongroup[2][1] = new JButton("2");
		buttongroup[2][1].setBounds(550, 155, 50, 27);
		panel.add(buttongroup[2][1]);
		
		buttongroup[1][1] = new JButton("2");
		buttongroup[1][1] .setBounds(550, 215, 50, 27);
		panel.add(buttongroup[1][1] );
		
		buttongroup[0][1] = new JButton("2");
		buttongroup[0][1].setBounds(550, 275, 50, 27);
		panel.add(buttongroup[0][1]);
		
		buttongroup[4][0]= new JButton("1");
		buttongroup[4][0].setBounds(625, 35, 50, 27);
		panel.add(buttongroup[4][0]);
		
		buttongroup[3][0]= new JButton("1");
		buttongroup[3][0].setBounds(625, 95, 50, 27);
		panel.add(buttongroup[3][0]);
		
		buttongroup[2][0] = new JButton("1");
		buttongroup[2][0].setBounds(625, 155, 50, 27);
		panel.add(buttongroup[2][0]);
		
		buttongroup[1][0] = new JButton("1");
		buttongroup[1][0].setBounds(625, 215, 50, 27);
		panel.add(buttongroup[1][0]);
		
		buttongroup[0][0] = new JButton("1");
		buttongroup[0][0].setBounds(625, 275, 50, 27);
		panel.add(buttongroup[0][0]);
	/*	JButton mybutton = new JButton("1");
		mybutton.setBounds(622, 98, 50, 27);
		panel.add(mybutton);*/
		
		for(int i=0;i<5;i++){
			for(int j=0;j<8;j++){
				buttongroup[i][j].addActionListener(this);
			}
		}
		
		JButton btnNewButton_1 = new JButton("Screen");
		btnNewButton_1.setBounds(68, 335, 557, 27);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setBounds(14, 287, 75, 29);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(815, 287, 75, 29);
		contentPane.add(label);
		
		JLabel lblB = new JLabel("B");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBounds(14, 231, 75, 29);
		contentPane.add(lblB);
		
		JLabel label_1 = new JLabel("B");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(815, 231, 75, 29);
		contentPane.add(label_1);
		
		JLabel lblC = new JLabel("C");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(14, 171, 75, 29);
		contentPane.add(lblC);
		
		JLabel label_2 = new JLabel("C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(815, 171, 75, 29);
		contentPane.add(label_2);
		
		JLabel lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(14, 110, 75, 29);
		contentPane.add(lblD);
		
		JLabel label_3 = new JLabel("D");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(815, 110, 75, 29);
		contentPane.add(label_3);
		
		JLabel lblE = new JLabel("E");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setBounds(17, 55, 72, 18);
		contentPane.add(lblE);
		
		JLabel label_4 = new JLabel("E");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(815, 55, 72, 18);
		contentPane.add(label_4);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(14, 427, 113, 27);
		contentPane.add(btnBack);
		
		btnChoose = new JButton("Confirm");
		btnChoose.addActionListener(this);

		btnChoose.setBounds(777, 427, 113, 27);
		contentPane.add(btnChoose);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setBounds(385, 427, 113, 27);
		contentPane.add(btnReset);
		
		
		try{
			File myFile=new File(System.getProperty("user.dir")+"\\"+"data.txt");
			FileReader fr=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				String[] list=line.split("@");
				if(list[1].equals("screen3")&&list[2].equals(choosetime)&&list[0].equals(moviename)){
				Character a=list[4].charAt(0);
				int b=Integer.valueOf(list[4].substring(1,2))-1;
				int j=-1;
				switch(a){
				case 'A':
					j=0;
					break;
				case 'B':
					j=1;
					break;
				case 'C':
					j=2;
					break;
				case 'D':
					j=3;
					break;
				case 'E':
					j=4;
				}
				buttongroup[j][b].setEnabled(false);
				}
			}
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

	/**
	 * This actionPerformed function will judge the selected button the user choose,
	 * if user press the reset button, the seats will be reset
	 * if user press the seats buttons, the function will record the index of the button
	 */
	
	public void actionPerformed(ActionEvent e) {
		JButton jb=(JButton)e.getSource();
		if(jb==btnBack){
			dispose();
			Select frame=new Select(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		else if(jb==btnReset){
			for(int i=0;i<selectedbutton.size();i++){
				selectedbutton.get(i).setEnabled(true);
			}
			selectedbutton.clear();
		}
		else if(jb==btnChoose){
			if(selectedbutton.size()==ticketnumber){
			dispose();
			confirmPayment frame2=new confirmPayment(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);
			}
			else{
				Dialog frame3=new Dialog("Wrong ticket number!the seat number is: "+ticketnumber+", But you select "+selectedbutton.size()+" seat(s)");
				frame3.setLocationRelativeTo(null);
				frame3.setVisible(true);
				seat="";
				btnReset.doClick();
			}
		}
		else{
		 for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 8; j++) {	            		
	                if (buttongroup[i][j] == e.getSource()) {
	                	buttongroup[i][j].setEnabled(false);
	                	selectedbutton.add(buttongroup[i][j]);
	                	String output="";
	                	switch(i){
						case 0:
							output=output+"A";
							break;
						case 1:
							output=output+"B";
							break;
						case 2:
							output=output+"C";
							break;
						case 3:
							output=output+"D";
							break;
						case 4:
							output=output+"E";
						default:
							break;
						}
						output=output+(j+1);
						if(seat.equals("")){
							seat=output;
						}
						else{
						seat=seat+" "+output;
						}
	                }
	        }
	     }
		}
	}
}
