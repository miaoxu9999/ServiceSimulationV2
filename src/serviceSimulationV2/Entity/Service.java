package serviceSimulationV2.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;import org.apache.poi.hssf.record.UseSelFSRecord;

import bibliothek.gui.dock.action.FilteredDockActionSource;
import bsh.This;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;
import repast.simphony.engine.schedule.ScheduleParameters;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;
import serviceSimulationV2.Manager.CurrentServiceManager;
import serviceSimulationV2.Manager.CurrentServicePropertyManager;


/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����2:32:08 
* ��˵�� 
*/
public class Service {
	//	Service������
	private static long counter = 0;
    private final long id = counter++;
    //�趨�ķ����ʼ��֧���Ǯ��
    private static  double firstvalue;
    int count = 0;
	private Tag tag;
	
	//����
	private double reputation;
	//���������ʱ��
	private double birthTime;
	//����ʹ�õĴ���
	private int numberUsed;
	//������Դ
	private Resource resource;
	
	
	//service�����Ŀռ䣬����λ��
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	
	//�û�������reputation List
	private List<Double> reputationList;
	
	//�ɿ���
	private double reliablity;
	
	//�й�
	private double sense;
	
	//��ֲ��
	private double transform_ability;
	
	//��Ӧ��
	private double response;
	
	//����ѡ��Service���û���Service������
	private List<Feedback> feedbacks;
	
	//����ĳ�ʼ��֧����
	private  double initial_capital;
	
	//����ĸ��³ɱ�
	private double update_cost;
	
	public Service(double birthTime, ContinuousSpace<Object> space,
			Grid<Object> grid, Tag tag, double reputation,Resource resource, double reliablity, double sense,
			double transform_ability, double response) {
		this(birthTime, space,
			 grid,  tag,  reputation, resource);
		
		this.reliablity = reliablity;
		this.sense = sense;
		this.transform_ability = transform_ability;
		this.response = response;
		
		feedbacks = new ArrayList<>();
	}

	//

	public Service(  double birthTime, ContinuousSpace<Object> space,
			Grid<Object> grid, Tag tag, double reputation,Resource resource) {
		super();
		this.tag = tag;
		this.reputation = reputation;
		this.birthTime = birthTime;
		this.resource = resource;
		this.space = space;
		this.grid = grid;
		numberUsed = 0;
		reputationList = new ArrayList<>();
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public double getReputation() {
		return reputation;
	}

	public void setReputation(double reputation) {
		if (reputation < 0) {
			this.reputation = 0;
		}
		else if (reputation > 10) {
			this.reputation = 10;
		}
		else {
			this.reputation = reputation;
		}
	}
	
	public  long getId() {
		return id;
	}

	public double getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(double birthTime) {
		this.birthTime = birthTime;
	}

	public int getNumberUsed() {
		return numberUsed;
	}

	public void setNumberUsed(int numberUsed) {
		this.numberUsed = numberUsed;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ContinuousSpace<Object> getSpace() {
		return space;
	}

	public void setSpace(ContinuousSpace<Object> space) {
		this.space = space;
	}

	public Grid<Object> getGrid() {
		return grid;
	}

	public void setGrid(Grid<Object> grid) {
		this.grid = grid;
	}

	public List<Double> getReputationList() {
		return reputationList;
	}

	public void setReputationList(List<Double> reputationList) {
		this.reputationList = reputationList;
	}

	public double getReliablity() {
		return reliablity;
	}

	public void setReliablity(int reliablity) {
		this.reliablity = reliablity;
	}

	public double getSense() {
		return sense;
	}

	public void setSense(int sense) {
		this.sense = sense;
	}

	public double getTransform_ability() {
		return transform_ability;
	}

	public void setTransform_ability(int transform_ability) {
		this.transform_ability = transform_ability;
	}

	public double getResponse() {
		return response;
	}

	public void setResponse(double response) {
		this.response = response;
	}
	
	/**
	 * 
	 */
	public void addFeedback(Feedback feedback) {
		feedbacks.add(feedback);
	}
	
	public int  getFeedBackCount() {
		return feedbacks.size();
	}
	
	/**
	 * ����ĸ��£��۲��û��������������Լ��û���Trustֵ��User�й۲������δ���
	 */
//	@Watch(watcheeClassName ="serviceSimulationV2.Entity.User", watcheeFieldNames = "reliablity,"
//			+ "sense,"
//			+ "transform_ability"
//			+ "response",
//			
//			whenToTrigger = WatcherTriggerSchedule.IMMEDIATE, query = "linked_from ['network name']", 
//			triggerCondition = "")
	@ScheduledMethod(start = 10, interval = 10, priority = 3)
	public void Update()
	{
		//ʹ�õ����� * ����ֵ����ĳһ��ֵ || reputation��ֵ����ĳ��ֵ
		HashSet<User> users = new HashSet<>();
		Feedback feedback_all = new Feedback(null, 0, 0, 0, 0, 0);
		
		double updatevalue = getUpdate_cost();
		if (numberUsed >= 1 && (initial_capital - updatevalue) > 0 && reputation > 0) {
			//���User������reliability * User��Trustֵ�ĺ� С��ĳһ��ֵ������reliability
			getAllUserFeedback(users, feedback_all);
			if (feedback_all.getReliablity() < 6) {
				updateUserFactor("Reliablity", 5.0, reliablity + 1);
				updateUserTrust("Reliablity", feedback_all.getReliablity(), 0.1);
			}
			if (feedback_all.getSense() < 6) {
				updateUserFactor("Sense", 5.0, sense + 1);
				updateUserTrust("Sense", feedback_all.getReliablity(), 0.1);
			}
			if (feedback_all.getTransform_ability() < 6) {
				updateUserFactor("Transform_ability", 5.0, transform_ability + 1);
				updateUserTrust("Transform_ability", feedback_all.getReliablity(), 0.1);

			}
			if (feedback_all.getResponse() < 6) {
				updateUserTrust("Response", feedback_all.getReliablity(), 0.1);
				if (this.getResponse() > 2) {
					updateUserFactor("Response", 5.0, response + 1.5);
				}
				else
				{
					updateUserFactor("Response", 5.0, response + 2.5);
				}
			}
			if (reputation > CurrentServiceManager.getReputationupdatecondition() || numberUsed > 10) {
				double addvalue = reputation - CurrentServiceManager.getReputationupdatecondition();
				addvalue = addvalue * 100; 
				setInitial_capital(addvalue + getInitial_capital());
			}
			
			if (getInitial_capital() > 4000 && getInitial_capital() < firstvalue * 2) {
				setReputation(getReputation() + 0.00001 * (getInitial_capital() - 2000));
			}
		}
		
		if (getInitial_capital() < firstvalue / 2) {
			if (getReputation() > 5) {
				setReputation(getReputation() - 0.001 * (2000 - getInitial_capital()));
			}
		}
		
	}
	
	/** 
	 * �����û���Trustֵ
	 * @param type
	 * @param value
	 * @param range
	 */
	public void updateUserTrust(String type, double value,double range) {
		
		double addvalue = 0.1;
		// Χ��ĳһ�㸡�����£��������Χ�ĸ���         
		for(Feedback feedback: feedbacks)
		{
			User user = feedback.getUser();
			double currrenttime = RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
			if (currrenttime - feedback.getTime()  >= 10 && currrenttime - feedback.getTime()  <= 15) {
				if (type.equals("Reliablity")) {
					if (feedback.getReliablity() >= value - range && feedback.getReliablity() <= value + range) {
						if (user.getTrust() + addvalue < 1) {
							user.setTrust(user.getTrust() + addvalue);
						}
						
					}
					else
					{
						if (user.getTrust() - addvalue > 0)
						{
							user.setTrust(user.getTrust() - addvalue);
						}
						
					}
				}
				else if (type.equals("Sense")) {
					if (feedback.getSense() >= value - range && feedback.getReliablity() <= value + range)
					{
						if (user.getTrust() + addvalue < 1) {
							user.setTrust(user.getTrust() + addvalue);
						}
					}
					else
					{
						if (user.getTrust() - addvalue > 0)
						{
							user.setTrust(user.getTrust() - addvalue);
						}
					}
				}
				else if (type.equals("Transform_ability")) {
					if (feedback.getTransform_ability() >= value - range && feedback.getReliablity() <= value + range)
					{
						if (user.getTrust() + addvalue < 1) {
							user.setTrust(user.getTrust() + addvalue);
						}
					}
					else
					{
						if (user.getTrust() - addvalue > 0)
						{
							user.setTrust(user.getTrust() - addvalue);
						}
					}
				}
				else if (type.equals("Response")) {
					if (feedback.getResponse() >= value - range && feedback.getReliablity() <= value + range)
					{
						if (user.getTrust() + addvalue < 1) {
							user.setTrust(user.getTrust() + addvalue);
						}
					}
					else
					{
						if (user.getTrust() - addvalue > 0)
						{
							user.setTrust(user.getTrust() - addvalue);
						}
					}
				}
			}
		}
	}
	
	public void  updateFactorValue(String type, double value) {
		if (type.equals("Reliablity")) {
			this.reliablity = value;
		}
		else if (type.equals("Sense")) {
			this.sense = value;
		}
		else if (type.equals("Transform_ability")) {
			this.transform_ability = value;
		}
		else if (type.equals("Response")) {
			this.response = value;
		}
	}
	
	/**
	 * �����û��������ĸ�Ҫ��
	 * @param type ������������
	 * @param time ��һ�θ��µ�ʱ��
	 * @param newvalue �趨����ֵ
	 */
	public void updateUserFactor(String type, double time, double newvalue) {
		ISchedule schedule = RunEnvironment.getInstance().getCurrentSchedule();
		double current_tick = schedule.getTickCount();
		ScheduleParameters scheduleParameters = ScheduleParameters.createOneTime(current_tick + time, 1);
		schedule.schedule(scheduleParameters, this, "updateFactorValue", type, newvalue);
		
		//���³�ʼ�ʲ�
		setInitial_capital(getInitial_capital() - getUpdate_cost());
	}
	
	
	
	public void getAllUserFeedback(HashSet<User> users, Feedback feedbackall) {
		double r = 0, s = 0, t = 0 , a = 0;
		for(Feedback feedback: feedbacks)
		{
			
			User user = feedback.getUser();
			Principle principle = user.getPrinciple();
			users.add(user);
			//��ǰ�û������Ŀ���������
			 r += feedback.getReliablity() * user.getTrust();
			 s += feedback.getSense() * user.getTrust();
			 t += feedback.getTransform_ability() * user.getTrust();
			 a += feedback.getResponse() * user.getTrust();
			
		}
		
		feedbackall.setReliablity((r / feedbacks.size() ));
		feedbackall.setSense((s / feedbacks.size() )) ;
		feedbackall.setTransform_ability((t / feedbacks.size() ));
		feedbackall.setResponse((a / feedbacks.size() ));
		
	}

	public double getInitial_capital() {
		return initial_capital;
	}

	public void setInitial_capital(double initial_capital) {
		if (count == 0) {
			firstvalue = initial_capital;
			count++;
		}
		if (initial_capital < 500) {
			this.initial_capital = 500;
		}
		else {
			this.initial_capital = initial_capital;
		}
		
	}

	public double getUpdate_cost() {
		return (double)CurrentServicePropertyManager.getCostUpdateStragety().getStragetyValue();
	}

	public void setUpdate_cost(double update_cost) {
		this.update_cost = update_cost;
	}
	
	
	
	
	
	
	

}
 