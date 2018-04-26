package serviceSimulationV2.util; 
/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 上午8:57:52 
* 类说明 元组
*/
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K k, V v) {
        this.key = k;
        this.value = v;
    }
}
 