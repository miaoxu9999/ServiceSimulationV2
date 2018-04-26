package serviceSimulationV2.MoveMent;

import java.util.HashMap;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import serviceSimulationV2.Entity.Resource;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentServiceManager;
import serviceSimulationV2.Manager.CurrentServicePropertyManager;
import serviceSimulationV2.Responsitorry.ServiceResponsitory;
import serviceSimulationV2.ServiceGenerator.ServiceGenerator;
import serviceSimulationV2.Stragety.Stragety;


/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午3:52:34 
* 类说明 
*/
public class ServiceMoveMent {
	private Context context;
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	public ServiceMoveMent() {
		super();
		this.context = CurrentContext.getCurrentContext();
		this.space = CurrentContext.getCurrentSpace();
		this.grid = CurrentContext.getCurrentGrid();
	}
	
	@ScheduledMethod(start = 1, interval = 1, priority = 3)
	public void Appendent()
	{
		HashMap<Tag, Integer> service = (HashMap<Tag, Integer>) CurrentServiceManager.getMoveInStragety().getStragetyValue();
		ServiceGenerator serviceGenerator = CurrentServiceManager.getServiceGenerator();
		for(java.util.Map.Entry<Tag, Integer> entry: service.entrySet())
		{
			Tag tag = entry.getKey();
			int num = entry.getValue();
			for (int i = 0; i < num; i++) {
				Service s = serviceGenerator.next();
				context.add(s);
				ServiceResponsitory.add(s);
			}
		}
		
	}
	/**
	 * 服务的消失
	 */
	@ScheduledMethod(start = 6, interval = 50, priority = 3)
	public void MoveOut() {
		int randomnum = RandomHelper.nextIntFromTo(1, 120);
		List<Service> services = CurrentServiceManager.getMoveOutStragety().getStragetyValueList(randomnum);
		Context<Object> context = CurrentContext.getCurrentContext();
		for(Service s: services)
		{
			context.remove(s);
			ServiceResponsitory.getList().remove(s);
		}
		
	}

}
 