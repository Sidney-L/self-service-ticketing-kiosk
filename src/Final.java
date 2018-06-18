import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Final extends JFrame {
	private JPanel contentPane;
	private String[] tickettime;
	private int ticketnumber;
	private String moviename;
	private String screen;
	private String choosetime;
	private String tickettype;
	private String seat;
	private String stunum;
	private String totalprice;

	/**
	 * Create the frame.
	 * This is the Final Payment frame, the ticket information will be printed out in the frame,
	 * the user can choose whether to buy tickets again or exit the system
	 * 
	 */
	public Final(String moviename,String screen, String[] tickettime,String choosetime,String tickettype,int ticketnumber,String seat, String totalprice,String stunum) {
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
		setBounds(100, 100, 747, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy tickets");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ChooseFilm frame = new ChooseFilm("beauty and the beast","screen", new String[]{"10:00","12:30","null"},"0","0",0,"","");
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(329, 394, 167, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(526, 394, 167, 27);
		contentPane.add(btnNewButton_1);
		
		/*write down ticket information into data.txt and generate ticket in ticketid.txt*/
		String text="";
		String []line=seat.split(" ");
		if(!stunum.equals("")){
			String []splitstunum=stunum.split(";");
		for(int i=0;i<line.length;i++){
			String ticketid=generateID(8);
			String tickettxt=System.getProperty("user.dir")+"\\"+ticketid+".txt";
			writeData(tickettxt,ticketid,line[i],splitstunum[i]);
			writeData("data.txt",ticketid,line[i],splitstunum[i]);
			text=text+"Moviename: "+moviename+" Screen: "+screen+" Time: "+choosetime+" Ticket Type: "+tickettype+" Seat: "+line[i]+" Ticket: ID "+ticketid+"\r\n";
		}
		}
		/*write down ticket information into data.txt and generate ticket in ticketid.txt*/
		else{
			for(int i=0;i<line.length;i++){
			String ticketid=generateID(8);
			String tickettxt=System.getProperty("user.dir")+"\\"+ticketid+".txt";
			writeData(tickettxt,ticketid,line[i],"");
			writeData("data.txt",ticketid,line[i],"");
			text=text+"Moviename: "+moviename+" Screen: "+screen+" Time: "+choosetime+" Ticket Type: "+tickettype+" Seat: "+line[i]+" Ticket: ID "+ticketid+"\r\n";
			}
			}
		JTextArea txtrDdd = new JTextArea();
		txtrDdd.setText(text);
		txtrDdd.setBounds(31, 48, 662, 301);
		contentPane.add(txtrDdd);
		txtrDdd.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("You have sucessfully bought the ticket(s)!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 13, 627, 27);
		contentPane.add(lblNewLabel);
	}
	
	public String generateID(int length){
		Random rand=new Random();
		String ticketid="";
		for(int i=0;i<length;i++){
			int number=rand.nextInt(4)+1;
			ticketid=ticketid+String.valueOf(number);
		}
		try{
			File myFile=new File(System.getProperty("user.dir")+"\\"+"data.txt");
			FileReader fr=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				String[] list=line.split("@");
				if(list[5].equals(ticketid)){
					ticketid=generateID(8);
				}
			}
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return ticketid;
	}
	
	
    /**
     * This is the function to write down the information in a particular outputtxt.txt
     * @param outputtxt the filename you want to use
     * @param ticketid   the ticket id
     * @param seat      the seat of the ticket 
     * @param stunum  the number of student id
     */ 
	public void writeData(String outputtxt,String ticketid,String seat,String stunum){
		try{
			File myFile=new File(outputtxt);
			FileWriter fw=new FileWriter(myFile,true);
			BufferedWriter writer=new BufferedWriter(fw);
			String line=moviename+"@"+screen+"@"+choosetime+"@"+tickettype+"@"+seat+"@"+ticketid+"@"+stunum+"\r\n";
			writer.write(line);
			writer.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
