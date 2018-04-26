package serviceSimulationV2.Stragety.DemandStragety;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.Entity.Demand.RandomDemand;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午7:20:51 
* 类说明 
*/
public class RandomDemandStragety extends DemandStragety{

	@Override
	public Demand getStragetyValue() {
		// TODO Auto-generated method stub
		return new RandomDemand();
	}

	@Override
	public List<Demand> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return Arrays.asList(getStragetyValueArray(size));
	}

	@Override
	public Demand[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Demand[] demands = new Demand[size];
		return demands;
	}

}
 