import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;


import javax.swing.JButton;


public class Admin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private String childnumber;
	private String adultnumber;
	private String seniornumber;
	private String studentnumber;
	private double totalsales_b;
	private double totalsales_k;
	private double totalsales_m;
	private double totalsales_lo;
	private double totalsales_la;
	private String totalsales_bs;
	private String totalsales_ks;
	private String totalsales_ms;
	private String totalsales_los;
	private String totalsales_las;
	private String totalticket;
	private String outtext;
	private JButton btnGenerateReport;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * This is the frame about amdin, it will generate the statistic report about 
	 * the total sale of each film; total number of tickets sold; each type of ticket sold
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistic Report");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 36, 357, 46);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(60, 100, 571, 233);
		contentPane.add(textArea);
		childnumber=String.valueOf(numberofkeyword("Child",3));
		adultnumber=String.valueOf(numberofkeyword("Adult",3));
		seniornumber=String.valueOf(numberofkeyword("Senior",3));
		studentnumber=String.valueOf(numberofkeyword("Student",3));
		
		/*The price for Child is 16*0.5
		 * The price for Adult is 16*1.0
		 * This price for Senior is 16*0.8
		 * This price for Student is 16*0.85
		 * 
		 */
		totalsales_b=16*(double)num_movie_type("beauty and the beast","Child")*0.5+
				16*(double)num_movie_type("beauty and the beast","Adult")*1.0+
				16*(double)num_movie_type("beauty and the beast","Senior")*0.8+
				16*(double)num_movie_type("beauty and the beast","Student")*0.85; 
		totalsales_bs = String.format("%.2f",totalsales_b);
		
		
		totalsales_k=16*(double)num_movie_type("kong: skull island","Child")*0.5+
				16*(double)num_movie_type("kong: skull island","Adult")*1.0+
				16*(double)num_movie_type("kong: skull island","Senior")*0.8+
				16*(double)num_movie_type("kong: skull island","Student")*0.85;
		totalsales_ks = String.format("%.2f",totalsales_k);
		
		
		totalsales_m=16*(double)num_movie_type("moonlight","Child")*0.5+
				16*(double)num_movie_type("moonlight","Adult")*1.0+
				16*(double)num_movie_type("moonlight","Senior")*0.8+
				16*(double)num_movie_type("moonlight","Student")*0.85;
		totalsales_ms = String.format("%.2f",totalsales_m);
		
		totalsales_lo=16*(double)num_movie_type("logan","Child")*0.5+
				16*(double)num_movie_type("logan","Adult")*1.0+
				16*(double)num_movie_type("logan","Senior")*0.8+
				16*(double)num_movie_type("logan","Student")*0.85;
		totalsales_los = String.format("%.2f",totalsales_lo);
		
		
		totalsales_la=16*(double)num_movie_type("la la land","Child")*0.5+
				16*(double)num_movie_type("la la land","Adult")*1.0+
				16*(double)num_movie_type("la la land","Senior")*0.8+
				16*(double)num_movie_type("la la land","Student")*0.85;
		totalsales_las = String.format("%.2f",totalsales_la);
		
		totalticket=String.valueOf(numberoflines());
		
		outtext="Child: "+childnumber+"    Adult: "+adultnumber+"    Senior: "+seniornumber+"    Student: "+studentnumber+"\r\n"
				+"beauty and the beast: "+totalsales_bs+"    kong: skull island: "+totalsales_ks+"    moonlight: "+totalsales_ms+"    logan: "
				+totalsales_los+"    la la land: "+ totalsales_las+"\r\n"+"total tickets: "+totalticket;
		textArea.setText(outtext);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(28, 398, 193, 27);
		contentPane.add(btnBack);
		

		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.addActionListener(this);
		btnGenerateReport.setBounds(458, 398, 193, 27);
		contentPane.add(btnGenerateReport);
	}
	
	public void actionPerformed(ActionEvent e){
		JButton jb=(JButton)(e.getSource());
		if(jb==btnGenerateReport){
			try{
				File myFile=new File(System.getProperty("user.dir")+"\\"+"report.txt");
				FileWriter fw=new FileWriter(myFile);
				BufferedWriter writer=new BufferedWriter(fw);
				writer.write(outtext+"\r\n");
				writer.close();
				Dialog dg=new Dialog("Report Generated!");
				dg.setLocationRelativeTo(null);
				dg.setVisible(true);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		else if(jb==btnBack){
			dispose();
			Log frame = new Log("beauty and the beast","screen1", new String[]{"10:00","12:30"},"0","0",0,"","");
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		}
	}
	/**
	 * This is the function to find the number of keyword in a .txt file
	 * @param the keyword to find out
	 * @param the index of keyword
	 * @return return the number of keyword in the file
	 */
	public int numberofkeyword(String s,int index){
		int i=0;
		try{
			File myFile=new File(System.getProperty("user.dir")+"\\"+"data.txt");
			FileReader fr=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				String[] list=line.split("@");
				if(list[index].equals(s)){
					i++;
				}
			}
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return i;
	}
	
	/**
	 * This is the function to find out the number of tickets(each type, eg:Child,Adult,Senior,Student) sold in a particular movie
	 * @param movie the name of movie
	 * @param type the type of the ticket
	 * @return the number tickets
	 */
	
	public int num_movie_type(String movie,String type){
		int i=0;
		try{
			File myFile=new File(System.getProperty("user.dir")+"\\"+"data.txt");
			FileReader fr=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				String[] list=line.split("@");
				if(list[0].equals(movie)&&list[3].equals(type)){
					i++;
				}
			}
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return i;
	}
	/**
	 * This is the function to find out the number of total tickets sold 
	 * @return the number of total tickets sold
	 */
	
	public int numberoflines(){
		int i=0;
		try{
			File myFile=new File(System.getProperty("user.dir")+"\\"+"data.txt");
			FileReader fr=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				i++;
			}
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return i;
	}
}
