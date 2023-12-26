package com.mauricio.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainView extends JFrame {
    private JPanel mainPanel;
    private JPanel panelSideMenu;
    private JPanel panelContent;
    private JComboBox<String> certificadoChooser;
    private JPasswordField certificadoPassword;
    private JButton fileChooserBtn;
    private JFileChooser fileChooser;
    private JButton btnGerarLote;
    private JButton btnLoteRps;
    private JTextField nroLote;
    private JButton logoBtn;
    private JLabel fileChooserLabel;

    public MainView() {
        init();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            initLaF();
            MainView mainView = new MainView();
            mainView.setVisible(true);
        });
    }

    public static void initLaF() {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 200);
        UIManager.put("Component.arc", 200);
        UIManager.put("TextComponent.arc", 200);
    }

    private void init() {
        // Main panel config
        setTitle("Clara Imóveis - Gerenciamento de NF-e");
        setSize(new Dimension(1280, 720));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);

        // Side panel config
        panelSideMenu.putClientProperty(FlatClientProperties.STYLE, "arc: 30");
        btnLoteRps.putClientProperty(FlatClientProperties.STYLE,
                "hoverBackground: lighten(#303551, 15%);" +
                "pressedBackground: lighten(#303551, 10%);" +
                "selectedBackground: lighten(#303551, 10%);" +
                "selectedForeground: #FFFFFF;" +
                "font: 20;" +
                "margin: 0,0,3,0");
        logoBtn.putClientProperty(FlatClientProperties.STYLE,
                "background: #FFFFFF;" +
                "hoverBackground: #FFFFFF;" +
                "pressedBackground: #FFFFFF;" +
                "foreground: #000000;" +
                "arc: 30;");

        // Other configs
        fileChooser = new JFileChooser();
    }
}
