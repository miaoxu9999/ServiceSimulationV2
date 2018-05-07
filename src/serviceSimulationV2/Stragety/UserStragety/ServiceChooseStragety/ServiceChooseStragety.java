package serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.Stragety.Stragety;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��28�� ����9:31:23 
* ��˵�� 
*/
public  abstract class ServiceChooseStragety implements Stragety<Service>{
	public abstract List<Service> getService(Demand demand, List<Service> services);
	
	/**
	 * ɾѡ����Demand��Service
	 * @param demand
	 * @param services
	 * @return
	 */
	public HashMap<Tag, List<Service>> filter(Demand demand, List<Service> services) {
		HashMap<Tag, Integer> tagCount = demand.getTagCount();
//		HashMap<Tag, Integer> tagCount = getTagCount();
		HashMap<Tag, List<Service>> taglists = new HashMap<>();
//		System.out.println(tagCount.keySet());
		for(Service s: services)
		{
			Tag tag = s.getTag();
//			System.out.println(tagCount.containsKey(tag));
			
			if (tagCount.containsKey(tag) ) {
				if (!taglists.containsKey(tag)) {
					ArrayList<Service> list = new ArrayList<>();
					list.add(s);
//					System.out.println(s);
					taglists.put(tag, list);
				}
				else
				{
					taglists.get(tag).add(s);
				}
			}
		}
		
		return taglists;
	}

}
 