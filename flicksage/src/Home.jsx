    // src/Home.jsx

    import React, { useState, useEffect } from 'react';
    import axios from 'axios';
    import GenreSelector from './components/GenreSelector';
    import MovieList from './components/MovieList';

    const Home = () => {
    const [genres, setGenres] = useState([]);
    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(false);
    const API_KEY = import.meta.env.VITE_API_KEY;

    useEffect(() => {
        fetchGenres();
        fetchMovies();
    }, []);

    const fetchGenres = async () => {
        try {
        const res = await axios.get(
            `https://api.themoviedb.org/3/genre/movie/list?api_key=${API_KEY}`
        );
        setGenres(res.data.genres);
        } catch (err) {
        console.error('Error fetching genres:', err);
        }
    };

    const fetchMovies = async (genreId = '') => {
        setLoading(true);
        try {
        const res = await axios.get(
            `https://api.themoviedb.org/3/discover/movie?api_key=${API_KEY}&with_genres=${genreId}`
        );
        setMovies(res.data.results);
        } catch (err) {
        console.error('Error fetching movies:', err);
        }
        setLoading(false);
    };

    return (
        <div className="container">
        <h1>FlickSage 🎬</h1>
        <GenreSelector genres={genres} onGenreSelect={fetchMovies} />
        {loading ? <div className="spinner"></div> : <MovieList movies={movies} />}
        </div>
    );
    };

    export default Home;
