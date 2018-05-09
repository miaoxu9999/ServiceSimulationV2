package serviceSimulationV2.Entity.Demand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.stringtemplate.v4.compiler.CodeGenerator.primary_return;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Responsitorry.TagResponsitory;
import serviceSimulationV2.util.MapData;
import serviceSimulationV2.util.Print;
import serviceSimulationV2.util.SimulationUtil;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午5:23:12 
* 类说明 
*/
public class RandomDemand extends Demand{
	HashMap<Tag, Integer> tagCount;
	public RandomDemand() {
		super();
		// TODO Auto-generated constructor stub
		tagCount = new HashMap<Tag, Integer>();
		
		//从tag中随机选取一个tag作为denmand
		int randindex = RandomHelper.nextIntFromTo(0, TagResponsitory.getTags().size());
		List<Tag> list = new ArrayList<>();
		list.add(TagResponsitory.getTags().get(randindex));
		
//		int num = RandomHelper.nextIntFromTo(1, list.size() - 1);
//		int num = 1;
//		List<Tag>l = SimulationUtil.getRandomClass(num, list);
//		tagCount = MapData.map(list, 1);
		tagCount = setTagCount(list);
		
	}
	
	private HashMap<Tag, Integer> setTagCount(List<Tag> list)
	{
		for(Tag t: list)
		{
			tagCount.put(t, 1);
		}
		return tagCount;
		
	}

	@Override
	public HashMap<Tag, Integer> getTagCount() {
		// TODO Auto-generated method stub
		return tagCount;
	}

	@Override
	public void setTagCount(HashMap<Tag, Integer> tagCount) {
		// TODO Auto-generated method stub
		this.tagCount = tagCount;                       
	}
	
	

	

}
 