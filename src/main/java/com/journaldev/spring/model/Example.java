package com.journaldev.spring.model;



import java.util.HashMap;
import java.util.Map;

public class Example {

private String conversationId;
private System system;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getConversationId() {
return conversationId;
}

public void setConversationId(String conversationId) {
this.conversationId = conversationId;
}

public System getSystem() {
return system;
}

public void setSystem(System system) {
this.system = system;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

