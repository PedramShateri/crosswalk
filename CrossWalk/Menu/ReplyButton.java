package CrossWalk.Menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import CrossWalk.Const;
import CrossWalk.InitGame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReplyButton extends Menu {

    public ReplyButton() {
        super("بازی های قابل مشاهده", 500, 500);
    }

    @Override
    protected void createPanel() {
        File buttons = null;

        JPanel panel = new JPanel(new BorderLayout(1, 1));
        panel.setBorder(new EmptyBorder(5, 10, 20, 10));

        frame.setContentPane(panel);

        JPanel controls = new JPanel(new GridLayout(6, 0));
        panel.add(controls, BorderLayout.CENTER);

        buttons = new File(Const.ROOT_PATH + Const.REPLY_ROOT_ADDRESS);
        String[] buttonsName = buttons.list();

        for (int i = 1; i <= buttonsName.length; i++) {
            JButton currentButton = createButton(buttonsName[i - 1], (ActionEvent event) -> {
                JButton temp = (JButton) event.getSource();

                InitGame initReply = new InitGame();
                initReply.replyTheMovie("\\" + temp.getText());
            });
            controls.add(currentButton);
        }
    }

}