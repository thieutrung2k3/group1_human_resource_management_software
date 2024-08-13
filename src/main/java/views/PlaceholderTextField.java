package views;

import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.EmptyBorder;

public class PlaceholderTextField extends JTextField {

    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;

         setOpaque(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setFont(new Font("Arial", Font.PLAIN, 14)); 
        // Xử lý sự kiện focus để hiển thị/ẩn chữ mờ
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g2);

        // Vẽ placeholder nếu JTextField trống
        if (getText().isEmpty() && !isFocusOwner()) {
            g2.setFont(new Font("Arial", Font.PLAIN, 14));
            g2.setColor(Color.GRAY); // Màu xám
            int padding = (getHeight() - getFont().getSize()) / 2;
            g2.drawString(placeholder, getInsets().left, getHeight() - padding - 1);
        }
        g2.dispose();
    }
     @Override
    protected void paintBorder(Graphics g) {
        // Vẽ viền bo tròn
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        return new Insets(10, 10, 10, 20); // Khoảng cách bên trong
    }
}
