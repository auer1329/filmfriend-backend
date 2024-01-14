# filmfriend
Application that catalogues available filmstock. It allows users to keep track of which films could be on the market, which film is loaded in which camera and when a roll that was submitted for development can be picked up.

Deployed on [render.com](https://filmfriend-frontend.onrender.com).
Loading the site for the first time after a while may take longer than usual.

[Frontend Repository](https://github.com/ZieglerAaron/filmfriend-frontend/)

## API
The project uses REST API [filmindexapi-v2](https://github.com/jordanwhunter/filmdexapi-v2).
Uncomment the '@EventListener(ApplicationReadyEvent.class)' in StockService to update the database. Note that this may lead to redundant filmstock-datasets.
