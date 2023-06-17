package machinecoding.gymbooking.common.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LockService {

    private static final Map<String, Object> lockMap = new ConcurrentHashMap<>();

    public static synchronized Object getLockObject(String key) {
        if (!lockMap.containsKey(key)) {
            lockMap.put(key, new Object());
        }
        return lockMap.get(key);
    }
}
