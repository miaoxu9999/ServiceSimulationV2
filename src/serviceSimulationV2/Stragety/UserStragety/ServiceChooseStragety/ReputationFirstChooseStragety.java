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
	//随机系数
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
			//过滤需求
			HashMap<Tag, List<Service>> taglists = filter(demand, services);
			//将Service 的reputation值按照从大到小的顺序排列
			double[] p = {random_coefficients, 1 - random_coefficients};

			for(Map.Entry<Tag, List<Service>> entry: taglists.entrySet())
			{
				List<Service> temp = entry.getValue();
				if (temp.size() > 0) {
					//选择0代表随机选择
					if (roulette(p) == 0) {
						res.add(temp.get(RandomHelper.nextIntFromTo(0, temp.size() - 1)));
					}//权值优先
					else
					{
						sortByReputation(temp);
						res.add(temp.get(0));
					}
				}
				else
				{
					System.out.println("没有满足条件的Service");
				}
			}
			
			
		}
		
		doExtraWork(res);
		return res;
	}
	
	//对list降序排序
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
     * 轮盘赌函数
     * @param P 各类对象概率分布
     * @return 生成的对象类
     */
    private int roulette(double[] P){
        
        double rand=Math.random();
        double pointer=0;//pointer指示每个区段的右边界，从左往右扫描判断
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
		//选择之后，每个服务的响应性降低0.1
		for(Service s: services)
		{
			s.setResponse(s.getResponse() + 0.1);
		}
	}
	

	
	

}
