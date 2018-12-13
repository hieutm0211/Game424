package com.example.hieutm.game424;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Guide extends Activity {
    TextView tv_guide;
    @Override
    protected void onCreate(final Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.guide);
        tv_guide = (TextView)findViewById(R.id.tv_guide);

        tv_guide.setText("Người chơi sẽ có một bảng các con số ngẫu nhiên trên màn hình.\n" +
                " Nhiệm vụ của người chơi là tính tổng các con số sao cho bằng với con số màu xanh." +
                " Nếu chọn chính xác, game sẽ mất đi các con số đó và người chơi sẽ được cộng điểm và tăng thời gian chơi. " +
                "Nếu sai thì người chơi sẽ không được cộng điểm nào cả và cũng không được tăng thời gian chơi.\n" +
                "\tNhưng từ lv5 trở đi, game sẽ có xác xuất xuất hiện ô xui xẻo. Nếu người chơi chọn đúng ô xui xẻo mà không cần đúng hay sai, các ô còn lại sẽ có xác suất thay đổi ngẫu nhiên giá trị, xuất hiện thêm ô mới, giảm thời gian chơi đi 15%.\n" +
                "\tBù lại cũng có những ô may mắn giúp người chơi tăng điểm, tăng thời gian chơi thêm 10%,...");
    }
}
