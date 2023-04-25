# An explanation of my solutions.

## Context
- This project introduced me to Java as a language. I spent the first few days learning the language, and every thing else related.
- Due to time constraints, I did not write any tests.

## Work Done

### List workers (paginated) endpoint
Implemented an endpoint to retrieve workers from database, paginated.

### Start worker and stop woker endpoints
Implemented two endpoints, one to start and the other to stop containers.


### Design Considerations
#### Source: start-stop-worker branch
- Revisited the endpoint to list workers.
#### Notes
The task does not include writing an endpoint to create workers. I assume another mechanism exists to create workers. This mechechanism also does not update my database. Hence, I need to provide a way to update the database.
- An ideal process would be a background process that uses the java-docker library to retrive a list of containers at intervals. For each container in the list, if the container is not in the database, then update the database.
- The much slower method I was exploring was to adjust the list endpoint so that it performs the check and updates the database each time, before returning the result.


Implementing a one-to-one relationship between each worker and the ports table was a challenge.