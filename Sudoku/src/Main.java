import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        String[] grille = lectureGrille("grille.txt");

        UDO fenetre = new UDO(grille);

        for (int i = 0; i < grille.length ; i++) {
            System.out.println(grille[i]);
        }

    }

    //lecture du grille.txt
    public static String[] lectureGrille(String file) throws FileNotFoundException {

        JFrame erreur = new JFrame();
        ArrayList<String[]> lecture = new ArrayList<>();
        String[] valide =  new String[0];
        try {
            //1- Créer un objet de FileReader pour les mots
            FileReader rT = new FileReader(file);
            //2- Créer un objet de Buffered Reader pour les mots
            BufferedReader rL = new BufferedReader(rT);

            boolean Empty = true;
            boolean last;

            do {
                last = true;
                String[] grille = new String[4];

                for (int i = 0; i < grille.length && rL.ready(); i++) {
                    Empty = false;
                    String colonne = rL.readLine();

                    //validation de grille
                    validationDeGrille(colonne);

                    //validation des valeurs
                  validationDesValeurs(colonne);

                    grille[i] = colonne;
                }

                //si le file.txt est vide
                if (Empty) {
                    throw new FileIsEmptyException();
                }
                // si le file.txt nest pas vide
                if (rL.ready()) {
                    String tirer = rL.readLine();
                    if (tirer.equals("----")) {
                        last = false;
                    } else {
                        throw new not4X4Exception();
                    }
                }
                //ajouter le grille dans un arraylist
                lecture.add(grille);
            } while (!last);

            //Ensuite le programme choisit aleatoirement un grille
            Random ran = new Random();
            valide = lecture.get(ran.nextInt(lecture.size()));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(erreur, "Il y a un probleme lors de la lecture du " + file + ".txt");
            erreur.setVisible(true);
            System.exit(0);
        }  catch (FileIsEmptyException e) {
            JOptionPane.showMessageDialog(erreur, file + ".txt est vide. Veuillez reesayer encore une fois");
            erreur.setVisible(true);
            erreur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        }  catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(erreur, "Il y a un erreur dans le programme, Veuillez reesayer encore une fois");
            System.exit(0);
        } catch (not4X4Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(erreur, "Le grille doit contenir seulement 4X4. Veuillez reesayez encore une fois");
            erreur.setVisible(true);
            erreur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        }

        return valide;

    }

    public static String validationDeGrille (String colonne){
        JFrame erreur = new JFrame();
        try {
            //valider si le
            if (colonne.length() != 4) {
                throw new not4X4Exception();
            }
        } catch ( not4X4Exception e){
                JOptionPane.showMessageDialog(erreur, "Le grille doit contenir seulement 4X4. Veuillez reesayez encore une fois");
                erreur.setVisible(true);
                erreur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
        }

        return colonne;
    }



    public static String validationDesValeurs(String valeurs){
        JFrame erreur = new JFrame();
        for (int j = 0; j < valeurs.length(); j++) {
            char[] numbers = valeurs.toCharArray();
            if ((numbers[j] < 49 || numbers[j] > 52) && numbers[j] != 32) {
                try {
                    throw new IncorrectValueException();
                } catch (IncorrectValueException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(erreur, "Il faut que les valeurs soient entre 1 et 4");
                    erreur.setVisible(true);
                    erreur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    System.exit(0);
                }
            }

        }
        return valeurs;

    }





    public static class not4X4Exception extends Exception {

    }

    public static class IncorrectValueException extends Exception {
    }

    public static class FileIsEmptyException extends Exception {
    }





}


