package serviceSimulationV2.Entity;

public class Principle {
	//对评价指标的权重
	double[] weight;
	//各个指标的期望值
	int[] exp;
	public Principle(double[] weight, int[] exp) {
		super();
		this.weight = weight;
		this.exp = exp;
	}
	public double[] getWeight() {
		return weight;
	}
	public void setWeight(double[] weight) {
		this.weight = weight;
	}
	public int[] getExp() {
		return exp;
	}
	public void setExp(int[] exp) {
		this.exp = exp;
	}
	
	
	
}
