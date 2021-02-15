/**
 * @program: proj1b
 * @Date: 2021/2/15 16:59
 * @Author: Mr.Deng
 * @Description:
 */
public class OffByN implements CharacterComparator {
    private int n;

    OffByN(int N){
        n = N;
    }

    @Override
    public boolean equalChars(char x,char y){
        return Math.abs(x-y) == n;
    }
}
