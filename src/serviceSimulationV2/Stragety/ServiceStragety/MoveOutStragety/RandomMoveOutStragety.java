package serviceSimulationV2.Stragety.ServiceStragety.MoveOutStragety;

import java.util.List;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Responsitorry.ServiceResponsitory;
import serviceSimulationV2.Stragety.Stragety;
import serviceSimulationV2.util.SimulationUtil;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月29日 下午3:59:15 
* 类说明 
*/
public class RandomMoveOutStragety implements MoveOutStragety, Stragety<Service>{

	@Override
	public Service getStragetyValue() {
		// TODO Auto-generated method stub
		List<Service> services = ServiceResponsitory.getList();
		int size = services.size();
		int index = RandomHelper.nextIntFromTo(0, size - 1);
		return services.get(index);
	}

	@Override
	public List<Service> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		List<Service> services = ServiceResponsitory.getList();
		int sizeOfList = services.size();
		int num = RandomHelper.nextIntFromTo(1, Math.min(sizeOfList, sizeOfList - 1));
		List<Service> result = SimulationUtil.getRandomClass(num, services);
		return result;
	}

	@Override
	public Service[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
 