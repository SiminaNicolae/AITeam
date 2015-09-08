package com.fortech.aiteam.aiteam.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationAdapter<T> extends ArrayAdapter<T> {
    private final List<T> objects;
    private final Object mLock;

    public ApplicationAdapter(Context context) {
        super(context, 0);
        objects = new ArrayList<>();
        mLock = new Object();
        setNotifyOnChange(false);
    }

    public ApplicationAdapter(Context context, List<T> objects) {
        super(context, 0);
        this.objects = objects;
        mLock = new Object();
    }

    @Override
    public void add(T object) {
        synchronized (mLock) {
            objects.add(object);
        }
    }

    @Override
    public void addAll(Collection<? extends T> collection) {
        synchronized (mLock) {
            objects.addAll(collection);
        }
    }

    @Override
    public void insert(T object, int index) {
        synchronized (mLock) {
            objects.add(index, object);
        }
    }

    @Override
    public void remove(T object) {
        synchronized (mLock) {
            objects.remove(object);
        }
    }

    @Override
    public void clear() {
        synchronized (mLock) {
            objects.clear();
        }
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getPosition(T item) {
        return objects.indexOf(item);
    }

    public List<T> getObjects() {
        return objects;
    }
}
