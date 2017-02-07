package edu.nyu.cs9053.homework8;
import java.util.Collection;
import java.util.Set;
import java.util.Map;
import java.util.List;


public abstract class MultimapAbstractClass<K, V>  implements Multimap<K, V> {

    private Map<K, Collection<V>> mapObj;//to use the built in methods

    protected abstract Collection<V> getNewList();
    protected abstract List<V> combineList(List<V> list1,List<V> list2);

    public MultimapAbstractClass(Map<K, Collection<V>> mapObj) {
        this.mapObj=nullArgumentCheck(mapObj);
    }

    @Override public Collection<V> getItems(K key) {
        if(containsKey(kObjectExceptionCheck(key))) {
            return get(key);
        }
        return getNewList();
    }

    @Override public Collection<V> get(Object key) {
        return mapObj.get(nullObjectCheck(key));
    }

    @Override public boolean putItem(K key, V value) {
        Collection<V> list = get(kObjectExceptionCheck(key));
        if(list == null) {
            list = getNewList();
            put(key,list);
        }
        return list.add(vObjectExceptionCheck(value));
    }

    @Override public Collection<V> put(K key, Collection<V> value) {
        if ( key ==null || value == null ) {
            throw new IllegalArgumentException();
        }
        return mapObj.put(key, value);
    }

    @Override public void putAll(Map<? extends K, ? extends Collection<V>> m) {
        if ( m ==null ) {
            throw new IllegalArgumentException();
        }
        mapObj.putAll(m);
    }

    @Override public int size() {
        return mapObj.size();
    }
    
    private V vObjectExceptionCheck(V v) {
        if (v == null){
            throw new IllegalArgumentException();
        }
        return v;
    }

   
    @Override public boolean containsKey(Object key) {
        return mapObj.containsKey(nullObjectCheck(key));
    }

    @Override public boolean containsValue(Object value) {
        return mapObj.containsValue(nullObjectCheck(value));
    }

    @Override public void clear() {
    	mapObj.clear();
    }

    @Override public Set<K> keySet() {
        return mapObj.keySet();
    }
    
    @Override public boolean isEmpty() {
        return mapObj.isEmpty();
    }


    @Override public Set<Entry<K, Collection<V>>> entrySet() {
        return mapObj.entrySet();
    }

    private Map<K, Collection<V>> nullArgumentCheck(Map<K, Collection<V>> map) {
        if (map == null){
            throw new IllegalArgumentException();
        }
        return map;
    }

    @Override public Collection<Collection<V>> values() {
        return mapObj.values();
    }
    
    @Override public Collection<V> remove(Object key) {
        return mapObj.remove(nullObjectCheck(key));
    }
    
    private Object nullObjectCheck(Object obj) {
        if (obj == null){
            throw new IllegalArgumentException();
        }
        return obj;
    }

    private K kObjectExceptionCheck(K k) {
        if (k == null){
            throw new IllegalArgumentException();
        }
        return k;
    }

    
}
