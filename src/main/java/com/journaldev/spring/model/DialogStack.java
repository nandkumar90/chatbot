package com.journaldev.spring.model;

import java.util.HashMap;
import java.util.Map;


public class DialogStack {

private String dialogNode;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getDialogNode() {
return dialogNode;
}

public void setDialogNode(String dialogNode) {
this.dialogNode = dialogNode;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}