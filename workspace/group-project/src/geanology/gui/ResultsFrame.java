package geanology.gui;

import geanology.packets.Packet;
import geanology.packets.Person;
import geanology.packets.requests.SearchForPersonRequest;
import geanology.packets.responses.SearchForPersonResponse;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;

public class ResultsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2978255820270824608L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//create window for results
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsFrame frame = new ResultsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private boolean DEBUG = false;
	
	/**
	 * Method to add entry to database.
	 */
	public void addPerson(){
				
	}

	/**
	 * Create the frame.
	 */
	public ResultsFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/sam/Desktop/budweis.png"));
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new TitledBorder(null, "Search Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		String[] columnNames = {"Person ID",
                "First Name",
                "Last Name",
                "Date of birth",
                "Place of birth",
                "Mother ID",
                "Father ID",
                "Child ID",
                "Date of death",
                "Place of death",
                "Biography"};
		Object[][] data = {
		{"116", "Susan",
		"Jeffreys", "1990/05/19", "London, UK", "102", "109",
		"", "", "", "Student at the University of Birmingham"},
		{"245", "Robert",
		"McGovern", "1978/02/12", "Glasgow, UK", "", "",
		"", "2005/01/14", "London, UK", ""},
		{"354", "Roger",
		"Pearce", "1984/11/03", "Lincoln, UK", "192", "182",
		"", "", "", ""},
		{"578", "Mick",
		"Hill", "1965/04/25", "Pembroke, UK", "", "168",
		"724","", "", "Lecturer at University"},
		{"872", "Elena",
		"Clancy", "1975/05/13", "Cork, Ireland", "149", "198",
		"948", "", "", ""},
		{"529", "Anushka",
			"Puri", "1992/02/18", "Kolkata, India", "", "",
			"", "", "", "Exchange student"}
		};
		
		
		table = new JTable(data, columnNames);
		contentPane.add(table, "cell 0 1,grow");
		table.setPreferredScrollableViewportSize(new Dimension(1050, 114));
	    table.setFillsViewportHeight(true);
	    table.setAutoCreateRowSorter(true);
	    table.getRowSorter().toggleSortOrder(0);
	    
	    JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SearchFrame frame = new SearchFrame();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewSearch, "cell 0 8");
		

	    
	    if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        
        setTitle("Search results");
        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
	
	public static Packet getResponseForRequest(Packet request) {
		Socket socket = null;
		try {
		socket = new Socket("localhost", 5678);// localhost because
		// we're connecting
		// to the local
		// computer and 5678
		// because this is
		// the port number
		// of the server

		ObjectOutputStream outputStream = new ObjectOutputStream(
		socket.getOutputStream());
		ObjectInputStream inputStream = new ObjectInputStream(
		socket.getInputStream());

		// send the request object to the server
		outputStream.writeObject(request);

		// get our response packet from the server
		Packet response = (Packet) inputStream.readObject();

		socket.close();

		// return this response packet
		return response;

		} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} finally {
		try {
		socket.close();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		return null;// if everything fails, return null
		}

	
	
	}
