package edu.rosehulman.historicaldocs

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DocListFragment.OnDocSelectedListener] interface
 * to handle interaction events.
 *
 */
class DocListFragment : Fragment() {
    private var listener: OnDocSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val recyclerView= inflater.inflate(R.layout.fragment_doc_list, container, false) as RecyclerView
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter =DocListAdapter(activity, listener)
        return recyclerView
    }

    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDocSelectedListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnDocSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnDocSelectedListener {
        // TODO: Update argument type and name
        fun OnDocSelectedListener(doc:Doc)
    }
    // TODO: MainActivity implements this interface

}
