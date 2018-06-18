import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Details_M extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Details_M() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("moonlight.png"));
		lblNewLabel.setBounds(48, 98, 118, 176);
		contentPane.add(lblNewLabel);
		
		JLabel lblMovieName = new JLabel("Movie name");
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setBounds(218, 57, 111, 18);
		contentPane.add(lblMovieName);
		
		JLabel lblKongSkullIsland = new JLabel("MOONLIGHT");
		lblKongSkullIsland.setHorizontalAlignment(SwingConstants.CENTER);
		lblKongSkullIsland.setBounds(375, 57, 201, 18);
		contentPane.add(lblKongSkullIsland);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(218, 98, 111, 18);
		contentPane.add(lblTime);
		
		JLabel lblMin = new JLabel("111 min");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(375, 98, 201, 18);
		contentPane.add(lblMin);
		
		JLabel lblIntroduction = new JLabel("Introduction");
		lblIntroduction.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduction.setBounds(218, 140, 111, 18);
		contentPane.add(lblIntroduction);
		
		JTextArea txtrKongSkullIsland = new JTextArea();
		txtrKongSkullIsland.setEditable(false);
		txtrKongSkullIsland.setLineWrap(true);
		
		
		/*The detail about MoonLight*/
		txtrKongSkullIsland.setText("Moonlight is a 2016 American coming-of-age drama film directed by Barry Jenkins and written by Jenkins and Tarell Alvin McCraney based on McCraney's unpublished semi-autobiographical play In Moonlight Black Boys Look Blue. It stars Trevante Rhodes, Andr\u00E9 Holland, Janelle Mon\u00E1e, Ashton Sanders, Naomie Harris and Mahershala Ali.");
		txtrKongSkullIsland.setBounds(228, 171, 348, 147);
		contentPane.add(txtrKongSkullIsland);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(25, 345, 113, 27);
		contentPane.add(btnBack);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(516, 345, 113, 27);
		contentPane.add(btnOk);
	}

}
