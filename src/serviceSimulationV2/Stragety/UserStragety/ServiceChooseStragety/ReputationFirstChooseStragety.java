package serviceSimulationV2.Stragety.UserStragety.ServiceChooseStragety;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import repast.simphony.random.RandomHelper;
import serviceSimulationV2.Entity.Service;
import serviceSimulationV2.Entity.Tag;
import serviceSimulationV2.Entity.Demand.Demand;
import serviceSimulationV2.util.SimulationUtil;

public class ReputationFirstChooseStragety extends ServiceChooseStragety{
	//���ϵ��
	private double 	random_coefficients;
	
	public ReputationFirstChooseStragety(double random_coefficients) {
		super();
		this.random_coefficients = random_coefficients;
	}

	@Override
	public Service getStragetyValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> getStragetyValueList(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service[] getStragetyValueArray(int size) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Service> getService(Demand demand, List<Service> services) {
		// TODO Auto-generated method stub
		List<Service> res = new ArrayList<>();
		if (demand == null) {
			res = SimulationUtil.getRandomClass(RandomHelper.nextIntFromTo(1, services.size() / 2 + 1), services);
			doExtraWork(res);
			return res;
		}
		else
		{
			//��������
			HashMap<Tag, List<Service>> taglists = filter(demand, services);
			//��Service ��reputationֵ���մӴ�С��˳������
			double[] p = {random_coefficients, 1 - random_coefficients};

			for(Map.Entry<Tag, List<Service>> entry: taglists.entrySet())
			{
				List<Service> temp = entry.getValue();
				if (temp.size() > 0) {
					//ѡ��0�������ѡ��
					if (roulette(p) == 0) {
						res.add(temp.get(RandomHelper.nextIntFromTo(0, temp.size() - 1)));
					}//Ȩֵ����
					else
					{
						sortByReputation(temp);
						res.add(temp.get(0));
					}
				}
				else
				{
					System.out.println("û������������Service");
				}
			}
			
			
		}
		
		doExtraWork(res);
		return res;
	}
	
	//��list��������
	public void sortByReputation(List<Service> services) {
		Collections.sort(services, new Comparator<Service>() {

			@Override
			public int compare(Service o1, Service o2) {
				// TODO Auto-generated method stub
				return (int) (o2.getReputation() - o1.getReputation());
			}
		});
	}
	
	/**
     * ���̶ĺ���
     * @param P ���������ʷֲ�
     * @return ���ɵĶ�����
     */
    private int roulette(double[] P){
        
        double rand=Math.random();
        double pointer=0;//pointerָʾÿ�����ε��ұ߽磬��������ɨ���ж�
        for(int i=0;i<P.length;i++){
            pointer+=P[i];
            if(rand<=pointer)
                return i;
        }
        return -1;
    }

	@Override
	public void doExtraWork(List<Service> services) {
		// TODO Auto-generated method stub
		//ѡ��֮��ÿ���������Ӧ�Խ���0.1
		for(Service s: services)
		{
			s.setResponse(s.getResponse() + 0.1);
		}
	}
	

	
	

}
