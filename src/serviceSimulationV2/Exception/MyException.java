package serviceSimulationV2.Exception;

import serviceSimulationV2.Enums.ResultEnum;

/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����3:39:21 
* ��˵�� 
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
 