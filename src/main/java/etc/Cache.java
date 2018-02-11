package etc;

import java.util.Date;
import java.util.Map;

interface Cache {
    Object get(String key);
    void put(String key, Object value, Date expires);
    void delete(String key);
    void reload(String key, Object value);
}

interface Lock {
    void lock(String key);
    void release(String key);
    void store(Object value);
}

class CacheImpl implements Cache {

    static Map<String, Date> timer;
    static Map<String, Object> data;
    static Lock lock; // Write Lock
    static Lock read; // Read Lock

    public Object get(String key) {
        read.lock(key);
        return data.get(key);
    }

    public void put(String key, Object value) {
        lock.lock(key);
        lock.store(data.get(key));
        data.put(key, value);
        lock.release(key);
    }

    public void put(String key, Object value, Date expires) {
        put(key, value);
        timer.put(key, expires);
    }

    public void delete(String key) {
        lock.lock(key);
        data.remove(key);
        lock.release(key);
    }

    public void reload(String key, Object value) {
        lock.lock(key);
        data.put(key, value);
        lock.release(key);
    }
}
