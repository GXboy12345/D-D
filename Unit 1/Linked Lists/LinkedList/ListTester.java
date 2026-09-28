
import java.util.ArrayList;
import java.util.Arrays;

public class ListTester {
    public static void main(String[] args) {
        Integer[] arr = {0, 1, 3, 5, 2, 2, 4, 6, 2, 3, 2, 4, 2, 3};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
        SinglyLinkedList<Integer> list = (SinglyLinkedList<Integer>) new SinglyLinkedList<>((Integer[]) arr);
        for(int i = 0; i < al.size(); i++) System.out.println(al.get(i).equals(list.get(i)) ? "Pass" : "Fail");
        int r = (int) (Math.random() * al.size());
        for(int i = 0; i < 6; i++) {System.out.println((al.remove(r).equals(list.remove(r))) ? "Pass" : "Fail"); r = (int) (Math.random() * al.size());}
        for(int i = 0; i < al.size(); i++) System.out.println(al.get(i).equals(list.get(i)) ? "Pass" : "Fail");
        r = (int) (Math.random() * al.size());
        int v = (int) (Math.random() * al.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(al.set(r, v).equals(list.set(r, v)) ? "Pass" : "Fail");
            r = (int) (Math.random() * al.size());
            v = (int) (Math.random() * al.size());
        }
        for(int i = 0; i < al.size(); i++) System.out.println(al.get(i).equals(list.get(i)) ? "Pass" : "Fail");
        for (int i = 0; i < 10; i++) {
            r = (int) (Math.random() * al.size());
            v = (int) (Math.random() * al.size());
            al.add(r, v);
            list.add(r, v);
        }
        for(int i = 0; i < al.size(); i++) System.out.println(al.get(i).equals(list.get(i)) ? "Pass" : "Fail");
        for (int i = 0; i < 10; i++) {
            r = (int) (Math.random() * al.size());
            al.add(r);
            list.add(r);
        }
        for(int i = 0; i < al.size(); i++) System.out.println(al.get(i).equals(list.get(i)) ? "Pass" : "Fail");
        System.out.println(al.size() == list.size() ? "Pass" : "Fail");
        for (int i = 0; i < 10; i++) {
            r = (int) (Math.random() * al.size());
            v = al.get(r);
            System.out.println(al.contains(v) == list.contains(v) ? "Pass" : "Fail");
        }
        for (int i = 0; i < 10; i++) {
            r = (int) (Math.random() * al.size());
            v = al.get(r);
            System.out.println(al.indexOf(v) == list.indexOf(v) ? "Pass" : "Fail");
        }
    }
}
