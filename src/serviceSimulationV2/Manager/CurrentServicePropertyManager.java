package serviceSimulationV2.Manager;

import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����10:32:43 
* ��˵��  ����ǰ����Service������
*/
public class CurrentServicePropertyManager {
	private static Stragety reputationStragety;
	private static Stragety resourceStragety;
	private static Stragety usedNumberStragety;
	private static Stragety tagStragety;
	
	//����ĸ�Service����
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
	
	//�õ�����Service����Ҫ�����в���
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
 