package io.example.movie.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.example.movie.core.Constants.Companion.MOVIE_TABLE
import io.example.movie.data.dao.MovieDao
import io.example.movie.data.network.MovieDb
import io.example.movie.data.repository.MovieRepositoryImpl
import io.example.movie.domain.repository.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideMovieDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        MovieDb::class.java,
        MOVIE_TABLE
    )
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                db.execSQL(
                    "INSERT INTO $MOVIE_TABLE (title, studio, image, rating) VALUES" +
                            "('The Adventure Begins', 'DreamWorks', 'https://media-cache.cinematerial.com/p/500x/mv1xlzu6/remo-williams-the-adventure-begins-japanese-movie-poster.jpg?v=1594789210', 4.5)," +
                            "('Echoes of Eternity', 'Paramount Pictures', 'https://static.wikia.nocookie.net/primaltv/images/e/eb/Echoes_Of_Eternity.png/revision/latest/scale-to-width-down/1200?cb=20220919055352', 4.2)," +
                            "('Infinite Horizon', 'Universal Pictures', 'https://i.pinimg.com/474x/42/ce/c5/42cec5ef737cffe57a00dcd4040c45b8.jpg', 4.8)," +
                            "('Whispers in the Dark', 'Warner Bros.', 'https://www.janellesnollywooddiary.com/wp-content/uploads/2020/07/light-in-the-dark-1.jpg', 3.9)," +
                            "('Midnight Serenade', '20th Century Studios', 'https://m.media-amazon.com/images/M/MV5BZTAxMTg4NDAtZmVhYS00NGJhLTgyMGQtZjE3YjcyYmI4ZjMxL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMzYyNzgzMzI@._V1_.jpg', 4.1)," +
                            "('Mystic Shadows', 'Columbia Pictures', 'https://musicart.xboxlive.com/7/14f05100-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080', 4.4)," +
                            "('Eternal Sunshine', 'Sony Pictures', 'https://upload.wikimedia.org/wikipedia/en/5/53/Eternal_sunshine_CD_cover.jpg', 4.6)," +
                            "('Rising Phoenix', 'MGM Studios', 'https://m.media-amazon.com/images/M/MV5BYmM4YjU4YWEtZTE3ZS00ZWZhLWFhZDgtOTcwMmJjZWRkOTljXkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_.jpg', 3.7)," +
                            "('Frozen Dreams', 'Disney Studios', 'https://www.picclickimg.com/bVgAAOSw-C9k5KuK/Winter-Of-Frozen-Dreams-DVD-2009-Region-4.webp', 4.9)," +
                            "('Lost in Time', 'Lionsgate', 'https://m.media-amazon.com/images/M/MV5BMjA5NzE0MDkwM15BMl5BanBnXkFtZTgwNzE0MDg0NzE@._V1_FMjpg_UX1000_.jpg', 4.0)," +
                            "('Whirlwind Romance', 'Focus Features', 'https://m.media-amazon.com/images/M/MV5BNzQ5N2QwOTYtZWE0OC00MTIyLTg2YjEtMzI5OWVkODdkZTE2XkEyXkFqcGdeQXVyMzUwODAyOA@@._V1_.jpg', 4.3)," +
                            "('Silent Echo', 'Miramax Films', 'https://m.media-amazon.com/images/M/MV5BZmRjNTlhZTQtZGY0Zi00ODJhLWJkNDItMDAyODE1NDhkMmQyXkEyXkFqcGdeQXVyMTUwNTQ1NTAy._V1_FMjpg_UX1000_.jpg', 4.7)," +
                            "('Rogue Wave', 'Fox Searchlight Pictures', 'https://i.ytimg.com/vi/maqfTK8ZvJs/maxresdefault.jpg', 3.5)," +
                            "('Shattered Illusions', 'A24', 'https://preview.redd.it/so-i-tweaked-a-fake-movie-poster-of-him-v0-57g81q3blmgb1.jpg?width=640&crop=smart&auto=webp&s=1d2d15c3db202a97324a3c631dd285112dab962e', 4.2)," +
                            "('Crimson Horizon', 'New Line Cinema', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTW7eqdGw_bND5g3-7ys-sgT5--GSAOdcrBL2Wjj01isCkwuhxhRfUlMByzGIIJjmfRg6s&usqp=CAU', 3.8)," +
                            "('Lost in Translation', 'Studio Ghibli', 'https://upload.wikimedia.org/wikipedia/en/4/4c/Lost_in_Translation_poster.jpg', 4.9)," +
                            "('Whispering Pines', 'Orion Pictures', 'https://upload.wikimedia.org/wikipedia/en/a/ac/Riders_of_the_Whistling_Pines_Poster.jpg', 4.1)," +
                            "('Starlight Serenade', 'DreamWorks', 'https://www.imdb.com/title/tt0221579/mediaviewer/rm1739556097/?ref_=tt_ov_i', 4.6)," +
                            "('Epic Journeys', 'Paramount Pictures', 'https://m.media-amazon.com/images/I/81zfw8ozhrL._SL1500_.jpg', 4.3)," +
                            "('Timeless Love', 'Universal Pictures', 'https://www.imdb.com/title/tt9702698/mediaviewer/rm4220608768/?ref_=tt_ov_i', 4.7)," +
                            "('Enchanted Gardens', 'Warner Bros.', 'https://upload.wikimedia.org/wikipedia/en/d/d1/Enchanted_gardentv5.jpg', 4.0)," +
                            "('Ocean of Dreams', '20th Century Studios', 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.imdb.com%2Ftitle%2Ftt0367567%2F&psig=AOvVaw37qgEfyaxDXgVKRzsttz_J&ust=1701064797007000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIj8wan-4IIDFQAAAAAdAAAAABAI', 4.5)," +
                            "('Beyond the Stars', 'Columbia Pictures', 'https://upload.wikimedia.org/wikipedia/en/f/fe/Beyond_the_Stars_DVD_cover.jpg', 4.8)," +
                            "('Golden Sands', 'Sony Pictures', 'https://www.imdb.com/title/tt6697138/mediaviewer/rm1430866432/?ref_=tt_ov_i', 4.2)," +
                            "('Celestial Harmony', 'MGM Studios', 'https://upload.wikimedia.org/wikipedia/commons/7/73/Harmonyoftheworld.jpg', 4.4)," +
                            "('Whispers of Destiny', 'Disney Studios', 'https://static.wikia.nocookie.net/sandman/images/0/0c/House_of_Whispers_cover.jpg/revision/latest/scale-to-width-down/1000?cb=20200820213929', 4.9)," +
                            "('City of Angels', 'Lionsgate', 'https://upload.wikimedia.org/wikipedia/en/e/e1/City_Of_Angels.jpg', 3.7)," +
                            "('Sapphire Skies', 'Focus Features', 'https://upload.wikimedia.org/wikipedia/en/3/36/Sapphire_Sky_bookcover.jpg', 4.5)," +
                            "('Lost Horizon', 'Miramax Films', 'https://www.imdb.com/title/tt0029162/mediaviewer/rm3129671936/?ref_=tt_ov_i', 4.3)," +
                            "('Sunset Dreams', 'Warner Bros', 'https://www.imdb.com/title/tt6153250/mediaviewer/rm359290880/?ref_=tt_ov_i', 4.7);"
                )
            }
        }).build()

    @Provides
    fun provideMovieDao(
        movieDb: MovieDb
    ) = movieDb.movieDao

    @Provides
    fun provideBookRepository(
        movieDao: MovieDao
    ): MovieRepository = MovieRepositoryImpl(
        movieDao = movieDao
    )
}