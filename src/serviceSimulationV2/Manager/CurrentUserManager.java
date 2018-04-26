package serviceSimulationV2.Manager;

import serviceSimulationV2.Entity.User;
import serviceSimulationV2.Stragety.DemandStragety.DemandStragety;
import serviceSimulationV2.Stragety.UserStragety.MoveInStragety.UserMoveInStragety;
import serviceSimulationV2.util.Generator;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����8:42:51 
* ��˵�� �������е�ǰ��User����
*/
public class CurrentUserManager {
	private static UserMoveInStragety userMoveInStragety;
	private static Generator<User> usergenerator;
	private static DemandStragety demandStragety;
	public static UserMoveInStragety getUserMoveInStragety() {
		return userMoveInStragety;
	}
	public static void setUserMoveInStragety(UserMoveInStragety userMoveInStragety) {
		CurrentUserManager.userMoveInStragety = userMoveInStragety;
	}
	public static Generator<User> getUsergenerator() {
		return usergenerator;
	}
	public static void setUsergenerator(Generator<User> usergenerator) {
		CurrentUserManager.usergenerator = usergenerator;
	}
	public static DemandStragety getDemandStragety() {
		return demandStragety;
	}
	public static void setDemandStragety(DemandStragety demandStragety) {
		CurrentUserManager.demandStragety = demandStragety;
	}
	
	
}
 