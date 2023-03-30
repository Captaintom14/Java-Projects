import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deroulementJeu extends JButton  {

    private JButton [][] jButton;
    private String [] grille;
    private int value = 0;
    private char ligne;
    private char colonne;
    private int clic = 0;


    public deroulementJeu(JButton [][] jButton, String[] grille, int i, int j) {

        char initialiser = grille[i].toCharArray()[j];

        if (initialiser == ' '){

                     jButton[i][j].addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {

                             jButton[i][j].setText(String.valueOf((value%5)+1));
                             value++;
                             if (value == 5){
                                 value = 0;
                                 jButton[i][j].setText("");

                                 Couleur couleur = new Couleur(jButton,i,j);
                             }

                         }
                     });

                     }

                 else {
                     jButton[i][j].setText(String.valueOf(grille[i].charAt(j)));

                }
                 this.add(jButton[i][j]);




        }

    }


