import java.util.LinkedList;
import java.util.Queue;

class DataStream {
    private int value;
    private int k;
    private Queue<Integer> stream;
    private int valueCount;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.stream = new LinkedList<>();
        this.valueCount = 0;
    }

    public boolean consec(int num) {
        stream.offer(num);

        if (stream.size() > k) {
            int removed = stream.poll();
            if (removed == value) {
                valueCount--;
            }
        }

        if (num == value) {
            valueCount++;
        }

        return valueCount == k;
    }
}
