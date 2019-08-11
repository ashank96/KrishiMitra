package com.aloofwillow96.languageapp.controllers;

import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.ViewUtils;
import com.aloofwillow96.languageapp.databinding.ConductorRegisterPhoneNumberBinding;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class OtpValidationController extends Controller {
	String phoneNumber;
	FirebaseAuth mAuth;
	ConductorRegisterPhoneNumberBinding baseBinding;
	PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
	private String mVerificationId;

	public OtpValidationController() {

	}

	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		baseBinding = DataBindingUtil.inflate(inflater, R.layout.conductor_register_phone_number, container, false);
		init();
		return baseBinding.getRoot();
	}

	public OtpValidationController(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private void init() {
		mAuth = FirebaseAuth.getInstance();
		baseBinding.proceedButton.setVisibility(View.GONE);
		baseBinding.phoneNumberEditText.setVisibility(View.GONE);
		baseBinding.newUserHeader.setText("Enter OTP");
		baseBinding.newUserHeader.setVisibility(View.VISIBLE);
		baseBinding.otpViewEditText.otpViewEditText.setVisibility(View.VISIBLE);
		initOtpEntryView();
		setVerificationCallbacks();
		sendOtp();
	}

	private void initOtpEntryView() {
		baseBinding.otpViewEditText.otpViewEditText.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
			@Override
			public void onPinEntered(CharSequence str) {
				if (mVerificationId != null) {
					baseBinding.loadingView.setVisibility(View.VISIBLE);
					verifyVerificationCode(str.toString());
				}
			}
		});
	}

	private void sendOtp() {
		Activity activity = getActivity();
		if (activity != null) {
			PhoneAuthProvider.getInstance().verifyPhoneNumber(
					"+91" + phoneNumber,
					60,
					TimeUnit.SECONDS,
					activity,
					mCallbacks);
		}
	}

	private void setVerificationCallbacks() {
		mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
			@Override
			public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
				Log.d(TAG, "onVerificationCompleted:" + phoneAuthCredential);
				String code = phoneAuthCredential.getSmsCode();
				if (code != null) {
					baseBinding.otpViewEditText.otpViewEditText.setText(code);
					verifyVerificationCode(code);
				}else{
					signInWithPhoneAuthCredential(phoneAuthCredential);
				}
			}

			@Override
			public void onVerificationFailed(FirebaseException e) {
				Log.w(TAG, "onVerificationFailed", e);
				if (e instanceof FirebaseAuthInvalidCredentialsException) {
					Snackbar.make(baseBinding.getRoot(), "Invalid Phone Number",
							Snackbar.LENGTH_SHORT).show();
				} else if (e instanceof FirebaseTooManyRequestsException) {
					Snackbar.make(baseBinding.getRoot(), "Quota exceeded.",
							Snackbar.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
				super.onCodeSent(s, forceResendingToken);
				mVerificationId = s;
			}
		};
	}

	private void verifyVerificationCode(String otp) {
		PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, otp);
		signInWithPhoneAuthCredential(credential);
	}

	private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
		mAuth.signInWithCredential(credential)
				.addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						baseBinding.loadingView.setVisibility(View.GONE);
						if (task.isSuccessful()) {
							//verification successful we will start the profile activity
							getRouter().pushController(RouterTransaction.with(new FormController()));

						} else {
							//verification unsuccessful.. display an error message
							String message = "Something is wrong, we will fix it soon...";

							if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
								message = "Invalid code entered...";
							}

							View view = baseBinding.getRoot();
							if (view != null) {
								Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
								snackbar.setAction("Dismiss", new View.OnClickListener() {
									@Override
									public void onClick(View v) {

									}
								});
								snackbar.show();
							}
						}
					}
				});
	}

}
