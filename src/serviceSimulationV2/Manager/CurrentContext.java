package serviceSimulationV2.Manager;

import repast.simphony.context.Context;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����8:45:55 
* ��˵�� 
*/
public class CurrentContext {
	private static Context currentContext;
	private static ContinuousSpace<Object> currentSpace;
	private static Grid<Object> currentGrid;
	public static Context getCurrentContext() {
		return currentContext;
	}
	public static void setCurrentContext(Context currentContext1) {
		CurrentContext.currentContext = currentContext1;
	}
	public static ContinuousSpace<Object> getCurrentSpace() {
		return currentSpace;
	}
	public static void setCurrentSpace(ContinuousSpace<Object> currentSpace1) {
		CurrentContext.currentSpace = currentSpace1;
	}
	public static Grid<Object> getCurrentGrid() {
		return currentGrid;
	}
	public static void setCurrentGrid(Grid<Object> currentGrid1) {
		CurrentContext.currentGrid = currentGrid1;
	}
	
}
 