public class Q1 {
    public static void main(String[] args) {
        int[] arr1 = {2, 10, 38, 41, 51};
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        for (int val : arr1) {
            list1.addLast(val);
        }
        System.out.println(list1.toString());

        int[] arr2 = {5, 12, 18, 21, 35, 41, 56};
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        for (int val : arr2) {
            list2.addLast(val);
        }
        System.out.println(list2.toString());

        MyLinkedList<Integer> newList = combine(list1, list2);
        System.out.println(newList.toString());
    }

    private static <E extends Comparable<E>> MyLinkedList<E> combine(MyLinkedList<E> list1, MyLinkedList<E> list2) {
        MyLinkedList<E> newList = new MyLinkedList<>();
        E elem1 = list1.removeFirst();
        E elem2 = list2.removeFirst();

        while (elem1 != null && elem2 != null) {
            if (elem1.compareTo(elem2) <= 0) {
                newList.addLast(elem1);
                elem1 = list1.removeFirst();
            } else {
                newList.addLast(elem2);
                elem2 = list2.removeFirst();
            }
        }

        while (elem1 != null) {
            newList.addLast(elem1);
            elem1 = list1.removeFirst();
        }

        while (elem2 != null) {
            newList.addLast(elem2);
            elem2 = list2.removeFirst();
        }
        return newList;
    }
}
