package com.ziterz.jonqko;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] layouts;
    private LinearLayout dotsLayout;
    private TextView[] dotsHome;

    private TextView tvAlamat;
    private Button btGantiAlamat;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarHome);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(null);

        viewPager = (ViewPager)view.findViewById(R.id.view_pager_home);
        dotsLayout = (LinearLayout)view.findViewById(R.id.layoutDotsHome);

        /*--- Linear Layout Alamat ---*/
        tvAlamat = (TextView)view.findViewById(R.id.textviewAlamat);
        btGantiAlamat = (Button)view.findViewById(R.id.buttonGantiAlamat);
        btGantiAlamat.setTransformationMethod(null);

        btGantiAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast. makeText (getContext(), "Ganti Alamat" ,
                        Toast. LENGTH_SHORT ).show();
            }
        });

        layouts = new int[]{R.layout.slider_home1,R.layout.slider_home2};
        addBottomDots(0);
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.main_top_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menuSrch:
                Toast. makeText (getContext(), "Search" ,
                        Toast. LENGTH_SHORT ).show();
                return true ;
            case R.id.menuCart:
                Toast. makeText (getContext(), "Cart" ,
                        Toast. LENGTH_SHORT ).show();
                return true ;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    private void addBottomDots(int position){
        dotsHome = new TextView[layouts.length];
        int[] colorActive = getResources().getIntArray(R.array.dot_active);
        int[] colorInactive = getResources().getIntArray(R.array.dot_inactive);
        dotsLayout.removeAllViews();
        for(int i = 0; i < dotsHome.length; i++){
            dotsHome[i] = new TextView(getContext());
            dotsHome[i].setText(Html.fromHtml("&#8226;"));
            dotsHome[i].setTextSize(35);
            dotsHome[i].setTextColor(colorInactive[position]);
            dotsLayout.addView(dotsHome[i]);
        }
        if (dotsHome.length > 0) {
            dotsHome[position].setTextColor(colorActive[position]);
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class ViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View)object;
            container.removeView(v);
        }
    }

}
