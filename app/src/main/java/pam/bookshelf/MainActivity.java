package pam.bookshelf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BookListFragment.OnFragmentInteractionListener
, BookDetailsFragment.OnFragmentInteractionListener {
   public static String screen="";
    public static  FrameLayout frame_details;
    public static   double diagonalInches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame_details=findViewById(R.id.frame_details);

        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, new BookListFragment());
//        transaction.addToBackStack(null);
        transaction.commit();


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float yInches= metrics.heightPixels/metrics.ydpi;
        float xInches= metrics.widthPixels/metrics.xdpi;
         diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
//        if (screen.equals("ph")) {
            Fragment f = getSupportFragmentManager().findFragmentById(R.id.frame_details);
        if (diagonalInches>=6.5 || getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            super.onBackPressed();
        }
        else {
            if (f instanceof BookDetailsFragment) {
                getSupportFragmentManager().beginTransaction().remove(f).commit();
            }   else{
                super.onBackPressed();
            }

        }

    }
}
