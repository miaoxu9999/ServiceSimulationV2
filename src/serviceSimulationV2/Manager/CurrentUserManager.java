package serviceSimulationV2.Manager;

import repast.simphony.relogo.ide.code.NetLogoRGWParser.stat_return;
import serviceSimulationV2.Entity.User;
import serviceSimulationV2.Stragety.Stragety;
import serviceSimulationV2.Stragety.DemandStragety.DemandStragety;
import serviceSimulationV2.Stragety.UserStragety.MoveInStragety.UserMoveInStragety;
import serviceSimulationV2.util.Generator;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 上午8:42:51 
* 类说明 管理所有当前的User策略
*/
public class CurrentUserManager {
	private static UserMoveInStragety userMoveInStragety;
	private static Generator<User> usergenerator;
	private static DemandStragety demandStragety;
	private static Stragety principleStragety;
	private static Stragety userTrustStragety;
	private static Stragety userChooseStragety;
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
	
	public static Stragety getPrincipleStragety() {
		return principleStragety;
	}
	public static void setPrincipleStragety(Stragety principleStragety) {
		CurrentUserManager.principleStragety = principleStragety;
	}
	public static Stragety getUserTrustStragety() {
		return userTrustStragety;
	}
	public static void setUserTrustStragety(Stragety userTrustStragety) {
		CurrentUserManager.userTrustStragety = userTrustStragety;
	}
	public static Stragety getUserChooseStragety() {
		return userChooseStragety;
	}
	public static void setUserChooseStragety(Stragety userChooseStragety) {
		CurrentUserManager.userChooseStragety = userChooseStragety;
	}
	
	
	
	
	
}
 