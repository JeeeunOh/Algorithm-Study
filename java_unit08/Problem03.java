
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problem03 extends JFrame{
	private int x,y,i=0;
	private JButton btn;
	public Problem03() {
		this.setTitle("그래픽 문제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("클릭하세요");
		c.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPanel m = new MyPanel();
				c.add(m);
			}
		});
		
		this.setSize(300,300);
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			int x = (int)(Math.random()*50)+1;
			int y = (int)(Math.random()*50)+1;
			if(i%5==0) g.setColor(Color.RED);
			if(i%5==1) g.setColor(Color.GREEN);
			if(i%5==2) g.setColor(Color.BLUE);
			if(i%5==3) g.setColor(Color.YELLOW);
			if(i%5==4) g.setColor(Color.BLACK);
			g.fillRect(x,y,50,50);
			i++; 
		}
	}
	public static void main(String[] args) {
		new Problem03();
	}
}