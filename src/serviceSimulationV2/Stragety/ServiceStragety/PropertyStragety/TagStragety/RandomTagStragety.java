package serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.TagStragety;

import java.util.Arrays;
import java.util.List;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Responsitorry.TagResponsitory;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月27日 下午4:58:08 
* 类说明 
*/
public class RandomTagStragety implements TagStragety<Tag>, Stragety<Tag>{

	@Override
	public Tag getStragetyValue() {
		// TODO Auto-generated method stub
		List<Tag> list = TagResponsitory.getTags();
		//随机生成选择tag的序号
		int randindex = RandomHelper.nextIntFromTo(1, list.size() - 1);
		return list.get(randindex);
	}

	@Override
	public List<Tag> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return Arrays.asList(getStragetyValueArray(size));
	}

	@Override
	public Tag[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Tag[] tags = new Tag[size];
		for(int i = 0; i < size; i++)
		{
			tags[i] = getStragetyValue();
		}
		return tags;
	}

}
 