import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.*;  

public class LoginScreen { 

	private JFrame f;
	private JFrame asph;
    private JTextArea textArea;
	private JMenu games;
    int auth = 0;
    private ArrayList<User> users;
    private ArrayList<Admin> admin;
    private ArrayList<Game> game;
    private Game cG;
    private User cU;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginScreen() {
		initialize();
	}
	
	private void initialize() {
		
		if(auth == 0) {
			
			String directory = "C:\\Users\\star\\Desktop";
			String uf = "users.txt";
			String absPthU = directory + File.separator + uf;
			users  = new ArrayList<User>();
			
			String af = "admins.txt";
			String absPthA = directory + File.separator + af;
			admin = new ArrayList<Admin>();
			
			String gf = "games.txt";
			String absPthG = directory + File.separator + gf;
			game = new ArrayList<Game>();
			
	        try {
	            String line;
	            BufferedReader br = Files.newBufferedReader(Paths.get(absPthU));
	            while ((line = br.readLine()) != null) {
	            	if(line.length() > 0) {
		            	String u = line.substring(0, line.indexOf(" "));
		            	String p = line.substring(line.indexOf("pswd: ") + 6, line.indexOf("interests = {")-1);
		            	String i = line.substring(line.indexOf("interests = {"), line.length()-1);
		            	
		            	User us = new User(u, p, i);
		            	users.add(us);
	            	}
	            }
	            	            
	            br = Files.newBufferedReader(Paths.get(absPthA));
	            while ((line = br.readLine()) != null) {
	            	if(line.length() > 0) {
		            	String u = line.substring(0, line.indexOf(" "));
		            	String p = line.substring(line.indexOf("pswd: ") + 6, line.indexOf("interests = {")-1);
		            	String i = line.substring(line.indexOf("interests = {"), line.length()-1);
		            	
		            	Admin us = new Admin(u, p, i);
		            	admin.add(us);
	            	}
	            }
	            
	            br = Files.newBufferedReader(Paths.get(absPthG));
	            while ((line = br.readLine()) != null) {
	            	if(line.length() > 0) {
		            	String name = line.substring(0, line.indexOf("C:\\\\"));
		            	String genres = line.substring(line.indexOf("Genres = {") + 10, line.indexOf("Content = {")-2);
		            	String con = line.substring(line.indexOf("Content = {")+ 11, line.length() -1);
		     
		            	Game g = new Game(name, genres, 3, con);
		            	game.add(g);
	            	}
	            }
	            br.close();
	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
				        
		    f = new JFrame();
		    JTextField uname = new JTextField();
		    JTextField pswd = new JTextField();
			f.setTitle("G.E.S. Login Screen");
			f.setBounds(100, 100, 620, 240);
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.getContentPane().setLayout(null);
			
			uname.setForeground(Color.BLACK);
			uname.setFont(new Font("MV Boli", Font.BOLD, 12));
			uname.setBackground(SystemColor.text);
			uname.setBounds(112, 52, 372, 21);
		
			f.getContentPane().add(uname);
			
			pswd.setForeground(Color.BLACK);
			pswd.setFont(new Font("MV Boli", Font.BOLD, 12));
			pswd.setBackground(SystemColor.text);
			pswd.setBounds(112, 82, 372, 21);
		
			f.getContentPane().add(pswd);
			
			JButton submit = new JButton("Submit");
			submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String un = uname.getText();
					String pw = pswd.getText();
					int i = 0;
					
					if(un.length()>0 && pw.length()>0) {
						for(i=0; i< admin.size(); i++) 
							if(un.equals(admin.get(i).getUname()))
								if(pw.equals(admin.get(i).getPswd())) {
									auth = 1;
									cU = admin.get(i);
									initialize();
									break;
								}
								else break; 
						if(auth!=1) {
							for(i=0; i< users.size(); i++) 
								if(un.equals(users.get(i).getUname()))
									if(pw.equals(users.get(i).getPswd())) {
										auth = -1;
										cU = users.get(i);
										initialize();
										break;
									}
									else break; 
						}
					}
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
			bgi.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\WorkSpaces\\eclipse-ws\\Opinion Mining For Games\\OMBG.png"));
			bgi.setBounds(0, 0, 610, 510);
			
		    f.getContentPane().add(bgi);
			f.setVisible(true);
		}
		else if(auth == 1 ) {
			auth = 0;
			f = new JFrame();
			f.setTitle("G.E.S.");
			f.setBounds(100, 100, 1196, 549);
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.getContentPane().setLayout(null);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(Color.BLACK);
			f.setJMenuBar(menuBar);
			
			games = new JMenu("Games");
			games.setForeground(Color.GREEN);
			games.setFont(new Font("Segoe UI", Font.BOLD, 13));
			menuBar.add(games);
			
			String directory = "C:\\Users\\star\\Desktop";
			String fileName = "games.txt";
			String absPth = directory + File.separator + fileName;
			
	        try (BufferedReader br = Files.newBufferedReader(Paths.get(absPth))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	if(line.length() > 0) {
		            	String name = line.substring(0, line.indexOf("C:\\\\")-1);
		            	String p2p = line.substring(line.indexOf("C:\\\\"), line.indexOf("Genres = {"));
		            	String genres = line.substring(line.indexOf("Genres = {") + 10, line.indexOf("Content = {")-2);
		            	String content = line.substring(line.indexOf("Content = {")+ 11, line.length()-1);
		            	
		                createGame(name, p2p, genres, content);
	            	}
	            }
	            br.close();
	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
			
			JButton addg = new JButton("Add Games");
			addg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JFrame f = new JFrame();
					f.setTitle("Adding Game");
					f.setBounds(100, 100, 600, 340);
					f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					f.getContentPane().setLayout(null);
					
					JTextField gtba = new JTextField();
					gtba.setForeground(Color.BLACK);
					gtba.setFont(new Font("MV Boli", Font.BOLD, 12));
					gtba.setBackground(SystemColor.text);
					gtba.setBounds(80, 52, 472, 21);
					
					JLabel name = new JLabel("Name");
					name.setFont(new Font("Segoe UI", Font.BOLD, 13));
					name.setBounds(5, 52, 80, 23);
					name.setForeground(Color.yellow);
				
					f.getContentPane().add(gtba);
					f.getContentPane().add(name);
					
					JTextField gtba2 = new JTextField();
					gtba2.setForeground(Color.BLACK);
					gtba2.setFont(new Font("MV Boli", Font.BOLD, 12));
					gtba2.setBackground(SystemColor.text);
					gtba2.setBounds(80, 82, 472, 21);
				
					JLabel pic = new JLabel("Path to Picture");
					pic.setFont(new Font("Segoe UI", Font.BOLD, 13));
					pic.setBounds(5, 82, 80, 23);
					pic.setForeground(Color.yellow);
				
					f.getContentPane().add(gtba2);
					f.getContentPane().add(pic);
					
					JTextField gtba3 = new JTextField();
					gtba3.setForeground(Color.BLACK);
					gtba3.setFont(new Font("MV Boli", Font.BOLD, 12));
					gtba3.setBackground(SystemColor.text);
					gtba3.setBounds(80, 112, 472, 21);
				
					JLabel genre = new JLabel("Genres");
					genre.setFont(new Font("Segoe UI", Font.BOLD, 13));
					genre.setBounds(5, 112, 80, 23);
					genre.setForeground(Color.yellow);
				
					f.getContentPane().add(gtba3);
					f.getContentPane().add(genre);
					
					JTextField gtba4 = new JTextField();
					gtba4.setForeground(Color.BLACK);
					gtba4.setFont(new Font("MV Boli", Font.BOLD, 12));
					gtba4.setBackground(SystemColor.text);
					gtba4.setBounds(80, 142, 472, 21);
				
					JLabel content = new JLabel("Content");
					content.setFont(new Font("Segoe UI", Font.BOLD, 13));
					content.setBounds(5, 142, 80, 23);
					content.setForeground(Color.yellow);
				
					f.getContentPane().add(gtba4);
					f.getContentPane().add(content);
					
					JButton submit = new JButton("Submit");
					submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String name = gtba.getText();
							String p2p = gtba2.getText();
							String genres = gtba3.getText();
							String info = gtba4.getText();
							
							createGame(name, p2p, genres, info);
							FileWriter fw;
							
							try {
					                fw = new FileWriter(absPth, true);
					                fw.append("\r\n" + name + " " +p2p +" Genres = {"+ genres + "}" +" Content = {"+ info + "}" );
						            fw.close();
						            
					        } catch (IOException e) {
					            System.err.format("IOException: %s%n", e);
					        } 
							
							f.dispose();
						}
					});
					submit.setFont(new Font("Segoe UI", Font.BOLD, 13));
					submit.setForeground(Color.GREEN);
					
					submit.setBounds(365, 172, 90, 23);
					f.getContentPane().add(submit);
				
					JButton cancel = new JButton("Cancel");
					cancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							f.dispose();
						}
					});
					cancel.setFont(new Font("Segoe UI", Font.BOLD, 13));
					cancel.setForeground(Color.RED);
					cancel.setBounds(460, 172, 90, 23);
					f.getContentPane().add(cancel);
					
					JLabel bgi= new JLabel("bg");
					bgi.setFont(new Font("Segoe UI", Font.BOLD, 13));
					bgi.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\WorkSpaces\\eclipse-ws\\Opinion Mining For Games\\OMBG.png"));
					bgi.setBounds(0, 0, 580, 510);
					
				    f.getContentPane().add(bgi);
					f.setVisible(true);
				}
			});
			addg.setFont(new Font("Segoe UI", Font.BOLD, 13));
			addg.setForeground(Color.GREEN);
			addg.setBackground(Color.BLACK);
			addg.setBounds(1000, 0, 130, 23);
			menuBar.add(addg);
			
			JLabel bg= new JLabel("bg");
			bg.setFont(new Font("Segoe UI", Font.BOLD, 13));
			bg.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\WorkSpaces\\eclipse-ws\\Opinion Mining For Games\\OMBG.png"));
			bg.setBounds(0, 0, 1180, 510);
			
			f.getContentPane().add(bg);
			f.setVisible(true);
		}
		else if(auth == -1){
			
			auth = 0;
			f = new JFrame();
			f.setTitle("G.E.S.");
			f.setBounds(100, 100, 1196, 549);
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.getContentPane().setLayout(null);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(Color.BLACK);
			f.setJMenuBar(menuBar);
			
			games = new JMenu("Games");
			games.setForeground(Color.GREEN);
			games.setFont(new Font("Segoe UI", Font.BOLD, 13));
			menuBar.add(games);
			
			String directory = "C:\\Users\\star\\Desktop";
			String fileName = "games.txt";
			String absPth = directory + File.separator + fileName;

	        try (BufferedReader br = Files.newBufferedReader(Paths.get(absPth))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	if(line.length() > 0) {
		            	String name = line.substring(0, line.indexOf("C:\\\\")-1);
		            	String p2p = line.substring(line.indexOf("C:\\\\"), line.indexOf("Genres = {"));
		            	String genres = line.substring(line.indexOf("Genres = {") +10, line.indexOf("Content = {")-2);
		            	String content = line.substring(line.indexOf("Content = {")+ 11, line.length()-1);
		            	
		                createGame(name, p2p, genres, content);
	            	}
	            }
	            br.close();
	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
			
			JLabel bg= new JLabel("bg");
			bg.setFont(new Font("Segoe UI", Font.BOLD, 13));
			bg.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\WorkSpaces\\eclipse-ws\\Opinion Mining For Games\\OMBG.png"));
			bg.setBounds(0, 0, 1180, 510);
			
			f.getContentPane().add(bg);
			f.setVisible(true);
		}
	}
	
	private void createGame(String name, String p2p, String genres, String content) {

		Game ga = new Game(name, genres, 0.0, content);
		game.add(ga);
		
		textArea = new JTextArea();
		String directory = "C:\\Users\\star\\Desktop";
		String cf = "comments.txt";
		String absPthC = directory + File.separator + cf;
		
		JMenuItem crys = new JMenuItem(name);
		crys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cG = ga;
				cG.comments = (ArrayList<Comment>)ga.comments.clone();
		        try {
		            String line;
		            BufferedReader br = Files.newBufferedReader(Paths.get(absPthC));
		            while ((line = br.readLine()) != null) {
		            	if(line.length() > 0) {
			            	String content = line.substring(11, line.indexOf("ofGame")-2);
			            	String g = line.substring(line.indexOf("ofGame = ") + 9, line.indexOf("ofUser")-1);
			            	String u = line.substring(line.indexOf("ofUser = ") + 9, line.length());
			            	
			            	Comment com = new Comment(g, u, content);
			            	if(ga.getName().equals(g)) {
			            		textArea.append(u + " said " +com.getContent() + "\n");
			            		ga.comments.add(com);
			            	}
			            	if(cU.getUname().equals(u)) 
			            		cU.comments.add(com);
			            	
		            	}
		            }}catch (IOException e) { 
		            	System.err.format("IOException: %s%n", e);
		            }
		        
				asph = new JFrame();
				asph.setVisible(true);
				asph.setTitle(name);
				asph.setBounds(100, 100, 596, 549);
				asph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				asph.getContentPane().setLayout(null);
				
				int res = 0;
				
				JLabel lblWhatDoPlayers = new JLabel("What do players think about " + name+" ?");
				lblWhatDoPlayers.setForeground(Color.YELLOW);
				lblWhatDoPlayers.setFont(new Font("Segoe UI", Font.BOLD, 13));
				lblWhatDoPlayers.setBounds(10, 28, 252, 14);
				asph.getContentPane().add(lblWhatDoPlayers);
				
				JLabel rating = new JLabel("RATED: " + String.valueOf(res) + " /5");
				rating.setFont(new Font("Segoe UI", Font.BOLD, 13));
				rating.setBounds(285, 25, 114, 23);
				rating.setForeground(Color.BLUE);
				asph.getContentPane().add(rating);
				
				String g = "";
				for(int i=0; i< game.size(); i++)
					if(name.equals(game.get(i).getName())) 
						g = game.get(i).getGenres();
				
				JLabel genres = new JLabel("Genre: " + g);
				genres.setFont(new Font("Segoe UI", Font.BOLD, 13));
				genres.setBounds(10, 105, 175, 23);
				genres.setForeground(Color.YELLOW);
				asph.getContentPane().add(genres);
				
				String c = "";
				for(int i=0; i< game.size(); i++)
					if(name.equals(game.get(i).getName())) 
						c = game.get(i).getContent();
				
				JLabel con = new JLabel("Content: " + c);
				con.setFont(new Font("Segoe UI", Font.BOLD, 13));
				con.setBounds(10, 115, 374, 100);
				con.setForeground(Color.YELLOW);
				asph.getContentPane().add(con);
								
				JButton btnNewButton = new JButton("COMMENT");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						JFrame f = new JFrame();
						
						f.setTitle("Comment On " + name);
						f.setBounds(100, 100, 520, 240);
						f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						f.getContentPane().setLayout(null);
						f.setVisible(true);
						f.setBackground(Color.WHITE);
						
						JTextField tf = new JTextField();
						tf.setForeground(Color.BLACK);
						tf.setFont(new Font("MV Boli", Font.BOLD, 12));
						tf.setBackground(SystemColor.text);
						tf.setBounds(10, 52, 472, 21);
						f.getContentPane().add(tf);
						
						JButton done = new JButton("Done");
						done.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String tmp = tf.getText();
								if(tmp.length()>0) {
									textArea.append(cU.getUname() + " said "+ tmp +"\n");
									Comment c = new Comment(cG.getName(), cU.getUname(), tmp);
									cU.comments.add(c);
									cG.comments.add(c);
									
									FileWriter fw;
									
									try {
							                fw = new FileWriter(absPthC, true);
							                fw.append("\r\nContent = {" +tmp+ "} " + "ofGame = " +cG.getName() + " ofUser = " +
							                			cU.getUname());
								            fw.close();
								            
							        } catch (IOException e) {
							            System.err.format("IOException: %s%n", e);
							        } 
								}
								f.dispose();
							}
						});
						done.setFont(new Font("Segoe UI", Font.BOLD, 13));
						done.setForeground(Color.GREEN);
						done.setBounds(300, 112, 90, 23);
						f.getContentPane().add(done);
					
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
						
						JLabel lblNewLabel = new JLabel("New label");
						lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
						lblNewLabel.setIcon(new ImageIcon(p2p));
						lblNewLabel.setBounds(0, 0, 500, 205);
						f.getContentPane().add(lblNewLabel);
						
					}
				});
				btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
				btnNewButton.setForeground(Color.RED);
				btnNewButton.setBounds(443, 52, 114, 23);
				asph.getContentPane().add(btnNewButton);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 52, 412, 41);
				asph.getContentPane().add(scrollPane);
				
				textArea.setForeground(Color.BLACK);
				textArea.setFont(new Font("MV Boli", Font.BOLD, 12));
				scrollPane.setViewportView(textArea);
				textArea.setBackground(SystemColor.text);
				textArea.setEditable(false);
				
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setBounds(10, 98, 412, 87);

				JLabel bg = new JLabel("bg");
				bg.setFont(new Font("Segoe UI", Font.BOLD, 13));
				bg.setIcon(new ImageIcon(p2p));
				bg.setBounds(0, 0, 580, 510);
				asph.getContentPane().add(bg);
			}
		});
		games.add(crys);
	}
}