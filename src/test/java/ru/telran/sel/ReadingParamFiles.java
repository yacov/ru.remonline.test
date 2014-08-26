package ru.telran.sel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReadingParamFiles {

	private ArrayList parameters = new ArrayList();
	private ArrayList tags = new ArrayList();
	private ArrayList rows = new ArrayList();

	private void getRows(String path) {

		
		File file = new File(path);

		if (file.exists()) {
			FileReader fr;
			BufferedReader br;

			try {
				fr = new FileReader(path);
				br = new BufferedReader(fr);
				String curLine;
				while ((curLine = br.readLine()) != null) {					
					rows.add(curLine.trim());
				}
				br.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
			}
		} else
			JOptionPane.showMessageDialog(new JFrame(),
					" The file with test data is missing " + path);

	}

	public ArrayList getParameters(String path) {
		parameters = get(path, 1);
		return parameters;
	}

	public ArrayList getTags(String path) {
		tags = get(path, 0);
		return tags;
	}

	// type = 0 -> get tags ; type = 1 -> get values of the tags
	private ArrayList get(String path, int type) {
		ArrayList temp = new ArrayList();
		getRows(path);
		Iterator itr = rows.iterator();
		while (itr.hasNext()) {
			String row = (String) itr.next();
			String[] words = row.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (i % 2 == type) {					
					temp.add(words[i].trim());					
				}
			}
		}

		return temp;
	}

}
