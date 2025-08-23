package decorator;

public class CamelCaseStringPrinter implements StringPrinter {
	private StringPrinter printer;
	
	public CamelCaseStringPrinter(StringPrinter printer){
		this.printer=printer;
	}
	
	public void print(String text) {
		String result="";
		boolean flag=true;
		char currChar;
		for(int i=0;i<text.length();i++){
			currChar=text.charAt(i);
			if(flag){
				flag=false;
				currChar=(currChar+"").toUpperCase().charAt(0);
			}else{
				currChar=(currChar+"").toLowerCase().charAt(0);
			}
			if(currChar==' '){
				flag=true;
			}
			result+=currChar+"";
		}
		printer.print(result);
	}
}
