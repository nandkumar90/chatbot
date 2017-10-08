package com.journaldev.spring.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class NodeOutputMap {

private List<Integer> node21494676005718 = null;
private List<Integer> goodWish = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Integer> getNode21494676005718() {
return node21494676005718;
}

public void setNode21494676005718(List<Integer> node21494676005718) {
this.node21494676005718 = node21494676005718;
}

public List<Integer> getGoodWish() {
return goodWish;
}

public void setGoodWish(List<Integer> goodWish) {
this.goodWish = goodWish;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}