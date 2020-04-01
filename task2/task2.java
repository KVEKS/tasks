import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
        String rectangleIn = args[0];
        String dotsIn = args[1];

        List<String> lines = Files.readAllLines(Paths.get(rectangleIn), Charset.defaultCharset());
        List<String> dotsFromFile = Files.readAllLines(Paths.get(dotsIn), Charset.defaultCharset());

        ArrayList<Float> corners = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            for (String s : lines.get(i).split("\\s")) {
                corners.add(Float.parseFloat(s));
            }
        }

        ArrayList<Float> dots = new ArrayList<>();

        for (int i = 0; i < dotsFromFile.size(); i++) {
            for (String s : dotsFromFile.get(i).split("\\s")) {
                dots.add(Float.parseFloat(s));
            }
        }

        float leftLowerCornerX = corners.get(0);
        float leftLowerCornerY = corners.get(1);
        float rightUpperCornerX = corners.get(4);
        float rightUpperCornerY = corners.get(5);


        float dotCheckX = 0, dotCheckY = 0;
        for (int i = 0; i < dots.size(); i+=2) {
            dotCheckX = dots.get(i);
            dotCheckY = dots.get(i+1);
            if ((dotCheckX == leftLowerCornerX || dotCheckX == rightUpperCornerX) & (dotCheckY == leftLowerCornerY || dotCheckY == rightUpperCornerY)) {
                System.out.println(0);
            } else if ((((dotCheckX == leftLowerCornerX | dotCheckX == rightUpperCornerX) &
                    ((dotCheckY > leftLowerCornerY) & (dotCheckY < rightUpperCornerY))) |
                    (dotCheckY == leftLowerCornerY | dotCheckY == rightUpperCornerY) &
                            ((dotCheckX > leftLowerCornerX) & (dotCheckX < rightUpperCornerX))))
            {
                System.out.println(1);
            } else if ((dotCheckX > leftLowerCornerX & dotCheckX < rightUpperCornerX) & (dotCheckY > leftLowerCornerY & dotCheckY < rightUpperCornerY)) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}


