/*****
 *Creates the GUI components, performs event handling, processes the player's answer
 *updates the score, and controls the audio clip and player.
 */
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.applet.*;



class GamePanel extends JFrame implements ActionListener
{
	Rank list = new Rank();
	private int rightButton = 0;
	private int wrongButton = 0;
	
	
	private String player;
	public GameLetterPanel gp;
	private JTextArea numberTextArea;
	private JTextField rightButtonTextField,
						wrongButtonTextField;
	private Player playerObject;
	
	private JLabel rightClickLabel, 
					wrongClickLabel;
	private JRadioButton  ButtonA, ButtonB, ButtonC, ButtonD, ButtonE, ButtonF, ButtonG,
						  ButtonH, ButtonI, ButtonJ, ButtonK, ButtonL, ButtonM, ButtonN,
						  ButtonO, ButtonP, ButtonQ, ButtonR, ButtonS, ButtonT, ButtonU,
						  ButtonV, ButtonW, ButtonX, ButtonY, ButtonZ;

	private JButton	startButton,
					quitButton,
					stopGameButton,
					rankButton;
	
	private URL beginSound;
	
	private AudioClip audioClip;
	private URL audioUrl;
	
	public GamePanel (String player)
	{
		
		setTitle("Alphabet Learning Game");
		setResizable(false);
		setSize(900,700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		centerWindow(this);
		this.setLayout(null);
		
		this.player = player;
		this.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.red);
		buttonPanel.setLayout(new FlowLayout (FlowLayout.CENTER));
		
		//Create panel with component placement 
		JPanel componentPanel1 = new JPanel(); 
		componentPanel1.setLayout(new BoxLayout(componentPanel1, BoxLayout.Y_AXIS)); 
		componentPanel1.add(new JLabel("CHOSING THE CHARACTER:"));
		JPanel componentPanel2 = new JPanel(); 
		componentPanel2.setLayout(new BoxLayout(componentPanel2, BoxLayout.Y_AXIS));
		componentPanel2.add(new JLabel("Project by: "));
		componentPanel2.add(new JLabel("Zanyuan Yang"));
		componentPanel2.add(new JLabel("Linhao Xin"));
		componentPanel2.add(new JLabel("Banglun Wu"));

		
		//Use border layout to place panel
		add(componentPanel1, BorderLayout.WEST);
		add(componentPanel2, BorderLayout.EAST);
		
		//set start button
		startButton = new JButton("Start", new ImageIcon("images/StartButton.png"));
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
		
		//set stop button
		stopGameButton = new JButton ("Stop", new ImageIcon("images/stop.jpg"));
		stopGameButton.addActionListener(this);
		buttonPanel.add(stopGameButton);
		
		//set quit button
		quitButton = new JButton ("Quit", new ImageIcon("images/quit.png"));
		quitButton.addActionListener(this);
		buttonPanel.add(quitButton);
		
		//set rank button
		rankButton = new JButton("Rank List:", new ImageIcon("images/rank.jpg"));
		rankButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					
					JOptionPane.showMessageDialog(null, list.toString());
				}
		});		
		buttonPanel.add(rankButton);
		
		
		
		//set score display panel
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(Color.YELLOW);
		buttonPanel.add(scorePanel);
		
		rightClickLabel = new JLabel("Right: ");
		scorePanel.add(rightClickLabel);

		rightButtonTextField = new JTextField(3);
		rightButtonTextField.setEditable(false);
		rightButtonTextField.setFocusable(false);
		scorePanel.add(rightButtonTextField);

		wrongClickLabel = new JLabel("Wrong: ");
		scorePanel.add(wrongClickLabel);


		wrongButtonTextField = new JTextField(3);
		wrongButtonTextField.setEditable(false);
		wrongButtonTextField.setFocusable(false);
		scorePanel.add(wrongButtonTextField);

		this.add(buttonPanel, BorderLayout.SOUTH);
		
		//number panel display 10 numbers
		
		JPanel lettersPanel = new JPanel();
		lettersPanel.setBackground(Color.white);
		lettersPanel.setLayout(new BorderLayout());
		
		JPanel firstPanel1 = new JPanel();
		firstPanel1.setBackground(Color.orange);
		JPanel firstPanel2 = new JPanel();
		firstPanel2.setBackground(Color.orange);
		JPanel firstPanel3 = new JPanel();
		firstPanel3.setBackground(Color.orange);
		JPanel firstPanel4 = new JPanel();
		firstPanel4.setBackground(Color.orange);
		
		ButtonA = new JRadioButton("A"); 
		ButtonB = new JRadioButton("B"); 
		ButtonC = new JRadioButton("C");
		ButtonD = new JRadioButton("D");
		ButtonE = new JRadioButton("E");
		ButtonF = new JRadioButton("F");
		ButtonG = new JRadioButton("G");
		ButtonH = new JRadioButton("H");
		ButtonI = new JRadioButton("I");
		ButtonJ = new JRadioButton("J");
		ButtonK = new JRadioButton("K");
		ButtonL = new JRadioButton("L");
		ButtonM = new JRadioButton("M");
		ButtonN = new JRadioButton("N");
		ButtonO = new JRadioButton("O");
		ButtonP = new JRadioButton("P");
		ButtonQ = new JRadioButton("Q");
		ButtonR = new JRadioButton("R");
		ButtonS = new JRadioButton("S");
		ButtonT = new JRadioButton("T");
		ButtonU = new JRadioButton("U");
		ButtonV = new JRadioButton("V");
		ButtonW = new JRadioButton("W");
		ButtonX = new JRadioButton("X");
		ButtonY = new JRadioButton("Y");
		ButtonZ = new JRadioButton("Z");

		
		firstPanel1.add(ButtonQ);
		firstPanel1.add(ButtonW);
		firstPanel1.add(ButtonE);
		firstPanel1.add(ButtonR);
		firstPanel1.add(ButtonT);
		firstPanel1.add(ButtonY);
		firstPanel1.add(ButtonU);
		firstPanel1.add(ButtonI);
		firstPanel1.add(ButtonO);
		firstPanel1.add(ButtonP);
		
		firstPanel2.add(ButtonA);
		firstPanel2.add(ButtonS);
		firstPanel2.add(ButtonD);
		firstPanel2.add(ButtonF);
		firstPanel2.add(ButtonG);
		firstPanel2.add(ButtonH);
		firstPanel2.add(ButtonJ);
		firstPanel2.add(ButtonK);
		firstPanel2.add(ButtonL);
		
		firstPanel3.add(ButtonZ);
		firstPanel3.add(ButtonX);
		firstPanel3.add(ButtonC);
		firstPanel3.add(ButtonV);
		firstPanel3.add(ButtonB);
		firstPanel3.add(ButtonN);
		firstPanel3.add(ButtonM);	
		
		ButtonGroup paymentGroup = new ButtonGroup(); 
		paymentGroup.add(ButtonA);
		paymentGroup.add(ButtonB);
		paymentGroup.add(ButtonC);
		paymentGroup.add(ButtonD);
		paymentGroup.add(ButtonE);
		paymentGroup.add(ButtonF);
		paymentGroup.add(ButtonG);		
		paymentGroup.add(ButtonH);
		paymentGroup.add(ButtonI);
		paymentGroup.add(ButtonJ);
		paymentGroup.add(ButtonK);
		paymentGroup.add(ButtonL);
		paymentGroup.add(ButtonM);
		paymentGroup.add(ButtonN);	
		paymentGroup.add(ButtonO);
		paymentGroup.add(ButtonP);
		paymentGroup.add(ButtonQ);
		paymentGroup.add(ButtonR);
		paymentGroup.add(ButtonS);
		paymentGroup.add(ButtonT);
		paymentGroup.add(ButtonU);	
		paymentGroup.add(ButtonV);
		paymentGroup.add(ButtonW);
		paymentGroup.add(ButtonX);
		paymentGroup.add(ButtonY);
		paymentGroup.add(ButtonZ);
		
		lettersPanel.add(firstPanel1, BorderLayout.NORTH);
		lettersPanel.add(firstPanel2, BorderLayout.CENTER);
		lettersPanel.add(firstPanel3, BorderLayout.SOUTH);
				
		stopGameButton.setPreferredSize(new java.awt.Dimension(120, 40));
				
		// add listener to the buttons
		this.add(lettersPanel, BorderLayout.NORTH);
		
		ButtonA.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String rl = gp.getLetter(); // get random dropping letter
						matchingLetter(rl, "A");	// compare dropping letter with button leter
						}
				}
			);
		
		ButtonB.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String rl = gp.getLetter(); // get random dropping letter
						matchingLetter(rl, "B");	// compare dropping letter with button leter
						}
				}
			);
		ButtonC.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String rl = gp.getLetter(); // get random dropping letter
						matchingLetter(rl, "C");	// compare dropping letter with button leter
						}
				}
			);
		ButtonE.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String rl = gp.getLetter(); // get random dropping letter
						matchingLetter(rl, "D");	// compare dropping letter with button leter
						}
				}
			);
		ButtonF.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String rl = gp.getLetter(); // get random dropping letter
						matchingLetter(rl, "E");	// compare dropping letter with button leter
						}
				}
			);
		ButtonG.addActionListener(
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter(); // get random dropping letter
					matchingLetter(rl, "G");	// compare dropping letter with button leter
				}
			}

		);
		ButtonH.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "H");
				}
			}
		);
		ButtonI.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "I");
				}
			}
		);
		ButtonJ.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter(); // get random dropping letter
					matchingLetter(rl, "J");	// compare dropping letter with button leter
				}
			}

		);
		ButtonK.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "K");
				}
			}
		);
		ButtonL.addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String rl = gp.getLetter();
								matchingLetter(rl, "L");
							}
						}
		);
		ButtonM.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "M");
				}
			}
		);
		ButtonN.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter(); // get random dropping letter
					matchingLetter(rl, "N");	// compare dropping letter with button leter
				}
			}
		);
		ButtonO.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "O");
				}
			}
		);
		ButtonP.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "P");
				}
			}
		);
		ButtonQ.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter(); // get random dropping letter
					matchingLetter(rl, "Q");	// compare dropping letter with button leter
				}
			}

		);
		ButtonR.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "R");
				}
			}
		);
		ButtonS.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "S");
				}
			}
		);
		ButtonT.addActionListener(
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter(); // get random dropping letter
					matchingLetter(rl, "t");	// compare dropping letter with button leter
				}
			}

		);
		ButtonU.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "U");
				}
			}
		);
		ButtonV.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "V");
				}
			}
		);
		ButtonW.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter(); // get random dropping letter
					matchingLetter(rl, "W");	// compare dropping letter with button leter
				}
			}
		);
		ButtonX.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "X");
				}
			}
		);
		ButtonY.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "Y");
				}
			}
		);
		ButtonZ.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rl = gp.getLetter();
					matchingLetter(rl, "Z");
				}
			}
		);
		
		keySetup(ButtonA);
		keySetup(ButtonB);
		keySetup(ButtonC);
		keySetup(ButtonD);
		keySetup(ButtonE);
		keySetup(ButtonF);
		keySetup(ButtonG);
		keySetup(ButtonH);
		keySetup(ButtonI);
		keySetup(ButtonJ);
		keySetup(ButtonK);
		keySetup(ButtonL);
		keySetup(ButtonM);
		keySetup(ButtonN);
		keySetup(ButtonO);
		keySetup(ButtonP);
		keySetup(ButtonQ);
		keySetup(ButtonR);
		keySetup(ButtonS);
		keySetup(ButtonT);
		keySetup(ButtonU);
		keySetup(ButtonV);
		keySetup(ButtonW);
		keySetup(ButtonX);
		keySetup(ButtonY);
		keySetup(ButtonZ);
		keySetup(startButton);
		keySetup(quitButton);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(Color.white);
		displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		numberTextArea = new JTextArea(300,40);
		numberTextArea.setBackground(Color.white);
		numberTextArea.disable();
		displayPanel.add(numberTextArea);
		this.add(displayPanel,BorderLayout.CENTER);
		
	}
	
	/*
	method: matchingLetter
	purpose: compare dropping letter and button letter that the user selected
			 display message when matching or mismatch
*/
public void matchingLetter(String droppingnumber, String buttonnumber) {
	if(droppingnumber.equalsIgnoreCase(buttonnumber)) {
		try {
				   audioUrl=new URL("file:" + new File(".").getCanonicalPath()
				                                 + "//sounds//win.wav");

		           audioClip=Applet.newAudioClip(audioUrl);
		           audioClip.play();
			   }catch(Exception e){
		            System.out.println(e.toString());
		       }

		JOptionPane.showMessageDialog(null, "GOOD JOB");
		rightButton += 1;
		rightButtonTextField.setText(Integer.toString(rightButton));
		Object source = startButton;
	}
	else {
		//PlaySound ps = new PlaySound("sounds/error.wav");

		try {
				   audioUrl=new URL("file:" + new File(".").getCanonicalPath()
				                                 + "//sounds//lose.wav");

		           audioClip=Applet.newAudioClip(audioUrl);
		           audioClip.play();
			   }catch(Exception e){
		            System.out.println(e.toString());
		       }

		JOptionPane.showMessageDialog(null, "Choosing Wrong Character");
		wrongButton += 1;
		wrongButtonTextField.setText(Integer.toString(wrongButton));
	}

}

public void actionPerformed (ActionEvent e)
{
	Object source = e.getSource();
	if (source == quitButton) {
		System.exit(0);
	}
	
	
	
	else if (source == stopGameButton) {
		gp.stop();
		playerObject = new Player(player,rightButton,wrongButton);
		list.addPlayer(playerObject);
		JOptionPane.showMessageDialog(null, "Thank you " + player + " for playing this game. Your Score is "
										+ rightButton + " right and " + wrongButton + " wrong out of "
										+ GameLetterPanel.nLetterDropped + " character");
		GameLetterPanel.nLetterDropped = 0;
	}
	else if (source == startButton) {
		player = JOptionPane.showInputDialog("Please put your name: ");
		rightButton = 0;
		wrongButton = 0;
		rightButtonTextField.setText(Integer.toString(rightButton));
		wrongButtonTextField.setText(Integer.toString(wrongButton));
		gp = new GameLetterPanel();
		JPanel displayPanel = gp;
		displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(displayPanel, BorderLayout.CENTER);
		Font f = new Font("SansSerif", Font.BOLD, 48);
			numberTextArea.setFont(f);
		
	}
	
}


public void keySetup(Component theCandidate){
	 theCandidate.addKeyListener( new KeyAdapter() {
	      public void keyPressed( KeyEvent ke ) {
	        if (ke.getKeyCode()==ke.VK_A){matchingLetter(gp.getLetter(), "A");}
	        else if (ke.getKeyCode()==ke.VK_B){matchingLetter(gp.getLetter(), "B");}
	        else if (ke.getKeyCode()==ke.VK_C){matchingLetter(gp.getLetter(), "C");}
	        else if (ke.getKeyCode()==ke.VK_D){matchingLetter(gp.getLetter(), "D");}
	        else if (ke.getKeyCode()==ke.VK_E){matchingLetter(gp.getLetter(), "E");}
	        else if (ke.getKeyCode()==ke.VK_F){matchingLetter(gp.getLetter(), "F");}
	        else if (ke.getKeyCode()==ke.VK_G){matchingLetter(gp.getLetter(), "G");}
	        else if (ke.getKeyCode()==ke.VK_H){matchingLetter(gp.getLetter(), "H");}
	        else if (ke.getKeyCode()==ke.VK_I){matchingLetter(gp.getLetter(), "I");}
	        else if (ke.getKeyCode()==ke.VK_J){matchingLetter(gp.getLetter(), "J");}
	        else if (ke.getKeyCode()==ke.VK_K){matchingLetter(gp.getLetter(), "K");}
	        else if (ke.getKeyCode()==ke.VK_L){matchingLetter(gp.getLetter(), "L");}
	        else if (ke.getKeyCode()==ke.VK_M){matchingLetter(gp.getLetter(), "M");}
	        else if (ke.getKeyCode()==ke.VK_N){matchingLetter(gp.getLetter(), "N");}
	        else if (ke.getKeyCode()==ke.VK_O){matchingLetter(gp.getLetter(), "O");}
	        else if (ke.getKeyCode()==ke.VK_P){matchingLetter(gp.getLetter(), "P");}
	        else if (ke.getKeyCode()==ke.VK_Q){matchingLetter(gp.getLetter(), "Q");}
	        else if (ke.getKeyCode()==ke.VK_R){matchingLetter(gp.getLetter(), "R");}
	        else if (ke.getKeyCode()==ke.VK_S){matchingLetter(gp.getLetter(), "S");}
	        else if (ke.getKeyCode()==ke.VK_T){matchingLetter(gp.getLetter(), "T");}
	        else if (ke.getKeyCode()==ke.VK_U){matchingLetter(gp.getLetter(), "U");}
	        else if (ke.getKeyCode()==ke.VK_V){matchingLetter(gp.getLetter(), "V");}
	        else if (ke.getKeyCode()==ke.VK_W){matchingLetter(gp.getLetter(), "W");}
	        else if (ke.getKeyCode()==ke.VK_X){matchingLetter(gp.getLetter(), "X");}
	        else if (ke.getKeyCode()==ke.VK_Y){matchingLetter(gp.getLetter(), "Y");}
	        else if (ke.getKeyCode()==ke.VK_Z){matchingLetter(gp.getLetter(), "Z");};
	      };
	    } );
}

private void centerWindow (Window w)
{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	setLocation((d.width - w.getWidth())/2, (d.height - w.getHeight())/2);
}
	

}
