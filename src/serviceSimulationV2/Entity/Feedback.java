package serviceSimulationV2.Entity;

/**
 * �û���Service������
 * @author mx
 *
 */
public class Feedback {
	
	//���۵��û�
	private User user;
	//���۵�ʱ��
	private double time;

	//�ɿ���
	private double reliablity;
			
	//�й�
	private double sense;
			
	//��ֲ��
	private double transform_ability;
			
	//��Ӧ��
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
