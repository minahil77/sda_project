package sda.sda_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class weatherAppGui extends JFrame {
    private JTextField searchField;

    public weatherAppGui() {
        setTitle("Weather App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
 
        //searchbaar
        JPanel searchBar= new JPanel();
        Color searchColor= Color.decode("#FF0000");
        searchBar.setBackground(Color.decode("#41C9E2")); 
        searchBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        searchField = new JTextField(50);
        //adding margin 
        int margin = 10; 
        searchBar.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));
        searchField.setMargin(new Insets(7, 7, 7, 7));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText(); 
                JOptionPane.showMessageDialog(weatherAppGui.this, "Searching for: " + searchText);
            }
        });
        searchBar.add(searchField);
        searchBar.add(searchButton); 
        add(searchBar, BorderLayout.NORTH);

        JPanel border1 = new JPanel();
        JPanel border2 = new JPanel();
        JPanel border3= new JPanel();
        border1.setBackground(Color.decode("#DFF5FF"));
        border2.setBackground(Color.decode("#DFF5FF"));
        border3.setBackground(Color.decode("#DFF5FF"));
        border1.setPreferredSize(new Dimension(10, 10));
        border2.setPreferredSize(new Dimension(10, 10));
        border3.setPreferredSize(new Dimension(10, 10));
        add(border1, BorderLayout.EAST);
        add(border2, BorderLayout.SOUTH);
        add(border3, BorderLayout.WEST);
    }

  
    
}
