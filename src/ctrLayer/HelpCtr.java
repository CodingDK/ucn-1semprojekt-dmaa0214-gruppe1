package ctrLayer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import modelLayer.Help;
import modelLayer.HelpCont;

public class HelpCtr {
	private static boolean loaded = false;
	
	public HelpCtr() throws IOException {
		if (!loaded) {
			load();
		}
	}
	
	public void load() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("./help.hlp"), "UTF-8"));
		HelpCont hCont = HelpCont.getInstance();
		String line;
		boolean firstLine = false;
		Help h = null;
		String title = "";
		while ((line = bf.readLine()) != null) {
			if (line.contains("@Title")) {
				firstLine = true;
				title = line.replace("@Title", "");
				if (title.charAt(0) == ' ') {
					title = title.substring(1, title.length());
				}
			}
			if (firstLine) {
				h = new Help(title);
				firstLine = false;
			} else if (line.contains("---")) {
				hCont.addHelp(title, h);
			} else {
				h.append(line);
			}
		}
		bf.close();
	}
	
	public Help getHelp(String pane) {
		HelpCont hCont = HelpCont.getInstance();
		return hCont.getHelp(pane);
	}
	
}
