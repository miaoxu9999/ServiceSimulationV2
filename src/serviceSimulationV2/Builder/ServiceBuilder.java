package serviceSimulationV2.Builder;


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
import serviceSimulationV2.Responsitorry.TagResponsitory;
import serviceSimulationV2.ServiceGenerator.RandomServiceGenerator;
import serviceSimulationV2.Stragety.DemandStragety.RandomDemandStragety;
import serviceSimulationV2.Stragety.ServiceStragety.MoveInStragety.PossionServiceMoveInStragety;
import serviceSimulationV2.Stragety.ServiceStragety.MoveInStragety.RandomServiceMoveInStragety;
import serviceSimulationV2.Stragety.ServiceStragety.MoveOutStragety.FixedMoveOutStragety;
import serviceSimulationV2.Stragety.ServiceStragety.MoveOutStragety.RandomMoveOutStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReliabilityStragety.FixedReliabilityStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReputationStragety.FixedReputationStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ReputationStragety.RandomReputationStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ResourceStragety.RandomResourceStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.ResponseStragety.FixedResponseStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.SenseStragety.FixedSenseStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.TagStragety.RandomTagStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.Transform_ability.FixedTransform_abilityStragety;
import serviceSimulationV2.Stragety.ServiceStragety.PropertyStragety.UsedNumberStragety.FixedUsedNumberStragety;
import serviceSimulationV2.Stragety.UserStragety.MoveInStragety.FixedUserMoveInStragety;
import serviceSimulationV2.Stragety.UserStragety.MoveInStragety.RandomUserMoveInStragety;
import serviceSimulationV2.Stragety.UserStragety.PrincipleStragety.FixedPrincipleStragety;
import serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety.ReputationFirstChooseStragety;
import serviceSimulationV2.Stragety.UserStragety.TrustStragety.FixedTrustStragety;
import serviceSimulationV2.UserGenerator.RandomUserGenerator;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午8:25:10 
* 类说明  Service Builder 用来构建
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
		
		TagResponsitory.getAllTags();
		
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
	 * 设置CurrentContext属性的值
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
	 * 设置CurrentServiceManager属性的值
	 */
	public void  setCurrentServiceManagerProperty() {
		CurrentServiceManager.setMoveInStragety(new PossionServiceMoveInStragety());
		CurrentServiceManager.setServiceGenerator(new RandomServiceGenerator());
		CurrentServicePropertyManager.setReputationStragety(new FixedReputationStragety(8));
		CurrentServiceManager.setMoveOutStragety(new FixedMoveOutStragety(0));
	}
	
	/**
	 * 设置CurrentServicePropertyManager属性的初始值
	 */
	public void SetCurrentServicePropertyManager() {
		CurrentServicePropertyManager.setTagStragety(new RandomTagStragety());
		CurrentServicePropertyManager.setUsedNumberStragety(new FixedUsedNumberStragety());
		CurrentServicePropertyManager.setResourceStragety(new RandomResourceStragety());
		
		CurrentServicePropertyManager.setReliablityStragety(new FixedReliabilityStragety(8.0));
		CurrentServicePropertyManager.setSenseStragety(new FixedSenseStragety(8.0));
		CurrentServicePropertyManager.setTransform_abilityStragety(new FixedTransform_abilityStragety(8.0));
		CurrentServicePropertyManager.setResponseStragety(new FixedResponseStragety(8.0));
	}
	
	public void  setCurrentUserManagerProperty() {
		CurrentUserManager.setUserChooseStragety(new ReputationFirstChooseStragety(0.1));
		CurrentUserManager.setDemandStragety(new RandomDemandStragety());
		CurrentUserManager.setUsergenerator(new RandomUserGenerator());
		CurrentUserManager.setUserMoveInStragety(new FixedUserMoveInStragety(20));
		CurrentUserManager.setPrincipleStragety(new FixedPrincipleStragety());
		CurrentUserManager.setUserTrustStragety(new FixedTrustStragety(8.0));
	}

}
 