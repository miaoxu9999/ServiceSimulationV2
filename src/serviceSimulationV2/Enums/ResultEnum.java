package serviceSimulationV2.Enums; 
/** 
* @author MiaoXu E-mail: 
* @version ����ʱ�䣺2018��3��26�� ����3:40:21 
* ��˵�� 
*/
public enum ResultEnum {
	TAGNUMBERUNCORRECT(100, "��ǩ����������"),
	SERVICENUMBERUNCORRECT(401, "service����������"),
	RANDOMSERVICEMOVEINLISTVALUEUNHANDLED(402, "Random Service MoveIn stragetyList���� δʵ��");
	
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}