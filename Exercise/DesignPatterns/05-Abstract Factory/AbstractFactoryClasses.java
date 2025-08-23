// Report interface
public interface Report {
	void generateReport();
	void saveToDatabase();
}

// Report Type A 
public class ReportTypeA implements Report { 

    @Override 
    public void generateReport() { 
		System.out.println("Generating Report Type A...");
	} 

    @Override 
    public void saveToDatabase() { 
		System.out.println("Saving Report Type A to database..."); 
	} 
}

public interface ReportFactory {
    Report createReport();
}

// Factory for Report Type A 
public class ReportTypeAFactory implements ReportFactory {
	 @Override public Report createReport() { 
		return new ReportTypeA(); 
	} 
}

// Factory for Report Type B 
public class ReportTypeBFactory implements ReportFactory { 	
	@Override public Report createReport() 
	{ 
		return new ReportTypeB(); 
	} 
}

public class ReportProcessor {
    private ReportFactory reportFactory;

    public ReportProcessor(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
	}

    public void processReport() {
        Report report = reportFactory.createReport();
        report.generateReport();
        report.saveToDatabase();
	}
}

public class Main {
    	public static void main(String[] args) {
			ReportFactory reportTypeAFactory = 
				new ReportTypeAFactory();
			ReportProcessor processorA = 
				new ReportProcessor(reportTypeAFactory);
        	processorA.processReport();
			ReportFactory reportTypeBFactory = 
				new ReportTypeBFactory();
        	ReportProcessor processorB = 
				new ReportProcessor(reportTypeBFactory);
        	processorB.processReport(); 
		}
}
