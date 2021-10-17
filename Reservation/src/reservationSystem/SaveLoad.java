package reservationSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad {

	public static void save(String fileName, Object saveIt) throws Exception {
		File file = new File(fileName);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(saveIt);
		oos.close();
		fos.close();
	}

	public static Object load(String fileName) throws Exception {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object res = ois.readObject();
		ois.close();
		fis.close();
		
		return res;
	}

}
