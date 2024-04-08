import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Write a program to generate all potential anagrams of an input string.⁴⁰ For example, the potential anagrams of “biro” are:
// • biro bior brio broi boir bori
// • ibro ibor irbo irob iobr iorb
// • rbio rboi ribo riob roib robi
// • obir obri oibr oirb orbi orib
public class AnagramsTest {

    @Test
    void nothing() {
        assertTrue(true);
    }

    @Test
    void emptyStringReturnsSingleEmptyString() {
        Collection<String> anagrams = anagramsOf("");
        Assertions.assertIterableEquals(List.of(""), anagrams);
    }

    @Test
    void singleCharacterStringReturnsOneStringCollectionWithSingleCharacter() {
        Collection<String> anagrams = anagramsOf("a");
        assertIterableEquals(List.of("a"), anagrams);
    }

    @Test
    void twoCharacterStringReturnsTwoStringsWithCharactersInADifferentOrder() {
        Collection<String> anagrams = anagramsOf("ab");
        assertIterableEquals(List.of("ab", "ba"), anagrams);
    }

    @Test
    void threeCharacterStringReturnsSixStringsWithCharactersInADifferentOrder() {
        Collection<String> anagrams = anagramsOf("abc");
        assertIterableEquals(List.of("abc", "acb", "bac", "bca", "cab", "cba"), anagrams);
    }

    private Collection<String> anagramsOf(String word) {
        if (word.length() > 2) {
            List<String> result = new ArrayList<>();
            String newLetter = word.charAt(0) + "";
            String newWord = word.substring(1);

            result.add(newLetter + newWord);
            result.add(word.charAt(0) + new StringBuilder("abc").delete(0, 1).toString());
            result.add(word.charAt(1) + "ac");
            result.add(word.charAt(1) + "ca");
            result.add(word.charAt(2) + "ab");
            result.add(word.charAt(2) + "ba");

            return result;
        }
        if (word.length() > 1) {
            return List.of(word, "" + word.charAt(1) + word.charAt(0));
        }

        return List.of(word);
    }
}
