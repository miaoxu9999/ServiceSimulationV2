package serviceSimulationV2.Stragety.UserStragety.MoveInStragety;

import repast.simphony.random.RandomHelper;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��28�� ����11:13:02 
* ��˵�� 
*/
public class RandomUserMoveInStragety extends UserMoveInStragety{

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return RandomHelper.nextIntFromTo(1, 10);
	}

}
 