package com.example.alexandre.list.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandre.list.R;
import com.example.alexandre.list.models.Tree;

import java.util.List;

/**
 * Created by Alexandre on 07/11/2017.
 */

public class TreeAdapter extends ArrayAdapter<Tree> {

    //tree est la liste des models à afficher
    public TreeAdapter(Context context, List<Tree> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_arbre,parent, false);
        }

        TreeAdapter.TreeViewHolder viewHolder = (TreeAdapter.TreeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TreeAdapter.TreeViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Tree tree = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.pseudo.setText(tree.getPseudo());
        viewHolder.text.setText(tree.getText());
        viewHolder.avatar.setImageDrawable(tree.getD());

        return convertView;
    }

    private class TreeViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;
    }

}
