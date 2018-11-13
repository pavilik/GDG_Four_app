package com.example.home_work;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home_work.ItemFragment.OnListFragmentInteractionListener;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    public OnItemClickListener itemClickListener;

    private final List<CardFIONitem> itemValues;
    private final OnListFragmentInteractionListener holderListener;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public MyItemRecyclerViewAdapter(List<CardFIONitem> items, OnListFragmentInteractionListener listener) {
        itemValues = items;
        holderListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        //инфлейтим другой лайоут для понимания перехвата касания в кардвью когда нет текстЕдит
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_card, parent, false);
        ButterKnife.bind(this, view);
        view.setOnClickListener(itemClickListener);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.bind(itemValues.get(position), itemClickListener);

        holder.mItem = itemValues.get(position);
        holder.familCard.setText(itemValues.get(position).getNameFamili());
        holder.nameCard.setText(itemValues.get(position).getHasPhoto());
        //указан формат выводимой даты
        holder.otchestvoCard.setText(simpleDateFormat.format(itemValues.get(position).getBdate()));
        holder.telefonCard.setText(itemValues.get(position).getNumId());

        holder.familCard.setEnabled(false);
        holder.nameCard.setEnabled(false);
        holder.otchestvoCard.setEnabled(false);
        holder.telefonCard.setEnabled(false);


        holder.mView.setBackgroundResource(R.color.colorForRecyclerView);
        holder.anyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "!!!!!!!!!!!!!!!!!!! " + position, Toast.LENGTH_SHORT).show();
            }
        });


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != holderListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.


                    Toast.makeText(v.getContext(), "Нажатие! " + position, Toast.LENGTH_SHORT).show();

                    //не ясно для чего этот метод вызывать, т.к. обрабатывается клик по фрагменту
                    // holderListener.onListFragmentInteraction();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.famil)
        public TextView familCard;
        @BindView(R.id.imja)
        public TextView nameCard;
        @BindView(R.id.ot4estvo)
        public TextView otchestvoCard;
        @BindView(R.id.telefon)
        public TextView telefonCard;

        @BindView(R.id.cardView)

        public CardView anyCard;


        public final View mView;

        public CardFIONitem mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;

        }

        public void bind(final CardFIONitem cfioItem, final OnItemClickListener itemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(cfioItem);
                    Log.d(TAG, "onClick " + getAdapterPosition() + " " + mItem);
                    Toast.makeText(view.getContext(), "Нажатиеfsdlkhfshda ", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + "Ничего нет";
        }


    }

    interface OnItemClickListener extends View.OnClickListener {
        void onItemClick(CardFIONitem cardItem);

        @Override
        void onClick(View view);
    }

}
