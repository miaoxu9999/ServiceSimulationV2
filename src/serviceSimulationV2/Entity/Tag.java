package serviceSimulationV2.Entity; 
/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����2:33:11 
* ��˵�� 
*/
public class Tag {
	//Service�����ĵ�һ�����𣬼�Service�Ĵ���
		private int firstLevel;
		//Service�����ĵڶ������𣬼�Service��С��
		private int secondLevel;
		
		public Tag(int firstLevel, int secondLevel) {
			super();
			this.firstLevel = firstLevel;
			this.secondLevel = secondLevel;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "��һ����" + firstLevel + "�ڶ�����" + secondLevel;
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
 