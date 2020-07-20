package task3701;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public T remove(int index) {
        return super.remove(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();//super.iterator()
    }

    public class RoundIterator implements Iterator<T>{
//        private int cursor = 0;
//        private int lastReturned = -1;
//        private int expectedModCount = modCount;
        private Iterator<T> itr = Solution.super.iterator();

        RoundIterator() {//Iterator<E> itr
//            this.itr = itr;
        }

        @Override
        public boolean hasNext() {
            //return cursor != size();
            return Solution.this.size() > 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) return null;
            if (!itr.hasNext()) itr = Solution.super.iterator();
            return itr.next();
//            checkForComodification();
//            int i = cursor;
//            System.out.print(i);
//            if (i >= size()) throw new NoSuchElementException();
//            Object[] elementData = Solution.this.toArray();
//            if (i >= elementData.length) i = 0;
//            cursor = i + 1;
//            return (E) elementData[lastReturned = i];
        }

        @Override
        public void remove() {
            itr.remove();
//            if (lastReturned < 0) throw new IllegalStateException();
//            checkForComodification();
//
//            try {
//                Solution.this.remove(lastReturned);
//                cursor = lastReturned;
//                lastReturned = -1;
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException e) {
//                throw new ConcurrentModificationException();
//            }
        }

//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
    }
}
