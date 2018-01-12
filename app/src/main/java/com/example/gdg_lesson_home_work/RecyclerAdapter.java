package com.example.gdg_lesson_home_work;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by Павел on 12.01.2018.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] mDataset;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // пункт состоит из одной картинки (фото контакта) и 2х TextView (имя, фамилия)
      //  public ImageView mImageViewPhoto;
        public TextView mTextViewName;
     //   public TextView mTextViewFamily;


        public ViewHolder(View v) {
            super(v);
          //  mImageViewPhoto = (ImageView) v.findViewById(R.id.photoImageView);
            mTextViewName = (TextView) v.findViewById(R.id.name_recycler_item);
         //   mTextViewFamily = (TextView) v.findViewById(R.id.famil_recycler_item);


        }
    }

    // Конструктор
    public RecyclerAdapter(String[] dataset) {
        mDataset = dataset;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextViewName.setText(mDataset[position]);
     //   holder.mTextViewFamily.setText(mDataset[position]);
      //  holder.mImageViewPhoto.setImageDrawable();

    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
