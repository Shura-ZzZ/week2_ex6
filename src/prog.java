public class prog {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        System.out.println(array);
        MyArray array1 = array.stream().collect(new ReverseCollector<>(new MyArray()));
        System.out.println(array1);
        MyArray array2;

        array2 = array.stream().collect(new ReverseCollector<Integer, MyArray>(MyArray::new));
        System.out.println(array2);



    }
}
