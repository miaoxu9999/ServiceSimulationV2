package serviceSimulationV2.Entity;

/**
 * �û���Service������
 * @author mx
 *
 */
public class Feedback {
	//�ɿ���
	private int reliablity;
			
	//�й�
	private int sense;
			
	//��ֲ��
	private int transform_ability;
			
	//��Ӧ��
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
