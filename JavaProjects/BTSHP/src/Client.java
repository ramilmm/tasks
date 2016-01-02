import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by ��� on 19.11.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        int port = 1234;
        String host = "10.19.19.76";
        Socket s = new Socket(host, port);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        BattleShipCreating bsc = new BattleShipCreating();
        int st = bsc.status();
        while(st != 0){
            st = bsc.status();
            Thread.sleep(500);
        }
        bsc.dispose();
        int[][] myField = bsc.getField();
        oos.writeObject(myField);
        boolean flag = (boolean) ois.readObject();
        int[][] youField = (int[][]) ois.readObject();

        Battleship battleship = new Battleship(oos, myField, youField);
        boolean endGame = false;
        int k = 0;
        while (!endGame) {
            battleship.enableAction(flag);
            if (!flag) {
                JOptionPane.showMessageDialog(null, "Wait, 2 player is thinking");
                Target tFM = (Target) ois.readObject();
                endGame = (boolean) ois.readObject();
                while (myField[tFM.getI()][tFM.getJ()] != 0 & !endGame) {
                    int i = tFM.getI();
                    int j = tFM.getJ();
                    k += myField[i][j];
                    JButton jb = battleship.field[i][j];
                    jb.removeActionListener(null);
                    jb.setBackground(Color.RED);
                    if (k == 50) {
                        battleship.dispose();
                        JOptionPane.showMessageDialog(null, "You lose");
                        return;
                    }
                    tFM = (Target) ois.readObject();
                    endGame = (boolean) ois.readObject();
                }
                int i = tFM.getI();
                int j = tFM.getJ();
                k += myField[i][j];
                if (k == 50) {
                    battleship.dispose();
                    JOptionPane.showMessageDialog(null, "You lose");
                    return;
                }
                JButton jb = battleship.field[tFM.getI()][tFM.getJ()];
                jb.removeActionListener(null);
                jb.setBackground(Color.ORANGE);
            }
            flag = (boolean) ois.readObject();
            endGame = (boolean) ois.readObject();
        }
        if (endGame) {
            battleship.dispose();
            JOptionPane.showMessageDialog(null, "You win");
        }
    }
}
