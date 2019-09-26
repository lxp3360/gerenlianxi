/**
 * FileName: HelloGc
 * Author:   Lixiaopeng
 * Date:     2019/9/26 14:11
 * Description:
 */
package gc;

public class HelloGc {
    public static void main(String[] args){
        System.out.println("hellogc11");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
