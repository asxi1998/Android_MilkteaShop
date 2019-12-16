package com.example.thandroid_milkteabooking;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thandroid_milkteabooking.Adapter.orderAdapter;
import com.example.thandroid_milkteabooking.File.ChiTietHoaDon;
import com.example.thandroid_milkteabooking.File.ChiTietHoaDonModel;
import com.example.thandroid_milkteabooking.File.HoaDon;
import com.example.thandroid_milkteabooking.File.HoaDonModel;
import com.example.thandroid_milkteabooking.File.UserModel;
import com.example.thandroid_milkteabooking.model.order;

import net.sourceforge.jtds.jdbc.DateTime;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GetOrderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GetOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetOrderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GetOrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetOrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GetOrderFragment newInstance(String param1, String param2) {
        GetOrderFragment fragment = new GetOrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    RecyclerView re;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View v;
    RecyclerView recyclerView;
    ArrayList<order> orderList;
    TextView textViewtongtien;
    orderAdapter orderAdapter;
    HoaDonModel hoaDonModel;
    ChiTietHoaDonModel chiTietHoaDonModel;
    Button btn;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewtongtien=view.findViewById(R.id.textViewtongtien);
        recyclerView=view.findViewById(R.id.listView_lst_order);
        btn=view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OnClick();

                } catch (SQLException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext().getApplicationContext(),"loi:"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        int so=0;
        for(int i=0;i<HomeActivity.manggiohang.size();i++)
        {
            so+=Integer.parseInt( HomeActivity.manggiohang.get(i).getMota());

        }
        textViewtongtien.setText(String.valueOf(so));
        Log.d("aaaa",HomeActivity.manggiohang.size()+"aaaaaaaa");

        orderAdapter = new orderAdapter(HomeActivity.manggiohang, getContext().getApplicationContext());
        recyclerView.setAdapter(orderAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_order, container, false);
    }
    public void showInfor( RecyclerView.Adapter  lst)
    {
        re= v.findViewById(R.id.listView_lst_order);
        re.setAdapter(lst);

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

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void OnClick() throws SQLException {

        hoaDonModel= new HoaDonModel();

        UserModel userModel= new UserModel();
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        Date date= new Date();
        String s= dateFormat.format(date);
        HoaDon hd= new HoaDon(AccountFragment.sdt,s,Integer.parseInt( textViewtongtien.getText().toString()) );
        hoaDonModel.Insert(hd);

        int so=hoaDonModel.getID(hd);
        for(int i=0;i<HomeActivity.manggiohang.size();i++) {
            com.example.thandroid_milkteabooking.File.SP sp=new com.example.thandroid_milkteabooking.File.SP( HomeActivity.manggiohang.get(i).getTen(),null,0);
            int user=userModel.getID(sp);
            chiTietHoaDonModel= new ChiTietHoaDonModel();
            chiTietHoaDonModel.Insert(new ChiTietHoaDon(so,user,Integer.parseInt( HomeActivity.manggiohang.get(i).getMota())/100000,Integer.parseInt(HomeActivity.manggiohang.get(i).getMota())));
        }
        Toast.makeText(getContext().getApplicationContext(),"Thanhcong",Toast.LENGTH_LONG).show();

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
}
