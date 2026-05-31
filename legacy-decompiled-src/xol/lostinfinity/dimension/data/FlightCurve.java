/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
package xol.lostinfinity.dimension.data;

import java.util.function.Function;
import net.minecraft.core.BlockPos;

public class FlightCurve {
    public static double a = 1.0;
    public static double b = 1.0;
    public static double c = 1.0;
    public static double p = 2.0;
    public static double q = 3.0;
    private double moveSpeed;
    private Function<Double, Double> xFunction;
    private Function<Double, Double> yFunction;
    private Function<Double, Double> zFunction;
    private Function<Double[], Double> slopeFunction;
    private Function<Double, Double> xslopeFunction;
    private Function<Double, Double> yslopeFunction;
    private Function<Double, Double> zslopeFunction;

    public static void main(String[] args) {
        FlightCurve f = new FlightCurve(new BlockPos(3, 4, 10), new BlockPos(0, 0, 4), 5.0);
        for (double t = 0.0; t < 1.0; t += 0.1) {
            System.out.println(String.format("x:%f y:%f z%f", f.getXVelocity(t), f.getYVelocity(t), f.getZVelocity(t)));
        }
    }

    public FlightCurve(BlockPos start, BlockPos finish, double moveSpeed) {
        this.moveSpeed = moveSpeed;
        final double x0 = start.func_177958_n();
        final double x1 = finish.func_177958_n();
        final double y0 = start.func_177956_o();
        final double y1 = finish.func_177956_o();
        final double z0 = start.func_177952_p();
        final double z1 = finish.func_177952_p();
        this.slopeFunction = new Function<Double[], Double>(){

            @Override
            public Double apply(Double[] values) {
                double f0 = values[0];
                double f1 = values[1];
                double t0 = values[2];
                double t1 = values[3];
                double t = values[4];
                double a = (f1 - f0) / (t1 - t0);
                double b = f0 - a * t0;
                return a * t + b;
            }
        };
        this.xslopeFunction = new Function<Double, Double>(){

            @Override
            public Double apply(Double t) {
                Double[] Values2 = new Double[]{x0, x1, 0.0, 1.0, t};
                return (Double)FlightCurve.this.slopeFunction.apply(Values2);
            }
        };
        this.yslopeFunction = new Function<Double, Double>(){

            @Override
            public Double apply(Double t) {
                Double[] Values2 = new Double[]{y0, y1, 0.0, 1.0, t};
                return (Double)FlightCurve.this.slopeFunction.apply(Values2);
            }
        };
        this.zslopeFunction = new Function<Double, Double>(){

            @Override
            public Double apply(Double t) {
                Double[] Values2 = new Double[]{z0, z1, 0.0, 1.0, t};
                return (Double)FlightCurve.this.slopeFunction.apply(Values2);
            }
        };
        this.xFunction = new Function<Double, Double>(){

            @Override
            public Double apply(Double t) {
                return (Double)FlightCurve.this.xslopeFunction.apply(t);
            }
        };
        this.yFunction = new Function<Double, Double>(){

            @Override
            public Double apply(Double t) {
                return 3.6105 * Math.pow(t, 3.0) - 5.9498 * Math.pow(t, 2.0) + 2.3644 * t + 0.0187;
            }
        };
        this.zFunction = new Function<Double, Double>(){

            @Override
            public Double apply(Double t) {
                return (Double)FlightCurve.this.zslopeFunction.apply(t);
            }
        };
    }

    public double getMoveSpeed() {
        return this.moveSpeed;
    }

    public void setMoveSpeed(double speed) {
        this.moveSpeed = speed;
    }

    public double getXVelocity(double t) {
        return -(this.xFunction.apply(t) - this.xFunction.apply(t + 0.01)) / 0.01;
    }

    public double getYVelocity(double t) {
        return -(this.yFunction.apply(t) - this.yFunction.apply(t + 0.01)) / 0.01;
    }

    public double getZVelocity(double t) {
        return -(this.zFunction.apply(t) - this.zFunction.apply(t + 0.01)) / 0.01;
    }
}

