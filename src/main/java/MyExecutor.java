import entities.SentenceElement;
import entities.Text;
import entities.Word;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Class created to do one specific task, which is the exec method.
 */
public class MyExecutor {
    /**
     * Finds a word in the first sentence unique to the rest of the text.
     * Throws an exception if the text is empty.
     *
     * @param text The StringBuilder text to be analyzed.
     * @return A StringBuilder containing the word unique to the first sentence. Or empty if there is no such
     */
    public static StringBuilder exec(@NotNull StringBuilder text) {
        if (text.isEmpty())
            throw new RuntimeException("Text is empty!");
        return exec(new Text(String.valueOf(text)));
    }

    /**
     * Finds a word in the first sentence unique to the rest of the text.
     * Throws an exception if the text is empty.
     *
     * @param text The Text object to be analyzed.
     * @return A StringBuilder containing the word unique to the first sentence. Or empty if there is no such
     */
    public static StringBuilder exec(@NotNull Text text) {
        Word[] wordsInFirstSentence = Arrays.stream(text.getText()[0].getSentence())
                .filter(e -> e instanceof Word)
                .map(e -> (Word) e)
                .toArray(Word[]::new);

        Word[] otherWords = Arrays.stream(text.getText())
                .skip(1)
                .flatMap(s -> Arrays.stream(s.getSentence())
                        .filter(e -> e instanceof Word))
                .map(e -> (Word) e)
                .toArray(Word[]::new);

        for (Word word : wordsInFirstSentence) {
            if (!Arrays.asList(otherWords).contains(word)) {
                return new StringBuilder(word.toString());
            }
        }
        return new StringBuilder("");
    }
}
