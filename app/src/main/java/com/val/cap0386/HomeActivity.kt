package com.`val`.cap0386

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.`val`.cap0386.ml.Model
import kotlinx.android.synthetic.main.activity_home.*
import org.tensorflow.lite.DataType
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var tflite:Interpreter

        fun loadModelFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer {
            val fileDescriptor = assetManager.openFd(modelPath)
            val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
            val fileChannel = inputStream.channel
            val startOffset = fileDescriptor.startOffset
            val declaredLength = fileDescriptor.declaredLength
            return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
        }

        //var aa = loadModelFile(assets, "model.tflite")

        fun inference(){
            var inputvalue = FloatArray(3)
            //inputvalue[0] = inp1.toFloat()
            //inputvalue[1] = inp2.toFloat()
            //inputvalue[2] = inp3.toFloat()
            //aa.run()
        }

        btnPredict.setOnClickListener {
            var inp1 = txtCurah2.text.toString().toFloat()
            var inp2 = txtKelembaban2.text.toString().toFloat()
            var inp3 = txtSuhu2.text.toString().toFloat()

            var inputvalue = FloatArray(3)
            inputvalue[0] = inp1
            inputvalue[1] = inp2
            inputvalue[2] = inp3

            var byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(3)
            byteBuffer.putFloat(inp1)
            byteBuffer.putFloat(inp2)
            byteBuffer.putFloat(inp3)

            val model = Model.newInstance(this)
            val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 3), DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)
            val outputs = model.process(inputFeature0)
            val outputFeature0 = outputs.outputFeature0AsTensorBuffer

            txtHasil.setText(outputFeature0.toString())

            model.close()
        }

    }
}