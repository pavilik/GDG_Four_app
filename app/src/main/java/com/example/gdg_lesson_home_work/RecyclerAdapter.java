package com.example.gdg_lesson_home_work;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Павел on 12.01.2018.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Person[] dataset;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // пункт состоит из одной картинки (фото контакта) и 2х TextView (имя, номер телефона)
        public ImageView imageViewPhoto;
        public TextView textViewName;
        public TextView textViewPhoneNum;

        public ViewHolder(View v) {
            super(v);
            imageViewPhoto = (ImageView) v.findViewById(R.id.imageView);
            textViewName = (TextView) v.findViewById(R.id.name_recycler_item);
            textViewPhoneNum = (TextView) v.findViewById(R.id.phoneNum_recycler_item);
        }
    }

    // Конструктор
    public RecyclerAdapter(Person[] dataset) {
        this.dataset = dataset;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        return new ViewHolder(v);
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewName.setText(dataset[position].name);
        holder.textViewPhoneNum.setText(dataset[position].phoneNumber);
        holder.imageViewPhoto.setImageResource(dataset[position].photo);
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
