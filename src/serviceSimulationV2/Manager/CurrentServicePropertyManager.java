package serviceSimulationV2.Manager;

import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 上午10:32:43 
* 类说明  管理当前所有Service的属性
*/
public class CurrentServicePropertyManager {
	private static Stragety reputationStragety;
	private static Stragety resourceStragety;
	private static Stragety usedNumberStragety;
	private static Stragety tagStragety;
	public static Stragety getReputationStragety() {
		return reputationStragety;
	}
	public static void setReputationStragety(Stragety rStragety) {
		reputationStragety = rStragety;
	}
	
	public static Stragety getResourceStragety() {
		return resourceStragety;
	}
	public static void setResourceStragety(Stragety rStragety) {
		CurrentServicePropertyManager.resourceStragety = rStragety;
	}
	public static Stragety getUsedNumberStragety() {
		return usedNumberStragety;
	}
	public static void setUsedNumberStragety(Stragety usedNStragety) {
		usedNumberStragety = usedNStragety;
	}
	public static Stragety getTagStragety() {
		return tagStragety;
	}
	public static void setTagStragety(Stragety tStragety) {
		tagStragety = tStragety;
	}
	
	//得到生成Service所需要的所有策略
	public Object[] getAllParameters() {
		Object[] res = new Object[] {getReputationStragety(), getResourceStragety(), getUsedNumberStragety(), getTagStragety()};
		
		
		return res;
		
	}
	
	
	
}
 