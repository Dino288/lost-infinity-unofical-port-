/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import xol.lostinfinity.dimension.data.LightSwitchNode;
import xol.lostinfinity.dimension.data.SwitchableLightNode;

public class LightSwitchGameGenerator {
    private List<LightSwitchNode> switches = new ArrayList<LightSwitchNode>();
    private List<SwitchableLightNode> lights = new ArrayList<SwitchableLightNode>();

    public LightSwitchGameGenerator(int numSwitches, int numLights) {
        Random rand = new Random();
        for (int i = 0; i < numLights; ++i) {
            SwitchableLightNode light = new SwitchableLightNode(2, 0, i, true);
            this.addLight(light);
        }
        for (int j = 0; j < numSwitches; ++j) {
            boolean[] toToggle = new boolean[numLights];
            for (int f = 0; f < toToggle.length; ++f) {
                toToggle[f] = false;
            }
            for (int k = 0; k < numLights - 1; ++k) {
                int randLight = rand.nextInt(numLights);
                toToggle[randLight] = true;
                LightSwitchNode node = new LightSwitchNode(0, 0, j);
                node.setLights(toToggle);
                this.addSwitch(node);
            }
        }
        for (int p = 0; p < numSwitches; ++p) {
            LightSwitchNode switchNode = this.getSwitch(p);
            boolean pressSwitch = rand.nextBoolean();
            if (!pressSwitch) continue;
            boolean[] lightsToSwitch = switchNode.getLights();
            for (int c = 0; c < lightsToSwitch.length; ++c) {
                if (!lightsToSwitch[c]) continue;
                this.getLight(c).toggle();
            }
        }
    }

    public static void main(String[] args) {
        int numSwitches = 5;
        int numLights = 5;
        LightSwitchGameGenerator switchGen = new LightSwitchGameGenerator(numSwitches, numLights);
        for (int i = 0; i < numSwitches; ++i) {
            LightSwitchNode node = switchGen.getSwitch(i);
            for (int k = 0; k < node.getLights().length; ++k) {
                System.out.print(String.format("Switch %d %b ", i, node.getLights()[k]));
            }
            System.out.println("");
        }
        for (int j = 0; j < numLights; ++j) {
            System.out.println(String.format("Light %d %b", j, switchGen.getLight(j).isLit()));
        }
    }

    private void addLight(SwitchableLightNode light) {
        this.lights.add(light);
    }

    private void addSwitch(LightSwitchNode lightSwitch) {
        this.switches.add(lightSwitch);
    }

    public LightSwitchNode getSwitch(int i) {
        return this.switches.get(i);
    }

    public SwitchableLightNode getLight(int i) {
        return this.lights.get(i);
    }
}

