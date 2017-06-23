package com.example.merxu.shoushijianting;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 手势监听
 * 
 * @author zihao
 * 
 */
public class MainActivity extends Activity implements OnTouchListener,
		OnGestureListener {
	// 创建一个用于识别收拾的GestureDetector对象
	@SuppressWarnings("deprecation")
	private GestureDetector detector = new GestureDetector(this);
	// 新建一个LinearLayout布局对象，这里是指主页面的布局
	private LinearLayout myLayout;
	// 限制最小移动像素
	private int FLING_MIN_DISTANCE = 110;
	// 定义的Toast提示框显示时间
	private int TIME_OUT = 1000;
	private static final String TAG = "Main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myLayout = (LinearLayout) findViewById(R.id.test_layout);
		// 为布局绑定监听
		myLayout.setOnTouchListener(this);
	}

	/**
	 * 手势滑动时别调用
	 */
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒
		if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE) {
			// 向左滑动
			Toast.makeText(this, "向左滑动", Toast.LENGTH_LONG).show();
		} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE) {
			// 向右滑动
			Toast.makeText(this, "向右滑动", Toast.LENGTH_LONG).show();
		}
		return false;
	}

	/**
	 * 长按时被调用
	 */
	@Override
	public void onLongPress(MotionEvent e) {
		Log.d(TAG, "触发长按回调");
	}

	/**
	 * 滚动时调用
	 */
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	/**
	 * 在按下动作时被调用
	 */
	@Override
	public boolean onDown(MotionEvent e) {
		Log.d(TAG, "按下回调");
		return false;
	}

	/**
	 * 按住时被调用
	 */
	@Override
	public void onShowPress(MotionEvent e) {
		Log.d(TAG, "按住不松回调");
	}

	/**
	 * 抬起时被调用
	 */
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		Log.d(TAG, "触发抬起回调");
		return false;
	}

	/**
	 * 重写OnTouchListener的onTouch方法 此方法在触摸屏被触摸，即发生触摸事件（接触和抚摸两个事件）的时候被调用
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		detector.onTouchEvent(event);
		return true;
	}
}
