package LearnLangByWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Davlatbek Isroilo
 *         Innopolis University
 *         Summer School 2015
 */

public class LocalData {

    ArrayList<Word> engrusDict;

    public LocalData()
    {
        engrusDict = new ArrayList<Word>();
    }

    protected void AddWord(String engWord, String rusWord, byte rating)
    {
            engrusDict.add(new Word(engWord, rusWord, rating));
    }

    //???????? ?????? ? ????????? ??????????? ?????
    //?? ??????? ? ????????? ??? ??? ???????? ?? Word.russianWord (ArrayList<String>)
    public boolean SearchForTranslation(String translationToRussian)
    {
            for (Word word : engrusDict)
            {
                for (String s : word.russianWord)
                {
                    if (translationToRussian.equals(s.toLowerCase()))
                    {
                        return true;
                    }
                }
            }
        return false;
    }

    protected void PrintAllWords()
    {
            for (Word w : engrusDict)
            {
                System.out.println("Translations of " + w.englishWord + ":");
                for (String s : w.russianWord)
                {
                    System.out.println(s);
                }
            }
    }

    protected String SearchWord(String strToSearch, ArrayList<String> arrToSearch)
    {
        for (String s : arrToSearch)
        {
            if (strToSearch.equals(s))
            {
                return strToSearch;
            }
        }
        return null;
    }

    protected void SortByRating(ArrayList<Integer> ratingListToSort)
    {
        Comparator comparator = Collections.reverseOrder();
        Collections.sort(ratingListToSort, comparator);
    }

    /*
    public static void main(String[] args)
    {
        Word word = new Word();
        word.FillWordData("capture", "??????1", (byte)5);
        word.FillWordData("capture", "?????????2", (byte) -5);

        System.out.println(word.englishWord);
        for (String s : word.russianWord) {
            System.out.println(s);
        }
        System.out.println(word.rating);

        for (String s : word)
        {
            for (String s1:word.russianWord)
            System.out.println(s);
        }
    }
    */
}