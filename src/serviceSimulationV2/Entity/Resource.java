package serviceSimulationV2.Entity; 
/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午2:59:14 
* 类说明  服务的初始容量
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
 