package serviceSimulationV2.ServiceGenerator;

import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;
import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;
import serviceSimulationV2.Entity.Resource;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentServicePropertyManager;
import serviceSimulationV2.Stragety.Stragety;
import serviceSimulationV2.util.Generator;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午3:21:13 
* 类说明 随机生成Service
*/
public class RandomServiceGenerator extends ServiceGenerator{

	@Override
	public Service next() {
		// TODO Auto-generated method stub
		ISchedule schedule = RunEnvironment.getInstance().getCurrentSchedule();
		Stragety reputationStragety = CurrentServicePropertyManager.getReputationStragety();
	    Stragety resourceStragety = CurrentServicePropertyManager.getResourceStragety();
	    Stragety usedNumberStragety= CurrentServicePropertyManager.getUsedNumberStragety();
	    Stragety tagStragety = CurrentServicePropertyManager.getTagStragety();
		Service s = new Service(schedule.getTickCount(), CurrentContext.getCurrentSpace(), CurrentContext.getCurrentGrid(), (Tag) tagStragety.getStragetyValue(), (double) reputationStragety.getStragetyValue(), (Resource)resourceStragety.getStragetyValue());
		
		return s;
	}

}
 