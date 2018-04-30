package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReliabilityStragety;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedReliabilityStragety implements ReliabilityStragety, Stragety<Integer>{
	int FixedValue;
	
	public FixedReliabilityStragety(int fixedValue) {
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
		Integer[] reliablityArray = new Integer[size];
		Arrays.fill(reliablityArray, FixedValue);
		return reliablityArray;
	}

}
