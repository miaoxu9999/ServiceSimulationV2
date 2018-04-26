package serviceSimulationV2.Responsitorry;

import java.util.ArrayList;
import java.util.List;

import serviceSimulationV2.Entity.Service;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午11:26:56 
* 类说明 
*/
public class ServiceResponsitory {
	private static List<Service> list = new ArrayList<>();
	public static void add(Service service) {
		list.add(service);
	}
	public static List<Service> getList() {
		return list;
	}
	public static void setList(List<Service> list) {
		ServiceResponsitory.list = list;
	}
	
	
}
 