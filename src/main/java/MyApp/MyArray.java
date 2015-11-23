package MyApp;

import java.util.Arrays;

public class MyArray {

    private int[] body;
    private int col = 0;
    private static final int DEFAULT_SIZE = 10;

    /*Допишите конструктор(ы) и реализуйте методы*/
    public MyArray(int count) {
        body = new int[count];
    }

    public MyArray() {
        body = new int[DEFAULT_SIZE];
    }

    public MyArray(int[] a) {
        body = new int[a.length];
        System.arraycopy(a, 0, body, 0, a.length);
        col = a.length;
    }

    public void add(int el) {
        if (body.length == col) {
            int tmp[] = new int[body.length * 2];
            System.arraycopy(body, 0, tmp, 0, col);
            body = tmp;
        }
        body[col++] = el;
    }

    public void delete(int index) {
        col--;
        System.arraycopy(body, index + 1, body, index, col - index);

    }

    public void set(int index, int newElement) {
        body[index] = newElement;
    }

    public int get(int index) {
        return body[index];
    }

    public void printArr() {
        for (int i = 0; i < col; i++) {
            System.out.print(body[i] + " ");
        }
        System.out.println();
    }

    public int findMin() {
        int min = body[0];
        for (int i = 1; i < col; i++) {
            if (body[i] < min) {
                min = body[i];
            }
        }
        return min;
    }

    public void sort() {
        for (int i = 1; i < col; i++) {
            int target = i;
            while (target != 0 && body[target] < body[target - 1]) {
                int tmp = body[target];
                body[target] = body[target - 1];
                body[target - 1] = tmp;
                target--;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArray myArray = (MyArray) o;

        if (col != myArray.col) return false;
        for(int i=0;i<col;i++){
            if (myArray.body[i]!=body[i]){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(body);
        result = 31 * result + col;
        return result;
    }
}
