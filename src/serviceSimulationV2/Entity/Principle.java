package serviceSimulationV2.Entity;

public class Principle {
	//������ָ���Ȩ��
	double[] weight;
	//����ָ�������ֵ
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
