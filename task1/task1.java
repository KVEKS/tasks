import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task1 {
    public static void main(String[] args) throws IOException {
        String fileNameIn = args[0];
        List<String> lines = Files.readAllLines(Paths.get(fileNameIn), Charset.defaultCharset());
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (String s : lines) {
            list.add(Integer.parseInt(s));
        }

        Collections.sort(list);
        calcPercentiles(list);
        mediane(list);
        System.out.format("%.2f%n", Double.parseDouble(list.get(list.size() - 1).toString()));
        System.out.format("%.2f%n", Double.parseDouble(list.get(0).toString()));
        average(list);
    }

    public static void calcPercentiles(ArrayList list) {
        int size = list.size();

        double x = (0.9 * (size - 1) + 1);
        int index = (int) x - 1;
        int nextIndex = (int) x;
        double coefficient = x - (int) x;
        double result = Double.parseDouble(list.get(index).toString()) + (coefficient *
                (Double.parseDouble(list.get(nextIndex).toString()) - Double.parseDouble(list.get(index).toString())));
        System.out.format("%.2f%n", result);

    }

    public static void mediane(ArrayList list) {
        int size = list.size();
        double result;
        if (size % 2 == 0) {
            int index = size / 2;
            result = (Double.parseDouble(list.get(index).toString()) + Double.parseDouble(list.get(index + 1).toString())) / 2;
        } else {
            int index = (int) (size / 2 + 0.5);
            result = Double.parseDouble(list.get(index).toString());
        }
        System.out.format("%.2f%n", result);
    }

    public static void average(ArrayList list) {
        double sum = 0;
        for (Object i : list) {
            sum += Double.parseDouble(i.toString());
        }
        double result = sum / list.size();
        System.out.format("%.2f%n", result);
    }
}
