package util;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class JTableUtil {

    public static void autoResizeAllColumns(JTable table) {
        // Đặt chế độ tự động điều chỉnh kích thước cho tất cả các cột
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Cập nhật lại kích thước các cột để đảm bảo chúng vừa khít với nội dung
        table.invalidate();
        table.repaint();
    }

    public static boolean isARowSelected(JTable tbl) {
        boolean selected = true;
        int selectedRowIndex = tbl.getSelectedRow();
        if (selectedRowIndex == -1) {
            selected = false;
            JOptionPane.showMessageDialog(null, "A row must be selected!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return selected;
    }
}
