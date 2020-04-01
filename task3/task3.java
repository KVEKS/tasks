import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String dir = args[0];

        List<String> cash1 = Files.readAllLines(Paths.get(dir + "Cash1.txt"), Charset.defaultCharset());
        List<String> cash2 = Files.readAllLines(Paths.get(dir + "Cash2.txt"), Charset.defaultCharset());
        List<String> cash3 = Files.readAllLines(Paths.get(dir + "Cash3.txt"), Charset.defaultCharset());
        List<String> cash4 = Files.readAllLines(Paths.get(dir + "Cash4.txt"), Charset.defaultCharset());
        List<String> cash5 = Files.readAllLines(Paths.get(dir + "Cash5.txt"), Charset.defaultCharset());

        ArrayList<Float> cash1list = new ArrayList<Float>();

        for (String s : cash1) {
            cash1list.add(Float.parseFloat(s));
        }

        ArrayList<Float> cash2list = new ArrayList<Float>();

        for (String s : cash2) {
            cash2list.add(Float.parseFloat(s));
        }

        ArrayList<Float> cash3list = new ArrayList<Float>();

        for (String s : cash3) {
            cash3list.add(Float.parseFloat(s));
        }

        ArrayList<Float> cash4list = new ArrayList<Float>();

        for (String s : cash4) {
            cash4list.add(Float.parseFloat(s));
        }

        ArrayList<Float> cash5list = new ArrayList<Float>();

        for (String s : cash5) {
            cash5list.add(Float.parseFloat(s));
        }

        System.out.println(index(cash1list));
        System.out.println(index(cash2list));
        System.out.println(index(cash3list));
        System.out.println(index(cash4list));
        System.out.println(index(cash5list));
    }

    public static int index(ArrayList<Float> list) {
        float max = list.get(0);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        index++;
        return index;
    }
}
