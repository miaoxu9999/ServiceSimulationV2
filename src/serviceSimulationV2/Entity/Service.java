package serviceSimulationV2.Entity;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;


/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午2:32:08 
* 类说明 
*/
public class Service {
//	Service的属性
	private static long counter = 0;
    private final long id = counter++;
	private Tag tag;
	
	//评分
	private double reputation;
	//服务产生的时间
	private double birthTime;
	//服务被使用的次数
	private int numberUsed;
	//服务资源
	private Resource resource;
	
	
	//service所处的空间，网格位置
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	
	//用户给出的reputation List
	private List<Double> reputationList;
	
	//可靠性
	private int reliablity;
	
	//感观
	private int sense;
	
	//移植性
	private int transform_ability;
	
	//响应性
	private double response;
	
	public Service(double birthTime, ContinuousSpace<Object> space,
			Grid<Object> grid, Tag tag, double reputation,Resource resource, int reliablity, int sense,
			int transform_ability, double response) {
		this(birthTime, space,
			 grid,  tag,  reputation, resource);
		
		this.reliablity = reliablity;
		this.sense = sense;
		this.transform_ability = transform_ability;
		this.response = response;
	}

	//

	public Service(  double birthTime, ContinuousSpace<Object> space,
			Grid<Object> grid, Tag tag, double reputation,Resource resource) {
		super();
		this.tag = tag;
		this.reputation = reputation;
		this.birthTime = birthTime;
		this.resource = resource;
		this.space = space;
		this.grid = grid;
		numberUsed = 0;
		reputationList = new ArrayList<>();
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public double getReputation() {
		return reputation;
	}

	public void setReputation(double reputation) {
		this.reputation = reputation;
	}

	public double getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(double birthTime) {
		this.birthTime = birthTime;
	}

	public int getNumberUsed() {
		return numberUsed;
	}

	public void setNumberUsed(int numberUsed) {
		this.numberUsed = numberUsed;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ContinuousSpace<Object> getSpace() {
		return space;
	}

	public void setSpace(ContinuousSpace<Object> space) {
		this.space = space;
	}

	public Grid<Object> getGrid() {
		return grid;
	}

	public void setGrid(Grid<Object> grid) {
		this.grid = grid;
	}

	public List<Double> getReputationList() {
		return reputationList;
	}

	public void setReputationList(List<Double> reputationList) {
		this.reputationList = reputationList;
	}

	public int getReliablity() {
		return reliablity;
	}

	public void setReliablity(int reliablity) {
		this.reliablity = reliablity;
	}

	public int getSense() {
		return sense;
	}

	public void setSense(int sense) {
		this.sense = sense;
	}

	public int getTransform_ability() {
		return transform_ability;
	}

	public void setTransform_ability(int transform_ability) {
		this.transform_ability = transform_ability;
	}

	public double getResponse() {
		return response;
	}

	public void setResponse(double response) {
		this.response = response;
	}

	
	
	
	
	

}
 