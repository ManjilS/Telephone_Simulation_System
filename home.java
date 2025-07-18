package telphone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class home extends JFrame {

    public home() {
        setTitle("Telephone Simulation Dashboard");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Logo panel at top
        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(Color.WHITE);
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon icon = new ImageIcon("C:\\Users\\bhade\\Downloads\\logo.png"); // Your logo path
        JLabel logoLabel = new JLabel(icon);
        logoPanel.add(logoLabel);

        // Center welcome + button panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel welcomeLabel = new JLabel("Welcome to Telephone Simulation System");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        welcomeLabel.setForeground(new Color(33, 37, 41));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 10, 30, 10);
        centerPanel.add(welcomeLabel, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnLostCall = new JButton("Lost Call Simulation");
        JButton btnDelayCall = new JButton("Delay Call Simulation");

        btnLostCall.setPreferredSize(new Dimension(200, 40));
        btnDelayCall.setPreferredSize(new Dimension(200, 40));

        btnLostCall.setBackground(new Color(52, 152, 219));
        btnLostCall.setForeground(Color.WHITE);
        btnLostCall.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnDelayCall.setBackground(new Color(231, 76, 60));
        btnDelayCall.setForeground(Color.WHITE);
        btnDelayCall.setFont(new Font("Segoe UI", Font.BOLD, 14));

        buttonPanel.add(btnLostCall);
        buttonPanel.add(btnDelayCall);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 20, 10);
        centerPanel.add(buttonPanel, gbc);

        // Developer credit at bottom
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        JLabel footerLabel = new JLabel("Developed by Ayush Dev (022-314)");
        footerLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        footerPanel.add(footerLabel);

        // Add panels to frame
        add(logoPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Button Actions
        btnLostCall.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new TelephoneSystemSimulator());
        });

        btnDelayCall.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new DelayCallSimulator());
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(home::new);
    }
}
