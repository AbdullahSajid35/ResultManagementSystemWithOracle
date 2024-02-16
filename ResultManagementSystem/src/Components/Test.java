package Components;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CSV Reader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Browse CSV");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                // Set file filter to show only CSV files
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File f) {
                        return f.getName().toLowerCase().endsWith(".csv") || f.isDirectory();
                    }

                    public String getDescription() {
                        return "CSV Files (*.csv)";
                    }
                });

                // Show open dialog:
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());

                    // Read and print contents of the selected CSV file
                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(button);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
