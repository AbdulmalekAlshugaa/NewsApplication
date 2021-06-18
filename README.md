#  Project Overview 
The developed application is an application with the aim to display a list of news where the user can able to view the tile of  the news as well as . The user can able to filter the news peroid such as 1 day , 7 days and 30 days options. In addition, the developer will consume one of the popular news API which will be attached later to this documentation.
 ## Main Features
1. Java
2. MVVM
3. Retrofit2
4. RXJava
5. Single Activity Architecture
6. LiveData 
7. View Binding 
8. WebViews
9. Singletons

 ## Assumptions 
The user will be able to list all the movies and has the ability to filter movies based on his/her needs. In addition, the user will be able to book any movie through a web view on the developed application. 
## Product Requirements 
1. Design and implement a movie an Android application using either Java or Kotlin 
2. consume a movie API using a Retrofit networking library
3. Integrate a Reactive library such as RxJava  
4. use a design pattern (Android Architecture ) which will use an MVVM design pattern
6. Use View Data Binding in order to increase readability and avoiding using normal referencing features such as `findViewById` 
7. Test and debug code and ensure the developed code is readable, maintainable, and easy to understand   
  
## Design and architecture 
### flowchart of the application :

| search |Filtering news 
| ----------- | ----------- 
| ![listMovies](https://user-images.githubusercontent.com/33663456/117691887-fa069400-b1ee-11eb-8f5a-b8ca2f4aa09e.PNG) | ![filterMovies](https://user-images.githubusercontent.com/33663456/117691982-1b678000-b1ef-11eb-8546-ff16ceee24e9.PNG)

The above table shows the main three functions of the application which are listing movies, filtering movies, and Movie Details. In addition, the developer should meet these requirements in order to deliver a fully functional application.
### Sequence diagram :

### Design application architecture (MVVM)
| MVVM diagram |
| ----------- |
|![Capture](https://user-images.githubusercontent.com/33663456/122086927-c561aa00-ce36-11eb-9758-472c7e99c91a.PNG)

The application will be developed using MVVM architecture
#### Activity Diagram will be used for the following activity and fragments
1. Main Activity 
2. Discover Fragment 
3. popluar news
 #### View Model And Live Data
1. popular ViewModel
2. Article ViewModel
#### Repository
1. App Repository
 #### Repository
1. Remote Data Source which is the API https://developer.nytimes.com/

### implementation 
| Main Fragment |Movie Details |Search Articles |
| ----------- | ----------- | ----------- |
| ![Capture](https://user-images.githubusercontent.com/33663456/122086588-6bf97b00-ce36-11eb-8261-31a627fc54bc.PNG)| ![Capture1](https://user-images.githubusercontent.com/33663456/122086626-761b7980-ce36-11eb-9c55-32001c12d90f.PNG)|![Capture3](https://user-images.githubusercontent.com/33663456/122086635-7a479700-ce36-11eb-8598-845414b43434.PNG)|

## Testing  
## unit testing 
The develoepr has tested only  two major functions which are get list of movies as well as get movie by ID 
### implementation 
| Listing News (Unit Testing) |Searching News (Unit testing) |
| ----------- | ----------- |
| ![getAllMoviews](https://user-images.githubusercontent.com/33663456/122535170-e0f6cb80-d055-11eb-9c30-0c8db852768a.PNG)|![searchApi](https://user-images.githubusercontent.com/33663456/122535217-ebb16080-d055-11eb-8a1f-ee1f5c0a88d6.PNG)
|
## Running this app
To run this app you will need to have an Android device or emulator that supports Android version 6 onward. The device should have an internet connection. 
