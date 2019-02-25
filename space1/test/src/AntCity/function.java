package AntCity;

import java.util.ArrayList;

/**
 * @author ：Yorick
 * @date ：Created in 2019/2/22 10:38
 * @description：函数调用的类文件
 * @modified By：
 * @version: 1.0$
 */
public class function {

    public ArrayList addlist(double[][] location) {
        ArrayList<double[]> list = new ArrayList<double[]>();
        for (int i = 0; i < init.N; i++) {
            list.add(location[i]);
        }
        return list;
    }

    public ArrayList<double[]> Relative_position(ArrayList<double[]> list) {


        ArrayList<double[]> list3 = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            double[] doubles = new double[2];
            doubles[0] = list.get(i)[0] - list.get(0)[0];
            doubles[1] = list.get(i)[1] - list.get(0)[1];
            double sum = 1 / Math.sqrt(Math.pow(doubles[0], 2) + Math.pow(doubles[1], 2));
            doubles[0] = doubles[0] * sum;
            doubles[1] = doubles[1] * sum;
            list3.add(doubles);
        }

        return list3;
    }

    public double[] Resultant_force(ArrayList list) {
        double[] Sum_vector = {0, 0};
        for (int i = 1; i < list.size(); i++) {
            Sum_vector[0] = Sum_vector[0] + ((double[]) list.get(i))[0];
            Sum_vector[1] = Sum_vector[1] + ((double[]) list.get(i))[1];
        }
        return Sum_vector;
    }

    public double Angle(double[] force, double[] location) {
        double angle = 0.0;
        angle = (force[0] * location[0] + force[1] * location[1]) /
                (Math.sqrt(Math.pow(force[0], 2) + Math.pow(force[1], 2)) + Math.sqrt(Math.pow(location[0], 2) + Math.pow(location[1], 2)));
        return angle;
    }

    public double Distance(double[] location) {
        double distance;
        distance = Math.sqrt(Math.pow(location[0], 2) + Math.pow(location[1], 2));
        return distance;
    }

    public int Shortest(ArrayList<Double> distance) {
        int index = 0;
        double ss = distance.get(0);
        for (int i = 0; i < distance.size(); i++) {
            if (distance.get(i) < ss) {
                index = i;
                ss = distance.get(i);
            }
        }
        return index;
    }

    public double Calculate_distance(ArrayList<double[]> order) {
        double distance = 0.0;
        for (int i = 0; i < order.size() - 1; i++) {
            distance = distance + Math.sqrt(Math.pow(order.get(i)[0] - order.get(i + 1)[0], 2) + Math.pow(order.get(i)[1] - order.get(i + 1)[1], 2));
        }
        distance = distance + Math.sqrt(Math.pow(order.get(0)[0] - order.get(order.size() - 1)[0], 2) + Math.pow(order.get(0)[1] - order.get(order.size() - 1)[1], 2));
        return distance;
    }
}
