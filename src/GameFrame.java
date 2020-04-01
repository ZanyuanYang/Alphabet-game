/****
 * creates the frame, set the size and position of the letter,
 *  handles window closing, and creates and adds the game panel 
*/

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener {
	
	private JLabel gameRule1, gameRule2, gameRule3;
	private JButton EnterButton, ExitButton;
	private ImageIcon background;
	private URL beginSound;
	
	public GameFrame() {
		setTitle("Alphabet Learning Game");
		setResizable(false);
		setSize(900,700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		centerWindow(this);
		this.setLayout(null);
		
		//Explain the game rules
		gameRule1 = new JLabel("The Game Introduction:     1: The alphabets will show on the board.");
		gameRule1.setBounds(100, 60, 800, 50);
		gameRule1.setFont(new Font("Courier", Font.BOLD, 18));
		gameRule1.setVisible(true);
		this.add(gameRule1);	
		
		gameRule2 = new JLabel("2: Clicking the corresponding option.");
		gameRule2.setBounds(333, 90, 800, 50);
		gameRule2.setFont(new Font("Courier", Font.BOLD, 18));
		gameRule2.setVisible(true);
		this.add(gameRule2);	
		
		gameRule3 = new JLabel("3: Or typing the corresponding alphabet on the keyboard.");
		gameRule3.setBounds(333, 120, 800, 50);
		gameRule3.setFont(new Font("Courier", Font.BOLD, 18));
		gameRule3.setVisible(true);
		this.add(gameRule3);
		//Enter and Exit Button
		EnterButton = new JButton("Enter");
		EnterButton.addActionListener(this);
		EnterButton.setBounds(200, 400, 150, 150);
		EnterButton.setFont(new Font("Courier", Font.BOLD, 30));

		ExitButton = new JButton("Exit");
		ExitButton.addActionListener(this);
		ExitButton.setBounds(700, 400, 150, 150);
		ExitButton.setFont(new Font("Courier", Font.BOLD, 30));
		
		EnterButton.setVisible(true);
		ExitButton.setVisible(true);
		this.add(EnterButton);
		this.add(ExitButton);
		
		//background
		JPanel back1 = (JPanel)this.getContentPane();
		back1.setOpaque(false);
		background = new ImageIcon("images//background.jpg");
		JLabel b = new JLabel(background);
		b.setBounds(0, 00, 900, 700);
		b.setVisible(true);
		getLayeredPane().setLayout(null);
		getLayeredPane().add(b,new Integer(Integer.MIN_VALUE));
	}
	
	
	
	private void centerWindow(GameFrame w)
	{	
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width-w.getWidth())/2,(d.height-w.getHeight())/2);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == ExitButton) 
			System.exit(0);
		else if(source == EnterButton){
			
			try{
				beginSound = new URL("file:" + new File(".").getCanonicalPath()
					+ "//sounds//start.wav");
				AudioClip a = Applet.newAudioClip(beginSound);
				a.play();
				}
			catch(Exception e1) {
				System.out.println(e1.toString());
				}
			
			
			JFrame a = new GamePanel("ww"); 
			a.setVisible(true);
			this.dispose();			
		}
}
}
