/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.execute;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import xol.lostinfinity.util.execute.JsonNode;
import xol.lostinfinity.util.execute.JsonObject;

public class JsonParser {
    private PrintWriter pw;

    public JsonParser(String path, String name) {
        try {
            File parentDirectory = new File(path);
            File file = new File(parentDirectory, name);
            FileWriter fw = new FileWriter(file, false);
            this.pw = new PrintWriter(fw);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void WriteKeyValue(JsonNode node, Boolean comma, Integer level, boolean compress) {
        if (node.hasChildren()) {
            Integer n = level;
            Integer n2 = level = Integer.valueOf(level + 1);
            this.WriteNode(node, comma, n, compress);
        } else if (node.hasSubNodes()) {
            node.setHasSubNodes(false);
            this.pw.print(String.format("\t\"%s\":", node.getKey()));
            List<JsonNode> subNodes = node.getSubNodes();
            this.pw.println("[");
            for (JsonNode subNode : subNodes) {
                String key = subNode.getKey();
                String value = subNode.getValue();
                String subKey = subNode.getSubKey();
                String subValue = subNode.getSubValue();
                String line = String.format("\t\t{ \"%s\": \"%s\", \"%s\": %s }", key, value, subKey, subValue);
                if (subNodes.indexOf(subNode) != subNodes.size() - 1) {
                    line = line + ",";
                }
                this.pw.println(line);
            }
            if (comma.booleanValue()) {
                this.pw.println("\t\t],");
            } else {
                this.pw.println("\t\t]");
            }
        } else {
            String key = node.getKey();
            String value = node.getValue();
            if (value == null) {
                String subNode = String.format("\t\"%s\":", key);
            }
            String line = String.format("\t\"%s\": \"%s\"", key, value);
            if (comma.booleanValue()) {
                line = line + ",";
            }
            this.pw.println(line);
        }
    }

    public void WriteNode(JsonNode node, Boolean comma, Integer level, boolean compress) {
        if (!node.hasChildren()) {
            this.WriteKeyValue(node, comma, level, compress);
        } else {
            String line;
            String key = node.getKey();
            if (level > 0 && compress) {
                line = String.format("\"%s\": {", key);
                this.pw.print(line);
            } else {
                line = String.format("\t\"%s\": {", key);
                this.pw.println(line);
            }
            List<JsonNode> nodeList = node.getNodes();
            for (int i = 0; i < nodeList.size(); ++i) {
                node = nodeList.get(i);
                if (i == nodeList.size() - 1) {
                    this.pw.print("\t");
                    this.WriteKeyValue(node, false, level, compress);
                    continue;
                }
                this.pw.print("\t");
                this.WriteKeyValue(node, true, level, compress);
            }
            if (level > 0 && compress) {
                if (comma.booleanValue()) {
                    this.pw.print(" },");
                } else {
                    this.pw.print(" }");
                }
            } else if (comma.booleanValue()) {
                this.pw.println("\t},");
            } else {
                this.pw.println("\t}");
            }
        }
    }

    public void WriteJson(JsonObject json) {
        List<JsonNode> nodes = json.getNodes();
        this.pw.println("{");
        for (int i = 0; i < nodes.size(); ++i) {
            JsonNode node = nodes.get(i);
            if (i == nodes.size() - 1) {
                this.WriteNode(node, false, 0, false);
                continue;
            }
            this.WriteNode(node, true, 0, false);
        }
        this.pw.print("}");
        this.pw.close();
    }

    public void WriteJson(JsonObject json, boolean compress) {
        List<JsonNode> nodes = json.getNodes();
        this.pw.println("{");
        for (int i = 0; i < nodes.size(); ++i) {
            JsonNode node = nodes.get(i);
            if (i == nodes.size() - 1) {
                this.WriteNode(node, false, 0, compress);
                continue;
            }
            this.WriteNode(node, true, 0, compress);
        }
        this.pw.print("}");
        this.pw.close();
    }
}

