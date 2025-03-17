    // src/components/MovieModal.jsx

    import React, { useEffect, useState } from 'react';
    import axios from 'axios';

    const MovieModal = ({ movie, onClose }) => {
    const [trailerKey, setTrailerKey] = useState('');

    useEffect(() => {
        const fetchTrailer = async () => {
        const API_KEY = import.meta.env.VITE_API_KEY;
        try {
            const res = await axios.get(
            `https://api.themoviedb.org/3/movie/${movie.id}/videos?api_key=${API_KEY}`
            );
            const trailer = res.data.results.find((vid) => vid.type === 'Trailer');
            setTrailerKey(trailer ? trailer.key : '');
        } catch (err) {
            console.error('Error fetching trailer:', err);
        }
        };

        fetchTrailer();
    }, [movie.id]);

    return (
        <div className="modal-overlay" onClick={onClose}>
        <div className="modal-content" onClick={(e) => e.stopPropagation()}>
            <h2>{movie.title}</h2>
            <p><strong>Summary:</strong> {movie.overview || 'No summary available.'}</p>
            {trailerKey ? (
            <iframe
                width="100%"
                height="400"
                src={`https://www.youtube.com/embed/${trailerKey}`}
                title="Movie Trailer"
                allowFullScreen
            ></iframe>
            ) : (
            <p>Trailer not available.</p>
            )}
            <button onClick={onClose}>Close</button>
        </div>
        </div>
    );
    };

    export default MovieModal;
