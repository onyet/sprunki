package id.onyet.games.sprunki.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.onyet.games.sprunki.R
import id.onyet.games.sprunki.model.Game

class GameAdapter(
    private val games: List<Game>,
    private val onGameClick: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnail: ImageView = itemView.findViewById(R.id.gameThumbnail)
        val name: TextView = itemView.findViewById(R.id.gameName)
        val playButton: View = itemView.findViewById(R.id.playButton)

        fun bind(game: Game) {
            name.text = game.name
            
            Glide.with(itemView.context)
                .load(game.thumbnail)
                .apply(RequestOptions().transform(RoundedCorners(24)))
                .placeholder(R.drawable.placeholder_game)
                .error(R.drawable.placeholder_game)
                .into(thumbnail)

            itemView.setOnClickListener { onGameClick(game) }
            playButton.setOnClickListener { onGameClick(game) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount(): Int = games.size
}
