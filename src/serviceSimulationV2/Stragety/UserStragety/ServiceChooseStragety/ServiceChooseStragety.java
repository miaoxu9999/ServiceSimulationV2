package serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety;

import java.util.List;

import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��28�� ����9:31:23 
* ��˵�� 
*/
public abstract class ServiceChooseStragety implements Stragety<Service>{
	public abstract List<Service> getService(Demand demand, List<Service> services);

}
 