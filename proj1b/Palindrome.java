/**
 * @program: proj1b
 * @Date: 2021/2/15 15:19
 * @Author: Mr.Deng
 * @Description:xxx
 */
import java.util.Comparator;
import java.util.Deque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        if(word == null) return null;
        Deque<Character> res = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            res.addLast(word.charAt(i));
        }
        return res;
    }
    private boolean isPaliWord(String word, int front, int rear, CharacterComparator cc){
        if(rear <= front) return true;
        return cc.equalChars(word.charAt(front),word.charAt(rear)) && isPaliWord(word,front+1,rear-1,cc);

    }
    public boolean isPalindrome(String word){
        return isPaliWord(word,0,word.length()-1,(x,y)->
                x == y);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        return isPaliWord(word,0,word.length()-1,cc);
    }
}
