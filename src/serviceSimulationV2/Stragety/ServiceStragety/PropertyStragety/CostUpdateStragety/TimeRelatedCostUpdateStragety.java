package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.CostUpdateStragety;

import java.util.List;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;
import serviceSimulationV2.Stragety.Stragety;

public class TimeRelatedCostUpdateStragety implements Stragety<Double>, CostUpdateStragety{

	@Override
	public Double getStragetyValue() {
		// TODO Auto-generated method stub
		ISchedule schedule = RunEnvironment.getInstance().getCurrentSchedule();
		double current_tick = schedule.getTickCount();
		double value = current_tick * 0.1;
		return value;
	}

	@Override
	public List<Double> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
