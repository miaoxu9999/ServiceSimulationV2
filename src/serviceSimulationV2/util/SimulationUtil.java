package serviceSimulationV2.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import serviceSimulationV2.Enums.ResultEnum;
import serviceSimulationV2.Exception.MyException;



/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����3:37:24 
* ��˵�� 
*/
public  class SimulationUtil{
	
	/** ���ȡnum����0��maxVal��tag�������㣬������maxValue
     * @param num �������tag������
     * @param tags�б�
     * @return
     */
    public static<T> List<T> getRandomClass(int num,List<T> services){
    	if (num == 0) {
			return null;
		}
        if(num<0 || services.size() < 1){
            throw new MyException(ResultEnum.SERVICENUMBERUNCORRECT);
        }
        List<T> result = new ArrayList<T>();
        
        HashSet<Integer> randomIndexSet = new HashSet<>();
        randomSet(0, services.size() - 1, num, randomIndexSet);
        for(Integer n: randomIndexSet)
        {
        	result.add(services.get(n));
        }


        return result;
    }
    
    /** ���ָ����Χ��N�����ظ����� 
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
	
	
}
 