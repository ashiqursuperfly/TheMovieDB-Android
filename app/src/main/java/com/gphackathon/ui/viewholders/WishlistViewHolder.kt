package com.gphackathon.ui.viewholders

import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.Const
import com.gphackathon.data.db.AppDB
import com.gphackathon.data.models.local.WishlistEntity
import com.gphackathon.databinding.RowWishlistBinding
import com.gphackathon.util.helper.DateUtil
import com.gphackathon.util.helper.load


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class WishlistViewHolder(
    private val binding: RowWishlistBinding
) : BaseViewHolder<WishlistEntity, WishlistEntity.OnClick>(binding.root) {

    val wishlistDb = AppDB.getInstance().wishlistDao()

    override fun onBind() {
        mItem?.let {
            binding.tvName.text = it.name
            try {
                binding.tvDate.text = DateUtil.convertDateFormats(it.date, "yyyy-M-dd", Const.DATE_FORMAT)
            }catch (e: Exception) {
                binding.tvDate.text = it.date
            }

            binding.tvType.text = it.type
            binding.image.load(it.getPosterImageUrl())

            binding.btnRemoveFromWishlist.setOnClickListener { _ ->
                wishlistDb.delete(it)
                mCallback?.onDelete(it)
            }

            setClickListener(binding.container)
        }
    }

}