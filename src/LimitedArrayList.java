import java.util.ArrayList;

public class LimitedArrayList<E> extends ArrayList<E> {
    private final int maxSize;

    public LimitedArrayList(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    @Override
    public boolean add(E e) {
        if (this.size() >= maxSize) {
            throw new IllegalStateException("List size limit reached");
        }
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (this.size() >= maxSize) {
            throw new IllegalStateException("List size limit reached");
        }
        super.add(index, element);
    }

}