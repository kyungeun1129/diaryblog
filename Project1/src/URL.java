import javax.swing.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class URL {
    private final Map<JButton, String> buttonUrlMap = new HashMap<>();

    public URL() {
        // 초기화 필요
    }

    public void addButton(JButton button, String url) {
        buttonUrlMap.put(button, url);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLink(url);  // 클릭 시마다 새 창 열기
            }
        });
    }

    private void openLink(String url) {
        try {
            // 새 창을 열도록 처리
            Desktop.getDesktop().browse(URI.create(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
