import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Юра on 19.11.2015.
 */
public class Battleship extends JFrame {
    int buttonSize = 50;
    JButton[][] field = new JButton[10][10];
    JButton[][] field2 = new JButton[10][10];
    boolean flag;

    public Battleship(ObjectOutputStream oos, int[][] field, int[][] field2) throws IOException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Battleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        setBounds(50, 50, buttonSize * 22 + 20, buttonSize * 11 + buttonSize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GroupLayout(getContentPane()));
        for (int i = 97; i < 118; i++) {
            if (i != 107) {
                JButton jb = new JButton();
                jb.setText((i < 107 ? (char) i : (char) (i - 11)) + "");
                jb.setBounds((i + 1 - 97) * buttonSize, 0, buttonSize, buttonSize);
                jb.setBackground(Color.WHITE);
                add(jb);
            }
        }
        for (int i = 0; i < 10; i++) {
            JButton jb = new JButton();
            jb.setText("" + (1 + i));
            jb.setBounds(0, (i + 1) * buttonSize, buttonSize, buttonSize);
            jb.setBackground(Color.WHITE);
            add(jb);
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton jb = new JButton();
                jb.setBounds((j + 1) * buttonSize, (i + 1) * buttonSize, buttonSize, buttonSize);
                add(jb);
                this.field[i][j] = jb;
                if (field[i][j] == 0) {
                    jb.setText("");
                } else {
                    jb.setText(field[i][j] + "");
                    jb.setBackground(Color.DARK_GRAY);
                    jb.setForeground(Color.WHITE);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton jb = new JButton();
                jb.setBounds(j * buttonSize + 12 * buttonSize, (i + 1) * buttonSize, buttonSize, buttonSize);
                jb.setName(field2[i][j] + "");
                jb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (flag) {
                            jb.setText(jb.getName().equals("0") ? "0" : "H");
                            Target target = new Target();
                            int i = (jb.getY()) / buttonSize;
                            int j = (jb.getX() + buttonSize) / buttonSize - 12 + 96;
                            target.setI(i);
                            target.setJ(j);
                            jb.setEnabled(false);
                            if (jb.getText().equals("H")){
                                statusesShipes(i,j);
                            }
                            update(getGraphics());
                            try {
                                oos.writeObject(target);
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
                add(jb);
                this.field2[i][j] = jb;
            }
        }
        setVisible(true);
    }

    public void enableAction(boolean flag) {
        this.flag = flag;
    }

    public void enabledButtons(boolean b) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j].setEnabled(false);
                field2[i][j].setEnabled(false);
            }

        }
        update(getGraphics());
    }

    public boolean getStatus() {
        int k = 50;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String txt = field[i][j].getText();
                if (!txt.equals("") && field[i][j].getBackground().equals(Color.RED)) {
                    k -= Integer.parseInt(txt);
                }
            }
        }
        return k == 0; // true, если ты еще не проиграл
    }

    public void statusesShipes(int i, int j) {
        statusesShipes(i - 1, j - 97, Integer.parseInt(field2[i - 1][j - 97].getName()), new ArrayList<JButton>());
    }

    public void statusesShipes(int i, int j, int maxSch, ArrayList<JButton> list) {
        if(list.size() != maxSch){
                try{
                    for(int i1 = -1; i <2 ; i++){
                        for (int j1 = -1; j1 < 2; j1++) {
                            if (i1 != 0 & j1 != 0){
                                if (field2[i][j].getText().equals("H")){
                                    list.add(field2[i1][j1]);
                                    maxSch++;
                                    statusesShipes(i,j,maxSch, list);
                                    continue;
                                }
                            }
                        }
                    }
                }catch (ArrayIndexOutOfBoundsException ignored){
                }
        }else{
            for(JButton jb : list){
                jb.setForeground(Color.RED);
                jb.setText("X");
            }
        }
    }
}
