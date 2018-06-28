package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class DAO {
	public static DAO dao;
	public String fileName = "data.dat";

	public static DAO newInstance() {
		if (dao == null) {
			dao = new DAO();
		}
		return dao;
	}

	public boolean saveScore(String score) {
		String urlFile = getClass().getResource("../data.txt").getPath();
		File file = new File(urlFile);
		if (file.exists()) {
			try {
				PrintWriter printWriter = new PrintWriter(file);
				printWriter.println(score);
				printWriter.flush();
				printWriter.close();
				System.out.println("Done");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Null");
		}
		return false;
	}

	public static void main(String[] args) {
		DAO dao = DAO.newInstance();
		dao.saveScore("fafas");
	}

}
