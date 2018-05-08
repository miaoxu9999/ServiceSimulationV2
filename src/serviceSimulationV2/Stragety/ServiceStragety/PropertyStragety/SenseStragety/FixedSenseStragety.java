package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.SenseStragety;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedSenseStragety implements SenseStragety, Stragety<Double>{
	Double FixedValue;
	
	public FixedSenseStragety(Double fixedValue) {
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
		Double[] senseArray = new Double[size];
		Arrays.fill(senseArray, FixedValue);
		return senseArray;
	}

}
