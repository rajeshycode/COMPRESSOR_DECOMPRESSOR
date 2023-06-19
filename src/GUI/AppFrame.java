package GUI;

import javax.swing.JOptionPane;
import comp_decomp.Compressor;
import comp_decomp.Decompressor;
import java.io.File;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.blue);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50)); // Set FlowLayout with center alignment and spacing

        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setSize(200, 100); // Double the height of the button

        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setSize(200, 100);

        this.add(compressButton);
        this.add(decompressButton);

        this.setSize(300, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                System.out.print(file);
                try {
                    Compressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Compression error: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
