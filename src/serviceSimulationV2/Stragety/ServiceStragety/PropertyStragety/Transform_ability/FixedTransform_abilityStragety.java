package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.Transform_ability;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedTransform_abilityStragety implements Transform_abilityStragety, Stragety<Integer>{
	int FixedValue;
	
	public FixedTransform_abilityStragety(int fixedValue) {
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
		Integer[] array = new Integer[size];
		Arrays.fill(array, FixedValue);
		return array;
	}

}
