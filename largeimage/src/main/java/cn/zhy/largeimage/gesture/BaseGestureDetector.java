package cn.zhy.largeimage.gesture;

import android.content.Context;
import android.view.MotionEvent;
/**
* 手势基类
* @author zhengy
* create at 2019/9/24 上午10:11
**/
public abstract class BaseGestureDetector {

    protected boolean mGestureInProgress;
    protected MotionEvent mPreMotionEvent;
    protected MotionEvent mCurrentMotionEvent;

    protected Context mContext;

    public BaseGestureDetector(Context mContext) {
        this.mContext = mContext;
    }

    public boolean onTouchEvent(MotionEvent event){
        if(!mGestureInProgress){
            handleStartProgressEvent(event);
        }else {
            handleInProgressEvent(event);
        }
        return true;
    }

    protected abstract void handleInProgressEvent(MotionEvent event);

    protected abstract void handleStartProgressEvent(MotionEvent event);

    protected abstract void updateStateByEvent(MotionEvent event);

    protected void resetState(){
        if(mPreMotionEvent != null){
            mPreMotionEvent.recycle();
            mPreMotionEvent = null;
        }
        if(mCurrentMotionEvent != null){
            mCurrentMotionEvent.recycle();
            mCurrentMotionEvent =null;
        }
        mGestureInProgress = false;
    }
}
