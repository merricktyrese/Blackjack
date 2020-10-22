import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DealButton extends Casino implements ActionListener  {
    public void actionPerformed(ActionEvent e) {
        dcardPanel.add(dealerlabel);
        pcardPanel.add(playerlabel);

    }
}
