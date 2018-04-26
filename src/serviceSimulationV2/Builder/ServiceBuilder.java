package serviceSimulationV2.Builder;

import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.graph.NetworkBuilder;
import repast.simphony.context.space.grid.GridFactory;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;
import serviceSimulationV2.Manager.CurrentContext;
import serviceSimulationV2.Manager.CurrentServiceManager;
import serviceSimulationV2.Manager.CurrentServicePropertyManager;
import serviceSimulationV2.Manager.CurrentUserManager;
import serviceSimulationV2.MoveMent.ServiceMoveMent;
import serviceSimulationV2.MoveMent.UserMoveMent;
import serviceSimulationV2.ServiceGenerator.RandomServiceGenerator;
import serviceSimulationV2.Stragety.DemandStragety.RandomDemandStragety;
import serviceSimulationV2.Stragety.ServiceStragety.MoveInStragety.RandomServiceMoveInStragety;
import serviceSimulationV2.Stragety.ServiceStragety.MoveOutStragety.RandomMoveOutStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReputationStragety.RandomReputationStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ResourceStragety.RandomResourceStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.TagStragety.RandomTagStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.UsedNumberStragety.FixedUsedNumberStragety;
import serviceSimulationV2.Stragety.UserStragety.MoveInStragety.RandomUserMoveInStragety;
import serviceSimulationV2.UserGenerator.RandomUserGenerator;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����8:25:10 
* ��˵��  ����
*/
public class ServiceBuilder implements ContextBuilder<Object>{

	@Override
	public Context build(Context<Object> context) {
		// TODO Auto-generated method stub
		context.setId("ServiceSimulationV2");
		
		NetworkBuilder<Object> networkBuilder = new NetworkBuilder<>(
				"AgentServiceNetwork", context, true);
		networkBuilder.buildNetwork();
		
		ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder.createContinuousSpaceFactory(null);
		ContinuousSpace<Object> space = spaceFactory.createContinuousSpace(
				"space", context, new RandomCartesianAdder<Object>(), new repast.simphony.space.continuous.WrapAroundBorders(), 50,
				50);
		
		GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);
		Grid<Object> grid  = gridFactory.createGrid("grid",context, 
										new GridBuilderParameters<Object>(new WrapAroundBorders(), 
												new SimpleGridAdder<Object>(), true, 50, 50));
		
		setCurrentContextProperty(context, grid, space);
		setCurrentServiceManagerProperty();
		SetCurrentServicePropertyManager();
		setCurrentUserManagerProperty();
		
//		CurrentServiceManager.setCurrentServiceMoveOutStragety(new RandomServiceMoveOutStragety(context));
//		ServiceMoveMent serviceMoveMent = new ServiceMoveMent(context, space, grid);
		ServiceMoveMent serviceMoveMent = new ServiceMoveMent();

		context.add(serviceMoveMent);
//		
		UserMoveMent userMoveMent = new UserMoveMent();
		context.add(userMoveMent);
		
		return context;
	}
	
	/**
	 * ����CurrentContext���Ե�ֵ
	 * @param context
	 * @param grid
	 * @param space
	 */
	public void  setCurrentContextProperty(Context<Object> context, Grid<Object> grid, ContinuousSpace<Object> space) {
		CurrentContext.setCurrentContext(context);
		CurrentContext.setCurrentGrid(grid);
		CurrentContext.setCurrentSpace(space);
	}
	/**
	 * ����CurrentServiceManager���Ե�ֵ
	 */
	public void  setCurrentServiceManagerProperty() {
		CurrentServiceManager.setMoveInStragety(new RandomServiceMoveInStragety());
		CurrentServiceManager.setServiceGenerator(new RandomServiceGenerator());
		CurrentServicePropertyManager.setReputationStragety(new RandomReputationStragety());
		CurrentServiceManager.setMoveOutStragety(new RandomMoveOutStragety());
	}
	
	/**
	 * ����CurrentServicePropertyManager���Եĳ�ʼֵ
	 */
	public void SetCurrentServicePropertyManager() {
		CurrentServicePropertyManager.setTagStragety(new RandomTagStragety());
		CurrentServicePropertyManager.setUsedNumberStragety(new FixedUsedNumberStragety());
		CurrentServicePropertyManager.setResourceStragety(new RandomResourceStragety());
	}
	
	public void  setCurrentUserManagerProperty() {
		CurrentUserManager.setDemandStragety(new RandomDemandStragety());
		CurrentUserManager.setUsergenerator(new RandomUserGenerator());
		CurrentUserManager.setUserMoveInStragety(new RandomUserMoveInStragety());
	}

}
 