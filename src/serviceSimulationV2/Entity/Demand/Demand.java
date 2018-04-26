package serviceSimulationV2.Entity.Demand;

import java.util.HashMap;
import java.util.List;

import serviceSimulationV2.Entity.Tag;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午4:58:15 
* 类说明  Demand的抽象接口
*/
public class Demand{
	HashMap<Tag, Integer> tagCount;

	public HashMap<Tag, Integer> getTagCount() {
		return tagCount;
	}

	public void setTagCount(HashMap<Tag, Integer> tagCount) {
		this.tagCount = tagCount;
	}
	
}
 