import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class WordsInFilesTest {

    @Test
    void tester() {
        WordsInFiles wf = new WordsInFiles();
        wf.buildWordFileMap();

        int max = wf.maxNumber();
        System.out.println("maximum number of files any word is in = "+max);

        ArrayList<String> maxWords = wf.wordsInNumFiles(max);
        for (String word : maxWords)
            wf.printFilesIn(word);

        wf.showMap();
    }

    @Test
    void wordsInNumFiles() {
        WordsInFiles wf = new WordsInFiles();
        wf.buildWordFileMap();

        ArrayList<String> neg = wf.wordsInNumFiles(-1);
        assertTrue(neg.size() == 0, "negative number");
        ArrayList<String> zero = wf.wordsInNumFiles(0);
        assertTrue(zero.size() == 0, "zero case");
        ArrayList<String> three = wf.wordsInNumFiles(3);
        assertTrue(three.size() == 2, "three case");
        assertTrue(three.contains("cats") && three.contains("and"), "three content");
        ArrayList<String> two = wf.wordsInNumFiles(2);
        assertTrue(two.size() == 3, "two case");
        assertTrue(two.contains("love") && two.contains("are") && two.contains("dogs"), "two content");
    }

    @Test
    void maxNumber() {
        WordsInFiles wf = new WordsInFiles();

        // Before words loaded, should get -1 back.
        assertTrue(wf.maxNumber() == -1, "no words loaded is -1");

        // Load
        wf.buildWordFileMap();

        // With our 4 test files, maxNumber() should be 3.
        assertTrue(wf.maxNumber() == 3, "loaded 4 brief files");
    }

    @Test
    void printFilesIn() {
        WordsInFiles wf = new WordsInFiles();
        wf.buildWordFileMap();

        // null and empty don't cause a crash.
        wf.printFilesIn(null);
        wf.printFilesIn("");

        // word not in the file does not crash, prints message.
        System.out.println("expect bccfgh not found");
        wf.printFilesIn("bccfgh");

        // cat appears in 3 files.
        System.out.println("expect cats in brief1, brief3 and brief4");
        wf.printFilesIn("cats");
    }

    @Test
    void practiceQuiz() {
        WordsInFiles wf = new WordsInFiles();
        wf.buildWordFileMap(); // select the 5 Shakespeare files interactively
        ArrayList<String> five = wf.wordsInNumFiles(5);
        System.out.println("Q4.  "+ five.size());
        ArrayList<String> four = wf.wordsInNumFiles(4);
        System.out.println("Q5.  "+four.size());
        System.out.println("Q6.  Answer is the file NOT listed");
        wf.printFilesIn("sad");
        System.out.println("Q7.  Answer is the list of these files");
        wf.printFilesIn("red");
    }

    @Test
    void finalQuiz() {
        WordsInFiles wf = new WordsInFiles();
        wf.buildWordFileMap();  // select caesar.txt, confucius.txt, errors.txt, hamlet.txt, likeit.txt, macbeth.txt and romeo.txt.

        ArrayList<String> seven = wf.wordsInNumFiles(7);
        System.out.println("Q12. "+seven.size());

        ArrayList<String> four = wf.wordsInNumFiles(4);
        System.out.println("Q13. "+four.size());

        System.out.println("Q14 answer is where 'sea' does not appear");
        wf.printFilesIn("sea");

        System.out.println("Q15 answer is all these files");
        wf.printFilesIn("tree");
    }

}