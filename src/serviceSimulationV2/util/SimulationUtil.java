package serviceSimulationV2.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import serviceSimulationV2.Enums.ResultEnum;
import serviceSimulationV2.Exception.MyException;



/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午3:37:24 
* 类说明 
*/
public  class SimulationUtil{
	
	/** 随机取num个从0到maxVal的tag。包括零，不包括maxValue
     * @param num 随机生成tag的数量
     * @param tags列表
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
    
    /** 随机指定范围内N个不重复的数 
    * 利用HashSet的特征，只能存放不同的值 
    * @param min 指定范围最小值 
    * @param max 指定范围最大值 
    * @param n 随机数个数 
    * @param HashSet<Integer> set 随机数结果集 
    */  
      public static void randomSet(int min, int max, int n, HashSet<Integer> set) {  
          if (n > (max - min + 1) || max < min) {  
              return;  
          }  
          for (int i = 0; i < n; i++) {  
              // 调用Math.random()方法  
              int num = (int) (Math.random() * (max - min)) + min;  
              set.add(num);// 将不同的数存入HashSet中  
          }  
          int setSize = set.size();  
          // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小  
          if (setSize < n) {  
           randomSet(min, max, n - setSize, set);// 递归  
          }  
      }  
	
	
}
 