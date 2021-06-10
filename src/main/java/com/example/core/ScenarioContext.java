package com.example.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Get and Set different contexts that lives in the lifecycle of the scenario (use this when you need to use some variable in different steps.
 */
public class ScenarioContext {
    private static ThreadLocal<Map<String, Object>> scenarioContext = new ThreadLocal<>();

    public static void setContext(Context key, Object value) {
        getInstance().put(key.toString(), value);
    }

    public static Object getContext(Context key) {
        return getInstance().get(key.toString());
    }

    public static void clear() {
        scenarioContext = new ThreadLocal<>();
    }

    private static Map<String, Object> getInstance() {
        if (scenarioContext.get() == null) {
            scenarioContext.set(new HashMap<>());
        }
        return scenarioContext.get();
    }
}
