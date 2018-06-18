import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This is the frame to confirm the select information 
 * @author Fan
 *
 */
public class SelectConfirm extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private String[] tickettime;
	private int ticketnumber;
	private String tickettype;
	private String moviename;
	private String screen;
	private String choosetime;
	private String seat;
	private JButton cancelButton;
	private JButton okButton;
	private String stunum;

	/**
	 * Create the dialog.
	 */
	public SelectConfirm(String moviename,String screen, String[] tickettime,String choosetime,String tickettype,int ticketnumber,String seat,String stunum) {
		setTitle("Confirm");
		this.moviename=moviename;
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.stunum=stunum;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.seat=seat;
		setBounds(100, 100, 705, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText("Moviename: "+moviename+"   "+"Choosetime: "+choosetime+"   "+"Ticket Type: "+tickettype+"   "+"Number: "+ticketnumber);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 73, 542, 150);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton= new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		JButton jb=(JButton) e.getSource();
		if(jb==okButton){
			int valid=validSeats(screen,choosetime,moviename);
		if(ticketnumber>valid){
			Dialog dialog=new Dialog("You want to buy "+ticketnumber+" ticket(s),but there are only "+valid+" seat(s)!");
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
			return;
		}
		dispose();
		switch(screen){
		case "screen1":
			screen1frame framea=new screen1frame(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
			framea.setLocationRelativeTo(null);
			framea.setVisible(true);
			break;
		case "screen2":
			screen2frame frameb=new screen2frame(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
			frameb.setLocationRelativeTo(null);
			frameb.setVisible(true);
			break;
		case "screen3":
			screen3frame framec=new screen3frame(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
			framec.setLocationRelativeTo(null);
			framec.setVisible(true);
			break;		
		}
		}
		else{
		dispose();
		Select frame=new Select(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		}
	}
	
	
	/**
	 * This is the function to return the number of valid seats 
	 * @param screen the screen of the movie 
	 * @param choosetime   the choose time of the movie
	 * @param moviename     the name of movie 
	 * @return  the number of the seats
	 */
	
	public int validSeats(String screen,String choosetime,String moviename){
		int usedseats=0;
		int size=0;
		switch(screen){
		case "screen1":
			size=32;
			break;
		case "screen2":
			size=26;
			break;
		case "screen3":
			size=32;
			break;
		}
		/*The funciton will open the data.txt to count the number of used seats*/
		try{
			File myFile=new File(System.getProperty("user.dir")+"\\"+"data.txt");
			FileReader fr=new FileReader(myFile);
			BufferedReader reader=new BufferedReader(fr);
			String line=null;
			while((line=reader.readLine())!=null){
				String []list=line.split("@");
				if(list[0].equals(moviename)&&list[1].equals(screen)&&list[2].equals(choosetime)) usedseats++;
			}
			reader.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return size-usedseats;
	}
}
