import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;  
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class confirmPayment extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private String[] tickettime;
	private int ticketnumber;
	private String moviename;
	private String screen;
	private String choosetime;
	private String tickettype;
	private String seat;
	private String totalprice;
	private JButton okButton;
	private JButton cancelButton;
	private String stunum;


	/**
	 * Create the frame.
	 * This is the frame to confirm the payment  
	 */
	public confirmPayment(String moviename,String screen, String[] tickettime,String choosetime,String tickettype,int ticketnumber,String seat,String stunum) {
		this.moviename=moviename;
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.stunum=stunum;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.seat=seat;
		this.totalprice= String.valueOf(calculatePrice(tickettype,ticketnumber));
		DecimalFormat df = new DecimalFormat("#.00");  
        /*System.out.println(df.format(a)); */ 
		setBounds(100, 100, 756, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setText("Moviename: "+moviename+"   "+"Choosetime: "+choosetime+"   "+"Ticket Type: "+tickettype+"   "+"Number: "+ticketnumber);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(49, 42, 612, 62);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("seat: "+seat);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(49, 110, 612, 62);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("totalPrice: "+df.format(calculatePrice(tickettype,ticketnumber)));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(49, 185, 612, 50);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Pay");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		} 
		
	}
	public void actionPerformed(ActionEvent e){
		JButton jb=(JButton)e.getSource();
		if(jb==okButton){
			dispose();
			if(tickettype.equals("Student")){
				StunumIn stu=new StunumIn(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,totalprice,stunum);
				stu.setLocationRelativeTo(null);
				stu.setVisible(true);
			}
			else {
			Final frame1=new Final(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,totalprice,stunum);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			}
			
		}
		else{
			dispose();
			seat="";
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
	}
	
	/**
	 * This is the function to calculate the price
	 * @param the type of the tickets
	 * @param the number of the tickets 
	 * @return the price for one type of tickets
	 */
	
	public double calculatePrice(String tickettype,int ticketnumber){
		switch(tickettype){
		case "Child":
			return ticketnumber*16.0*0.5;
		case "Adult":
			return ticketnumber*16.0*1.0;
		case "Senior":
			return ticketnumber*16.0*0.8;
		case "Student":
			return ticketnumber*16.0*0.85;
		}
		return ticketnumber*16.0*1.0;
	}
}
