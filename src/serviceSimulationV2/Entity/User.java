package serviceSimulationV2.Entity;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.environment.RunEnvironment;
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
* 
* �޸ģ� �ı�User�����ֲ���
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
	
	Principle principle;
	
	//�ɿ���
	private double reliablity;
		
	//�й�
	private double sense;
		
	//��ֲ��
	private double transform_ability;
		
	//��Ӧ��
	private double response;
	
	//����ֵ
	private double trust;
	
	
	
	
	public User(Demand demand, ServiceChooseStragety chooseStragety, ContinuousSpace<Object> space, Grid<Object> grid, Principle principle, double trust) {
		this(demand,chooseStragety, space, grid);
		this.principle = principle;
		this.trust = trust;
		}

	private User(Demand demand, ServiceChooseStragety chooseStragety, ContinuousSpace<Object> space, Grid<Object> grid) {
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
//		System.out.println(listServices+  "is being chooseed");
		for(Service s: listServices)
		{
			if (!network.isAdjacent(this, s)) {
				network.addEdge(this, s);
				s.setNumberUsed(s.getNumberUsed() + 1);
				choosedServices.add(s);
			}
			
		}
	}
	//��Ӷ���Service������
	@ScheduledMethod(start = 6, interval = 6, priority = 1)
	public void AddFeedback()
	{
		if (choosedServices != null) {
			for(Service s: choosedServices)
			{
				reliablity = (s.getReliablity() - this.principle.exp[0] +  s.getReliablity()) * this.principle.weight[0];
				sense = (s.getSense() - this.principle.exp[1] +  s.getSense()) * this.principle.weight[1];
				transform_ability = (s.getTransform_ability() - this.principle.exp[2]  + s.getTransform_ability()) * this.principle.weight[2];
				response = (s.getResponse() - this.principle.exp[3] + s.getResponse()) * this.principle.weight[3];
				Feedback feedback = new Feedback(this, RunEnvironment.getInstance().getCurrentSchedule().getTickCount(), 
						reliablity / principle.weight[0], sense / principle.weight[1], transform_ability / principle.weight[2], response / principle.weight[3]);
				double sum = reliablity + sense + transform_ability + response;
				double reputation = (s.getReputation() * s.getFeedBackCount() + sum) / (s.getFeedBackCount() + 1);
				s.addFeedback(feedback);
				reputation = Double.parseDouble(String.format("%.1f", reputation));
				s.setReputation(reputation);
				System.out.println(s.getId() + " " + s.getReputation());
			}
			
		}
	}

	
	public double getTrust() {
		return trust;
	}

	public void setTrust(double trust) {
		this.trust = trust;
	}

	public Principle getPrinciple() {
		return principle;
	}

	public void setPrinciple(Principle principle) {
		this.principle = principle;
	}
	
	
	
	
	
}
 