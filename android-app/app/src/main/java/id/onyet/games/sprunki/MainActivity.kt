package id.onyet.games.sprunki

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.onyet.games.sprunki.adapter.GameAdapter
import id.onyet.games.sprunki.model.Game
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter
    private var games: List<Game> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.gamesRecyclerView)
        
        loadGames()
        setupRecyclerView()
    }

    private fun loadGames() {
        try {
            val inputStream = resources.openRawResource(R.raw.games)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val jsonString = reader.use { it.readText() }
            
            val type = object : TypeToken<List<Game>>() {}.type
            games = Gson().fromJson(jsonString, type)
        } catch (e: Exception) {
            e.printStackTrace()
            games = emptyList()
        }
    }

    private fun setupRecyclerView() {
        gameAdapter = GameAdapter(games) { game ->
            openGame(game)
        }
        
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = gameAdapter
            setHasFixedSize(true)
        }
    }

    private fun openGame(game: Game) {
        val intent = Intent(this, GameActivity::class.java).apply {
            putExtra(GameActivity.EXTRA_GAME_URL, game.link)
            putExtra(GameActivity.EXTRA_GAME_NAME, game.name)
            putExtra(GameActivity.EXTRA_IS_LANDSCAPE, game.isLandscape())
        }
        startActivity(intent)
    }
}
