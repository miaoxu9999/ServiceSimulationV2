package serviceSimulationV2.Stragety.ServiceStragety.MoveInStragety;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Enums.ResultEnum;
import serviceSimulationV2.Exception.MyException;
import serviceSimulationV2.Responsitorry.TagResponsitory;


/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����4:05:23 
* ��˵�� 
*/
public class RandomServiceMoveInStragety extends MoveInStragety{
	/**
	 * ��Ҫ�ķ����Ӧ�ı�ǩ�Լ���Ӧ�ķ�����Ŀ
	 */
	private HashMap<Tag, Integer> hashMap;
	

	public RandomServiceMoveInStragety() {
		int num = RandomHelper.nextIntFromTo(1, 10);
		hashMap = new HashMap<Tag, Integer>();
		List<Tag> tags = TagResponsitory.getAllTags();
		List<Tag> randomIndexTags = getRandomTags(num, tags);
		for (int i = 0; i < randomIndexTags.size(); i++) {
			hashMap.put(randomIndexTags.get(i), RandomHelper.nextIntFromTo(1, 10));
		}
	}

	
	
	/**
     * ���ȡnum����0��maxVal��tag�������㣬������maxValue
     * @param num �������tag������
     * @param tags�б�
     * @return
     */
    public static List<Tag> getRandomTags(int num,List<Tag> tags){
        if(num<0 || tags.size() < 1){
            throw new MyException(ResultEnum.TAGNUMBERUNCORRECT);
        }
        List<Tag> result = new ArrayList<Tag>();
        
        HashSet<Integer> randomIndexSet = new HashSet<>();
        randomSet(0, tags.size() - 1, num, randomIndexSet);
        for(Integer n: randomIndexSet)
        {
        	result.add(tags.get(n));
        }


        return result;
    }
    
    /** 
     * ���ָ����Χ��N�����ظ����� 
     * ����HashSet��������ֻ�ܴ�Ų�ͬ��ֵ 
     * @param min ָ����Χ��Сֵ 
     * @param max ָ����Χ���ֵ 
     * @param n ��������� 
     * @param HashSet<Integer> set ���������� 
     */  
       public static void randomSet(int min, int max, int n, HashSet<Integer> set) {  
           if (n > (max - min + 1) || max < min) {  
               return;  
           }  
           for (int i = 0; i < n; i++) {  
               // ����Math.random()����  
               int num = (int) (Math.random() * (max - min)) + min;  
               set.add(num);// ����ͬ��������HashSet��  
           }  
           int setSize = set.size();  
           // ����������С��ָ�����ɵĸ���������õݹ�������ʣ�����������������ѭ����ֱ���ﵽָ����С  
           if (setSize < n) {  
            randomSet(min, max, n - setSize, set);// �ݹ�  
           }  
       }

	@Override
	public HashMap<Tag, Integer> getStragetyValue() {
		// TODO Auto-generated method stub
		return hashMap;
	}

	@Override
	public List<HashMap<Tag, Integer>> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public HashMap<Tag, Integer>[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		return null;
	}  
}
 