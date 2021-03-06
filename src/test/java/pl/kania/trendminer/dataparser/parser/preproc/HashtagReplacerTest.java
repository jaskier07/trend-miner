package pl.kania.trendminer.dataparser.parser.preproc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.kania.trendminer.dataparser.parser.preproc.replacing.HashtagReplacer;

import static org.junit.jupiter.api.Assertions.*;

class HashtagReplacerTest {

    @ParameterizedTest
    @CsvSource({
            "'#BLM',blm",
            "'#iLikePizza',i like pizza",
            "'#WholeNewGame',whole new game",
//            "'#WithABrightSmile',with a bright smile",
            "'#stayathome',stayathome",
            "'#COVID-19 #goHome',covid-19 go home"
    })
    @DisplayName("Given text with hashtags replace them")
    public void givenTextContainingHashtagsThenSplitThemAndReplace(String text, String expected) {
        String newText = HashtagReplacer.replace(text);
        assertEquals(expected, newText);
    }

}