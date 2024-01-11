package simulation.src.main.java;

import java.nio.file.Watchable;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        ArrayList<Integer> neww  = new ArrayList<>();

        neww.add(3);
        neww.add(3);neww.add(5);neww.add(8);neww.add(3);neww.add(5);neww.add(8);neww.add(2);neww.add(5);neww.add(8);
        neww.add(3);
        neww.add(3);neww.add(5);neww.add(8);neww.add(3);neww.add(5);neww.add(8);neww.add(2);neww.add(5);neww.add(8);
        neww.add(3);






        War test = new War(neww);
        System.out.println(test);
        System.out.println(test.simulateGame());

    }
}
