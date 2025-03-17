    // src/components/MovieList.jsx

    import React, { useState } from 'react';
    import MovieModal from './MovieModal';

    const MovieList = ({ movies }) => {
    const [selectedMovie, setSelectedMovie] = useState(null);

    return (
        <div className="movie-grid">
        {movies.map((movie) => (
            <div
            key={movie.id}
            className="movie-card"
            onClick={() => setSelectedMovie(movie)}
            >
            <img
                src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`}
                alt={movie.title}
            />
            <h3>{movie.title}</h3>
            </div>
        ))}
        {selectedMovie && (
            <MovieModal movie={selectedMovie} onClose={() => setSelectedMovie(null)} />
        )}
        </div>
    );
    };

    export default MovieList;
