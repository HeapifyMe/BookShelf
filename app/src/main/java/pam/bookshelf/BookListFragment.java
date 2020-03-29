package pam.bookshelf;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BookListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookListFragment newInstance(String param1, String param2) {
        BookListFragment fragment = new BookListFragment();
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

    String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };
    public static  ListView list;
    Activity context;
    public static String Author="",Title="";

   HashMap<Integer,String> author=new HashMap<Integer,String>();
   HashMap<Integer,String> title=new HashMap<Integer,String>();
    ArrayList<HashMap> books=new ArrayList<HashMap>();
    public static   FrameLayout frame_details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view=    inflater.inflate(R.layout.fragment_book_list, container, false);
     list=view.findViewById(R.id.list);

        books();
    context=getActivity();


//        MyListAdapter adapter=new MyListAdapter(context, maintitle);
        MyListAdapter adapter=new MyListAdapter(context, books);
        list.setAdapter(adapter);


        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
        void onFragmentInteraction(Uri uri);
    }


public void books(){
    author.put(0,"half girlfriend");
    title.put(0,"Chetan Bhagat");
    books.add(author);
    books.add(title);
    author.put(1,"the white tiger");
    title.put(1,"Arvind Adiga");
    books.add(title);
    books.add(author);
    author.put(2,"War and Peace");
    title.put(2,"Leo Tolstoy");
    books.add(title);
    books.add(author);
    author.put(3,"In Search of Lost Time");
    title.put(3,"Marcel Proust");
    books.add(title);
    books.add(author);
    author.put(4,"The Great Gatsby");
    title.put(4,"F. Scott Fitzgerald");
    books.add(title);
    books.add(author);

   author.put(5,"Javier Moro");
    title.put(5,"The Red Sari");
    books.add(title);
    books.add(author);

    author.put(6,"Dalai Lama");
    title.put(6,"Freedom in Exile");
    books.add(title);
    books.add(author);
 author.put(7,"Ruskin Bond");
    title.put(7,"My Favourite Nature Stories");
    books.add(title);
    books.add(author);

author.put(7,"Khurshid M Kasuari");
    title.put(7,"Neither a hawk nor a dove");
    books.add(title);
    books.add(author);

author.put(8,"Deepak Nayyar");
    title.put(8,"Faces and Places Professor");
    books.add(title);
    books.add(author);

author.put(9,"Meira Kumar");
    title.put(9,"Indian Parliamentary Diplomacy");
    books.add(title);
    books.add(author);

author.put(10,"Farishta");
    title.put(10,"Kapil Isapuari");
    books.add(title);
    books.add(author);

author.put(11,"Amitabh Ghosh");
    title.put(11,"Flood of fire");
    books.add(title);
    books.add(author);




}

}
