package kr.ac.kpu.aloha

import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_home.*

class homeActivity : AppCompatActivity() {
    lateinit var mr: MediaRecorder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var path:String = Environment.getExternalStorageDirectory().toString() + "/myrec.3gp" //파일의 저장 위치

        mr = MediaRecorder()
        button.isEnabled = false
        button2.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED) //권한을 요청하고 요청이 수행이 되면 그 button이 활성화가 되는 것을 의미하는 함수
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO,android.Manifest.permission.WRITE_EXTERNAL_STORAGE),111)

        button.isEnabled = true

        //스타트 버튼 클릭
        button.setOnClickListener{
            mr.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP) //저장할 파일의 확장자를 정해주는 것
            mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            mr.setOutputFile(path)
            mr.prepare()
            mr.start()
            button2.isEnabled = true
            button.isEnabled = false
        }

        //정지 버튼 클릭
        button2.setOnClickListener{
            mr.stop()
            button.isEnabled = true //정지가 눌리면 시작버튼은 비활성화

        }

        //재생 버튼 클릭
        button3.setOnClickListener{
            var mp = MediaPlayer()
            mp.setDataSource(path)
            mp.prepare()
            mp.start()

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            button.isEnabled = true
    }

}