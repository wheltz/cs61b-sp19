/**
 * @program: proj1b
 * @Date: 2021/2/15 16:39
 * @Author: Mr.Deng
 * @Description:
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        return Math.abs(x-y) == 1;
    }
}
