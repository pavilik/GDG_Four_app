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


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>  {

    public OnItemClickListener itemClickListener ;

    private final List<CardFIONitem> itemValues;
    private final OnListFragmentInteractionListener holderListener;

    public MyItemRecyclerViewAdapter(List<CardFIONitem> items, OnListFragmentInteractionListener listener) {
        itemValues = items;
        holderListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
         ButterKnife.bind(this,view);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

holder.bind(itemValues.get(position),itemClickListener);

        holder.mItem = itemValues.get(position);
             holder.familCard.setText(itemValues.get(position).getFamili());
        holder.nameCard.setText(itemValues.get(position).getName());
        holder.otchestvoCard.setText(itemValues.get(position).getOtchestvo());
        holder.telefonCard.setText(itemValues.get(position).getNumTel());

        holder.familCard.setEnabled(false);
        holder.nameCard.setEnabled(false);
        holder.otchestvoCard.setEnabled(false);
        holder.telefonCard.setEnabled(false);

holder.mView.setBackgroundResource(R.color.colorForRecyclerView);




//holder.anyCard.setClickable(true);
//holder.anyCard.setFocusableInTouchMode(true);
//
//        holder.anyCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "ИИИхххааа! " +position, Toast.LENGTH_SHORT).show();
//
//            }
//        });


//
//if (null!= itemClickListener) {
//    itemClickListener.onItemClick(holder.mItem);
//    } //   ho
//

//
//holder.mView.setOnClickListener(new OnItemClickListener() {
//    @Override
//    public void onItemClick(CardFIONitem cardItem) {
//        Log.d(TAG, "onClick " +cardItem.getFamili());
//    }
//
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(view.getContext(), "!!!!!!!!!!!!!!!!!!! " +position, Toast.LENGTH_SHORT).show();
//
//    }
//});
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != holderListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.



                  Toast.makeText(v.getContext(), "Нажатие! " +position, Toast.LENGTH_SHORT).show();
                    holderListener.onListFragmentInteraction();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.famil)
     public    TextView familCard;
        @BindView(R.id.imja)
        public   TextView nameCard;
        @BindView(R.id.ot4estvo)
        public    TextView otchestvoCard;
        @BindView(R.id.telefon)
        public   TextView telefonCard;

        @BindView(R.id.cardView)

        public CardView anyCard;




        public final View mView;
//        public final TextView familCard;
//        public final TextView nameCard;
//        public final TextView otchestvoCard;
//        public final TextView telefonCard;
        public CardFIONitem mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            mView = view;
           // view.setOnClickListener(view);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    itemClickListener.onItemClick(itemValues.get(getAdapterPosition()));
//                    Log.d(TAG, "onClick " +getAdapterPosition()+ " " + mItem);
//
//                }
//            });



//            familCard = view.findViewById(R.id.famil);
//            nameCard =  view.findViewById(R.id.imja);
//            otchestvoCard = view.findViewById(R.id.ot4estvo);
//            telefonCard = view.findViewById(R.id.telefon);
        }

        public  void bind(final CardFIONitem cfioItem, final OnItemClickListener itemClickListener ){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(cfioItem);
                    Log.d(TAG, "onClick " +getAdapterPosition()+ " " + mItem);

                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + "Ничего нет";
        }



//        @Override
//        public void onClick(View view) {
//            Log.d(TAG, "onClick " +getAdapterPosition()+ " " + mItem);
//        }
    }

    interface OnItemClickListener extends View.OnClickListener {
        void onItemClick(CardFIONitem cardItem);

        @Override
        void onClick(View view);
    }

}
