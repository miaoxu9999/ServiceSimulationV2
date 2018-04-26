package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.UsedNumberStragety;

import java.util.Arrays;
import java.util.List;

import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月27日 下午5:08:57 
* 类说明 固定使用策略
*/
public class FixedUsedNumberStragety implements Stragety<Integer>, UsedNumberStragety{

	@Override
	public Integer getStragetyValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return Arrays.asList(getStragetyValueArray(size));
	}

	@Override
	public Integer[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Integer[] nums = new Integer[size];
		for(int i = 0; i < size; i++)
		{
			nums[i] = getStragetyValue();
		}
		return nums;
	}

}
 