package serviceSimulationV2.Entity;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;


/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����2:32:08 
* ��˵�� 
*/
public class Service {
//	Service������
	private static long counter = 0;
    private final long id = counter++;
	private Tag tag;
	
	//����
	private double reputation;
	//���������ʱ��
	private double birthTime;
	//����ʹ�õĴ���
	private int numberUsed;
	//������Դ
	private Resource resource;
	
	
	//service�����Ŀռ䣬����λ��
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	
	//�û�������reputation List
	private List<Double> reputationList;

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
	
	
	
	

}
 