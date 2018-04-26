package serviceSimulationV2.UserGenerator;

import bibliothek.gui.dock.station.stack.tab.layouting.Size.Type;
import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.User;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentUserManager;
import serviceSimulationV2.Stragety.DemandStragety.DemandStragety;
import serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety.RandomServiceChooseStragety;
import serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety.ServiceChooseStragety;
import serviceSimulationV2.util.Generator;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��28�� ����8:14:01 
* ��˵�� 
*/
public class RandomUserGenerator implements Generator<User>{
	Class[] type = {RandomServiceChooseStragety.class};
	@Override
	public User next() {
		// TODO Auto-generated method stub
		//���User��Demand
		DemandStragety demandStragety = CurrentUserManager.getDemandStragety();
		
		//���User��ServiceChooseStragety
		User user = null;
		try {
			user = new User(demandStragety.getStragetyValue(), (ServiceChooseStragety) type[0].newInstance(), CurrentContext.getCurrentSpace(), CurrentContext.getCurrentGrid());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
 