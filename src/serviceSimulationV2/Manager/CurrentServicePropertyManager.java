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
	
	
	
}
 