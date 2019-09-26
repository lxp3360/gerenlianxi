/**
 * FileName: VolataileDemo
 * Author:   Lixiaopeng
 * Date:     2019/9/20 16:40
 * Description:
 */
package atomic;

public class VolataileDemo {
    volatile  boolean running = true;
    public void m(){
        while (running) {

        }
    }

    public static void main(String[] args){
        VolataileDemo volataileDemo = new VolataileDemo();

        new Thread(volataileDemo::m,"t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volataileDemo.running=false;
    }

}
