package com.example.android.common.baservadapter

import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.android.common.baseconstants.BaseCodes

abstract class BaseRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // comment by srdpatel: 2/2/2021 If viewType is loading or shimmer, we have the control here.
        when (viewType) {
            BaseCodes.VIEW_TYPE_LOADING -> {

            }
            BaseCodes.VIEW_TYPE_SHIMMER -> {

            }
            BaseCodes.VIEW_TYPE_ITEM -> {

            }
        }
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        TODO("Not yet implemented")
    }

    open fun <E> onItemSelected(position: Int, item: E) {

    }

    open fun <E> onItemChecked(position: Int, item: E) {

    }

    open fun <E> onItemUnSelected(position: Int, item: E) {

    }

    open fun <E> onItemUnchecked(position: Int, item: E) {

    }

    open fun <E> onItemAdded(position: Int, item: E) {

    }

    open fun <E> onItemRemoved(position: Int, item: E) {

    }

    open fun showShimmers() {

    }

    open fun hideShimmer() {

    }

    open fun showLoading() {

    }

    open fun hideLoading() {

    }

    open fun setHasShimmers() {

    }

    open fun <E> addItem(item: E, onTop: Boolean = false) {

    }

    open fun <E> addItem(item: E, index: Int) {

    }

    open fun addItemList() {

    }

    open fun <E> addItemList(pageNumber: Int, itemList: List<E>, onTop: Boolean = false) {

    }

    open fun clearItemList() {

    }

    open fun resetData() {

    }

    open fun resetItemList() {

    }

    open fun removeItem() {

    }

    open fun removeItemList() {

    }

    open fun setClickListeners() {

    }

    fun onClickItem() {

    }

    fun onSelectItem() {

    }

    open fun setIsSelectable() {

    }

    open fun setSingleSelection() {

    }

    open fun setMultipleSelection() {

    }

    open fun removeSelection() {

    }

    open fun setItemList() {

    }

    open fun filterItems() {

    }

    open fun updateList() {

    }

    open fun updateItem(index: Int) {

    }

    open fun toggleSelection() {

    }

    open fun toggleSelectionList() {

    }

    open fun replaceList() {

    }

    open fun replaceItem() {

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}