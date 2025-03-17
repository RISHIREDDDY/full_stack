    // src/components/GenreSelector.jsx

    import React from 'react';

    const GenreSelector = ({ genres, onGenreSelect }) => {
    return (
        <div className="genre-selector">
        <button onClick={() => onGenreSelect('')}>All</button>
        {genres.map((genre) => (
            <button key={genre.id} onClick={() => onGenreSelect(genre.id)}>
            {genre.name}
            </button>
        ))}
        </div>
    );
    };

    export default GenreSelector;
