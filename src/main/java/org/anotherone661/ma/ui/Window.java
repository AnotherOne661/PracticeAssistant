package org.anotherone661.ma.ui;
import org.anotherone661.ma.Settings;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private JPanel panel;
    private JLabel label;
    private ImageIcon background;
    private JLabel bglabel;
    Window(){
     this(Settings.TITLE, Settings.WIDTH, Settings.HEIGHT, Settings.WINDOW_RESIZABLE, Settings.ALWAYS_ON_TOP, Settings.ICON_PATH);
    }


    public Window(String title, int width, int height, boolean windowResizable, boolean alwaysOnTop, String iconPath) {
        setTitle(title);
        setSize(width, height);
        setPreferredSize(Settings.WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(windowResizable);
        setAlwaysOnTop(alwaysOnTop);
        setLocationRelativeTo(null);
        init();
        setUpUI();
        pack();
        loadIcon(iconPath);
        setLocationRelativeTo(null);
    }
    private void loadIcon(String path) {
        Image icon = new ImageIcon(Window.class.getResource(path)).getImage();
        setIconImage(icon);
    }
    protected void init() {
        // Override this method to initialize the window
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Paint the background image
                Image background = new ImageIcon(Window.class.getResource(Settings.BG_PATH)).getImage();
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        label = new JLabel("Hello World!");
    }



    protected void setUpUI() {
        panel.setLayout(new BorderLayout());

        // set label in the center of the window
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        panel.add(label, BorderLayout.CENTER);
        add(panel);
    }

}
