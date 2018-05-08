package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.Transform_ability;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedTransform_abilityStragety implements Transform_abilityStragety, Stragety<Double>{
	Double FixedValue;
	
	public FixedTransform_abilityStragety(Double fixedValue) {
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
		Double[] array = new Double[size];
		Arrays.fill(array, FixedValue);
		return array;
	}

}
