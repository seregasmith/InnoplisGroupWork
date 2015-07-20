/**
 * @author Davlatbek Isroilo
 *         Innopolis University
 *         Summer School 2015
 */

package LearnLangByWords;

import java.util.ArrayList;
import java.util.List;

public class Word
{
    String originalWord;
    List<String> translationWord = new ArrayList<>();
    byte rating = 0;
    Integer index;

    public Word()
    {
        translationWord = new ArrayList<>();
    }

    public Word (Integer ind, String engWord, String translationToRussian, byte Rating)
    {
        //add index - key, (in Local Data: DictMap Value = Original word;
        index = ind;
        originalWord = engWord;
        translationWord.add(translationToRussian);
        rating = Rating;
    }

    public Word (Integer ind, String engWord, ArrayList<String> translationToRussian, byte Rating)
    {
        //add index - key, (in Local Data: DictMap Value = Original word;
        index = ind;
        originalWord = engWord;
        for (String s : translationToRussian)
        {
            translationWord.add(s);
        }
        rating = Rating;
    }

    public byte getRating()
    {
        return this.rating;
    }

    public void setRating(byte rating)
    {
        this.rating = rating;
    }

    public String getOriginalWord()
    {
        return this.originalWord;
    }

    public void setOriginalWord(String engWord)
    {
        this.originalWord = engWord;
    }
}
