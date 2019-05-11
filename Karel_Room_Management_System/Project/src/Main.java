import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main {

	private JFrame frame;
	public String karel;
	public String date;
	public String hour;
	public String karel_c;
	public String date_c;
	public String hour_c;
	public String name;
	public String id;
	public ArrayList<String> karelList = new ArrayList<String>();
	public ArrayList<String> dateList = new ArrayList<String>();
	public ArrayList<String> hourList = new ArrayList<String>();
	public ArrayList<String> nameList = new ArrayList<String>();
	public ArrayList<String> idList = new ArrayList<String>();

	public int counter = 0;
	private JTable tableBooking;
	private JTextField txtName;
	private JTextField txtId;
	
	
	
	 public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void FillData() {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Room");
		defaultTableModel.addColumn("Date");
		defaultTableModel.addColumn("Time");
		defaultTableModel.addColumn("Full Name");
		defaultTableModel.addColumn("Student ID");		
		for(int i=0; i<counter; i++)
		defaultTableModel.addRow(new Object[] {karelList.get(i).toString(), dateList.get(i).toString(), hourList.get(i).toString(), nameList.get(i).toString(), idList.get(i).toString()});
		tableBooking.setModel(defaultTableModel);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Karel Room Management System");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 483, 365);
		frame.getContentPane().add(tabbedPane);
		
		JLabel jLabel1 = new JLabel();
		

		
				JPanel panel = new JPanel();
				tabbedPane.addTab("New Booking", null, panel, null);
				panel.setLayout(null);
				
			
				

				
						JComboBox boxKarel = new JComboBox();
						boxKarel.setToolTipText("");
						boxKarel.setBounds(10, 70, 120, 50);
						panel.add(boxKarel);
						
						
						
								JComboBox boxHour = new JComboBox();
								boxHour.setToolTipText("");
								boxHour.setBounds(333, 70, 120, 50);
								panel.add(boxHour);
								
								

									JButton btnNewButton = new JButton("Book");
									btnNewButton.setBounds(140, 255, 180, 50);
									panel.add(btnNewButton);
									
											JLabel lblNewLabel = new JLabel("Karel Room Booking");
											lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
											lblNewLabel.setBounds(140, 31, 180, 20);
											panel.add(lblNewLabel);
											
													
													//for (int i = 1; i<=5; i++) {
														//boxKarel.addItem(i);
												//	}
													
													boxKarel.addItem("1. Karel Room");
													boxKarel.addItem("2. Karel Room");
													boxKarel.addItem("3. Karel Room");
													boxKarel.addItem("4. Karel Room");
													boxKarel.addItem("5. Karel Room");
													
													JDateChooser dateChooser = new JDateChooser();
													dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
														public void propertyChange(PropertyChangeEvent arg0) {
														}
													});
													dateChooser.setBounds(138, 70, 182, 50);
													panel.add(dateChooser);
													
													JLabel lblPersonalInformation = new JLabel("Personal Information");
													lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
													lblPersonalInformation.setBounds(140, 150, 180, 20);
													panel.add(lblPersonalInformation);
													
													txtName = new JTextField();
													txtName.setText("Full Name");
													txtName.setBounds(10, 191, 229, 31);
													panel.add(txtName);
													txtName.setColumns(10);
													
													txtId = new JTextField();
													txtId.setText("Student ID");
													txtId.setColumns(10);
													txtId.setBounds(249, 191, 204, 31);
													panel.add(txtId);
													
													JPanel panel_2 = new JPanel();
													tabbedPane.addTab("Book Cancellation", null, panel_2, null);
													panel_2.setLayout(null);
													
													JComboBox boxKarel_c = new JComboBox();
													boxKarel_c.setToolTipText("");
													boxKarel_c.setBounds(10, 71, 120, 50);
													panel_2.add(boxKarel_c);
													
													JDateChooser dateChooser_c = new JDateChooser();
													dateChooser_c.setBounds(138, 71, 182, 50);
													panel_2.add(dateChooser_c);
													
													JComboBox boxHour_c = new JComboBox();
													boxHour_c.setToolTipText("");
													boxHour_c.setBounds(333, 71, 120, 50);
													panel_2.add(boxHour_c);
													
													for (int i=8; i<20; i++) {

														boxHour_c.addItem(i + ".00" + " - " +(i+1) + ".00");

													}
													
													boxKarel_c.addItem("1. Karel Room");
													boxKarel_c.addItem("2. Karel Room");
													boxKarel_c.addItem("3. Karel Room");
													boxKarel_c.addItem("4. Karel Room");
													boxKarel_c.addItem("5. Karel Room");
													
													
													JButton btnCancelTheBooking = new JButton("Cancel the Booking");
													btnCancelTheBooking.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent e) {
															
															karel_c = boxKarel_c.getSelectedItem().toString();
															date_c = ((JTextField)dateChooser_c.getDateEditor().getUiComponent()).getText();
														    hour_c = boxHour_c.getSelectedItem().toString();

															boolean sil = false;
															int cancelIndex = 0;
															for(int i=0; i<counter; i++) {
																
																if(karelList.get(i).toString().equals(karel_c) && dateList.get(i).toString().equals(date_c) && hourList.get(i).toString().equals(hour_c)) {
																	sil = true;
																	infoBox("The booking is succesfully cancalled.", "Cancelation.");
																	cancelIndex = i;
																	break;
																}	
															} 
															
															if (sil) {
																karelList.remove(cancelIndex);
																dateList.remove(cancelIndex);
																hourList.remove(cancelIndex);
																counter--;
																FillData();
																	}
														    
															
														}
													});
													btnCancelTheBooking.setBounds(140, 171, 180, 50);
													panel_2.add(btnCancelTheBooking);
													
													JLabel lblKarelRoomBooking = new JLabel("Karel Room Booking Cancelation");
													lblKarelRoomBooking.setHorizontalAlignment(SwingConstants.CENTER);
													lblKarelRoomBooking.setBounds(120, 32, 236, 20);
													panel_2.add(lblKarelRoomBooking);
													
													JPanel panel_1 = new JPanel();
													panel_1.addMouseListener(new MouseAdapter() {
														@Override
														public void mouseEntered(MouseEvent arg0) {
															FillData();
														}
													});
													tabbedPane.addTab("Previous Bookings", null, panel_1, null);
													panel_1.setLayout(null);
													
													JScrollPane scrollPane = new JScrollPane();
													scrollPane.setBounds(32, 31, 395, 266);
													panel_1.add(scrollPane);
													
													tableBooking = new JTable();
													scrollPane.setViewportView(tableBooking);
													
															
															btnNewButton.addActionListener(new ActionListener() {
																public void actionPerformed(ActionEvent arg0) {

																		karel = boxKarel.getSelectedItem().toString();
																		date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
																	    hour = boxHour.getSelectedItem().toString();
																	    name = txtName.getText();
																	    id = txtId.getText();
																	    
																		
																		boolean ekle = true;
																		
																		for(int i=0; i<counter; i++) {
																			
																			if(karelList.get(i).toString().equals(karel) && dateList.get(i).toString().equals(date) && hourList.get(i).toString().equals(hour)) {
																				ekle = false;
																				infoBox("In that time, the room has been reserved. Please choose another time slot.", "Room is reserved.");
																				break;
																			}
																			
																		} 
																		
																			if (ekle) {
																			karelList.add(karel);
																			dateList.add(date);
																			hourList.add(hour);
																			nameList.add(name);
																			idList.add(id);
																			infoBox("The room is successfully booked.", "Booking.");
																			counter++;
																				}
																		
																			FillData();
																}
															});
		
		

		
		
		
		for (int i=8; i<20; i++) {

			boxHour.addItem(i + ".00" + " - " +(i+1) + ".00");

		}

	}
}
