package com.aspectj.template.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 自定义项目中Trace Model模板信息
public class Trace {

    private final long tracerId;
    private final long timestamp;
    private final long cpuTime;
    private final long memoryValue;
    private final Map<String, JsonNode> properties = new HashMap<>();

    public Trace(long tracerId, long timestamp, long cpuTime, long memoryValue) {
        this.tracerId = tracerId;
        this.timestamp = timestamp;
        this.cpuTime = cpuTime;
        this.memoryValue = memoryValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (getClass() != o.getClass()))
            return false;
        Trace trace = (Trace) o;
        return tracerId == trace.tracerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tracerId);
    }

    public long getTracerId() {
        return tracerId;
    }

    public long getCpuTime() {
        return cpuTime;
    }

    public long getMemory() {
        return memoryValue;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Map<String, JsonNode> getProperties() {
        return properties;
    }
}
