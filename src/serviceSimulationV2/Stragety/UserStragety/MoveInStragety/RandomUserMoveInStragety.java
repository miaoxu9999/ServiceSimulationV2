package serviceSimulationV2.Stragety.UserStragety.MoveInStragety;

import repast.simphony.random.RandomHelper;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午11:13:02 
* 类说明 
*/
public class RandomUserMoveInStragety extends UserMoveInStragety{

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return RandomHelper.nextIntFromTo(1, 10);
	}

}
 