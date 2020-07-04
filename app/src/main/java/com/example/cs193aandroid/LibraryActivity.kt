package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Picasso.get()
            .load("https://m.baidu.com/sf/vsearch?pd=image_content&word=%E5%9B%BE%E6%A0%87&tn=vsearch&atn=mediacy&fr=alawise&sa=vs_ala_img&imgtype=0&imgpn=1&imgspn=0&imgcontent=%7B%22subjectJson%22%3A%7B%7D%7D&mediacyKey=undefined&tt=1&di=33000&pi=0&cs=2574324515%2C2446667376&adpicid=&bdtype=0&objurl=https%3A%2F%2Ftimgsa.baidu.com%2Ftimg%3Fimage%26quality%3D80%26size%3Db9999_10000%26sec%3D1593861696419%26di%3D3a743da2a3a9cbe5197eb2b160363fd7%26imgtype%3D0%26src%3Dhttp%253A%252F%252Fimg.zcool.cn%252Fcommunity%252F01b4e456f396e86ac7257d2069a793.jpg%25401280w_1l_2o_100sh.jpg&imgos=1630291670%2C417118898&imgis=0%2C0&isRecFrClick=0")
            .into(photo_image)
    }
}