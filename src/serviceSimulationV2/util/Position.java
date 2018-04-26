package serviceSimulationV2.util;

import repast.simphony.context.Context;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import serviceSimulationV2.Manager.CurrentContext;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月28日 下午3:49:55 
* 类说明 
*/
public class Position {
	public static void SetRightPosition() {
	 Context context = CurrentContext.getCurrentContext();
	 ContinuousSpace<Object> space = CurrentContext.getCurrentSpace();
	 Grid<Object> grid = CurrentContext.getCurrentGrid();
		for(Object obj: context)
		{
			NdPoint point = space.getLocation(obj);
			grid.moveTo(obj, (int) point.getX(), (int) point.getY());
		}
	}

}
 