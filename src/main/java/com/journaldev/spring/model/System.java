package com.journaldev.spring.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class System {

private List<DialogStack> dialogStack = null;
private Integer dialogTurnCounter;
private Integer dialogRequestCounter;
private NodeOutputMap nodeOutputMap;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<DialogStack> getDialogStack() {
return dialogStack;
}

public void setDialogStack(List<DialogStack> dialogStack) {
this.dialogStack = dialogStack;
}

public Integer getDialogTurnCounter() {
return dialogTurnCounter;
}

public void setDialogTurnCounter(Integer dialogTurnCounter) {
this.dialogTurnCounter = dialogTurnCounter;
}

public Integer getDialogRequestCounter() {
return dialogRequestCounter;
}

public void setDialogRequestCounter(Integer dialogRequestCounter) {
this.dialogRequestCounter = dialogRequestCounter;
}

public NodeOutputMap getNodeOutputMap() {
return nodeOutputMap;
}

public void setNodeOutputMap(NodeOutputMap nodeOutputMap) {
this.nodeOutputMap = nodeOutputMap;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
