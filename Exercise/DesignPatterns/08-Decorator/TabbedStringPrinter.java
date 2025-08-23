package decorator;

public class TabbedStringPrinter implements StringPrinter {

	private StringPrinter printer;
	
	public TabbedStringPrinter(StringPrinter printer){
		this.printer=printer;
	}
	
	public void print(String text) {
		String result="";
		for(int i=0;i<text.length();i++){
			result+=text.charAt(i)+"	"; // "\t" ?
		}
		printer.print(result);
	}

}
