package org.example.aop.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TraceLog {

    @JsonProperty
    private final double correlationId;

    @JsonProperty
    private final String operation;

    @JsonProperty
    private final long elapsed;

    @JsonProperty
    private final String cpuDiff;

    @JsonProperty
    private final String cpuEnd;

    @JsonProperty
    private final String memoryDiff;

    @JsonProperty
    private final String memoryEnd;

    @JsonProperty
    private final String memoryAllocated;

    public TraceLog(double correlationId,
                    String operation,
                    long elapsed,
                    String cpuDiff,
                    String cpuEnd,
                    String memoryDiff,
                    String memoryEnd,
                    String memoryAllocated) {
        this.correlationId = correlationId;
        this.operation = operation;
        this.elapsed = elapsed;
        this.cpuDiff = cpuDiff;
        this.cpuEnd = cpuEnd;
        this.memoryDiff = memoryDiff;
        this.memoryEnd = memoryEnd;
        this.memoryAllocated = memoryAllocated;
    }
}
