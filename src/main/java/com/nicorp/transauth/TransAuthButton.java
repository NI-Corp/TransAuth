package com.nicorp.transauth;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class TransAuthButton extends LinearLayout {

    private ImageView icon;
    private ConstraintLayout custom_button;

    public TransAuthButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.transauth_button, this, true);
        icon = findViewById(R.id.custom_button_icon);
        custom_button = findViewById(R.id.custom_button);

        custom_button.setOnClickListener(v -> {
            // Start TransAuthService
//            TransAuthService transAuthService = new TransAuthService();

            // Go to TransAuthActivity
            Intent intent = new Intent(context, TransAuthActivity.class);
            context.startActivity(intent);
            

        });

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomButton, 0, 0);

        try {
            icon.setImageResource(typedArray.getResourceId(R.styleable.CustomButton_cb_icon, 0));
            int backgroundColor = typedArray.getColor(R.styleable.CustomButton_cb_backgroundColor, 0);
            float cornerRadius = typedArray.getDimension(R.styleable.CustomButton_cb_cornerRadius, 0);

            GradientDrawable background = new GradientDrawable();
            background.setColor(backgroundColor);
            background.setCornerRadius(cornerRadius);
            setBackground(background);
        } finally {
            typedArray.recycle();
        }
    }
}