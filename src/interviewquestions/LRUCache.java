package interviewquestions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 1.1f, true);
        this.capacity = capacity;
    }
    
    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > capacity;
    }
    
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<String, String>(3);
        cache.put("1", "value1");
        cache.put("2", "value2");
        cache.put("3", "value3");
        cache.get("2");
//        cache.put("4", "value4");
        
        System.out.println(cache);
        
        /*HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");     
        System.out.println(map);
        
        LinkedHashMap<String, String> lhmap = new LinkedHashMap<String, String>();
        lhmap.put("1", "value1");
        lhmap.put("2", "value2");
        lhmap.put("3", "value3");
        System.out.println(lhmap);*/
        
        printCache(cache);
//        printCache(map);
//        printCache(lhmap);
    }

    private static void printCache(Map<String, String> cache) {
        for (Entry<String, String> entry: cache.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println();
    }
}
