package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReputationStragety;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedReputationStragety implements Stragety<Double>, ReputationStragety{
	private double fixedValue;
	
	public FixedReputationStragety(double fixedValue) {
		super();
		this.fixedValue = fixedValue;
	}

	@Override
	public Double getStragetyValue() {
		// TODO Auto-generated method stub
		return fixedValue;
	}

	@Override
	public List<Double> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		List<Double> list = Arrays.asList(getStragetyValueArray(size));
		
		return list;
	}

	@Override
	public Double[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Double[] array = new Double[size];
		Arrays.fill(array, fixedValue);
		return array;
	}

}
