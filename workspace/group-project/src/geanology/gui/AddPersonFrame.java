package geanology.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JFormattedTextField;

public class AddPersonFrame extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4837965865478419141L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPersonFrame frame = new AddPersonFrame();
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
	public AddPersonFrame() {
		super("Add Person");
		setTitle("Add Person - Budweis Geneology ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/sam/Desktop/budweis.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 555, 399);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setToolTipText("");
		contentPane.setBorder(new TitledBorder(null, "Add Person", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[107px][114px,grow][]", "[19px][15px][15px][15px][15px][][][][][][][][grow][grow]"));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblName, "cell 0 0,alignx left,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname:");
		contentPane.add(lblSurname, "cell 0 1,alignx left,aligny center");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setToolTipText("Must be a unique entry in the database.");
		contentPane.add(lblId, "cell 0 2,alignx left,aligny center");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblPlaceOfBirth = new JLabel("Date of birth:");
		contentPane.add(lblPlaceOfBirth, "cell 0 3,alignx left,aligny center");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 3,growx");
		textField_3.setColumns(10);
		
		JLabel lblPlaceOfDeath = new JLabel("Place of birth:");
		contentPane.add(lblPlaceOfDeath, "cell 0 4,alignx left");
		
		textField_4 = new JTextField();
		contentPane.add(textField_4, "cell 1 4,growx");
		textField_4.setColumns(10);
		
		JLabel lblMotherId = new JLabel("Mother ID:");
		lblMotherId.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblMotherId, "cell 0 5,alignx left");
		
		textField_5 = new JTextField();
		contentPane.add(textField_5, "cell 1 5,growx");
		textField_5.setColumns(10);
		
		JLabel lblFatherId = new JLabel("Father ID:");
		contentPane.add(lblFatherId, "cell 0 6,alignx left");
		
		textField_6 = new JTextField();
		contentPane.add(textField_6, "cell 1 6,growx");
		textField_6.setColumns(10);
		
		JLabel lblChildId = new JLabel("Child ID:");
		contentPane.add(lblChildId, "cell 0 7,alignx left");
		
		textField_7 = new JTextField();
		contentPane.add(textField_7, "cell 1 7,growx");
		textField_7.setColumns(10);
		
		JLabel lblDateOfDeath = new JLabel("Date of death:");
		contentPane.add(lblDateOfDeath, "cell 0 8,alignx left");
		
		textField_8 = new JTextField();
		contentPane.add(textField_8, "cell 1 8,growx");
		textField_8.setColumns(10);
		
		JLabel lblPlaceOfDeath_1 = new JLabel("Place of death:");
		contentPane.add(lblPlaceOfDeath_1, "cell 0 9,alignx trailing");
		
		textField_9 = new JTextField();
		contentPane.add(textField_9, "cell 1 9,growx");
		textField_9.setColumns(10);
		
		JButton btnDelete = new JButton("Cancel");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnEdit = new JButton("Add");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultsFrame results = new ResultsFrame();
				results.addPerson();
			}
		});
		
		JLabel lblBiography = new JLabel("Biography:");
		lblBiography.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblBiography, "cell 0 10,alignx left");
		
		textField_10 = new JTextField();
		contentPane.add(textField_10, "cell 1 10,growx");
		textField_10.setColumns(10);
		contentPane.add(btnEdit, "cell 2 12,growx");
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setForeground(new Color(0, 0, 255));
		contentPane.add(lblHelp, "cell 0 13");
		contentPane.add(btnDelete, "cell 2 13");
	}

}
