/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbojayajaya;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class WebtoonAppGUI extends JFrame {
    private List<Webtoon<String>> webtoons;

    private JPanel mainPanel;
    private JTextArea outputTextArea;
    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTextField artistTextField;
    private JTextField genreTextField;
    private JTextArea sinopsisTextArea;
    private JComboBox<String> statusComboBox;
    private JTextField whereToReadTextField;
    private JButton addButton;

    public WebtoonAppGUI() {
        webtoons = new ArrayList<>();

        initializeComponents();
        addComponentsToPanel();
        configureMainFrame();
    }

    private void initializeComponents() {
        mainPanel = new JPanel();
        outputTextArea = new JTextArea(10, 30);
        titleTextField = new JTextField(20);
        authorTextField = new JTextField(20);
        artistTextField = new JTextField(20);
        genreTextField = new JTextField(20);
        sinopsisTextArea = new JTextArea(5, 20);
        statusComboBox = new JComboBox<>(new String[]{"Completed", "Ongoing", "Hiatus"});
        whereToReadTextField = new JTextField(20);
        addButton = new JButton("Add Webtoon");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String author = authorTextField.getText();
                String artist = artistTextField.getText();
                String genre = genreTextField.getText();
                String sinopsis = sinopsisTextArea.getText();
                String status = (String) statusComboBox.getSelectedItem();
                String whereToRead = whereToReadTextField.getText();

                Webtoon<String> webtoon = new Webtoon<>(title, author, artist, genre, sinopsis, status, whereToRead, null);
                webtoons.add(webtoon);
                displayWebtoons();
                clearInputFields();
            }
        });
    }

    private void addComponentsToPanel() {
        outputTextArea.setEditable(false); 
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Title:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(titleTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Author:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(authorTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Artist:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(artistTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Genre:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(genreTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Synopsis:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(new JScrollPane(sinopsisTextArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(statusComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(new JLabel("Where to Read:"), gbc);

        gbc.gridx = 1;
        mainPanel.add(whereToReadTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(addButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(new JScrollPane(outputTextArea), gbc);

        add(mainPanel);
    }

    private void configureMainFrame() {
        setTitle("Webtoon App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void clearInputFields() {
        titleTextField.setText("");
        authorTextField.setText("");
        artistTextField.setText("");
        genreTextField.setText("");
        sinopsisTextArea.setText("");
        statusComboBox.setSelectedIndex(0);
        whereToReadTextField.setText("");
    }

    private void displayWebtoons() {
        outputTextArea.setText("");
        for (Webtoon<String> webtoon : webtoons) {
            outputTextArea.append("Title: " + webtoon.getTitle() + "\n");
            outputTextArea.append("Author: " + webtoon.getAuthor() + "\n");
            outputTextArea.append("Artist: " + webtoon.getArtist() + "\n");
            outputTextArea.append("Genre: " + webtoon.getGenre() + "\n");
            outputTextArea.append("Sinopsis: " + webtoon.getSinopsis() + "\n");
            outputTextArea.append("Status: " + webtoon.getStatus() + "\n");
            outputTextArea.append("Where to Read: " + webtoon.getWhereToRead() + "\n");
            outputTextArea.append("\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WebtoonAppGUI();
            }
        });
    }
}
