package serviceSimulationV2.Stragety.ServiceStragety.MoveOutStragety;

import java.util.List;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Responsitorry.ServiceResponsitory;
import serviceSimulationV2.Stragety.Stragety;
import serviceSimulationV2.util.SimulationUtil;

public class FixedMoveOutStragety implements MoveOutStragety, Stragety<Service>{
	int fixedValue;
	
	public FixedMoveOutStragety(int fixedValue) {
		super();
		
		this.fixedValue = fixedValue;
	}

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
		List<Service> result = SimulationUtil.getRandomClass(fixedValue, services);
		return result;
		
	}

	@Override
	public Service[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
