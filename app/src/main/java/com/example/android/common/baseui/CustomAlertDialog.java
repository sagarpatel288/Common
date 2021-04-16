package com.example.android.common.baseui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;

import com.example.android.common.R;
import com.example.android.common.baselisteners.Callbacks;
import com.example.android.common.baseutils.ScreenUtils;


public class CustomAlertDialog extends DialogFragment {

    CustomButton btnTvTitle;
    CustomButton btnTvContentMsg;
    CustomButton btnLeft;
    CustomButton btnRight;

    //Interface callback to notify which option end user has selected from this dialog
    private Callbacks.OnDialogBtnClick onDialogBtnClick;
    //title to be set as the title of this dialog
    private String title;
    //content to be set for this dialog
    private String contentMsg;
    //text on left button to be set
    private String btnLeftText;
    //text on right button to be set
    private String btnRightText;

    /**
     * Gives the {@link #titleColor} to be set as {@link AppCompatTextView#setTextColor(int)}
     *
     * @since 1.0
     */
    public int getTitleColor() {
        return titleColor;
    }

    /**
     * Sets the {@link #titleColor} as {@link AppCompatTextView#setTextColor(int)} on {@link #btnTvTitle}
     *
     * @since 1.0
     */
    public CustomAlertDialog setTitleColor(int titleColor) {
        this.titleColor = titleColor;
        return this;
    }

    //color to set for alert dialog title
    private int titleColor;

    /**
     * Gives the {@link #title} to be set as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnTvTitle}
     *
     * @since 1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the {@link #title} as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnTvTitle}
     *
     * @since 1.0
     */
    public CustomAlertDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gives the {@link #contentMsg} to be set as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnTvContentMsg}
     *
     * @since 1.0
     */
    public String getContentMsg() {
        return contentMsg;
    }

    /**
     * Sets the {@link #contentMsg} as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnTvContentMsg}
     *
     * @since 1.0
     */
    public CustomAlertDialog setContentMsg(String contentMsg) {
        this.contentMsg = contentMsg;
        return this;
    }

    /**
     * Gives the {@link #btnLeftText} to be set as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnLeft}
     *
     * @since 1.0
     */
    public String getBtnLeftText() {
        return btnLeftText;
    }

    /**
     * Sets the {@link #btnLeftText} as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnLeft}
     *
     * @since 1.0
     */
    public CustomAlertDialog setBtnLeftText(String btnLeftText) {
        this.btnLeftText = btnLeftText;
        return this;
    }

    /**
     * Gives the {@link #btnRightText} to be set as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnRight}
     *
     * @since 1.0
     */
    public String getBtnRightText() {
        return btnRightText;
    }

    /**
     * Sets the {@link #btnRightText} as {@link AppCompatTextView#setText(CharSequence)} on {@link #btnRight}
     *
     * @since 1.0
     */
    public CustomAlertDialog setBtnRightText(String btnRightText) {
        this.btnRightText = btnRightText;
        return this;
    }

    /**
     * Sets the {@link Callbacks.OnDialogBtnClick} as interface callback on this dialog fragment
     *
     * @since 1.0
     */
    public CustomAlertDialog setOnDialogBtnClick(Callbacks.OnDialogBtnClick onDialogBtnClick) {
        this.onDialogBtnClick = onDialogBtnClick;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_alert, container);
        setValues();
        getDialog().setCanceledOnTouchOutside(false);
        return view;
    }

    /**
     * Sets the values on views
     *
     * @since 1.0
     */
    private void setValues() {
        if (getTitleColor() != 0) {
            btnTvTitle.setBtnTxtColor(getTitleColor());
        }
        btnTvTitle.setText(getTitle());
        btnLeft.setText(getBtnLeftText());
        btnRight.setText(getBtnRightText());
        btnTvContentMsg.setText(getContentMsg());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getShowsDialog()) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.dimAmount = 0.60f; //Existed background host screen will be dimmed by given float value. Hight the float value, higher it will be dimmed.
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND; //Requires this flag to dim host
            window.setAttributes(layoutParams);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //To remove default rectangle background
            window.setLayout((int) (ScreenUtils.getScreenWidthHeight(getActivity())[0] * 0.90), WindowManager.LayoutParams.WRAP_CONTENT); //Sets width and height of this dialog as per given value
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_left) {
            if (onDialogBtnClick != null) {
                onDialogBtnClick.onLeftBtnClick();
            }
            dismiss();
        } else if (id == R.id.btn_right) {
            if (onDialogBtnClick != null) {
                onDialogBtnClick.onRightBtnClick();
            }
            dismiss();
        }
    }
}
