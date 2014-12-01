/**
 * @file: AIGM.java
 * @author: Brandon, 22 Sep 2014, QASMT
 * Lenovo Thinkpad, Eclipse
 */

package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.LolMarket3;
import view.Welcome;
import data.Singleton;


/**
 * @author Brandon
 *
 */
public class AIGM {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					AIGM window = new AIGM();
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
	public AIGM() {
		loadData();
		initialize();
	}
	
	private void loadData() {
		try {
			String dirName = System.getProperty("user.home") + File.separator + "AIGM" + File.separator;
			File dir = new File(dirName);

			if (!dir.exists()) {
				dir.mkdir();
			}

			String fileName = "data.ser";
			File dataFile = new File(dirName, fileName);
			
			if (!dataFile.exists()) {
				dataFile.createNewFile();
			}
			
			if (dataFile.length() != 0) {
				FileInputStream fileIn = new FileInputStream(dataFile);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				
				Singleton.setInstance((Singleton) in.readObject());

				in.close();
				fileIn.close();
			} else {
				Singleton.getInstance();
			}
			
			System.out.println(Singleton.getInstance());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent arg0) {
				System.out.println("Tab: " + tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()));
				frame.setSize(tabbedPane.getSelectedComponent().getPreferredSize());
			}
		});
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		int[] empty = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] max = {1000000, 10000000, 1000000000, 1000000000, 1000000000, 1000000000, 10000000, 10000000, 100000, 10000000};

		tabbedPane.addTab("Welcome", new Welcome());
		tabbedPane.addTab("LOLMarket", new LolMarket3());

	}

	public static void save(Class c) {
		
	}

}
