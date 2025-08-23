package facade;

public class BusinessFacade {
	
	private BusinessA a=new BusinessA();
	private BusinessB b=new BusinessB();
	private BusinessC c=new BusinessC();
	
	public void DoBusiness1(){
		a.doBusiness1();
		b.doBusiness1();
		c.doBusiness1();
	}
	
	public void DoBusiness2(){
		a.doBusiness2();
		b.doBusiness2();
		c.doBusiness2();
	}
	
}
