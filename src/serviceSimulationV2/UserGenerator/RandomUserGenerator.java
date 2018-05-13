package serviceSimulationV2.UserGenerator;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Principle;
import serviceSimulationV2.Entity.User;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentUserManager;
import serviceSimulationV2.Stragety.Stragety;
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
	
	@Override
	public User next() {
		// TODO Auto-generated method stub
		//获得User的Demand
		DemandStragety demandStragety = CurrentUserManager.getDemandStragety();
		Stragety serviceChooseStragety = CurrentUserManager.getUserChooseStragety();
		Stragety trustStragety = CurrentUserManager.getUserTrustStragety();
		//获得User的ServiceChooseStragety
//		System.out.println(demandStragety);
//		System.out.println(trustStragety);
//		System.out.println(serviceChooseStragety);
		User user = null;
		user = new User(demandStragety.getStragetyValue(), (ServiceChooseStragety) serviceChooseStragety, CurrentContext.getCurrentSpace(), CurrentContext.getCurrentGrid(),
				(Principle)(CurrentUserManager.getPrincipleStragety().getStragetyValue()),
				(double) (trustStragety.getStragetyValue()));
		try {
			
		} catch (Exception e) {
			// TODO Auto-gen
			e.printStackTrace();
		} 
		
		return user;
	}

}
 