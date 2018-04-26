package serviceSimulationV2.Entity;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.graph.Network;
import repast.simphony.space.grid.Grid;
import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Responsitorry.ServiceResponsitory;
import serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety.ServiceChooseStragety;


/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��28�� ����3:11:04 
* ��˵�� 
*/
public class User {
	private static long counter = 0;
    private final long id = counter++;
	//User������
	private Demand demand;
	//Userѡȡservice�Ĳ���
	private ServiceChooseStragety chooseStragety;
	//Userѡ���Service�б�
	private List<Service> choosedServices;
		
	//Agent�����Ŀռ䣬����λ��
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	public User(Demand demand, ServiceChooseStragety chooseStragety, ContinuousSpace<Object> space, Grid<Object> grid) {
		super();
		this.demand = demand;
		this.chooseStragety = chooseStragety;
		this.space = space;
		this.grid = grid;
		choosedServices = new ArrayList<>();
	}
	
	@ScheduledMethod(start = 5, interval = 5, priority = 1)
	public void chooseService() {
		
		List<Service> listServices = chooseStragety.getService(demand, ServiceResponsitory.getList());
		Context<Object> context = CurrentContext.getCurrentContext();
		Network<Object> network = (Network<Object>) context.getProjection("AgentServiceNetwork");
		for(Service s: listServices)
		{
			if (!network.isAdjacent(this, s)) {
				network.addEdge(this, s);
				choosedServices.add(s);
			}
			
		}
	}
	//����Service��reputationֵ
	@ScheduledMethod(start = 6, interval = 6, priority = 1)
	public void updateService()
	{
		if (choosedServices != null) {
			for(Service s: choosedServices)
			{
				double d = RandomHelper.createBinomial(10, 0.3).nextDouble();
				s.setReputation(d);
				s.getReputationList().add(d);
			}
			
		}
	}
	
	
	
}
 