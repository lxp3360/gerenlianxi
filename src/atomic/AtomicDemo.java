/**
 * FileName: AtomicDemo
 * Author:   Lixiaopeng
 * Date:     2019/9/2 17:15
 * Description:
 */
package atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicDemo {
    static AtomicStampedReference<Integer> asf = new AtomicStampedReference<>(100,1);
    public static void main(String[] args){
        new Thread(()->{
            int stamp = asf.getStamp();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"初始版本号"+stamp);
            asf.compareAndSet(100,101,asf.getStamp(),asf.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"第二次版本号"+asf.getStamp());
            asf.compareAndSet(101,100,asf.getStamp(),asf.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"第三次版本号"+asf.getStamp());

        },"t1").start();

        new Thread(()->{
            int stamp = asf.getStamp();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = asf.compareAndSet(100, 101, stamp, asf.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"版本号"+stamp);
            System.out.println(Thread.currentThread().getName()+"是否修改成功"+b);
            System.out.println(Thread.currentThread().getName()+"版本号"+asf.getReference());
        },"t2").start();
    }

}
