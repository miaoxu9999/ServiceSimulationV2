package serviceSimulationV2.Entity; 
/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午2:33:11 
* 类说明 
*/
public class Tag {
	//Service所处的第一个级别，即Service的大类
		private int firstLevel;
		//Service所处的第二个级别，即Service的小类
		private int secondLevel;
		
		public Tag(int firstLevel, int secondLevel) {
			super();
			this.firstLevel = firstLevel;
			this.secondLevel = secondLevel;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "第一级别" + firstLevel + "第二级别" + secondLevel;
		}
		
//		@Override
//	    public boolean equals(Object obj) {
//			if (obj instanceof Tag) {
//				Tag tag = (Tag) obj;
//			if (tag.firstLevel == this.firstLevel && tag.secondLevel == this.secondLevel) {
//				return true;
//			}
//			}
//	        return false;
//	    } 
}
 