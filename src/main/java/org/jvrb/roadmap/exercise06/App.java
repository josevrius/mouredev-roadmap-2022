package org.jvrb.roadmap.exercise06;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;

public class App {

    private static final Scanner SCN = new Scanner(System.in);

    private static final String HEADER = """
            
            ASPECT RATIO
            ============
            Imagen .:\s""";

    public static void main(String[] args) {
        System.out.print(HEADER);
        try {
            ImageReader image = enterSource();
            System.out.printf("AR .....: %s = %s%n", getAspectRatio(image), getSimpleAspectRatio(image));
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.out.println("Error ..: Imagen no encontrada");
            } else {
                System.out.println("Error ..: " + e.getMessage());
            }
        }
    }

    private static ImageReader enterSource() throws IOException {
        String source = SCN.nextLine().strip();
        ImageInputStream iis = getImageInputStream(source);
        return getImageReader(iis);
    }

    private static ImageInputStream getImageInputStream(String source) throws IOException {
        return ImageIO.createImageInputStream(
                source.startsWith("https://")
                        ? URI.create(source).toURL().openStream()
                        : Path.of(source).toFile()
        );
    }

    private static ImageReader getImageReader(ImageInputStream iis) throws IOException {
        ImageReader reader;
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

        if (readers.hasNext()) {
            reader = readers.next();
            reader.setInput(iis);
        } else {
            throw new IOException("Invalid format image");
        }
        return reader;
    }

    private static String getAspectRatio(ImageReader ir) throws IOException {
        return new DecimalFormat("#.##").format(ir.getAspectRatio(0)).replace(",", ".") + ":1";
    }

    private static String getSimpleAspectRatio(ImageReader ir) throws IOException {
        int width = ir.getWidth(0);
        int height = ir.getHeight(0);
        int gcd = calculateGCD(width, height);

        return width / gcd + ":" + height / gcd;
    }

    private static int calculateGCD(int width, int height) {
        int gcd = width;

        while (height != 0) {
            int temp = height;
            height = gcd % height;
            gcd = temp;
        }
        return gcd;
    }
}
