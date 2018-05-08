package serviceSimulationV2.Entity;

/**
 * 用户对Service的评价
 * @author mx
 *
 */
public class Feedback {
	//可靠性
	private int reliablity;
			
	//感观
	private int sense;
			
	//移植性
	private int transform_ability;
			
	//响应性
	private double response;
	
	private User user;

	public Feedback(int reliablity, int sense, int transform_ability, double response, User user) {
		super();
		this.reliablity = reliablity;
		this.sense = sense;
		this.transform_ability = transform_ability;
		this.response = response;
		this.user = user;
	}
	


}
