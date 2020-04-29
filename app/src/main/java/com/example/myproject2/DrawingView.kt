package com.example.myproject2

// Интерфейс для глобальной информации о среде приложения
import android.content.Context
import android.graphics.*
// растровое изображение
// Класс Color предоставляет методы для создания, преобразования и * манипулирования цветами
// Класс Paint содержит информацию о стиле и цвете для рисования геометрии, текста и растровых изображений.
// Класс Path инкапсулирует составные (многоконтурные) геометрические пути
// Коллекция атрибутов, найденная связанной с тегом в документе XML *
import android.util.AttributeSet
// Этот класс представляет основной строительный блок для компонентов пользовательского интерфейса
import android.view.View

// необходимо использовать Viеw класс для отрисовки чего либо на экран
class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs) {

    // путь отрисовки
    private var mDrawPath:CustomPath? = null
    // растровое изображение
    private var mCanvasBitmap:Bitmap? = null
    // информация о стиле, цвете, геометрии т.д.
    private var mDrawPaint: Paint? = null
    // холст
    private var mCanvasPaint:Paint? = null
    // толщина кисти
    private var mBrushSize:Float = 0.toFloat()
    // цвет кисти
    private var color = Color.BLACK
    // белвый фон для отрисовки
    private var canvas:Canvas? = null


    init {
        setUpDrawing()
    }

    internal inner class CustomPath(var color:Int, var brushThicness:Float) : Path(){

    }

    private fun setUpDrawing() {
        mDrawPath = CustomPath(color,mBrushSize)
        // инициализируем и устанавливаем свой-ва
        mDrawPaint = Paint()
        mDrawPaint!!.color = color
        mDrawPaint!!.style = Paint.Style.STROKE
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        // cтиль линии
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        mCanvasPaint = Paint(Paint.DITHER_FLAG)
        mBrushSize = 20.toFloat()
    }

}