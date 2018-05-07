package serviceSimulationV2.Stragety.UserStragety.PrincipleStragety;

import java.util.List;

import serviceSimulationV2.Entity.Principle;
import serviceSimulationV2.Stragety.Stragety;

public class FixedPrincipleStragety implements Stragety<Principle>, PrincipleStragety{
	double[][]  w= {{0.1, 0.2, 0.3, 0.4},
				{0.2, 0.2, 0.2, 0.4},
				{0.25, 0.25, 0.25, 0.25},
				{0.3, 0.2, 0.3, 0.2},
				{0.4, 0.4, 0.1, 0.1},};
	int[][] exp = {{9, 9, 9, 9}, //ƽ������ֵ��
			//��1��3������
			{6, 10, 8, 10},
			//��1��3������
			{10, 6, 10, 6},
			
			{2, 2, 2, 2},
			//ƽ������ֵ��
			{6, 6, 6, 6},};
	private static int count;
	@Override
	public Principle getStragetyValue() {
		// TODO Auto-generated method stub
		int index = count % w.length;
		count++;
		
		return new Principle(w[index], exp[index]);
	}

	@Override
	public List<Principle> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return java.util.Arrays.asList(getStragetyValueArray(size));
	}

	@Override
	public Principle[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		Principle[] principles = new Principle[size];
		for (int i = 0; i < principles.length; i++) {
			principles[i] = getStragetyValue();
		}
		return principles;
	}

}
