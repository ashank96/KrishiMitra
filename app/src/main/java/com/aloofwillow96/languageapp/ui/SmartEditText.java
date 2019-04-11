package com.aloofwillow96.languageapp.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.aloofwillow96.languageapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.ColorInt;

/**
 * @author ashankbharati created at 14/03/19
 */
public class SmartEditText extends TextInputLayout {

	private TextInputLayout textInputLayout;
	private TextInputEditText editText;
	private static final String ARG_SUPER_STATE = "super-state";
	private static final String ARG_EDIT_TEXT = "edit-text";

	public SmartEditText(Context context) {
		super(context);
	}

	public SmartEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	@Override
	public Parcelable onSaveInstanceState() {
		Bundle bundle = new Bundle();
		bundle.putParcelable(ARG_SUPER_STATE, super.onSaveInstanceState());
		bundle.putString(ARG_EDIT_TEXT, getEditTextContent().toString());
		return bundle;

	}

	@Override
	protected void onRestoreInstanceState(Parcelable state) {
		if(state instanceof Bundle ) {
			Bundle bundle = (Bundle) state;
			state = bundle.getParcelable(ARG_SUPER_STATE);
			setEditTextContent(bundle.getString(ARG_EDIT_TEXT));
		}
		super.onRestoreInstanceState(state);
	}

	private void init(Context context, AttributeSet attrs) {
		View root = LayoutInflater.from(context).inflate(R.layout.view_smart_edit_text, this, true);
		textInputLayout = root.findViewById(R.id.smartTextInputLayout);
		editText = root.findViewById(R.id.smartEditText);
		String editTextContent = "";
		String editTextHint = "";

		@ColorInt int editTextContentColor = Color.BLACK;
		@ColorInt int editTextHintColor = Color.GRAY;
		int editTextInputType = InputType.TYPE_CLASS_TEXT;
		int editTextMaxLength = 100;
		int editTextMaxLines = 10;
		int editTextSelection = 0;

		if (attrs != null) {
			TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SmartEditText, 0, 0);
			try {
				editTextContent = typedArray.getString(R.styleable.SmartEditText_editTextContent);
				editTextHint = typedArray.getString(R.styleable.SmartEditText_editTextHint);
				editTextContentColor = typedArray.getColor(R.styleable.SmartEditText_editTextContentColor, editTextContentColor);
				editTextHintColor = typedArray.getColor(R.styleable.SmartEditText_editTextHintColor, editTextHintColor);
				editTextInputType = typedArray.getInteger(R.styleable.SmartEditText_editTextInputType, editTextInputType);
				editTextMaxLength = typedArray.getInteger(R.styleable.SmartEditText_editTextMaxLength, editTextMaxLength);
				editTextMaxLines = typedArray.getInteger(R.styleable.SmartEditText_editTextMaxLines, editTextMaxLines);
				editTextSelection = typedArray.getInteger(R.styleable.SmartEditText_editTextSelection, editTextSelection);
			} finally {
				typedArray.recycle();
			}
		}
		setEditTextContent(editTextContent);
		setEditTextHintContent(editTextHint);
		setEditTextContentColor(editTextContentColor);
		setEditTextHintColor(editTextHintColor);
		setEditTextInputType(editTextInputType);
		setEditTextMaxLength(editTextMaxLength);
		setEditTextMaxLines(editTextMaxLines);
		setSelection(editTextSelection);
	}

	public void setTextWatcher(TextWatcher watcher) {
		editText.addTextChangedListener(watcher);
	}

	public void setEditTextMaxLines(int editTextMaxLines) {
		editText.setMaxLines(editTextMaxLines);
	}

	public void setEditTextMaxLength(int editTextMaxLength) {
		editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(editTextMaxLength)});
	}

	public void setEditTextInputType(int editTextInputType) {
		editText.setInputType(editTextInputType);
	}

	public void setEditTextHintColor(int editTextHintColor) {
		editText.setHintTextColor(editTextHintColor);
	}

	public void setEditTextContentColor(int editTextContentColor) {
		editText.setTextColor(editTextContentColor);
	}

	public void setSelection(int pos) {
		editText.setSelection(pos);
	}

	public void setEditTextHintContent(String editTextHint) {
		textInputLayout.setHint(editTextHint);
	}

	public Editable getEditTextContent() {
		return editText.getText();
	}

	public void setEditTextContent(String editTextContent) {
		editText.setText(editTextContent);
	}

	public void setEditTextEnabled(boolean value) {
		editText.setEnabled(value);
	}

	public void setEditTextCursorVisible(boolean value) {
		editText.setCursorVisible(value);
	}

	public void setOnEditTextTouchListener(OnTouchListener onTouchListener) {
		editText.setOnTouchListener(onTouchListener);
	}

	public void clearEditTextContent() {
		editText.getText().clear();
	}

	public void setOnEditTextClickListener(OnClickListener onClickListener){
		editText.setOnClickListener(onClickListener);
	}


}
