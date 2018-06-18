import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;



public class Log extends JFrame implements ActionListener{
	private String[] tickettime;
	private int ticketnumber;
	private String ticketytype;
	private String moviename;
	private String screen;
	private String choosetime;
	private String tickettype;
	private int tichetnumber;
	private String seat;
	private String stunum;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log("beauty and the beast","screen1", new String[]{"10:00","12:30"},"0","0",0,"","");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * This is the frame of log in, the user can choose film, or see the statistic report, or exit
	 */
	public Log(String moviename,String screen,String[] tickettime,String choosetime,String tickettype,int ticketnumber,String seat,String stunum) {
		this.moviename=moviename;
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.seat=seat;
		this.stunum=stunum;
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("Welcome to SE cinema!");
		lblWelcomeTo.setBounds(134, 92, 168, 18);
		contentPane.add(lblWelcomeTo);
		
		JButton btnBuyTickets = new JButton("Film");
		btnBuyTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuyTickets.setBounds(134, 144, 148, 27);
		btnBuyTickets.addActionListener(this);
		contentPane.add(btnBuyTickets);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnExit.setBounds(134, 224, 148, 27);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("kiosk.png"));
		lblNewLabel.setBounds(114, 13, 202, 74);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Admin");
		/*When user click the admin button, it will jump over to the Admin frame*/
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad=new Admin();
				ad.setLocationRelativeTo(null);
				ad.setVisible(true);
			}
		});
		btnNewButton.setBounds(134, 184, 148, 27);
		contentPane.add(btnNewButton);
	}
	
	
	/**
	 * When user click the film button, it will jump over to the ChooseFilm frame 
	 */
	public void actionPerformed(ActionEvent e){
		dispose();
		ChooseFilm frame = new ChooseFilm(moviename,screen,tickettime,choosetime,tickettype,ticketnumber,seat,stunum);
		frame.setVisible(true);
	}
}
