import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Þðà on 26.11.2015.
 */
public class BattleShipCreating extends JFrame {
    int buttonSize = 50;
    JButton[][] field = new JButton[10][10];
    JButton[][] field2 = new JButton[10][10];
    boolean directionVertical = false;     // if vertical then true else gorizontal
    int shipValue = 0;
    int n1 = 4;
    int n2 = 3;
    int n3 = 2;
    int n4 = 1;

    public BattleShipCreating() {
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

        setBounds(50, 50, buttonSize * 22 + 20, buttonSize * 11 + 2 * buttonSize);
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
                jb.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        boolean f = false;
                        switch (shipValue) {
                            case (0):
                                f = false;
                                break;
                            case (1):
                                f = n1 != 0;
                                break;
                            case (2):
                                f = n2 != 0;
                                break;
                            case (3):
                                f = n3 != 0;
                                break;
                            case (4):
                                f = n4 != 0;
                                break;
                        }
                        if (f) {
                            viewPossibility(false);
                            int x = (jb.getY() + buttonSize) / buttonSize - 1;
                            int y = (jb.getX() + buttonSize) / buttonSize - 1;
                            if (!aroundView(x, y)) {
                                JOptionPane.showMessageDialog(null, "Change dislacation your ship");
                                viewPossibility(true);
                            }
                        }
                    }
                });
                field[i][j] = jb;
                add(jb);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton jb = new JButton();
                jb.setBounds(j * buttonSize + 12 * buttonSize, (i + 1) * buttonSize, buttonSize, buttonSize);
                add(jb);
                field2[i][j] = jb;
            }
        }
        JButton jb = new JButton("Horizontal");
        jb.setBounds(70, 550, 150, 30);
        JButton jb2 = jb;
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                directionVertical = !directionVertical;
                if (jb2.getText().equals("Horizontal")) {
                    jb2.setText("Vertical");
                    ;
                } else {
                    jb2.setText("Horizontal");
                    ;
                }
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("XXXX");
        jb.setBounds(220, 550, 120, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 4;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("XXX");
        jb.setBounds(340, 550, 90, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 3;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("XX");
        jb.setBounds(430, 550, 60, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 2;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        jb = new JButton("X");
        jb.setBounds(490, 550, 40, 30);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewPossibility(false);
                shipValue = 1;
                viewPossibility(true);
            }
        });
        jb.setBackground(Color.darkGray);
        jb.setForeground(Color.white);
        add(jb);
        setVisible(true);
    }

    public void viewPossibility(boolean f) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (directionVertical) {
                    if (i > 10 - shipValue) {
                        field[i][j].setEnabled(!f);
                    }
                } else {
                    if (j > 10 - shipValue) {
                        field[i][j].setEnabled(!f);
                    }
                }
            }
        }
    }

    public boolean aroundView(int x, int y) {
        x = x - 1;
        y = y - 1;
        boolean f = true;
        int n = shipValue;
        ArrayList<MyClass> list = new ArrayList<>();//
        try {
            while (f && n > 0) {
                if (field2[x][y].getText().equals("")) {
                    MyClass myClass = new MyClass(x, y);//
                    list.add(myClass);
                    if (directionVertical) {
                        x++;
                    } else {
                        y++;
                    }
                    n--;
                } else {
                    viewPossibility(false);
                    return false;
                }
                if ((x == 10 || y > 10) & n != 0) {
                    viewPossibility(false);
                    return f;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            viewPossibility(true);
            return false;
        }

        ArrayList<MyClass> list2 = new ArrayList<>();
        for (MyClass mC : list) {
            list2.add(mC);
        }
        for (MyClass mC : list2) {
            int xx = mC.getX();
            int yy = mC.getY();
            for (int i = -1; i < 2; i++) {
                if (xx + i > -1 && xx + i < 10) {
                    for (int j = -1; j < 2; j++) {
                        if (yy + j > -1 && yy + j < 10) {
                            if (!(i == 0 && j == 0)) {
                                int q = xx + i;
                                int w = yy + j;
                                if (!list.contains(new MyClass(q, w)) && !field2[q][w].getText().equals("")) {
                                    viewPossibility(false);
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        if (f) {
            for (MyClass mC : list) {
                int i = mC.getX();
                int j = mC.getY();
                JButton jb = field2[i][j];
                jb.setEnabled(false);
                jb.setText(shipValue + "");
                field[i][j].setVisible(false);
            }
            if (shipValue == 1) {
                n1--;
            }
            if (shipValue == 2) {
                n2--;
            }
            if (shipValue == 3) {
                n3--;
            }
            if (shipValue == 4) {
                n4--;
            }
            viewPossibility(false);
            update(getGraphics());
        }
        return f; // true if empty
    }

    public int status() {
        return n1 + n2 + n3 + n4;
    }

    public int[][] getField() {
        int[][] a = new int [10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String str = field2[i][j].getText();
                a[i][j] = str.equals("") ? 0 : Integer.parseInt(str);
            }
        }
        return a;
    }
}
