package com.codehash.nikunj.androidapi;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by nikunj on 31/5/17.
 */

public class dialogLayout extends DialogFragment implements DialogInterface.OnClickListener{

    public View view;
    public POSTdata getdata;
    public interface POSTdata {


        void postData(String name,String description);

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater=LayoutInflater.from(getActivity());
        view = inflater.inflate(R.layout.dialoglayout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hack it :");
        builder.setMessage("Enter data :");
        builder.setPositiveButton("Ok", this);
        builder.setNegativeButton("Cancel", null);
        builder.setView(view);

        return builder.create();



    }

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        getdata=(POSTdata) a;

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        EditText namedialog=(EditText)view.findViewById(R.id.namedialog);
        EditText descdialog=(EditText)view.findViewById(R.id.descdialog);
        String name=namedialog.getText().toString();
        String description=descdialog.getText().toString();
        getdata.postData(name,description);

    }
}
