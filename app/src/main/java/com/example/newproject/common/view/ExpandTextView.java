package com.example.newproject.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newproject.R;

/**
 * Created by Administrator on 2019/11/27 0027.
 */

public class ExpandTextView extends LinearLayout {
    public static final int DEFAULT_MAX_LINES = 3;
    private TextView contentText;
    private TextView textPlus;
    private int showLines;
    private ExpandStatusListener expandStatusListener;
    private boolean isExpand;

    public ExpandTextView(Context context) {
        super(context);
        initView();
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        initView();
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        initView();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ExpandTextView, 0, 0);
        try {
            showLines = typedArray.getInt(R.styleable.ExpandTextView_showLines, DEFAULT_MAX_LINES);
        }finally {
            typedArray.recycle();
        }
    }

    private void initView() {
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_magic_text, this);
        contentText = (TextView) findViewById(R.id.contentText);
        if(showLines > 0){
            contentText.setMaxLines(showLines);
        }

        textPlus = (TextView) findViewById(R.id.textPlus);
        textPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String textStr = textPlus.getText().toString().trim();
                if("??????".equals(textStr)){
                    contentText.setMaxLines(Integer.MAX_VALUE);
                    textPlus.setText("??????");
                    setExpand(true);
                }else{
                    contentText.setMaxLines(showLines);
                    textPlus.setText("??????");
                    setExpand(false);
                }
                //???????????????????????????
                if(expandStatusListener != null){
                    expandStatusListener.statusChange(isExpand());
                }
            }
        });
    }

    public void setText(final CharSequence content){

        //???????????????contentText????????????????????????
        contentText.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                // ??????????????????
                contentText.getViewTreeObserver().removeOnPreDrawListener(this);
                //???????????????????????????
                int linCount = contentText.getLineCount();
                if(linCount > showLines){

                    if(isExpand){
                        contentText.setMaxLines(Integer.MAX_VALUE);
                        textPlus.setText("??????");
                    }else{
                        contentText.setMaxLines(showLines);
                        textPlus.setText("??????");
                    }
                    textPlus.setVisibility(View.VISIBLE);
                }else{
                    textPlus.setVisibility(View.GONE);
                }
                return true;
            }


        });
        contentText.setText(content);
    }

    public void setExpand(boolean isExpand){
        this.isExpand = isExpand;
    }

    public boolean isExpand(){
        return this.isExpand;
    }

    public void setExpandStatusListener(ExpandStatusListener listener){
        this.expandStatusListener = listener;
    }

    public interface ExpandStatusListener{
        void statusChange(boolean isExpand);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return textPlus.dispatchTouchEvent(event);
    }
}
