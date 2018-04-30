package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.SenseStragety;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedSenseStragety implements SenseStragety, Stragety<Integer>{
	int FixedValue;
	
	public FixedSenseStragety(int fixedValue) {
		super();
		FixedValue = fixedValue;
	}

	@Override
	public Integer getStragetyValue() {
		// TODO Auto-generated method stub
		return FixedValue;
	}

	@Override
	public List<Integer> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(getStragetyValueArray(size));
		
		return list;
	}

	@Override
	public Integer[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Integer[] senseArray = new Integer[size];
		Arrays.fill(senseArray, FixedValue);
		return senseArray;
	}

}
