import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDO extends JFrame {

    public UDO(String[] grille) {


        JPanel Board = new JPanel(new GridLayout(4,4));

        JButton[][] numeros = new JButton[4][4];

        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {

                numeros[i][j] = new JButton();
                numeros[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

                Font font = new Font("Arial", Font.PLAIN, 20);
                numeros[i][j].setFont(font);
                numeros[i][j].setForeground(Color.BLACK);
                numeros[i][j].setBackground(Color.WHITE);

                //initialiser les positions et faire les actions pour augmenter la valeur de 1 a 4
                deroulementJeu tableau = new deroulementJeu(numeros,grille,i,j);

                ///creation des menus pour le menu et le propos
                JMenuBar menubar= new JMenuBar();

                JMenu menu = new JMenu("Menu");
                JMenu propos = new JMenu("Propos");

                menubar.add(menu);
                menubar.add(propos);
                this.setJMenuBar(menubar);

                JMenuItem nvPartie = new JMenuItem("Une nouvelle partie");
                JPanel nouveau = new JPanel();

                nvPartie.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        new UDO(grille);
                        JOptionPane.showMessageDialog(nouveau,"Vous avez recommence une partie");

                    }
                });

                menu.add(nvPartie);
                menu.addSeparator();

                JMenuItem mnuQuitter = new JMenuItem("Quitter");
                JPanel quitter = new JPanel();
                mnuQuitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(quitter,"Vous avez quitter cette partie de Sudoku");
                        System.exit(0);
                    }
                });
                menu.add(mnuQuitter);

                JPanel info = new JPanel();
                JMenuItem auteur= new JMenuItem("A propos");
                auteur.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog( info,
                                "Auteur : Thomas Mejia");
                    }
                });
                propos.add(auteur);


                numeros[i][j].setOpaque(true);
                numeros[i][j].setHorizontalAlignment(JTextField.CENTER);
                Board.add(numeros[i][j]);



            }

    }
        this.add(Board);
        this.setTitle("UDO");
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }





}





