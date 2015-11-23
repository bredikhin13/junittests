package MyApp;

/**
 * Created by User on 10.11.2015.
 */
public class MyClass {
    public static void main(String[] args) {
        MyArray arr = new MyArray(10);
        for(int i = 0;i<15;i++){
            arr.add(i);
        }
        arr.printArr();
    }
}
