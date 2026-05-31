/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.util.execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import xol.lostinfinity.util.execute.JsonNode;
import xol.lostinfinity.util.execute.JsonObject;
import xol.lostinfinity.util.execute.JsonParser;

public class GenBasicJson {
    private static String assetPath = "src/main/resources/assets/lostinfinity/";

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            System.out.print("GenBasicJson >> ");
            String line = myObj.nextLine();
            String[] split = line.split("\\s+");
            if (split.length > 1 && split.length < 6) {
                String shape;
                Integer num;
                String name = split[1];
                if (split[0].equals("i")) {
                    GenBasicJson.GenBasicItem(name);
                    continue;
                }
                if (split[0].equals("b")) {
                    switch (split.length) {
                        case 3: {
                            try {
                                num = Integer.parseInt(split[2]);
                                GenBasicJson.GenBasicBlock(name, num, "cube");
                            }
                            catch (NumberFormatException e) {
                                shape = split[2];
                                GenBasicJson.GenBasicBlock(name, 0, shape);
                            }
                            break;
                        }
                        case 2: {
                            GenBasicJson.GenBasicBlock(name, 0, "cube");
                            break;
                        }
                        case 4: {
                            try {
                                num = Integer.parseInt(split[2]);
                                shape = split[3];
                                GenBasicJson.GenBasicBlock(name, num, shape);
                                break;
                            }
                            catch (NumberFormatException e) {
                                num = Integer.parseInt(split[3]);
                                shape = split[2];
                                GenBasicJson.GenBasicBlock(name, num, shape);
                            }
                        }
                    }
                    continue;
                }
                if (split[0].equals("bb")) {
                    String activeName = split[2];
                    switch (split.length) {
                        case 3: {
                            shape = "cube";
                            num = 0;
                            GenBasicJson.GenBasicBlockBoolean(name, activeName, shape, num);
                            break;
                        }
                        case 4: {
                            try {
                                num = Integer.parseInt(split[3]);
                                shape = "cube";
                                GenBasicJson.GenBasicBlockBoolean(name, activeName, shape, num);
                            }
                            catch (NumberFormatException e) {
                                shape = split[3];
                                num = 0;
                                GenBasicJson.GenBasicBlockBoolean(name, activeName, shape, num);
                            }
                            break;
                        }
                        case 5: {
                            try {
                                num = Integer.parseInt(split[3]);
                                shape = split[4];
                                GenBasicJson.GenBasicBlockBoolean(name, activeName, shape, num);
                                break;
                            }
                            catch (NumberFormatException e) {
                                num = Integer.parseInt(split[4]);
                                shape = split[3];
                                GenBasicJson.GenBasicBlockBoolean(name, activeName, shape, num);
                            }
                        }
                    }
                    continue;
                }
                if (split[0].equals("ba")) {
                    switch (split.length) {
                        case 4: {
                            int amount;
                            try {
                                num = Integer.parseInt(split[3]);
                                amount = Integer.parseInt(split[2]);
                                GenBasicJson.GenBasicBlockAmount(name, num, "cube", amount);
                            }
                            catch (NumberFormatException e) {
                                shape = split[2];
                                amount = Integer.parseInt(split[3]);
                                GenBasicJson.GenBasicBlockAmount(name, 0, shape, amount);
                            }
                            break;
                        }
                        case 3: {
                            int amount = Integer.parseInt(split[2]);
                            GenBasicJson.GenBasicBlockAmount(name, 0, "cube", amount);
                            break;
                        }
                        case 5: {
                            int amount;
                            try {
                                amount = Integer.parseInt(split[2]);
                                num = Integer.parseInt(split[4]);
                                shape = split[3];
                                GenBasicJson.GenBasicBlockAmount(name, num, shape, amount);
                                break;
                            }
                            catch (NumberFormatException e) {
                                amount = Integer.parseInt(split[3]);
                                num = Integer.parseInt(split[4]);
                                shape = split[2];
                                GenBasicJson.GenBasicBlockAmount(name, num, shape, amount);
                            }
                        }
                    }
                    continue;
                }
                if (split[0].equals("s")) {
                    if (split.length != 2) continue;
                    GenBasicJson.GenSound(name);
                    continue;
                }
                if (!split[0].equals("p") || split.length != 2) continue;
                GenBasicJson.GenParticle(name);
                continue;
            }
            System.out.println("Incorrect num arguments");
        }
    }

    private static void GenParticle(String name) {
        String initPath = "src/main/java/xol/lostinfinity/init/ParticleInit.java";
        String capsName = name.toUpperCase();
        String spriteEntry = String.format("\tpublic static TextureAtlasSprite %s_SPRITE;", capsName);
        String spriteHead = "public static TextureAtlasSprite FIREGOO_SPRITE;";
        String particleRegEntry = String.format("\tpublic static final EnumParticleTypes %s = particleRegistry(\"%s\");", capsName, name);
        String particleRegHead = "public static final EnumParticleTypes VENOM = particleRegistry(\"venom\");";
        String spriteRegEntry = String.format("\t\t%s_SPRITE = ev.getMap().registerSprite(new ResourceLocation(Reference.MODID, \"particles/%s\"));", capsName, name);
        String spriteRegHead = "FIREGOO_SPRITE = ev.getMap().registerSprite(new ResourceLocation(Reference.MODID, \"particles/firegoo\"));";
        String particleClassName = GenBasicJson.firstCase(name);
        String particleRenderRegEntry = String.format("\t\tMinecraft.getMinecraft().effectRenderer.registerParticle(%s.getParticleID(), new Particle%s.Factory());", capsName, particleClassName);
        String particleRenderRegHead = "Minecraft.getMinecraft().effectRenderer.registerParticle(FIREGOO.getParticleID(), new ParticleFiregoo.Factory());";
        try {
            GenBasicJson.writeBeforeAnnotatedLine(initPath, spriteEntry, spriteHead);
            GenBasicJson.writeBeforeAnnotatedLine(initPath, particleRegEntry, particleRegHead);
            GenBasicJson.writeBeforeAnnotatedLine(initPath, spriteRegEntry, spriteRegHead);
            GenBasicJson.writeBeforeAnnotatedLine(initPath, particleRenderRegEntry, particleRenderRegHead);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GenSound(String name) {
        String jsonPath = "src/main/resources/assets/lostinfinity/sounds.json";
        int lineNum = 2;
        String soundEntry = String.format("\t\"%s\":{ \"category\":\"master\", \"sounds\":[ \"lostinfinity:%s\" ] },", name, name);
        GenBasicJson.writeBeforeLineNumber(jsonPath, lineNum, soundEntry);
        String initPath = "src/main/java/xol/lostinfinity/init/SoundInit.java";
        String capsName = name.toUpperCase();
        String soundInit = String.format("\t public static final SoundEvent %s = registerCustomSound(\"%s\");", capsName, name);
        lineNum = 18;
        GenBasicJson.writeBeforeLineNumber(initPath, lineNum, soundInit);
    }

    private static void writeBeforeLineNumber(String filename, int lineNum, String text) {
        try {
            String line;
            File file = new File(filename);
            File temp = File.createTempFile("temp-file-name", ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            int num = 0;
            while ((line = br.readLine()) != null) {
                if (++num == lineNum) {
                    pw.println(text);
                }
                pw.println(line);
            }
            br.close();
            pw.close();
            file.delete();
            temp.renameTo(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GenBasicBlock(String name, Integer num, String shape) {
        String blockPath = assetPath + "models/block/";
        String itemPath = assetPath + "models/item/";
        String blockStatePath = assetPath + "blockstates/";
        JsonParser itemJsonParser = new JsonParser(itemPath, name + ".json");
        String itemTexture = String.format("lostinfinity:block/%s", name);
        JsonObject itemJson = new JsonObject("parent", itemTexture);
        String defaultWeight = "100";
        itemJsonParser.WriteJson(itemJson);
        JsonParser blockStateJsonParser = new JsonParser(blockStatePath, name + ".json");
        JsonObject blockStateJson = new JsonObject();
        ArrayList<JsonNode> variantSubNodes = new ArrayList<JsonNode>();
        if (num == 0) {
            num = 1;
        }
        for (int i = 1; i <= num; ++i) {
            String numStr = i == 1 ? "" : Integer.toString(i);
            String blockModel = String.format("lostinfinity:%s", name + numStr);
            JsonNode subNode = new JsonNode("model", blockModel);
            subNode.setSubKey("weight");
            subNode.setSubValue(defaultWeight);
            variantSubNodes.add(subNode);
        }
        JsonNode variants = new JsonNode("variants");
        JsonNode normalVariant = new JsonNode("normal");
        if (variantSubNodes.size() > 1) {
            normalVariant.setSubNodes(variantSubNodes);
        } else {
            normalVariant.addNode((JsonNode)variantSubNodes.get(0));
        }
        variants.addNode(normalVariant);
        blockStateJson.add(variants);
        blockStateJsonParser.WriteJson(blockStateJson);
        if (num == 0) {
            num = 1;
        }
        for (int i = 1; i <= num; ++i) {
            String numStr = i == 1 ? "" : Integer.toString(i);
            JsonParser blockJsonParser = new JsonParser(blockPath, name + numStr + ".json");
            String shapeName = shape;
            String shapeAlias = shape;
            if (shape.equals("cube")) {
                shapeName = "cube_all";
                shapeAlias = "all";
            }
            JsonObject blockJson = new JsonObject("parent", "block/" + shapeName);
            JsonNode node = new JsonNode("textures");
            String blockTexture = String.format("lostinfinity:blocks/%s", name + numStr);
            JsonNode child = new JsonNode(shapeAlias, blockTexture);
            node.addNode(child);
            blockJson.add(node);
            blockJsonParser.WriteJson(blockJson);
        }
        String initPath = "src/main/java/xol/lostinfinity/init/BlockInit.java";
        String annotation = "Append basic blocks here";
        String camelName = GenBasicJson.camelCase(name);
        System.out.println(camelName);
        String blockInit = String.format("\tpublic static final Block %s = new BlockBasic(\"%s\");", camelName, name);
        try {
            GenBasicJson.writeBeforeAnnotatedLine(initPath, blockInit, annotation);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GenBasicBlockAmount(String name, Integer num, String shape, int amount) {
        String amStr;
        int i;
        String blockPath = assetPath + "models/block/";
        String itemPath = assetPath + "models/item/";
        String blockStatePath = assetPath + "blockstates/";
        JsonParser itemJsonParser = new JsonParser(itemPath, name + ".json");
        String itemTexture = String.format("lostinfinity:block/%s_0", name);
        JsonObject itemJson = new JsonObject("parent", itemTexture);
        String defaultWeight = "100";
        itemJsonParser.WriteJson(itemJson);
        JsonParser blockStateJsonParser = new JsonParser(blockStatePath, name + ".json");
        JsonObject blockStateJson = new JsonObject();
        JsonNode variants = new JsonNode("variants");
        for (i = 0; i <= amount; ++i) {
            amStr = Integer.toString(i);
            JsonNode varHeader = new JsonNode(String.format("amount=%s", amStr));
            if (num <= 1) {
                String blockModel = String.format("lostinfinity:%s", name + "_" + amStr);
                JsonNode subNode = new JsonNode("model", blockModel);
                varHeader.addNode(subNode);
            } else {
                ArrayList<JsonNode> variantSubNodes = new ArrayList<JsonNode>();
                if (num == 0) {
                    num = 1;
                }
                for (int j = 1; j <= num; ++j) {
                    String numStr = j == 1 ? "" : "_" + Integer.toString(j);
                    String blockModel = String.format("lostinfinity:%s", name + "_" + amStr + numStr);
                    JsonNode subNode = new JsonNode("model", blockModel);
                    subNode.setSubKey("weight");
                    subNode.setSubValue(defaultWeight);
                    variantSubNodes.add(subNode);
                }
                varHeader.setSubNodes(variantSubNodes);
            }
            variants.addNode(varHeader);
        }
        blockStateJson.add(variants);
        blockStateJsonParser.WriteJson(blockStateJson);
        for (i = 0; i <= amount; ++i) {
            if (num <= 1) {
                amStr = Integer.toString(i);
                JsonParser blockJsonParser = new JsonParser(blockPath, name + "_" + amStr + ".json");
                String shapeName = shape;
                String shapeAlias = shape;
                if (shape.equals("cube")) {
                    shapeName = "cube_all";
                    shapeAlias = "all";
                }
                JsonObject blockJson = new JsonObject("parent", "block/" + shapeName);
                JsonNode node = new JsonNode("textures");
                String blockTexture = String.format("lostinfinity:blocks/%s", name + "_" + amStr);
                JsonNode child = new JsonNode(shapeAlias, blockTexture);
                node.addNode(child);
                blockJson.add(node);
                blockJsonParser.WriteJson(blockJson);
                continue;
            }
            if (num == 0) {
                num = 1;
            }
            String numStr = "";
            for (int j = 1; j <= num; ++j) {
                numStr = j == 1 ? "" : "_" + Integer.toString(j);
                String amStr2 = Integer.toString(i);
                JsonParser blockJsonParser = new JsonParser(blockPath, name + "_" + amStr2 + numStr + ".json");
                String shapeName = shape;
                String shapeAlias = shape;
                if (shape.equals("cube")) {
                    shapeName = "cube_all";
                    shapeAlias = "all";
                }
                JsonObject blockJson = new JsonObject("parent", "block/" + shapeName);
                JsonNode node = new JsonNode("textures");
                String blockTexture = String.format("lostinfinity:blocks/%s", name + "_" + amStr2 + numStr);
                JsonNode child = new JsonNode(shapeAlias, blockTexture);
                node.addNode(child);
                blockJson.add(node);
                blockJsonParser.WriteJson(blockJson);
            }
        }
        String initPath = "src/main/java/xol/lostinfinity/init/BlockInit.java";
        String annotation = "Append basic blocks here";
        String camelName = GenBasicJson.camelCase(name);
        System.out.println(camelName);
        String blockInit = String.format("\tpublic static final Block %s = new BlockBasic(\"%s\");", camelName, name);
        try {
            GenBasicJson.writeBeforeAnnotatedLine(initPath, blockInit, annotation);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GenBasicBlockBoolean(String name, String activeName, String shape, Integer num) {
        String numStr;
        int i;
        String blockPath = assetPath + "models/block/";
        String itemPath = assetPath + "models/item/";
        String blockStatePath = assetPath + "blockstates/";
        JsonParser itemJsonParser = new JsonParser(itemPath, name + ".json");
        String itemTexture = String.format("lostinfinity:block/%s", name);
        JsonObject itemJson = new JsonObject("parent", itemTexture);
        String defaultWeight = "100";
        itemJsonParser.WriteJson(itemJson);
        JsonParser blockStateJsonParser = new JsonParser(blockStatePath, name + ".json");
        JsonObject blockStateJson = new JsonObject();
        ArrayList<JsonNode> trueVariantSubNodes = new ArrayList<JsonNode>();
        ArrayList<JsonNode> falseVariantSubNodes = new ArrayList<JsonNode>();
        JsonNode variants = new JsonNode("variants");
        JsonNode trueHeader = new JsonNode("active=true");
        JsonNode falseHeader = new JsonNode("active=false");
        JsonNode trueBody = new JsonNode("model", String.format("lostinfinity:%s_%s", name, activeName));
        JsonNode falseBody = new JsonNode("model", String.format("lostinfinity:%s", name));
        if (num == 0) {
            num = 1;
        }
        for (i = 1; i <= num; ++i) {
            numStr = i == 1 ? "" : Integer.toString(i);
            String falseBlockModel = String.format("lostinfinity:%s", name + numStr);
            JsonNode falseSubNode = new JsonNode("model", falseBlockModel);
            falseSubNode.setSubKey("weight");
            falseSubNode.setSubValue(defaultWeight);
            falseVariantSubNodes.add(falseSubNode);
            String trueBlockModel = String.format("lostinfinity:%s", name + "_" + activeName + numStr);
            JsonNode trueSubNode = new JsonNode("model", trueBlockModel);
            trueSubNode.setSubKey("weight");
            trueSubNode.setSubValue(defaultWeight);
            trueVariantSubNodes.add(trueSubNode);
        }
        if (trueVariantSubNodes.size() > 1) {
            trueHeader.setSubNodes(trueVariantSubNodes);
        } else {
            trueHeader.addNode(trueBody);
        }
        if (falseVariantSubNodes.size() > 1) {
            falseHeader.setSubNodes(falseVariantSubNodes);
        } else {
            falseHeader.addNode(falseBody);
        }
        variants.addNode(trueHeader);
        variants.addNode(falseHeader);
        blockStateJson.add(variants);
        blockStateJsonParser.WriteJson(blockStateJson, true);
        if (num == 0) {
            num = 1;
        }
        for (i = 1; i <= num; ++i) {
            numStr = i == 1 ? "" : Integer.toString(i);
            JsonParser blockJsonParserTrue = new JsonParser(blockPath, name + "_" + activeName + numStr + ".json");
            String shapeName = shape;
            String shapeAlias = shape;
            if (shape.equals("cube")) {
                shapeName = "cube_all";
                shapeAlias = "all";
            }
            JsonObject blockJson = new JsonObject("parent", "block/" + shapeName);
            JsonNode node = new JsonNode("textures");
            String blockTexture = String.format("lostinfinity:blocks/%s", name + "_" + activeName + numStr);
            JsonNode child = new JsonNode(shapeAlias, blockTexture);
            node.addNode(child);
            blockJson.add(node);
            blockJsonParserTrue.WriteJson(blockJson);
            JsonParser blockJsonParserFalse = new JsonParser(blockPath, name + numStr + ".json");
            if (shape.equals("cube")) {
                shapeName = "cube_all";
                shapeAlias = "all";
            }
            blockJson = new JsonObject("parent", "block/" + shapeName);
            node = new JsonNode("textures");
            blockTexture = String.format("lostinfinity:blocks/%s", name + numStr);
            child = new JsonNode(shapeAlias, blockTexture);
            node.addNode(child);
            blockJson.add(node);
            blockJsonParserFalse.WriteJson(blockJson);
        }
        String initPath = "src/main/java/xol/lostinfinity/init/BlockInit.java";
        String annotation = "Append basic blocks here";
        String camelName = GenBasicJson.camelCase(name);
        System.out.println(camelName);
        String blockInit = String.format("\tpublic static final Block %s = new BlockBasicBoolState(\"%s\");", camelName, name);
        try {
            GenBasicJson.writeBeforeAnnotatedLine(initPath, blockInit, annotation);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void GenBasicItem(String name) {
        String itemPath = assetPath + "models/item/";
        JsonParser jsonParser = new JsonParser(itemPath, name + ".json");
        JsonObject json = new JsonObject("parent", "item/generated");
        JsonNode node = new JsonNode("textures");
        String itemTexture = String.format("lostinfinity:items/%s", name);
        JsonNode child = new JsonNode("layer0", itemTexture);
        node.addNode(child);
        json.add(node);
        jsonParser.WriteJson(json);
        String initPath = "src/main/java/xol/lostinfinity/init/ItemInit.java";
        String annotation = "Append basic items here";
        String camelName = GenBasicJson.camelCase(name);
        System.out.println(camelName);
        String itemInit = String.format("\tpublic static final Item %s = new ItemBasic(\"%s\", TabsInit.TAB_AUXMATS);", camelName, name);
        try {
            GenBasicJson.writeBeforeAnnotatedLine(initPath, itemInit, annotation);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String camelCase(String name) {
        String camel = "";
        for (int i = 0; i < name.length(); ++i) {
            camel = i == 0 ? camel + name.charAt(0) : (name.charAt(i) == '_' ? camel + Character.toUpperCase(name.charAt(++i)) : camel + name.charAt(i));
        }
        return camel;
    }

    public static String firstCase(String name) {
        String cased = "";
        for (int i = 0; i < name.length(); ++i) {
            cased = i == 0 ? cased + Character.toUpperCase(name.charAt(0)) : (name.charAt(i) == '_' ? cased + Character.toUpperCase(name.charAt(++i)) : cased + name.charAt(i));
        }
        return cased;
    }

    public static void writeBeforeAnnotatedLine(String filename, String text, String annotation) throws IOException {
        try {
            String line;
            File file = new File(filename);
            File temp = File.createTempFile("temp-file-name", ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            while ((line = br.readLine()) != null) {
                if (line.contains(annotation)) {
                    pw.println(text);
                }
                pw.println(line);
            }
            br.close();
            pw.close();
            file.delete();
            temp.renameTo(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

