package com.ywt.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ywt on 2018/5/25.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    private int layoutId;

    public ItemAdapter(Context context, int layoutId, List<Item> list) {
        super(context, layoutId, list);
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);// 获取当前项的Item实例
        View view = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);//实例化一个对象 使用Inflater对象来将布局文件解析成一个View
        ImageView imageView = (ImageView) view.findViewById(R.id.item_img);//获取该布局内的图片视图
        TextView textView = (TextView) view.findViewById(R.id.item_text);//获取该布局内的文本视图
        imageView.setImageResource(item.getImgId());//为图片视图设置图片资源
        textView.setText(item.getName());//为文本视图设置文本内容

        return view;
    }
}






















