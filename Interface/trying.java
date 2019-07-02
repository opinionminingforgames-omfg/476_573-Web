import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  

public class trying {  
	

	private JFrame f;
    private JTextArea textArea;
    private JMenu games;
    
    String[] words = {"good", "awesome", "great", "bad", "sucks", "terrible" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trying window = new trying();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public trying() {
		initialize();
	}

	private void initialize() {
		f = new JFrame();
	    textArea = new JTextArea();
		f.setTitle("G.E.S.");
		f.setBounds(100, 100, 1196, 549);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		f.setJMenuBar(menuBar);
		
		games = new JMenu("GAMES");
		games.setForeground(Color.GREEN);
		games.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(games);
		
		JMenuItem asphalt = new JMenuItem("Asphalt 8 Airbone");
		asphalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				test t = new test();
			}
		});
		
		games.add(asphalt);
		
		JMenuItem lol = new JMenuItem("League Of Legends");
		
		games.add(lol);

		JMenuItem fort = new JMenuItem("Fortnite");
		
		games.add(fort);
		
		JMenuItem cod = new JMenuItem("Call Of Duty 3");
				
		games.add(cod);
		
		JMenuItem crys = new JMenuItem("Crysis 3");
				
		games.add(crys);
		
		JButton asp = new JButton("Add Games");
		asp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame f = new JFrame();
			    JTextField gtba = new JTextField();
				f.setTitle("G.E.S.");
				f.setBounds(100, 100, 520, 240);
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.getContentPane().setLayout(null);
				
				gtba.setForeground(Color.BLACK);
				gtba.setFont(new Font("MV Boli", Font.BOLD, 12));
				gtba.setBackground(SystemColor.text);
				gtba.setBounds(10, 52, 472, 21);
			
				f.getContentPane().add(gtba);
				
				JButton submit = new JButton("Submit");
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String tmp = gtba.getText();
						if(tmp.length()>0) {
							JMenuItem newi = new JMenuItem(tmp);
						
						    games.add(newi); }
						f.dispose();
					}
				});
				submit.setFont(new Font("Segoe UI", Font.BOLD, 13));
				submit.setForeground(Color.GREEN);
				submit.setBounds(300, 112, 90, 23);
				f.getContentPane().add(submit);
			
				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						f.dispose();
					}
				});
				cancel.setFont(new Font("Segoe UI", Font.BOLD, 13));
				cancel.setForeground(Color.RED);
				cancel.setBounds(395, 112, 90, 23);
				f.getContentPane().add(cancel);
				
				JLabel bgi= new JLabel("bg");
				bgi.setFont(new Font("Segoe UI", Font.BOLD, 13));
				bgi.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\About Me\\eclipse-ws\\Opinion Mining For Games\\OMBG.png"));
				bgi.setBounds(0, 0, 580, 510);
				
			    f.getContentPane().add(bgi);
				f.setVisible(true);
			}
		});
		asp.setFont(new Font("Segoe UI", Font.BOLD, 13));
		asp.setForeground(Color.BLACK);
		asp.setBounds(1000, 0, 130, 23);
		menuBar.add(asp);
		
		JLabel bg= new JLabel("bg");
		bg.setFont(new Font("Segoe UI", Font.BOLD, 13));
		bg.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\About Me\\eclipse-ws\\Opinion Mining For Games\\OMBG.png"));
		bg.setBounds(0, 0, 1180, 510);
		
		f.getContentPane().add(bg);
	}
}