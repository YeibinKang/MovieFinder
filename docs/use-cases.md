# Movie Application Use Cases

## Table of Contents
- [UC-1: User Accesses Main Page](#uc-1-user-accesses-main-page)
- [UC-2: Movie Details View](#uc-2-movie-details-view)
- [UC-3: Search Movies by Title Keyword](#uc-3-search-movies-by-title-keyword)

## UC-1: User Accesses Main Page

### Primary Actor
- User

### Scope
- Movie Display System

### Level
- User Goal

### Main Success Scenario
1. User navigates to the home page
2. System displays a list of now-playing movies
3. User scrolls through the movie list
4. User selects a movie to view its details

### Alternative Flows
1. No movies are currently playing
  - System displays error message indicating no movies available
  - System provides option to return to home page
2. Loading fails
  - System displays error message
  - System shows customer service contact information

### Technical Requirements
- Endpoint: `GET /movies/now-playing`
- Authentication: Not required
- Response includes:
  - Movie list (title, poster, release date, etc.)
  - Total count of movies
  - Pagination information

### Preconditions
1. TMDB API connection is active
2. Movie data is synced with TMDB

### Post-conditions
1. Now playing movies are displayed to user
2. User can interact with displayed movies
3. Movies are properly sorted by release date

### Business Rules
1. Data Display
  - Movies should be sorted by release date (newest first)
  - Adult content must be filtered out by default
2. Error Handling
  - Retry TMDB API calls up to 3 times
  - Cache failed requests for 5 minutes

<br>

## UC-2: Movie Details View

### Primary Actor

- User

### Scope

- Movie Display System

### Level

- User Goal

### Main Success Scenario

1. User clicks a movie from the now-playing movie list
2. System retrieves detailed movie information using TMDB ID
3. System displays comprehensive movie details
4. User views movie information
5. System validates TMDB ID
6. User can add movie to their watchlist (if authenticated)

### Alternative Flows

1. Movie Details Unavailable
    - System displays error message indicating movie information is not available
    - System provides option to return to movie list
2. Loading Failure
    - System displays error message
    - System shows customer service contact information

### Technical Requirements

- Endpoint: `GET /movies/{tmdbId}`
- Authentication: Not required (except for watchlist operations)
- Response includes:
    - Movie details (title, overview, release date, etc.)
    - Rating and review statistics
    - Watchlist status (if user is authenticated)

### Preconditions

1. TMDB API connection is active
2. Movie exists in TMDB database
3. Now-playing movies list is accessible
4. User must be authenticated for watchlist operations

### Post-conditions

1. Movie details are displayed to user
2. If movie added to watchlist:
    - Movie appears in user's watchlist
    - System displays success confirmation
    - Watchlist count is updated
    - Watchlist database is updated
    - User's watchlist is refreshed on My page

### Business Rules

1. Watchlist Management
    - Maximum 100 movies per watchlist
    - Duplicate movies not allowed in watchlist
2. Data Display
    - Release dates shown in user's local timezone
    - Adult content requires age verification
3. Error Handling
    - Retry TMDB API calls up to 3 times
  
<br>

## UC-3: Search Movies by Title Keyword

### Primary Actor

- User

### Scope

- Movie Display System

### Level

- User Goal

### Main Success Scenario

1. User fills a search bar with a keyword
2. User clicks ‘Search’ button
3. System validates search keyword
4. System retrieves a list of movies which contain the keyword
5. System displays the movie list with information
6. User views the movie list

### Alternative Flows

1. Movie with keyword Unavailable
    - System displays ‘Movie with ‘keyword’ not found’ message
2. Invalid keyword format or input
    - System shows ‘warning or suggested keyword’ message
3. Loading Failure
    - System displays error message
    - System shows customer service contact information

### Technical Requirements

- Endpoint: `GET /movies/search`
- Authentication: Not required (except for watchlist operations)
- Response includes:
    - Movie list with keyword
    - Movie details (title, overview, release date, etc.)
    - Rating and review statistics
    - Watchlist status (if user is authenticated)

### Preconditions

1. TMDB API connection is active

### Post-conditions

1. Search results are displayed to user

### Business Rules

1. Data Display
    - Release dates shown in user's local timezone
    - Adult content requires age verification
2. Error Handling
    - Retry TMDB API calls up to 3 times
