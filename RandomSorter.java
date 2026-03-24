import java.util.Collections;
import java.util.List;

public class RandomSorter implements CardOrganizer {
    public List<Card> organize(List<Card> cards) {
        Collections.shuffle(cards);
        return cards;
    }
}