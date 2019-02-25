package AntCity;

import java.util.ArrayList;

/**
 * @author ：Yorick
 * @date ：Created in 2019/2/22 10:38
 * @description：主函数
 * @modified By：
 * @version: 1.0$
 */
public class main {
    public static void main(String[] args) {

        function fun = new function();
        ArrayList<double[]> list = new ArrayList<double[]>();
        list = fun.addlist(init.locate);
        ArrayList<double[]> list1 = new ArrayList<double[]>();
        ArrayList<double[]> list3 = new ArrayList<double[]>();
        ArrayList<Double> distance = new ArrayList<Double>();
        ArrayList<double[]> order = new ArrayList<double[]>();
        order.add(list.get(0));

        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i));
        }

        while (list1.size() > 1) {

            //list2是相对位置
            ArrayList<double[]> list2 = fun.Relative_position(list1);
            double[] force = fun.Resultant_force(list2);
            double n = 0.01;
            double angle1 = 0.164;
            while (list3.size() <= 0) {
                angle1 = angle1 - n;
                for (int i = 0; i < list2.size(); i++) {
                    double angle = fun.Angle(force, list2.get(i));
                    if (angle > angle1) {
                        //list3是满足条件的相对位置的集合
                        list3.add(list2.get(i));
                    }

                }
            }

            for (int i = 0; i < list3.size(); i++) {
                distance.add(fun.Distance(list3.get(i)));
            }

            int index = fun.Shortest(distance);
            double[] doubles = list3.get(index);

            for (int i = 0; i < list2.size(); i++) {
                if (doubles.equals(list2.get(i))) {
                    order.add(list1.get(i));
                    list1.remove(i);
                    list1.remove(0);
                    list1.add(0, doubles);
                }
            }
            list2.clear();
            list3.clear();
            distance.clear();
        }

        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i)[0] + "  ");
            System.out.println(order.get(i)[1]);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        double Final_distance = fun.Calculate_distance(order);
        System.out.println(Final_distance);

    }


}
