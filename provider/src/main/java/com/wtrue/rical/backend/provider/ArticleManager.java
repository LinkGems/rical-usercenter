package com.wtrue.rical.backend.provider;

import com.aliasi.sentences.IndoEuropeanSentenceModel;
import com.aliasi.sentences.SentenceModel;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: meidanlong
 * @date: 2021/10/20 10:42 PM
 */
public class ArticleManager {
    //字母类
    public static class Letter {
        char letter;
    }

    //句子类
    public class Sentence {
        Word[] words;//句子里的每个单词类
        public String text;//句子

    }

    //字词类
    public class Word {
        Letter[] letters;//单词里的每个字符类
        String word;//单词
    }


    final TokenizerFactory tokenizerFactory = IndoEuropeanTokenizerFactory.INSTANCE;
    final SentenceModel sentenceModel = new IndoEuropeanSentenceModel();

    /**
     * 根据文章截取句子；
     * @param text 文章
     * @return 句子集合
     */
    public List<Sentence> getSentences(String text) {
        List<String> wordlist = new ArrayList<String>();
        List<String> whiteList = new ArrayList<String>();
        Tokenizer tokenizer = tokenizerFactory.tokenizer(text.toCharArray(),
                0, text.length());
        tokenizer.tokenize(wordlist, whiteList);
        String[] words = new String[wordlist.size()];//得到所有的词
        String[] whites = new String[whiteList.size()];//得到空白字符
        wordlist.toArray(words);
        whiteList.toArray(whites);
        int[] sentenceLastCharIndexs = sentenceModel.boundaryIndices(words, whites);//拿到句子结束的索引
        int nextIndex = 0;
        ArrayList<Sentence> sentences = new ArrayList<Sentence>();
        for (int lastIndex : sentenceLastCharIndexs) {
            Sentence sentence = new Sentence();
            StringBuilder stringBuilder = new StringBuilder();
            Word[] sentencWords = new Word[lastIndex - nextIndex + 1];
            int j = 0;
            for (int i = nextIndex; i <= lastIndex; i++) {
                Word sentencWord = new Word();
                sentencWords[j++] = sentencWord;
                sentencWord.word = (words[i]);
                char[] chars = new char[sentencWord.word.length()];
                sentencWord.word.getChars(0, chars.length, chars, 0);
                Letter[] letters = new Letter[chars.length];
                for (int z = 0; z < chars.length; z++) {
                    Letter letter = new Letter();
                    letter.letter = chars[z];
                    letters[z] = letter;
                }
                sentencWord.letters = letters;
                stringBuilder.append(sentencWord.word);
                if (i != lastIndex - 1) {
                    stringBuilder.append(' ');//补空格
                }

            }
            sentence.text = stringBuilder.toString();
            sentence.words = sentencWords;
            nextIndex = lastIndex + 1;
            sentences.add(sentence);
        }
        return sentences;

    }

    static String text ="你个大笨猪呀。This novel has been fully translated by RWX. There are a total of 21 books spanning 800+ chapters, so sit back, buckle your seat belts, and get ready for one long ride!\n\n" +
            "\n" +
            "Empires rise and fall on the Yulan Continent. Saints, immortal beings of unimaginable power, battle using spells and swords, leaving swathes of destruction in their wake. Magical beasts rule the mountains, where the brave – or the foolish – go to test their strength. Even the mighty can fall, feasted on by those stronger. The strong live like royalty; the weak strive to survive another day.\n" +
            "\n" +
            "This is the world which Linley is born into. Raised in the small town of Wushan, Linley is a scion of the Baruch clan, the clan of the once-legendary Dragonblood Warriors. Their fame once shook the world, but the clan is now so decrepit that even the heirlooms of the clan have been sold off. Tasked with reclaiming the lost glory of his clan, Linley will go through countless trials and tribulations, making powerful friends but also deadly enemies.\n" +
            "\n" +
            "Come witness a new legend in the making. The legend of Linley Baruch.";


    public static void main(String[] args){
        ArticleManager articleManager = new ArticleManager();
        List<ArticleManager.Sentence> sentences = articleManager.getSentences(text);
        for (ArticleManager.Sentence sentence : sentences) {
            System.out.println(sentence.text);
        }
    }

}
