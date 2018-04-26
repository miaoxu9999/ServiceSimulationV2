package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReputationStragety;

import java.util.Arrays;
import java.util.List;


import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����8:35:22 
* ��˵�� 
*/
public class RandomReputationStragety implements Stragety<Double>, ReputationStragety{

	@Override
	public Double getStragetyValue() {
		// TODO Auto-generated method stub
		
		return RandomHelper.nextDouble();
	}

	@Override
	public List<Double> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		List<Double> res = Arrays.asList(getStragetyValueArray(size));
		return res;
	}

	@Override
	public Double[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Double[] res = new Double[size];
		for (int i = 0; i < res.length; i++) {
			res[i] = getStragetyValue();
		}
		return res;
	}

}
 