import java.util.ArrayList;
import java.util.List;

public class RecentMistakesFirstSorter implements CardOrganizer {

    private List<Card> mistakes = new ArrayList<>();

    public void recordMistake(Card card) {
        if (!mistakes.contains(card)) {
            mistakes.add(card);
        }
    }

    @Override
    public List<Card> organize(List<Card> cards) {
        List<Card> result = new ArrayList<>();

        for (Card c : mistakes) {
            if (cards.contains(c)) {
                result.add(c);
            }
        }

        for (Card c : cards) {
            if (!result.contains(c)) {
                result.add(c);
            }
        }

        return result;
    }
}