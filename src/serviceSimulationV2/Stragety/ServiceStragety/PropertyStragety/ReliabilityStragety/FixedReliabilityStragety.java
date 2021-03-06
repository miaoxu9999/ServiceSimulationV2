package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReliabilityStragety;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedReliabilityStragety implements ReliabilityStragety, Stragety<Double>{
	Double FixedValue;
	
	public FixedReliabilityStragety(Double fixedValue) {
		super();
		FixedValue = fixedValue;
	}

	@Override
	public Double getStragetyValue() {
		// TODO Auto-generated method stub
		return FixedValue;
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
		Double[] reliablityArray = new Double[size];
		Arrays.fill(reliablityArray, FixedValue);
		return reliablityArray;
	}

}
