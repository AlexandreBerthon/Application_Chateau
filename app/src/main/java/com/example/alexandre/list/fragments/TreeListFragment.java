package com.example.alexandre.list.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alexandre.list.R;
import com.example.alexandre.list.adapters.TreeAdapter;
import com.example.alexandre.list.models.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandre on 07/11/2017.
 */

public class TreeListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Image monImage;
    private Bitmap bitmap;

    private ListView maListView;

    private String[] prenoms = new String[]{
            "Alexandre", "Yoann", "Simon", "Bob", "Jean", "Yann", "Louis", "Christophe", "Gael", "Bamboula", "Gareth"
    };

    private OnTreeListClickListener mListener;

    public TreeListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TreeListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TreeListFragment newInstance(String param1, String param2) {
        TreeListFragment fragment = new TreeListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);

        bindViews(view);

        afficherListeTree();

        maListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onTreeListClick();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onTreeListClick() {
        if (mListener != null) {
            mListener.onTreeListClick();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TreeListFragment.OnTreeListClickListener) {
            mListener = (TreeListFragment.OnTreeListClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTweetListClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void bindViews(View view) {
        maListView = (ListView) view.findViewById(R.id.list);
    }

    private void afficherListeTree() {
        TreeAdapter adapter = new TreeAdapter(getContext(), genererTree());
        maListView.setAdapter(adapter);
    }

    private List<Tree> genererTree() {
        List<Tree> trees = new ArrayList<Tree>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),   R.drawable.arbre);
        Drawable d = new BitmapDrawable(getResources(),bitmap);

        trees.add(new Tree(d, "Platane commun ", "Large arbre plus couramment situé en France pouvant vivre jusqu’à 2000 ans et mesurer jusqu’à 40 mètres"));
        trees.add(new Tree(d, "Platane d’orient ", "Large arbre plus couramment situé en France pouvant mesurer jusqu’à 30 mètres de hauteur\n"));
        trees.add(new Tree(d, "Noyer noir d’Amérique ", "arbre venant d’Amérique du nord qui mesure de 20 à 30 mètres "));
        trees.add(new Tree(d, "Cèdre du Liban ", "arbre qui pousse en forêt, pouvant vivre jusqu’à 300 ans, mesurer jusqu’à 40, et pouvant résister au froid jusqu’à -17°C.\n"));
        return trees;
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
    public interface OnTreeListClickListener {
        void onTreeListClick();
    }
}