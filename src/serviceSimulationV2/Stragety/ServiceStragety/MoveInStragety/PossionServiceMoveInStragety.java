package serviceSimulationV2.Stragety.ServiceStragety.MoveInStragety;

import java.util.HashMap;
import java.util.List;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Responsitorry.ServiceResponsitory;
import serviceSimulationV2.Responsitorry.TagResponsitory;

public class PossionServiceMoveInStragety extends MoveInStragety{
	/**
	 * 需要的服务对应的标签以及对应的服务数目
	 */
	private HashMap<Tag, Integer> hashMap;
	public PossionServiceMoveInStragety() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public HashMap<Tag, Integer> getStragetyValue() {
		hashMap = new HashMap<>();
		// TODO Auto-generated method stub
		int tickcount = (int)RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
		int num = (int) (RandomHelper.createPoisson(2).pdf(tickcount) * 31);
		List<Tag> tags = TagResponsitory.getTags();
		for(Tag tag: tags)
		{
			hashMap.put(tag, num);
		}
		return hashMap;
	}

	@Override
	public List<HashMap<Tag, Integer>> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Tag, Integer>[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
