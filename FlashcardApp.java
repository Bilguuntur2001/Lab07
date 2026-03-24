import java.io.*;
import java.util.*;

public class FlashcardApp {
    private List<Card> cards = new ArrayList<>();
    private CLIParser config;

    public FlashcardApp(CLIParser config) {
        this.config = config;
        loadCards(config.getFile());
    }

    private void loadCards(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    cards.add(new Card(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        for (Card c : cards) {
            System.out.println(c.getQuestion());
            String input = sc.nextLine();

            if (c.checkAnswer(input)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
        }
    }
}