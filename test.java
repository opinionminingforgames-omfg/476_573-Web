import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test {

	private JFrame frmFifo;
    private JTextArea textArea;
    String[] words = {"good", "awesome", "great", "bad", "sucks", "terrible" };
    private JTable table;
    private DefaultTableModel dtm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmFifo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFifo = new JFrame();
		frmFifo.setVisible(true);
	    textArea = new JTextArea();
		frmFifo.setTitle("Asphalt");
		frmFifo.setBounds(100, 100, 596, 549);
		frmFifo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFifo.getContentPane().setLayout(null);
		
		int res = 0;
		
		JLabel lblWhatDoPlayers = new JLabel("What do players think about Asphalt ?");
		lblWhatDoPlayers.setForeground(Color.YELLOW);
		lblWhatDoPlayers.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblWhatDoPlayers.setBounds(10, 28, 252, 14);
		frmFifo.getContentPane().add(lblWhatDoPlayers);
		
		JLabel rating = new JLabel("RATED: " + String.valueOf(res) + " /5");
		rating.setFont(new Font("Segoe UI", Font.BOLD, 13));
		rating.setBounds(443, 100, 114, 23);
		rating.setForeground(Color.BLUE);
		frmFifo.getContentPane().add(rating);
		
		JButton btnNewButton = new JButton("COMMENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame f = new JFrame();
				
				f.setTitle("Comment On Asphalt");
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
						if(tmp.length()>0)
							textArea.append("user x said "+ tmp +"\n");
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
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\About Me\\eclipse-ws\\Opinion Mining For Games\\Asphalt.png"));
				lblNewLabel.setBounds(0, 0, 500, 205);
				f.getContentPane().add(lblNewLabel);
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(443, 70, 114, 23);
		frmFifo.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 412, 41);
		frmFifo.getContentPane().add(scrollPane);
		
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("MV Boli", Font.BOLD, 12));
		scrollPane.setViewportView(textArea);
		textArea.setBackground(SystemColor.text);
		textArea.setEditable(false);
		
		
		int i=0;
		for(i = 0; i< 10; i++) {
			
			int no = (int)(Math.random()*(words.length-1)) + 1;
			String w = words[no];
			textArea.append("user " + (i+1) + " said " + ""+ w + "\n");			
		}
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 98, 412, 87);

		table = new JTable();
		scrollPane2.add(table);
		String[][] columns = {{}, {}, {}, {}};
		String[] rows = {"Treat To Beginners", "Stability", "Events"};
		dtm = new DefaultTableModel(columns, rows);
		table.setModel(dtm);
		scrollPane2.setViewportView(table);
		frmFifo.getContentPane().add(scrollPane2);

		JLabel bg = new JLabel("bg");
		bg.setFont(new Font("Segoe UI", Font.BOLD, 13));
		bg.setIcon(new ImageIcon("C:\\Users\\star\\Desktop\\About Me\\eclipse-ws\\Opinion Mining For Games\\Asphalt.png"));
		bg.setBounds(0, 0, 580, 510);
		frmFifo.getContentPane().add(bg);
	}
}
