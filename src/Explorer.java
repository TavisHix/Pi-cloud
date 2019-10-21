
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class Explorer extends piTran{

	private JFrame frame;
	private JPanel panelLogin;
	private JPanel panelRegister;
	private JPanel panelLanding;
	private JTextField logPassword;
	private JTextField logUsername;
	private JTextField regPass;
	private JTextField regUser;
	private JTextField confPass;
	private JTextField textFieldPathFile;
	private String thisUser;
	
	String currentUserName;
	String piDir = "/home/pi/Desktop/fold/";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explorer window = new Explorer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Explorer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "name_68003176853239");
		panelLogin.setLayout(null);
		panelLogin.setVisible(true);
		
		final JPanel panelRegister = new JPanel();
		frame.getContentPane().add(panelRegister, "name_68004772353354");
		panelRegister.setLayout(null);
		panelRegister.setVisible(false);
		
		final JPanel panelLanding = new JPanel();
		frame.getContentPane().add(panelLanding, "name_68008061657179");
		panelLanding.setLayout(null);
		panelLanding.setVisible(false);
		
//		JPanel panelUpload = new JPanel();
//		frame.getContentPane().add(panelUpload, "name_545718415350199");
//		panelUpload.setLayout(null);
//		panelUpload.setVisible(true);
//		
//		textFieldPathFile = new JTextField();
//		textFieldPathFile.setBounds(54, 102, 396, 28);
//		panelUpload.add(textFieldPathFile);
//		textFieldPathFile.setColumns(10);
//		
//		JLabel lblFileToTransfer = new JLabel("Path of upload file:");
//		lblFileToTransfer.setBounds(54, 69, 126, 22);
//		panelUpload.add(lblFileToTransfer);
//		
//		JButton btnNewButton_1 = new JButton("Select File");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				FileDialog fd = new FileDialog(frame, "Your Files", FileDialog.LOAD);
//                fd.setVisible(true);
//                String path = fd.getDirectory() + fd.getFile();
//                File f = new File(path);
//                textFieldPathFile.setText(path);
//			}
//		});
//		btnNewButton_1.setBounds(54, 143, 97, 25);
//		panelUpload.add(btnNewButton_1);
//		
//		JLabel lblPathOfDirectory = new JLabel("Directory of recieving party");
//		lblPathOfDirectory.setBounds(54, 199, 196, 28);
//		panelUpload.add(lblPathOfDirectory);
//		
//		
//		
//		JLabel lblhomedesktop = new JLabel("/home/pi/Desktop/fold/" + currentUserName);
//		lblhomedesktop.setBounds(54, 234, 196, 28);
//		panelUpload.add(lblhomedesktop);
//		
//		JButton btnNewButton_2 = new JButton("Upload");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String local = textFieldPathFile.getText();
//				String remote = lblhomedesktop.getText();
//				TransferU(local, remote);
//				JOptionPane.showConfirmDialog(null, "Succecufly uploaded file", "Success", JOptionPane.DEFAULT_OPTION);
//				panelUpload.setVisible(false);
//			}
//		});
//		btnNewButton_2.setBounds(212, 275, 126, 42);
//		panelUpload.add(btnNewButton_2);
//		
//		JButton btnBack = new JButton("Back");
//		btnBack.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				panelLanding.setVisible(true);
//				panelUpload.setVisible(false);
//			}
//		});
//		btnBack.setBounds(443, 13, 97, 25);
//		panelUpload.add(btnBack);
	
//		String userFolder = piDir + currentUserName;
//		String[] arr = printlist(userFolder);
//		JPanel panelDownload = new JPanel();
//		frame.getContentPane().add(panelDownload, "name_545718415350199");
//		panelDownload.setLayout(null);
//		panelDownload.setVisible(true);
//		
//		JList list = new JList(arr);
//		list.setBounds(75, 33, 415, 176);
//		panelDownload.add(list);
//		
//		JLabel lblNewLabel_1 = new JLabel("File you are downloading:");
//		lblNewLabel_1.setBounds(40, 232, 169, 32);
//		panelDownload.add(lblNewLabel_1);
//		
//		JLabel remDir = new JLabel("/home/pi/desktop/fold/" + currentUserName + "");
//		remDir.setBounds(194, 232, 296, 32);
//		panelDownload.add(remDir);
//		
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		String s = remDir.getText();
//		list.addListSelectionListener(
//				new ListSelectionListener(){
//					public void valueChanged(ListSelectionEvent event) {
//						
//						String value = list.getSelectedValue().toString();
//						remDir.setText(s + value);
//					}
//					
//				});
//		
//		
//		JLabel locDir = new JLabel("New label");
//		locDir.setBounds(194, 277, 302, 26);
//		panelDownload.add(locDir);
//		
//		JLabel lblDirectoryToDownload = new JLabel("Directory to download to: ");
//		lblDirectoryToDownload.setBounds(40, 282, 153, 16);
//		panelDownload.add(lblDirectoryToDownload);
//		
//		JButton btnNewButton_3 = new JButton("Select Directory");
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser j = new JFileChooser();
//				j.setCurrentDirectory(new java.io.File("."));
//			    j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//			    j.setAcceptAllFileFilterUsed(false);  
//			    if (j.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
//			      locDir.setText(j.getSelectedFile().getAbsolutePath());
//			      }
//			}
//		});
//		btnNewButton_3.setBounds(50, 311, 131, 38);
//		panelDownload.add(btnNewButton_3);
//		
//		JButton btnDownload = new JButton("Download");
//		btnDownload.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String local = remDir.getText();
//				String remote = locDir.getText();
//				TransferD(local, remote);
//			}
//		});
//		btnDownload.setBounds(393, 361, 97, 25);
//		panelDownload.add(btnDownload);
		
		
////		
////		
////		
////		JLabel lblNewLabel = new JLabel("Select a file from your folder:");
////		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
////		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
////		lblNewLabel.setBounds(140, 48, 296, 29);
////		panelDownload.add(lblNewLabel);
////		panelDownload.setVisible(false);
		
		
		//								//
		//								//
		//			Login page			//
		//								//
		//								//
		
		
		
		JLabel logLabel = new JLabel("Welcome");
		logLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		logLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logLabel.setBounds(199, 13, 123, 49);
		panelLogin.add(logLabel);
		
		JLabel logUsernameLabel = new JLabel("Username:");
		logUsernameLabel.setBounds(165, 111, 86, 24);
		panelLogin.add(logUsernameLabel);
		
		JLabel logPasswordLabel = new JLabel("Password:");
		logPasswordLabel.setBounds(165, 178, 86, 24);
		panelLogin.add(logPasswordLabel);
		
		logPassword = new JTextField();
		logPassword.setBounds(242, 179, 116, 22);
		panelLogin.add(logPassword);
		logPassword.setColumns(10);
		
		logUsername = new JTextField();
		logUsername.setColumns(10);
		logUsername.setBounds(242, 112, 116, 22);
		panelLogin.add(logUsername);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = -1;
				x = dbHandler.validateLogin(logUsername.getText(), logPassword.getText());
				if(x == 0){
				currentUserName = logUsername.getText();


				
				
				
				panelLanding.setVisible(true);
				panelLogin.setVisible(false);
				}
					else if(x == 1)
					{
						JOptionPane.showConfirmDialog(null, "User does not exist", "Username", JOptionPane.DEFAULT_OPTION);
					}
						else if(x == 2)
						{
							JOptionPane.showConfirmDialog(null, "Wrong Password", "Password", JOptionPane.DEFAULT_OPTION);
						}
			}
		});
		login.setBounds(215, 236, 97, 25);
		panelLogin.add(login);
		
		JButton signUp = new JButton("Sign Up");
		signUp.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					panelRegister.setVisible(true);
					panelLogin.setVisible(false);
				
					}
				}
		);
		
		signUp.setBounds(215, 284, 97, 25);
		panelLogin.add(signUp);
		
		
		//									//
		//									//
		//			Register page			//
		//									//
		//									//
		
		
		JLabel SignUp = new JLabel("Sign Up");
		SignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SignUp.setHorizontalAlignment(SwingConstants.CENTER);
		SignUp.setBounds(199, 13, 123, 49);
		panelRegister.add(SignUp);
		
		JLabel regUsernameLabel = new JLabel("Username:");
		regUsernameLabel.setBounds(127, 75, 86, 24);
		panelRegister.add(regUsernameLabel);
		
		JLabel regPassLabel = new JLabel("Password:");
		regPassLabel.setBounds(127, 137, 86, 24);
		panelRegister.add(regPassLabel);
		
		regPass = new JTextField();
		regPass.setColumns(10);
		regPass.setBounds(297, 138, 116, 22);
		panelRegister.add(regPass);
		
		regUser = new JTextField();
		regUser.setColumns(10);
		regUser.setBounds(297, 75, 116, 22);
		panelRegister.add(regUser);
		
		JLabel ReenterPassword = new JLabel("Re-Enter Password:");
		ReenterPassword.setBounds(127, 203, 123, 22);
		panelRegister.add(ReenterPassword);
		
		confPass = new JTextField();
		confPass.setColumns(10);
		confPass.setBounds(297, 203, 116, 22);
		panelRegister.add(confPass);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u = regUser.getText();
				String p = regPass.getText();
			    String cp = confPass.getText();
			    if(regUser.getText().equals(""))
			    {
			    	JOptionPane.showConfirmDialog(null, "Empty Username", "Empty Username", JOptionPane.DEFAULT_OPTION);
			    	
			    }
			    else if(regPass.getText().equals(""))
			    {
			    	JOptionPane.showConfirmDialog(null, "Empty Password", "Empty Password", JOptionPane.DEFAULT_OPTION);
			    }
			    else if(p.compareTo(cp) != 0)
			    {
			    	JOptionPane.showConfirmDialog(null, "Passwords do not match", "Success", JOptionPane.DEFAULT_OPTION);
			    }
			    else{
			    	dbHandler.insertAndDisplay(u, p);
			    	
			    	JOptionPane.showConfirmDialog(null, "Succecufly registered \nUser: " + u + "\nPassword: " + p + "", "Success", JOptionPane.DEFAULT_OPTION);
			    	createFolder(u);
			    	panelLogin.setVisible(true);
			    	panelRegister.setVisible(false);
			    	regUser.setText("");
			    	regPass.setText("");
			    	confPass.setText("");
			    }
			    
				
			}
		});
		Register.setBounds(199, 274, 97, 25);
		panelRegister.add(Register);
		
		//								//
		//								//
		//			Landing page		//
		//								//
		//								//


		JButton btnNewButton = new JButton("Upload File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				panelUpload.revalidate();
//				panelUpload.repaint();
//				thisUser = currentUserName;
//				panelUpload.setVisible(true);
				showUpload();
				panelLanding.setVisible(false);
			}
		});
		btnNewButton.setBounds(68, 153, 147, 74);
		panelLanding.add(btnNewButton);
		
		JButton btnDownloadFile = new JButton("Download File");
		btnDownloadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showDownload();
				panelLanding.setVisible(false);
			}
		});
		btnDownloadFile.setBounds(290, 153, 147, 74);
		panelLanding.add(btnDownloadFile);
		
		//								//
		//								//
		//			Upload page			//
		//								//
		//								//

		
		
	}
	
	public void showUpload(){
		JPanel panelUpload = new JPanel();
		frame.getContentPane().add(panelUpload, "name_545718415350199");
		panelUpload.setLayout(null);
		panelUpload.setVisible(true);
		
		textFieldPathFile = new JTextField();
		textFieldPathFile.setBounds(54, 102, 396, 28);
		panelUpload.add(textFieldPathFile);
		textFieldPathFile.setColumns(10);
		
		JLabel lblFileToTransfer = new JLabel("Path of upload file:");
		lblFileToTransfer.setBounds(54, 69, 126, 22);
		panelUpload.add(lblFileToTransfer);
		
		JButton btnNewButton_1 = new JButton("Select File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(frame, "Your Files", FileDialog.LOAD);
                fd.setVisible(true);
                String path = fd.getDirectory() + fd.getFile();
                File f = new File(path);
                textFieldPathFile.setText(path);
			}
		});
		btnNewButton_1.setBounds(54, 143, 97, 25);
		panelUpload.add(btnNewButton_1);
		
		JLabel lblPathOfDirectory = new JLabel("Directory of recieving party");
		lblPathOfDirectory.setBounds(54, 199, 196, 28);
		panelUpload.add(lblPathOfDirectory);
		
		
		
		JLabel lblhomedesktop = new JLabel("/home/pi/Desktop/fold/" + currentUserName);
		lblhomedesktop.setBounds(54, 234, 196, 28);
		panelUpload.add(lblhomedesktop);
		
		JButton btnNewButton_2 = new JButton("Upload");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String local = textFieldPathFile.getText();
				String remote = lblhomedesktop.getText();
				TransferU(local, remote);
				JOptionPane.showConfirmDialog(null, "Succecufly uploaded file", "Success", JOptionPane.DEFAULT_OPTION);
				panelUpload.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(212, 275, 126, 42);
		panelUpload.add(btnNewButton_2);
		
	}
	
	//								//
	//								//
	//			download page		//
	//								//
	//								//
	
	public void showDownload(){
		String userFolder = piDir + currentUserName;
		String[] arr = printlist(userFolder);
		JPanel panelDownload = new JPanel();
		frame.getContentPane().add(panelDownload, "name_545718415350199");
		panelDownload.setLayout(null);
		panelDownload.setVisible(true);
		
		JList list = new JList(arr);
		list.setBounds(75, 33, 415, 176);
		panelDownload.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("File you are downloading:");
		lblNewLabel_1.setBounds(40, 232, 169, 32);
		panelDownload.add(lblNewLabel_1);
		
		JLabel remDir = new JLabel("/home/pi/Desktop/fold/" + currentUserName + "/");
		remDir.setBounds(194, 232, 296, 32);
		panelDownload.add(remDir);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String s = remDir.getText();
		list.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event) {
						
						String value = list.getSelectedValue().toString();
						remDir.setText(s + value);
					}
					
				});
		
		
		JLabel locDir = new JLabel("New label");
		locDir.setBounds(194, 277, 302, 26);
		panelDownload.add(locDir);
		
		JLabel lblDirectoryToDownload = new JLabel("Directory to download to: ");
		lblDirectoryToDownload.setBounds(40, 282, 153, 16);
		panelDownload.add(lblDirectoryToDownload);
		
		JButton btnNewButton_3 = new JButton("Select Directory");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(frame, "Your Files", FileDialog.LOAD);
                fd.setVisible(true);
                String s = fd.getDirectory().replace("\\","/" );
                locDir.setText(s.substring(0, s.length()-1));
                }
		});
		btnNewButton_3.setBounds(50, 311, 131, 38);
		panelDownload.add(btnNewButton_3);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String remote = remDir.getText();
				System.out.println(remote);
				String local = locDir.getText();
				System.out.println(local);
				TransferD(local, remote);
			}
		});
		btnDownload.setBounds(393, 361, 97, 25);
		panelDownload.add(btnDownload);
		
//		JLabel lblNewLabel = new JLabel("Select a file from your folder:");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(140, 48, 296, 29);
//		panelDownload.add(lblNewLabel);
		//panelDownload.setVisible(false);
	}
}
