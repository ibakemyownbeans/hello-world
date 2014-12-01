package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import main.Utilities;
import data.LolMarketData;
import data.Singleton;

public class LolMarket3 extends JPanel {

	private static final long serialVersionUID = 8920772441220537349L;
	private static final Dimension SIZE = new Dimension(800, 555);

	private JTextField[][] textFields;

	// TODO remove
	private int numGems = 10;
	private int numFields = 6;

	/**
	 * Create the panel.
	 */
	public LolMarket3() {
		setLayout(null);
		setPreferredSize(SIZE);

		textFields = new JTextField[numGems][numFields];

		JPanel pneBuySell = new JPanel();
		pneBuySell
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pneBuySell.setBounds(160, 20, 500, 30);
		add(pneBuySell);
		pneBuySell.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblBuy = new JLabel("Buy");
		pneBuySell.add(lblBuy);

		Component horizontalStrut = Box.createHorizontalStrut(200);
		pneBuySell.add(horizontalStrut);

		JLabel lblSell = new JLabel("Sell");
		pneBuySell.add(lblSell);

		JPanel pneTitle = new JPanel();
		pneTitle.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pneTitle.setBounds(40, 60, 700, 30);
		add(pneTitle);
		pneTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		pneTitle.add(horizontalStrut_5);

		JLabel lblCurrentPrice = new JLabel("Current");
		pneTitle.add(lblCurrentPrice);

		Component horizontalStrut_1 = Box.createHorizontalStrut(65);
		pneTitle.add(horizontalStrut_1);

		JLabel lblMax = new JLabel("Max");
		pneTitle.add(lblMax);

		Component horizontalStrut_2 = Box.createHorizontalStrut(75);
		pneTitle.add(horizontalStrut_2);

		JLabel lblMin = new JLabel("Min");
		pneTitle.add(lblMin);

		Component horizontalStrut_3 = Box.createHorizontalStrut(80);
		pneTitle.add(horizontalStrut_3);

		JLabel lblCurrentPrice_1 = new JLabel("Current");
		pneTitle.add(lblCurrentPrice_1);

		Component horizontalStrut_6 = Box.createHorizontalStrut(70);
		pneTitle.add(horizontalStrut_6);

		JLabel lblMax_1 = new JLabel("Max");
		pneTitle.add(lblMax_1);

		Component horizontalStrut_4 = Box.createHorizontalStrut(70);
		pneTitle.add(horizontalStrut_4);

		JLabel lblMin_1 = new JLabel("Min");
		pneTitle.add(lblMin_1);

		for (int gem = 0; gem < numGems; gem++) {

			JPanel pne = new JPanel();
			pne.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			pne.setBounds(6, 44 * gem + 106, 734, 32);
			add(pne);
			pne.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

			JLabel lbl = new JLabel(gem + 1 + "");
			pne.add(lbl);

			for (int field = 0; field < numFields; field++) {

				int[] numbers = Singleton.getInstance().getMarketData()
						.getNumbers()[gem];

				textFields[gem][field] = new JTextField(numbers[field] + "");
				if (field == 0 || field == 3) {
					textFields[gem][field].setEditable(true);
				} else {
					textFields[gem][field].setEditable(false);
					textFields[gem][field].setFocusable(false);
				}
				pne.add(textFields[gem][field]);
				textFields[gem][field].setColumns(8);
			}
		}

		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LolMarketData lmd = Singleton.getInstance().getMarketData();

				int[][] marketNumbers = lmd.getNumbers();

				for (int gem = 0; gem < numGems; gem++) {
					if (!textFields[gem][0].equals("")) {
						int curPrice = Integer.parseInt(textFields[gem][0]
								.getText());
						marketNumbers[gem][0] = curPrice;

						if (curPrice > marketNumbers[gem][1])
							marketNumbers[gem][1] = curPrice;

						if (curPrice < marketNumbers[gem][2]
								|| marketNumbers[gem][2] == 0)
							marketNumbers[gem][2] = curPrice;

						curPrice = Integer.parseInt(textFields[gem][3]
								.getText());
						marketNumbers[gem][3] = curPrice;

						if (curPrice > marketNumbers[gem][4])
							marketNumbers[gem][4] = curPrice;

						if (curPrice < marketNumbers[gem][5]
								|| marketNumbers[gem][5] == 0)
							marketNumbers[gem][5] = curPrice;
					}
				}

				lmd.setNumbers(marketNumbers);

				redraw();

				Utilities.saveData();
			}
		});
		btnPush.setBounds(32, 19, 117, 29);
		add(btnPush);
	}

	public void redraw() {
		int[][] marketNumbers = Singleton.getInstance().getMarketData()
				.getNumbers();

		for (int gem = 0; gem < numGems; gem++) {
			for (int field = 0; field < numFields; field++) {
				textFields[gem][field].setText("" + marketNumbers[gem][field]);
			}
		}
	}
}
