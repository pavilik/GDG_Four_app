package com.example.home_work;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2InputFIO.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2InputFIO#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2InputFIO extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbider;

    @BindView(R.id.imja)
    TextView nameItem;
    @BindView(R.id.famil)
    TextView familItem;
    @BindView(R.id.ot4estvo)
    TextView ot4estvoItem;
    @BindView(R.id.telefon)
    TextView numtelItem;

    //, R.id.famil, R.id.ot4estvo, R.id.telefon}

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment2InputFIO() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2InputFIO.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2InputFIO newInstance(String param1, String param2) {
        Fragment2InputFIO fragment = new Fragment2InputFIO();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        unbider = ButterKnife.bind(this,view);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @OnClick(R.id.fragment2BntAcsept)
    void   onButtonPressed()
    {
        CardFIONitem cardFIONitem = new CardFIONitem( nameItem.getText().toString(),familItem.getText().toString(), ot4estvoItem.getText().toString(), numtelItem.getText().toString());

        mListener.onFragmentInteraction(cardFIONitem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_fragment2_input_fio, container, false);

    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;

    }

    @Override
    public  void  onDestroyView(){

        super.onDestroyView();
        unbider.unbind();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(CardFIONitem cardFIONitem);
    }
}
