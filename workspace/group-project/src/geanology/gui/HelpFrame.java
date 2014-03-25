package geanology.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class HelpFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8519371621931567692L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpFrame frame = new HelpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelpFrame() {
		super("Budweis Geneology Search Engine");
		setResizable(false);
		setTitle("Help - Budweis Geneology");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/sam/Desktop/budweis.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 378, 193);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new TitledBorder(null, "Help", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[289px,grow]", "[15px][15px,grow][25px,grow][][][]"));
				
				JTextPane txtrEnterSearchTerms = new JTextPane();
				txtrEnterSearchTerms.setEditable(false);
				txtrEnterSearchTerms.setText("Enter search terms in the above fields to return a list of persons matching the criteria from the database. \n\nClick the 'Add Person' button add a new entry to the database.");
				txtrEnterSearchTerms.setBackground(SystemColor.window);
				contentPane.add(txtrEnterSearchTerms, "cell 0 1 1 2,alignx center,aligny center");
				
						JButton btnCancel = new JButton("OK");
						btnCancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							}
						});
						btnCancel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent event) {
								setVisible(false);															//need to add method to make sure action isn't carried out
							}
						});
						contentPane.add(btnCancel, "cell 0 4,alignx center,aligny top");
	}
}
