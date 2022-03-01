/**
 * class Box
 *
 * @author Melnev Dmitry
 * @version 2022-03-02
 */
package Lesson_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> list = new ArrayList<>();

    public void addItem(T item) {
        list.add(item);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void pourTo(Box<T> dist) {
        if (this == dist) return;
        dist.getList().addAll(list);
        list.clear();
    }

    public float getWeight() {
        if (list.size() <= 0) return 0f;
        return (float) list.size() * list.get(0).getWeight();
    }

    public boolean compare(Box<? extends Fruit> o) {
        return (getWeight() == o.getWeight());
    }
}
