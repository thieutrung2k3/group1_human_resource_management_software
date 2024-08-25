/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author PC
 */
public class JFrameUtil {

    public static void centerFrame(JFrame frame) {
        // Lấy kích thước màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Tính toán vị trí để căn JFrame ra giữa
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int frameX = (screenWidth - frameWidth) / 2;
        int frameY = (screenHeight - frameHeight) / 2;

        // Đặt vị trí cho JFrame
        frame.setLocation(frameX, frameY);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
}
