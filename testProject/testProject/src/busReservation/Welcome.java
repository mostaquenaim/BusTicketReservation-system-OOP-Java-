package busReservation;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Welcome {
    public void welcome() throws InterruptedException {
        while (true) {
            int width = 150;
            int height = 30;

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.setFont(new Font("SansSerif", Font.BOLD, 10));

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString("BUS RESERVATION", 10, 25);

            for (int y = 0; y < height; y++) {
                StringBuilder builder = new StringBuilder();

                for (int x = 0; x < width; x++) {
                    builder.append(image.getRGB(x, y) == -16777216 ? " " : "W");
                }
                System.out.println(builder);

                Thread.sleep(100);
            }
            break;
        }
    }
}
