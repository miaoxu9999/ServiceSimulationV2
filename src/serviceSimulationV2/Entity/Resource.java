package serviceSimulationV2.Entity; 
/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����2:59:14 
* ��˵��  ����ĳ�ʼ����
*/
public class Resource {
	private int initialCapability;
	private int currentCapablity;
	public Resource(int initialCapability) {
		super();
		this.initialCapability = initialCapability;
		this.currentCapablity = 0;
	}
	public int getInitialCapability() {
		return initialCapability;
	}
	public void setInitialCapability(int initialCapability) {
		this.initialCapability = initialCapability;
	}
	public int getCurrentCapablity() {
		return currentCapablity;
	}
	public void setCurrentCapablity(int currentCapablity) {
		this.currentCapablity = currentCapablity;
	}
	
}
 