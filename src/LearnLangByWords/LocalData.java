/**
 * @author Davlatbek Isroilo
 *         Innopolis University
 *         Summer School 2015
 */

package LearnLangByWords;

import java.util.*;

public class LocalData {

    List<Word> engrusDict;
    Map<Integer, Word> dictMap;
    int i = 1;

    public LocalData()
    {
        dictMap = new HashMap<>();
        engrusDict = new ArrayList<>();
    }

    protected void addWord(Integer index, String origWord, String tranWord, byte rating)
    {
        Word w = new Word(index, origWord, tranWord, rating);
        engrusDict.add(w);
        //if (w.originalWord.equals())
        //engrusDict.add(new Word(index, origWord, tranWord, rating));
    }

    protected void addWordWithManyTransl(Integer index, String origWord, ArrayList<String> tranWord, byte rating)
    {
        for (String s : tranWord)
        {
            Word w = new Word(index, origWord, new ArrayList<>(Collections.singletonList(s)), rating);
            engrusDict.add(w);
        }
    }

    // Inserts indexes to key and Word objects to value
    public void addDictToMap()
    {
        for (Word w : engrusDict)
        {
            dictMap.put(i, w);
            i++;
        }
    }

    // Searches a map for a Word by index
    public Word searchInMapByIndex(int inputKey)
    {
        if (dictMap.containsKey(inputKey)) {
            Set<Integer> keys = dictMap.keySet();
            for (Object key : keys) {
                if ((int) key == inputKey) {
                    return dictMap.getOrDefault(inputKey, null);
                    //System.out.println(dictMap.getOrDefault(2, null).originalWord + " : " + dictMap.getOrDefault(2, null).translationWord);
                }
            }
        }
        return null;
    }

    // Print map by key-values
    public void printMap()
    {
        Set<Map.Entry<Integer, Word>> set = dictMap.entrySet();
        for (Map.Entry<Integer, Word> dict : set)
        {
            System.out.println("Key: " + dict.getKey());
            System.out.println("Value: " + dict.getValue().originalWord);
        }
    }

    public boolean searchForTranslation(String translation)
    {
        for (Word word : engrusDict)
        {
            for (String s : word.translationWord)
            {
                if (translation.equals(s.toLowerCase()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchForTranslation(String original, String translation)
    {
        for (Word word : engrusDict)
        {
            if (word.originalWord.equals(original))
            {
                for (String s : word.translationWord)
                {
                    if (s.equals(translation))
                        return true;
                }
            }
        }
        return false;
    }

    protected void printAllWords()
    {
        for (Word w : engrusDict)
        {
            System.out.println("Translations of " + w.originalWord.toUpperCase() + ":");
            for (String translation : w.translationWord)
            {
                System.out.println(translation);
            }
            System.out.println("Rating: " + w.rating);
            System.out.println();
        }
    }

    protected void sortByRating()
    {
        /*Comparator comparator = new Comparator<Word>()
        {
            public int compare(Word v1, Word v2)
            {
                return v1.rating.compareTo(v2.rating);
            }
        };
        Collections.sort(engrusDict, comparator);*/

        Comparator<Word> comparator = Collections.reverseOrder();
        Collections.sort(engrusDict, comparator);
    }

    protected String searchWord(String strToSearch, ArrayList<String> arrToSearch)
    {
        for (String s : arrToSearch)
        {
            if (strToSearch.equals(s)) {
                return strToSearch;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        LocalData ld = new LocalData();

        ld.engrusDict.add(new Word(1, "complex", new ArrayList<>(Arrays.asList("slozniy", "kompleksniy")), (byte) 3));
        ld.engrusDict.add(new Word(2, "computer", new ArrayList<>(Arrays.asList("komputer", "vichislitel")), (byte) -5));
        ld.engrusDict.add(new Word(3, "mouse", "mysh", (byte) 1));
        ld.printAllWords();

        ld.addDictToMap();
        ld.printMap();

        /*ld.dictMap.put(1, ld.engrusDict.get(0));
        ld.dictMap.put(2, ld.engrusDict.get(1));
        ld.dictMap.put(3, ld.engrusDict.get(2));*/

        /*for (Map.Entry entry : ld.dictMap.entrySet())
        {
            Word w = (Word) entry.getValue();
            System.out.println(entry.getKey() + " " + w.originalWord);
        }*/

        // Function searchInMapByIndex()
        System.out.println(ld.searchInMapByIndex(1).originalWord +
                ld.searchInMapByIndex(1).translationWord + ld.searchInMapByIndex(1).rating);
    }
}