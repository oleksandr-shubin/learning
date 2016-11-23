import model.enums.WindRose;

public class Main {
    public static void main(String[] args) {
        for (WindRose direction : WindRose.values()) {
           System.out.printf("%s : %d degrees, %d rhumbs%n",
                   direction, direction.getDegrees(), direction.getRhumbs());
        }
    }
}
