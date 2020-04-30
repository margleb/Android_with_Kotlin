package com.example.myproject2

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // устанавливаем толщину кисти в соответствии с размером экрана
        drawing_view.setSizeForBrush(20.toFloat())

        // черный цвет (получаем позицию данного элемента)
        mImageButtonCurrentPaint = ll_paint_colors[1] as ImageButton
        // устанавливаем нажатое сосотояние кнопки
        mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_pressed))

        ib_brush.setOnClickListener{
            showBrushSizeChooserDialog()
        }
        ib_gallery.setOnClickListener{
            if(isReadStorageAllowed()) {
                val pickPhotoIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(pickPhotoIntent, GALLERY)
            } else {
                // запрос на получение разрешения
                requestStoragePermission()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            if(requestCode== GALLERY) {
                // заменяем изображение
                try{
                    if(data!!.data != null) {
                        // устанавливаем изображение
                        iv_background.visibility = View.VISIBLE
                        iv_background.setImageURI(data.data)
                    } else {
                        Toast.makeText(this@MainActivity, "Error in parsing the image or its corrupeted.", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun showBrushSizeChooserDialog() {
        // создает диалоговое окно по умолчанию
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallBtn = brushDialog.ib_small_brush
        val mediumBtn = brushDialog.ib_medium_brush
        val largeBtn = brushDialog.ib_large_brush
        // устанавливаем размер кисти на 10
        smallBtn.setOnClickListener{
            drawing_view.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        mediumBtn.setOnClickListener{
            drawing_view.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        largeBtn.setOnClickListener{
            drawing_view.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }

    fun paintClicked(view: View) {
        // если кнопка не была выбрана
        if(view !== mImageButtonCurrentPaint) {
            val imageButton = view as ImageButton
            // прочитываем цвет кнопки
            var colorTag = imageButton.tag.toString()
            drawing_view.setColor(colorTag)
            // устанавливаем нажаетое состояние
            imageButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_pressed))
            // а у предыдущей отключаем состояния нажатой
            mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pallet_normal))
            // устанавливаем новую кнопку как текущую
            mImageButtonCurrentPaint = view
        }
    }

    companion object{
        private const val STORAGE_PERMISSION_CODE = 1
        private const val GALLERY = 2
    }

    // запрос разрешения
    private fun requestStoragePermission() {
        // проверка на требование запроса разрешения
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE).toString())) {
            Toast.makeText(this, "Need permission to add a Background", Toast.LENGTH_SHORT).show()
        }
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), STORAGE_PERMISSION_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == STORAGE_PERMISSION_CODE) {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Permission granded now you can read the storage files", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this@MainActivity, "You just denide the permission", Toast.LENGTH_LONG).show()
        }
    }

    // проверка на разршение
    private fun isReadStorageAllowed():Boolean {
        var result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
    }

}
