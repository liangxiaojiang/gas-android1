package com.joe.oil.parolmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.joe.oil.R;
import com.joe.oil.util.BasePopupWindow;


public class MeasureWindow extends BasePopupWindow implements
		OnClickListener {

	private LinearLayout mBarCodeButton;
	private LinearLayout mCameraButton;
	private LinearLayout mColorButton;

	private onSearchBarItemClickListener mOnSearchBarItemClickListener;

	public MeasureWindow(Context context, int width, int height) {
		super(LayoutInflater.from(context).inflate(
				R.layout.popwin_button, null), width, height);
	}

	@Override
	public void initViews() {
		mBarCodeButton = (LinearLayout) findViewById(R.id.search_barcode_btn);
		mCameraButton = (LinearLayout) findViewById(R.id.search_camera_btn);
		mColorButton = (LinearLayout) findViewById(R.id.color_shopping_btn);
	}

	@Override
	public void initEvents() {
		mBarCodeButton.setOnClickListener(this);
		mCameraButton.setOnClickListener(this);
		mColorButton.setOnClickListener(this);
	}

	@Override
	public void init() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.search_barcode_btn:
			if (mOnSearchBarItemClickListener != null) {
				mOnSearchBarItemClickListener.onBarCodeButtonClick();
			}
			break;

		case R.id.search_camera_btn:
			if (mOnSearchBarItemClickListener != null) {
				mOnSearchBarItemClickListener.onCameraButtonClick();
			}
			break;

		case R.id.color_shopping_btn:
			if (mOnSearchBarItemClickListener != null) {
				mOnSearchBarItemClickListener.onColorButtonClick();
			}
			break;
		}
		dismiss();
	}

	public void setOnSearchBarItemClickListener(
			onSearchBarItemClickListener listener) {
		mOnSearchBarItemClickListener = listener;
	}


	public interface onSearchBarItemClickListener {
		void onBarCodeButtonClick();

		void onCameraButtonClick();

		void onColorButtonClick();
	}
}
