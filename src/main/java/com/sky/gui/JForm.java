package com.sky.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author : wushikai
 * <p>
 * date : 2020-06-09
 */
public class JForm {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;

    public static void main(String[] args){
        JFrame jFrame=new JFrame("Java");
        jFrame.add(new JForm().tabbedPane1);
        jFrame.setBackground(Color.white);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
