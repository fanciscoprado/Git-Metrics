package sample;
import java.util.LinkedList;


public class Print {
    public void results(LinkedList<wc> list) {
        System.out.printf("%-20s", "Word");
        System.out.printf("%-20s", "Line");
        System.out.printf("%-20s", "Character");
        System.out.println();
        for (wc temp: list) {
            if(!temp.skipped) {
                System.out.printf("%-20d", temp.wcount);
                System.out.printf("%-20d", temp.lcount);
                System.out.printf("%-20d", temp.ccount);
                System.out.println(temp.filename);
            }
        }
    }
}
