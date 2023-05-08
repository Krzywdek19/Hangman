import org.example.Database;
import org.example.Hangman;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import java.io.BufferedReader;
import java.io.IOException;



public class JUnitTest {
    Hangman hangman;


    @Test
    public void testGuessLetterMethodWithEmptyValue() throws IOException {

        this.hangman = new Hangman(new Database("words"));


        try {
            BufferedReader reader = Mockito.mock(BufferedReader.class);
            Mockito.when(reader.readLine())
                    .thenReturn("")
                    .thenReturn("b");
            this.hangman.guessLetter(reader);
        }catch (IndexOutOfBoundsException e){
            Assertions.fail();
        }

        //no exception thrown - test passed
    }
}
