package com.aspectj.template.property;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Optional;

public class DefaultPropertyExtractor implements PropertiesExtractor<Object> {

    @Override
    public Map<String, JsonNode> extract(String propertyName, Object propertyValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map.Entry<String, Object> propertyEntry = Map.entry(propertyName,
                Optional.ofNullable(propertyValue).orElse(""));
        return Map.of(propertyEntry.getKey(), objectMapper.valueToTree(propertyEntry.getValue()));
    }
}
