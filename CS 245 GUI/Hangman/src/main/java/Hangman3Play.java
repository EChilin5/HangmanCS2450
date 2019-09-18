/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Edgar Chilin and Natalie

//import static java.awt.SystemColor.text;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author edgarchilin
 */
public class Hangman3Play extends javax.swing.JFrame {

    int index = 0;
    int count = 0;
    int Score = 100;
    String text1 = "";
    String name = "";

    /**
     * Creates new form Hangman3Play
     */
    public Hangman3Play() {
        initComponents();
        resetButtons();
        text1 = //GetWord();
                "nurse";
        clock();
        Display();
        SetName();
    }

    private void SetName() {
        name = JOptionPane.showInputDialog("Enter Your Name");
        EnterName.setText("WELCOME " + name);

    }

    private String GetName() {
        return name;
    }

    private void ClearDisplay() {
        Nurse.setVisible(false);
        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
        n4.setVisible(false);
        n5.setVisible(false);

        CLIMBING.setVisible(false);
        CL1.setVisible(false);
        CL2.setVisible(false);
        CL3.setVisible(false);
        CL4.setVisible(false);
        CL5.setVisible(false);
        CL8.setVisible(false);
        CL7.setVisible(false);
        CL6.setVisible(false);

        PHARMACY.setVisible(false);
        PH1.setVisible(false);
        PH2.setVisible(false);
        PH3.setVisible(false);
        PH4.setVisible(false);
        PH5.setVisible(false);
        PH6.setVisible(false);
        PH7.setVisible(false);
        PH8.setVisible(false);
        CEMETERY.setVisible(false);
        C5.setVisible(false);
        C1.setVisible(false);
        C2.setVisible(false);
        C3.setVisible(false);
        C4.setVisible(false);
        C8.setVisible(false);
        C7.setVisible(false);
        C6.setVisible(false);
        ABSTRACT.setVisible(false);
        AB1.setVisible(false);
        AB2.setVisible(false);
        AB3.setVisible(false);
        AB4.setVisible(false);
        AB5.setVisible(false);
        AB6.setVisible(false);
        AB7.setVisible(false);
        AB8.setVisible(false);

    }

    private void Display() {
        ClearDisplay();
        if (text1.equals("nurse")) {
            Nurse.setVisible(true);
            n1.setVisible(true);
            n2.setVisible(true);
            n3.setVisible(true);
            n4.setVisible(true);
            n5.setVisible(true);
        } else if (text1.equals("climbing")) {
            CLIMBING.setVisible(true);
            CL1.setVisible(true);
            CL2.setVisible(true);
            CL3.setVisible(true);
            CL4.setVisible(true);
            CL5.setVisible(true);
            CL8.setVisible(true);
            CL7.setVisible(true);
            CL6.setVisible(true);

        } else if (text1.equals("pharmacy")) {
            PHARMACY.setVisible(true);
            PH1.setVisible(true);
            PH2.setVisible(true);
            PH3.setVisible(true);
            PH4.setVisible(true);
            PH5.setVisible(true);
            PH6.setVisible(true);
            PH7.setVisible(true);
            PH8.setVisible(true);
        } else if (text1.equals("cemetery")) {
            CEMETERY.setVisible(true);
            C5.setVisible(true);
            C1.setVisible(true);
            C2.setVisible(true);
            C3.setVisible(true);
            C4.setVisible(true);
            C8.setVisible(true);
            C7.setVisible(true);
            C6.setVisible(true);

        } else if (text1.equals("abstract")) {
            ABSTRACT.setVisible(true);
            AB1.setVisible(true);
            AB2.setVisible(true);
            AB3.setVisible(true);
            AB4.setVisible(true);
            AB5.setVisible(true);
            AB6.setVisible(true);
            AB7.setVisible(true);
            AB8.setVisible(true);
        }
    }

    private void resetButtons() {
        a.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
        E.setEnabled(true);
        F.setEnabled(true);
        G.setEnabled(true);
        H.setEnabled(true);
        I.setEnabled(true);
        J.setEnabled(true);
        K.setEnabled(true);
        L.setEnabled(true);
        M.setEnabled(true);
        N.setEnabled(true);
        O.setEnabled(true);
        P.setEnabled(true);
        Q.setEnabled(true);
        R.setEnabled(true);
        S.setEnabled(true);
        T.setEnabled(true);
        U.setEnabled(true);
        V.setEnabled(true);
        W.setEnabled(true);
        X.setEnabled(true);
        Y.setEnabled(true);
        Z.setEnabled(true);
        Frame1.setVisible(true);
        Frame2.setVisible(false);
        Frame3.setVisible(false);
        Frame4.setVisible(false);
        Frame5.setVisible(false);
        Frame6.setVisible(false);
        Frame7.setVisible(false);
        Frame8.setVisible(false);

        //jPanel3.setEnabled(true);
        Wrong.setVisible(false);
        correct.setVisible(false);
        ScoreCount.setText("100");
    }

    private void clock() {
        Thread th = new Thread() {
            public void run() {
                try {
                    for (;;) {
                        Calendar c1 = new GregorianCalendar();
                        int second = c1.get(Calendar.SECOND);
                        int min = c1.get(Calendar.MINUTE);
                        int hour = c1.get(Calendar.HOUR);
                        int am_pm = c1.get(Calendar.AM_PM);
                        String set = "";
                        if (am_pm == 1) {
                            set = "pm";
                        } else if (am_pm == 2) {
                            set = "am";
                        }

                        TimeLabel.setText(hour + ":" + min + ":" + second + " " + set);
                        sleep(1000);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        th.start();
    }

    private String GetWord() {
        String[] guess = new String[5];
        guess[0] = "nurse";
        guess[1] = "cemetery";
        guess[2] = "abstract";
        guess[3] = "pharmacy";
        guess[4] = "climbing";
        Random random = new Random();
        int number = random.nextInt(5);
        return guess[number];
    }

    private void VerifySelection(String choice) {

        //   JOptionPane.showMessageDialog(null, text1);
        boolean sol = true;
       // JOptionPane.showMessageDialog(null, count);

        if ("nurse".equals(text1)) {
                            JOptionPane.showMessageDialog(null, "true");

            if ("nurse".contains(choice)) {
                Nurse.setVisible(true);
            } else if ("n".contains(choice)) {
                JOptionPane.showMessageDialog(null, "true");
                n1.setVisible(false);
                Wrong.setVisible(false);
                correct.setVisible(true);
                n1.setVisible(false);
                count += 1;
            } else if ("u".contains(choice)) {
                                JOptionPane.showMessageDialog(null, "true");

                Wrong.setVisible(false);
                correct.setVisible(true);
                n2.setVisible(false);
                count += 1;
            } else if ("r".contains(choice)) {
                                JOptionPane.showMessageDialog(null, "true");

                Wrong.setVisible(false);
                correct.setVisible(true);
                n3.setVisible(false);
                count += 1;
            } else if ("s".contains(choice)) {
                                JOptionPane.showMessageDialog(null, "true");

                Wrong.setVisible(false);
                correct.setVisible(true);
                n4.setVisible(false);
                count += 1;
            } else if ("e".contains(choice)) {
                                JOptionPane.showMessageDialog(null, "true");

                Wrong.setVisible(false);
                
                correct.setVisible(true);
                n5.setVisible(false);
                count += 1;
            } else {
                Wrong.setVisible(true);
                correct.setVisible(false);
                sol = false;
            }

            if (count == 5) {
                JOptionPane.showMessageDialog(null, "You win");
                End();

            }

        } else if ("cemetery".equals(text1)) {
            CEMETERY.setVisible(true);
            if ("c".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                C1.setVisible(false);
            } else if ("e".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                C2.setVisible(false);
                C4.setVisible(false);
                C6.setVisible(false);
            } else if ("m".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                C3.setVisible(false);
            } else if ("t".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                C5.setVisible(false);
            } else if ("r".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                C7.setVisible(false);
            } else if ("y".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                C8.setVisible(false);
            } else {
                Wrong.setVisible(true);
                correct.setVisible(false);
                sol = false;
            }

            if (count == 6) {
                JOptionPane.showMessageDialog(null, "You win");
                End();

            }

        } else if ("abstract".equals(text1)) {
            ABSTRACT.setVisible(true);
            Wrong.setVisible(false);
            correct.setVisible(true);
            if ("a".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                AB1.setVisible(false);
                AB6.setVisible(false);
                count += 1;
            } else if ("b".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                AB2.setVisible(false);

                count += 1;
            } else if ("s".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                AB3.setVisible(false);
                count += 1;
            } else if ("t".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                AB4.setVisible(false);
                AB8.setVisible(false);
                count += 1;
            } else if ("r".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                AB5.setVisible(false);
                count += 1;
            } else if ("c".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                count += 1;
                AB7.setVisible(false);
            } else {
                Wrong.setVisible(true);
                correct.setVisible(false);
                sol = false;
            }

            if (count == 6) {
                JOptionPane.showMessageDialog(null, "You win");
                End();

            }

        } else if ("pharmacy".contains(text1)) {
            PHARMACY.setVisible(true);
            if ("p".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH1.setVisible(false);
                count += 1;
            } else if ("h".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH2.setVisible(false);
                count += 1;
            } else if ("a".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH3.setVisible(false);
                PH6.setVisible(false);
                count += 1;
            } else if ("r".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH4.setVisible(false);
                count += 1;
            } else if ("m".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH5.setVisible(false);
                count += 1;
            } else if ("c".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH7.setVisible(false);
                count += 1;
            } else if ("y".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                PH8.setVisible(false);
                count += 1;
            } else {
                Wrong.setVisible(true);
                correct.setVisible(false);
                sol = false;
            }

            if (count == 7) {
                JOptionPane.showMessageDialog(null, "You win");
                End();

            }

        } else if ("climbing".equals(text1)) {
            if ("c".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL1.setVisible(false);
                count += 1;
            } else if ("l".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL2.setVisible(false);
                count += 1;
            } else if ("i".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL3.setVisible(false);
                CL6.setVisible(false);
                count += 1;
            } else if ("m".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL4.setVisible(false);
                count += 1;
            } else if ("b".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL5.setVisible(false);
                count += 1;
            } else if ("n".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL7.setVisible(false);
                count += 1;
            } else if ("g".contains(choice)) {
                Wrong.setVisible(false);
                correct.setVisible(true);
                CL8.setVisible(false);
                count += 1;
            } else {
                Wrong.setVisible(true);
                correct.setVisible(false);
                sol = false;
            }

            if (count == 7) {
                JOptionPane.showMessageDialog(null, "You win");
                End();

            }

        }
        if (sol == false) {
            Score -= 10;
            int point = Score;
            switch (point) {
                case 90:
                    ClearImage();
                    Frame2.setVisible(true);
                    ScoreCount.setText("90");
                    break;
                case 80:
                    ClearImage();
                    Frame3.setVisible(true);
                    ScoreCount.setText("80");
                    break;
                case 70:
                    ClearImage();
                    Frame4.setVisible(true);
                    ScoreCount.setText("70");
                    break;
                case 60:
                    ClearImage();
                    Frame5.setVisible(true);
                    ScoreCount.setText("60");
                    break;
                case 50:
                    ClearImage();
                    Frame6.setVisible(true);
                    ScoreCount.setText("50");
                    break;
                case 40:
                    ClearImage();
                    Frame7.setVisible(true);
                    ScoreCount.setText("40");
                    break;
                case 30:
                    ClearImage();
                    Frame8.setVisible(true);
                    ScoreCount.setText("30");
                    break;
                default:
                    break;
            }
        }
        index++;
        if (Score <= 30) {
            Score = 0;
            End();
        }

    }

    private void End() {
        Hangman3Play h3 = new Hangman3Play();
        h3.setVisible(false);
        h3.dispose();

        Hangman4GameOver h4 = new Hangman4GameOver();
        h4.setVisible(true);
    }

    public int GetScore() {
        return Score;
    }

    private void ClearImage() {
        Frame1.setVisible(false);
        Frame2.setVisible(false);
        Frame3.setVisible(false);
        Frame4.setVisible(false);
        Frame5.setVisible(false);
        Frame6.setVisible(false);
        Frame7.setVisible(false);
        Frame8.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Frame6 = new javax.swing.JLabel();
        a = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        E = new javax.swing.JButton();
        F = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        I = new javax.swing.JButton();
        J = new javax.swing.JButton();
        L = new javax.swing.JButton();
        M = new javax.swing.JButton();
        K = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        N = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        O = new javax.swing.JButton();
        X = new javax.swing.JButton();
        P = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        R = new javax.swing.JButton();
        S = new javax.swing.JButton();
        T = new javax.swing.JButton();
        U = new javax.swing.JButton();
        V = new javax.swing.JButton();
        W = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Wrong = new javax.swing.JLabel();
        correct = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Frame1 = new javax.swing.JLabel();
        Frame2 = new javax.swing.JLabel();
        Frame3 = new javax.swing.JLabel();
        Frame4 = new javax.swing.JLabel();
        Frame5 = new javax.swing.JLabel();
        Frame7 = new javax.swing.JLabel();
        Frame8 = new javax.swing.JLabel();
        ScoreCount = new javax.swing.JLabel();
        NursePanel = new javax.swing.JPanel();
        n1 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        n4 = new javax.swing.JLabel();
        n5 = new javax.swing.JLabel();
        Nurse = new javax.swing.JLabel();
        CL1 = new javax.swing.JLabel();
        CL2 = new javax.swing.JLabel();
        CL3 = new javax.swing.JLabel();
        CL4 = new javax.swing.JLabel();
        CL5 = new javax.swing.JLabel();
        CL6 = new javax.swing.JLabel();
        CL7 = new javax.swing.JLabel();
        CL8 = new javax.swing.JLabel();
        CLIMBING = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        C4 = new javax.swing.JLabel();
        C5 = new javax.swing.JLabel();
        C6 = new javax.swing.JLabel();
        C7 = new javax.swing.JLabel();
        C8 = new javax.swing.JLabel();
        CEMETERY = new javax.swing.JLabel();
        AB1 = new javax.swing.JLabel();
        AB2 = new javax.swing.JLabel();
        AB3 = new javax.swing.JLabel();
        AB4 = new javax.swing.JLabel();
        AB5 = new javax.swing.JLabel();
        AB6 = new javax.swing.JLabel();
        AB7 = new javax.swing.JLabel();
        AB8 = new javax.swing.JLabel();
        ABSTRACT = new javax.swing.JLabel();
        PH1 = new javax.swing.JLabel();
        PH2 = new javax.swing.JLabel();
        PH3 = new javax.swing.JLabel();
        PH4 = new javax.swing.JLabel();
        PH5 = new javax.swing.JLabel();
        PH6 = new javax.swing.JLabel();
        PH7 = new javax.swing.JLabel();
        PH8 = new javax.swing.JLabel();
        PHARMACY = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        EnterName = new javax.swing.JLabel();

        Frame6.setText("jLabel5");
        Frame6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        a.setText("A");
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        B.setText("b");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });

        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        D.setText("D");
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });

        E.setText("E");
        E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EActionPerformed(evt);
            }
        });

        F.setText("F");
        F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FActionPerformed(evt);
            }
        });

        G.setText("G");
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });

        H.setText("H");
        H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HActionPerformed(evt);
            }
        });

        I.setText("I");
        I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IActionPerformed(evt);
            }
        });

        J.setText("J");
        J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActionPerformed(evt);
            }
        });

        L.setText("L");
        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }
        });

        M.setText("M");
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }
        });

        K.setText("K");
        K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KActionPerformed(evt);
            }
        });

        Y.setText("Y");
        Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YActionPerformed(evt);
            }
        });

        N.setText("N");
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }
        });

        Z.setText("Z");
        Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZActionPerformed(evt);
            }
        });

        O.setText("O");
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });

        X.setText("X");
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });

        P.setText("P");
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }
        });

        Q.setText("Q");
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }
        });

        R.setText("R");
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }
        });

        S.setText("S");
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }
        });

        T.setText("T");
        T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TActionPerformed(evt);
            }
        });

        U.setText("U");
        U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UActionPerformed(evt);
            }
        });

        V.setText("V");
        V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VActionPerformed(evt);
            }
        });

        W.setText("W");
        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }
        });

        jPanel2.setLayout(null);

        Wrong.setText(" You choose poorly, minus 10 points");
        Wrong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(Wrong);
        Wrong.setBounds(90, 0, 178, 20);

        correct.setText("You choose Wisely");
        correct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(correct);
        correct.setBounds(90, 0, 99, 20);

        jLabel2.setText("Score");

        jPanel1.setLayout(null);

        Frame1.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/HangmanFrame.PNG")); // NOI18N
        Frame1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame1);
        Frame1.setBounds(10, 0, 430, 240);

        Frame2.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/F1.PNG")); // NOI18N
        Frame2.setText("jLabel3");
        Frame2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame2);
        Frame2.setBounds(10, 0, 430, 240);

        Frame3.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/F2.PNG")); // NOI18N
        Frame3.setText("jLabel3");
        Frame3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame3);
        Frame3.setBounds(10, 0, 430, 240);

        Frame4.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/F3.PNG")); // NOI18N
        Frame4.setText("jLabel3");
        Frame4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame4);
        Frame4.setBounds(10, 0, 430, 240);

        Frame5.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/F4.PNG")); // NOI18N
        Frame5.setText("jLabel3");
        Frame5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame5);
        Frame5.setBounds(10, 0, 430, 240);

        Frame7.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/F5.PNG")); // NOI18N
        Frame7.setText("jLabel3");
        Frame7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame7);
        Frame7.setBounds(10, 0, 430, 240);

        Frame8.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/F6.PNG")); // NOI18N
        Frame8.setText("jLabel3");
        Frame8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(Frame8);
        Frame8.setBounds(10, 0, 430, 240);

        ScoreCount.setText("100");

        NursePanel.setLayout(null);

        n1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        n1.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        n1.setToolTipText("");
        n1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(n1);
        n1.setBounds(40, 10, 30, 60);

        n2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        n2.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        n2.setText("__");
        n2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(n2);
        n2.setBounds(70, 10, 30, 60);

        n3.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        n3.setText("__");
        n3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(n3);
        n3.setBounds(100, 10, 30, 60);

        n4.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        n4.setText("__");
        n4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(n4);
        n4.setBounds(130, 10, 30, 60);

        n5.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        n5.setText("__");
        n5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(n5);
        n5.setBounds(160, 10, 30, 60);

        Nurse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nurse.setText("N   U   R   S   E");
        Nurse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(Nurse);
        Nurse.setBounds(50, 30, 140, 30);

        CL1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CL1.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL1.setToolTipText("");
        CL1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL1);
        CL1.setBounds(10, 10, 30, 60);

        CL2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        CL2.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL2.setText("__");
        CL2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL2);
        CL2.setBounds(40, 10, 30, 60);

        CL3.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL3.setText("__");
        CL3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL3);
        CL3.setBounds(70, 10, 30, 60);

        CL4.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL4.setText("__");
        CL4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL4);
        CL4.setBounds(100, 10, 30, 60);

        CL5.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL5.setText("__");
        CL5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL5);
        CL5.setBounds(130, 10, 30, 60);

        CL6.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL6.setText("__");
        CL6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL6);
        CL6.setBounds(160, 10, 30, 60);

        CL7.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL7.setText("__");
        CL7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL7);
        CL7.setBounds(190, 10, 30, 60);

        CL8.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        CL8.setText("__");
        CL8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(CL8);
        CL8.setBounds(220, 10, 30, 60);

        CLIMBING.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        CLIMBING.setText("C   L   I   M   B    I   N   G");
        NursePanel.add(CLIMBING);
        CLIMBING.setBounds(20, 20, 230, 40);

        C1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        C1.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C1.setToolTipText("");
        C1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C1);
        C1.setBounds(10, 10, 30, 60);

        C2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        C2.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C2.setText("__");
        C2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C2);
        C2.setBounds(40, 10, 30, 60);

        C3.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C3.setText("__");
        C3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C3);
        C3.setBounds(70, 10, 30, 60);

        C4.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C4.setText("__");
        C4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C4);
        C4.setBounds(100, 10, 30, 60);

        C5.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C5.setText("__");
        C5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C5);
        C5.setBounds(130, 10, 30, 60);

        C6.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C6.setText("__");
        C6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C6);
        C6.setBounds(160, 10, 30, 60);

        C7.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C7.setText("__");
        C7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C7);
        C7.setBounds(190, 10, 30, 60);

        C8.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        C8.setText("__");
        C8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(C8);
        C8.setBounds(220, 10, 30, 60);

        CEMETERY.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        CEMETERY.setText("C   E   M   E   T   E   R   Y");
        NursePanel.add(CEMETERY);
        CEMETERY.setBounds(20, 20, 230, 50);

        AB1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        AB1.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB1.setToolTipText("");
        AB1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB1);
        AB1.setBounds(10, 10, 30, 60);

        AB2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        AB2.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB2.setText("__");
        AB2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB2);
        AB2.setBounds(40, 10, 30, 60);

        AB3.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB3.setText("__");
        AB3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB3);
        AB3.setBounds(70, 10, 30, 60);

        AB4.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB4.setText("__");
        AB4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB4);
        AB4.setBounds(100, 10, 30, 60);

        AB5.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB5.setText("__");
        AB5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB5);
        AB5.setBounds(130, 10, 30, 60);

        AB6.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB6.setText("__");
        AB6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB6);
        AB6.setBounds(160, 10, 30, 60);

        AB7.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB7.setText("__");
        AB7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB7);
        AB7.setBounds(190, 10, 30, 60);

        AB8.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        AB8.setText("__");
        AB8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(AB8);
        AB8.setBounds(220, 10, 30, 60);

        ABSTRACT.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        ABSTRACT.setText("A   B   S   T   R   A   C   T");
        NursePanel.add(ABSTRACT);
        ABSTRACT.setBounds(20, 20, 230, 50);

        PH1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        PH1.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH1.setToolTipText("");
        PH1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH1);
        PH1.setBounds(10, 10, 30, 60);

        PH2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        PH2.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH2.setText("__");
        PH2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH2);
        PH2.setBounds(40, 10, 30, 60);

        PH3.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH3.setText("__");
        PH3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH3);
        PH3.setBounds(70, 10, 30, 60);

        PH4.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH4.setText("__");
        PH4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH4);
        PH4.setBounds(100, 10, 30, 60);

        PH5.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH5.setText("__");
        PH5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH5);
        PH5.setBounds(130, 10, 30, 60);

        PH6.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH6.setText("__");
        PH6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH6);
        PH6.setBounds(160, 10, 30, 60);

        PH7.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH7.setText("__");
        PH7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH7);
        PH7.setBounds(190, 10, 30, 60);

        PH8.setIcon(new javax.swing.ImageIcon("/Users/edgarchilin/Desktop/CS 245 GUI/Hangman/photos/hangmanBlank.PNG")); // NOI18N
        PH8.setText("__");
        PH8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NursePanel.add(PH8);
        PH8.setBounds(220, 10, 30, 60);

        PHARMACY.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        PHARMACY.setText("P   H   A   R   M   A   C   Y");
        NursePanel.add(PHARMACY);
        PHARMACY.setBounds(20, 20, 240, 50);

        TimeLabel.setText("jLabel3");

        jButton1.setText("Skip");
        jButton1.setActionCommand("buttonSkip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        EnterName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NursePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(F, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(J, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ScoreCount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(EnterName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EnterName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ScoreCount)))
                    .addComponent(TimeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NursePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a)
                    .addComponent(B)
                    .addComponent(C)
                    .addComponent(D)
                    .addComponent(E)
                    .addComponent(F)
                    .addComponent(G)
                    .addComponent(H)
                    .addComponent(I)
                    .addComponent(J)
                    .addComponent(L)
                    .addComponent(M)
                    .addComponent(K))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(N)
                    .addComponent(O)
                    .addComponent(P)
                    .addComponent(Q)
                    .addComponent(R)
                    .addComponent(S)
                    .addComponent(T)
                    .addComponent(U)
                    .addComponent(V)
                    .addComponent(W)
                    .addComponent(Y)
                    .addComponent(Z)
                    .addComponent(X))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
        String text = "a";
        VerifySelection(text);
        a.setEnabled(false);

    }//GEN-LAST:event_aActionPerformed

    private void NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NActionPerformed
        String text = "n";
        VerifySelection(text);
        N.setEnabled(false);

    }//GEN-LAST:event_NActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        String text = "c";
        VerifySelection(text);
        C.setEnabled(false);

    }//GEN-LAST:event_CActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing


    }//GEN-LAST:event_formWindowClosing

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        String text = "b";
        VerifySelection(text);
        B.setEnabled(false);

    }//GEN-LAST:event_BActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
        String text = "d";
        VerifySelection(text);
        D.setEnabled(false);

    }//GEN-LAST:event_DActionPerformed

    private void EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EActionPerformed
        String text = "e";
        VerifySelection(text);
        E.setEnabled(false);

    }//GEN-LAST:event_EActionPerformed

    private void FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FActionPerformed
        String text = "f";
        VerifySelection(text);
        F.setEnabled(false);


    }//GEN-LAST:event_FActionPerformed

    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        String text = "g";
         VerifySelection(text);
        G.setEnabled(false);

    }//GEN-LAST:event_GActionPerformed

    private void HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HActionPerformed
        String text = "h";
        VerifySelection(text);

        H.setEnabled(false);

    }//GEN-LAST:event_HActionPerformed

    private void IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IActionPerformed
        String text = "i";
        I.setEnabled(false);
        VerifySelection(text);
    }//GEN-LAST:event_IActionPerformed

    private void JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JActionPerformed
        String text = "j";
        VerifySelection(text);
        J.setEnabled(false);

    }//GEN-LAST:event_JActionPerformed

    private void KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KActionPerformed
        String text = "k";
        VerifySelection(text);
        K.setEnabled(false);

    }//GEN-LAST:event_KActionPerformed

    private void LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LActionPerformed
        String text = "l";
        VerifySelection(text);
        L.setEnabled(false);

    }//GEN-LAST:event_LActionPerformed

    private void MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MActionPerformed
        String text = "m";
        VerifySelection(text);
        M.setEnabled(false);

    }//GEN-LAST:event_MActionPerformed

    private void OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OActionPerformed
        String text = "o";
        VerifySelection(text);
        O.setEnabled(false);

    }//GEN-LAST:event_OActionPerformed

    private void PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PActionPerformed
        String text = "p";
        VerifySelection(text);
        P.setEnabled(false);

    }//GEN-LAST:event_PActionPerformed

    private void QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QActionPerformed
        String text = "q";
        VerifySelection(text);
        Q.setEnabled(false);

    }//GEN-LAST:event_QActionPerformed

    private void RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RActionPerformed
        String text = "r";
        VerifySelection(text);
        R.setEnabled(false);

    }//GEN-LAST:event_RActionPerformed

    private void SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SActionPerformed
        String text = "s";
        VerifySelection(text);
        S.setEnabled(false);

    }//GEN-LAST:event_SActionPerformed

    private void TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TActionPerformed
        String text = "t";
        VerifySelection(text);
        T.setEnabled(false);

    }//GEN-LAST:event_TActionPerformed

    private void UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UActionPerformed
        String text = "u";
        U.setEnabled(false);
        VerifySelection(text);
    }//GEN-LAST:event_UActionPerformed

    private void VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VActionPerformed
        String text = "v";
        VerifySelection(text);
        V.setEnabled(false);

    }//GEN-LAST:event_VActionPerformed

    private void WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WActionPerformed
        String text = "w";
        VerifySelection(text);

        W.setEnabled(false);

    }//GEN-LAST:event_WActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        String text = "x";
        VerifySelection(text);
        X.setEnabled(false);
    }//GEN-LAST:event_XActionPerformed

    private void YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YActionPerformed
        String text = "y";
        Y.setEnabled(false);
        VerifySelection(text);
    }//GEN-LAST:event_YActionPerformed

    private void ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZActionPerformed
        String text = "z";
        VerifySelection(text);
        Z.setEnabled(false);
    }//GEN-LAST:event_ZActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ClearDisplay();
        switch (text1) {
            case "nurse":
                Nurse.setVisible(true);
                break;
            case "climbing":
                CLIMBING.setVisible(true);
                break;
            case "pharmacy":
                PHARMACY.setVisible(true);
                break;
            case "cemetery":
                CEMETERY.setVisible(true);
                break;
            case "abstract":
                ABSTRACT.setVisible(true);
                break;
            default:
                break;
        }
        Score = 0;
        ScoreCount.setText("0");
     
        End();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hangman3Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hangman3Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hangman3Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hangman3Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hangman3Play().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AB1;
    private javax.swing.JLabel AB2;
    private javax.swing.JLabel AB3;
    private javax.swing.JLabel AB4;
    private javax.swing.JLabel AB5;
    private javax.swing.JLabel AB6;
    private javax.swing.JLabel AB7;
    private javax.swing.JLabel AB8;
    private javax.swing.JLabel ABSTRACT;
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JLabel C1;
    private javax.swing.JLabel C2;
    private javax.swing.JLabel C3;
    private javax.swing.JLabel C4;
    private javax.swing.JLabel C5;
    private javax.swing.JLabel C6;
    private javax.swing.JLabel C7;
    private javax.swing.JLabel C8;
    private javax.swing.JLabel CEMETERY;
    private javax.swing.JLabel CL1;
    private javax.swing.JLabel CL2;
    private javax.swing.JLabel CL3;
    private javax.swing.JLabel CL4;
    private javax.swing.JLabel CL5;
    private javax.swing.JLabel CL6;
    private javax.swing.JLabel CL7;
    private javax.swing.JLabel CL8;
    private javax.swing.JLabel CLIMBING;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JLabel EnterName;
    private javax.swing.JButton F;
    private javax.swing.JLabel Frame1;
    private javax.swing.JLabel Frame2;
    private javax.swing.JLabel Frame3;
    private javax.swing.JLabel Frame4;
    private javax.swing.JLabel Frame5;
    private javax.swing.JLabel Frame6;
    private javax.swing.JLabel Frame7;
    private javax.swing.JLabel Frame8;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JLabel Nurse;
    private javax.swing.JPanel NursePanel;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JLabel PH1;
    private javax.swing.JLabel PH2;
    private javax.swing.JLabel PH3;
    private javax.swing.JLabel PH4;
    private javax.swing.JLabel PH5;
    private javax.swing.JLabel PH6;
    private javax.swing.JLabel PH7;
    private javax.swing.JLabel PH8;
    private javax.swing.JLabel PHARMACY;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JLabel ScoreCount;
    private javax.swing.JButton T;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JButton W;
    private javax.swing.JLabel Wrong;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    private javax.swing.JButton a;
    private javax.swing.JLabel correct;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel n5;
    // End of variables declaration//GEN-END:variables
}
