/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.execute;

import java.util.ArrayList;
import java.util.List;

public class JsonNode {
    private boolean hasChildren;
    private List<JsonNode> subNodes;
    private String key;
    private String value;
    private List<JsonNode> nodes;
    private String subKey;
    private String subValue;
    private boolean hasSubNodes;

    public JsonNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.nodes = new ArrayList<JsonNode>();
        this.hasChildren = false;
        this.subNodes = new ArrayList<JsonNode>();
        this.subKey = null;
        this.subValue = null;
        this.hasSubNodes = false;
    }

    public JsonNode(String key) {
        this.key = key;
        this.value = null;
        this.nodes = new ArrayList<JsonNode>();
        this.hasChildren = false;
        this.subNodes = new ArrayList<JsonNode>();
        this.subKey = null;
        this.subValue = null;
        this.hasSubNodes = false;
    }

    public void addNode(JsonNode child) {
        this.nodes.add(child);
        this.hasChildren = true;
    }

    public void setSubNodes(List<JsonNode> values) {
        this.subNodes = values;
        this.hasSubNodes = values != null;
    }

    public boolean hasSubNodes() {
        return this.hasSubNodes;
    }

    public List<JsonNode> getSubNodes() {
        return this.subNodes;
    }

    public List<JsonNode> getNodes() {
        return this.nodes;
    }

    public void setSubKey(String subKey) {
        this.subKey = subKey;
    }

    public void setSubValue(String subValue) {
        this.subValue = subValue;
    }

    public String getSubKey() {
        return this.subKey;
    }

    public String getSubValue() {
        return this.subValue;
    }

    public String getValue() {
        return this.value;
    }

    public boolean hasChildren() {
        return this.hasChildren;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setHasSubNodes(boolean b) {
        this.hasSubNodes = b;
    }
}

