/**
 * Created by gaoxd on 2018/5/24.
 */
public class t {
    public static void main(String[] args){
        System.out.println("ddd");

        int[] a={1,2};

        System.out.println("a="+a.length);

        Integer[] cacheArray = new Integer[]
                { 1, 2, 3, 4 };

        Integer[] cacheArray1 =
                { 1, 2, 3, 4, 5 };
        System.out.println("cacheArray="+cacheArray.length);
        System.out.println("cacheArray1="+cacheArray1.length);

        //没有break,就会执行所有的case
        int switch_type = 0;

        switch (switch_type){
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println(switch_type);
            default:
                System.out.println("default");
        }
    }
}
