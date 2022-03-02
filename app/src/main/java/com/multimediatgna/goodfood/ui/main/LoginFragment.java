package com.multimediatgna.goodfood.ui.main;

import static androidx.core.content.ContextCompat.getSystemService;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.multimediatgna.goodfood.MainActivity;
import com.multimediatgna.goodfood.R;

public class LoginFragment extends Fragment implements View.OnClickListener{

    private MainViewModel mViewModel;
    EditText mynameedittext,mypasswdedittext;
    TextView mytextview;
    private Context mycontext;
    Button mybutton;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mycontext=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.main_fragment, container, false);
        Intent intent = getActivity().getIntent();
        mynameedittext = root.findViewById(R.id.myusername);
        mypasswdedittext = root.findViewById(R.id.mypasswd);
        mynameedittext.setText(intent.getStringExtra("myname"));
        mypasswdedittext.setText(intent.getStringExtra("mypassword"));
        mytextview = root.findViewById(R.id.mysysteminfo);
        mybutton = root.findViewById(R.id.mysysteminfobutton);
        mybutton.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {

        if(ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this.getActivity(), new String[] {Manifest.permission.READ_PHONE_STATE}, 1);

        } else {
            String deviceId_str, softwareVersion_str, simSerialNo, voicemailNumer_str, sim_operator_Name;
            TelephonyManager telephonyManager = (TelephonyManager) mycontext.getSystemService(mycontext.TELEPHONY_SERVICE);
            deviceId_str = telephonyManager.getDeviceId();
            softwareVersion_str = telephonyManager.getDeviceSoftwareVersion();
            simSerialNo = telephonyManager.getSimSerialNumber();
            voicemailNumer_str = telephonyManager.getVoiceMailNumber();
            sim_operator_Name = telephonyManager.getSimOperatorName();
            String Manufacturer_value = Build.MANUFACTURER;
            String Brand_value = Build.BRAND;
            String Model_value = Build.MODEL;
            String Board_value = Build.BOARD;
            String Hardware_value = Build.HARDWARE;
            String Serial_nO_value = Build.SERIAL;
            String android_id = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
            String BootLoader_value = Build.BOOTLOADER;
            String User_value = Build.USER;
            String Host_value = Build.HOST;
            String Version = Build.VERSION.RELEASE;
            String API_level = Build.VERSION.SDK_INT + "";
            String Build_ID = Build.ID;
            String Build_Time = Build.TIME + "";
            String Fingerprint = Build.FINGERPRINT;

            mytextview.setText(deviceId_str + "\n \n"
                                + simSerialNo + "\n \n"
                                + sim_operator_Name
                                + "\n \n"
                                + softwareVersion_str
                                + "\n \n" + voicemailNumer_str + "\n \n"
                                + Manufacturer_value + "\n \n"
                                + Brand_value + "\n \n"
                                + Model_value + "\n \n"
                                + Board_value + "\n \n"
                                + Hardware_value + "\n \n"
                                + Serial_nO_value + "\n \n"
                                + android_id + "\n \n"
                                + BootLoader_value + "\n \n"
                                + User_value + "\n \n"
                                + Host_value + "\n \n"
                                + Version + "\n \n"
                                + API_level + "\n \n"
                                + Build_ID + "\n \n"
                                + Build_Time + "\n \n"
                                + Fingerprint);

        }

    }
}