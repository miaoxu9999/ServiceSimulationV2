package serviceSimulationV2.Stragety;

import java.util.List;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月25日 上午10:41:14 
* 类说明 所有stragety的接口
*/
public interface Stragety<T> {
	T getStragetyValue();
	List<T> getStragetyValueList(int size );
	T[] getStragetyValueArray(int size);
}
 