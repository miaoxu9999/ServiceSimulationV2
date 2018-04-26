package serviceSimulationV2.util; 
/** 
* @author MiaoXu E-mail: 
* @version 创建时间：2018年3月26日 上午9:00:01 
* 类说明 
*/
import java.util.Iterator;
import java.util.LinkedHashMap;
public class MapData<K, V> extends LinkedHashMap<K, V> {
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            Pair p = (Pair)gen.next();
            this.put((K)p.key, (V)p.value);
        }

    }

    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.put(genK.next(), genV.next());
        }

    }

    public MapData(Generator<K> genK, V value, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.put(genK.next(), value);
        }

    }

    public MapData(Iterable<K> genK, Generator<V> genV) {
        Iterator var4 = genK.iterator();

        while(var4.hasNext()) {
            Object key = (Object)var4.next();
            this.put((K) key, genV.next());
        }

    }

    public MapData(Iterable<K> genK, V value) {
        Iterator<K> var4 = genK.iterator();

        while(var4.hasNext()) {
//            Object key = (Object)var4.next();
//            this.put((K)key, value);
            this.put(var4.next(), value);
        }

    }

    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData(genK, genV, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
        return new MapData(genK, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData(genK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData(genK, value);
    }
}

 