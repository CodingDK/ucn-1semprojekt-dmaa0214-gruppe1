package modelLayer;

import java.util.HashMap;

public class HelpCont {
	private static HelpCont instance;
	private HashMap<String, Help> helpMap;
	
	private HelpCont() {
		helpMap = new HashMap<String, Help>();
	}
	
	public static HelpCont getInstance() {
		if (instance == null) {
			instance = new HelpCont();
		}
		
		return instance;
	}
	
	public void addHelp(String pane, Help h) {
		helpMap.put(pane, h);
	}
	
	public Help getHelp(String pane) {
		return helpMap.get(pane);
	}
	
}
