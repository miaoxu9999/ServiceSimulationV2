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
	
	//添加四个Service属性
	private static Stragety reliablityStragety;
	private static Stragety senseStragety;
	private static Stragety responseStragety;
	private static Stragety transform_abilityStragety;
	
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
	
	
	public static Stragety getReliablityStragety() {
		return reliablityStragety;
	}
	public static void setReliablityStragety(Stragety reliablityStragety) {
		CurrentServicePropertyManager.reliablityStragety = reliablityStragety;
	}
	public static Stragety getSenseStragety() {
		return senseStragety;
	}
	public static void setSenseStragety(Stragety senseStragety) {
		CurrentServicePropertyManager.senseStragety = senseStragety;
	}
	public static Stragety getResponseStragety() {
		return responseStragety;
	}
	public static void setResponseStragety(Stragety responseStragety) {
		CurrentServicePropertyManager.responseStragety = responseStragety;
	}
	public static Stragety getTransform_abilityStragety() {
		return transform_abilityStragety;
	}
	public static void setTransform_abilityStragety(Stragety transform_abilityStragety) {
		CurrentServicePropertyManager.transform_abilityStragety = transform_abilityStragety;
	}
	
	
	
}
 