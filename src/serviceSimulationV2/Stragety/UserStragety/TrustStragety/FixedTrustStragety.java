package serviceSimulationV2.Stragety.UserStragety.TrustStragety;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

public class FixedTrustStragety implements Stragety<Double>, TrustStragety{
	Double FixedValue;
	
	public FixedTrustStragety(Double fixedValue) {
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
