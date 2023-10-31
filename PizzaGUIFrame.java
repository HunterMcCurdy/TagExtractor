import javafx.scene.control.Labeled;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import static java.nio.file.StandardOpenOption.CREATE;


public class PizzaGUIFrame {
    private JFrame window;
    private JTextArea displayTA = new JTextArea(20, 50);;
    private JTextArea displayTA2 = new JTextArea(20, 50);;

    public PizzaGUIFrame() {

    }


    public void initialize() {
        window = new JFrame();
        window.setTitle("Tag Extractor");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1440, 1000);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout(10, 5));
        window.setVisible(true);
    }

    public void createDisplayPanel() {
        JPanel displayPnl = new JPanel();
        JPanel text = new JPanel();
        JPanel text2 = new JPanel();

        JButton ChoseFile = new JButton("Chose a File");
        ChoseFile.setFont(new Font("Arial", Font. BOLD, 100));
        ChoseFile.addActionListener(((ActionEvent ae) -> choseFile()));

        text2.add(displayTA2);
        displayPnl.add(ChoseFile);
        text.add(displayTA);
        window.add(text2);
        window.add(displayPnl);
        window.add(text);
        window.add(text2,BorderLayout.SOUTH);
        window.add(text,BorderLayout.CENTER);
        window.add(displayPnl, BorderLayout.NORTH);



    }



    public void createImageIcon() {

    }

    public void choseFile(){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;

        try
        {
            File workingDirectorys = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectorys);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();

                Path files = selectedFile.toPath();

                BufferedInputStream InputStream = new BufferedInputStream(Files.newInputStream(files, CREATE));

                BufferedReader reader = new BufferedReader(new InputStreamReader(InputStream));

                while (reader.ready())
                {
                    // read and count the characters, words, and lines
                    rec = reader.readLine();

                    displayTA.append(rec);
                }
                reader.close();
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void clear(){

    }


    public void order(){

    }



}

