package serviceSimulationV2.Stragety;

import java.util.List;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��25�� ����10:41:14 
* ��˵�� ����stragety�Ľӿ�
*/
public interface Stragety<T> {
	T getStragetyValue();
	List<T> getStragetyValueList(int size );
	T[] getStragetyValueArray(int size);
}
 