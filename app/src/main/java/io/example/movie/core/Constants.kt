package io.example.movie.core

class Constants {
    companion object {
        //Room
        const val MOVIE_TABLE = "movie_table"

        //Screens
        const val MOVIES_SCREEN = "Movies"
        const val UPDATE_MOVIE_SCREEN = "Update Movie"

        //Arguments
        const val MOVIE_ID = "movieId"

        //Actions
        const val ADD_MOVIE = "Add a movie."
        const val DELETE_MOVIE = "Delete a movie."

        //Buttons
        const val ADD_BUTTON = "Add"
        const val DISMISS_BUTTON = "Dismiss"
        const val UPDATE_BUTTON = "Update"

        //Placeholders
        const val MOVIE_TITLE = "Type a movie title..."
        const val STUDIO = "Type the studio name..."
        const val DESCRIPTION = "Description about the movie..."
        const val EMPTY_STRING = ""
        const val DEFAULT_IMG = "https://images.unsplash.com/photo-1616530940355-351fabd9524b?q=80&w=3024&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    }
}