package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ResourceStragety;

import java.util.Arrays;
import java.util.List;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Resource;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月27日 下午5:32:33 
* 类说明 
*/
public class RandomResourceStragety implements ResourceStragety, Stragety<Resource>{

	@Override
	public Resource getStragetyValue() {
		// TODO Auto-generated method stub
		Resource resource = new Resource(RandomHelper.nextInt());
		return resource;
	}

	@Override
	public List<Resource> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return Arrays.asList(getStragetyValueArray(size));
	}

	@Override
	public Resource[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Resource[] resources = new Resource[size];
		for (int i = 0; i < resources.length; i++) {
			resources[i] = getStragetyValue();
		}
		return resources;
	}

}
 