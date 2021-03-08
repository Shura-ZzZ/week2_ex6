import java.util.ArrayList;

public class MyArray extends ArrayList<Integer> implements MyBuilder<MyArray> {
    @Override
    public MyArray build() {
        return  new MyArray();
    }
}
