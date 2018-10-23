package com.example.iyemon018.lifecyclesample001

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout

/**
 * Created by iyemon018 on 2018/10/23.
 */
class MyCustomView : LinearLayout {
    companion object {
        /**
         * インジケーターの数
         */
        const val INDICATOR_COUNT: Int = 3
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initializeView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * レイアウトを初期化する。
     */
    private fun initializeView(context: Context?, attrs: AttributeSet?) {

        // ここでこのクラスが使用するレイアウトを決定する。
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.three_starts_indicator, this)
        if (attrs == null) return

        // three_starts_attrs.xml に定義したスタイルを取得する。
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView)
        selected = typedArray.getInteger(0, 0)
        typedArray.recycle()
    }

    /**
     * inflate が完了するタイミングでコールバックされる。
     */
    override fun onFinishInflate() {
        super.onFinishInflate()

        this._star1 = findViewById(R.id.star1)
        this._star2 = findViewById(R.id.star2)
        this._star3 = findViewById(R.id.star3)

        setSelected(selected, true)
    }

    /**
     * 指定された番号を選択する。
     *
     * @param   selecte: 指定する番号（0 を最も左の値とする。）
     * @param   force: true を設定すると強制的に値を反映する。
     */
    fun setSelected(selected: Int, force: Boolean) {

        // 各ImageView の画像を差し替える。
        _star1.setImageResource(R.mipmap.star_empty)
        _star2.setImageResource(R.mipmap.star_empty)
        _star3.setImageResource(R.mipmap.star_empty)

        when (selected) {
            0 -> _star1.setImageResource(R.mipmap.star)
            1 -> _star2.setImageResource(R.mipmap.star)
            2 -> _star3.setImageResource(R.mipmap.star)
            else -> {
            }
        }

        this.selected = selected
    }

    private lateinit var _star1: ImageView

    private lateinit var _star2: ImageView

    private lateinit var _star3: ImageView

    /**
     * 選択されている番号
     */
    var selected: Int = 0
        get() = field
        private set(value) {
            field = value
        }
}