package serviceSimulationV2.Responsitorry;

import java.util.ArrayList;
import java.util.List;

import serviceSimulationV2.Entity.Tag;


/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午4:24:35 
* 类说明 
*/
public class TagResponsitory {
	private static List<Tag> tags;
	public static List<Tag> getTags() {
		return tags;
	}
	
	public static  List<Tag> getAllTags() {
		 tags = mockTags(10, 5);
		return tags;
	}
	
	
	
	/**
	 * 模拟Tag类的生成
	 * @param fitrstnum
	 * @param secondnum
	 * @return
	 */
	private static List<Tag> mockTags(int fitrstnum, int secondnum)
	{
		List<Tag> tags = new ArrayList<>();
		for(int i = 0; i < fitrstnum; i++)
		{
			for(int j = 0; j < secondnum; j++)
			{
				tags.add(new Tag(i,j ));
			}
		}
		return tags;
	}
	
	

}
 