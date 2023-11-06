package com.aspectj.template.property;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public interface PropertiesExtractor<T> {
    
    Map<String, JsonNode> extract(String propertyName, T propertyValue);
}
