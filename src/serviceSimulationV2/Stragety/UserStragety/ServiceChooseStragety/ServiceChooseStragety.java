package serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety;

import java.util.List;

import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午9:31:23 
* 类说明 
*/
public abstract class ServiceChooseStragety implements Stragety<Service>{
	public abstract List<Service> getService(Demand demand, List<Service> services);

}
 