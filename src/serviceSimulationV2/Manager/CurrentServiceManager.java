package serviceSimulationV2.Manager;

import serviceSimulationV2.ServiceGenerator.ServiceGenerator;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 上午8:42:29 
* 类说明 管理所有当前的Service策略
*/
public class CurrentServiceManager {
	private static Stragety moveInStragety;
	private static Stragety moveOutStragety;
	private static ServiceGenerator serviceGenerator;
	//Service 更新的下限
	private static double reputationupdatecondition;
	public static Stragety getMoveInStragety() {
		return moveInStragety;
	}
	public static void setMoveInStragety(Stragety moveInStragety) {
		CurrentServiceManager.moveInStragety = moveInStragety;
	}
	public static Stragety getMoveOutStragety() {
		return moveOutStragety;
	}
	public static void setMoveOutStragety(Stragety moveOutStragety) {
		CurrentServiceManager.moveOutStragety = moveOutStragety;
	}
	public static ServiceGenerator getServiceGenerator() {
		return serviceGenerator;
	}
	public static void setServiceGenerator(ServiceGenerator serviceGenerator) {
		CurrentServiceManager.serviceGenerator = serviceGenerator;
	}
	public static double getReputationupdatecondition() {
		return 4;
	}
	public static void setReputationupdatecondition(double reputationupdatecondition) {
		CurrentServiceManager.reputationupdatecondition = reputationupdatecondition;
	}
	
	
	
	
	

}
 