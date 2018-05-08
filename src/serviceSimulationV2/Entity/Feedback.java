package serviceSimulationV2.Entity;

/**
 * 用户对Service的评价
 * @author mx
 *
 */
public class Feedback {
	
	//评价的用户
	private User user;
	//评价的时间
	private double time;

	//可靠性
	private double reliablity;
			
	//感观
	private double sense;
			
	//移植性
	private double transform_ability;
			
	//响应性
	private double response;

	public Feedback(User user, double time, double reliablity, double sense, double transform_ability,
			double response) {
		super();
		this.user = user;
		this.time = time;
		this.reliablity = reliablity;
		this.sense = sense;
		this.transform_ability = transform_ability;
		this.response = response;
	}
	
	
	

	
	


}
