package serviceSimulationV2.util;

import java.io.PrintStream;

/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 上午8:53:11 
* 类说明 
*/
public class Print {
	public Print() {
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print() {
        System.out.println();
    }

    public static void printnb(Object obj) {
        System.out.print(obj);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
 