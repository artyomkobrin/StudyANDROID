package com.fad.android.geoquiz;

/**
 * Created by Artsiom_Levaniuk on 6/6/2017.
 */

public class Question {
    private int mTextResId;
    private boolean mAnsverTrue;

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnsverTrue() {
        return mAnsverTrue;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public void setAnsverTrue(boolean ansverTrue) {
        mAnsverTrue = ansverTrue;
    }

    public Question(int TextResId, boolean AnsverTrue){
        mTextResId = TextResId;
        mAnsverTrue = AnsverTrue;
    }


}
