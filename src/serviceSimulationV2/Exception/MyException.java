package serviceSimulationV2.Exception;

import serviceSimulationV2.Enums.ResultEnum;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午3:39:21 
* 类说明 
*/
public class MyException extends RuntimeException{
//	private String msg;
	private int code;
	public MyException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
		System.out.println(resultEnum.getMsg() + resultEnum.getCode());
	}
	
	
}
 