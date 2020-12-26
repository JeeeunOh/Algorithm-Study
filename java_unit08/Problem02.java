import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Problem02 extends JFrame{
	private JLabel imageLabel;
	private JRadioButton[] b = new JRadioButton[3];
	private ImageIcon[] image = new ImageIcon[3] ;
	public Problem02() {
		setTitle("애완동물");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		image[0] = new ImageIcon("src\\images\\dog.jpg");
		image[1] = new ImageIcon("src\\images\\cat.jpg");
		image[2] = new ImageIcon("src\\images\\rabbit.jpg");
		String[] cl = {"강아지", "고양이", "토끼"};
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		imageLabel = new JLabel();
		c.add(imageLabel, BorderLayout.CENTER);
		
		JPanel r_button = new JPanel();
		ButtonGroup g = new ButtonGroup();
		for (int i=0;i<cl.length;i++) {
			b[i] = new JRadioButton(cl[i]);
			g.add(b[i]);
			r_button.add(b[i]);
			b[i].addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange()==ItemEvent.SELECTED) {
						if(e.getItem()==b[0]) {
							imageLabel.setIcon(image[0]);
						}
						else if(e.getItem()==b[1]) {
							imageLabel.setIcon(image[1]);
						}
						else
							imageLabel.setIcon(image[2]);
					}
				}
			});
		}
		c.add(r_button, BorderLayout.NORTH);
		setSize(800,800);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Problem02();
	}

}
