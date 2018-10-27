package com.example.iyemon018.fragmentsample001

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * Created by iyemon018 on 2018/10/27.
 */
class MyFragment : Fragment() {

    /**
     * Fragment のライフサイクル
     *  onAttach    // Fragment とActivity が関連付けられた。
     *              // getActivity の戻り値は null になる。
     *  ↓
     *  onCreate    // 初期化処理のタイミング
     *  ↓
     *  onCreateView
     *  ↓
     *  onActivityCreated
     *  ↓
     *  onStart     // この時点ではまだ描画されていない。
     *  ↓
     *  onResume    // ここで描画されたことになる。
     *  ↓
     *  onPause     // この時点ではまだ描画されている。
     *  ↓
     *  onStop      // この時点で非表示になる。
     *  ↓
     *  onSavedInstance // Activity でもあった必要な情報の保存タイミング
     *                  // ここで保存した情報は、onCreate ～ onActivityCreated のBundle 引数から取り出す。
     *  ↓
     *  onDestroyView   // これ以降は不要なリソースの開放に使用する。
     *  ↓
     *  onDestroy
     *  ↓
     *  onDetach
     */

    private var _listener: OnFragmentInteractionListener? = null

    /**
     * このFragment のビューが作成されるタイミングで呼ばれます。
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater でFragment が使用するレイアウトを決定する。
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    /**
     * このFragment のビューが作成されたあとに呼ばれます。
     * 順番的にはonCreateView → onViewCreated の順序で呼ばれる。
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ここではサンプルとしてボタンを押したときにリスナーを呼び出す。
        view.findViewById<Button>(R.id.button).setOnClickListener { v -> _listener?.onFragmentInteraction() }
    }

    /**
     * このFragment が何らかのコンポーネントにアタッチした場合に呼ばれる。
     * リスナーの初期化はここで行うのがセオリー
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnFragmentInteractionListener) _listener = context
        else {
            throw RuntimeException("${context.toString()} に${OnFragmentInteractionListener::class.java.simpleName} を実装してください。")
        }
    }

    /**
     * onAttach で初期化した内容はここで開放する。
     */
    override fun onDetach() {
        super.onDetach()
        _listener = null
    }
}