import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestCardLayout extends JFrame implements ActionListener {
     CardLayout cl;
     JPanel nav = new JPanel();
     JPanel main = new JPanel();
     JPanel jp1 = new JPanel();
     JPanel jp2 = new JPanel();
     JPanel jp3 = new JPanel();
     JPanel jp4 = new JPanel();
     JPanel jpFirst = new JPanel();
     JPanel jpNext = new JPanel();
     JPanel jpPrevious = new JPanel();
     JPanel jpLast = new JPanel();
     JLabel jl1 = new JLabel("第一张");
     JLabel jl2 = new JLabel("第二张");
     JLabel jl3 = new JLabel("第三张");
     JLabel jl4 = new JLabel("第四张");
     JButton first = new JButton("第一张");
     JButton next = new JButton("下一张");
     JButton previous = new JButton("上一张");
     JButton last = new JButton("最后一张");
     
     public static void main(String[] args) {
         new TestCardLayout();
     }
     
    public TestCardLayout() {
        this.setTitle("TestCardLayout");
        this.setSize(400, 300);
        this.setLayout(new GridLayout(1, 2));
        main.setLayout(new CardLayout());
        this.setResizable(false);
        
        nav.setLayout(new GridLayout(4,1));
        jp1.add(first);
        jp2.add(next);
        jp3.add(previous);
        jp4.add(last);
        nav.add(jp1);
        nav.add(jp2);
        nav.add(jp3);
        nav.add(jp4);
        jpFirst.add(jl1);
        jpNext.add(jl2);
        jpPrevious.add(jl3);
        jpLast.add(jl4);
        main.add(jpFirst);
        main.add(jpNext);
        main.add(jpPrevious);
        main.add(jpLast);
        
        this.add(nav);
        this.add(main);
        first.addActionListener(this);
        next.addActionListener(this);
        previous.addActionListener(this);
        last.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }            
        });            
        setVisible(true);    
     }
     
    public void actionPerformed(ActionEvent e) {
        cl = (CardLayout)main.getLayout();
        cl.setHgap(0); cl.setVgap(0);
        
        if(e.getSource() == first){
            cl.first(main);
        }else if(e.getSource() == next){
            cl.next(main);
        }else if(e.getSource() == previous){
            cl.previous(main);
        }else if(e.getSource() == last){
            cl.last(main);
        }
        
        
    }

}