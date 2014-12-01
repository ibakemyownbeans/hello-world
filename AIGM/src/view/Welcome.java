/**
 * @file: Welcome.java
 * @author: Brandon, 22 Sep 2014, QASMT
 * Lenovo Thinkpad, Eclipse
 */

package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;


/**
 * @author Brandon
 *
 */
public class Welcome extends JPanel {

	private static final long serialVersionUID = -1979989118477393501L;
	private static final Dimension SIZE = new Dimension(550, 350);
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Welcome() {
		
		setPreferredSize(SIZE);
		
		JLabel lblWelcomeYouCan = new JLabel("Welcome. You can find out new shit here.");
		add(lblWelcomeYouCan);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("asstits");
			}
		});
		add(textField);
		textField.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblWelcomeYouCan, btnNewButton, textField}));

	}

}
