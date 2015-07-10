package LearnLangByWords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Davlatbek Isroilo
 *         Innopolis University
 *         Summer School 2015
 */

public class LocalData {

    ArrayList<String> englishWord;
    ArrayList<String> russianWord;
    ArrayList<Integer> ratingOfEngWords;
    ArrayList<Integer> ratingOfRusWords;

    public LocalData()
    {

    }

    public String getEnglishWord(String engWord)
    {
        for (String s : englishWord)
        {
            if (s.equals(engWord))
            {
                return s;
            }
        }
        return null;
    }

    protected String getRussianWord(String rusWord)
    {
        for (String s : russianWord)
        {
            if (s.equals(rusWord))
            {
                return s;
            }
        }
        return null;
    }

    protected void setEnglisWord(String engWord)
    {

    }

    protected void setRussianWord(String rusWord)
    {

    }

    protected void SortByRating()
    {

    }

    public String Search(String strToSearch)
    {
        return strToSearch;
    }
}