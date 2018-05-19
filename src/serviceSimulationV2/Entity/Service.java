package serviceSimulationV2.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;import org.apache.poi.hssf.record.UseSelFSRecord;

import bibliothek.gui.dock.action.FilteredDockActionSource;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ISchedule;
import repast.simphony.engine.schedule.ScheduleParameters;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;


/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午2:32:08 
* 类说明 
*/
public class Service {
	//	Service的属性
	private static long counter = 0;
    private final long id = counter++;
	private Tag tag;
	
	//评分
	private double reputation;
	//服务产生的时间
	private double birthTime;
	//服务被使用的次数
	private int numberUsed;
	//服务资源
	private Resource resource;
	
	
	//service所处的空间，网格位置
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	
	//用户给出的reputation List
	private List<Double> reputationList;
	
	//可靠性
	private double reliablity;
	
	//感观
	private double sense;
	
	//移植性
	private double transform_ability;
	
	//响应性
	private double response;
	
	//所有选择Service的用户对Service的评价
	private List<Feedback> feedbacks;
	
	//服务的初始可支配金额
	private  double initial_capital;
	
	//服务的更新成本
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
		this.reputation = reputation;
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
	 * 服务的更新，观察用户的评价数量，以及用户的Trust值，User中观察的属性未完成
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
		//使用的数量 * 信任值大于某一个值 || reputation的值低于某个值
		HashSet<User> users = new HashSet<>();
		Feedback feedback_all = new Feedback(null, 0, 0, 0, 0, 0);
		getAllUserFeedback(users, feedback_all);
		if (numberUsed >= 1 ) {
			//如果User反馈的reliability * User的Trust值的和 小于某一个值，更新reliability
			if (feedback_all.getReliablity() < -1) {
				updateUserFactor("Reliablity", 5.0, reliablity + 0.1);
			}
			if (feedback_all.getSense() < -1) {
				updateUserFactor("Sense", 5.0, sense + 0.1);
			}
			if (feedback_all.getTransform_ability() < -1) {
				updateUserFactor("Transform_ability", 5.0, transform_ability + 0.1);
			}
			if (feedback_all.getResponse() < 6) {
				if (this.getResponse() > 1) {
					updateUserFactor("Response", 5.0, response - 0.1);
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
	 * 更新用户衡量的四个要素
	 * @param type 更新哪种类型
	 * @param time 下一次更新的时间
	 * @param newvalue 设定的新值
	 */
	public void updateUserFactor(String type, double time, double newvalue) {
		ISchedule schedule = RunEnvironment.getInstance().getCurrentSchedule();
		double current_tick = schedule.getTickCount();
		ScheduleParameters scheduleParameters = ScheduleParameters.createOneTime(current_tick + time, 1);
		schedule.schedule(scheduleParameters, this, "updateFactorValue", type, newvalue);
	}
	
	
	public void getAllUserFeedback(HashSet<User> users, Feedback feedbackall) {
		for(Feedback feedback: feedbacks)
		{
			User user = feedback.getUser();
			Principle principle = user.getPrinciple();
			users.add(user);
			//当前用户给出的可用性评价
			double r = (principle.getExp()[0] - reliablity) * principle.getWeight()[0] * user.getTrust();
			feedback.setReliablity(feedback.getReliablity() + r);
			double s = (principle.getExp()[1] - sense) * principle.getWeight()[1] * user.getTrust();
			feedback.setSense(feedback.getSense() + s);
			double t = (principle.getExp()[2] - transform_ability) * principle.getWeight()[2] * user.getTrust();
			feedback.setTransform_ability(feedback.getTransform_ability() + t);
			double a = (principle.getExp()[3] - response) * principle.getWeight()[3] * user.getTrust();
			feedback.setResponse(feedback.getResponse() + a);
		}
		
	}

	public double getInitial_capital() {
		return initial_capital;
	}

	public void setInitial_capital(double initial_capital) {
		this.initial_capital = initial_capital;
	}

	public double getUpdate_cost() {
		return update_cost;
	}

	public void setUpdate_cost(double update_cost) {
		this.update_cost = update_cost;
	}
	
	

	
	
	
	
	

}
 