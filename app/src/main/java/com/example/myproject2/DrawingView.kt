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
import android.view.MotionEvent
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
    // сохранение пути
    private val mPaths = ArrayList<CustomPath>()

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

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // при изменении размера экрана создается растровое изображение
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        // создает холст с указанным растровым изображением для рисования.
        canvas = Canvas(mCanvasBitmap!!)
    }

    // Changes Canvas to Canvas? if fails
    // Указывает вконце что происходит при рисовании
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // рисуйте указанное растровое изображение с его верхним / левым углом в (x, y), используя указанную краску
        canvas.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)

        for(path in mPaths) {
            // указываем стиль кисти
            mDrawPaint!!.strokeWidth = path.brushThicness
            //  Возращает цвет краски в sRGB
            mDrawPaint!!.color = path.color
            canvas.drawPath(path, mDrawPaint!!)
        }

        // рисуем путь
        if(!mDrawPath!!.isEmpty) {
            // указываем стиль кисти
            mDrawPaint!!.strokeWidth = mDrawPath!!.brushThicness
            //  Возращает цвет краски в sRGB
            mDrawPaint!!.color = mDrawPaint!!.color
            // рисует указанный путь, используя указанную краску
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }
    }

    // MotionEvent - Объект, используемый для сообщения о событиях движения (мышь, ручка, палец, трекбол).
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // получаем значение координат x/y
        val touchX = event?.x
        val touchY = event?.y
        when(event?.action) {
            // начальная позиция прорисовки
            MotionEvent.ACTION_DOWN -> {
                mDrawPath!!.color = color
                mDrawPath!!.brushThicness = mBrushSize
                // Удаляет все линии и кривые с пути, сделав его пустым.
                mDrawPath!!.reset()
                // перемещение по оси x/y
                mDrawPath!!.moveTo(touchX!!, touchY!!)
            }
            // во время движения
            MotionEvent.ACTION_MOVE -> {
                // добавить линию от начальной до конечной точки
                mDrawPath!!.lineTo(touchX!!, touchY!!)
            }
            // конечная точка прорисовки
            MotionEvent.ACTION_UP -> {
                mPaths.add(mDrawPath!!)
                mDrawPath = CustomPath(color, mBrushSize)
            }
            else -> return false
        }
        // проверяет на видимость view
        invalidate()
        return true
    }
}