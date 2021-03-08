import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ReverseCollector<T, A extends Collection<T> & MyBuilder<A>> implements Collector<T, ArrayList<T>, A> {


    private A collection;

    public ReverseCollector(A collection) {

        this.collection = collection;
    }

    public ReverseCollector(MyBuilder<A> builder) {
        this.collection = builder.build();
    }

    @Override
    public Supplier<ArrayList<T>> supplier() {

        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<T>, T> accumulator() {

        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<T>> combiner() {
        return (x, y) -> {
            x.addAll(y);
            return x;
        };
    }

    @Override
    public Function<ArrayList<T>, A> finisher() {
        return x -> {
            A fin = collection.build();
            for (int i = x.size() - 1; i > -1; i--) {
                fin.add((T) x.get(i));
            }
            return fin;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {

        return EnumSet.of(Characteristics.UNORDERED);
    }
}

interface MyBuilder<A> {
   public A build();
}