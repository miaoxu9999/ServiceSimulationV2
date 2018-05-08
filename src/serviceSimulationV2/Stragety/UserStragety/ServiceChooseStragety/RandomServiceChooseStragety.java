package serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.analysis.function.Min;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.stringtemplate.v4.compiler.STParser.element_return;

import com.sun.net.httpserver.Filter;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Responsitorry.TagResponsitory;
import serviceSimulationV2.util.MapData;
import serviceSimulationV2.util.SimulationUtil;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午9:36:38 
* 类说明 
*/
public class RandomServiceChooseStragety extends ServiceChooseStragety{

	@Override
	public Service getStragetyValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> getService(Demand demand, List<Service> services) {
		// TODO Auto-generated method stub
		if (demand == null) {
			return SimulationUtil.getRandomClass(RandomHelper.nextIntFromTo(1, services.size() / 2 + 1), services);
		}
		else
		{
			HashMap<Tag, List<Service>> taglists = filter(demand, services);
//			HashMap<Tag, List<Service>> taglists = services;
			
			ArrayList<Service> list = new ArrayList<>();
			for(Map.Entry<Tag, List<Service>> entry: taglists.entrySet())
			{
				Tag tag = entry.getKey();
				List<Service> services2 = entry.getValue();
				int requireNum = 1;
				int currentnum = services2.size();
				List<Service> tempList = SimulationUtil.getRandomClass(Math.min(requireNum, currentnum), services2);
				for(Service s: tempList)
				{
					list.add(s);
				}
				
			}
		   return list;
		}
	}
	
	
	private HashMap<Tag, Integer> getTagCount()
	{
		//得到所有的Tag
				List<Tag> tags = TagResponsitory.getTags();
				HashMap<Tag, Integer> demandstragetyMap = new HashMap<>();
				//一个tag和数量的hashmap表
				for (Tag tag: tags) {
//					demandstragetyMap.put(tag, num);
					demandstragetyMap.put(tag, 1);
				}
		return demandstragetyMap;
	}


	@Override
	public void doExtraWork(List<Service> services) {
		// TODO Auto-generated method stub
		
	}

}
 