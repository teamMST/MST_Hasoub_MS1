package decorator;

public class CapitalizeStringPrinter implements StringPrinter {
	private StringPrinter printer;
	
	public CapitalizeStringPrinter(StringPrinter printer){
		this.printer=printer;
	}
	
	public void print(String text) {
		printer.print(text.toUpperCase());
	}
}
