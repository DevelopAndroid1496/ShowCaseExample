package com.example.showcaseviewexample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class HighlightOverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    enum class ShapeType {
        CIRCLE, RECTANGLE
    }

    private val paint = Paint().apply {
        color = 0xAA000000.toInt() // Color semitransparente para el fondo oscuro
    }

    private val path = Path()
    private var highlightX = 0f
    private var highlightY = 0f
    private var highlightRadius = 200f // Ajusta el tamaño del área destacada
    private var highlightRect = RectF(0f, 0f, 0f, 0f) // Rectángulo del área destacada
    private var shapeType = ShapeType.RECTANGLE


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Dibuja el fondo oscuro
        path.reset()
        path.addRect(0f, 0f, width.toFloat(), height.toFloat(), Path.Direction.CW)


        when (shapeType) {
            ShapeType.RECTANGLE -> {
                // Dibuja un rectángulo transparente
                path.addRect(highlightRect, Path.Direction.CCW)
            }

            ShapeType.CIRCLE -> {
                // Dibuja un círculo transparente
                path.addCircle(highlightX, highlightY, highlightRadius, Path.Direction.CCW)
            }
        }

        // Recorta el área destacada con una combinación de diferencias
        canvas.drawPath(path, paint)
    }

    fun setHighlightCircleArea(x: Float, y: Float, radius: Float) {
        shapeType = ShapeType.CIRCLE
        highlightX = x
        highlightY = y
        highlightRadius = radius
        invalidate() // Redibuja la vista
    }

    fun setHighlightRectangleArea(left: Float, top: Float, right: Float, bottom: Float) {
        shapeType = ShapeType.RECTANGLE
        highlightRect.set(left, top, right, bottom)
        invalidate() // Redibuja la vista
    }
}
