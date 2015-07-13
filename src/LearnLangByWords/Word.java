package LearnLangByWords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Davlatbek Isroilo
 *         Innopolis University
 *         Summer School 2015
 */

public class Word
{
    String englishWord;
    List<String> russianWord;
    byte rating = 0;

    public Word()
    {
        russianWord = new ArrayList<>();
    }

    public Word (String engWord, String translationToRussian, byte Rating)
    {
        englishWord = engWord;
        russianWord.add(translationToRussian);
        rating = Rating;
    }

    public String getEnglishWord()
    {
        return this.englishWord;
    }

    public String setEnglishWord(String engWord)
    {
        return this.englishWord = engWord;
    }

    public void FillWordData(String engWord, String translationToRussian, byte Rating)
    {
        englishWord = engWord;
        russianWord.add(translationToRussian);
        rating = Rating;
    }
}
