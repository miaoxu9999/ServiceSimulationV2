package serviceSimulationV2.Entity.Demand;

import java.util.HashMap;
import java.util.List;

import serviceSimulationV2.Entity.Tag;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��28�� ����4:58:15 
* ��˵��  Demand�ĳ���ӿ�
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
 