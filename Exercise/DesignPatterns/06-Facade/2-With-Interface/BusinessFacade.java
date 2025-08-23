package facade;

public class BusinessFacade {
	
	private List<Business> businesses;
	
	public BusinessFacade() {
		businesses = new ArrayList<>();
		businesses.add(new BusinessA());
		businesses.add(new BusinessB());
		businesses.add(new BusinessC());
	}
	
	public void doBusiness1(){
		for (var business: businesses) {
			business.doBusiness1();
		}
	}
	
	public void doBusiness2(){
		for (var business: businesses) {
			business.doBusiness2();
		}
	}
}
