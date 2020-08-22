/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.platform

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("app:imageUrl")
fun loadImage(imageView: ImageView, url: String?) {

    if (url == null) return

    Glide.with(imageView.context)
        .applyDefaultRequestOptions(
            RequestOptions()
//                .error(R.drawable.ic_default)
//                .placeholder(R.drawable.ic_default)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
        )
        .load(url)
        .into(imageView)
}