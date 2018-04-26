package serviceSimulationV2.Enums; 
/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 下午3:40:21 
* 类说明 
*/
public enum ResultEnum {
	TAGNUMBERUNCORRECT(100, "标签的数量错误"),
	SERVICENUMBERUNCORRECT(401, "service的数量错误"),
	RANDOMSERVICEMOVEINLISTVALUEUNHANDLED(402, "Random Service MoveIn stragetyList方法 未实现");
	
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