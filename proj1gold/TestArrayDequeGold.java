/**
 * @program: proj1gold
 * @Date: 2021/2/15 18:00
 * @Author: Mr.Deng
 * @Description:
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    private static String message = "";

    private void randomAdd(double random,Integer num,ArrayDequeSolution<Integer> a,StudentArrayDeque<Integer> b){
        if(random < 0.5){
            a.addFirst(num);
            b.addFirst(num);
            message += "\naddFirst(" + num + ")";
        }else{
            a.addLast(num);
            b.addLast(num);
            message += "\naddLast(" + num + ")";
        }
    }

    private void randomRemove(double random,Integer num,ArrayDequeSolution<Integer> a,StudentArrayDeque<Integer> b){
        if(random < 0.5){
            Integer expected = a.removeFirst();
            Integer actual = b.removeFirst();
            message += "\nremoveFirst(" + num + ")";
            assertEquals(message,expected,actual);
        }else{
            Integer expected = a.removeLast();
            Integer actual = b.removeLast();
            message += "\nremoveLast(" + num + ")";
            assertEquals(message,expected,actual);
        }
    }

    @Test
    public  void TestArrayDeque() {
        Integer randomNum;
        double random1,random2;
        ArrayDequeSolution<Integer> Solu1 = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> Solu2 = new StudentArrayDeque<>();
        while(true){
            randomNum = StdRandom.uniform(20);
            if(Solu1.isEmpty()){
                double random = StdRandom.uniform();
                randomAdd(random,randomNum,Solu1,Solu2);
            }else {
                random1 = StdRandom.uniform();
                random2 = StdRandom.uniform();
                if(random1 < 0.5){
                    randomAdd(random2,randomNum,Solu1,Solu2);
                }else {
                    randomRemove(random2,randomNum,Solu1,Solu2);
                }
            }
        }
    }
}
