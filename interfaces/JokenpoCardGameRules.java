package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JokenpoCardGameRules extends JFrame {
    private JTextArea rulesTextArea;
    private JButton backButton;

    public JokenpoCardGameRules(JFrame mainFrame) {
        super("Regras do Jogo");
        setLayout(new BorderLayout());
        setSize(500, 500);

        rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setText("JOKENPO CARD GAME\n\n" +
        "O jogo Jokenpo Card Game é uma variação do clássico jogo Pedra-Papel-Tesoura. \n" +

        "\nRegra 1: Ao invés de escolher pedra, papel ou tesoura, os jogadores jogam cartas. \n" +
        "\nRegra 2: Após jogar uma carta ela é descartada."+
        "\nRegra 3: A ordem das cartas continuam iguais.\n\n" +
        "\n As cartas são embaralhadas e distribuídas 3 para cada jogador.\n" +
        "Cada jogador joga uma carta por rodada\n"+
        " \n Quem tiver a carta de maior valor de força " +
        "ganha a rodada. \n Em caso de empate, os jogadores jogam outra carta para desempatar.\n " +
        "O jogador que ganhar a melhor de 3 ganha os pontos da rodada.\n\n" +
        "Boa sorte e divirta-se!");
        JScrollPane scrollPane = new JScrollPane(rulesTextArea);
        add(scrollPane, BorderLayout.CENTER);

        backButton = new JButton("Voltar");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mainFrame.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
