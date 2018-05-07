package serviceSimulationV2.UserGenerator;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Principle;
import serviceSimulationV2.Entity.User;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentUserManager;
import serviceSimulationV2.Stragety.DemandStragety.DemandStragety;
import serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety.RandomServiceChooseStragety;
import serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety.ServiceChooseStragety;
import serviceSimulationV2.util.Generator;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午8:14:01 
* 类说明 
*/
public class RandomUserGenerator implements Generator<User>{
	Class[] type = {RandomServiceChooseStragety.class};
	@Override
	public User next() {
		// TODO Auto-generated method stub
		//获得User的Demand
		DemandStragety demandStragety = CurrentUserManager.getDemandStragety();
		
		//获得User的ServiceChooseStragety
		User user = null;
		try {
			user = new User(demandStragety.getStragetyValue(), (ServiceChooseStragety) type[0].newInstance(), CurrentContext.getCurrentSpace(), CurrentContext.getCurrentGrid(),
					(Principle)CurrentUserManager.getPrincipleStragety().getStragetyValue());
		} catch (InstantiationException e) {
			// TODO Auto-gen
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
 