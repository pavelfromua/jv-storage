public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int index = 0;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (index < 10) {
            boolean isHere = false;

            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == key && key != null) {
                    isHere = true;
                    values[i] = value;
                    break;
                }

                if (keys[i] instanceof Object) {
                    if (keys[i].equals(key)) {
                        isHere = true;
                        values[i] = value;
                        break;
                    }
                }
            }

            if (!isHere) {
                keys[index] = key;
                values[index] = value;
                index++;
            }
        } else {
            System.out.println("There is overlimit");
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = -1;

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                keyIndex = i;
                break;
            }

            if (keys[i] instanceof Object) {
                if (keys[i].equals(key)) {
                    keyIndex = i;
                    break;
                }
            }
        }

        if (keyIndex == -1) {
            return null;
        } else {
            return values[keyIndex];
        }
    }
}
