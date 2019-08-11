package com.aloofwillow96.languageapp.controllers;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.databinding.ConductorRegisterPhoneNumberBinding;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

public class PhoneNumberController extends Controller {

	ConductorRegisterPhoneNumberBinding baseBinding;
	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		baseBinding = DataBindingUtil.inflate(inflater, R.layout.conductor_register_phone_number,container,false);
		init();
		return baseBinding.getRoot();
	}

	private void init() {
		baseBinding.proceedButton.setEnabled(false);
		baseBinding.proceedButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				launchOtpController();
			}
		});

		baseBinding.phoneNumberEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				if(isPhoneNumber(s.toString())){
					baseBinding.proceedButton.setEnabled(true);
				}else{
					baseBinding.proceedButton.setEnabled(false);
				}
			}
		});
	}

	private void launchOtpController() {
		getRouter()
				.pushController(
						RouterTransaction
								.with(new OtpValidationController(baseBinding.phoneNumberEditText.getText().toString())));
	}

	private boolean isPhoneNumber(String s) {
		if(TextUtils.isEmpty(s)||s.length()!=10){
			return false;
		}
		return true;
	}


}
