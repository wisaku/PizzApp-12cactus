package com.example.saba.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.List;

public class BaseArrayAdapter<T> extends ArrayAdapter<T>
{
    protected List<T> elements;

    public BaseArrayAdapter(@NonNull Context context, @LayoutRes int resource, List<T> elements)
    {
        super(context, resource);

        this.elements = elements;
    }

    @Override
    public int getCount()
    {
        if(elements != null)
            return elements.size();

        return 0;
    }

    @Nullable
    @Override
    public T getItem(int position)
    {
        if(elements != null)
            return elements.get(position);

        return null;
    }
}