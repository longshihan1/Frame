package com.news.asframe.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/4/11.
 * 项目名称：AsFrame
 * 类描述：软键盘相关辅助类
 * 创建人：longshihan
 * 创建时间：2016/4/11 17:13
 * 修改人：Administrator
 * 修改时间：2016/4/11 17:13
 * 修改备注：
 * 邮箱： longshihan@163.com
 */
public class KeyBoardUtils {
    /**
     * 打卡软键盘
     *
     * @param mEditText
     *            输入框
     * @param mContext
     *            上下文
     */
    public static void openKeybord(EditText mEditText, Context mContext)
    {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText
     *            输入框
     * @param mContext
     *            上下文
     */
    public static void closeKeybord(EditText mEditText, Context mContext)
    {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
