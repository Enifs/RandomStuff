import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.JTextComponent;

/**
 * Created by Anna on 17/09/2014.
 */
public class DisplayBuilder {

	public DisplayBuilder() {
		JFrame frame = new JFrame("Box");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("This is your display box.");
		String scrollable = new String("And this is your scroll pane. You might have noticed that the" +
				" preceding code sets the preferred size of the scroll pane's container. In the Java look and feel, this preferred size happens to be a bit less tall than required for the text area to display the 5 rows that we requested when creating it, so the scroll bar initially displays a vertical scroll bar. If we didn't restrict the size of the scroll pane's container, the scroll pane would be big enough for the text area to display the full 5 rows and 30 columns specified with the JTextArea constructor. Refer to Sizing a Scroll Pane for information about techniques for making a scroll pane the size you want.");
		JLabel label1 = new JLabel();

		JTextArea textArea = new JTextArea(5, 30);
		textArea.append("And this is your scroll pane. You might have noticed that the preceding code sets the preferred size of the scroll pane's container. In the Java look and feel, this preferred size happens to be a bit less tall than required for the text area to display the 5 rows that we requested when creating it, so the scroll bar initially displays a vertical scroll bar. If we didn't restrict the size of the scroll pane's container, the scroll pane would be big enough for the text area to display the full 5 rows and 30 columns specified with the JTextArea constructor. Refer to Sizing a Scroll Pane for information about techniques for making a scroll pane the size you want.");
		textArea.setLineWrap(true);
		JScrollPane jScrollPane = new JScrollPane(textArea);
		jScrollPane.createVerticalScrollBar();
//		jScrollPane.add(label1);
		jScrollPane.setVisible(true);

		frame.add(jScrollPane);
//		frame.setGlassPane(label);
		frame.pack();
		frame.setVisible(true);
	}
}
