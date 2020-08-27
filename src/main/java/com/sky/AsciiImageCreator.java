package com.sky;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author : wushikai
 * <p>
 * date : 2020-08-05
 */

public class AsciiImageCreator {
    public static void create(File srcImgFile, File destAsciiImgFile) {
        final String base = "@#&$%*o!;.";
        String result = "";
        try {
            BufferedImage bufferedImage = ImageIO.read(srcImgFile);
            for (int i = 0; i < bufferedImage.getHeight(); i += 32) {
                for (int j = 0; j < bufferedImage.getWidth(); j += 8) {
                    int pixel = bufferedImage.getRGB(j, i); // 下面三行代码将一个数字转换为RGB数字
                    int red = (pixel & 0xff0000) >> 16;
                    int green = (pixel & 0xff00) >> 8;
                    int blue = (pixel & 0xff);
                    float gray = 0.299f * red + 0.578f * green + 0.114f * blue;
                    int index = Math.round(gray * (base.length() + 1) / 255);
                    result += index >= base.length() ? " " : String.valueOf(base.charAt(index));
                }
                result += "\r\n";
            }
            FileWriter fileWriter = new FileWriter(destAsciiImgFile);
            fileWriter.write(result);
            fileWriter.flush();
            fileWriter.close();
            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void create(String srcImgFile, String destAsciiImgFile) {
        create(new File(srcImgFile),new File(destAsciiImgFile));
    }



    public static void main(String[] args){
        File file = new File("C:\\Users\\Administrator\\Pictures\\但是.jpg");
        File file1 = new File("test.txt");
        AsciiImageCreator.create(file, file1);

    }
}
