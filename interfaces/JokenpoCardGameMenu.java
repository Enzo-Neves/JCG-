package interfaces;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JokenpoCardGameMenu extends JFrame {
    private JButton playButton, rulesButton, exitButton;

    public JokenpoCardGameMenu() {
        super("Jokenpo Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um JPanel com layout null
        JPanel contentPane = new JPanel(null);
        
        // Adiciona a imagem de fundo ao JLabel
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("interfaces\\imagens\\Fundo-menu.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel background = new JLabel(new ImageIcon(image));
        background.setBounds(0, 0, 600, 600);
        contentPane.add(background);

        // Adiciona os botões ao JPanel
        playButton = new JButton("");
        ImageIcon fundojogar = new ImageIcon("interfaces\\imagens\\jogar.png");
        playButton.setIcon(fundojogar);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui vai o código para abrir a tela de jogo
                JOptionPane.showMessageDialog(null, "Jogo iniciado!");
            }
        });
        playButton.setBounds(220, 200, 160, 40);
        background.add(playButton);

        rulesButton = new JButton("");
        ImageIcon fundoregras = new ImageIcon("interfaces\\imagens\\regras.png");
        rulesButton.setIcon(fundoregras);
        rulesButton.setBorderPainted(false);
        rulesButton.setContentAreaFilled(false);
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JokenpoCardGameRules rules = new JokenpoCardGameRules(JokenpoCardGameMenu.this);
            }
        });
        rulesButton.setBounds(220, 260, 160, 40);
        background.add(rulesButton);

        exitButton = new JButton("");
        ImageIcon fundosair = new ImageIcon("interfaces\\imagens\\sair.png");
        exitButton.setIcon(fundosair);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitButton.setBounds(220, 320, 160, 40);
        background.add(exitButton);

        setContentPane(contentPane);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        JokenpoCardGameMenu menu = new JokenpoCardGameMenu();
    }
}
