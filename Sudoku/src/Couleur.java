import com.sun.deploy.ui.AboutDialog;

import javax.swing.*;
import java.awt.*;

public class Couleur {

    private int [] valeur = new int[16];
    private int [] nombre = new int [16];
    private boolean []ligne = new boolean[4];
    private boolean [] colonne = new boolean[4];
    private boolean[] quadrant = new boolean [4];

    public Couleur(JButton[][] jButtons, int i, int j) {

        for (int k = 0; k < 16 ; k++) {
            nombre[k] = 0;
        }


                //1er ligne du grille
                if ((jButtons[0][0]) == null){
                    valeur[0] = 0;
                }
                else if (jButtons[0][0].getText().equals("")){
                    valeur[0] = 0;
                }
                else {
                    valeur[0] = Integer.parseInt(jButtons[0][0].getText());
                }

                if ((jButtons[0][1]) == null){
                    valeur[1] = 0;
                }
                else if (jButtons[0][1].getText().equals("")){
                    valeur[1] = 0;
                }
                else{
                    valeur[1] = Integer.parseInt(jButtons[0][1].getText());
                }


                if ((jButtons[0][2]) == null){
                    valeur[2] = 0;
                }
                else if (jButtons[0][2].getText().equals("")){
                    valeur[2] = 0;
                }
                else{
                    valeur[2] = Integer.parseInt(jButtons[0][2].getText());
                }


                if ((jButtons[0][3]) == null){
                    valeur[3] = 0;
                }
                else if (jButtons[0][3].getText().equals("")){
                    valeur[3] = 0;
                }
                else {
                  valeur[3] = Integer.parseInt(jButtons[0][3].getText());
                }


                //2e ligne du grille
                if ((jButtons[1][0]) == null){
                    valeur[4] = 0;
                }
                else if (jButtons[1][0].getText().equals("")){
                    valeur[4] = 0;
                }
                else{
                    valeur[4] = Integer.parseInt(jButtons[1][0].getText());
                }

                if ((jButtons[1][1]) == null){
                    valeur[5] = 0;
                }
                else if (jButtons[1][1].getText().equals("")){
                    valeur[5] = 0;
                }
                else{
                    valeur[5] = Integer.parseInt(jButtons[1][1].getText());
                }

                if ((jButtons[1][2]) == null){
                    valeur[6] = 0;
                }
                else if (jButtons[1][2].getText().equals("")){
                        valeur[6] = 0;
                }
                else {
                    valeur[6] = Integer.parseInt(jButtons[1][2].getText());
                }

                if ((jButtons[1][3]) == null){
                    valeur[7] = 0;
                }
                else if (jButtons[1][3].getText().equals("")) {
                    valeur[7] = 0;
                }
                else{
                    valeur[7] = Integer.parseInt(jButtons[1][3].getText());
                }


                //3e ligne du grille
                if ((jButtons[2][0]) == null){
                    valeur[8] = 0;
                }
                else if (jButtons[2][0].getText().equals("")){
                    valeur[8] = 0;
                }
                else{
                    valeur[8] = Integer.parseInt(jButtons[2][0].getText());
                }

                if ((jButtons[2][1]) == null){
                    valeur[9] = 0;
                }
                else if (jButtons[2][1].getText().equals("")){
                    valeur[9] = 0;
                }
                else{
                    valeur[9] = Integer.parseInt(jButtons[2][1].getText());
                }

                if ((jButtons[2][2]) == null){
                    valeur[10] = 0;
                }
                else if (jButtons[2][2].getText().equals("")){
                    valeur[10] = 0;
                }
                else{
                    valeur[10] = Integer.parseInt(jButtons[2][2].getText());
                }

                if ((jButtons[2][3]) == null){
                    valeur[11] = 0;
                }
                else if (jButtons[2][3].getText().equals("")){
                    valeur[11] = 0;
                }
                else{
                    valeur[11] = Integer.parseInt(jButtons[2][3].getText());
                }

                //4e ligne
                if ((jButtons[3][0]) == null){
                    valeur[12] = 0;
                }
                else if (jButtons[3][0].getText().equals("")){
                    valeur[12] = 0;
                }
                else{
                    valeur[12] = Integer.parseInt(jButtons[3][0].getText());
                }

                if ((jButtons[3][1]) == null){
                    valeur[13] = 0;
                }
                else if (jButtons[3][1].getText().equals("")){
                    valeur[13] = 0;
                }
                else{
                    valeur[13] = Integer.parseInt(jButtons[3][1].getText());
                }

                if ((jButtons[3][2]) == null){
                    valeur[14] = 0;
                }
                else if (jButtons[3][2].getText().equals("")){
                    valeur[14] = 0;
                }
                else{
                    valeur[14] = Integer.parseInt(jButtons[3][2].getText());
                }

                if ((jButtons[3][3]) == null){
                    valeur[15] = 0;
                }
                else if (jButtons[3][3].getText().equals("")){
                    valeur[15] = 0;
                }
                else{
                    valeur[15] = Integer.parseInt(jButtons[3][3].getText());
                }

//-------------------------------------------------------------------------------
                //validation 1er ligne

                if((valeur[0]+valeur[1]+valeur[2]+valeur[3]) == 10){


                    nombre[0] = nombre[0] + 1;
                    nombre[1] = nombre[1] + 1;
                    nombre[2] = nombre[2] + 1;
                    nombre[3] = nombre[3] + 1;

                    ligne[0] = true;
                    }

                //validation 2e ligne
                if ((valeur[4]+valeur[5]+valeur[6]+valeur[7]) == 10){

                    nombre[4] = nombre [4] + 1;
                    nombre[5] = nombre[5] + 1;
                    nombre[6] = nombre[6] + 1;
                    nombre[7] = nombre[7] + 1;

                    ligne[1] = true;
                }

                //validation 3e ligne
                if ((valeur[8]+valeur[9]+valeur[10]+valeur[11]) == 10){

                    nombre[8] = nombre[8] + 1;
                    nombre[9] = nombre [9] + 1;
                    nombre[10] = nombre[10] + 1;
                    nombre[11] = nombre[11] + 1;

                   ligne [2] = true;
                }

                //validation 4e ligne
                if((valeur[12] + valeur[13] + valeur[14] + valeur[15]) == 10){

                    nombre[12] = nombre[12]+1;
                    nombre[13] = nombre[13]+1;
                    nombre[14] = nombre[14]+1;
                    nombre[15] = nombre[15]+1;
                    ligne[3] = true;
                }

                //----------------------------------------------------
                //validation 1er colonne

                if((valeur[0] + valeur[4] + valeur[8] + valeur[12]) == 10){


                    nombre[0] = nombre[0] + 1;
                    nombre[4] = nombre[4] + 1;
                    nombre[8] = nombre[8] + 1;
                    nombre[12] = nombre[12] + 1;

                    colonne[0] = true;
                }

                //validation 2e colonne
                if ((valeur[1] + valeur[5] + valeur[9] + valeur[13]) == 10){

                    nombre[1] = nombre[1] + 1;
                    nombre[5] = nombre[5] + 1;
                    nombre[9] = nombre[9] + 1;
                    nombre[13] = nombre[13] + 1;
                    colonne[1] = true;
                }

                //validation 3e colonne
                if ((valeur[2] + valeur[6] + valeur[10] + valeur[14]) == 10){

                    nombre[2] = nombre[2] + 1;
                    nombre[6] = nombre[6] + 1;
                    nombre[10] = nombre[10] + 1;
                    nombre[13] = nombre[14] + 1;
                    colonne[2] = true;
                }

                //validation 4e colonne
                if ((valeur[3] + valeur[7] + valeur[11] + valeur[15]) == 10){

                    nombre[3] = nombre[3] + 1;
                    nombre[7] = nombre[7] + 1;
                    nombre[11] = nombre[11] + 1;
                    nombre[15] = nombre[15] + 1;
                    colonne[3] = true;
                }



                //

                // validation 1er quadrant

                if ((valeur[0]+valeur[1]+valeur[4]+valeur[5]) == 10) {

                    nombre[0] = nombre[0] + 1;
                    nombre[1] = nombre[1] + 1;
                    nombre[4] = nombre[4] + 1;
                    nombre[5] = nombre[5] + 1;
                    quadrant[0] = true;

                }

                //validation du 2e quadrant

                if ((valeur[2] + valeur[3] + valeur[6] + valeur[7]) == 10){

                    quadrant[1] = true;

                    nombre[2] = nombre[2] + 1;
                    nombre[3] = nombre[3] + 1;
                    nombre[6] = nombre[6] + 1;
                    nombre[7] = nombre[7] + 1;

                }
                //validation du 3e quadrant

                if ((valeur[8]+valeur[9]+valeur[12] + valeur[13]) == 10){

                    quadrant[2] = true;
                    nombre[8] = nombre[8] + 1;
                    nombre[9] = nombre[9] + 1;
                    nombre[12] = nombre[12] + 1;
                    nombre[13] = nombre[13] + 1;

                }

                //validation du 4e quadrant

                if ((valeur[10] + valeur[11] + valeur[14] + valeur[15]) == 10){

                    quadrant[3] = true;
                    nombre[10] = nombre[10] + 1;
                    nombre[11] = nombre[11] + 1;
                    nombre[14] = nombre[14] + 1;
                    nombre[15] = nombre[15] + 1;


                }

                //----------------------------------------------------------

                JFrame fini = new JFrame();

                for (int k = 0; k < 16 ; k++) {
                    if (nombre[k] == 0 ){
                 jButtons[i][j].setBackground(Color.white);
                }
                    if (nombre[k] == 1){
                        jButtons[i][j].setBackground(Color.YELLOW);
                    }
                    if (nombre[k] == 2){
                        jButtons[i][j].setBackground(Color.blue);

                    }
                    if (nombre[k] == 3){
                        jButtons[i][j].setBackground(Color.GREEN);

                    }

                }



            }
        }

