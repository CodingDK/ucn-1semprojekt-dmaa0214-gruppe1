package modelLayer;

public class Help {
	private String name;
	private String help;
	private String nL = System.getProperty("line.separator");
	
	public Help(String name) {
		this.name = name;
		this.help = "";
	}
	
	public void append(String line){
		help += line + nL;
	}
	
	public String getName(){
		return name;
	}
	
	public String getHelp(){
		return help;
	}
	
}
