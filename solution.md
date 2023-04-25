# An explanation of my solutions.

## Context
This project introduced me to Java as a language. I spent the first few days learning the language, and every thing else related.
NB: The time provided is not enought for me to learn how to write tests

## Work Done

### List workers (paginated) endpoint
- Changed the repository fron CrudRepository to JpaRepository
- Install the dependencies in the build.gradle file (lines 41 to 43)
- Database migration in the table-schema.xml file
- Updated worker model, created worker service and updated worker controller

### Start and stop worker endpoint
- Setup Docker config