package pam.bookshelf;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static pam.bookshelf.BookDetailsFragment.txtAuthor;
import static pam.bookshelf.BookDetailsFragment.txtAuthorTitleName;
import static pam.bookshelf.BookListFragment.Author;
import static pam.bookshelf.BookListFragment.frame_details;
import static pam.bookshelf.BookListFragment.list;
import static pam.bookshelf.MainActivity.diagonalInches;

public class MyListAdapter extends BaseAdapter {
    private final Activity context;
    List<HashMap> book=new ArrayList<HashMap>();

 public MyListAdapter(Activity context, List<HashMap> book) {
        this.context = context;
        this.book = book;
    }

    @Override
    public int getCount() {
        return book.size();
    }

    @Override
    public Object getItem(int position) {
        return book.size();
    }

    @Override
    public long getItemId(int position) {
        return book.size();
    }

    ;
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.list_layout,null,true);

        final TextView titleText = (TextView) view.findViewById(R.id.title);
        TextView subtitleText = (TextView) view.findViewById(R.id.subtitle);
        LinearLayout lin = (LinearLayout) view.findViewById(R.id.lin);

        final HashMap<Integer ,String > AuthorName= book.get(0);
        final HashMap<Integer ,String > AuthorBookName= book.get(1);

        titleText.setText(AuthorName.get(position));
        subtitleText.setText(AuthorBookName.get(position));

        if (position==0){
        if (diagonalInches>=6.5 || context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ){
            // 6.5inch device or bigger
            BookListFragment.Title=AuthorBookName.get(position);
            Author=AuthorName.get(position);
            FragmentTransaction transaction =((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_details, new BookDetailsFragment());
            transaction.commit();
        }}
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diagonalInches>=6.5){
                    // 6.5inch device or bigger
                    BookListFragment.Title=AuthorBookName.get(position);
                    Author=AuthorName.get(position);
                    txtAuthor.setText(BookListFragment.Author);
                    txtAuthorTitleName.setText(BookListFragment.Title);

                }else{
                    // smaller device
                    if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        //Do some stuff
                        BookListFragment.Title=AuthorBookName.get(position);
                        Author=AuthorName.get(position);
                        txtAuthor.setText(BookListFragment.Author);
                        txtAuthorTitleName.setText(BookListFragment.Title);

                    }else {
                        MainActivity.frame_details.setVisibility(View.VISIBLE);
                        BookListFragment.Title = AuthorBookName.get(position);
                        Author = AuthorName.get(position);
                        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_details, new BookDetailsFragment());
                        transaction.commit();
                    }
                }

                 }
        });

        return view;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
}

