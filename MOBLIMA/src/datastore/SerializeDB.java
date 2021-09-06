package datastore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Serialize DB class
 * @author Haqim
 *
 */
public class SerializeDB {
	
	/**
	 * Read SerializedObject
	 * @param filename
	 * @return
	 */
	public static Object readSerializedObject(String filename) {
		Object pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList<?>) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return pDetails;
	}
	
	/**
	 * Write on serialized object
	 * @param filename
	 * @param object
	 */
	public static void writeSerializedObject(String filename, Object object) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(object);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
