import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Problem01 extends JFrame{
	public Problem01() {
		setTitle("배경색 바꾸기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("클릭");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red = (int)(Math.random()*255);
				int blue = (int)(Math.random()*255);
				int green = (int)(Math.random()*255);
				Color color = new Color(red,blue,green);
				c.setBackground(color); 
			}
		});
		c.add(btn);
		
		setSize(300,180);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Problem01();
	}

}
