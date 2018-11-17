package problem_146;

import javax.management.monitor.Monitor;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> map;
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.map=new LinkedHashMap<>(16,0.75f,true);
    }
    public int get(int key){
        if (!map.containsKey(key))
            return -1;
       return map.get(key);
    }
    public void put(int key,int value){
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                Iterator<Integer> it = map.keySet().iterator();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }

            }
        }
        map.put(key,value);
    }
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>(16,0.75f,true);
       LRUCache cache=new LRUCache(2);
       cache.get(2);
       cache.put(2,6);
       cache.get(1);
       cache.put(1,5);
       cache.put(1,2);
        cache.put(13,2);
       cache.get(1);
       cache.get(2);
    }
}
