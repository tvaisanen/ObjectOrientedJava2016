import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {

    private JFrame mainFrame;
    private JLabel guessesLeftLabel;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JLabel wordStatusLabel;
    private JPanel controlPanel;
    final private JTextField charInput = new JTextField(6);
    final private JTextField stringInput = new JTextField(12);

    private UIController controller;

    public View(HanginMan hm) {
        startGUI(hm);

    }

    private void startGUI(HanginMan hm) {
        setupGUI();
        initEvents();
        controller = new UIController(hm);
        wordStatusLabel.setText(controller.getWordStatus());
    }

    private void setupGUI() {
        mainFrame = new JFrame("Hirsipuu");
        mainFrame.setSize(600, 300);
        mainFrame.setLayout(new GridLayout(3, 2));

        guessesLeftLabel = new JLabel("Guesses left: ", JLabel.CENTER);
        headerLabel = new JLabel("HangingMan", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        wordStatusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(100, 20);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void closingWindow(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(guessesLeftLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(wordStatusLabel);
        mainFrame.setVisible(true);
    }

    private void initEvents() {
        JButton guessButton = new JButton("Guess!");
        JButton guessWordButton = new JButton("Guess the word!");
        JButton exitButton = new JButton("Exit.");

        guessButton.setActionCommand("Guess");
        guessWordButton.setActionCommand("GuessWord");
        exitButton.setActionCommand("Exit");

        guessButton.addActionListener(new ButtonClickListener());
        guessWordButton.addActionListener(new ButtonClickListener());
        exitButton.addActionListener(new ButtonClickListener());

        controlPanel.add(charInput);
        controlPanel.add(guessButton);
        controlPanel.add(stringInput);
        controlPanel.add(guessWordButton);
        controlPanel.add(exitButton);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Guess":
                    try {
                        char chr = charInput.getText().toCharArray()[0];
                        statusLabel.setText(Character.toString(chr));
                        guessesLeftLabel.setText(controller.getGuessesLeftStatus());
                        controller.guess(chr);
                        charInput.setText("");
                    } catch (ArrayIndexOutOfBoundsException AIOBE){
                        statusLabel.setText("Insert a char!");
                        break;
                    }
                    wordStatusLabel.setText(controller.getWordStatus());
                    if (controller.wordGuessed()){
                        statusLabel.setText("You won!");
                    } else if (controller.getGuessesLeft() == 0){
                        statusLabel.setText("You lost!");
                    }
                    break;
                case "GuessWord":
                    String word = stringInput.getText();
                    statusLabel.setText(word);
                    guessesLeftLabel.setText(controller.getGuessesLeftStatus());
                    if (controller.guessWord(word)){
                        wordStatusLabel.setText(word);
                        statusLabel.setText("Right answer!");
                        controller.gameEnded();
                    }
                    stringInput.setText("");
                    if (controller.wordGuessed()){
                        statusLabel.setText("You won!");
                    } else if (controller.getGuessesLeft() == 0){
                        statusLabel.setText("You lost!");
                    }
                    break;
                case "Exit":
                    System.exit(1);
                    statusLabel.setText("Exit");
                    break;
            }
        }
    }
}
