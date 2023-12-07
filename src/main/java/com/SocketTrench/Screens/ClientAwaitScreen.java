package com.SocketTrench.Screens;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.SocketTrench.GUI.GUIScreen;

public final class ClientAwaitScreen implements GUIScreen {
    private final JFrame frame;

    public ClientAwaitScreen() {
        this.frame = new JFrame();
        this.initComponents();
    }

    private void initComponents() {
        final var ipInfo = new JLabel();
        ipInfo.setPreferredSize(new Dimension(400, 50));
        ipInfo.setMaximumSize(new Dimension(400, 50));
        ipInfo.setHorizontalAlignment(JLabel.CENTER);
        ipInfo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        ipInfo.setFont(new Font("Arial", Font.PLAIN, 20));
        ipInfo.setText("INPUT THE IP");

        final var ipInput = new JTextField();
        ipInput.setPreferredSize(new Dimension(400, 50));
        ipInput.setMaximumSize(new Dimension(400, 50));
        ipInput.setMinimumSize(new Dimension(400, 50));
        ipInput.setFont(new Font("Arial", Font.PLAIN, 30));
        ipInput.setText("192.168.0.1");

        final var confirm = new JButton();
        confirm.setPreferredSize(new Dimension(400, 50));
        confirm.setMaximumSize(new Dimension(400, 50));
        confirm.setAlignmentX(JButton.CENTER_ALIGNMENT);
        confirm.setText("CONFIRM");
        confirm.setFont(new Font("Arial", 0, 20));
        // confirm.addActionListener(event -> {
        // });

        final var content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(Box.createVerticalGlue());
        content.add(ipInfo);
        content.add(Box.createVerticalGlue());
        content.add(ipInput);
        content.add(Box.createVerticalGlue());
        content.add(confirm);
        content.add(Box.createVerticalGlue());
        content.setPreferredSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));
        content.setMinimumSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));
        content.setMaximumSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));

        final var container = new JPanel(new FlowLayout());
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(Box.createHorizontalGlue());
        container.add(content);
        container.add(Box.createHorizontalGlue());
        container.setPreferredSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));

        frame.add(container);
        frame.pack();
        frame.setTitle("Client | Socket Trench");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void dispose() {
        this.frame.dispose();
    }
}
