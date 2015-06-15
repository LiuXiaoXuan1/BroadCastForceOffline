package com.xiaoxuan.broadcastforceexit.ui.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import com.xiaoxuan.broadcastforceexit.entities.ActivityCollector;
import com.xiaoxuan.broadcastforceexit.ui.activities.LoginActivity;

/**
 * Created by xiaoxuan on 2015/6/15.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

    /**
     * 接收广播后在onReceive方法中写逻辑
     */
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);//创建对话框
        dialogBuilder.setTitle("警告");
        dialogBuilder.setMessage("你已被迫下线，请重新登录");
        //注意这里一定要调用setCancelable方法，否则用户按一下Back键就可以关闭对话框继续使用程序
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();//销毁所有活动
                Intent intent = new Intent(context, LoginActivity.class);
                //因为此活动是在广播接收器里启动的，所以必须加入此标志，不然关闭按钮后会异常退出
                //接上翻译:而不是返回到登录页面
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);//返回登录页面
            }
        });
        //需要设置AlertDialog的类型，保证在广播接收器中正常弹出
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
