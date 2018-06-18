import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ChooseFilm extends JFrame implements ActionListener {

	private JPanel contentPane;
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
	private JButton btnBuy;
	private JButton btnBuy_1;
	private JButton btnBuy_2;
	private JButton btnBuy_3;
	private JButton btnBuy_4;
	private JButton btnBack;
	/**
	 * Launch the application.
	 */
	public static void main(String argsp[]){
		ChooseFilm fm=new ChooseFilm("","",new String[]{"",""},"","",0,"","");
		fm.setLocationRelativeTo(null);
		fm.setVisible(true);
	}

	/**
	 * Create the frame.
	 * This is the frame of ChooseFilm, user is able to choose film from this frame
	 */
	public ChooseFilm(String moviename,String screen,  String[] tickettime, String choosetime, String tickettype, int ticketnumber,String seat,String stunum) {
		this.moviename=moviename;
		this.screen=screen;
		this.tickettime=tickettime;
		this.choosetime=choosetime;
		this.tickettype=tickettype;
		this.ticketnumber=ticketnumber;
		this.seat=seat;
		this.stunum=stunum;
		setTitle("Film");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("skull.png"));
		label.setBounds(352, 27, 123, 188);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Logan.png"));
		label_1.setBounds(352, 301, 123, 188);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("beautyandbeast.png"));
		label_2.setBounds(352, 581, 123, 188);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("moonlight.png"));
		label_3.setBounds(974, 27, 123, 180);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("lalland.png"));
		label_4.setBounds(974, 312, 113, 188);
		contentPane.add(label_4);
		
		JLabel lblKongSkullIsland = new JLabel("KONG: SKULL ISLAND");
		lblKongSkullIsland.setBounds(24, 101, 156, 18);
		contentPane.add(lblKongSkullIsland);
		
		JLabel lblMin = new JLabel("118 min");
		lblMin.setBounds(232, 101, 72, 18);
		contentPane.add(lblMin);
		
		JLabel lblLogan = new JLabel("LOGAN");
		lblLogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogan.setBounds(54, 401, 72, 18);
		contentPane.add(lblLogan);
		
		JLabel lblMin_1 = new JLabel("135 min");
		lblMin_1.setBounds(232, 401, 72, 18);
		contentPane.add(lblMin_1);
		
		JLabel lblBeautyAndThe = new JLabel("BEAUTY AND THE BEAST");
		lblBeautyAndThe.setBounds(24, 673, 185, 18);
		contentPane.add(lblBeautyAndThe);
		
		JLabel lblMin_2 = new JLabel("130 min");
		lblMin_2.setBounds(232, 673, 72, 18);
		contentPane.add(lblMin_2);
		
		JLabel lblNewLabel = new JLabel("MOONLIGHT");
		lblNewLabel.setBounds(652, 101, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblMin_3 = new JLabel("111 min");
		lblMin_3.setBounds(808, 101, 72, 18);
		contentPane.add(lblMin_3);
		
		JLabel lblNewLabel_1 = new JLabel("LA LA LAND");
		lblNewLabel_1.setBounds(652, 401, 108, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMin_4 = new JLabel("128 min");
		lblMin_4.setBounds(808, 401, 72, 18);
		contentPane.add(lblMin_4);
		
		JButton btnDetail = new JButton("Detail");
		/*If user choose to see the detail of KONG, it will prompt out a frame about the detail of the KONG*/
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details_K d=new Details_K();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnDetail.setBounds(352, 219, 113, 27);
		contentPane.add(btnDetail);
		
		btnBuy = new JButton("Buy");
		btnBuy.addActionListener(this);
		btnBuy.setBounds(352, 248, 113, 27);
		contentPane.add(btnBuy);
		
		JButton btnDetail_1 = new JButton("Detail");
		/*If user choose to see the detail of LOGAN, it will prompt out a frame about the detail of the LOGAN*/
		btnDetail_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details_Lo d=new Details_Lo();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnDetail_1.setBounds(352, 502, 113, 27);
		contentPane.add(btnDetail_1);
		
		btnBuy_1 = new JButton("Buy");
		btnBuy_1.addActionListener(this);
		btnBuy_1.setBounds(352, 532, 113, 27);
		contentPane.add(btnBuy_1);
		
		JButton btnDetail_2 = new JButton("Detail");
		/*If user choose to see the detail of BEAUTY, it will prompt out a frame about the detail of the BEAUTY*/
		btnDetail_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Details_B d=new Details_B();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnDetail_2.setBounds(352, 772, 113, 27);
		contentPane.add(btnDetail_2);
		
		btnBuy_2 = new JButton("Buy");
		btnBuy_2.setBounds(352, 802, 113, 27);
		btnBuy_2.addActionListener(this);
		contentPane.add(btnBuy_2);
		
		JButton btnDetail_3 = new JButton("Detail");
		/*If user choose to see the detail of MOONLIGHT, it will prompt out a frame about the detail of the MOONLIGHT*/
		btnDetail_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Details_M d=new Details_M();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnDetail_3.setBounds(974, 219, 113, 27);
		contentPane.add(btnDetail_3);
		
		btnBuy_3 = new JButton("Buy");
		btnBuy_3.addActionListener(this);
		btnBuy_3.setBounds(974, 248, 113, 27);
		contentPane.add(btnBuy_3);
		
		JButton btnDetial = new JButton("Detail");
		/*If user choose to see the detail of LA LA LAND, it will prompt out a frame about the detail of the LA LA LAND*/
		btnDetial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Details_La d=new Details_La();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnDetial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDetial.setBounds(974, 502, 113, 27);
		contentPane.add(btnDetial);
		
		btnBuy_4 = new JButton("Buy");
		btnBuy_4.addActionListener(this);
		btnBuy_4.setBounds(974, 532, 113, 27);
		contentPane.add(btnBuy_4);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(54, 13, 72, 18);
		contentPane.add(lblName);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(232, 13, 72, 18);
		contentPane.add(lblLength);
		
		JLabel label_5 = new JLabel("Name");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(652, 13, 72, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Length");
		label_6.setBounds(808, 13, 72, 18);
		contentPane.add(label_6);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnExit.setBounds(1038, 802, 113, 27);
		contentPane.add(btnExit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(1038, 772, 113, 27);
		contentPane.add(btnBack);
		setLocationRelativeTo(null);
	}
	
	
	/**
	 * This is the controller of all the buy button
	 * If user touches the button, it will first find out which button the user clicked to
	 * find out related show time about the film (it will also initiate parameter moviename)
	 * and then it will jump over the next Select frame
	 */
	public void actionPerformed(ActionEvent e){
		JButton jb=(JButton)e.getSource();
		if(jb==btnBuy_2){
		dispose();
		Select frame=new Select("beauty and the beast","screen1", new String[]{"10:00","10:30","12:30","13:00"},choosetime,tickettype,ticketnumber,seat,stunum);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		}
		else if(jb==btnBuy_1){
		dispose();
		Select frame1=new Select("logan","screen3", new String[]{"15:30","18:00"},choosetime,tickettype,ticketnumber,seat,stunum);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		}
		else if(jb==btnBuy){
			dispose();
			Select frame2=new Select("kong: skull island","screen1", new String[]{"15:30","18:30","20:00","20:30","21:00"},choosetime,tickettype,ticketnumber,seat,stunum);
			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);
		}
		else if(jb==btnBuy_3){
			dispose();
			Select frame3=new Select("moonlight","screen2", new String[]{"16:00","18:00"},choosetime,tickettype,ticketnumber,seat,stunum);
			frame3.setLocationRelativeTo(null);
			frame3.setVisible(true);
		}
		else if(jb==btnBuy_4){
			dispose();
			Select frame4=new Select("la la land","screen2", new String[]{"10:30","13:00"},choosetime,tickettype,ticketnumber,seat,stunum);
			frame4.setLocationRelativeTo(null);
			frame4.setVisible(true);
		}
		else if(jb==btnBack){
			dispose();
			Log framea = new Log("beauty and the beast","screen1", new String[]{"10:00","12:30"},"0","0",0,"","");
			framea.setVisible(true);
			framea.setLocationRelativeTo(null);
		}
	}
}
