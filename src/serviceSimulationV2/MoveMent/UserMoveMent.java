package serviceSimulationV2.MoveMent;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import serviceSimulationV2.Entity.User;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentUserManager;
import serviceSimulationV2.Stragety.ServiceStragety.MoveInStragety.MoveInStragety;
import serviceSimulationV2.Stragety.UserStragety.MoveInStragety.UserMoveInStragety;
import serviceSimulationV2.util.Generator;
import serviceSimulationV2.util.Position;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午8:15:15 
* 类说明 
*/
public class UserMoveMent {
	
	@ScheduledMethod(start = 2, interval = 2, priority = 3)
	public void UserAppendent() {
		//获得MoveInStragety
		UserMoveInStragety moveInStragety = CurrentUserManager.getUserMoveInStragety();
		//获得当前User的Generator
		Generator<User> userGenerator = CurrentUserManager.getUsergenerator();
		Context<Object> context = CurrentContext.getCurrentContext();
		for(int i = 0; i < moveInStragety.getAmount(); i++)
		{
			User user = userGenerator.next();
			context.add(user);
		}
		Position.SetRightPosition();
	}
}
 