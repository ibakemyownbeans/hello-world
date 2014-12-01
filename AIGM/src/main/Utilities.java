/**
 * @file: Utilities.java
 * @author: Brandon, 23 Sep 2014, QASMT
 * Lenovo Thinkpad, Eclipse
 */

package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import data.Singleton;

/**
 * @author Brandon
 *
 */
public class Utilities {

	public static void saveData() {
		
		Singleton singleInstance = Singleton.getInstance();

		String dirName = System.getProperty("user.home") + File.separator
				+ "AIGM" + File.separator;
		File dir = new File(dirName);

		try {

			String fileName = "data.ser";
			File outFile = new File(dir, fileName);

			FileOutputStream singleOut = new FileOutputStream(outFile);
			ObjectOutputStream singletonObjectOut = new ObjectOutputStream(
					singleOut);

			singletonObjectOut.writeObject(singleInstance);

			singletonObjectOut.close();
			singleOut.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
